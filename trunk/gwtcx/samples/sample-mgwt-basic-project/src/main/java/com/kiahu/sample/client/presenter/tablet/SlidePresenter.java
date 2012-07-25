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

package com.kiahu.sample.client.presenter.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;

public class SlidePresenter extends
    Presenter<SlidePresenter.MyView, SlidePresenter.MyProxy> {

  //
  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.slide)
  public interface MyProxy extends Proxy<SlidePresenter>, Place {
  }

  public interface MyView extends View {
  }

  @Inject
  public SlidePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
    super(eventBus, view, proxy);

    Log.debug("SlidePresenter()");
  }

  @Override
  protected void revealInParent() {

	Log.debug("SlidePresenter()");

    RevealAnimatableDisplayContentEvent.fire(this, MgwtRootPresenter.TYPE_SetContextAreaContent, this, getAnimation());
  }

  private Animation getAnimation(){
    return Animation.SLIDE;
  }
}