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
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.extgwt.client.view.AbstractFormView;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;

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

    getPanel().setStyleName("gwtcx-Dashboards-View");  // overflow: auto;

    getTabPanel().setWidth(CONTEXT_AREA_WIDTH);
    getForm().setWidget(getTabPanel());

    createGeneralInformationSection();

    createAddressInformationSection();

    vLayout = new VerticalLayoutContainer();
    vLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    // vLayout.add(generalInformation, new VerticalLayoutData(1, -1));
    // vLayout.add(addressInformation, new VerticalLayoutData(1, -1));

    vLayout.add(generalLayout, new VerticalLayoutData(1, -1));
    vLayout.add(addressLayout, new VerticalLayoutData(1, -1));

    getTabPanel().add(vLayout, "General");

    // /*

    this.panel.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {

        int width = event.getWidth();
        int height = event.getHeight();

        Log.debug("vLayout - width: " + width + " height: " + height);

        vLayout.setSize(width + "px", height + "px");
        // generalInformation.setWidth((width - DEFAULT_MARGIN * 5) + "px");
        // addressInformation.setWidth((width - DEFAULT_MARGIN * 5) + "px");
        // generalInformation.forceLayout();
        // addressInformation.forceLayout();
      }
    });

    // */
  }

  protected void createGeneralInformationSection() {

    generalInformation = new FieldSet();
    generalInformation.setHeadingText("General Information");
    generalInformation.setCollapsible(true);

    generalLayout = new HtmlLayoutContainer(getGeneralInformationSectionTableMarkup());
    generalLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    new ContactInformationNameSection(generalLayout);
    new ContactInformationElectronicAddressSection(generalLayout);

    // generalInformation.add(generalLayout);
  }

  protected void createAddressInformationSection() {

    addressInformation = new FieldSet();
    addressInformation.setHeadingText("Address Information");
    addressInformation.setCollapsible(true);

    addressLayout = new HtmlLayoutContainer(getAddressInformationSectionTableMarkup());
    addressLayout.setLayoutData(new MarginData(DEFAULT_MARGIN));

    new ContactInformationAddressSection(addressLayout);

    // addressInformation.add(addressLayout);
  }

  private native String getGeneralInformationSectionTableMarkup() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>', '</table>'
    ].join("");
  }-*/;

  private native String getAddressInformationSectionTableMarkup() /*-{
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

  public TabPanel getTabPanel() {
    return tabPanel;
  }
}

/*

<form action="">
<fieldset>
<legend>Personal information:</legend>
Name: <input type="text" size="30" /><br />
E-mail: <input type="text" size="30" /><br />
Date of birth: <input type="text" size="10" />
</fieldset>
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