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
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ActionButton;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarSpacer;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBarText;
import com.googlecode.mgwt.ui.client.widget.buttonbar.TrashButton;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.ButtonBarPresenter;

public class ButtonBarView extends AbstractUiView implements ButtonBarPresenter.MyView {

  public ButtonBar footerPanel;

  @Inject
  public ButtonBarView() {
    super();

    Log.debug("ButtonBarView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

	footerPanel = new ButtonBar();

	footerPanel.add(new ActionButton());
	footerPanel.add(new ButtonBarSpacer());
	footerPanel.add(new ButtonBarText("There are many more buttons to choose from."));
	footerPanel.add(new ButtonBarSpacer());
	// footerPanel.add(new ActionButton());
	// footerPanel.add(new ArrowDownButton());
	// footerPanel.add(new ArrowUpButton());
	// footerPanel.add(new ArrowLeftButton());
	// footerPanel.add(new ArrowRightButton());
	// footerPanel.add(new BookmarkButton());
	// footerPanel.add(new CameraButton());
	// footerPanel.add(new ComposeButton());
	//
	// footerPanel.add(new FastForwardButton());
	//
	// footerPanel.add(new InfoButton());
	// footerPanel.add(new LocateButton());
	// footerPanel.add(new NewIconButton());
	// footerPanel.add(new NextSlideButton());
	// footerPanel.add(new OrganizeButton());
	// footerPanel.add(new PauseButton());
	// footerPanel.add(new PlayButton());
	// footerPanel.add(new PlusButton());
	// footerPanel.add(new PreviousSlideButton());
	// footerPanel.add(new ReplyButton());
	// footerPanel.add(new RewindButton());
	// footerPanel.add(new SearchButton());
	// footerPanel.add(new StopButton());
	footerPanel.add(new TrashButton());

	panel.add(footerPanel);

    headerPanel.setCenter(NameTokens.buttonBar);  // "ButtonBar"
  }
}