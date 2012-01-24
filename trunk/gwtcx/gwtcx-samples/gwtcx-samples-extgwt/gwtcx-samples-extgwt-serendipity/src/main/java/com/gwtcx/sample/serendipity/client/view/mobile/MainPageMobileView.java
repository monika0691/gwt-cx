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

package com.gwtcx.sample.serendipity.client.view.mobile;

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
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.ContentPanel.ContentPanelAppearance;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.menu.Item;
import com.sencha.gxt.widget.core.client.menu.MenuItem;

public class MainPageMobileView extends AbstractMainPageView<MainPageUiHandlers> implements
    MainPagePresenter.MyView {

  public interface MainPageUiBinder extends UiBinder<Viewport, MainPageMobileView> { }

  private static MainPageUiBinder uiBinder = GWT.create(MainPageUiBinder.class);

  @Inject
  public MainPageMobileView(final Masthead masthead, final ApplicationMenu applicationMenu) {
    super(masthead, applicationMenu);

    Log.debug("MainPageMobileView()");

    getNavigationPane().setWidget(getNavigationPane().getWidget(0));
  }

  @Override
  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    viewport = uiBinder.createAndBindUi(this);
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
        new NewActivitySelectionHandler());
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
}