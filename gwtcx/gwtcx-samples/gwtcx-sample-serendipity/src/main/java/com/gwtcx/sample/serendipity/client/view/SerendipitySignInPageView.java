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

package com.gwtcx.sample.serendipity.client.view;

import com.gwtcx.client.smartgwt.view.SignInPageView;
import com.gwtcx.client.smartgwt.view.handlers.SignInPageUiHandlers;
import com.gwtcx.sample.serendipity.client.presenter.SerendipitySignInPagePresenter;

public class SerendipitySignInPageView extends SignInPageView<SignInPageUiHandlers> 
    implements SerendipitySignInPagePresenter.MyView {

  private static final String DEFAULT_USER_NAME = "Administrator";
  private static final String DEFAULT_PASSWORD = "N0More$ecrets";

  private static String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td colspan=\"2\" style=\"font-weight:bold;\">Sign In <img src=\"images/signin.gif\"/></td>\n"
    + "  </tr>\n"
    + "  <tr>\n"
    + "    <td>User name</td>\n"
    + "    <td id=\"userNameFieldContainer\"></td>\n"
    + "  </tr>\n"
    + "  <tr>\n"
    + "    <td>Password</td>\n"
    + "    <td id=\"passwordFieldContainer\"></td>\n"
    + "  </tr>\n"
    + "  <tr>\n"
    + "    <td></td>\n"
    + "    <td id=\"signInButtonContainer\"></td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td colspan=\"2\">Forget your password?</td>\n"
    + "  </tr>\n"
    + "  <tr>\n"
    + "    <td colspan=\"2\">Contact your Serendipity administrator.</td>\n"
    + "  </tr>\n"
    + "</table>\n"
    + "</div>\n";

	
  public SerendipitySignInPageView() {
    super();  
    
    getUserName().setText(DEFAULT_USER_NAME);
    getPassword().setText(DEFAULT_PASSWORD); 
  }
  
  @Override
  protected String getPanelHtml() {
    return html;
  }
}
