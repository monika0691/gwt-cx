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
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormView;
import com.gwtcx.extgwt.client.desktop.view.EntityTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationAdministrationTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationDetailsTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationGeneralTab;
import com.gwtcx.extgwt.client.desktop.view.contact.tab.InformationNotesTab;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FormPanel;

public class AbstractContactTabbedFormView<C extends UiHandlers> extends
    AbstractTabbedFormView<C> {

  public final static int TAB_LABEL = 0;

  // TAB_LABEL
  private String[][] tabTemplate = null;

  private EntityTab<ContactRepresentation> [] entityTabs = null;

  private ContactRepresentation contact;

  public AbstractContactTabbedFormView(EventBus eventBus, FormPanel form, TabPanel tabPanel) {
    super(eventBus, form, tabPanel);

    contact = null;
  }

  // See: ContactPageView - setInSlot(Object slot, Widget content)

  protected void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    VerticalLayoutContainer layout = null;

    Log.debug("resize() - width: " + width + " height: " + height);

    getPanel().setSize(width + "px", height + "px");
    getForm().setSize(width + "px", height + "px");
    getTabPanel().setWidth(width + "px");

    // you must call setTabTemplate() in the constructor of your derived class
    if (getTabTemplate() == null) { return; }

    for (int row = 0; row < getNumberOfTabs(); row++) {

      layout = entityTabs[row].getLayoutContainer();

      if (layout != null && layout instanceof com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) {

        layout.setSize(width + "px", height + "px");

        Log.debug("layout.setSize()");
      }
    }

    getPanel().onResize();
  }

  @SuppressWarnings("unchecked")
  protected void createTabs() {

    Log.debug("createTabs()");

    // you must call setTabTemplate() in the constructor of your derived class
    if (getTabTemplate() == null) { return; }

    entityTabs = new EntityTab[getNumberOfTabs()];

    Log.debug("NumberOfTabs: " + getNumberOfTabs());

    for (int row = 0; row < getNumberOfTabs(); row++) {

      entityTabs[row] = getTab(tabTemplate[row][TAB_LABEL]);
    }
  }

  enum Tab
  {
     GENERAL("General"), DETAILS("Details"), ADMINISTRATION("Administration"), NOTES("Notes"), NOT_USED("notUsed");

     private Tab(String stringValue) { this.stringValue = stringValue; }
     public String toString() { return stringValue; }

     private String stringValue;
  }

  public Tab getTabAsEnum(String tabName) {

    Tab result = Tab.NOT_USED;

    for (Tab tab : Tab.values()) {
      if (tabName.contentEquals(tab.toString())) {
        result = tab;
      }
    }

    return result;
  }

  public EntityTab<ContactRepresentation> getTab(String tabName) {

    EntityTab<ContactRepresentation> result = null;
    Tab tab = getTabAsEnum(tabName);

    Log.debug("getTab()");

    switch (tab) {

      case GENERAL: result = new InformationGeneralTab(getTabPanel()); break;

      case DETAILS: result = new InformationDetailsTab(getTabPanel()); break;

      case ADMINISTRATION: result = new InformationAdministrationTab(getTabPanel()); break;

      case NOTES: result = new InformationNotesTab(getTabPanel()); break;

      default:
        result = null;
        break;
    }

    return result;
  }

  protected String[][] getTabTemplate() {
    return tabTemplate;
  }

  protected AbstractContactTabbedFormView<C> setTabTemplate(String[][] fields) {
    this.tabTemplate = fields;
    return this;
  }

  public int getNumberOfTabs() {
    return tabTemplate.length;
  }

  @Override
  public void setId(String id) {

    // TODO
  }

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

    for (int row = 0; row < getNumberOfTabs(); row++) {

      entityTabs[row].setFields(dto);
    }

    // set Masthead Contact Name label and the browser window's title
    // setMastheadLabel(dto.getFullName());
  }
}
