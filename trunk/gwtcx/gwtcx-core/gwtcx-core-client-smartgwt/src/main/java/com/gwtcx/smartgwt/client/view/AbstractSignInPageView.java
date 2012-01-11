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

package com.gwtcx.smartgwt.client.view;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtcx.client.uihandlers.SignInPageUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.smartgwt.client.util.FieldVerifier;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public abstract class AbstractSignInPageView extends ViewWithUiHandlers<SignInPageUiHandlers> implements SignInPageView {

  public static final String USER_NAME_FIELD_CONTAINER = "userNameFieldContainer";
  public static final String PASSWORD_FIELD_CONTAINER = "passwordFieldContainer";
  public static final String SIGNIN_BUTTON_CONTAINER = "signInButtonContainer";

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
    + "    <td colspan=\"2\">Contact your application administrator.</td>\n"
    + "  </tr>\n"
    + "</table>\n"
    + "</div>\n";

  private HTMLPanel panel;

  protected final TextBox userName;
  protected final PasswordTextBox password;
  protected final Button signInButton;

  public AbstractSignInPageView() {

    panel = new HTMLPanel(getPanelHtml());

    userName = new TextBox();
    password = new PasswordTextBox();
    signInButton = new Button(I18nUtil.getConstant().signIn());

    panel.add(userName, USER_NAME_FIELD_CONTAINER);
    panel.add(password, PASSWORD_FIELD_CONTAINER);
    panel.add(signInButton, SIGNIN_BUTTON_CONTAINER);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    signInButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {

        if (FieldVerifier.isValidUserName(getUserName().getText()) &&
           (FieldVerifier.isValidPassword(getPassword().getText()))) {
          if (getUiHandlers() != null) {
            signInButton.disable();
            ((SignInPageUiHandlers) getUiHandlers()).onSignInButtonClicked();
          }
        }
        else {
          event.cancel();
          SC.say(I18nUtil.getConstant().signIn(), I18nUtil.getConstant().signInPrompt());
          resetAndFocus();
        }
      }
    });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  protected String getPanelHtml() {
    return html;
  }

  public TextBox getUserName() {
    return userName;
  }

  public String getUserNameText() {
    return getUserName().getText();
  }

  public PasswordTextBox getPassword() {
    return password;
  }

  public String getPasswordText() {
    return getPassword().getText();
  }

  public void resetAndFocus() {
    userName.setFocus(true);
    userName.selectAll();
    signInButton.enable();
  }

  public void say(String string) {
    // SC.say("Error", string);
    SC.warn(string);
  }
}

/*


public abstract class AbstractSignInPageView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String USER_NAME_FIELD_CONTAINER = "userNameFieldContainer";
  public static final String PASSWORD_FIELD_CONTAINER = "passwordFieldContainer";
  public static final String SIGNIN_BUTTON_CONTAINER = "signInButtonContainer";

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
    + "    <td colspan=\"2\">Contact your application administrator.</td>\n"
    + "  </tr>\n"
    + "</table>\n"
    + "</div>\n";

  private HTMLPanel panel;

  protected final TextBox userName;
  protected final PasswordTextBox password;
  protected final Button signInButton;

  public AbstractSignInPageView() {

    panel = new HTMLPanel(getPanelHtml());

    userName = new TextBox();
    password = new PasswordTextBox();
    signInButton = new Button(I18nUtil.getConstant().signIn());

    panel.add(userName, USER_NAME_FIELD_CONTAINER);
    panel.add(password, PASSWORD_FIELD_CONTAINER);
    panel.add(signInButton, SIGNIN_BUTTON_CONTAINER);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    signInButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {

        if (FieldVerifier.isValidUserName(getUserName().getText()) &&
           (FieldVerifier.isValidPassword(getPassword().getText()))) {
          if (getUiHandlers() != null) {
            signInButton.disable();
            ((SignInPageUiHandlers) getUiHandlers()).onSignInButtonClicked();
          }
        }
        else {
          event.cancel();
          SC.say(I18nUtil.getConstant().signIn(), I18nUtil.getConstant().signInPrompt());
          resetAndFocus();
        }
      }
    });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  protected String getPanelHtml() {
    return html;
  }

  public TextBox getUserName() {
    return userName;
  }

  public String getUserNameText() {
    return getUserName().getText();
  }

  public PasswordTextBox getPassword() {
    return password;
  }

  public String getPasswordText() {
    return getPassword().getText();
  }

  public void resetAndFocus() {
    userName.setFocus(true);
    userName.selectAll();
    signInButton.enable();
  }

  public void say(String string) {
    // SC.say("Error", string);
    SC.warn(string);
  }
}


*/



