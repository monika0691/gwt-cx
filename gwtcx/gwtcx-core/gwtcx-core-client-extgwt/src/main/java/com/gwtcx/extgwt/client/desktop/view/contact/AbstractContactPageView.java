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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.extgwt.client.widgets.EntityMasthead;
import com.gwtcx.extgwt.client.widgets.NavigationPane;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * AbstractContactPageView
 */
public abstract class AbstractContactPageView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  // public static final String CONTEXT_AREA_WIDTH = "100%";
  // public static final String CONTEXT_AREA_HEIGHT = "100%";
  public static final String TOOLBAR_WIDTH = "100%";
  public static final String TOOLBAR_HEIGHT = "26px";

  protected final EventBus eventBus;
  protected final com.gwtcx.extgwt.client.widgets.ToolBar toolBar;
  protected final EntityMasthead masthead;

  protected Viewport viewport;

  @UiField public BorderLayoutContainer borderLayoutContainer;

  @UiField public FlowPanel northPanel;

  @UiField public ContentPanel westPanel;

  @UiField public ContentPanel centerPanel;

  @UiField public NavigationPane navigationPane;

  @Inject
  public AbstractContactPageView(final EventBus eventBus, final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final EntityMasthead masthead) {
    super();

    Log.debug("AbstractContactPageView()");

    this.eventBus= eventBus;
    this.toolBar = toolBar;
    this.masthead = masthead;

    createAndBindUi();

    // get rid of scroll bars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area
    getViewport().setEnableScroll(false);  // calls Window.enableScrolling(false);
    Window.setMargin("0px");

    getToolBar().setSize(TOOLBAR_WIDTH, TOOLBAR_HEIGHT);

    VerticalLayoutContainer vLayout = new VerticalLayoutContainer();
    vLayout.add(getToolBar(), new VerticalLayoutData(1, -1));

    getNorthPanel().add(vLayout);
    getNorthPanel().add(getMasthead());

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {
    Log.warn("Don't forget to @Override createAndBindUi()");

    // e.g. setViewport(uiBinder.createAndBindUi(this));
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    // initialise the ToolBar and register its handlers
    initToolBar();

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

  protected void initToolBar() { }

  protected void initNavigationPane() { }

  public com.gwtcx.extgwt.client.widgets.ToolBar getToolBar() {
    return toolBar;
  }

  public EntityMasthead getMasthead() {
    return masthead;
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
}
