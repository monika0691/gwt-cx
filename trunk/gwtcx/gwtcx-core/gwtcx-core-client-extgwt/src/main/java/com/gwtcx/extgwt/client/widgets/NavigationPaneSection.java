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

package com.gwtcx.extgwt.client.widgets;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.extgwt.client.data.NavigationPaneSectionModel;
import com.gwtcx.extgwt.client.widgets.grid.NavigationPaneSectionGrid;
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
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;

/**
 * NavigationPaneSection
 */
public class NavigationPaneSection extends ContentPanel {

  // public static final String NAVIGATION_PANE_WIDTH = "100%";
  // public static final String NAVIGATION_PANE_HEIGHT = "100%";

  public static final String URL_PREFIX = GWT.getModuleName() + "/gwtcx/extgwt/" + "data/";
  public static final String FILENAME_EXTENSION = ".xml";

  protected NavigationPaneSectionGrid grid;

  protected RequestBuilder builder;
  protected HttpProxy<ListLoadConfig> proxy;
  protected ListLoader<ListLoadConfig, ListLoadResult<NavigationPaneSectionModel>> loader ;
  protected XmlReader<ListLoadResult<NavigationPaneSectionModel>, NavigationPaneSectionModelCollection> reader;
  protected ListStore<NavigationPaneSectionModel> store;

  protected final String filename;
  protected String dataUrl;

  protected static final NavigationPaneSectionModelProperties property = GWT.create(NavigationPaneSectionModelProperties.class);

  public interface XmlAutoBeanFactory extends AutoBeanFactory {

    static XmlAutoBeanFactory instance = GWT.create(XmlAutoBeanFactory.class);

    AutoBean<NavigationPaneSectionModelCollection> items();
    AutoBean<ListLoadConfig> loadConfig();
  }

  public interface NavigationPaneSectionModelCollection {
    @PropertyName("record")
    List<NavigationPaneSectionModel> getValues();
  }

  public interface NavigationPaneSectionModelProperties extends PropertyAccess<NavigationPaneSectionModel> {
    ValueProvider<NavigationPaneSectionModel, String> icon();
    ValueProvider<NavigationPaneSectionModel, String> name();
    ValueProvider<NavigationPaneSectionModel, String> displayName();
  }

  private static AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

  @Inject
  public NavigationPaneSection(final String filename) {
    super(appearance);

    this.filename = filename;

    this.builder = new RequestBuilder(RequestBuilder.GET, setDataUrl(URL_PREFIX + getFilename(), FILENAME_EXTENSION));

    this.proxy = new HttpProxy<ListLoadConfig>(builder);

    this.reader = new XmlReader<ListLoadResult<NavigationPaneSectionModel>, NavigationPaneSectionModelCollection>(XmlAutoBeanFactory.instance, NavigationPaneSectionModelCollection.class) {
        protected com.sencha.gxt.data.shared.loader.ListLoadResult<NavigationPaneSectionModel> createReturnData(Object loadConfig,
                NavigationPaneSectionModelCollection records) {
          return new ListLoadResultBean<NavigationPaneSectionModel>(records.getValues());
        };
    };

    this.store = new ListStore<NavigationPaneSectionModel>(new ModelKeyProvider<NavigationPaneSectionModel>() {
        @Override
        public String getKey(NavigationPaneSectionModel item) {
          // Log.debug("getKey(NavigationPaneSectionModel item): " + item.getName());
          return item.getName();
        }
    });

    this.loader = new ListLoader<ListLoadConfig, ListLoadResult<NavigationPaneSectionModel>>(this.proxy, this.reader);
    this.loader.useLoadConfig(XmlAutoBeanFactory.instance.create(ListLoadConfig.class).as());
    this.loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, NavigationPaneSectionModel, ListLoadResult<NavigationPaneSectionModel>>(this.store));

    setGrid(new NavigationPaneSectionGrid(store, getColumModel()));
    // getGrid().setSize(NAVIGATION_PANE_WIDTH, NAVIGATION_PANE_HEIGHT);

    getGrid().setLoadMask(true);
    getGrid().setLoader(getLoader());

    getLoader().load();

