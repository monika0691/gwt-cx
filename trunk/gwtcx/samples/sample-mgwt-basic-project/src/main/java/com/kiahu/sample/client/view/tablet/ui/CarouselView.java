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
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.Carousel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.CarouselPresenter;

public class CarouselView extends AbstractUiView implements CarouselPresenter.MyView {

  public Carousel carousel;

  @Inject
  public CarouselView() {
    super();

    Log.debug("CarouselView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

	scrollPanel.removeFromParent();

	carousel = new Carousel();

	panel.add(carousel);

	for (int i = 0; i < 5; i++) {

	  ScrollPanel scrollPanel2 = new ScrollPanel();
	  scrollPanel2.setScrollingEnabledX(false);
	  // scrollPanel2.setWidth("100%");

	  RoundPanel flowPanel3 = new RoundPanel();

	  for (int j = 0; j < 10; j++) {
	    HTML html = new HTML("Slide: " + (i + 1));
		html.getElement().getStyle().setMarginBottom(300, Unit.PX);
		flowPanel3.add(html);
	  }

	  scrollPanel2.setWidget(flowPanel3);

	  carousel.add(scrollPanel2);
	}

    headerPanel.setCenter(NameTokens.carousel);
  }
}