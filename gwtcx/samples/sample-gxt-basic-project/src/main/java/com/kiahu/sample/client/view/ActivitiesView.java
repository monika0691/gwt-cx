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

package com.kiahu.sample.client.view;

import com.gwtcx.client.uihandlers.ActivitiesUiHandlers;
import com.gwtcx.extgwt.client.view.PlaceholderView;
import com.kiahu.sample.client.presenter.ActivitiesPresenter;

/**
 * ActivitiesView
 */
public class ActivitiesView extends PlaceholderView implements ActivitiesPresenter.MyView {

  // /*

  private final String html = "<div>\n"
    + "<table align=\"center\">\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n"
    + "    <td style=\"font-weight:bold;\">Placeholder Activities view</td>\n"
    + "  </tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "  <tr>\n" + "<td>&nbsp;</td>\n" + "</tr>\n"
    + "</table>\n"
    + "</div>\n";

  // */

  /*

  private final String html = "<div data-role=\"page\">\n"
      + "<div data-role=\"header\">\n"
    + "<h1>My Title</h1>\n"
    + "</div>\n"
    + "<div data-role=\"content\">\n"
    + "<ul data-role=\"listview\" data-inset=\"true\" data-filter=\"true\">\n"
    + "<li><a href=\"#\">Acura</a></li>\n"
    + "<li><a href=\"#\">Audi</a></li>\n"
    + "<li><a href=\"#\">BMW</a></li>\n"
    + "<li><a href=\"#\">Cadillac</a></li>\n"
    + "<li><a href=\"#\">Ferrari</a></li>\n" + "</ul>\n" + "</div>\n"
    + "</div>\n";

  */

  // @Override
  public void setUiHandlers(ActivitiesUiHandlers uiHandlers) {
  }

  @Override
  protected String getPanelHtml() {
    return html;
  }
}
