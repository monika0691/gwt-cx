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

package com.kiahu.sample.client.view.tablet.ui;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.gwtplatform.mvp.client.ViewImpl;
import com.kiahu.sample.client.NameTokens;

public abstract class AbstractUiView extends ViewImpl {

  public LayoutPanel panel;
  public HeaderPanel headerPanel;
  public HeaderButton backButton;
  public HeaderButton navButton;
  public ScrollPanel scrollPanel;

  @Inject
  public AbstractUiView() {
    super();

    Log.debug("AbstractUiView()");

    createAndBindUi();

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    panel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    backButton = new HeaderButton();
    navButton = new HeaderButton();
    scrollPanel = new ScrollPanel();

	backButton.setBackButton(true);
	backButton.setVisible(!MGWT.getOsDetection().isAndroid());

	if (!MGWT.getOsDetection().isPhone()) {
	  headerPanel.setLeftWidget(navButton);
	  navButton.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getUtilCss().portraitonly());
	} else {
	  headerPanel.setLeftWidget(backButton);
	}

    panel.add(headerPanel);
    panel.add(scrollPanel);

    backButton.setText(NameTokens.ui);  // "UI"
    navButton.setText("Nav");
  }

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}