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

public class ActivitiesContextAreaListGrid extends ContextAreaListGrid {

  public static final int ACTIVITY_TYPE_COLUMN_WIDTH = 90;
  public static final int SUBJECT_COLUMN_WIDTH = 130;
  public static final int REGARDING_COLUMN_WIDTH = 100;
  public static final int PRIORITY_COLUMN_WIDTH = 60;
  public static final int START_DATE_COLUMN_WIDTH = 80;
  public static final int DUE_DATE_COLUMN_WIDTH = 80;

  public ActivitiesContextAreaListGrid() {
    super();

    this.setDetailField(ActivitiesRecord.ACTIVITY_TYPE);

    // initialise the List Grid fields
    ListGridField iconField = new ListGridField(ActivitiesRecord.ICON,
        ActivitiesRecord.ICON_DISPLAY_NAME, SMALL_ICON_FIELD_WIDTH);
    iconField.setImageSize(16);
    iconField.setAlign(Alignment.CENTER);
    iconField.setType(ListGridFieldType.IMAGE);
    iconField.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(SMALL_ICON_URL_PREFIX));
    iconField.setImageURLSuffix(URL_SUFFIX);

    ListGridField activityTypeField = new ListGridField(ActivitiesRecord.ACTIVITY_TYPE,
        I18nUtil.getConstant().activityType(), ACTIVITY_TYPE_COLUMN_WIDTH);

    ListGridField subjectField = new ListGridField(ActivitiesRecord.SUBJECT,
        I18nUtil.getConstant().subject(), SUBJECT_COLUMN_WIDTH);

    ListGridField regardingField = new ListGridField(ActivitiesRecord.REGARDING,
        I18nUtil.getConstant().regarding(), REGARDING_COLUMN_WIDTH);

    ListGridField priorityField = new ListGridField(ActivitiesRecord.PRIORITY,
        I18nUtil.getConstant().priority(), PRIORITY_COLUMN_WIDTH);

    ListGridField startDateField = new ListGridField(ActivitiesRecord.START_DATE,
        I18nUtil.getConstant().startDate(), START_DATE_COLUMN_WIDTH);

    ListGridField dueDateField = new ListGridField(ActivitiesRecord.DUE_DATE,
        I18nUtil.getConstant().dueDate(), DUE_DATE_COLUMN_WIDTH);

    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);

    // set the fields into the List Grid
    this.setFields(new ListGridField[] {iconField, activityTypeField, subjectField, regardingField,
        priorityField, startDateField, dueDateField, emptyField });

    // populate the List Grid
    this.setData(ActivityData.getRecords());
  }
}
