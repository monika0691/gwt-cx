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

import java.util.List;

import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.ReportsDto;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ReportsContextAreaListGrid extends ContextAreaListGrid {

  public static final String REPORT_ICON = "report";

  public static final int REPORT_NAME_COLUMN_WIDTH = 140;
  public static final int REPORT_TYPE_COLUMN_WIDTH = 120;
  public static final int MODIFIED_ON_COLUMN_WIDTH = 140;
  public static final int DESCRIPTION_COLUMN_WIDTH = 260;

  public ReportsContextAreaListGrid() {
    super();

    this.setDetailField(ReportsRecord.REPORT_ID);

    // initialise the List Grid fields
    ListGridField iconField = new ListGridField(ReportsRecord.ICON,
        ReportsRecord.ICON_DISPLAY_NAME, SMALL_ICON_FIELD_WIDTH);
    iconField.setImageSize(SMALL_ICON_SIZE);
    iconField.setAlign(Alignment.CENTER);
    iconField.setType(ListGridFieldType.IMAGE);
    iconField.setImageURLPrefix(GwtCxEntryPoint.getThemedResource(SMALL_ICON_URL_PREFIX));
    iconField.setImageURLSuffix(URL_SUFFIX);

    ListGridField reportNameField = new ListGridField(ReportsRecord.REPORT_NAME,
        I18nUtil.getConstant().reportName(), REPORT_NAME_COLUMN_WIDTH);

    ListGridField reportTypeField = new ListGridField(ReportsRecord.REPORT_TYPE,
        I18nUtil.getConstant().reportType(), REPORT_TYPE_COLUMN_WIDTH);

    ListGridField modifiedOnField = new ListGridField(ReportsRecord.MODIFIED_ON,
        I18nUtil.getConstant().modifiedOn(), MODIFIED_ON_COLUMN_WIDTH);

    ListGridField descriptionField = new ListGridField(ReportsRecord.DESCRIPTION,
        I18nUtil.getConstant().description(), DESCRIPTION_COLUMN_WIDTH);

    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);

    // set the fields into the List Grid
    this.setFields(new ListGridField[] {iconField, reportNameField, reportTypeField, modifiedOnField,
        descriptionField, emptyField});

    // this.setCanEdit(true);
    // this.setEditEvent(ListGridEditEvent.CLICK);
    // this.setModalEditing(true);
  }

  // @Override
  protected Canvas getExpansionComponent(ListGridRecord record) {
    Canvas canvas = super.getExpansionComponent(record);
    canvas.setMargin(5);
    return canvas;
  }

  public void setResultSet(List<ReportsDto> reportsDtos) {

    ReportsRecord[] reportsRecords = new ReportsRecord[reportsDtos.size()];

    for (int i = 0; i < reportsDtos.size(); i++) {
      reportsRecords[i] = createReportsRecord(reportsDtos.get(i));
    }

    // populate the List Grid
    this.setData(reportsRecords);
  }

  private ReportsRecord createReportsRecord(ReportsDto reportsDto) {
    return new ReportsRecord(REPORT_ICON, reportsDto.getReportId(), reportsDto.getReportName(),
        reportsDto.getEntityName(), reportsDto.getReportFilename(), reportsDto.getReportType(),
        reportsDto.getModifiedOn(), reportsDto.getDescription());
  }
}

