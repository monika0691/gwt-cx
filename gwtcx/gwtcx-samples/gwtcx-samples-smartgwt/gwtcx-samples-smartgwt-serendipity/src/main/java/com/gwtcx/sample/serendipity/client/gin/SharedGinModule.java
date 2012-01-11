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

import com.google.inject.Singleton;
import com.gwtcx.client.NameTokens;
import com.gwtcx.client.presenter.AccountInformationPresenter;
import com.gwtcx.client.presenter.AccountPagePresenter;
import com.gwtcx.client.presenter.AdminGatekeeper;
import com.gwtcx.client.presenter.EmailInformationPresenter;
import com.gwtcx.client.presenter.EmailPagePresenter;
import com.gwtcx.client.presenter.FileUploadPagePresenter;
import com.gwtcx.client.presenter.LoggedInGatekeeper;
import com.gwtcx.sample.serendipity.client.place.DefaultPlace;
import com.gwtcx.sample.serendipity.client.place.SerendipityPlaceManager;
import com.gwtcx.sample.serendipity.client.presenter.AccountsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ActivitiesPresenter;
import com.gwtcx.sample.serendipity.client.presenter.AdministrationPresenter;
import com.gwtcx.sample.serendipity.client.presenter.CalendarPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ErrorPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.HighlightsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ImportsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.gwtcx.sample.serendipity.client.presenter.ReportsPresenter;
import com.gwtcx.sample.serendipity.client.view.AccountsView;
import com.gwtcx.sample.serendipity.client.view.ActivitiesView;
import com.gwtcx.sample.serendipity.client.view.AdministrationView;
import com.gwtcx.sample.serendipity.client.view.CalendarView;
import com.gwtcx.sample.serendipity.client.view.ErrorPageView;
import com.gwtcx.sample.serendipity.client.view.HighlightsView;
import com.gwtcx.sample.serendipity.client.view.ImportsView;
import com.gwtcx.sample.serendipity.client.view.MainPageView;
import com.gwtcx.sample.serendipity.client.view.ReportsView;
import com.gwtcx.shared.SharedTokens;
import com.gwtcx.smartgwt.client.view.AccountInformationView;
import com.gwtcx.smartgwt.client.view.AccountPageView;
import com.gwtcx.smartgwt.client.view.EmailInformationView;
import com.gwtcx.smartgwt.client.view.EmailPageView;
import com.gwtcx.smartgwt.client.view.FileUploadPageView;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class SharedGinModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Defaults
    //

    install(new DefaultModule(SerendipityPlaceManager.class));

    //
    // Resources
    //

    // bind(SerendipityClientBundle.class).in(Singleton.class);
    // bind(Resources.class).in(Singleton.class);

    // bind(Translations.class).in(Singleton.class);
    // bind(CurrentUser.class).asEagerSingleton();

    //
    // Singletons
    //

    bind(LoggedInGatekeeper.class).in(Singleton.class);
    bind(AdminGatekeeper.class).in(Singleton.class);

    //
    // Constants
    //

    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);

    // Bind the Sign In page to the default place
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signInPage);

    //
    // Presenters
    //

    // Sign In
    // bindPresenter(SerendipitySignInPagePresenter.class, SerendipitySignInPagePresenter.MyView.class,
    //     SerendipitySignInPageDesktopView.class, SerendipitySignInPagePresenter.MyProxy.class);

    // bindPresenter(SerendipitySignInPagePresenter.class, SerendipitySignInPagePresenter.MyProxy.class);

    // bindPresenter(SerendipitySignInPagePresenter.class, SignInPageView.class,
    //     SignInPageDesktopView.class, SerendipitySignInPagePresenter.MyProxy.class);

    // Main Pages
    bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
           MainPageView.class, MainPagePresenter.MyProxy.class);
    bindPresenter(AccountPagePresenter.class, AccountPagePresenter.MyView.class,
        AccountPageView.class, AccountPagePresenter.MyProxy.class);
    bindPresenter(FileUploadPagePresenter.class, FileUploadPagePresenter.MyView.class,
        FileUploadPageView.class, FileUploadPagePresenter.MyProxy.class);
    bindPresenter(EmailPagePresenter.class, EmailPagePresenter.MyView.class,
            EmailPageView.class, EmailPagePresenter.MyProxy.class);

    // Error Page
    bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
        ErrorPageView.class, ErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class,
        ActivitiesView.class, ActivitiesPresenter.MyProxy.class);
    bindPresenter(CalendarPresenter.class, CalendarPresenter.MyView.class,
        CalendarView.class, CalendarPresenter.MyProxy.class);
    // bindPresenter(SerendipityDashboardsPresenter.class, SerendipityDashboardsPresenter.MyView.class,
    //     DashboardsDesktopView.class, SerendipityDashboardsPresenter.MyProxy.class);
    bindPresenter(ImportsPresenter.class, ImportsPresenter.MyView.class,
        ImportsView.class, ImportsPresenter.MyProxy.class);
    bindPresenter(AccountsPresenter.class, AccountsPresenter.MyView.class,
        AccountsView.class, AccountsPresenter.MyProxy.class);
    bindPresenter(ReportsPresenter.class, ReportsPresenter.MyView.class,
        ReportsView.class, ReportsPresenter.MyProxy.class);


    bindPresenter(AccountInformationPresenter.class, AccountInformationPresenter.MyView.class,
        AccountInformationView.class, AccountInformationPresenter.MyProxy.class);

    bindPresenter(EmailInformationPresenter.class, EmailInformationPresenter.MyView.class,
        EmailInformationView.class, EmailInformationPresenter.MyProxy.class);

    // Settings
    bindPresenter(AdministrationPresenter.class, AdministrationPresenter.MyView.class,
        AdministrationView.class, AdministrationPresenter.MyProxy.class);

    // Resource Centre
    bindPresenter(HighlightsPresenter.class, HighlightsPresenter.MyView.class,
        HighlightsView.class, HighlightsPresenter.MyProxy.class);
  }
}

/*

   Installing DefaultModule saves you from having to perform all the following bindings:

    // Singletons
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    bind(RootPresenter.class).asEagerSingleton();
    bind(PlaceManager.class).to(SerendipityPlaceManager.class).in(Singleton.class);
    // @deprecated bind(ProxyFailureHandler.class).to(DefaultProxyFailureHandler.class).in(Singleton.class);
    // see AsyncCallFailEvent
    // bind(GoogleAnalytics.class).to(GoogleAnalyticsImpl.class).in(Singleton.class);

    // bind(Resources.class).in(Singleton.class);
    // bind(Translations.class).in(Singleton.class);
    // bind(CurrentUser.class).asEagerSingleton();

*/
