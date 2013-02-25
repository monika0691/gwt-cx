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
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.gwtcx.client.NameTokens;

public class EntryPointDispatcher implements EntryPoint {

  public void onModuleLoad() {

    Log.debug("EntryPointDispatcher - onModuleLoad()");

    try {

      // get the Host Page name
      Dictionary dictionary = Dictionary.getDictionary("Pages");
      String page = dictionary.get("page");

      Log.debug("Page name token: " + page);

      if (page.equals(NameTokens.mainPage)) {
        MultiPageEntryPoint entrypoint = (MultiPageEntryPoint) GWT.create(MainPageEntryPoint.class);
        entrypoint.onModuleLoad();
      }
      else if (page.equals(NameTokens.accountPage)) {
        MultiPageEntryPoint entrypoint = (MultiPageEntryPoint) GWT.create(AccountPageEntryPoint.class);
        entrypoint.onModuleLoad();
      }
      else if (page.equals(NameTokens.contactPage)) {
        MultiPageEntryPoint entrypoint = (MultiPageEntryPoint) GWT.create(ContactPageEntryPoint.class);
        entrypoint.onModuleLoad();
      }
    } catch (Exception e) {
      Log.error("e: " + e);
      e.printStackTrace();

      Window.alert(e.getLocalizedMessage());
    }
  }
}
