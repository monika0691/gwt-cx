/**
 * (C) Copyright 2012 Kiahu
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

package com.kiahu.sample.client.gin;

import com.gwtcx.client.NameTokens;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.kiahu.sample.client.place.BasicProjectPlaceManager;
import com.kiahu.sample.client.place.DefaultPlace;

//
// Bind the various classes and providers using a Guice module. The module class
// looks almost exactly like it would in regular Guice (except we use GinModule
// and AbstractGinModule instead of Module and AbstractModule.)
// Note: GWTP's AbstractPresenterModule extends AbstractGinModule
// See: http://code.google.com/p/google-gin/wiki/GinTutorial#Step_3._Declare_bindings
//
public class SharedGinModule extends AbstractPresenterModule {

  @Override
  protected void configure() {

    //
    // Defaults
    //

    install(new DefaultModule(BasicProjectPlaceManager.class));

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
    // bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.signInPage);
    bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.mainPage);

    //
    // Presenters
    //

  }
}