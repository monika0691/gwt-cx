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

package com.gwtcx.extgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.presenter.ContactInformationPresenter;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
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
    // getForm().setLayoutData(new MarginData(8));
    // getTabPanel().setLayoutData(new MarginData(8));
    getForm().setWidget(tabPanel);

    FieldSet fieldSet = new FieldSet();
    fieldSet.setHeadingText("General Information");
    fieldSet.setCollapsible(true);



    HtmlLayoutContainer general = new HtmlLayoutContainer(getTableMarkup());
    general.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    general.setLayoutData(new MarginData(8));


    fieldSet.add(general);

    // getTabPanel().add(general, "General");

    getTabPanel().add(fieldSet, "General");

    new ContactInformationNameSection(general);
    new ContactInformationElectronicAddressSection(general);
  }

  private native String getTableMarkup() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td class=salutation width=50%></td><td class=businessPhone width=50%></td></tr>',
        '<tr><td class=givenName></td><td class=homePhone></td></tr>',
        '<tr><td class=middleName></td><td class=mobilePhone></td></tr>',
        '<tr><td class=familyName></td><td class=fax></td></tr>', '</table>'
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
