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

package com.gwtcx.client.smartgwt.widgets.grid;

import com.smartgwt.client.types.ExpansionMode;
import com.smartgwt.client.widgets.grid.ListGrid;

/**
 * SalesContextAreaListGrid displays a list of objects in a grid, where
 * each row represents one object and each cell in the row represents one property.
 */
public class ContextAreaListGrid extends ListGrid {

  public static final String EMPTY_FIELD = "emptyField";
  public static final String EMPTY_FIELD_DISPLAY_NAME = " ";
  public static final String SMALL_ICON_URL_PREFIX = "icons/16/";
  public static final String LARGE_ICON_URL_PREFIX = "icons/48/";
  public static final String URL_SUFFIX = ".png";

  public static final int SMALL_ICON_SIZE = 16;
  public static final int LARGE_ICON_SIZE = 48;
  public static final int SMALL_ICON_FIELD_WIDTH = 20;  // 27
  public static final int LARGE_ICON_FIELD_WIDTH = 80;

  public ContextAreaListGrid() {
    super();

    // initialise the List Grid
    this.setCanExpandRecords(true);
    this.setExpansionMode(ExpansionMode.DETAIL_FIELD);
    this.setShowAllRecords(true);

    // initialise the List Grid
    // this.setBaseStyle("gwtcx-ContextArea-GridCell");
    // this.setSortField(1);

    // show the List Grid filter editor
    // this.setShowFilterEditor(true);
    // this.setFilterOnKeypress(true);
  }
}
