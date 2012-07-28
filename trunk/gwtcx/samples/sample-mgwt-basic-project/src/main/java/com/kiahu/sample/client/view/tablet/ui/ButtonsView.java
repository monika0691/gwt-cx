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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.ButtonsPresenter;

public class ButtonsView extends AbstractUiView implements ButtonsPresenter.MyView {

  @Inject
  public ButtonsView() {
    super();

    Log.debug("ButtonsView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    FlowPanel content = new FlowPanel();
    content.getElement().getStyle().setMargin(20, Unit.PX);

    scrollPanel.setScrollingEnabledX(false);

    Button normalButton = new Button("Normal");
    content.add(normalButton);

    Button roundButton = new Button("Round");
    roundButton.setRound(true);
    content.add(roundButton);

    Button smallButton = new Button("Small");
    smallButton.setSmall(true);
    content.add(smallButton);

    HTML spacer = new HTML();
    spacer.setHeight("100px");
    content.add(spacer);

    Button importantButton = new Button("Important");
    importantButton.setImportant(true);
    content.add(importantButton);

    Button importantRoundButton = new Button("Round");
    importantRoundButton.setImportant(true);
    importantRoundButton.setRound(true);
    content.add(importantRoundButton);

    Button importantSmallButton = new Button("Small");
    importantSmallButton.setImportant(true);
    importantSmallButton.setSmall(true);
    content.add(importantSmallButton);

    spacer = new HTML();
    spacer.setHeight("100px");
    content.add(spacer);

    Button conmfirmButton = new Button("Confirm");
    conmfirmButton.setConfirm(true);
    content.add(conmfirmButton);

    Button confirmRoundButton = new Button("Round");
    confirmRoundButton.setConfirm(true);
    confirmRoundButton.setRound(true);
    content.add(confirmRoundButton);

    Button confirmSmallButton = new Button("Small");
    confirmSmallButton.setConfirm(true);
    confirmSmallButton.setSmall(true);
    content.add(confirmSmallButton);

    scrollPanel.setWidget(content);

    headerPanel.setCenter(NameTokens.buttons);
  }
}