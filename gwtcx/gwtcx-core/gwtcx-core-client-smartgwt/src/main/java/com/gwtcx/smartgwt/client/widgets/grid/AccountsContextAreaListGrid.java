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

import java.util.List;

import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AccountsDto;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGridField;

public class AccountsContextAreaListGrid extends ContextAreaListGrid {

  public static final String ACCOUNT_ICON = "account";

  public static final int ACCOUNT_NAME_COLUMN_WIDTH = 180;
  public static final int MAIN_PHONE_COLUMN_WIDTH = 90;
  public static final int LOCATION_COLUMN_WIDTH = 280; // 220
  public static final int PRIMARY_CONTACT_COLUMN_WIDTH = 130; // 100
  public static final int EMAIL_PRIMARY_CONTACT_COLUMN_WIDTH = 180;  // 120

  public AccountsContextAreaListGrid() {
    super();

    this.setDetailField(AccountsRecord.ACCOUNT_ID);

    // initialise the List Grid fields
    ListGridField iconField = new ListGridField(AccountsRecord.ICON,
        AccountsRecord.ICON_DISPLAY_NAME, SMALL_ICON_FIELD_WIDTH);
    iconField.setImageSize(SMALL_ICON_SIZE);
    iconField.setAlign(Alignment.CENTER);
    iconField.setType(ListGridFieldType.IMAGE);
    iconField.setImageURLPrefix(SmartGwtEntryPoint.getThemedResource(SMALL_ICON_URL_PREFIX));
    iconField.setImageURLSuffix(URL_SUFFIX);

    ListGridField accountNameField = new ListGridField(AccountsRecord.ACCOUNT_NAME,
        I18nUtil.getConstant().accountName(), ACCOUNT_NAME_COLUMN_WIDTH);

    ListGridField mainPhoneField = new ListGridField(AccountsRecord.MAIN_PHONE,
        I18nUtil.getConstant().mainPhone(), MAIN_PHONE_COLUMN_WIDTH);

    ListGridField locationField = new ListGridField(AccountsRecord.LOCATION,
        I18nUtil.getConstant().location(), LOCATION_COLUMN_WIDTH);

    ListGridField primaryContactField = new ListGridField(AccountsRecord.PRIMARY_CONTACT,
        I18nUtil.getConstant().primaryContact(), PRIMARY_CONTACT_COLUMN_WIDTH);
    primaryContactField.setType(ListGridFieldType.LINK);

    ListGridField emailPrimaryContactField = new ListGridField(AccountsRecord.EMAIL_PRIMARY_CONTACT,
        I18nUtil.getConstant().emailPrimaryContact(), EMAIL_PRIMARY_CONTACT_COLUMN_WIDTH);

    ListGridField emptyField = new ListGridField(EMPTY_FIELD, EMPTY_FIELD_DISPLAY_NAME);

    // set the fields into the List Grid
    this.setFields(new ListGridField[] {iconField, accountNameField, mainPhoneField, locationField,
        primaryContactField, emailPrimaryContactField, emptyField});
  }

  public void setResultSet(List<AccountsDto> accountsDtos) {

    AccountsRecord[] accountsRecords = new AccountsRecord[accountsDtos.size()];

    for (int i = 0; i < accountsDtos.size(); i++) {
      accountsRecords[i] = createAccountsRecord(accountsDtos.get(i));
    }

    // populate the List Grid
    this.setData(accountsRecords);
  }

  private AccountsRecord createAccountsRecord(AccountsDto accountsDto) {
    return new AccountsRecord(ACCOUNT_ICON, accountsDto.getId(), accountsDto.getAccountName(), accountsDto.getMainPhone(),
        accountsDto.getLocation(), accountsDto.getPrimaryContact(), accountsDto.getEmailPrimaryContact());
  }
}

