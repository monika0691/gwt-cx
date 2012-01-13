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

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * PagingView
 */
public class AbstractPagingView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";

  protected FlowPanel panel;

  final Grid<?> grid;

  @Inject
  // public AbstractPagingView(ToolBar toolBar, ContextAreaListGrid listGrid, StatusBar statusBar) {
  public AbstractPagingView(Grid<?> grid) {
    super();

    this.grid = grid;

    panel = new FlowPanel();
    // panel.setStyleName(StyleTokens.contextArea);
    panel.setWidth(CONTEXT_AREA_WIDTH);

    // add the Tool Bar, Grid, and Status Bar to the View's layout container
    panel.add(this.grid);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() { }

  @Override
  public Widget asWidget() {
    return panel;
  }
}
