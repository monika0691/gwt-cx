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
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.client.resources.SalesIcons;
import com.gwtcx.extgwt.client.ExtGwtCx;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModelListStore;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

/**
 * NavigationPaneSectionGrid
 */
public class NavigationPaneSectionGrid extends Grid<NavigationPaneSectionModel>{

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  public static final int SMALL_ICON_COLUMN_WIDTH = 24;
  public static final int DISPLAY_NAME_COLUMN_WIDTH = 180;

  public interface NavigationPaneSectionProperties extends PropertyAccess<NavigationPaneSectionModel> {
    @Path("name")
    ModelKeyProvider<NavigationPaneSectionModel> key();

    ValueProvider<NavigationPaneSectionModel, String> icon();
    ValueProvider<NavigationPaneSectionModel, String> name();
    ValueProvider<NavigationPaneSectionModel, String> displayName();
  }

  private static final NavigationPaneSectionProperties property = GWT.create(NavigationPaneSectionProperties.class);

  private static ColumnConfig<NavigationPaneSectionModel, String> displayNameColumnConfig;

  public static ColumnModel<NavigationPaneSectionModel> getColumModel() {

    ColumnConfig<NavigationPaneSectionModel, String> iconColumnConfig = new ColumnConfig<NavigationPaneSectionModel, String>(property.icon(),
        SMALL_ICON_COLUMN_WIDTH + 4, "");
    iconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:left;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("image-1", imageStyle, getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    displayNameColumnConfig = new ColumnConfig<NavigationPaneSectionModel, String>(property.displayName(),
        DISPLAY_NAME_COLUMN_WIDTH, "");

    List<ColumnConfig<NavigationPaneSectionModel, ?>> columnConfigList = new ArrayList<ColumnConfig<NavigationPaneSectionModel, ?>>();
    columnConfigList.add(iconColumnConfig);
    columnConfigList.add(displayNameColumnConfig);

    ColumnModel<NavigationPaneSectionModel> columnModel = new ColumnModel<NavigationPaneSectionModel>(columnConfigList);

    return columnModel;
  }

  @Inject
  public NavigationPaneSectionGrid(NavigationPaneSectionModelListStore store) {
    super(store, getColumModel());

    // this.setStyleName(StyleTokens.contextGrid);
    // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
    // In order to fix this, you will need to explicitly set these widgets width and height to 100%.
    this.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    this.getView().setAutoExpandColumn(displayNameColumnConfig);
    this.setBorders(false);
    this.setColumnLines(false);
    this.setColumnReordering(false);
    this.setHideHeaders(true);
    this.setStripeRows(false);

    store.addAll(getPlaces());
  }

  public static List<NavigationPaneSectionModel> getPlaces() {

    List<NavigationPaneSectionModel> sales = new ArrayList<NavigationPaneSectionModel>();

    sales.add(new NavigationPaneSectionModel("activities", NameTokens.activities, ExtGwtCx.getConstant().activitiesMenuItemName()));
    sales.add(new NavigationPaneSectionModel("calendar", NameTokens.calendar, ExtGwtCx.getConstant().calendarMenuItemName()));
    sales.add(new NavigationPaneSectionModel("dashboards", NameTokens.dashboards, ExtGwtCx.getConstant().dashboardsMenuItemName()));
    sales.add(new NavigationPaneSectionModel("imports", NameTokens.imports, ExtGwtCx.getConstant().importsMenuItemName()));
    sales.add(new NavigationPaneSectionModel("accounts", NameTokens.accounts, ExtGwtCx.getConstant().accountsMenuItemName()));
    sales.add(new NavigationPaneSectionModel("contacts", NameTokens.contacts, ExtGwtCx.getConstant().contactsMenuItemName()));
    sales.add(new NavigationPaneSectionModel("queues", NameTokens.queues, ExtGwtCx.getConstant().queuesMenuItemName()));
    sales.add(new NavigationPaneSectionModel("reports", NameTokens.reports, ExtGwtCx.getConstant().reportsMenuItemName()));

    return sales;
  }

  private static SafeHtml getIcon(String data) {

    if ("activities".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SalesIcons.INSTANCE.activities());
    } else if ("calendar".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SalesIcons.INSTANCE.calendar());
    } else if ("dashboards".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.dashboards());
    } else if ("imports".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.imports());
    } else if ("accounts".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.accounts());
    } else if ("contacts".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.contacts());
    } else if ("queues".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.queues());
    } else if ("reports".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SalesIcons.INSTANCE.reports());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder16());
    }
  }
}