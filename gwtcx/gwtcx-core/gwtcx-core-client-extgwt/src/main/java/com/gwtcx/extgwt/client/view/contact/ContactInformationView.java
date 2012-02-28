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

  @Inject
  public ContactInformationView(final EventBus eventBus, final TabPanel tabPanel) {
    super(eventBus);

    Log.debug("ContactInformationView()");

    this.tabPanel = tabPanel;

    getTabPanel().setWidth(CONTEXT_AREA_WIDTH);
    getForm().setWidget(tabPanel);

    // General Information - FieldSet

    FieldSet generalInformation = new FieldSet();
    generalInformation.setHeadingText("General Information");
    generalInformation.setCollapsible(true);

    HtmlLayoutContainer generalLayout = new HtmlLayoutContainer(getTableMarkup1());
    generalLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    generalLayout.setLayoutData(new MarginData(8));

    new ContactInformationNameSection(generalLayout);
    new ContactInformationElectronicAddressSection(generalLayout);

    generalInformation.add(generalLayout);

    // Address Information - FieldSet

    FieldSet addressInformation = new FieldSet();
    addressInformation.setHeadingText("Address Information");
    addressInformation.setCollapsible(true);

    HtmlLayoutContainer addressLayout = new HtmlLayoutContainer(getTableMarkup2());
    addressLayout.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    addressLayout.setLayoutData(new MarginData(8));

    new ContactInformationAddressSection(addressLayout);

    addressInformation.add(addressLayout);

    VerticalLayoutContainer vLayout = new VerticalLayoutContainer();
    vLayout.setLayoutData(new MarginData(8));
    vLayout.add(generalInformation, new VerticalLayoutData(1, -1));
    vLayout.add(addressInformation, new VerticalLayoutData(1, -1));

    getTabPanel().add(vLayout, "General");
  }

  private native String getTableMarkup1() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>', '</table>'
    ].join("");
  }-*/;

  private native String getTableMarkup2() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=addressName width=50%></td><td class=postalCode width=50%></td></tr>',
        '<tr><td class=addressLine1></td><td class=country></td></tr>',
        '<tr><td class=addressLine2></td><td class=addressType></td></tr>',
        '<tr><td class=addressLine3></td><td></td></tr>',
        '<tr><td class=city></td><td></td></tr>',
        '<tr><td class=state></td><td></td></tr>', '</table>'
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

    // getForm().setLayoutData(new MarginData(8));
    // getTabPanel().setLayoutData(new MarginData(8));

    // getTabPanel().add(general, "General");

*/