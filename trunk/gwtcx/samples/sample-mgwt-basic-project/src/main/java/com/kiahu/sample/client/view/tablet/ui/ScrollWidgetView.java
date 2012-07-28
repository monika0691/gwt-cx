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
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.ScrollWidgetPresenter;

public class ScrollWidgetView extends AbstractUiView implements ScrollWidgetPresenter.MyView {

  @Inject
  public ScrollWidgetView() {
    super();

    Log.debug("ScrollWidgetView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    RoundPanel roundPanel = new RoundPanel();
	roundPanel.setWidth("1000px");

	StringBuffer buffer = new StringBuffer();

	for (int i = 0; i < 5; i++) {
	  buffer.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tincidunt, arcu eget accumsan ullamcorper, ante nisl viverra enim, id consequat ante metus sed nibh. Sed orci nisl, dictum sit amet bibendum id, mollis ac arcu. Mauris venenatis orci sed dui lacinia vulputate. Proin in commodo nisl. Curabitur libero sem, tincidunt et eleifend et, euismod ac arcu. Etiam sit amet nulla mauris, id pulvinar enim. Quisque tincidunt accumsan tempor. Donec et euismod augue. Quisque ultricies mollis metus cursus consectetur. Ut sollicitudin magna in velit vulputate tempus. Sed metus metus, tincidunt nec consectetur vitae, sagittis ac velit Vestibulum consectetur, velit sed consectetur tempor, sapien odio tempor nulla, vel interdum mauris mi ac sem. Proin fermentum dictum mattis. Praesent eleifend posuere orci, vel rhoncus ante consequat eu. Vivamus eu nisl ornare nibh pellentesque fringilla. Sed tincidunt felis gravida mauris gravida sed venenatis mauris tincidunt. Pellentesque varius neque non arcu dictum consequat. Nulla vitae orci felis, ac egestas nisl. Vivamus semper sollicitudin mollis. Donec ac diam ut magna tempor consectetur. Donec at metus ligula, sed hendrerit sapien. Proin quis urna dui, id tincidunt tellus. Morbi enim ligula, mollis ut congue non, commodo nec magna. Quisque sagittis vehicula dui, ac aliquam tortor scelerisque a. Morbi urna ipsum, feugiat vitae fringilla in, blandit adipiscing tellus. Donec in est id tortor viverra viverra. Proin eu arcu sem, eget tincidunt est. Nunc in erat risus. Praesent pharetra pulvinar volutpat. Donec semper diam in enim luctus in viverra nisi tincidunt. Aliquam cursus interdum posuere.");
	}

	HTML html = new HTML(buffer.toString());
	roundPanel.add(html);
	scrollPanel.setWidget(roundPanel);

    headerPanel.setCenter(NameTokens.scrollWidget);
  }
}