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

package com.gwtcx.extgwt.client.desktop.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.extgwt.client.widgets.ApplicationMenu;
import com.gwtcx.extgwt.client.widgets.Masthead;
import com.gwtcx.extgwt.client.widgets.NavigationPane;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * AbstractMainPageView
 */
public abstract class AbstractMainPageView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  protected final EventBus eventBus;
  protected Viewport viewport;
  protected final Masthead masthead;
  protected final ApplicationMenu applicationMenu;

  @UiField public BorderLayoutContainer borderLayoutContainer;

  @UiField public FlowPanel northPanel;

  @UiField public ContentPanel westPanel;

  @UiField public ContentPanel centerPanel;

  @UiField public NavigationPane navigationPane;

  @Inject
  public AbstractMainPageView(final EventBus eventBus, final Masthead masthead, final ApplicationMenu applicationMenu) {
    super();

    Log.debug("AbstractMainPageView()");

    this.eventBus= eventBus;
    this.masthead = masthead;
    this.applicationMenu = applicationMenu;

    createAndBindUi();

    // get rid of scroll bars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area
    getViewport().setEnableScroll(false);  // calls Window.enableScrolling(false);
    Window.setMargin("0px");

    getNorthPanel().add(getMasthead());
    getNorthPanel().add(getApplicationMenu());

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.warn("Don't forget to @Override createAndBindUi()");

    // e.g. setViewport(uiBinder.createAndBindUi(this));
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initApplicationMenu();

    // initialise the NavigationPane and register its handlers
    initNavigationPane();
  }

  public EventBus getEventBus() {
    return eventBus;
  }

  public Viewport getViewport() {
    return viewport;
  }

  public void setViewport(Viewport viewport) {
    this.viewport = viewport;
  }

  @Override
  public Widget asWidget() {
    return viewport;
  }

  protected void initApplicationMenu() { }

  protected void initNavigationPane() { }

  public Masthead getMasthead() {
    return masthead;
  }

  public ApplicationMenu getApplicationMenu() {
    return applicationMenu;
  }

  public NavigationPane getNavigationPane() {
    return navigationPane;
  }

  public FlowPanel getNorthPanel() {
    return northPanel;
  }

  public ContentPanel getWestPanel() {
    return westPanel;
  }

  public ContentPanel getCenterPanel() {
    return centerPanel;
  }

  public ContentPanel getNavigationPaneHeader() {
    return getCenterPanel();
  }
}
