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

import com.gwtcx.client.uihandlers.ReportsUiHandlers;
import com.gwtcx.extgwt.client.view.PlaceholderView;
import com.gwtcx.sample.serendipity.client.presenter.ReportsPresenter;

/**
 * ReportsView
 */
public class ReportsView extends PlaceholderView implements ReportsPresenter.MyView {

  private final String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td style=\"font-weight:bold;\">Placeholder Reports view</td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "</table>\n"
    + "</div>\n";

  @Override
  public void setUiHandlers(ReportsUiHandlers uiHandlers) {
  }

  @Override
  protected String getPanelHtml() {
    return html;
  }
}

/*

import com.google.inject.Inject;
import com.gwtcx.sample.serendipity.client.presenter.ReportsPresenter;
import com.gwtcx.client.uihandlers.ReportsUiHandlers;
import com.gwtcx.extgwt.client.view.AbstractReportsView;
import com.gwtcx.extgwt.client.widgets.ToolBar;
import com.gwtcx.extgwt.client.widgets.grid.AccountsContextAreaGrid;

public class ReportsView extends AbstractReportsView<ReportsUiHandlers> implements
    ReportsPresenter.MyView {

  @Inject
  public ReportsView(ToolBar toolBar, AccountsContextAreaGrid grid) {
    super(toolBar, grid);

  }

  // @Override
  // protected void initToolBar() { }

  // @Override
  // protected void initStatusBar() { }
}

*/