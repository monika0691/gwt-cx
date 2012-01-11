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

package com.gwtcx.sample.basic.shared;

import com.gwtplatform.dispatch.shared.UnsecuredActionImpl;

public class SendTextToServer extends
    UnsecuredActionImpl<SendTextToServerResult> {

  private static final long serialVersionUID = 4621412923270714515L;

  private String textToServer;

  public SendTextToServer(final String textToServer) {
    this.textToServer = textToServer;
  }

  @SuppressWarnings("unused")
  private SendTextToServer() {
  }

  public String getTextToServer() {
    return textToServer;
  }
}
