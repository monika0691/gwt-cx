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

import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.SettingsIcons;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtcx.extgwt.client.data.ContextAreaModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * ContextAreaGrid
 */
public class ContextAreaGrid extends Grid<ContextAreaModel>{

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  // public static final int LARGE_ICON_SIZE = 48;
  public static final int LARGE_ICON_COLUMN_WIDTH = 60;  // 80
  public static final int DISPLAY_NAME_COLUMN_WIDTH = 420;  // 180

  public interface ContextAreaProperties extends PropertyAccess<ContextAreaModel> {
    @Path("column1Name")
    ModelKeyProvider<ContextAreaModel> key();

    ValueProvider<ContextAreaModel, String> column1Icon();
    ValueProvider<ContextAreaModel, String> column1Name();
    ValueProvider<ContextAreaModel, String> column1DisplayName();
    ValueProvider<ContextAreaModel, String> column2Icon();
    ValueProvider<ContextAreaModel, String> column2Name();
    ValueProvider<ContextAreaModel, String> column2DisplayName();
  }

  @Inject
  public ContextAreaGrid(ContextAreaModelListStore store, ColumnModel<ContextAreaModel> columnModel) {
    super(store, columnModel);

    // this.setStyleName(StyleTokens.contextGrid);
    // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
    // In order to fix this, you will need to explicitly set these widgets width and height to 100%.
    this.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.getView().setAutoExpandColumn(this.getColumnModel().getColumn(1)); // 1
    this.setBorders(false);
    this.setColumnLines(false);
    this.setColumnReordering(false);
    this.setHideHeaders(true);
    this.setStripeRows(false);

    // this.setSelectionModel(new CellSelectionModel<ContextAreaModel>());

    store.addAll(getPlaces());
  }

  // @Inject
  // public ContextAreaGrid(ContextAreaModelListStore store) {
  //   this(store, getColumModel());
  // }

  public static List<ContextAreaModel> getPlaces() {

    List<ContextAreaModel> administration = new ArrayList<ContextAreaModel>();

    administration.add(new ContextAreaModel(
      "announcements", NameTokens.announcements, ExtGwtCx.getConstant().announcementsMenuItemName(),
      "Create, edit and delete announcements.",

      "autonumbering", NameTokens.autoNumbering, ExtGwtCx.getConstant().autoNumberingMenuItemName(),
      "Specify the prefix for quotes, orders and invoices."));

    administration.add(new ContextAreaModel(
      "businessunits", NameTokens.businessUnits, ExtGwtCx.getConstant().businessUnitsMenuItemName(),
      "Add new business units. Edit and deactivate business units.<br /> Change the parent business unit.",

      "systemsettings", NameTokens.systemSettings, ExtGwtCx.getConstant().systemSettingsMenuItemName(),
      "Set the format for various values, such as numbers, the calendar and currency."));

    administration.add(new ContextAreaModel(
       "users", NameTokens.users, ExtGwtCx.getConstant().usersMenuItemName(),
      "Add new users. Edit information about users and deactivate user records. <br /> Manage the teams and roles assigned to users.",

      "teams", NameTokens.teams, ExtGwtCx.getConstant().teamsMenuItemName(),
      "Add new teams and new team members to existing teams. <br /> Modify the team description and delete members from teams."));

    administration.add(new ContextAreaModel(
      "privacypreferences", NameTokens.privacyPreferences, ExtGwtCx.getConstant().privacyPreferencesMenuItemName(),
      "Set the privacy preferences for the organisation.",

      "productupdates", NameTokens.productUpdates, ExtGwtCx.getConstant().productUpdatesMenuItemName(),
      "Sign up to be notified of product updates."));

    return administration;
  }

  public static SafeHtml getIcon(String data) {
    if ("announcements".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.announcements());
    } else if ("autonumbering".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.autoNumbering());
    } else if ("businessunits".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.businessUnits());
    } else if ("systemsettings".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.systemSettings());
    } else if ("users".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.users());
    } else if ("teams".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.teams());
    } else if ("privacypreferences".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.privacyPreferences());
    } else if ("productupdates".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.productUpdates());
    } else {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.placeholder());
    }
  }
}

/*


  private static final ContextAreaProperties property = GWT.create(ContextAreaProperties.class);

  // private static ColumnConfig<ContextAreaModel, String> column1DisplayNameColumnConfig;
  // private static ColumnConfig<ContextAreaModel, String> column2DisplayNameColumnConfig;

  public static ColumnModel<ContextAreaModel> getColumModel() {

    // Column 1

    ColumnConfig<ContextAreaModel, String> column1IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1Icon(),
        LARGE_ICON_COLUMN_WIDTH + 4, "");
    column1IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:center;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("image-1", imageStyle, getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column1DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1DisplayName(),
        DISPLAY_NAME_COLUMN_WIDTH, "");
    column1DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        Log.debug("context.getKey()" + context.getKey());

        sb.appendHtmlConstant("<span>" + data.asString() + "</span>");

      }
    });

    // Column 2

    ColumnConfig<ContextAreaModel, String> column2IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2Icon(),
        LARGE_ICON_COLUMN_WIDTH + 4, "");
    column2IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:center;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("image-2", imageStyle, getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column2DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2DisplayName(),
        DISPLAY_NAME_COLUMN_WIDTH, "");

    List<ColumnConfig<ContextAreaModel, ?>> columnConfigList = new ArrayList<ColumnConfig<ContextAreaModel, ?>>();
    columnConfigList.add(column1IconColumnConfig);
    columnConfigList.add(column1DisplayNameColumnConfig);
    columnConfigList.add(column2IconColumnConfig);
    columnConfigList.add(column2DisplayNameColumnConfig);

    ColumnModel<ContextAreaModel> columnModel = new ColumnModel<ContextAreaModel>(columnConfigList);

    return columnModel;
  }

*/