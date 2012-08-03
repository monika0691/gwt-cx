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

package com.kiahu.sample.client.entrypoint;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort.DENSITY;
import com.gwtcx.client.NameTokens;

public class MainPageEntryPoint extends MultiPageEntryPoint {

  private static SimplePanel westPanel;
  private static SimplePanel centerPanel;

  public static SimplePanel getWestPanel() {
    return westPanel;
  }

  public static SimplePanel getCenterPanel() {
    return centerPanel;
  }

  @Override
  protected void revealCurrentPlace(String page) {

	Log.debug("revealCurrentPlace()");

	createTabletDisplay();

    if (page.equals(NameTokens.mainPage)) {
      getBasicProjectGinjector().getPlaceManager().revealCurrentPlace();
    } else {
      Log.debug("Page name token: " + page);
    }
  }

  private void createTabletDisplay() {

    Log.debug("createTabletDisplay()");

    // see AbstractMainPageDesktopView
    ViewPort viewPort = new MGWTSettings.ViewPort();
    viewPort.setTargetDensity(DENSITY.MEDIUM);
    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

    MGWTSettings settings = new MGWTSettings();
    settings.setViewPort(viewPort);
    settings.setIconUrl("logo.png");
    settings.setAddGlosToIcon(true);
    settings.setFullscreen(true);
    settings.setPreventScrolling(true);
    MGWT.applySettings(settings);

    westPanel = new SimplePanel();
    westPanel.getElement().setId("NavigationPane");
    westPanel.getElement().addClassName("landscapeonly");

    centerPanel = new SimplePanel();
    centerPanel.getElement().setId("ContextArea");

    RootLayoutPanel.get().clear();
	RootPanel.get().clear();

    RootPanel.get().add(westPanel);
    RootPanel.get().add(centerPanel);
  }
}