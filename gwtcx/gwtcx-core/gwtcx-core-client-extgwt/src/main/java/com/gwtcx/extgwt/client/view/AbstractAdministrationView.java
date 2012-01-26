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

package com.gwtcx.extgwt.client.view;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.uihandlers.AdministrationUiHandlers;
import com.gwtcx.extgwt.client.data.ContextAreaModel;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaGrid;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaGrid.ContextAreaProperties;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaModelListStore;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * AbstractAdministrationView
 */
public abstract class AbstractAdministrationView<C extends UiHandlers> extends AbstractSettingsView<C> {

  private static final ContextAreaProperties property = GWT.create(ContextAreaProperties.class);


  @Inject
  public AbstractAdministrationView() {
    super();

    Log.debug("AbstractAdministrationView()");

    this.setGrid(new ContextAreaGrid(new ContextAreaModelListStore(), getContextAreaColumModel()));
    this.grid.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Grid to the View's layout container
    this.panel.add(this.grid, new VerticalLayoutData(1, 1));

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {

        Log.debug("execute()");

        resize();
      }
    });

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    // register the Gird handlers
    getGrid().addRowDoubleClickHandler(new RowDoubleClickHandler() {
      @Override
       public void onRowDoubleClick(RowDoubleClickEvent event) {

         // int rowIndex = event.getRowIndex();

         ContextAreaModel model = (ContextAreaModel) getGrid().getStore().get(event.getRowIndex());

         int columnIndex = event.getColumnIndex();
         String place = NameTokens.activities;

         if (columnIndex >= 2) {
           place = model.getColumn2Name();
         } else {
           place = model.getColumn1Name();
         }

         Info.display("Action", "You selected: " + place);

         rowDoubleClicked(place);
      }
    });
  }

  protected void rowDoubleClicked(String place) {
    if (getUiHandlers() != null) {
      assert getUiHandlers() instanceof AdministrationUiHandlers;
      // ((AdministrationUiHandlers) getUiHandlers()).onRowDoubleClicked(place);
    }
  }

  public void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    panel.setSize(width + "px", height + "px");
    panel.onResize();
  }

  public ColumnModel<ContextAreaModel> getContextAreaColumModel() {

    // Column 1

    ColumnConfig<ContextAreaModel, String> column1IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1Icon(),
            ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH, "");
    column1IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("width:48px; height:48px; float:center; cursor:pointer;");

        SafeHtml rendered = template.cell("image-1", imageStyle, ContextAreaGrid.getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column1DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1DisplayName(),
            ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");
    column1DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        Log.debug("context.getKey(): " + context.getKey() + " context.getIndex(): " + context.getIndex());

        ContextAreaModel model = (ContextAreaModel) getGrid().getStore().get(context.getIndex());

        sb.appendHtmlConstant("<span>"  + "<b>" + data.asString() + "</b><br />" + model.getColumn1Description() + "</span>");
      }
    });

    // Column 2

    ColumnConfig<ContextAreaModel, String> column2IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2Icon(),
            ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH, "");
    column2IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("width:48px; height:48px; float:center; cursor:pointer;");

        SafeHtml rendered = template.cell("image-2", imageStyle, ContextAreaGrid.getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column2DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2DisplayName(),
            ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");
    column2DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        Log.debug("context.getKey(): " + context.getKey() + " context.getIndex(): " + context.getIndex());

        ContextAreaModel model = (ContextAreaModel) getGrid().getStore().get(context.getIndex());

        sb.appendHtmlConstant("<span>"  + "<b>" + data.asString() + "</b><br />" + model.getColumn2Description() + "</span>");
      }
     });

    List<ColumnConfig<ContextAreaModel, ?>> columnConfigList = new ArrayList<ColumnConfig<ContextAreaModel, ?>>();
    columnConfigList.add(column1IconColumnConfig);
    columnConfigList.add(column1DisplayNameColumnConfig);
    columnConfigList.add(column2IconColumnConfig);
    columnConfigList.add(column2DisplayNameColumnConfig);

    ColumnModel<ContextAreaModel> columnModel = new ColumnModel<ContextAreaModel>(columnConfigList);

    return columnModel;
  }
}

/*

  public static ColumnModel<ContextAreaModel> getColumModel() {

    // Column 1

    ColumnConfig<ContextAreaModel, String> column1IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1Icon(),
            ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH + 4, "");
    column1IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:center;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("image-1", imageStyle, ContextAreaGrid.getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column1DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1DisplayName(),
            ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");
    column1DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        Log.debug("context.getKey(): " + context.getKey());

        sb.appendHtmlConstant("<span>" + data.asString() + "</span>");

      }
    });

    // Column 2

    ColumnConfig<ContextAreaModel, String> column2IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2Icon(),
            ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH + 4, "");
    column2IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) {
          return;
        }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("float:center;cursor:hand;cursor:pointer;");

        SafeHtml rendered = template.cell("image-2", imageStyle, ContextAreaGrid.getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column2DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2DisplayName(),
            ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");

    List<ColumnConfig<ContextAreaModel, ?>> columnConfigList = new ArrayList<ColumnConfig<ContextAreaModel, ?>>();
    columnConfigList.add(column1IconColumnConfig);
    columnConfigList.add(column1DisplayNameColumnConfig);
    columnConfigList.add(column2IconColumnConfig);
    columnConfigList.add(column2DisplayNameColumnConfig);

    ColumnModel<ContextAreaModel> columnModel = new ColumnModel<ContextAreaModel>(columnConfigList);

    return columnModel;
  }


*/

