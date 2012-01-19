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
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.gwtcx.smartgwt.client.SmartGwtCx;
import com.gwtcx.smartgwt.client.data.NavigationPaneSectionDataSource;
import com.gwtcx.smartgwt.client.data.ResourceCentreNpsDataSource;
import com.gwtcx.smartgwt.client.data.SalesNpsDataSource;
import com.gwtcx.smartgwt.client.data.SettingsNpsDataSource;
import com.gwtcx.smartgwt.client.view.AbstractMainPageView;
import com.gwtcx.smartgwt.client.widgets.ApplicationMenu;
import com.gwtcx.smartgwt.client.widgets.Masthead;
import com.gwtcx.smartgwt.client.widgets.NavigationPane;
import com.gwtcx.smartgwt.client.widgets.NavigationPaneHeader;
import com.gwtcx.smartgwt.client.widgets.NavigationPaneSection;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickEvent;
import com.smartgwt.client.widgets.layout.events.SectionHeaderClickHandler;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.events.ClickHandler;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

public class MainPageView extends AbstractMainPageView<MainPageUiHandlers> implements
    MainPagePresenter.MyView {

  @Inject
  public MainPageView(Masthead masthead, ApplicationMenu applicationMenu,
      NavigationPaneHeader navigationPaneHeader, NavigationPane navigationPane) {
    super(masthead, applicationMenu, navigationPaneHeader, navigationPane);
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    Log.debug("setInSlot()");

    if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {
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

  @Override
  protected void initApplicationMenu() {

    Log.debug("initApplicationMenu()");

    // getApplicationMenu().addMenu(Serendipity.getConstant().newActivityMenuName(),
    getApplicationMenu().addMenu(SmartGwtCx.getConstant().newActivityMenuName(),
        DEFAULT_MENU_WIDTH, SmartGwtCx.getConstant().newActivityMenuItemNames(),
      new NewActivityClickHandler());
    getApplicationMenu().addMenu(SmartGwtCx.getConstant().newRecordMenuName(),
        DEFAULT_MENU_WIDTH, SmartGwtCx.getConstant().newRecordMenuItemNames(),
      new NewRecordClickHandler());
    Menu goToMenu = getApplicationMenu().addMenu(SmartGwtCx.getConstant().goToMenuName(),
        DEFAULT_MENU_WIDTH - 30);
    getApplicationMenu().addSubMenu(goToMenu, SmartGwtCx.getConstant().salesMenuItemName(),
        SmartGwtCx.getConstant().salesMenuItemNames(),
      new GoToClickHandler());
    getApplicationMenu().addSubMenu(goToMenu, SmartGwtCx.getConstant().settingsMenuItemName(),
        SmartGwtCx.getConstant().settingsMenuItemNames(),
      new GoToClickHandler());
    getApplicationMenu().addSubMenu(goToMenu, SmartGwtCx.getConstant().resourceCentreMenuItemName(),
        SmartGwtCx.getConstant().resourceCentreMenuItemNames(),
      new GoToClickHandler());
    getApplicationMenu().addMenu(SmartGwtCx.getConstant().toolsMenuName(),
        DEFAULT_MENU_WIDTH - 30, SmartGwtCx.getConstant().toolsMenuItemNames(),
      new AppicationMenuBarClickHandler());
    getApplicationMenu().addMenu(SmartGwtCx.getConstant().helpMenuName(),
        DEFAULT_MENU_WIDTH - 30, SmartGwtCx.getConstant().helpMenuItemNames(),
      new AppicationMenuBarClickHandler());
  }

  @Override
  protected void initNavigationPane() {

    Log.debug("initNavigationPane()");

    getNavigationPane().addSection(SmartGwtCx.getConstant().salesStackSectionName(),
        SalesNpsDataSource.getInstance());
    getNavigationPane().addSection(SmartGwtCx.getConstant().settingsStackSectionName(),
        SettingsNpsDataSource.getInstance());
    getNavigationPane().addSection(SmartGwtCx.getConstant().resourceCentreStackSectionName(),
        ResourceCentreNpsDataSource.getInstance());

    getNavigationPane().addSectionHeaderClickHandler(new SectionHeaderClickHandler() {
      @Override
      public void onSectionHeaderClick(SectionHeaderClickEvent event) {
        SectionStackSection section = event.getSection();
        String name = ((NavigationPaneSection) section).getSelectedRecord();

        // If there is no selected record (e.g. the data hasn't finished loading)
        // then getSelectedRecord() will return an empty string.
        if (name.isEmpty()) {
          if (section.getTitle().equals(SmartGwtCx.getConstant().settingsStackSectionName())) {
            // default to the first item e.g. "Administration" in Settings
            name = SettingsNpsDataSource.DEFAULT_RECORD_NAME;
          } else if (section.getTitle().equals(SmartGwtCx.getConstant().resourceCentreStackSectionName())) {
            // default to the first item e.g. "Highlights" in Resource Centre
            name = ResourceCentreNpsDataSource.DEFAULT_RECORD_NAME;
          }
        }

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneSectionHeaderClicked(name);
        }
      }
    });

    getNavigationPane().addRecordClickHandler(SmartGwtCx.getConstant().salesStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        navigationPaneSectionClicked(event);
      }
    });

    getNavigationPane().addRecordClickHandler(SmartGwtCx.getConstant().settingsStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        navigationPaneSectionClicked(event);
      }
    });

    getNavigationPane().addRecordClickHandler(SmartGwtCx.getConstant().resourceCentreStackSectionName(),
        new RecordClickHandler() {
      @Override
      public void onRecordClick(RecordClickEvent event) {
        navigationPaneSectionClicked(event);
      }
    });
  }

  public class NewActivityClickHandler implements ClickHandler {
    @Override
    public void onClick(MenuItemClickEvent event) {

      String place = event.getItem().getTitle().trim();

      if (getUiHandlers() != null) {
         getUiHandlers().onNewActivityClicked(place);
      }
    }
  }

  public class NewRecordClickHandler implements ClickHandler {
    @Override
    public void onClick(MenuItemClickEvent event) {

      String place = event.getItem().getTitle().trim();

      if (getUiHandlers() != null) {
         getUiHandlers().onNewRecordClicked(place);
      }
    }
  }

  public class GoToClickHandler implements ClickHandler {
    @Override
    public void onClick(MenuItemClickEvent event) {

      String place = event.getItem().getTitle().trim();

      if (getUiHandlers() != null) {
        getUiHandlers().onGoToMenuItemClicked(place);
      }
    }
  }

  public class AppicationMenuBarClickHandler implements ClickHandler {
      @Override
    public void onClick(MenuItemClickEvent event) {
      String menuItemName = event.getItem().getTitle();
      SC.say("MenuItem name: " + menuItemName);
    }
  }

  protected void navigationPaneSectionClicked(RecordClickEvent event) {
    Record record = event.getRecord();
    String place = record.getAttributeAsString(NavigationPaneSectionDataSource.NAME);

    if (getUiHandlers() != null) {
      getUiHandlers().onNavigationPaneSectionClicked(place);
    }
  }
}