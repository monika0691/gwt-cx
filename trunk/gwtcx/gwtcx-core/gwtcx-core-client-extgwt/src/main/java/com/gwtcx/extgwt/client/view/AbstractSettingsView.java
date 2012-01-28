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
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.client.uihandlers.AdministrationUiHandlers;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaGrid;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.loader.XmlReader;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;

/**
 * AbstractSettingsView
 */
public abstract class AbstractSettingsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  public static final String URL_PREFIX = "/data/";
  // public static final String URL_PREFIX = GWT.getModuleName() + "/gwtcx/extgwt/" + "datasource/data/";
  public static final String FILENAME_EXTENSION = ".xml";

  protected VerticalLayoutContainer panel;
  protected ContextAreaGrid<?> grid;

  protected RequestBuilder builder;
  protected HttpProxy<ListLoadConfig> proxy;
  protected ListLoader<ListLoadConfig, ListLoadResult<ContextAreaModel>> loader ;
  protected XmlReader<ListLoadResult<ContextAreaModel>, ContextAreaModelCollection> reader;
  protected ListStore<ContextAreaModel> store;

  protected static final ContextAreaProperties property = GWT.create(ContextAreaProperties.class);

  public interface XmlAutoBeanFactory extends AutoBeanFactory {

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

  public interface ContextAreaModelCollection {
    @PropertyName("record")
    List<ContextAreaModel> getValues();
  }

  public interface ContextAreaProperties extends PropertyAccess<ContextAreaModel> {
    ValueProvider<ContextAreaModel, String> column1Icon();
    ValueProvider<ContextAreaModel, String> column1Name();
    ValueProvider<ContextAreaModel, String> column1DisplayName();
    ValueProvider<ContextAreaModel, String> column1Description();
    ValueProvider<ContextAreaModel, String> column2Icon();
    ValueProvider<ContextAreaModel, String> column2Name();
    ValueProvider<ContextAreaModel, String> column2DisplayName();
    ValueProvider<ContextAreaModel, String> column2Description();
  }

  protected String dataUrl;

  @Inject
  public AbstractSettingsView() {
    super();

    Log.debug("AbstractPagingView()");

    // panel.setStyleName(StyleTokens.contextArea);
    setPanel(new VerticalLayoutContainer());
    getPanel().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
  }

  // protected void bindCustomUiHandlers() { }

  protected void bindCustomUiHandlers() {

    assert getGrid() != null;

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

  @Override
  public Widget asWidget() {
    return panel;
  }

  public void resize() {
    panel.setSize(Window.getClientWidth() + "px", Window.getClientHeight() + "px");
    panel.onResize();
  }

  public VerticalLayoutContainer getPanel() {
    return panel;
  }

  public void setPanel(VerticalLayoutContainer panel) {
    this.panel = panel;;
  }

  public ContextAreaGrid<?> getGrid() {
    return grid;
  }

  public void setGrid(ContextAreaGrid<?> grid) {
    this.grid = grid;;
  }

  public String getDataUrl() {
    return dataUrl;
  }

  public String setDataUrl(String urlPrefix, String urlSuffix) {
    String url = urlPrefix;
    LocaleInfo localeInfo = LocaleInfo.getCurrentLocale();
    String localeName = localeInfo.getLocaleName();

    // e.g. "data/Administration_en";
    if (localeName.length() > 0) {
      url = url + "_" + localeName;
    }

    // e.g. "data/Administration_en.xml";
    url = url + urlSuffix;

    Log.debug("dataUrl: " + url);

    dataUrl = url;

    return dataUrl;
  }

  public ColumnModel<ContextAreaModel> getContextAreaColumModel() {

    ColumnConfig<ContextAreaModel, String> column1IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1Icon(),
        ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH, "");
    column1IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("margin-left: 10px; width:48px; height:48px; position:relative; cursor:pointer;");
        SafeHtml rendered = template.cell("column1Icon", imageStyle, getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column1DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column1DisplayName(),
        ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");
    column1DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

        ContextAreaModel model = (ContextAreaModel) getGrid().getStore().get(context.getIndex());
        sb.appendHtmlConstant("<span>"  + "<b>" + data.asString() + "</b><br />" + model.getColumn1Description() + "</span>");
      }
    });

    ColumnConfig<ContextAreaModel, String> column2IconColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2Icon(),
        ContextAreaGrid.LARGE_ICON_COLUMN_WIDTH, "");
    column2IconColumnConfig.setCell(new ImageCell() {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

        SafeStyles imageStyle = SafeStylesUtils.fromTrustedString("margin-left: 10px; width:48px; height:48px; position:relative; cursor:pointer;");
        SafeHtml rendered = template.cell("column2Icon", imageStyle, getIcon(data.asString()));
        sb.append(rendered);
      }
    });

    ColumnConfig<ContextAreaModel, String> column2DisplayNameColumnConfig = new ColumnConfig<ContextAreaModel, String>(property.column2DisplayName(),
        ContextAreaGrid.DISPLAY_NAME_COLUMN_WIDTH, "");
    column2DisplayNameColumnConfig.setCell(new AbstractSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance()) {
      @Override
      protected void render(Context context, SafeHtml data, SafeHtmlBuilder sb) {

        if (data == null) { return; }

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

  public SafeHtml getIcon(String data) {
    return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder48());
  }
}

/*


  public ContextAreaModelListStore getStore() {
    return store;
  }

  public void setStore(ContextAreaModelListStore store) {
    this.store = store;;
  }

    // int width = Window.getClientWidth();
    // int height = Window.getClientHeight();
    // Log.debug("resize() - width: " + width + " height: " + height);
    // panel.setSize(width + "px", height + "px");

  // protected void initToolBar() { }

  // protected void initStatusBar() { }

  // protected Grid<?> grid;

  // public void setGrid(Grid<?> grid) {
  //   this.grid = grid;;
  // }


public abstract class AbstractSettingsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String CONTEXT_AREA_WIDTH = "100%";
  public static final String CONTEXT_AREA_HEIGHT = "100%";

  protected VerticalLayoutContainer panel;

  protected final Grid<?> grid;

  @Inject
  public AbstractSettingsView(final Grid<?> grid) {
    super();

    Log.debug("AbstractPagingView()");

    this.grid = grid;

    // panel.setStyleName(StyleTokens.contextArea);
    this.panel = new VerticalLayoutContainer();
    this.panel.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);
    this.grid.setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    // add the Grid to the View's layout container
    this.panel.add(this.grid, new VerticalLayoutData(1, 1));  // 1, -1

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {

        Log.debug("execute()");

        resize();
      }
    });

    bindCustomUiHandlers();
  }

  public void resize() {

    int width = Window.getClientWidth();
    int height = Window.getClientHeight();

    Log.debug("resize() - width: " + width + " height: " + height);

    panel.setSize(width + "px", height + "px");
    panel.onResize();
  }

  protected void bindCustomUiHandlers() { }

  protected void initToolBar() { }

  protected void initStatusBar() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public Grid<?> getGrid() {
    return grid;
  }
}

*/