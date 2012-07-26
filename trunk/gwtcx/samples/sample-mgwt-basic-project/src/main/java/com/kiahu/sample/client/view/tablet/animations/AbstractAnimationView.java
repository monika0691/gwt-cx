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

package com.kiahu.sample.client.view.tablet.animations;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.gwtplatform.mvp.client.ViewImpl;

public abstract class AbstractAnimationView extends ViewImpl {

  public RoundPanel panel;
  public Button button;

  @Inject
  public AbstractAnimationView() {
    super();

    Log.debug("AbstractAnimationView()");

    createAndBindUi();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    panel = new RoundPanel();
    panel.getElement().setAttribute("style", "text-align:center");
	panel.setHeight("200px");

	HTML html = new HTML("<p style='text-align: center; position: relative; top: 75px; font-size: 20px'>Great, yeah!<p>");

	button = new Button();
	button.getElement().setAttribute("style", "margin:auto;width: 200px; top: 125px; position:relative;");
	button.setText("Back");

	panel.add(html);
	panel.add(button);
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}