    // add the Grid to the Panel's layout container
    this.add(getGrid());  // , new VerticalLayoutData(1, 1));
  }

  public NavigationPaneSectionGrid getGrid() {
    return grid;
  }

  public void addRowClickHandler(RowClickHandler handler) {
    getGrid().addRowClickHandler(handler);
  }

  public NavigationPaneSectionModel getSelectedRecord() {
     return getGrid().getSelectionModel().getSelectedItem();
  }

  /*

  public String getSelectedRecord() {

    String name = "";

    NavigationPaneSectionModel model = getGrid().getSelectionModel().getSelectedItem();

    if (model != null) {
      name = model.getName();
    }

    return name;
  }

  */

  /*

  public int getSelectedRecord() {

    int rowIndex = -1;

    NavigationPaneSectionModel model = getGrid().getSelectionModel().getSelectedItem();

    if (model != null) {
      rowIndex = store.indexOf(model);
    }

    return rowIndex;
  }

  */

  public void selectRecord(int rowIndex) {
    getGrid().getSelectionModel().select(rowIndex, false);
  }


  public void setGrid(NavigationPaneSectionGrid grid) {
    this.grid = grid;;
  }

  protected String getFilename() {
    return filename;
  }

  public RequestBuilder getBuilder() {
    return builder;
  }

  public void setBuilder(RequestBuilder builder) {
    this.builder = builder;
  }

  public HttpProxy<ListLoadConfig> getProxy() {
    return proxy;
  }

  public void setProxy(HttpProxy<ListLoadConfig> proxy) {
    this.proxy = proxy;
  }

  public ListLoader<ListLoadConfig, ListLoadResult<NavigationPaneSectionModel>> getLoader() {
    return loader;
  }

  public void setLoader(ListLoader<ListLoadConfig, ListLoadResult<NavigationPaneSectionModel>> loader) {
    this.loader = loader;
  }

  public XmlReader<ListLoadResult<NavigationPaneSectionModel>, NavigationPaneSectionModelCollection> getReader() {
    return reader;
  }

  public void setReader(XmlReader<ListLoadResult<NavigationPaneSectionModel>, NavigationPaneSectionModelCollection> reader) {
    this.reader = reader;
  }

  public ListStore<NavigationPaneSectionModel> getStore() {
    return store;
  }

  public void setStore(ListStore<NavigationPaneSectionModel> store) {
    this.store = store;
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

  public ColumnModel<NavigationPaneSectionModel> getColumModel() {

    ColumnConfig<NavigationPaneSectionModel, String> iconColumnConfig = new ColumnConfig<NavigationPaneSectionModel, String>(property.icon(),
        NavigationPaneSectionGrid.SMALL_ICON_COLUMN_WIDTH + 4, "");
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

    ColumnConfig<NavigationPaneSectionModel, String> displayNameColumnConfig = new ColumnConfig<NavigationPaneSectionModel, String>(property.displayName(),
        NavigationPaneSectionGrid.DISPLAY_NAME_COLUMN_WIDTH, "");

    List<ColumnConfig<NavigationPaneSectionModel, ?>> columnConfigList = new ArrayList<ColumnConfig<NavigationPaneSectionModel, ?>>();
    columnConfigList.add(iconColumnConfig);
    columnConfigList.add(displayNameColumnConfig);

    ColumnModel<NavigationPaneSectionModel> columnModel = new ColumnModel<NavigationPaneSectionModel>(columnConfigList);

    return columnModel;
  }

  public SafeHtml getIcon(String data) {
    return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder16());
  }
}

/*

public class NavigationPaneSection extends ContentPanel {

  private static AccordionLayoutAppearance appearance = GWT.<AccordionLayoutAppearance> create(AccordionLayoutAppearance.class);

  protected TreeStore<NavigationPaneSectionModel> store;
  protected Tree<NavigationPaneSectionModel, String> tree;

  public NavigationPaneSection() {
    super(appearance);

    store = new TreeStore<NavigationPaneSectionModel>(NavigationPaneSectionModel.KP);

    tree = new Tree<NavigationPaneSectionModel, String>(store,
        new ValueProvider<NavigationPaneSectionModel, String>() {

          @Override
          public String getValue(NavigationPaneSectionModel object) {
            return object.getName();
          }

          @Override
          public void setValue(NavigationPaneSectionModel object, String value) {
          }

          @Override
          public String getPath() {
            return "name";
          }
        });

    tree.setIconProvider(new IconProvider<NavigationPaneSectionModel>() {
        public ImageResource getIcon(NavigationPaneSectionModel model) {
          if (null == model.getIcon()) {
            return null;
          } else if ("activities".equalsIgnoreCase(model.getIcon())) {
            return SalesIcons.INSTANCE.activities();
          } else if ("calendar".equalsIgnoreCase(model.getIcon())) {
            return SalesIcons.INSTANCE.calendar();
          } else {
            return SalesIcons.INSTANCE.activities();
          }
        }
      });

    NavigationPaneSectionModel model = newItem(null,      // icon
        ExtGwtCx.getConstant().activitiesMenuItemName(),  // name
        ExtGwtCx.getConstant().activitiesMenuItemName()); // displayName
    store.add(model);

    store.add(newItem(null, ExtGwtCx.getConstant().calendarMenuItemName(), ExtGwtCx.getConstant().calendarMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().dashboardsMenuItemName(), ExtGwtCx.getConstant().dashboardsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().importsMenuItemName(), ExtGwtCx.getConstant().importsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().accountsMenuItemName(), ExtGwtCx.getConstant().accountsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().contactsMenuItemName(), ExtGwtCx.getConstant().contactsMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().queuesMenuItemName(), ExtGwtCx.getConstant().queuesMenuItemName()));
    store.add(newItem(null, ExtGwtCx.getConstant().reportsMenuItemName(), ExtGwtCx.getConstant().reportsMenuItemName()));

    add(tree);
  }

  private NavigationPaneSectionModel newItem(String icon, String name, String displayName) {
    return new NavigationPaneSectionModel(icon, name, displayName);
  }

  public void addRecordClickHandler(SimpleSafeHtmlCell<String> cell) {
    tree.setCell(cell);
  }
}

*/