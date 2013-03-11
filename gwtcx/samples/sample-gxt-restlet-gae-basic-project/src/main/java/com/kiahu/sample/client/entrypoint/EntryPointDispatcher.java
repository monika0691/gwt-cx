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

  public static final String HOST_FILE_PAGES_VAR = "Pages";
  public static final String PAGE_VAR = "page";

  enum Page
  {
     MAIN_PAGE(NameTokens.mainPage),
     ACCOUNT_PAGE(NameTokens.accountPage),
     CONTACT_PAGE(NameTokens.contactPage),
     LOOKUP_PAGE(NameTokens.lookupPage),
     NOT_FOUND("notFound");

     private Page(String stringValue) { this.stringValue = stringValue; }
     public String toString() { return stringValue; }

     private String stringValue;
  }

  public Page getPageAsEnum(String pageName) {

    Page result = Page.NOT_FOUND;

    Log.debug("Page name: " + pageName);

    for (Page section : Page.values()) {
      if (pageName.contentEquals(section.toString())) {
        result = section;
      }
    }

    return result;
  }

  public void onModuleLoad() {

    Log.debug("onModuleLoad()");

    try {

      MultiPageEntryPoint entrypoint = null;

      // get the Page name from the application's host file
      Dictionary dictionary = Dictionary.getDictionary(HOST_FILE_PAGES_VAR);
      Page page = getPageAsEnum(dictionary.get(PAGE_VAR));

      switch (page) {

        case MAIN_PAGE: entrypoint = (MultiPageEntryPoint) GWT.create(MainPageEntryPoint.class); break;

        case ACCOUNT_PAGE: entrypoint = (MultiPageEntryPoint) GWT.create(AccountPageEntryPoint.class); break;

        case CONTACT_PAGE: entrypoint = (MultiPageEntryPoint) GWT.create(ContactPageEntryPoint.class); break;

        default:
          break;
      }

      if (entrypoint != null) {
        entrypoint.onModuleLoad();
      } else {
        Log.error("Did you forget to update the host file's Pages var?");
      }

    } catch (Exception e) {
      Log.error("e: " + e);
      e.printStackTrace();

      Window.alert(e.getLocalizedMessage());
    }
  }

}
