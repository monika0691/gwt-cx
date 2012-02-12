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
import com.gwtcx.client.presenter.AccountPagePresenter;
import com.gwtcx.client.uihandlers.AccountPageUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.data.AccountDetailsNpsDataSource;
import com.gwtcx.smartgwt.client.widgets.EntityMasthead;
import com.gwtcx.smartgwt.client.widgets.NavigationPane;
import com.gwtcx.smartgwt.client.widgets.toolbar.EntityToolBar;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AccountPageView extends ViewWithUiHandlers<AccountPageUiHandlers> implements
    AccountPagePresenter.MyView {

  public static final String ENTITY_MAIN_LAYOUT_STYLE_NAME = "gwtcx-Entity-MainLayout";

  public static final int NORTH_HEIGHT = 73; // TOOLBAR_HEIGHT + MASTHEAD_HEIGHT
  public static final String DEFAULT_MARGIN = "0px";

  private final EntityToolBar toolBar;
  private final EntityMasthead masthead;
  private final NavigationPane navigationPane;;

  private VLayout panel;
  private HLayout northLayout;
  private HLayout southLayout;
  private VLayout westLayout;

  @Inject
  public AccountPageView(EntityToolBar toolBar, EntityMasthead masthead, NavigationPane navigationPane) {
    super();

    this.toolBar = toolBar;
    this.masthead = masthead;
    this.navigationPane = navigationPane;

    // get rid of scroll bars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area
    Window.enableScrolling(false);
    Window.setMargin(DEFAULT_MARGIN);

    // initialise the main layout container
    panel = new VLayout();
    panel.setWidth100();
    panel.setHeight100();

    panel.setStyleName(ENTITY_MAIN_LAYOUT_STYLE_NAME);

    // initialise the North layout container
    northLayout = new HLayout();
    northLayout.setHeight(NORTH_HEIGHT);

    // initialise the nested layout container
    VLayout vLayout = new VLayout();
    vLayout.addMember(this.toolBar);
    vLayout.addMember(this.masthead);

    // add the nested layout container to the North layout container
    northLayout.addMember(vLayout);

    initNavigationPane();

    // initialise the West layout container
    westLayout = this.navigationPane;

    // initialise the South layout container
    southLayout = new HLayout();

    // add the North and South layout containers to the main layout container
    panel.addMember(northLayout);
    panel.addMember(southLayout);

    // bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {
    // initialise the ToolBar and register its handlers
    initToolBar();
  }

  private void initNavigationPane() {
    navigationPane.addSection(I18nUtil.getConstant().accountDetailsNavigationPaneSectionName(),
        AccountDetailsNpsDataSource.getInstance());
  }

  protected void initToolBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  @Override
  public void setInSlot(Object slot, Widget content) {

    if (slot == AccountPagePresenter.TYPE_SetContextAreaContent) {
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
  }

  public EntityToolBar getToolBar() {
    return toolBar;
  }

  public EntityMasthead getMasthead() {
    return masthead;
  }

  public NavigationPane getNavigationPane() {
    return navigationPane;
  }
}
