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

package com.gwtcx.extgwt.client.desktop.view.contact.tab;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.resources.client.ImageResource;
import com.gwtcx.client.resources.ContactIcons;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormView;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.extgwt.client.desktop.view.EntityTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.AddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.ContactPreferencesSection;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.NameAndElectronicAddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.PersonalInformationSection;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.ProfessionalInformationSection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;

public abstract class AbstractContactTab extends EntityTab<ContactRepresentation> {

  public static final String generalTabIcon = "general";
  public static final String detailsTabIcon = "details";
  public static final String administrationTabIcon = "administration";
  public static final String notesTabIcon = "notes";

  private EntitySection<ContactRepresentation> [] entitySections = null;

  public AbstractContactTab(TabPanel tabPanel) {
    super(tabPanel);
  }

  protected void createFields(String label, String icon) {

    createFieldSets();

    if (icon.length() != 0) {

      TabItemConfig config = new TabItemConfig(label);
      config.setIcon(getTabIcon(icon));

      getTabPanel().add(getLayoutContainer(), config);

    } else {

      getTabPanel().add(getLayoutContainer(), label);
    }
  }

  protected ImageResource getTabIcon(String icon) {

    ImageResource image = null;

    if (generalTabIcon.equalsIgnoreCase(icon)) {
      image = ContactIcons.INSTANCE.generalTab();
    } else if (detailsTabIcon.equalsIgnoreCase(icon)) {
      image = ContactIcons.INSTANCE.administrationTab();
    } else if (administrationTabIcon.equalsIgnoreCase(icon)) {
      image = ContactIcons.INSTANCE.detailsTab();
    } else if (notesTabIcon.equalsIgnoreCase(icon)) {
      image = ContactIcons.INSTANCE.detailsTab();
    } else {
      image = PlaceholderIcons.INSTANCE.placeholder16x16();
    }

    return image;
  }

  /*

  The values for HorizontalLayoutData and VerticalLayoutData have different meanings depending on which range they are in:

  - If -1, then the item is measured, and given the space it has requested - useful for fields or labels
  - If greater than 1, a pixel value is assigned - you've noticed this in using 100, which draws as 100px wide
  - If greater than 0, and less than or equal to 1, then it will be assigned a percentage of the remaining size after the
    first two items listed have been calculated. The value 1 is 100%, and .25 would be 25% of the remaining space.

  */

  @SuppressWarnings("unchecked")
  protected void createFieldSets() {

    FieldSet fieldSet = null;
    HtmlLayoutContainer htmlLayout = null;

    getLayoutContainer().setSize(AbstractTabbedFormView.CONTEXT_AREA_WIDTH, AbstractTabbedFormView.CONTEXT_AREA_HEIGHT);
    getLayoutContainer().setLayoutData(new MarginData(AbstractTabbedFormView.DEFAULT_MARGIN));

    Log.debug("createFieldSets()");

    if (getFieldSets() == null) {
      Log.error("You must call setFieldSets(String[][] fields) in the constructor of your derived class");
      return;
    }

    entitySections = new EntitySection[getNumberOfRows()];

    Log.debug("NumberOfRows: " + getNumberOfRows());

    for (int row = 0; row < getNumberOfRows(); row++) {

      fieldSet = new FieldSet();
      fieldSet.setHeadingText(getFieldSets()[row][FIELD_SET_LABEL]);
      fieldSet.setCollapsible(true);

      htmlLayout = getFieldSetHtmlLayout(getFieldSets()[row][FIELD_SET_LABEL]);
      htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormView.DEFAULT_MARGIN));

      entitySections[row] = getFieldSetSection(getFieldSets()[row][FIELD_SET_LABEL], htmlLayout);

      fieldSet.add(htmlLayout);
      getLayoutContainer().add(fieldSet, new VerticalLayoutData(1, -1));
    }
  }

  public enum Section
  {
     GENERAL_INFORMATION("General Information"),
     ADDRESS_INFORMATION("Address Information"),
     PROFESSIONAL_INFORMATION("Professional Information"),
     PERSONAL_INFORMATION("Personal Information"),
     CONTACT_PREFERENCES("Contact Preferences"),
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

  // TODO: numberOfFieldSets == number of sections

   public EntitySection<ContactRepresentation> getFieldSetSection(String sectionName, HtmlLayoutContainer htmlLayout) {

    EntitySection<ContactRepresentation> result = null;
    Section section = getSectionAsEnum(sectionName);

    Log.debug("getFieldSetSection()");

    switch (section) {

      case GENERAL_INFORMATION: result = new NameAndElectronicAddressSection(htmlLayout); break;

      case ADDRESS_INFORMATION: result = new AddressSection(htmlLayout); break;

      case PROFESSIONAL_INFORMATION: result = new ProfessionalInformationSection(htmlLayout); break;

      case PERSONAL_INFORMATION: result = new PersonalInformationSection(htmlLayout); break;

      case CONTACT_PREFERENCES: result = new ContactPreferencesSection(htmlLayout); break;

      default:
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

      case PERSONAL_INFORMATION: result = new HtmlLayoutContainer(getPersonalInformationHtmlLayout()); break;

      case CONTACT_PREFERENCES: result = new HtmlLayoutContainer(getContactPreferencesHtmlLayout()); break;

      default:
        result = new HtmlLayoutContainer(getDefaultFieldSetHtmlLayout());
        break;
    }

    return result;
  }

  // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
  // In order to fix this, you will need to explicitly set these widgets width and height to 100%.

  protected static native String getGeneralInformationHtmlLayout() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>',
         '<tr><td class=parentCustomer></td><td class=email></td></tr>',
        '</table>'
    ].join("");
  }-*/;

  protected static native String getAddressInformationHtmlLayout() /*-{
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

  protected static native String getProfessionalInformationHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td class=department width=50%></td><td class=role width=50%></td></tr>',
      '<tr><td class=manager></td><td class=assistent></td></tr>',
      '<tr><td class=managerPhone></td><td class=assistentPhone></td></tr>',
      '</table>',
    ].join("");
  }-*/;

  protected static native String getPersonalInformationHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td class=gender width=50%></td><td class=birthday width=50%></td></tr>',
      '<tr><td class=maritalStatus></td><td class=anniversary></td></tr>',
      '<tr><td class=partnerName></td><td></td></tr>',
      '</table>',
    ].join("");
  }-*/;

  protected static native String getContactPreferencesHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td class=email width=50%></td><td width=50%></td></tr>',
      '<tr><td class=phone></td><td></td></tr>',
      '<tr><td class=fax></td><td></td></tr>',
      '<tr><td class=mail></td><td></td></tr>',
      '</table>',
    ].join("");
  }-*/;

  protected static native String getDefaultFieldSetHtmlLayout() /*-{
  return [ '<table width=100% cellpadding=0 cellspacing=0>',
      '<tr><td></td><td></td></tr>',
      '<tr><td></td><td></td></tr>',
      '</table>',
    ].join("");
  }-*/;


  public EntitySection<ContactRepresentation>[] getEntitySections() {
    return entitySections;
  }

  public AbstractContactTab setEntitySections(
      EntitySection<ContactRepresentation>[] entitySections) {
    this.entitySections = entitySections;
    return this;
  }

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
