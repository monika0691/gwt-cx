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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.WidgetList;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.FormsPresenter;

public class FormsView extends AbstractUiView implements FormsPresenter.MyView {

  @Inject
  public FormsView() {
    super();

    Log.debug("FormsView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    FlowPanel container = new FlowPanel();

	HTML header = new HTML("Contact Data");
	header.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());

	container.add(header);

	WidgetList widgetList = new WidgetList();
	widgetList.setRound(true);

	widgetList.add(new FormListEntry("First Name", new MTextBox()));
	widgetList.add(new FormListEntry("Last Name", new MTextBox()));
	widgetList.add(new FormListEntry("Title", new MTextBox()));

	container.add(widgetList);

	scrollPanel.setScrollingEnabledX(false);
	scrollPanel.setWidget(container);
	// workaround for android formfields jumping around when using
	// -webkit-transform
	scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());

    headerPanel.setCenter(NameTokens.forms);
  }
}