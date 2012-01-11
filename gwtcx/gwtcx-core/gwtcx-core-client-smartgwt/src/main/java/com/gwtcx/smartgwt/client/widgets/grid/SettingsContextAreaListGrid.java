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
import com.gwtcx.smartgwt.client.data.ContextAreaDataSource;
import com.gwtcx.smartgwt.client.data.SettingsCaDataSource;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;

public class SettingsContextAreaListGrid extends ListGrid {

  public static final String CONTEXT_AREA_FEATURE_CELL_STYLE_NAME = "gwtcx-ContextAreaFeatureCell";

  // public static final String EMPTY_FIELD = "emptyField";
  // public static final String EMPTY_FIELD_DISPLAY_NAME = " ";
  public static final String SMALL_ICON_URL_PREFIX = "icons/16/";
  public static final String LARGE_ICON_URL_PREFIX = "icons/48/";
  public static final String URL_SUFFIX = ".png";

  public static final int SMALL_ICON_SIZE = 16;
  public static final int LARGE_ICON_SIZE = 48;
  public static final int SMALL_ICON_FIELD_WIDTH = 20;  // 27
  public static final int LARGE_ICON_FIELD_WIDTH = 80;

  private static final int CELL_HEIGHT = 66;  // 56

  public SettingsContextAreaListGrid() {
    super();

    // initialise the List Grid
    this.setBaseStyle(CONTEXT_AREA_FEATURE_CELL_STYLE_NAME);
    // this.setDataSource(dataSource);
    this.setDataSource(SettingsCaDataSource.getInstance());
    this.setShowAllRecords(true);
    this.setWrapCells(true);
    this.setCellHeight(CELL_HEIGHT);

    // hide the column header
    this.setShowHeader(false);

    // feature 1 icon field
    ListGridField featureIcon1Field = new ListGridField(ContextAreaDataSource.COLUMN1_ICON,
        ContextAreaDataSource.COLUMN1_ICON_DISPLAY_NAME, LARGE_ICON_FIELD_WIDTH);
    featureIcon1Field.setImageSize(LARGE_ICON_SIZE);
    featureIcon1Field.setAlign(Alignment.CENTER);
    featureIcon1Field.setType(ListGridFieldType.IMAGE);
    featureIcon1Field.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(LARGE_ICON_URL_PREFIX));
    featureIcon1Field.setImageURLSuffix(URL_SUFFIX);
    featureIcon1Field.setCanEdit(false);

    // feature 1 description
    ListGridField featureDescription1Field = new ListGridField(ContextAreaDataSource.COLUMN1_DESCRIPTION,
        ContextAreaDataSource.COLUMN1_DESCRIPTION_DISPLAY_NAME);
    // TO DO - find out how to align top ???
    // featureDescription1Field.setAlign(top);

    // feature 2 icon field
    ListGridField featureIcon2Field = new ListGridField(ContextAreaDataSource.COLUMN2_ICON,
        ContextAreaDataSource.COLUMN2_ICON_DISPLAY_NAME, LARGE_ICON_FIELD_WIDTH);
    featureIcon2Field.setImageSize(LARGE_ICON_SIZE);
    featureIcon2Field.setAlign(Alignment.CENTER);
    featureIcon2Field.setType(ListGridFieldType.IMAGE);
    featureIcon2Field.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(LARGE_ICON_URL_PREFIX));
    featureIcon2Field.setImageURLSuffix(URL_SUFFIX);
    featureIcon2Field.setCanEdit(false);

    // feature 2 description
    ListGridField featureDescription2Field = new ListGridField(ContextAreaDataSource.COLUMN2_DESCRIPTION,
        ContextAreaDataSource.COLUMN2_DESCRIPTION_DISPLAY_NAME);

    // add the fields to the list grid
    this.setFields(new ListGridField[] {featureIcon1Field, featureDescription1Field, featureIcon2Field, featureDescription2Field});

    // register the Data Arrived Handler
    this.addDataArrivedHandler(new DataArrivedHandler() {
      @Override
      public void onDataArrived(DataArrivedEvent event) {
          Log.debug("Data has arrived.");
        // selectRecord(0);
      }
    });

    // populate the List Grid
    this.setAutoFetchData(true);
  }
}
