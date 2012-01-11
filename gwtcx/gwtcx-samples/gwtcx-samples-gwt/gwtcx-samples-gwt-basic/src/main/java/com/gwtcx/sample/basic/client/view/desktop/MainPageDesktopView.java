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

package com.gwtcx.sample.basic.client.view.desktop;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import com.gwtcx.sample.basic.client.presenter.MainPagePresenter;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainPageDesktopView extends ViewImpl implements MainPagePresenter.MyView {

  private static String html = "<h1>Basic Web Application Starter Project</h1>\n"
      + "<table align=\"center\">\n"
      + "  <tr>\n"
      + "    <td colspan=\"2\" style=\"font-weight:bold;\">Please enter your (Desktop) name:</td>\n"
      + "  </tr>\n"
      + "  <tr>\n"
      + "    <td id=\"nameFieldContainer\"></td>\n"
      + "    <td id=\"sendButtonContainer\"></td>\n"
      + "  </tr>\n"
      + "  <tr>\n"
      + "    <td colspan=\"2\" style=\"color:red;\" id=\"errorLabelContainer\"></td>\n"
      + "  </tr>\n" + "</table>\n";

  HTMLPanel panel = new HTMLPanel(html);

  private final Button sendButton;
  private final TextBox nameField;
  private final Label errorLabel;

  @Inject
  public MainPageDesktopView() {

    sendButton = new Button("Send");
    nameField = new TextBox();
    nameField.setText("Robinyo");
    errorLabel = new Label();

    sendButton.addStyleName("sendButton");

    panel.add(nameField, "nameFieldContainer");
    panel.add(sendButton, "sendButtonContainer");
    panel.add(errorLabel, "errorLabelContainer");
  }

  @Override
  public Widget asWidget() {
    return panel;
  }

  @Override
  public String getName() {
    return nameField.getText();
  }

  @Override
  public Button getSendButton() {
    return sendButton;
  }

  @Override
  public void resetAndFocus() {
    nameField.setFocus(true);
    nameField.selectAll();
  }

  @Override
  public void setError(String errorText) {
    errorLabel.setText(errorText);
  }
}
