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

package com.gwtcx.extgwt.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.theme.AquaClientBundle;

/**
 * ExtGwtEntryPoint
 */
public class ExtGwtEntryPoint implements EntryPoint {

  public static final String AQUA_THEME = "aqua";

  // theme needs to initialised
  //   See AquaCssConstants
  //   and aqua.cc re use of @eval function
  protected static String theme = AQUA_THEME;

  private static boolean initialised = false;

  public void onModuleLoad() {

    if (! ExtGwtEntryPoint.initialised) {

      I18nUtil.init();

      setTheme(AQUA_THEME);

      ExtGwtEntryPoint.initialised = true;
    }
  }

  public static String getRelativeURL(String url) {
    // .html files are located relative to the applications host page
    // e.g. /modulename/ModuleName.html not
    //      /modulename/modulename/hosted.html
    return GWT.getHostPageBaseURL() + url;
  }

  public static String getTheme() {
   return theme;
  }

  public void setTheme(String theme) {
    if (theme.equalsIgnoreCase(AQUA_THEME)) {
      AquaClientBundle.INSTANCE.css().ensureInjected();
      ExtGwtEntryPoint.theme = theme;
    }
  }

  /**
   * URL to the themed resource.
   *
   * For example, "/toolbar/new.png"
   *
   * @param  value the resource name
   * @return       the resource url
   */
  public static String getThemedResource(String resource) {
    return "../" + GWT.getModuleName() + "/gwtcx/skins/" + getTheme() + "/images/" + resource;
  }

  public static native String encodeBase64(String string) /*-{
    if (!$wnd.btoa) $wnd.btoa = $wnd.base64.encode
      return $wnd.btoa(string);
  }-*/;

  public static native String decodeBase64(String string) /*-{
    if (!$wnd.atob) $wnd.atob = $wnd.base64.decode;
      return $wnd.atob(string);
  }-*/;
}
