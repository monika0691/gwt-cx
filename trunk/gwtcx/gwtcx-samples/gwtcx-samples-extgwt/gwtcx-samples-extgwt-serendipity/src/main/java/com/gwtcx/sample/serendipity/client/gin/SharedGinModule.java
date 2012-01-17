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

import com.gwtcx.client.NameTokens;
import com.gwtcx.sample.serendipity.client.place.DefaultPlace;
import com.gwtcx.sample.serendipity.client.place.SerendipityPlaceManager;
import com.gwtcx.sample.serendipity.client.presenter.AccountsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ActivitiesPresenter;
import com.gwtcx.sample.serendipity.client.presenter.ErrorPagePresenter;
import com.gwtcx.sample.serendipity.client.view.AccountsView;
import com.gwtcx.sample.serendipity.client.view.ActivitiesView;
import com.gwtcx.sample.serendipity.client.view.ErrorPageView;
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

    // bind(LoggedInGatekeeper.class).in(Singleton.class);
    // bind(AdminGatekeeper.class).in(Singleton.class);

    //
    // Constants
    //

    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    // bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);

    // Bind the Main page to the default place
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.mainPage);

    //
    // Presenters
    //

    // Main Pages

    // Error Page
    bindPresenter(ErrorPagePresenter.class, ErrorPagePresenter.MyView.class,
        ErrorPageView.class, ErrorPagePresenter.MyProxy.class);

    // Sales
    bindPresenter(ActivitiesPresenter.class, ActivitiesPresenter.MyView.class,
        ActivitiesView.class, ActivitiesPresenter.MyProxy.class);

    bindPresenter(AccountsPresenter.class, AccountsPresenter.MyView.class,
        AccountsView.class, AccountsPresenter.MyProxy.class);

  }
}