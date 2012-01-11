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
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.gwtcx.sample.serendipity.client.presenter.DashboardsPresenter;
import com.gwtcx.sample.serendipity.client.presenter.MainPagePresenter;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public interface SerendipityGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();

  // Sign In
  // Provider<SignInPagePresenter> getSignInPagePresenter();

  // Main Page(s)
  Provider<MainPagePresenter> getMainPagePresenter();

  // Error Page
  // AsyncProvider<ErrorPagePresenter> getErrorPagePresenter();

  // Sales
  AsyncProvider<DashboardsPresenter> getDashboardsPresenter();
}