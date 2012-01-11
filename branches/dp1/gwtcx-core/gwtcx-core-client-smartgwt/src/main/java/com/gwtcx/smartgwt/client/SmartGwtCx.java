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

package com.gwtcx.smartgwt.client;

import com.gwtcx.client.i18n.GwtCxConstants;
import com.gwtcx.client.i18n.GwtCxMessages;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;

public class SmartGwtCx {

  public static GwtCxConstants getConstant() {
    return I18nUtil.getConstant();
  }

  public static GwtCxMessages getMessage() {
    return I18nUtil.getMessage();
  }

  /**
   * URL to the resource.
   *
   * For example, "/toolbar/new.png"
   *
   * @param  value the resource name
   * @return       the resource url
   */
  public static String getResource(String resource) {
    return SmartGwtEntryPoint.getThemedResource(resource);
  }
}
