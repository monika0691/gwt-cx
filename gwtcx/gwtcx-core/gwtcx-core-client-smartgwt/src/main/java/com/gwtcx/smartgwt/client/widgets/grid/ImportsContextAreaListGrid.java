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

import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

public class ImportsContextAreaListGrid extends ContextAreaListGrid {

  public static final String IMPORT_ICON = "import";

  public static final int IMPORT_NAME_COLUMN_WIDTH = 220;
  public static final int STATUS_COLUMN_WIDTH = 100;
  public static final int SUCCESSES_COLUMN_WIDTH = 70; // Submitted, Transformed, Completed
  public static final int ERRORS_COLUMN_WIDTH = 70;
  public static final int TOTAL_COLUMN_WIDTH = 70;
  public static final int CREATED_ON_COLUMN_WIDTH = 120;

  public ImportsContextAreaListGrid() {
    super();

    this.setDetailField(ImportsRecord.IMPORT_ID);

    // initialise the List Grid fields
    ListGridField iconField = new ListGridField(ImportsRecord.ICON,
        ImportsRecord.ICON_DISPLAY_NAME, SMALL_ICON_FIELD_WIDTH);
    iconField.setImageSize(16);
    iconField.setAlign(Alignment.CENTER);
    iconField.setType(ListGridFieldType.IMAGE);
    iconField.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(SMALL_ICON_URL_PREFIX));
    iconField.setImageURLSuffix(URL_SUFFIX);

    ListGridField importNameField = new ListGridField(ImportsRecord.IMPORT_NAME,
        I18nUtil.getConstant().importName(), IMPORT_NAME_COLUMN_WIDTH);

    ListGridField statusField = new ListGridField(ImportsRecord.STATUS,
        I18nUtil.getConstant().status(), STATUS_COLUMN_WIDTH);

    ListGridField successesField = new ListGridField(ImportsRecord.SUCCESSES,
        I18nUtil.getConstant().successes(), SUCCESSES_COLUMN_WIDTH);

    ListGridField errorsField = new ListGridField(ImportsRecord.ERRORS,
        I18nUtil.getConstant().errors(), ERRORS_COLUMN_WIDTH);

    ListGridField totalField = new ListGridField(ImportsRecord.TOTAL,
        I18nUtil.getConstant().total(), TOTAL_COLUMN_WIDTH);

    ListGridField createdOnField = new ListGridField(ImportsRecord.CREATED_ON,
        I18nUtil.getConstant().createdOn(), CREATED_ON_COLUMN_WIDTH);

    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);

    // set the fields into the List Grid
    this.setFields(new ListGridField[] {iconField, importNameField, statusField, successesField,
        errorsField, totalField, createdOnField, emptyField});
  }

  // public void setResultSet(List<ImportsDto> importsDto) { }

  // private ImportsRecord createImportsRecord(ImportsDto importsDto) { }
}

