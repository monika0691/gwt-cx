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
import com.gwtcx.extgwt.client.desktop.view.contact.ContactInformationAddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.ContactInformationElectronicAddressSection;
import com.gwtcx.extgwt.client.desktop.view.contact.ContactInformationNameSection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.kiahu.sample.client.presenter.contact.ContactInformationPresenter;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel;

/*

  The values for HorizontalLayoutData and VerticalLayoutData have different meanings depending on which range they are in:

  - If -1, then the item is measured, and given the space it has requested - useful for fields or labels
  - If greater than 1, a pixel value is assigned - you've noticed this in using 100, which draws as 100px wide
  - If greater than 0, and less than or equal to 1, then it will be assigned a percentage of the remaining size after the
    first two items listed have been calculated. The value 1 is 100%, and .25 would be 25% of the remaining space.

*/

public class ContactInformationTabbedFormDesktopView extends
    AbstractTabbedFormDesktopView<ContactInformationUiHandlers> implements
  ContactInformationPresenter.MyView {

  protected VerticalLayoutContainer vLayout;

  protected FieldSet generalInformation;
  protected FieldSet addressInformation;

  protected HtmlLayoutContainer generalLayout;
  protected HtmlLayoutContainer addressLayout;

  protected ContactInformationNameSection nameSection;
  protected ContactInformationElectronicAddressSection addressSection;

  private ContactRepresentation contact;

  @Inject
  public ContactInformationTabbedFormDesktopView(final EventBus eventBus, final FormPanel form,
      final TabPanel tabPanel) {
    super(eventBus, form, tabPanel);

    Log.debug("ContactInformationTabbedFormView()");

    contact = null;

    createGeneralInformationSection();

    createAddressInformationSection();

    vLayout = new VerticalLayoutContainer();
    vLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    // vLayout.setStyleName("gwtcx-Dashboards-View");  // overflow: auto;
    vLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    vLayout.add(generalInformation, new VerticalLayoutData(1, -1));
    vLayout.add(addressInformation, new VerticalLayoutData(1, -1));

    // vLayout.add(generalLayout, new VerticalLayoutData(1, -1));
    // vLayout.add(addressLayout, new VerticalLayoutData(1, -1));

    getTabPanel().add(vLayout, "General");
  }

  protected void createGeneralInformationSection() {

    generalInformation = new FieldSet();
    generalInformation.setHeadingText("General Information");
    generalInformation.setCollapsible(true);

    generalLayout = new HtmlLayoutContainer(getGeneralInformationSectionTableMarkup());
    generalLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    nameSection = new ContactInformationNameSection(generalLayout);
    addressSection = new ContactInformationElectronicAddressSection(generalLayout);

    generalInformation.add(generalLayout);
  }

  protected void createAddressInformationSection() {

    addressInformation = new FieldSet();
    addressInformation.setHeadingText("Address Information");
    addressInformation.setCollapsible(true);

    addressLayout = new HtmlLayoutContainer(getAddressInformationSectionTableMarkup());
    addressLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    new ContactInformationAddressSection(addressLayout);

    addressInformation.add(addressLayout);
  }

  // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
  // In order to fix this, you will need to explicitly set these widgets width and height to 100%.

  private native String getGeneralInformationSectionTableMarkup() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>',
         '<tr><td class=parentCustomer></td><td class=email></td></tr>',
        '</table>'
    ].join("");
  }-*/;

  private native String getAddressInformationSectionTableMarkup() /*-{
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

  @Override
  public void setId(String id) {

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

    nameSection.setFields(dto);
    // addressSection.setFields(dto);

    // set Masthead Contact Name label and the browser window's title
    // setMastheadLabel(dto.getFullName());
  }
}

/*

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

*/