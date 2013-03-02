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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormDesktopView;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;

public class ContactInformationGeneralInformationTab extends EntityTab<ContactRepresentation> {

  private TabPanel tabPanel;

  public ContactInformationGeneralInformationTab() {

    Log.debug("ContactInformationGeneralInformationTab()");

    this.tabPanel = null;
  }

  public ContactInformationGeneralInformationTab(TabPanel tabPanel) {
    this();

    Log.debug("ContactInformationGeneralInformationTab(TabPanel tabPanel)");

    setTabPanel(tabPanel);
  }

  public void setTabPanel(TabPanel tabPanel) {

    this.tabPanel = tabPanel;

    if (this.tabPanel != null) {

      VerticalLayoutContainer layout = new VerticalLayoutContainer();

      layout.setSize(AbstractTabbedFormDesktopView.CONTEXT_AREA_WIDTH, AbstractTabbedFormDesktopView.CONTEXT_AREA_HEIGHT);
      layout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      createFieldSets(layout);

      this.tabPanel.add(layout, "General");
    }
  }

  private final static int FIELD_SET_LABEL = 0;

  private String[][] fieldSets = {
    {"General Information"},
    {"Address Information"}
  };

  // numberOfFieldSets == number of sections (for now)

  private int numberOfFieldSets = fieldSets.length;
  @SuppressWarnings("unchecked")
  private EntitySection<ContactRepresentation> [] entitySections = new EntitySection[numberOfFieldSets];

  protected void createFieldSets(VerticalLayoutContainer layoutContainer) {

    FieldSet fieldSet = null;
    HtmlLayoutContainer htmlLayout = null;

    Log.debug("createFieldSets()");

    Log.debug("numberOfFieldSets: " + numberOfFieldSets);

    for (int row = 0; row < numberOfFieldSets; row++) {

      fieldSet = new FieldSet();
      fieldSet.setHeadingText(fieldSets[row][FIELD_SET_LABEL]);
      fieldSet.setCollapsible(true);

      htmlLayout = getFieldSetHtmlLayout(fieldSets[row][FIELD_SET_LABEL]);
      htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      entitySections[row] = getFieldSetSection(fieldSets[row][FIELD_SET_LABEL], htmlLayout);

      fieldSet.add(htmlLayout);
      layoutContainer.add(fieldSet, new VerticalLayoutData(1, -1));
    }
  }

  enum Section
  {
     GENERAL_INFORMATION("General Information"), ADDRESS_INFORMATION("Address Information"), NOT_USED("notUsed");

     private Section(String stringValue) { this.stringValue = stringValue; }
     public String toString() { return stringValue; }

     private String stringValue;
  }


  public Section getSectionAsEnum(String sectionName) {

    Section result = Section.NOT_USED;

    for (Section section : Section.values()) {
      if (sectionName.contentEquals(section.toString())) {
        result = section;
      }
    }

    return result;
  }

  // numberOfFieldSets == number of sections (for now)

  public EntitySection<ContactRepresentation> getFieldSetSection(String sectionName, HtmlLayoutContainer htmlLayout) {

    EntitySection<ContactRepresentation> result = null;
    Section section = getSectionAsEnum(sectionName);

    Log.debug("getFieldSetSection()");

    switch (section) {

      case GENERAL_INFORMATION: result = new ContactInformationNameSection(htmlLayout); break;

      case ADDRESS_INFORMATION: result = new ContactInformationAddressSection(htmlLayout); break;

      default:
        result = null;
        break;
    }

    return result;
  }

  public HtmlLayoutContainer getFieldSetHtmlLayout(String sectionName) {

    HtmlLayoutContainer result = null;
    Section section = getSectionAsEnum(sectionName);

    Log.debug("getFieldSetHtmlLayout()");

    switch (section) {

      case GENERAL_INFORMATION: result = new HtmlLayoutContainer(getGeneralInformationHtmlLayout()); break;

      case ADDRESS_INFORMATION: result = new HtmlLayoutContainer(getAddressInformationHtmlLayout()); break;

      default:
        result = new HtmlLayoutContainer(getDefaultFieldSetHtmlLayout());
        break;
    }

    return result;
  }

  // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
  // In order to fix this, you will need to explicitly set these widgets width and height to 100%.

  private static native String getGeneralInformationHtmlLayout() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>',
         '<tr><td class=parentCustomer></td><td class=email></td></tr>',
        '</table>'
    ].join("");
  }-*/;

  private static native String getAddressInformationHtmlLayout() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=addressName width=50%></td><td class=postalCode width=50%></td></tr>',
        '<tr><td class=addressLine1></td><td class=country></td></tr>',
        '<tr><td class=addressLine2></td><td class=addressType></td></tr>',
        '<tr><td class=addressLine3></td><td></td></tr>',
        '<tr><td class=city></td><td></td></tr>',
        '<tr><td class=state></td><td></td></tr>',
        '</table>',
    ].join("");
  }-*/;

  private static native String getDefaultFieldSetHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td></td><td></td></tr>',
      '<tr><td></td><td></td></tr>',
      '</table>',
  ].join("");
  }-*/;

  public void getFields(ContactRepresentation dto) {

  }

  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    for (int row = 0; row < numberOfFieldSets; row++) {
      entitySections[row].setFields(dto);
    }

  }
}

/*

    // vLayout.setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

*/

/*

The values for HorizontalLayoutData and VerticalLayoutData have different meanings depending on which range they are in:

- If -1, then the item is measured, and given the space it has requested - useful for fields or labels
- If greater than 1, a pixel value is assigned - you've noticed this in using 100, which draws as 100px wide
- If greater than 0, and less than or equal to 1, then it will be assigned a percentage of the remaining size after the
  first two items listed have been calculated. The value 1 is 100%, and .25 would be 25% of the remaining space.

*/