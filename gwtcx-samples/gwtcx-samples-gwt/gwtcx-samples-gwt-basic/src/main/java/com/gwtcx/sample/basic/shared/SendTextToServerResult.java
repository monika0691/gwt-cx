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

import com.gwtplatform.dispatch.shared.Result;

public class SendTextToServerResult implements Result {

  private static final long serialVersionUID = 4621412923270714515L;

  private String response;

  public SendTextToServerResult(final String response) {
    this.response = response;
  }

  @SuppressWarnings("unused")
  private SendTextToServerResult() {
  }

  public String getResponse() {
    return response;
  }
}
