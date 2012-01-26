/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
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

package com.gwtcx.client.resources;

import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * ImageCell
 */
public class ImageCell extends AbstractSafeHtmlCell<String> {

  public interface Template extends SafeHtmlTemplates {
    @Template("<div name=\"{0}\" style=\"{1}\">{2}</div>")
    SafeHtml cell(String name, SafeStyles styles, SafeHtml value);
  }

  protected static Template template = GWT.create(Template.class);

  protected static final SafeHtml PLACEHOLDER = makeImage(SalesIcons.INSTANCE.placeholder());

  public ImageCell() {
    super(SimpleSafeHtmlRenderer.getInstance());
    // super(SimpleSafeHtmlRenderer.getInstance(), "click", "keydown");
  }

  // public ImageCell(SafeHtmlRenderer<String> renderer) {
  //   super(renderer, "click", "keydown");
  // }

  @Override
  protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

    if (data == null) {
      return;
    }

    SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left; cursor:pointer;");

    SafeHtml rendered = template.cell("image-1", imageStyle, PLACEHOLDER);
    sb.append(rendered);
  }

  public static SafeHtml makeImage(ImageResource resource) {
    AbstractImagePrototype proto = AbstractImagePrototype.create(resource);
    return proto.getSafeHtml();
  }
}

/*



    // SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");
    // SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("width:48px; height:48px; float:left; cursor:pointer;");

    @Override
    public void onBrowserEvent(com.google.gwt.cell.client.Cell.Context context,
            Element parent, String value, NativeEvent event,
            com.google.gwt.cell.client.ValueUpdater<String> valueUpdater) {

        // Let AbstractCell handle the keydown event.
        super.onBrowserEvent(context, parent, value, event, valueUpdater);

        // Handle the click event.
        if ("click".equals(event.getType())) {

            // Ignore clicks that occur outside of the outermost element.
            EventTarget eventTarget = event.getEventTarget();

            if (parent.isOrHasChild(Element.as(eventTarget))) {
                // if (parent.getFirstChildElement().isOrHasChild(
                // Element.as(eventTarget))) {

                // use this to get the selected element!!
                Element el = Element.as(eventTarget);

                // check if we really click on the image
                if (el.getNodeName().equalsIgnoreCase("IMG")) {
                    doAction(el.getParentElement().getAttribute("name"),
                            valueUpdater);
                }

            }
        }

    };

    @Override
    protected void onEnterKeyDown(Context context, Element parent,
            String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
        doAction(value, valueUpdater);
    }

    private void doAction(String value, ValueUpdater<String> valueUpdater) {
        // Trigger a value updater. In this case, the value doesn't actually
        // change, but we use a ValueUpdater to let the app know that a value
        // was clicked.
        if (valueUpdater != null)
            valueUpdater.update(value);
    }


*/