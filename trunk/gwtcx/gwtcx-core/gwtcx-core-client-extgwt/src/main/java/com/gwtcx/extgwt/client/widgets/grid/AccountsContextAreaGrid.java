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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.gwtcx.client.resources.GridIcons;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.NavigationPaneIcons;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.data.AccountsDtoListStore;
import com.gwtcx.shared.dto.AccountsDto;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * AccountsContextAreaGrid
 */
public class AccountsContextAreaGrid extends Grid<AccountsDto> {

  public static final int SMALL_ICON_COLUMN_WIDTH = 24;

  public static final int ACCOUNT_NAME_COLUMN_WIDTH = 180;
  //   public static final int ACCOUNT_NUMBER_COLUMN_WIDTH = 90;
  //   public static final int CITY_COLUMN_WIDTH = 90;
  public static final int MAIN_PHONE_COLUMN_WIDTH = 90;
  public static final int LOCATION_COLUMN_WIDTH = 280; // 220
  public static final int PRIMARY_CONTACT_COLUMN_WIDTH = 130; // 100
  public static final int EMAIL_PRIMARY_CONTACT_COLUMN_WIDTH = 180;  // 120

  public interface AccountsProperties extends PropertyAccess<AccountsDto> {
    @Path("id")
    ModelKeyProvider<AccountsDto> key();

    ValueProvider<AccountsDto, String> id();
    ValueProvider<AccountsDto, String> accountName();
    ValueProvider<AccountsDto, String> mainPhone();
    ValueProvider<AccountsDto, String> location();
    ValueProvider<AccountsDto, String> primaryContact();
    ValueProvider<AccountsDto, String> emailPrimaryContact();
  }

  private static final AccountsProperties property = GWT.create(AccountsProperties.class);

  private static final SafeHtml ROW_ICON = ImageCell.makeImage(GridIcons.INSTANCE.rowCollapsed());
  private static final SafeHtml ENTITY_ICON = ImageCell.makeImage(NavigationPaneIcons.INSTANCE.accounts());

  public static ColumnModel<AccountsDto> getColumConfig() {

    ColumnConfig<AccountsDto, String> rowIconColumnConfig = new ColumnConfig<AccountsDto, String>(property.id(),
        SMALL_ICON_COLUMN_WIDTH, "");
    rowIconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("row-icon", imageStyle, ROW_ICON);
        sb.append(rendered);
      }
    });
    rowIconColumnConfig.setSortable(false);
    rowIconColumnConfig.setResizable(false);
    rowIconColumnConfig.setMenuDisabled(true);

    ColumnConfig<AccountsDto, String> accountIconColumnConfig = new ColumnConfig<AccountsDto, String>(property.id(),
        SMALL_ICON_COLUMN_WIDTH + 4, "");  // "#"
    accountIconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("entity-icon", imageStyle, ENTITY_ICON);
        sb.append(rendered);
      }
    });
    accountIconColumnConfig.setSortable(false);
    accountIconColumnConfig.setResizable(false);
    accountIconColumnConfig.setMenuDisabled(true);

    ColumnConfig<AccountsDto, String> accountNameColumnConfig = new ColumnConfig<AccountsDto, String>(property.accountName(),
        ACCOUNT_NAME_COLUMN_WIDTH, I18nUtil.getConstant().accountName());
    ColumnConfig<AccountsDto, String> mainPhoneColumnConfig = new ColumnConfig<AccountsDto, String>(property.mainPhone(),
        MAIN_PHONE_COLUMN_WIDTH, I18nUtil.getConstant().mainPhone());
    ColumnConfig<AccountsDto, String> locationColumnConfig = new ColumnConfig<AccountsDto, String>(property.location(),
        LOCATION_COLUMN_WIDTH, I18nUtil.getConstant().location());
    ColumnConfig<AccountsDto, String> primaryContactColumnConfig = new ColumnConfig<AccountsDto, String>(property.primaryContact(),
        PRIMARY_CONTACT_COLUMN_WIDTH, I18nUtil.getConstant().primaryContact());
    ColumnConfig<AccountsDto, String> emailPrimaryContactColumnConfig = new ColumnConfig<AccountsDto, String>(property.emailPrimaryContact(),
        EMAIL_PRIMARY_CONTACT_COLUMN_WIDTH, I18nUtil.getConstant().emailPrimaryContact());

    List<ColumnConfig<AccountsDto, ?>> columnConfigList = new ArrayList<ColumnConfig<AccountsDto, ?>>();
    columnConfigList.add(rowIconColumnConfig);
    columnConfigList.add(accountIconColumnConfig);
    columnConfigList.add(accountNameColumnConfig);
    columnConfigList.add(mainPhoneColumnConfig);
    columnConfigList.add(locationColumnConfig);
    columnConfigList.add(primaryContactColumnConfig);
    columnConfigList.add(emailPrimaryContactColumnConfig);

    ColumnModel<AccountsDto> columnModel = new ColumnModel<AccountsDto>(columnConfigList);

    return columnModel;
  }

  @Inject
  public AccountsContextAreaGrid(AccountsDtoListStore store) {
    super(store, getColumConfig());

    // Auto expand the last column (e.g. the Email Primary Contact column)
    this.getView().setAutoExpandColumn(this.getColumnModel().getColumn(this.getColumnModel().getColumnCount() - 1));
    this.setBorders(false);
    this.setStripeRows(true);
    this.setColumnLines(false);
    this.setColumnReordering(true);

    store.addAll(getAccounts());
  }

  public static List<AccountsDto> getAccounts() {

    List<AccountsDto> accounts = new ArrayList<AccountsDto>();

    accounts.add(new AccountsDto("1", "Abacus Property Group", "(02) 9253 8600", "Level 34, 264-278 George Street Sydney NSW 2000", "Dr Frank Wolf", "enquiries@abacusproperty.com.au"));
    accounts.add(new AccountsDto("2", "Adelaide Brighton Limited", "(08) 8223 8000", "Level 1, 157 Grenfell Street Adelaide SA 5000", "Mr Mark Chellew", "enquiries@adbri.com.au"));
    accounts.add(new AccountsDto("3", "AGL Energy Limited", "(02) 9921 2999", "Level 22, 101 Miller Street North Sydney NSW 2065", "Mr Michael Fraser", "enquiries@agl.com.au"));
    accounts.add(new AccountsDto("4", "Alesco Corporation Limited", "(02) 9248 2000", "Level 24, 207 Kent Street Sydney NSW 2000", "Mr Peter Boyd", "enquiries@alesco.com.au"));
    accounts.add(new AccountsDto("5", "Alumina Limited", "(03) 8699 2600", "Level 12, 60 City Road Southbank VIC 3006", "Mr John Bevan", "enquiries@alumina.com.au"));

    return accounts;
  }
}