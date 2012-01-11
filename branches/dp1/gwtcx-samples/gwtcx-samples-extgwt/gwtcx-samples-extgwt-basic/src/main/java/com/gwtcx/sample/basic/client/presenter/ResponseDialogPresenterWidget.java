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

package com.gwtcx.sample.basic.client.presenter;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class ResponseDialogPresenterWidget extends
    PresenterWidget<ResponseDialogPresenterWidget.MyView> {

  public interface MyView extends PopupView {
  }

  @Inject
  public ResponseDialogPresenterWidget(final EventBus eventBus, final MyView view) {
    super(eventBus, view);

    Log.debug("ResponseDialogPresenterWidget()");
  }

  @Override
  protected void onReset() {
    super.onReset();

    Log.debug("onReset()");
  }
}
