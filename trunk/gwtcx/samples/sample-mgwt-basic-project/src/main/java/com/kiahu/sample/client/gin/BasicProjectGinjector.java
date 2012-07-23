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

import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.kiahu.sample.client.presenter.tablet.AnimationsPresenter;
import com.kiahu.sample.client.presenter.tablet.MainPageTabletPresenter;

//
// Create a method for each object type you want to create, and the an implementation
// of the interface gets generated for you at compile time.
// See: http://code.google.com/p/google-gin/wiki/GinTutorial#Step_2._Defining_the_Ginjector
//
public interface BasicProjectGinjector extends Ginjector {

  EventBus getEventBus();
  PlaceManager getPlaceManager();

  // Error Page
  // AsyncProvider<ErrorPagePresenter> getErrorPagePresenter();

  Provider<MainPageTabletPresenter> getMainPageTabletPresenter();
  AsyncProvider<AnimationsPresenter> getAnimationsPresenter();

}