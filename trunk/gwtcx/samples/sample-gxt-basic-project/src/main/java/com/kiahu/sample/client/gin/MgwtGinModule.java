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

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;
import com.kiahu.sample.client.presenter.MgwtRootPresenter;

/**
 * Module with default MGWT bindings. You can
 * {@code install(new MgwttModule(MyPlaceManager.class))}
 * instead of manually binding the different classes to their default implementation.
 */
public class MgwtGinModule extends AbstractGinModule {

  private final Class<? extends PlaceManager> placeManagerClass;

  public MgwtGinModule(Class<? extends PlaceManager> placeManagerClass) {
    this.placeManagerClass = placeManagerClass;
  }

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(TokenFormatter.class).to(ParameterTokenFormatter.class).in(Singleton.class);
    // bind(RootPresenter.class).asEagerSingleton();
    bind(MgwtRootPresenter.class).asEagerSingleton();
    // bind(GoogleAnalytics.class).to(GoogleAnalyticsImpl.class).in(Singleton.class);
    bind(PlaceManager.class).to(placeManagerClass).in(Singleton.class);
  }
}
