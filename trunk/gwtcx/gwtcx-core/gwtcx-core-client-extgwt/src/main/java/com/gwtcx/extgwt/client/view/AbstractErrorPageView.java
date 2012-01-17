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

package com.gwtcx.extgwt.client.view;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtcx.client.uihandlers.ErrorPageUiHandlers;
import com.gwtcx.client.util.I18nUtil;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public abstract class AbstractErrorPageView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  public static final String OK_BUTTON_CONTAINER = "okButtonContainer";

  private final String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td style=\"font-weight:bold;\">An error has occurred.</td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>Try this action again. If the problem continues,</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>check the application's support forums for a solution or</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>contact the application's administrator.</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td id=\"okButtonContainer\"></td>\n"
    + "  </tr>\n"
    + "</table>\n"
    + "</div>\n";

  private final HTMLPanel panel;
  private final TextButton okButton;

  public AbstractErrorPageView() {

    panel = new HTMLPanel(getPanelHtml());

    okButton = new TextButton(I18nUtil.getConstant().ok());

    panel.add(okButton, OK_BUTTON_CONTAINER);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() {

      getOkButton().addSelectHandler(new SelectHandler() {
        @Override
        public void onSelect(SelectEvent event) {
          if (getUiHandlers() != null) {
            ((ErrorPageUiHandlers) getUiHandlers()).onOkButtonClicked();
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

  public TextButton getOkButton() {
    return okButton;
  }
}
