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

package com.kiahu.sample.client.entrypoint;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;

public class AccountPageEntryPoint extends MultiPageEntryPoint {

  @Override
  protected void revealCurrentPlace(String page) {

    if (page.equals(NameTokens.accountPage)) {
      PlaceRequest placeRequest = new PlaceRequest(NameTokens.accountPage);
      getBasicProjectGinjector().getPlaceManager().revealPlace(placeRequest);
    } else {
      Log.debug("Page name token: " + page);
    }
  }
}