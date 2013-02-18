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

package com.gwtcx.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtcx.client.uihandlers.AccountsUiHandlers;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

public abstract class AbstractAccountsPresenter<V extends View, Proxy_ extends Proxy<?>> extends
    AbstractPagingPresenter<V, Proxy_> implements AccountsUiHandlers {

  private static final String HOST_FILENAME = "account.html";
  // private static final String FEATURES = "width=880, height=540, location=no";

  @Inject
  public AbstractAccountsPresenter(EventBus eventBus, V view, Proxy_ proxy,
      PlaceManager placeManager) {
    super(eventBus, view, proxy, placeManager);

    Log.warn("AbstractAccountsPresenter()");
  }

  @Override
  protected void retrieveResultSet() { }

  public void onResultSetFirstButtonClicked() {
    super.resultSetFirstButtonClicked();
  }

  public void onResultSetPreviousButtonClicked() {
    super.resultSetPreviousButtonClicked();
  }

  public void onResultSetNextButtonClicked() {
    super.resultSetNextButtonClicked();
  }

  public static void newAccount() {
    openHostFile(HOST_FILENAME, NEW, "0", FEATURES);
  }

  public void onNewButtonClicked() {
    openHostFile(HOST_FILENAME, NEW, "0", FEATURES);
  }

  public void onRecordDoubleClicked(String id) {
    openHostFile(HOST_FILENAME, EDIT, id, FEATURES);
  }

  // TO DO: refactor onExportButtonClicked()

  public static final String DEFAULT_FILE_DOWNLOAD_SERVICE_PATH = "download/";
  private static final String FILE_DOWNLOAD_HOST_FILENAME = "FileDownload.html";
  private static final String RECORD_TYPE = "recordType";

  public void onExportButtonClicked() {

    StringBuilder url = new StringBuilder();
    url.append(DEFAULT_FILE_DOWNLOAD_SERVICE_PATH).append(FILE_DOWNLOAD_HOST_FILENAME).append("?");

    String arg0Name = URL.encodeQueryString(RECORD_TYPE);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString("Account");
    url.append(arg0Value);
    // url.append(encodeBase64(arg0Value));

    Log.debug("Window.open() getRelativeURL: " + GwtCxEntryPoint.getRelativeURL(url.toString()));
    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, FEATURES);
  }

  public void onDeleteButtonClicked(String accountId) { }

  public void onRefreshButtonClicked() {
    super.refreshButtonClicked();
  }
}
