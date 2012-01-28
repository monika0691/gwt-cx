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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.client.resources.SettingsIcons;
import com.gwtcx.extgwt.client.widgets.grid.ContextAreaGrid;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.data.client.loader.HttpProxy;
import com.sencha.gxt.data.client.loader.XmlReader;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.ListLoadConfig;
import com.sencha.gxt.data.shared.loader.ListLoadResult;
import com.sencha.gxt.data.shared.loader.ListLoadResultBean;
import com.sencha.gxt.data.shared.loader.ListLoader;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

/**
 * AbstractDataManagementView
 */
public abstract class AbstractDataManagementView<C extends UiHandlers> extends AbstractSettingsView<C> {

  private static final String FILENAME = "DataManagement";

  @Inject
  public AbstractDataManagementView() {
    super();

    Log.debug("AbstractDataManagementView()");

    builder = new RequestBuilder(RequestBuilder.GET, setDataUrl(URL_PREFIX + FILENAME, FILENAME_EXTENSION));

    proxy = new HttpProxy<ListLoadConfig>(builder);

    reader = new XmlReader<ListLoadResult<ContextAreaModel>, ContextAreaModelCollection>(XmlAutoBeanFactory.instance, ContextAreaModelCollection.class) {
        protected com.sencha.gxt.data.shared.loader.ListLoadResult<ContextAreaModel> createReturnData(Object loadConfig,
            ContextAreaModelCollection records) {
          return new ListLoadResultBean<ContextAreaModel>(records.getValues());
        };
    };

    store = new ListStore<ContextAreaModel>(new ModelKeyProvider<ContextAreaModel>() {
        @Override
        public String getKey(ContextAreaModel item) {
          return item.getColumn1DisplayName();  // return item.getColumn1Name();
        }
    });

    loader = new ListLoader<ListLoadConfig, ListLoadResult<ContextAreaModel>>(proxy, reader);
    loader.useLoadConfig(XmlAutoBeanFactory.instance.create(ListLoadConfig.class).as());
    loader.addLoadHandler(new LoadResultListStoreBinding<ListLoadConfig, ContextAreaModel, ListLoadResult<ContextAreaModel>>(store));

    setGrid(new ContextAreaGrid<ContextAreaModel>(store, getContextAreaColumModel()));
    getGrid().setSize(CONTEXT_AREA_WIDTH, CONTEXT_AREA_HEIGHT);

    getGrid().setLoadMask(true);
    getGrid().setLoader(loader);

    loader.load();

    // add the Grid to the View's layout container
    getPanel().add(getGrid(), new VerticalLayoutData(1, 1));

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {
        Log.debug("execute()");
        resize();
      }
    });

    bindCustomUiHandlers();
  }

  /*

  @Override
  public SafeHtml getIcon(String data) {

    if ("data_maps".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.dataMaps());
    } else if ("data_imports".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.dataImports());
    } else if ("data_import_templates".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.dataImportTemplates());
    } else if ("sample_data".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.sampleData());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder48());
    }
  }

  */
}
