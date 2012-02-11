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

package com.gwtcx.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
// import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.gwtcx.client.entrypoint.GwtCxEntryPoint;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;

/**
 * AbstractPagingPresenter
 */
public abstract class AbstractPagingPresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> {

  public static final int DEFAULT_MAX_RESULTS = 50;

  public static final String ID = "id";
  public static final String ACTIVITY = "activity";
  public static final String NEW = "new";
  public static final String EDIT = "edit";
  public static final String PARAMETER_SEPERATOR = "&";
  public static final String NAME = "_blank";
  public static final String FEATURES = "width=880, height=540, location=no";

  private final DispatchAsync dispatcher;
  private final PlaceManager placeManager;

  private int maxResults;
  private int firstResult;
  private int pageNumber;
  private int numberOfElements;

  @Inject
  public AbstractPagingPresenter(EventBus eventBus, V view, Proxy_ proxy, DispatchAsync dispatcher, PlaceManager placeManager) {
    super(eventBus, view, proxy);

    this.dispatcher = dispatcher;
    this.placeManager = placeManager;
  }

  @Override
  protected void onBind() {
    super.onBind();

    maxResults = DEFAULT_MAX_RESULTS;
    firstResult = 0;
    pageNumber = 1;
    numberOfElements = maxResults;

    retrieveResultSet();
  }

  protected void retrieveResultSet() {
    Log.warn("Don't forget to @Override retrieveResultSet()");
  }

  protected void refreshButtonClicked() {
    retrieveResultSet();
  }

  protected void resultSetFirstButtonClicked() {
    firstResult = 0;
    pageNumber = 1;

    retrieveResultSet();
  }

  protected void resultSetPreviousButtonClicked() {
    firstResult -= maxResults;
    pageNumber--;

    retrieveResultSet();
  }

  protected void resultSetNextButtonClicked() {
    firstResult += numberOfElements;
    pageNumber++;

    retrieveResultSet();
  }

  public static void openHostFile(String filename, String queryString, String id, String features) {

    StringBuilder url = new StringBuilder();
    url.append(filename).append("?");

    String arg0Name = URL.encodeQueryString(ID);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(id);
    url.append(GwtCxEntryPoint.encodeBase64(arg0Value));
    Log.debug("Window.open() arg0Value: " + arg0Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg0Value));
    url.append(PARAMETER_SEPERATOR);

    String arg1Name = URL.encodeQueryString(ACTIVITY);
    url.append(arg1Name);
    url.append("=");
    String arg1Value = URL.encodeQueryString(queryString);
    url.append(GwtCxEntryPoint.encodeBase64(arg1Value));
    Log.debug("Window.open() arg1Value: " + arg1Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg1Value));

    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, features);
  }

  // /*

  @Override
  protected void revealInParent() {

    Log.warn("Don't forget to @Override revealInParent()");

    // For example:
    // RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetContextAreaContent, this);
  }

  // */

  protected DispatchAsync getDispatcher() {
    return dispatcher;
  }

  protected PlaceManager getPlaceManager() {
    return placeManager;
  }

  protected int getMaxResults() {
    return maxResults;
  }

  protected void setMaxResults(int maxResults) {
    this.maxResults = maxResults;
  }

  protected int getFirstResult() {
    return firstResult;
  }

  protected void setFirstResult(int firstResult) {
    this.firstResult = firstResult;
  }

  protected int getPageNumber() {
    return pageNumber;
  }

  protected void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  protected int getNumberOfElements() {
    return numberOfElements;
  }

  protected void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
  }
}

/*

    // un-comment the following lines (and comment out the lines above) if you want
    // to open the new View in the current browser window

    // PlaceRequest placeRequest = new PlaceRequest(NameTokens.accountPage);
    // placeRequest = placeRequest.with(ACTIVITY, encodeBase64(EDIT)).with(AccountsRecord.ACCOUNT_ID, encodeBase64(accountId));
    // placeManager.revealPlace(placeRequest);

*/