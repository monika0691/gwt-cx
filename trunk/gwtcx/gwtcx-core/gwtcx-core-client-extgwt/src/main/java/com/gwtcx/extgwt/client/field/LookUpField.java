/**
 * (C) Copyright 2010-2013 Kiahu
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.extgwt.client.field;

import com.allen_sauer.gwt.log.client.Log;
// import com.google.gwt.core.client.JavaScriptObject;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent;
import com.sencha.gxt.widget.core.client.form.TriggerField;

public class LookupField extends TriggerField<String> {

  public LookupField() {
    this(new LookUpFieldPropertyEditor());

    Log.debug("LookUpField()");
  }

  public LookupField(StringCell cell) {
    this(cell, new LookUpFieldPropertyEditor());

    Log.debug("LookUpField(DateCell cell)");
  }

  public LookupField(StringCell cell, LookUpFieldPropertyEditor propertyEditor) {
    super(cell);
    setPropertyEditor(propertyEditor);
    redraw();

    Log.debug("LookUpField(DateCell cell, DateTimePropertyEditor propertyEditor)");
  }

  public LookupField(LookUpFieldPropertyEditor propertyEditor) {
    this(new StringCell(), propertyEditor);

    Log.debug("(DateTimePropertyEditor propertyEditor)");
  }

  @Override
  public StringCell getCell() {

    Log.debug("getCell()");

    return (StringCell) super.getCell();
  }

  @Override
  public LookUpFieldPropertyEditor getPropertyEditor() {

    Log.debug("getPropertyEditor()");

    return (LookUpFieldPropertyEditor) super.getPropertyEditor();
  }

  @Override
  protected void onCellParseError(ParseErrorEvent event) {
    super.onCellParseError(event);

    Log.debug("onCellParseError()");

  }
}


// http://www.sencha.com/blog/ext-gwt-3-appearance-design/
// http://www.sencha.com/forum/showthread.php?238477-Appearance-Design-Pattern-Implementation-Inconsistencies&s=274d3a1a8a5a0d1f6c96c320ef2d063e
// https://code.google.com/p/google-web-toolkit/wiki/CellBackedWIdgets#Appearance_Pattern

//See: com\sencha\gxt\theme\base\Base.gwt.xml

// <replace-with class="com.sencha.gxt.theme.base.client.field.DateCellDefaultAppearance">
//   <when-type-is class="com.sencha.gxt.cell.core.client.form.DateCell.DateCellAppearance" />
// </replace-with>

/*

Thanks for your feedback on how we've elected to deal with appearances in GXT 3
- I'm going to try to address your main points by describing the primary design
goals and non-goals, and implementation details that we've elected to follow.

Certainly, we haven't been totally consistent, but I think that we've hit most
of the ideas correctly.

First, some technical pieces - these'll come in handy later:
Singletons - these are usually considered helpful in cases where either a) state
must be shared, or b) allocation is expensive. The former is true in a few places
(CommonStyles, Mask, etc), but elsewhere it must be possible to create a component
or cell with a specific implementation, different from the rest of the app.

GWT.create - this is slightly magic, but in the end is the same as 'new'. This
breaks down to the following - look for <replace-with> or <generate-with> rules
in the modules currently used - if any rule applies, invoke the provided type's
default constructor. Otherwise, try to invoke the type passed into the GWT.create
method with new. This means there is no flyweight/singleton thing going on there
at all - new instances will be created (more on this in a bit) each time GWT.create
is invoked...

GWT's optimizing compiler - two interesting and applicable things that happen
here are to a) mark all possible types, methods, fields, and variables as final,
and b) any final method that is found can now be rewritten as a static method.
This has immediate two advantages - call sites can be rewritten as if there was
no appearance instance, and the keyword 'this' isn't necessary within the method
itself, both of which make for smaller code. Next, if the method itself doesn't
actually use fields or polymorphic methods, the 'this' argument might be possible
to drop. Especially where appearances are stateless or where there is only one
implementation of a given appearance interface, this means that GWT.create
effectively creates a singleton, except without the instance itself, so even
cheaper than a singleton.

ClientBundle - this is the most expensive part of creating an appearance instance,
since there is CSS that must be injected into the page. That being said, adding
the styles to the page is only costly the first time it is called (see
CssResource.ensureInjected), every subsequent time, it has no effect.

Okay, appearances themselves have several main goals:
- easily maintainable,
- efficient rendering,
- usable in both Components and Cells, and
- small compiled output

Some non-goals:
- external css and images (though a specific set of appearance implementations
 could achieve this)
- API to allow code external to the cell/component to modify the rendered internals

Maintenance:
Any component which also has a similar cell always delegates to that cell so there
are sure to render in the same way. To that end, we have two basic ways to select
a new appearance from the defaults in GXT:
- use an alternate constructor, which accepts an appearance instance
- add a <replace-with> rule for a different appearance implementation or an
 <inherits> statement for a theme (module with many replace-with rules for
 specific appearances)

The first allows specific instances to be modified, and the second for the entire
application to be rethemed in a single stroke. If singletons were used for some
appearances like ContentPanel, it would only ever be possible to draw ContentPanels
in one way in an application. As such, singletons are only used in specific cases
where it only ever makes sense to have one instance - global details like
CommonStyles, ThemeStyles, and necessarily consistent ones like DnD details or
component masks.

Many of the provided appearance implementations also allow for optional constructor
arguments, making it easier to easily subclass them and provide different styles
or html structures. Of course it is still possible to provide a completely new
implementation of the appearance interface, but this isn't required.

One last point here, regarding the first non-goal: Many developers prefer to have
one giant css file for all possible 'overrides' - styles that should be replaced
at runtime for application-specific reasons. GXT (via ClientBundle/CssResource)
deliberately does not make this easy to do, as while it makes for quick and easy
fixes, it increases the amount of CSS the browser must parse on page load and on
any change to the dom, and almost always results in useless CSS rules, since the
old rule now being overridden still exists somewhere. Using CssResource and the
@Source annotation makes it clear to the compiler and the browser which styles
will be used, and gives the compiler a chance to remove unused code.

Efficient Rendering:
Most appearances are used directly by a Cell, and then indirectly by a Component,
so being able to render to a SafeHtmlBuilder is important. For the remaining cases,
it is almost always more efficient (according to current benchmarks) to build up
html strings an to pass the entire string at once into element.setInnerHtml.

As a result of these guidelines, all appearances are expected to either produce a
SafeHtml instance, or to know how to render themselves into an existing SafeHtmlBuilder.

As mentioned in the maintenance section, CSS that is never loaded is the fastest,
so it is a goal to keep the active amount of CSS in the browser to a minimum.
ClientBundle/CssResource has a number of details already in place to make this
work, so the GXT provided appearances always make use of this.

Usable in both Components and Cells:
As mentioned above, the appearance APIs should in general be html-driven when
rendering content, but may accept Element (or XElement) instances when working
with already rendered content and events. This requirement has other interesting
impacts on maintenance - appearances should focus on rendering and updating the
ui, cells on managing DOM events, and components on high level logic (such as can
be handled only when there is exactly one rendered instance of a cell).

Small compiled output:
By using specific classes and referencing those types either in <replace-with>
rules or explicitly invoking them, we are making it clear to the compiler which
appearances, html strings, and styles (css and images) will be required.

By being this explicit, we can be fairly certain that the compiler will remove
all unused appearance code - if you add a replace-with rule for all
TriggerFieldAppearances, you can be certain that GXT's own implementations will
never touch your users' browsers.

Specifically looking at the CommonStyles and ThemeStyles example you mentioned,
there appears to be a good reason that the CommonStyles appearance instance isn't
exposed - the only useful method it provides is access to the styles. The shim()
method shouldn't have been made accessible in that way - it is only needed to
make the CommonDefaultStyles css resource work correctly. ThemeStyles exposes
the appearance itself to provide access to the one other method - the more icon,
which was intended to be needed by more than widget so must be available in a
shared manner (but is only used in one place, so doesn't make a ton of sense).

There are definitly some inconsistencies in appearances that need to be addressed,
but I'd tenatively suggest that between ClientBundle and the compiler itself, most
of your concerns are mitigated. Specific areas of improvement I see are mostly
API-related:
- Failure to keep appearance instances as private final fields, and to expose a
 type-safe getter for subclasses to know what methods they are guaranteed to
 have access to http://www.sencha.com/forum/showthread.php?236527
- Failure to rely on those getters internally, to allow subclassed
 cells/components to override the appearance implementations at will
- Insufficient appearance examples (somewhat mitigated by 3.0.1's Gray theme,
 as well as additional theming examples in the explorer)
- Possible performance issues in rendering appearances and updating after events
 have taken place. This mostly have to do with making appearances even faster
 by assuming that external code has no business re-structuring the dom of a
 given widget - by making this assumption, we can more efficiently look up
 elements by index instead of by class name, and can enable our widgets and
 cells to draw and update even faster.
- Lack of general documentation on appearances in general - this is why I try
 to make details forum posts when these questions come up, but we had initially
 had hopes that the pattern would be more wide-spread in GWT itself (instead of
 only in TextButton), and we could draw on those same resources and documents.

So yes, we have plans to try to be more clean and consistent, but I think so far
we've gotten things mostly right. I look forward to your thoughts on the ideas
I've posted above, and to any future ideas you might have to make this feature
in GXT 3 even clearer and easier to use.

*/
