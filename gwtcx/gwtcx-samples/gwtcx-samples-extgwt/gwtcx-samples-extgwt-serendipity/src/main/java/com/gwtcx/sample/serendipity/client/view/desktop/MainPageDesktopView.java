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
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.gwtcx.extgwt.client.view.AbstractMainPageView;
import com.gwtcx.extgwt.client.widgets.ApplicationMenu;
import com.gwtcx.extgwt.client.widgets.Masthead;
import com.gwtcx.extgwt.client.widgets.NavigationPaneSection;
import com.gwtcx.sample.serendipity.client.entrypoint.Serendipity;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.ContentPanel.ContentPanelAppearance;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.Menu;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

public class MainPageDesktopView extends AbstractMainPageView<MainPageUiHandlers> implements
    MainPagePresenter.MyView {

  public interface MainPageUiBinder extends UiBinder<Viewport, MainPageDesktopView> { }

  private static MainPageUiBinder uiBinder = GWT.create(MainPageUiBinder.class);

  protected NavigationPaneSection salesSection;
  protected NavigationPaneSection settingsSection;
  protected NavigationPaneSection resourceSection;

  @Inject
  public MainPageDesktopView(final Masthead masthead, final ApplicationMenu applicationMenu) {
    super(masthead, applicationMenu);

    Log.debug("MainPageDesktopView()");

    // expand the first Navigation Pane section
    getNavigationPane().setWidget(getNavigationPane().getWidget(0));
  }

  @Override
  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    setViewport(uiBinder.createAndBindUi(this));
  }

  @UiFactory
  public ContentPanel createContentPanel(ContentPanelAppearance appearance) {
    return new ContentPanel(appearance);
  }

  @Override
  public void setInSlot(Object slot, Widget content) {

    Log.debug("setInSlot() - getCenterLayoutContainer().add(content)");

    if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {
      if (content != null) {

        Log.debug("content: " + content.getClass().getName()) ;

        getCenterPanel().add(content);

        if (content instanceof com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) {

          Log.debug("panel.onResize()") ;

          ((com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) content).onResize();
        }
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
      new GoToSelectionHandler());
    getApplicationMenu().addSubMenu(goToMenu, ExtGwtCx.getConstant().settingsMenuItemName(),
        ExtGwtCx.getConstant().settingsMenuItemNames(),
      new GoToSelectionHandler());
    getApplicationMenu().addSubMenu(goToMenu, ExtGwtCx.getConstant().resourceCentreMenuItemName(),
        ExtGwtCx.getConstant().resourceCentreMenuItemNames(),
      new GoToSelectionHandler());

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

    salesSection = getNavigationPane().addSection(ExtGwtCx.getConstant().salesStackSectionName()) ;
    salesSection.addRowClickHandler(new RowClickHandler() {
      @Override
      public void onRowClick(RowClickEvent event) {

        // int rowIndex = event.getRowIndex();

        NavigationPaneSectionModel model = (NavigationPaneSectionModel) salesSection.getGrid().getStore().get(event.getRowIndex());
        navigationPaneSectionClicked(model.getName());
      }
    });

    settingsSection = getNavigationPane().addSection(ExtGwtCx.getConstant().settingsStackSectionName());

    resourceSection = getNavigationPane().addSection(ExtGwtCx.getConstant().resourceCentreStackSectionName());
  }

  protected void navigationPaneSectionClicked(String place) {
    if (getUiHandlers() != null) {
      getUiHandlers().onNavigationPaneSectionClicked(place);
    }
  }

  public class NewActivitySelectionHandler implements SelectionHandler<Item> {
    @Override
    public void onSelection(SelectionEvent<Item> event) {

      // TO DO: need to use name NOT displayName as per RowClickHandler()
      MenuItem item = (MenuItem) event.getSelectedItem();
      String place = item.getText().trim();

      Info.display("Action", "You selected: " + place);

      // if (getUiHandlers() != null) {
      //   getUiHandlers().onNewRecordClicked(place);
      // }
    }
  }

  public class GoToSelectionHandler implements SelectionHandler<Item> {
    @Override
    public void onSelection(SelectionEvent<Item> event) {

      // TO DO: need to use name NOT displayName as per RowClickHandler()
      MenuItem item = (MenuItem) event.getSelectedItem();
      String place = item.getText().trim();

      if (getUiHandlers() != null) {
        getUiHandlers().onGoToMenuItemClicked(place);
      }
    }
  }

}

/*


        // getCenterPanel().setWidget(content);

        if (content instanceof com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) {

          Log.debug("content.forceLayout()") ;

          ((com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer) content).forceLayout();
        }





    SimpleSafeHtmlCell<String> cell = new SimpleSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance(), "click") {
      @Override
      public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event,
          ValueUpdater<String> valueUpdater) {

        super.onBrowserEvent(context, parent, value, event, valueUpdater);

        if ("click".equals(event.getType())) {
          // Info.display("Click", "You clicked \"" + value + "\"!");

          navigationPaneSectionClicked(value);
        }
      }
    };

    // getNavigationPane().addRecordClickHandler(ExtGwtCx.getConstant().salesStackSectionName(), cell);



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