/**
 * (C) Copyright 2010-2013 Kiahu
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
import com.gwtcx.extgwt.client.data.ContactsDto;
import com.gwtcx.extgwt.client.data.ContactsDtoListStore;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * AccountsContextAreaGrid
 */
public class ContactsContextAreaGrid extends Grid<ContactsDto> {

  public static final int SMALL_ICON_COLUMN_WIDTH = 24;

  public static final int FULL_NAME_COLUMN_WIDTH = 180;
  public static final int PARENT_CUSTOMER_COLUMN_WIDTH = 160;
  public static final int CITY_COLUMN_WIDTH = 100;
  // public static final int LOCATION_COLUMN_WIDTH = 280;
  public static final int PHONE_COLUMN_WIDTH = 90;
  public static final int BUSINESS_PHONE_COLUMN_WIDTH = 90;
  public static final int EMAIL_COLUMN_WIDTH = 180;

  public interface ContactsProperties extends PropertyAccess<ContactsDto> {
    @Path("id")
    ModelKeyProvider<ContactsDto> key();

    ValueProvider<ContactsDto, String> id();
    ValueProvider<ContactsDto, String> fullName();
    ValueProvider<ContactsDto, String> parentCustomer();
    ValueProvider<ContactsDto, String> city();
    ValueProvider<ContactsDto, String> location();
    ValueProvider<ContactsDto, String> phone();
    ValueProvider<ContactsDto, String> businessPhone();
    ValueProvider<ContactsDto, String> email();
  }

  private static final ContactsProperties property = GWT.create(ContactsProperties.class);

  private static final SafeHtml ROW_ICON = ImageCell.makeImage(GridIcons.INSTANCE.rowCollapsed());
  private static final SafeHtml ENTITY_ICON = ImageCell.makeImage(NavigationPaneIcons.INSTANCE.contacts());

  public static ColumnModel<ContactsDto> getColumnConfig() {

    ColumnConfig<ContactsDto, String> rowIconColumnConfig = new ColumnConfig<ContactsDto, String>(property.id(),
        SMALL_ICON_COLUMN_WIDTH, "");
    rowIconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");
        SafeHtml rendered = template.cell("row-icon", imageStyle, ROW_ICON);

        sb.append(rendered);
      }
    });
    rowIconColumnConfig.setSortable(false);
    rowIconColumnConfig.setResizable(false);
    rowIconColumnConfig.setMenuDisabled(true);

    ColumnConfig<ContactsDto, String> entityIconColumnConfig = new ColumnConfig<ContactsDto, String>(property.id(),
        SMALL_ICON_COLUMN_WIDTH + 4, "");
    entityIconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");
        SafeHtml rendered = template.cell("entity-icon", imageStyle, ENTITY_ICON);

        sb.append(rendered);
      }
    });
    entityIconColumnConfig.setSortable(false);
    entityIconColumnConfig.setResizable(false);
    entityIconColumnConfig.setMenuDisabled(true);

    ColumnConfig<ContactsDto, String> fullNameColumnConfig = new ColumnConfig<ContactsDto, String>(property.fullName(),
        FULL_NAME_COLUMN_WIDTH, I18nUtil.getConstant().fullName());
    ColumnConfig<ContactsDto, String> parentCustomerColumnConfig = new ColumnConfig<ContactsDto, String>(property.parentCustomer(),
        PARENT_CUSTOMER_COLUMN_WIDTH, I18nUtil.getConstant().parentCustomer());
    ColumnConfig<ContactsDto, String> cityColumnConfig = new ColumnConfig<ContactsDto, String>(property.city(),
        CITY_COLUMN_WIDTH, I18nUtil.getConstant().city());
    // ColumnConfig<ContactsDto, String> locationColumnConfig = new ColumnConfig<ContactsDto, String>(property.location(),
    //     LOCATION_COLUMN_WIDTH, I18nUtil.getConstant().location());
    ColumnConfig<ContactsDto, String> phoneColumnConfig = new ColumnConfig<ContactsDto, String>(property.phone(),
        PHONE_COLUMN_WIDTH, I18nUtil.getConstant().phone());
    ColumnConfig<ContactsDto, String> businessPhoneColumnConfig = new ColumnConfig<ContactsDto, String>(property.businessPhone(),
        BUSINESS_PHONE_COLUMN_WIDTH, I18nUtil.getConstant().businessPhone());
    ColumnConfig<ContactsDto, String> emailColumnConfig = new ColumnConfig<ContactsDto, String>(property.email(),
        EMAIL_COLUMN_WIDTH, I18nUtil.getConstant().email());

    List<ColumnConfig<ContactsDto, ?>> columnConfigList = new ArrayList<ColumnConfig<ContactsDto, ?>>();
    columnConfigList.add(rowIconColumnConfig);
    columnConfigList.add(entityIconColumnConfig);
    columnConfigList.add(fullNameColumnConfig);
    columnConfigList.add(parentCustomerColumnConfig);
    columnConfigList.add(cityColumnConfig);
    columnConfigList.add(phoneColumnConfig);
    columnConfigList.add(businessPhoneColumnConfig);
    columnConfigList.add(emailColumnConfig);

    ColumnModel<ContactsDto> columnModel = new ColumnModel<ContactsDto>(columnConfigList);

    return columnModel;
  }

  @Inject
  public ContactsContextAreaGrid(ContactsDtoListStore store) {
    super(store, getColumnConfig());

    this.setBorders(false);
    this.setColumnReordering(true);

    // Auto expand the last column (e.g. the Email column)
    this.getView().setAutoExpandColumn(this.getColumnModel().getColumn(this.getColumnModel().getColumnCount() - 1));
    this.getView().setColumnLines(false);
    this.getView().setStripeRows(true);


    this.store.addAll(getAccounts());
  }

  public static List<ContactsDto> getAccounts() {

    List<ContactsDto> accounts = new ArrayList<ContactsDto>();

    accounts.add(new ContactsDto("1", "Dr Frank Wolf", "Abacus Property Group", "Sydney", "Level 34, 264-278 George Street Sydney NSW 2000", "0414 414 515", "(02) 9253 8600", "enquiries@abacus.com.au"));
    accounts.add(new ContactsDto("2", "Mr Mark Chellew", "Adelaide Brighton Limited", "Adelaide", "Level 1, 157 Grenfell Street Adelaide SA 5000", "0414 515 515", "(08) 8223 8000", "enquiries@adbri.com.au"));
    accounts.add(new ContactsDto("3", "Mr Michael Fraser", "AGL Energy Limited", "North Sydney", "Level 22, 101 Miller Street North Sydney NSW 2065", "0414 114 115", "(02) 9921 2999", "enquiries@agl.com.au"));
    accounts.add(new ContactsDto("4", "Mr Peter Boyd", "Alesco Corporation Limited", "Sydney", "Level 24, 207 Kent Street Sydney NSW 2000", "0414 233 332", "(02) 9248 2000", "enquiries@alesco.com.au"));
    accounts.add(new ContactsDto("5", "Mr John Bevan", "Alumina Limited", "Southbank", "Level 12, 60 City Road Southbank VIC 3006", "0414 456 345", "(03) 8699 2600", "enquiries@alumina.com.au"));

    return accounts;
  }
}