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

package com.gwtcx.client.i18n;

import com.google.gwt.i18n.client.Messages;

/**
 * GwtCxMessages interface to represent the messages contained in a resource bundle.
 */
public interface GwtCxMessages extends Messages {

  @DefaultMessage("{0} of {1} selected")
  String selected(int arg0, int arg1);

  @DefaultMessage("Page {0}")
  String page(int arg0);

}
