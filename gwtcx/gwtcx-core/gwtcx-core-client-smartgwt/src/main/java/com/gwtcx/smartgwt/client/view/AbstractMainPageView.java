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

package com.gwtcx.smartgwt.client.view;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.smartgwt.client.widgets.ApplicationMenu;
import com.gwtcx.smartgwt.client.widgets.Masthead;
import com.gwtcx.smartgwt.client.widgets.NavigationPane;
import com.gwtcx.smartgwt.client.widgets.NavigationPaneHeader;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * AbstractMainPageView
 */
public abstract class AbstractMainPageView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final int NORTH_HEIGHT = Masthead.MASTHEAD_HEIGHT +
                                         ApplicationMenu.APPLICATION_MENU_HEIGHT +
                                         NavigationPaneHeader.NAVIGATION_PANE_HEADER_HEIGHT;
  public static final int DEFAULT_MENU_WIDTH = 70;

  public static final String DEFAULT_MARGIN = "0px";

  private final Masthead masthead;
  private final ApplicationMenu applicationMenu;
  private final NavigationPaneHeader navigationPaneHeader;
  private final NavigationPane navigationPane;

  private final VLayout viewport;
  private final HLayout northLayout;
  private final HLayout southLayout;
  private final VLayout westLayout;

  @Inject
  public AbstractMainPageView(Masthead masthead, ApplicationMenu applicationMenu,
      NavigationPaneHeader navigationPaneHeader, NavigationPane navigationPane) {
    super();

    this.masthead = masthead;
    this.applicationMenu = applicationMenu;
    this.navigationPaneHeader = navigationPaneHeader;
    this.navigationPane = navigationPane;

    // get rid of scroll bars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area
    Window.enableScrolling(false);
    Window.setMargin(DEFAULT_MARGIN);

    // initialise the main layout container
    viewport = new VLayout();
    viewport.setWidth100();
    viewport.setHeight100();

    // initialise the North layout container
    northLayout = new HLayout();
    northLayout.setHeight(NORTH_HEIGHT);

    // initialise the nested layout container
    VLayout vLayout = new VLayout();
    vLayout.addMember(this.masthead);
    vLayout.addMember(this.applicationMenu);
    vLayout.addMember(this.navigationPaneHeader);

    // add the nested layout container to the North layout container
    northLayout.addMember(vLayout);

    // initialise the West layout container
    westLayout = this.navigationPane;

    // initialise the South layout container
    southLayout = new HLayout();

    // add the North and South layout containers to the main layout container
    viewport.addMember(northLayout);
    viewport.addMember(southLayout);

    bindCustomUiHandlers();
  }

  // SmartGWT Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initApplicationMenu();

    // initialise the NavigationPane and register its handlers
    initNavigationPane();
  }

  @Override
  public Widget asWidget() {
    return viewport;
  }

  /*

  // See MainPage Presenter:
  // @ContentSlot
  // public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();
  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @Override
  public void setInSlot(Object slot, Widget content) {
    Log.debug("setInSlot()");

    if (slot == MainPagePresenter.TYPE_SetContextAreaContent) {
      if (content != null) {
        southLayout.setMembers(westLayout, (VLayout) content);
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

  */

  protected void initApplicationMenu() { }

  protected void initNavigationPane() { }

  public Masthead getMasthead() {
    return masthead;
  }

  public ApplicationMenu getApplicationMenu() {
    return applicationMenu;
  }

  public NavigationPaneHeader getNavigationPaneHeader() {
    return navigationPaneHeader;
  }

  public NavigationPane getNavigationPane() {
    return navigationPane;
  }

  public HLayout getNorthLayout() {
    return northLayout;
  }

  public HLayout getSouthLayout() {
    return southLayout;
  }

  public VLayout getWestLayout() {
    return westLayout;
  }
}
