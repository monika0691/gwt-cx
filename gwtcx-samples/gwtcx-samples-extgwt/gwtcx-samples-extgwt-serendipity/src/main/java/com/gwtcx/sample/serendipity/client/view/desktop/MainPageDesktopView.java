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

package com.gwtcx.sample.serendipity.client.view.desktop;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtcx.extgwt.client.view.AbstractMainPageView;
import com.gwtcx.extgwt.client.widgets.ApplicationMenu;
import com.gwtcx.extgwt.client.widgets.Masthead;
import com.gwtcx.sample.serendipity.client.entrypoint.Serendipity;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.ContentPanel.ContentPanelAppearance;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

public class MainPageDesktopView extends AbstractMainPageView<MainPageUiHandlers> implements
    MainPagePresenter.MyView {

  public interface MainPageUiBinder extends UiBinder<Component, MainPageDesktopView> { }

  private static MainPageUiBinder uiBinder = GWT.create(MainPageUiBinder.class);

  @Inject
  public MainPageDesktopView(final Viewport viewport, final Masthead masthead, final ApplicationMenu applicationMenu) {
    super(viewport, masthead, applicationMenu);

    Log.debug("MainPageDesktopView()");

    getNavigationPane().setWidget(getNavigationPane().getWidget(0));
  }

  @Override
  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    widget = uiBinder.createAndBindUi(this);
  }

  @UiFactory
  public ContentPanel createContentPanel(ContentPanelAppearance appearance) {
    return new ContentPanel(appearance);
  }

  @Override
  public void setInSlot(Object slot, Widget content) {

    Log.debug("setInSlot()");

    if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {
      if (content != null) {
        getCenterLayoutContainer().add(content);
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

    getApplicationMenu().addMenu(Serendipity.getConstant().newActivityMenuName(),
        ExtGwtCx.getConstant().newActivityMenuItemNames(),
      new NewActivitySelectionHandler());

    getApplicationMenu().addMenu(Serendipity.getConstant().newRecordMenuName(),
        ExtGwtCx.getConstant().newRecordMenuItemNames(),
      new NewActivitySelectionHandler());

    Menu goToMenu = getApplicationMenu().addMenu(Serendipity.getConstant().goToMenuName());
    getApplicationMenu().addSubMenu(goToMenu, ExtGwtCx.getConstant().salesMenuItemName(),
        ExtGwtCx.getConstant().salesMenuItemNames(),
      new NewActivitySelectionHandler());
    getApplicationMenu().addSubMenu(goToMenu, ExtGwtCx.getConstant().settingsMenuItemName(),
        ExtGwtCx.getConstant().settingsMenuItemNames(),
      new NewActivitySelectionHandler());
    getApplicationMenu().addSubMenu(goToMenu, ExtGwtCx.getConstant().resourceCentreMenuItemName(),
        ExtGwtCx.getConstant().resourceCentreMenuItemNames(),
      new NewActivitySelectionHandler());

    getApplicationMenu().addMenu(Serendipity.getConstant().toolsMenuName(),
        ExtGwtCx.getConstant().toolsMenuItemNames(),
      new NewActivitySelectionHandler());

    getApplicationMenu().addMenu(Serendipity.getConstant().helpMenuName(),
        ExtGwtCx.getConstant().helpMenuItemNames(),
      new NewActivitySelectionHandler());
  }

  @Override
  protected void initNavigationPane() {

    Log.debug("initNavigationPane()");

    getNavigationPane().addSection(ExtGwtCx.getConstant().salesStackSectionName()) ;
        // SalesNpsDataSource.getInstance());
    getNavigationPane().addSection(ExtGwtCx.getConstant().settingsStackSectionName());
        // SettingsNpsDataSource.getInstance());
    getNavigationPane().addSection(ExtGwtCx.getConstant().resourceCentreStackSectionName());
        // ResourceCentreNpsDataSource.getInstance());

  }

  public class NewActivitySelectionHandler implements SelectionHandler<Item> {
    @Override
    public void onSelection(SelectionEvent<Item> event) {

        MenuItem item = (MenuItem)event.getSelectedItem();
        String place = item.getText().trim();

        Info.display("Action", "You selected: " + place);

        // if (getUiHandlers() != null) {
        //     getUiHandlers().onNewRecordClicked(place);
        // }
    }
  }
}

/*

  // @UiFactory
  // public Masthead createMasthead() {
  //   return new Masthead(eventBus);
  // }


  // @UiField
  // Masthead masthead;

    Widget north = borderLayoutContainer.getNorthWidget();

    if (null == north) {
      Log.debug("null == north");
    }


    // SimpleContainer north = (SimpleContainer) borderLayoutContainer.getNorthWidget();
    // north.add(this.masthead);


*/

/*


public class MainPageDesktopView extends AbstractMainPageView<MainPageUiHandlers> implements
    MainPagePresenter.MyView {

  public interface MainPageUiBinder extends UiBinder<Component, MainPageDesktopView> { }

  @SuppressWarnings("unused")
  private final EventBus eventBus;
  private final Viewport viewport;
  private final Widget widget;
  private final Masthead masthead;
  private final ApplicationMenu applicationMenu;

  @UiField
  BorderLayoutContainer borderLayoutContainer;

  @UiField
  VerticalPanel northLayout;

  @UiField
  ContentPanel westLayout;

  @UiField
  AccordionLayoutContainer navigationPane;

  @UiField(provided = true)
  String dummyTextShort = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.";

  @Inject
  public MainPageDesktopView(final EventBus eventBus, final Viewport viewport,
      final Masthead masthead, final ApplicationMenu applicationMenu, final MainPageUiBinder uiBinder) {
    super();

    Log.debug("MainPageDesktopView()");

    this.eventBus= eventBus;
    this.viewport = viewport;
    this.masthead = masthead;
    this.applicationMenu = applicationMenu;

    this.viewport.setEnableScroll(false);

    this.widget = uiBinder.createAndBindUi(this);

    // borderLayoutContainer.setNorthWidget(this.masthead);
    this.northLayout.add(this.masthead);
    this.northLayout.add(this.applicationMenu);

    this.navigationPane.setWidget(navigationPane.getWidget(0));

    this.viewport.add(this.widget);
  }

  @UiFactory
  public ContentPanel createContentPanel(ContentPanelAppearance appearance) {
    return new ContentPanel(appearance);
  }

  @Override
  public Widget asWidget() {
    return viewport;
  }

  @Override
  public void setInSlot(Object slot, Widget content) {
    Log.debug("setInSlot()");

    if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {
      if (content != null) {
        // getSouthLayout().setMembers(getWestLayout(), (VLayout) content);
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

    getApplicationMenu().addMenu(ExtGwtCx.getConstant().newActivityMenuName(),
        ExtGwtCx.getConstant().newActivityMenuItemNames(),
        // new NewActivitySelectionHandler());
        null);
  }

  @Override
  protected void initNavigationPane() {

    Log.debug("initNavigationPane()");

  }

  public class NewActivitySelectionHandler implements SelectionHandler<Item> {
    @Override
    public void onSelection(SelectionEvent<Item> event) {
        MenuItem item = (MenuItem)event.getSelectedItem();
        Info.display("Action", "You selected the " + item.getText());
    }
  }

  public ApplicationMenu getApplicationMenu() {
    return applicationMenu;
  }

  public AccordionLayoutContainer getNavigationPane() {
    return navigationPane;
  }
}

*/