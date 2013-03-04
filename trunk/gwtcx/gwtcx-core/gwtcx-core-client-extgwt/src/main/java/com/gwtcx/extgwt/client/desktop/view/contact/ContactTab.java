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
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.extgwt.client.desktop.view.EntityTab;
import com.gwtcx.extgwt.client.desktop.view.contact.section.AddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.section.NameAndElectronicAddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.section.ProfessionalInformationSection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;

public class ContactTab extends EntityTab<ContactRepresentation> {

  private EntitySection<ContactRepresentation> [] entitySections = null;

  public ContactTab(TabPanel tabPanel) {
    super(tabPanel);
  }

  @SuppressWarnings("unchecked")
  protected void createFieldSets(String tabLabel) {

    VerticalLayoutContainer layout = new VerticalLayoutContainer();
    FieldSet fieldSet = null;
    HtmlLayoutContainer htmlLayout = null;

    layout.setSize(AbstractTabbedFormDesktopView.CONTEXT_AREA_WIDTH, AbstractTabbedFormDesktopView.CONTEXT_AREA_HEIGHT);
    layout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

    Log.debug("createFieldSets()");

    if (getFieldSets() == null) {
      Log.error("You must call setFields(String[][] fields) in the constructor of your derived class");
      return;
    }

    entitySections = new EntitySection[getNumberOfRows()];

    Log.debug("NumberOfRows: " + getNumberOfRows());

    for (int row = 0; row < getNumberOfRows(); row++) {

      fieldSet = new FieldSet();
      fieldSet.setHeadingText(getFieldSets()[row][FIELD_SET_LABEL]);
      fieldSet.setCollapsible(true);

      htmlLayout = getFieldSetHtmlLayout(getFieldSets()[row][FIELD_SET_LABEL]);
      htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      entitySections[row] = getFieldSetSection(getFieldSets()[row][FIELD_SET_LABEL], htmlLayout);

      fieldSet.add(htmlLayout);
      layout.add(fieldSet, new VerticalLayoutData(1, -1));
    }

    getTabPanel().add(layout, tabLabel);
  }

  enum Section
  {
     GENERAL_INFORMATION("General Information"),
     ADDRESS_INFORMATION("Address Information"),
     // PERSONAL_INFORMATION("Personal Information"),
     PROFESSIONAL_INFORMATION("Professional Information"),
     NOT_USED("notUsed");

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

      case GENERAL_INFORMATION: result = new NameAndElectronicAddressSection(htmlLayout); break;

      case ADDRESS_INFORMATION: result = new AddressSection(htmlLayout); break;

      // case PERSONAL_INFORMATION: result = new PersonalInformationSection(htmlLayout); break;

      case PROFESSIONAL_INFORMATION: result = new ProfessionalInformationSection(htmlLayout); break;

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

      case PROFESSIONAL_INFORMATION: result = new HtmlLayoutContainer(getProfessionalInformationHtmlLayout()); break;

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

  private static native String getProfessionalInformationHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td class=department width=50%></td><td class=role width=50%></td></tr>',
      '<tr><td class=manager></td><td class=assistent></td></tr>',
      '<tr><td class=managerPhone></td><td class=assistentPhone></td></tr>',
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

    Log.debug("getFields()");

  }

  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    for (int row = 0; row < getNumberOfRows(); row++) {
      entitySections[row].setFields(dto);
    }
  }
}
