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

package com.gwtcx.smartgwt.client.widgets.grid;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.smartgwt.client.data.NavigationPaneSectionDataSource;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;

public class NavigationPaneSectionListGrid extends ListGrid {

  public static final String NAVIGATION_PANE_GRID_CELL_STYLE_NAME = "gwtcx-NavigationPaneGridCell";

  // public static final String EMPTY_FIELD = "emptyField";
  // public static final String EMPTY_FIELD_DISPLAY_NAME = " ";
  public static final String SMALL_ICON_URL_PREFIX = "icons/16/";
  public static final String LARGE_ICON_URL_PREFIX = "icons/48/";
  public static final String URL_SUFFIX = ".png";

  public static final int SMALL_ICON_SIZE = 16;
  public static final int LARGE_ICON_SIZE = 48;
  public static final int SMALL_ICON_FIELD_WIDTH = 27;
  public static final int LARGE_ICON_FIELD_WIDTH = 80;

  public NavigationPaneSectionListGrid(DataSource dataSource) {
    super();

    // initialise the List Grid
    this.setBaseStyle(NAVIGATION_PANE_GRID_CELL_STYLE_NAME);
    this.setDataSource(dataSource);
    this.setWidth100();
    this.setHeight100();
    this.setShowAllRecords(true);
    this.setShowHeader(false);

    // initialise the Icon field
    ListGridField appIconField = new ListGridField(NavigationPaneSectionDataSource.ICON,
        NavigationPaneSectionDataSource.ICON_DISPLAY_NAME, SMALL_ICON_FIELD_WIDTH);
    appIconField.setImageSize(SMALL_ICON_SIZE);
    appIconField.setAlign(Alignment.RIGHT);
    appIconField.setType(ListGridFieldType.IMAGE);
    appIconField.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(SMALL_ICON_URL_PREFIX));
    appIconField.setImageURLSuffix(URL_SUFFIX);
    // appIconField.setCanEdit(false);

    // initialise the Display Name field
    ListGridField appDisplayNameField = new ListGridField(NavigationPaneSectionDataSource.DISPLAY_NAME,
        NavigationPaneSectionDataSource.DISPLAY_NAME_DISPLAY_NAME);

    // set the fields into the List Grid
    this.setFields(new ListGridField[] {appIconField, appDisplayNameField});

    // register the Data Arrived Handler
    this.addDataArrivedHandler(new DataArrivedHandler() {
      @Override
      public void onDataArrived(DataArrivedEvent event) {
          Log.debug("Data has arrived.");
        // selectRecord(0);
      }
    });

    // populate the List Grid
    // this.setAutoFetchData(true);
    this.fetchData();
  }
}
