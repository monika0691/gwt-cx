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

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * AbstractPagingView
 */
public abstract class AbstractPagingView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;

  protected final com.gwtcx.extgwt.client.widgets.ToolBar toolBar;
  protected final Grid<?> grid;

  @Inject
  public AbstractPagingView(final com.gwtcx.extgwt.client.widgets.ToolBar toolBar, final Grid<?> grid) {
    super();

    this.toolBar = toolBar;
    this.grid = grid;

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Tool Bar, Grid, and Status Bar to the View's layout container
    this.panel.add(this.toolBar, new VerticalLayoutData(1, -1));  // new Margins(4)
    this.panel.add(this.grid, new VerticalLayoutData(1, -1));

    // this.panel.forceLayout();

    /*

    this.panel.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {

        int width = event.getWidth();
        int height = event.getHeight();

        Log.debug("ResizeHandler() - width: " + width + " height: " + height);

        toolBar.setWidth(width + "px");
        grid.setWidth(width + "px");
        grid.setHeight(height - 32 + "px");
      }
    });

    */

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() { }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public com.gwtcx.extgwt.client.widgets.ToolBar getToolBar() {
    return toolBar;
  }

  public Grid<?> getGrid() {
    return grid;
  }

  // public StatusBar getStatusBar() {
  //   return statusBar;
  // }
}
