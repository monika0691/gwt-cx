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

package com.gwtcx.sample.basic.client.view.mobile;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.sample.basic.client.presenter.MainPagePresenter;
import com.gwtcx.sample.basic.client.view.MainPageUiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;

public class MainPageMobileView extends ViewWithUiHandlers<MainPageUiHandlers> implements MainPagePresenter.MyView {

  private static String html = "<h1>Basic Web Application Starter Project</h1>\n"
      + "<table align=\"center\">\n"
      + "  <tr>\n"
      + "    <td colspan=\"2\" style=\"font-weight:bold;\">Please enter your (Mobile) name:</td>\n"
      + "  </tr>\n"
      + "  <tr>\n"
      + "    <td id=\"nameFieldContainer\"></td>\n"
      + "    <td id=\"sendButtonContainer\"></td>\n"
      + "  </tr>\n"
      + "  <tr>\n"
      + "    <td colspan=\"2\" style=\"color:red;\" id=\"errorLabelContainer\"></td>\n"
      + "  </tr>\n" + "</table>\n";

  HTMLPanel panel = new HTMLPanel(html);

  private final Label errorLabel;
  private final TextField nameField;
  private final TextButton sendButton;

  @Inject
  public MainPageMobileView() {

    sendButton = new TextButton("Send");
    nameField = new TextField();
    nameField.setText("Robinyo");
    errorLabel = new Label();

    sendButton.addStyleName("sendButton");

    panel.add(nameField, "nameFieldContainer");
    panel.add(sendButton, "sendButtonContainer");
    panel.add(errorLabel, "errorLabelContainer");

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

    sendButton.addSelectHandler(new SelectHandler() {
        @Override
        public void onSelect(SelectEvent event) {
          if (getUiHandlers() != null) {
            sendButton.disable();
            getUiHandlers().onSendButtonClicked();
          }
        }
    });
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
  public void resetAndFocus() {
    nameField.focus();
    nameField.selectAll();
    sendButton.enable();
  }

  @Override
  public void setError(String errorText) {
    errorLabel.setText(errorText);
  }
}
