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

package com.kiahu.sample.client.util;

import com.google.gwt.core.client.GWT;
import com.kiahu.sample.client.i18n.BasicProjectConstants;
import com.kiahu.sample.client.i18n.BasicProjectMessages;

public class I18nUtil {

  private static boolean initialised = false;

  private static BasicProjectConstants constants = null;
  private static BasicProjectMessages messages = null;

  public static void init() {

    if (! initialised) {
      constants = (BasicProjectConstants) GWT.create(BasicProjectConstants.class);
      messages = (BasicProjectMessages) GWT.create(BasicProjectMessages.class);

      initialised = true;
    }
  }

  public static BasicProjectConstants getConstant() {
    return constants;
  }

  public static BasicProjectMessages getMessage() {
    return messages;
  }
}
