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

package com.gwtcx.client.util;

import com.google.gwt.core.client.GWT;
import com.gwtcx.client.i18n.GwtCxConstants;
import com.gwtcx.client.i18n.GwtCxMessages;

/**
 * I18nUtil utility class.
 */
public class I18nUtil {

  private static boolean initialised = false;

  private static GwtCxConstants constants = null;
  private static GwtCxMessages messages = null;

  /**
   * Initialise gwt-cx i18n.
   */
  public static void init() {

    if (! initialised) {
      constants = (GwtCxConstants) GWT.create(GwtCxConstants.class);
      messages = (GwtCxMessages) GWT.create(GwtCxMessages.class);

      initialised = true;
    }
  }

  public static GwtCxConstants getConstant() {
    return constants;
  }

  public static GwtCxMessages getMessage() {
    return messages;
  }
}
