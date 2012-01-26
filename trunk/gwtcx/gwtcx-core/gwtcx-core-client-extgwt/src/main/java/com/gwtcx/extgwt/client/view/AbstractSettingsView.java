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

package com.gwtcx.extgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * AbstractSettingsView
 */
public abstract class AbstractSettingsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;

  protected Grid<?> grid;

  @Inject
  public AbstractSettingsView() {
    super();

    Log.debug("AbstractPagingView()");

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() { }

  // protected void initToolBar() { }

  // protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public Grid<?> getGrid() {
    return grid;
  }

  public void setGrid(Grid<?> grid) {
    this.grid = grid;;
  }
}

/*

public abstract class AbstractSettingsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;

  protected final Grid<?> grid;

  @Inject
  public AbstractSettingsView(final Grid<?> grid) {
    super();

    Log.debug("AbstractPagingView()");

    this.grid = grid;

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    this.grid.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Grid to the View's layout container
    this.panel.add(this.grid, new VerticalLayoutData(1, 1));  // 1, -1

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {

        Log.debug("execute()");

        resize();
      }
    });

    bindCustomUiHandlers();
  }

  public void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    panel.setSize(width + "px", height + "px");
    panel.onResize();
  }

  protected void bindCustomUiHandlers() { }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public Grid<?> getGrid() {
    return grid;
  }
}

*/