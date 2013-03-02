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

package com.kiahu.sample.client.view.desktop.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormDesktopView;
import com.gwtcx.extgwt.client.desktop.view.contact.ContactInformationGeneralInformationTab;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.kiahu.sample.client.presenter.contact.ContactInformationPresenter;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel;

public class ContactInformationTabbedFormDesktopView extends
    AbstractTabbedFormDesktopView<ContactInformationUiHandlers> implements
  ContactInformationPresenter.MyView {

  private ContactInformationGeneralInformationTab generalInformationTab;

  private ContactRepresentation contact;

  @Inject
  public ContactInformationTabbedFormDesktopView(final EventBus eventBus, final FormPanel form,
      final TabPanel tabPanel) {
    super(eventBus, form, tabPanel);

    Log.debug("ContactInformationTabbedFormDesktopView()");

    contact = null;

    createTabs();
  }

  protected void createTabs() {

    generalInformationTab = new ContactInformationGeneralInformationTab(getTabPanel());
  }

  @Override
  public void setId(String id) {

    // TODO
  }

  @Override
  public void setResult(ContactRepresentation dto) {

    Log.debug("setResult()");

    try {
      if (dto != null) {
        this.contact = dto;
        setFields(this.contact);
      }
    } catch (Exception e) {
      Log.error("Unable to set server response: " + e);
    }
  }

  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    generalInformationTab.setFields(dto);

    // set Masthead Contact Name label and the browser window's title
    // setMastheadLabel(dto.getFullName());
  }
}


/*


  private final static int TAB_LABEL = 0;

  private String[][] tabs = {
    {"General"}
  };

  // {"Details"}, {"Administration"}, {"Notes"}

  private int numberOfTabs = tabs.length;

  protected void createTabs() {

    VerticalLayoutContainer layout = null;

    try {

      for (int row = 0; row < numberOfTabs; row++) {

        layout = new VerticalLayoutContainer();
        layout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
        layout.setLayoutData(new MarginData(DEFAULT_MARGIN));

        createFieldSets(layout);
        getTabPanel().add(layout, tabs[row][TAB_LABEL]);
      }

    } catch (Exception e) {
      Log.error("Unable to create tabs: " + e);
    }
  }

  private String[][] fieldSets = {
    {"General Information", "Address Information", ""},
    {"Section 1", "Section 2"}
  };

  private int numberOfSections = fieldSets.length;
  @SuppressWarnings("unchecked")
  private EntitySection<ContactRepresentation> [] entitySections = new EntitySection[numberOfTabs];

  protected void createFieldSets(VerticalLayoutContainer layout) {

    for (int row = 0; row < numberOfSections; row++) {

      HtmlLayoutContainer HtmlLayout = getSectionHtmlLayout(Section.NAME_SECTION.toString());
      HtmlLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

      entitySections[row] = new ContactInformationNameSection(HtmlLayout);

      layout.add(createGeneralInformationFieldSet(), new VerticalLayoutData(1, -1));
    }
  }


  protected FieldSet createGeneralInformationFieldSet() {

    FieldSet fieldSet = new FieldSet();
    fieldSet.setHeadingText("General Information");
    fieldSet.setCollapsible(true);

    HtmlLayoutContainer layout = getSectionHtmlLayout(Section.NAME_SECTION.toString());
    layout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    nameSection = new ContactInformationNameSection(layout);
    electronicAddressSection = new ContactInformationElectronicAddressSection(layout);

    fieldSet.add(layout);

    return fieldSet;
  }


  protected void createGeneralTab() {

    VerticalLayoutContainer layout = new VerticalLayoutContainer();
    layout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    // vLayout.setStyleName("gwtcx-Dashboards-View");  // overflow: auto;
    layout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    layout.add(createGeneralInformationFieldSet(), new VerticalLayoutData(1, -1));
    layout.add(createAddressInformationFieldSet(), new VerticalLayoutData(1, -1));

    getTabPanel().add(layout, "General");

  }





  protected FieldSet createAddressInformationFieldSet() {

    FieldSet fieldSet = new FieldSet();
    fieldSet.setHeadingText("Address Information");
    fieldSet.setCollapsible(true);

    HtmlLayoutContainer layout = getSectionHtmlLayout(Section.ADDRESS_SECTION.toString());
    layout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    addressSection = new ContactInformationAddressSection(layout);

    fieldSet.add(layout);

    return fieldSet;
  }



*/

/*

        // vLayout.setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

  public void setId(String id) {

    Log.warn("Don't forget to @Override setId()");

    if (dto != null) {
      dto.setId(id);

      // set Masthead label and the browser window's title
      setMastheadLabel(dto.getName());
    }
  }

  public void setFields(AccountDto accountDto) {

    Tab[] tabs = tabSet.getTabs();

    for (Tab tab : tabs) {
      EntityTab entityTab = (EntityTab) tab;

      entityTab.setFields(accountDto);
    }

    // set Masthead Account Name label and the browser window's title
    setMastheadLabel(accountDto.getAccountName());
  }


    // vLayout.add(generalLayout, new VerticalLayoutData(1, -1));
    // vLayout.add(addressLayout, new VerticalLayoutData(1, -1));


*/