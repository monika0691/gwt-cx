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

package com.gwtcx.sample.serendipity.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtcx.client.presenter.AccountInformationPresenter;
import com.gwtcx.client.presenter.AccountPagePresenter;
import com.gwtcx.client.presenter.AdminGatekeeper;
import com.gwtcx.client.presenter.EmailInformationPresenter;
import com.gwtcx.client.presenter.EmailPagePresenter;
import com.gwtcx.client.presenter.FileUploadPagePresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityAdministrationPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityCalendarPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityDashboardsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityHighlightsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityImportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityReportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityAccountsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityActivitiesPresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityErrorPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipityMainPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.SerendipitySignInPagePresenter;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyFailureHandler;

@GinModules({DispatchAsyncModule.class, SerendipityClientModule.class})
public interface SerendipityGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();
  // Resources getResources();
  // DispatchAsync getDispatcher();
  // ProxyFailureHandler getProxyFailureHandler();
  // CurrentUser getCurrentUser();
  // Translations getTranslations();

  LoggedInGatekeeper getLoggedInGatekeeper();
  AdminGatekeeper    getAdminGatekeeper();

  // Sign In
  Provider<SerendipitySignInPagePresenter> getSignInPagePresenter();

  // Main Page(s)
  AsyncProvider<SerendipityMainPagePresenter> getSerendipityMainPagePresenter();

  Provider<AccountPagePresenter> getAccountPagePresenter();
  Provider<FileUploadPagePresenter> getFileUploadPagePresenter();
  Provider<EmailPagePresenter> getEmailPagePresenter();

  // Error Page
  AsyncProvider<SerendipityErrorPagePresenter> getErrorPagePresenter();

  // Sales
  AsyncProvider<SerendipityActivitiesPresenter> getActivitiesPresenter();
  AsyncProvider<SerendipityCalendarPresenter> getCalendarPresenter();
  AsyncProvider<SerendipityDashboardsPresenter> getDashboardsPresenter();
  AsyncProvider<SerendipityImportsPresenter> getImportsPresenter();
  AsyncProvider<SerendipityAccountsPresenter> getAccountsPresenter();
  AsyncProvider<SerendipityReportsPresenter> getReportsPresenter();

  AsyncProvider<AccountInformationPresenter> getAccountInformationPresenter();
  AsyncProvider<EmailInformationPresenter> getEmailInformationPresenter();

  // Settings
  AsyncProvider<SerendipityAdministrationPresenter> getAdministrationPresenter();

  // Resource Centre
  AsyncProvider<SerendipityHighlightsPresenter> getHighlightsPresenter();

  ProxyFailureHandler getProxyFailureHandler();
}
