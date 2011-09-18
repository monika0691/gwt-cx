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

package com.gwtcx.sample.serendipity.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.GwtCx;
import com.gwtcx.client.smartgwt.data.NavigationPaneSectionDataSource;
import com.gwtcx.client.smartgwt.data.ResourceCentreNpsDataSource;
import com.gwtcx.client.smartgwt.data.SalesNpsDataSource;
import com.gwtcx.client.smartgwt.data.SettingsNpsDataSource;
import com.gwtcx.client.smartgwt.view.MainPageView;
import com.gwtcx.client.smartgwt.view.handlers.MainPageUiHandlers;
import com.gwtcx.client.smartgwt.widgets.ApplicationMenu;
import com.gwtcx.client.smartgwt.widgets.Masthead;
import com.gwtcx.client.smartgwt.widgets.NavigationPane;
import com.gwtcx.client.smartgwt.widgets.NavigationPaneHeader;
import com.gwtcx.client.smartgwt.widgets.NavigationPaneSection;
import com.gwtcx.sample.serendipity.client.entrypoint.Serendipity;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityMainPagePresenter;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickHandler;
import com.smartgwt.client.widgets.menu.Menu;

public class SerendipityMainPageView extends MainPageView<MainPageUiHandlers> implements
    SerendipityMainPagePresenter.MyView {

  @Inject
  public SerendipityMainPageView(Masthead masthead, ApplicationMenu applicationMenu,
      NavigationPaneHeader navigationPaneHeader, NavigationPane navigationPane) {
    super(masthead, applicationMenu, navigationPaneHeader, navigationPane);
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    Log.debug("setInSlot()");

    if (slot == SerendipityMainPagePresenter.TYPE_SetContextAreaContent) {
      if (content != null) {
        getSouthLayout().setMembers(getWestLayout(), (VLayout) content);
      }
    } else {
      super.setInSlot(slot, content);
    }
  }

  @Override
  public void removeFromSlot(Object slot, Widget content) {
    super.removeFromSlot(slot, content);

    Log.debug("removeFromSlot()");
  }

  protected void onRecordClicked(RecordClickEvent event) {
    Record record = event.getRecord();
    String place = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);

    if (getUiHandlers() != null) {
      getUiHandlers().onNavigationPaneSectionClicked(place);
    }
  }

  @Override
  protected void initApplicationMenu() {

    Log.debug("initApplicationMenu()");

    getApplicationMenu().addMenu(Serendipity.getConstant().newActivityMenuName(),
        DEFAULT_MENU_WIDTH, GwtCx.getConstant().newActivityMenuItemNames(),
        null);
    getApplicationMenu().addMenu(GwtCx.getConstant().newRecordMenuName(),
        DEFAULT_MENU_WIDTH, GwtCx.getConstant().newRecordMenuItemNames(),
        null);
    Menu goToMenu = getApplicationMenu().addMenu(GwtCx.getConstant().goToMenuName(),
        DEFAULT_MENU_WIDTH - 30);
    getApplicationMenu().addSubMenu(goToMenu, GwtCx.getConstant().salesMenuItemName(),
            GwtCx.getConstant().salesMenuItemNames(),
        null);
    getApplicationMenu().addSubMenu(goToMenu, GwtCx.getConstant().settingsMenuItemName(),
            GwtCx.getConstant().settingsMenuItemNames(),
        null);
    getApplicationMenu().addSubMenu(goToMenu, GwtCx.getConstant().resourceCentreMenuItemName(),
            GwtCx.getConstant().resourceCentreMenuItemNames(),
        null);
    getApplicationMenu().addMenu(GwtCx.getConstant().toolsMenuName(),
        DEFAULT_MENU_WIDTH - 30, GwtCx.getConstant().toolsMenuItemNames(),
        null);
    getApplicationMenu().addMenu(GwtCx.getConstant().helpMenuName(),
        DEFAULT_MENU_WIDTH - 30, GwtCx.getConstant().helpMenuItemNames(),
        null);
  }

  @Override
  protected void initNavigationPane() {

    Log.debug("initNavigationPane()");

    getNavigationPane().addSection(GwtCx.getConstant().salesStackSectionName(),
        SalesNpsDataSource.getInstance());
    getNavigationPane().addSection(GwtCx.getConstant().settingsStackSectionName(),
        SettingsNpsDataSource.getInstance());
    getNavigationPane().addSection(GwtCx.getConstant().resourceCentreStackSectionName(),
        ResourceCentreNpsDataSource.getInstance());

    getNavigationPane().addSectionHeaderClickHandler(new SectionHeaderClickHandler() {
      @Override
      public void onSectionHeaderClick(SectionHeaderClickEvent event) {
        SectionStackSection section = event.getSection();
        String name = ((NavigationPaneSection) section).getSelectedRecord();

        // If there is no selected record (e.g. the data hasn't finished loading)
        // then getSelectedRecord() will return an empty string.
        if (name.isEmpty()) {
          if (section.getTitle().equals(GwtCx.getConstant().settingsStackSectionName())) {
            // default to the first item e.g. "Administration" in Settings
            name = SettingsNpsDataSource.DEFAULT_RECORD_NAME;
          } else if (section.getTitle().equals(GwtCx.getConstant().resourceCentreStackSectionName())) {
            // default to the first item e.g. "Highlights" in Resource Centre
            name = ResourceCentreNpsDataSource.DEFAULT_RECORD_NAME;
          }
        }

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneSectionHeaderClicked(name);
        }
      }
    });

    getNavigationPane().addRecordClickHandler(GwtCx.getConstant().salesStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        onRecordClicked(event);
      }
    });

    getNavigationPane().addRecordClickHandler(GwtCx.getConstant().settingsStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        onRecordClicked(event);
      }
    });

    getNavigationPane().addRecordClickHandler(GwtCx.getConstant().resourceCentreStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        onRecordClicked(event);
      }
    });
  }
}