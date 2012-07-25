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
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.gwtplatform.mvp.client.ViewImpl;
import com.kiahu.sample.client.presenter.tablet.AboutPresenter;

public class AboutView extends ViewImpl implements AboutPresenter.MyView {

  public LayoutPanel panel;

  @Inject
  public AboutView() {
    super();

    Log.debug("AboutView()");

    createAndBindUi();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;
    RoundPanel round;

    panel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();
    round = new RoundPanel();

    round.add(new HTML("<br />"));
    round.add(new HTML("Kiahu CX - mgwt Showcase"));
    round.add(new HTML("Version 1.1.2-SNAPSHOT"));
    round.add(new HTML("<br />"));

    scrollPanel.setWidget(round);
    scrollPanel.setScrollingEnabledX(false);

    panel.add(headerPanel);
    panel.add(scrollPanel);

    headerPanel.setCenter("About");
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}