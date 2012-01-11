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

package com.gwtcx.smartgwt.client.theme;

import com.google.gwt.core.client.GWT;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;

/**
 * AquaCssConstants resource constants.
 */
public class AquaCssConstants {

  protected static final String moduleBaseUrl = GWT.getModuleBaseURL();
  // protected static final String urlPrefix = "gwtcx/skins/aqua/images/";
  protected static final String urlPrefix = "gwtcx/skins/" + SmartGwtEntryPoint.getTheme() + "/images/";

  /**
   * URL to the Masthead background image.
   *
   * @return  the image url
   */
  public static String getMastheadBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "masthead.png" + ")";
  }

  /**
   * URL to the Application Menu background image.
   *
   * @return  the image url
   */
  public static String getApplicationMenuBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "application_menu.png" + ")";
  }

  /**
   * URL to the Navigation Pane Header background image.
   *
   * @return  the image url
   */
  public static String getNavigationPaneHeaderBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "navigation_pane_header.png" + ")";
  }

  /**
   * URL to the ApplicationMenu Button Over background image.
   *
   * @return  the image url
   */
  public static String getApplicationMenuButtonOverBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "application_menu_button_over.png" + ")";
  }

  /**
   * URL to the ApplicationMenu Button Down background image.
   *
   * @return  the image url
   */
  public static String getApplicationMenuButtonDownBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "application_menu_button_down.png" + ")";
  }


  /**
   * URL to the NavigationPane Gridcell Over background image.
   *
   * @return  the image url
   */
  public static String getNavigationPaneGridcellOverBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "navigation_pane_gridcell_over.png" + ")";
  }

  /**
   * URL to the ToolBar background image.
   *
   * @return  the image url
   */
  public static String getToolBarBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "toolbar.png" + ")";
  }

  /**
   * URL to the Context Area background image.
   *
   * @return  the image url
   */
  public static String getContextAreaBackgroundImage() {
    return "url(" + moduleBaseUrl + urlPrefix + "context_area.png" + ")";
  }
}
