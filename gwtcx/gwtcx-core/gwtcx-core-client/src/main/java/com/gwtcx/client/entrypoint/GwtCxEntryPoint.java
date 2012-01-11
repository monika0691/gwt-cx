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

package com.gwtcx.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * GwtCxEntryPoint entry point module.
 */
public class GwtCxEntryPoint implements EntryPoint {

  public void onModuleLoad() { }

  public static String getRelativeURL(String url) {
    // .html files are located relative to the applications host page
    // e.g. /modulename/ModuleName.html not
    //      /modulename/modulename/hosted.html
    return GWT.getHostPageBaseURL() + url;
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
