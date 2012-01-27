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
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.Placeholders;
import com.gwtcx.client.resources.SettingsIcons;
import com.gwtcx.client.uihandlers.AdministrationUiHandlers;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaGrid;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.loader.XmlReader;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;

/**
 * AbstractAdministrationView
 */
public abstract class AbstractAdministrationView<C extends UiHandlers> extends AbstractSettingsView<C> {

  interface XmlAutoBeanFactory extends AutoBeanFactory {

    static XmlAutoBeanFactory instance = GWT.create(XmlAutoBeanFactory.class);

    AutoBean<ContextAreaModelCollection> items();
    AutoBean<ListLoadConfig> loadConfig();
  }

  public interface ContextAreaModel {

    @PropertyName("column1Icon")
    String getColumn1Icon();

    @PropertyName("column1Name")
    String getColumn1Name();

    @PropertyName("column1DisplayName")
    String getColumn1DisplayName();

    @PropertyName("column1Description")
    String getColumn1Description();

    @PropertyName("column2Icon")
    String getColumn2Icon();

    @PropertyName("column2Name")
    String getColumn2Name();

    @PropertyName("column2DisplayName")
    String getColumn2DisplayName();

    @PropertyName("column2Description")
    String getColumn2Description();
  }

  interface ContextAreaModelCollection {
    @PropertyName("record")
    List<ContextAreaModel> getValues();
  }

  interface ContextAreaProperties extends PropertyAccess<ContextAreaModel> {

   ValueProvider<ContextAreaModel, String> column1Icon();
   ValueProvider<ContextAreaModel, String> column1Name();
   ValueProvider<ContextAreaModel, String> column1DisplayName();
   ValueProvider<ContextAreaModel, String> column1Description();
   ValueProvider<ContextAreaModel, String> column2Icon();
   ValueProvider<ContextAreaModel, String> column2Name();
   ValueProvider<ContextAreaModel, String> column2DisplayName();
   ValueProvider<ContextAreaModel, String> column2Description();
  }

  private static final ContextAreaProperties property = GWT.create(ContextAreaProperties.class);

  protected ListLoader<ListLoadConfig, ListLoadResult<ContextAreaModel>> loader ;

  @Inject
  public AbstractAdministrationView() {
    super();

    Log.debug("AbstractAdministrationView()");

    String path = "data/Administration_en.xml";
    RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, path);
    HttpProxy<ListLoadConfig> proxy = new HttpProxy<ListLoadConfig>(builder);

    XmlReader<ListLoadResult<ContextAreaModel>, ContextAreaModelCollection> reader = new XmlReader<ListLoadResult<ContextAreaModel>, ContextAreaModelCollection>(
            XmlAutoBeanFactory.instance, ContextAreaModelCollection.class) {
        protected com.sencha.gxt.data.shared.loader.ListLoadResult<ContextAreaModel> createReturnData(Object loadConfig,
                ContextAreaModelCollection records) {
            return new ListLoadResultBean<ContextAreaModel>(records.getValues());
        };
    };

    ListStore<ContextAreaModel> store = new ListStore<ContextAreaModel>(new ModelKeyProvider<ContextAreaModel>() {
        @Override
        public String getKey(ContextAreaModel item) {
            // return item.getColumn1Name();
            return item.getColumn1DisplayName();
        }
    });

    loader = new ListLoader<ListLoadConfig, ListLoadResult<ContextAreaModel>>(proxy, reader);
    loader.useLoadConfig(XmlAutoBeanFactory.instance.create(ListLoadConfig.class).as());
    loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, ContextAreaModel, ListLoadResult<ContextAreaModel>>(store));

    setGrid(new ContextAreaGrid<ContextAreaModel>(store, getContextAreaColumModel()));
    getGrid().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Grid to the View's layout container
    getPanel().add(getGrid(), new VerticalLayoutData(1, 1));

    getGrid().setLoadMask(true);
    getGrid().setLoader(loader);

    loader.load();

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {
        Log.debug("execute()");
        resize();
      }
    });

    bindCustomUiHandlers();
  }

  @Override
  public Widget asWidget() {

    // loader.load();
    // getGrid().getStore().addAll(getPlaces());

    return super.asWidget();
  }

  protected void bindCustomUiHandlers() {

    // register the Gird handlers
    getGrid().addRowDoubleClickHandler(new RowDoubleClickHandler() {
      @Override
       public void onRowDoubleClick(RowDoubleClickEvent event) {

         // int rowIndex = event.getRowIndex();

         ContextAreaModel model = (ContextAreaModel) getGrid().getStore().get(event.getRowIndex());

         int columnIndex = event.getColumnIndex();
         String place = NameTokens.accounts;

         if (columnIndex >= 2) {
           place = model.getColumn2Name();
         } else {
           place = model.getColumn1Name();
         }

         // Info.display("Action", "You selected: " + place);
         Log.debug("Place", "You selected: " + place);

         rowDoubleClicked(place);
      }
    });
  }

  protected void rowDoubleClicked(String place) {
    if (getUiHandlers() != null) {
      assert getUiHandlers() instanceof AdministrationUiHandlers;
      ((AdministrationUiHandlers) getUiHandlers()).onRowDoubleClicked(place);
    }
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

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("margin-left: 10px; width:48px; height:48px; position:relative; cursor:pointer;");

        SafeHtml rendered = template.cell("image-1", imageStyle, getIcon(data.asString()));
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

        // Log.debug("context.getKey(): " + context.getKey() + " context.getIndex(): " + context.getIndex());

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

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("margin-left: 10px; width:48px; height:48px; position:relative; cursor:pointer;");

        SafeHtml rendered = template.cell("image-2", imageStyle, getIcon(data.asString()));
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

        // Log.debug("context.getKey(): " + context.getKey() + " context.getIndex(): " + context.getIndex());

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
      return ImageCell.makeImage(Placeholders.INSTANCE.placeholder48());
    }
  }
}
