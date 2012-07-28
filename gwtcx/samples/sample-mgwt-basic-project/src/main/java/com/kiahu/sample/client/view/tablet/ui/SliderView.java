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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.MSlider;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.SliderPresenter;

public class SliderView extends AbstractUiView implements SliderPresenter.MyView {

  public MSlider mSlider;
  public HTML valueField;

  @Inject
  public SliderView() {
    super();

    Log.debug("SliderView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    FlowPanel content = new FlowPanel();

	mSlider = new MSlider();
	content.add(mSlider);
	mSlider.setMax(10);

	mSlider.getElement().getStyle().setMargin(20, Unit.PX);

	valueField = new HTML("0");
	valueField.getElement().setAttribute("style", "text-align: center; width: 280px;");
	content.add(valueField);

	scrollPanel.setWidget(content);
	scrollPanel.setScrollingEnabledX(false);
	scrollPanel.setScrollingEnabledY(false);

    headerPanel.setCenter(NameTokens.slider);
  }

  @Override
  protected void bindCustomUiHandlers() {

	 Log.debug("bindCustomUiHandlers()");

	 mSlider.addValueChangeHandler(new ValueChangeHandler<Integer>() {
	  @Override
	  public void onValueChange(ValueChangeEvent<Integer> event) {
	    valueField.setText("" + event.getValue());
	  }
    });
  }
}