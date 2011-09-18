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
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Singleton;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.AccountInformationPresenter;
import com.gwtcx.client.presenter.AccountPagePresenter;
import com.gwtcx.client.presenter.AdminGatekeeper;
import com.gwtcx.client.presenter.EmailInformationPresenter;
import com.gwtcx.client.presenter.EmailPagePresenter;
import com.gwtcx.client.presenter.FileUploadPagePresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.client.smartgwt.view.AccountInformationView;
import com.gwtcx.client.smartgwt.view.AccountPageView;
import com.gwtcx.client.smartgwt.view.EmailInformationView;
import com.gwtcx.client.smartgwt.view.EmailPageView;
import com.gwtcx.client.smartgwt.view.FileUploadPageView;
import com.gwtcx.sample.serendipity.client.place.DefaultPlace;
import com.gwtcx.sample.serendipity.client.place.SerendipityPlaceManager;
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
import com.gwtcx.sample.serendipity.client.view.SerendipityAdministrationView;
import com.gwtcx.sample.serendipity.client.view.SerendipityCalendarView;
import com.gwtcx.sample.serendipity.client.view.SerendipityDashboardsView;
import com.gwtcx.sample.serendipity.client.view.SerendipityHighlightsView;
import com.gwtcx.sample.serendipity.client.view.SerendipityImportsView;
import com.gwtcx.sample.serendipity.client.view.SerendipityReportsView;
import com.gwtcx.sample.serendipity.client.view.SerendipityAccountsView;
import com.gwtcx.sample.serendipity.client.view.SerendipityActivitiesView;
import com.gwtcx.sample.serendipity.client.view.SerendipityErrorPageView;
import com.gwtcx.sample.serendipity.client.view.SerendipityMainPageView;
import com.gwtcx.sample.serendipity.client.view.SerendipitySignInPageView;
import com.gwtcx.shared.SharedTokens;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.DefaultProxyFailureHandler;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyFailureHandler;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

public class SerendipityClientModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);

    // Singletons
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(PlaceManager.class).to(SerendipityPlaceManager.class).in(Singleton.class);
    bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    bind(RootPresenter.class).asEagerSingleton();
    bind(ProxyFailureHandler.class).to(DefaultProxyFailureHandler.class).in(Singleton.class);

    // bind(Resources.class).in(Singleton.class);
    // bind(Translations.class).in(Singleton.class);
    // bind(CurrentUser.class).asEagerSingleton();

    bind(LoggedInGatekeeper.class).in(Singleton.class);
    bind(AdminGatekeeper.class).in(Singleton.class);

    // Constants
    // Bind the Sign In page to the default place
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signInPage);

    // Presenters

    // Sign In
    bindPresenter(SerendipitySignInPagePresenter.class, SerendipitySignInPagePresenter.MyView.class,
        SerendipitySignInPageView.class, SerendipitySignInPagePresenter.MyProxy.class);

    // Main Pages
    bindPresenter(SerendipityMainPagePresenter.class, SerendipityMainPagePresenter.MyView.class,
           SerendipityMainPageView.class, SerendipityMainPagePresenter.MyProxy.class);
    bindPresenter(AccountPagePresenter.class, AccountPagePresenter.MyView.class,
        AccountPageView.class, AccountPagePresenter.MyProxy.class);
    bindPresenter(FileUploadPagePresenter.class, FileUploadPagePresenter.MyView.class,
        FileUploadPageView.class, FileUploadPagePresenter.MyProxy.class);
    bindPresenter(EmailPagePresenter.class, EmailPagePresenter.MyView.class,
            EmailPageView.class, EmailPagePresenter.MyProxy.class);

    // Error Page
    bindPresenter(SerendipityErrorPagePresenter.class, SerendipityErrorPagePresenter.MyView.class,
        SerendipityErrorPageView.class, SerendipityErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(SerendipityActivitiesPresenter.class, SerendipityActivitiesPresenter.MyView.class,
        SerendipityActivitiesView.class, SerendipityActivitiesPresenter.MyProxy.class);
    bindPresenter(SerendipityCalendarPresenter.class, SerendipityCalendarPresenter.MyView.class,
        SerendipityCalendarView.class, SerendipityCalendarPresenter.MyProxy.class);
    bindPresenter(SerendipityDashboardsPresenter.class, SerendipityDashboardsPresenter.MyView.class,
        SerendipityDashboardsView.class, SerendipityDashboardsPresenter.MyProxy.class);
    bindPresenter(SerendipityImportsPresenter.class, SerendipityImportsPresenter.MyView.class,
        SerendipityImportsView.class, SerendipityImportsPresenter.MyProxy.class);
    bindPresenter(SerendipityAccountsPresenter.class, SerendipityAccountsPresenter.MyView.class,
        SerendipityAccountsView.class, SerendipityAccountsPresenter.MyProxy.class);
    bindPresenter(SerendipityReportsPresenter.class, SerendipityReportsPresenter.MyView.class,
        SerendipityReportsView.class, SerendipityReportsPresenter.MyProxy.class);


    bindPresenter(AccountInformationPresenter.class, AccountInformationPresenter.MyView.class,
        AccountInformationView.class, AccountInformationPresenter.MyProxy.class);

    bindPresenter(EmailInformationPresenter.class, EmailInformationPresenter.MyView.class,
        EmailInformationView.class, EmailInformationPresenter.MyProxy.class);

    // Settings
    bindPresenter(SerendipityAdministrationPresenter.class, SerendipityAdministrationPresenter.MyView.class,
        SerendipityAdministrationView.class, SerendipityAdministrationPresenter.MyProxy.class);

    // Resource Centre
    bindPresenter(SerendipityHighlightsPresenter.class, SerendipityHighlightsPresenter.MyView.class,
        SerendipityHighlightsView.class, SerendipityHighlightsPresenter.MyProxy.class);
  }
}
