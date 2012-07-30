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

package com.kiahu.sample.client.view.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.gwtplatform.mvp.client.ViewImpl;
import com.kiahu.sample.client.presenter.tablet.AboutPresenter;

public class AboutView extends ViewImpl implements AboutPresenter.MyView {

  public LayoutPanel panel;
  public HeaderPanel headerPanel;
  public HeaderButton backButton;
  public HeaderButton navButton;
  public ScrollPanel scrollPanel;

  @Inject
  public AboutView() {
    super();

    Log.debug("AboutView()");

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

	RoundPanel round = new RoundPanel();

    round.add(new HTML("<br />"));
    round.add(new HTML("mgwt Showcase"));
    round.add(new HTML("Version 1.1.2-SNAPSHOT"));
    round.add(new HTML("Using GWT, GWTP and mgwt to build mobile apps"));
    round.add(new HTML("<br />"));
    round.add(new HTML("<a target='_blank' href='http://www.kiahu.com'>Kiahu.com</a>"));
    round.add(new HTML("<br />"));

    scrollPanel.setWidget(round);
    scrollPanel.setScrollingEnabledX(false);

    panel.add(headerPanel);
    panel.add(scrollPanel);

    backButton.setText("Home");
    navButton.setText("Nav");

    headerPanel.setCenter("About");
  }

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");

    navButton.addTapHandler(new TapHandler() {
      @Override
      public void onTap(TapEvent event) {
        // eventBus.fireEvent(new ShowMasterEvent(eventId));
      }
    });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}