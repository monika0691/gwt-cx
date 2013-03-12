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
import com.google.gwt.core.client.Scheduler;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.gwtcx.extgwt.client.desktop.view.contact.AbstractContactTabbedFormView;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.AbstractContactTab.Section;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationGeneralTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.section.NameAndElectronicAddressSection;
import com.kiahu.sample.client.presenter.contact.ContactInformationPresenter;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent;
import com.sencha.gxt.widget.core.client.event.TriggerClickEvent.TriggerClickHandler;
import com.sencha.gxt.widget.core.client.form.FormPanel;

public class InformationTabbedFormView extends
    AbstractContactTabbedFormView<ContactInformationUiHandlers> implements
  ContactInformationPresenter.MyView {

  private String[][] tabTemplate = {
    {"General"},
    {"Details"},
    {"Administration"},
    {"Notes"}
  };

  @Inject
  public InformationTabbedFormView(final EventBus eventBus, final FormPanel form,
      final TabPanel tabPanel) {
    super(eventBus, form, tabPanel);

    Log.debug("InformationTabbedFormView()");

    setTabTemplate(tabTemplate);

    createTabs();

    // bindCustomUiHandlers();

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      @Override
      public void execute() {

        Log.debug("execute()");

        resize();

        bindCustomUiHandlers();
      }
    });

    // bindCustomUiHandlers();
  }

  @Override
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");

    InformationGeneralTab tab = (InformationGeneralTab) getEntityTab(Tab.GENERAL);
    NameAndElectronicAddressSection section = (NameAndElectronicAddressSection) tab.getEntitySection(Section.GENERAL_INFORMATION);

    section.addParentCustomerTriggerClickHandler(new TriggerClickHandler() {
        @Override
        public void onTriggerClick(final TriggerClickEvent event) {

          if (getUiHandlers() != null) {
            assert getUiHandlers() instanceof ContactInformationUiHandlers;
            ((ContactInformationUiHandlers) getUiHandlers()).onParentCustomerButtonClicked();
          }
        }
    });
  }

  public void setParentCustomer(String parentCustomer) {

    Log.debug("setParentCustomer()");
  }
}


/*


  @Override
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");

    InformationGeneralTab tab = (InformationGeneralTab) getEntityTab(Tab.GENERAL);

    if (tab != null && tab instanceof com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationGeneralTab) {

      Log.debug("tab instanceof com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationGeneralTab");

      NameAndElectronicAddressSection section = (NameAndElectronicAddressSection) tab.getEntitySection(Section.GENERAL_INFORMATION);

      if (section != null && section instanceof com.gwtcx.extgwt.client.desktop.view.contact.tab.section.NameAndElectronicAddressSection) {

        Log.debug("section instanceof com.gwtcx.extgwt.client.desktop.view.contact.tab.section.NameAndElectronicAddressSection");

        section.addParentCustomerTriggerClickHandler(new TriggerClickHandler() {
          @Override
          public void onTriggerClick(final TriggerClickEvent event) {

            if (getUiHandlers() != null) {
              assert getUiHandlers() instanceof ContactInformationUiHandlers;
              ((ContactInformationUiHandlers) getUiHandlers()).onParentCustomerButtonClicked();
            }
          }
        });
      }
    }
  }



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


/*

  protected void createTabs() {

    Log.debug("createTabs()");

    Log.debug("tabs: " + tabs);

    for (int row = 0; row < numberOfTabs; row++) {

      Log.debug("createTabs()");

      // The argument to create(Class) must be a class literal because the Production Mode compiler
      // must be able to statically determine the requested type at compile-time. This can be tricky
      // because using a Class variable may appear to work correctly in Development Mode.

      // http://stackoverflow.com/questions/451658/gwt-dynamic-loading-using-gwt-create-with-string-literals-instead-of-class-lit

      ContactInformationGeneralInformationTab tab = GWT.create(tabs[row][0]);
      tab.setTabPanel(tabPanel);
    }
  }


*/
