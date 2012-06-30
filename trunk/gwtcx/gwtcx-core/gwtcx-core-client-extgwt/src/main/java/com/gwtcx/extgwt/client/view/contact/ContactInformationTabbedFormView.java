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

package com.gwtcx.extgwt.client.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.extgwt.client.view.AbstractTabbedFormView;
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

public class ContactInformationTabbedFormView extends AbstractTabbedFormView<ContactInformationUiHandlers> implements
    ContactInformationPresenter.MyView {

  protected VerticalLayoutContainer vLayout;

  protected FieldSet generalInformation;
  protected FieldSet addressInformation;

  protected HtmlLayoutContainer generalLayout;
  protected HtmlLayoutContainer addressLayout;

  @Inject
  public ContactInformationTabbedFormView(final EventBus eventBus, final FormPanel form, final TabPanel tabPanel) {
    super(eventBus, form, tabPanel);

    Log.debug("ContactInformationTabbedFormView()");

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

    new ContactInformationNameSection(generalLayout);
    new ContactInformationElectronicAddressSection(generalLayout);

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
        '<tr><td class=familyName></td><td class=fax></td></tr>', '</table>'
    ].join("");
  }-*/;

  private native String getAddressInformationSectionTableMarkup() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=addressName width=50%></td><td class=postalCode width=50%></td></tr>',
        '<tr><td class=addressLine1></td><td class=country></td></tr>',
        '<tr><td class=addressLine2></td><td class=addressType></td></tr>',
        '<tr><td class=addressLine3></td><td></td></tr>',
        '<tr><td class=city></td><td></td></tr>',
        '<tr><td class=state></td><td></td></tr>', '</table>',
    ].join("");
  }-*/;

  @Override
  public void setId(String id) {

    if (dto != null) {
      dto.setId(id);

      // set Masthead label and the browser window's title
      // setMastheadLabel(dto.getName());
    }
  }
}

/*


public class ContactInformationView extends AbstractFormView<ContactInformationUiHandlers> implements
    ContactInformationPresenter.MyView {

  protected TabPanel tabPanel;

  protected VerticalLayoutContainer vLayout;

  protected FieldSet generalInformation;
  protected FieldSet addressInformation;

  protected HtmlLayoutContainer generalLayout;
  protected HtmlLayoutContainer addressLayout;

  @Inject
  public ContactInformationView(final EventBus eventBus, final TabPanel tabPanel) {
    super(eventBus);

    Log.debug("ContactInformationView()");

    this.tabPanel = tabPanel;

    // getPanel().setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

    getTabPanel().setWidth(CONTEXT_AREA_WIDTH);
    getForm().setWidget(getTabPanel());

    createGeneralInformationSection();

    createAddressInformationSection();

    vLayout = new VerticalLayoutContainer();
    vLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    vLayout.add(generalInformation, new VerticalLayoutData(1, -1));
    vLayout.add(addressInformation, new VerticalLayoutData(1, -1));

    // vLayout.add(generalLayout, new VerticalLayoutData(1, -1));
    // vLayout.add(addressLayout, new VerticalLayoutData(1, -1));
    // getTabPanel().add(vLayout, "General");

    getTabPanel().add(vLayout);
  }

  protected void createGeneralInformationSection() {

    generalInformation = new FieldSet();
    generalInformation.setHeadingText("General Information");
    generalInformation.setCollapsible(true);

    generalLayout = new HtmlLayoutContainer(getGeneralInformationSectionTableMarkup());
    generalLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    new ContactInformationNameSection(generalLayout);
    new ContactInformationElectronicAddressSection(generalLayout);

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

  @Override
  public void setId(String id) {

    if (dto != null) {
      dto.setId(id);

      // set Masthead label and the browser window's title
      // setMastheadLabel(dto.getName());
    }
  }

  public TabPanel getTabPanel() {
    return tabPanel;
  }

  public FramedPanel getForm() {
    return form;
  }
}

*/

/*

    return [ '<fieldset>',
        '<legend>Address Information:</legend>',
        '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=addressName width=50%></td><td class=postalCode width=50%></td></tr>',
        '<tr><td class=addressLine1></td><td class=country></td></tr>',
        '<tr><td class=addressLine2></td><td class=addressType></td></tr>',
        '<tr><td class=addressLine3></td><td></td></tr>',
        '<tr><td class=city></td><td></td></tr>',
        '<tr><td class=state></td><td></td></tr>',
        '</table>',
        '</fieldset>'


    // vLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // getTabPanel().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

        // vLayout.forceLayout();

        // generalInformation.forceLayout();
        // addressInformation.forceLayout();


    // getTabPanel().forceLayout();
    // vLayout.forceLayout();

    // generalLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    // addressLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    '<tr><td class=addressLine3></td><td class=rowSpacer1></td></tr>',

    // getForm().setLayoutData(new MarginData(8));
    // getTabPanel().setLayoutData(new MarginData(8));

    // getTabPanel().add(general, "General");

*/