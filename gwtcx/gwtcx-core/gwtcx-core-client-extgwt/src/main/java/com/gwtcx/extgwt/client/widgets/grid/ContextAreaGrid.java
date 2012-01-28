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

package com.gwtcx.extgwt.client.widgets.grid;

import com.google.inject.Inject;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.data.ContextAreaModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * ContextAreaGrid
 */
public class ContextAreaGrid extends Grid<ContextAreaModel>{

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  public static final int COLUMN_1_NAME_INDEX = 1;
  public static final int COLUMN_2_NAME_INDEX = 3;

  // public static final int LARGE_ICON_SIZE = 48;
  public static final int LARGE_ICON_COLUMN_WIDTH = 70;
  public static final int DISPLAY_NAME_COLUMN_WIDTH = 420;

  @Inject
  // public ContextAreaGrid(ListStore<M> store, ColumnModel<M> cm) {
  public ContextAreaGrid(ListStore<ContextAreaModel> store, ColumnModel<ContextAreaModel> cm) {
    super(store, cm);

    // this.setStyleName(StyleTokens.contextGrid);
    // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
    // In order to fix this, you will need to explicitly set these widgets width and height to 100%.
    this.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.setBorders(false);
    this.setColumnLines(false);
    this.setColumnReordering(false);
    this.setHideHeaders(true);
    this.setStripeRows(false);

    this.getView().setAutoExpandColumn(this.getColumnModel().getColumn(COLUMN_1_NAME_INDEX));
    this.getView().setEmptyText(I18nUtil.getConstant().gridEmptyText());

    // this.setSelectionModel(new CellSelectionModel<ContextAreaModel>());
  }
}