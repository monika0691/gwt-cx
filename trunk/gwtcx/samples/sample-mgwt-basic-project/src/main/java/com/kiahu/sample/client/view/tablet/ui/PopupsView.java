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

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.dialog.ConfirmDialog.ConfirmCallback;
import com.googlecode.mgwt.ui.client.dialog.Dialogs.ButtonType;
import com.googlecode.mgwt.ui.client.dialog.Dialogs.OptionCallback;
import com.googlecode.mgwt.ui.client.dialog.Dialogs.OptionsDialogEntry;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.PopupsPresenter;

public class PopupsView extends AbstractUiView implements PopupsPresenter.MyView {

  public Button popUpButton;
  public Button alertButton;
  public Button confirmButton;

  @Inject
  public PopupsView() {
    super();

    Log.debug("PopupsView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    scrollPanel.setScrollingEnabledX(false);

	FlowPanel container = new FlowPanel();
	container.getElement().getStyle().setMarginTop(20, Unit.PX);
	scrollPanel.setWidget(container);

	popUpButton = new Button("Popup");
	container.add(popUpButton);

	alertButton = new Button("Alert");

	container.add(alertButton);

	confirmButton = new Button("Confirm");
	container.add(confirmButton);

    headerPanel.setCenter(NameTokens.popups);
  }

  @Override
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");

    popUpButton.addTapHandler(new TapHandler() {
      @Override
	  public void onTap(TapEvent event) {

        List<OptionsDialogEntry> list = new ArrayList<OptionsDialogEntry>();
		list.add(new OptionsDialogEntry("Confirm", ButtonType.CONFIRM));
		list.add(new OptionsDialogEntry("Cancel", ButtonType.NORMAL));
		list.add(new OptionsDialogEntry("Delete", ButtonType.IMPORTANT));

		showSomeOptions(list, new OptionCallback() {
		  @Override
		  public void onOptionSelected(int index) {
		  }
	    });
	  }
	});

    alertButton.addTapHandler(new TapHandler() {
	  @Override
	  public void onTap(TapEvent event) {
	    alertSomeStuff("Hi", "How are you doing?");
	  }
	});

    confirmButton.addTapHandler(new TapHandler() {
	  @Override
	  public void onTap(TapEvent event) {
	    confirmSomeStuff("Confirm this", "Confirm some more stuff", new ConfirmCallback() {
		  @Override
		  public void onOk() {
		  }
		  @Override
		  public void onCancel() {
		  }
	    });
      }
	});
  }

  private void showSomeOptions(List<OptionsDialogEntry> optionText, OptionCallback callback) {
    Dialogs.options(optionText, callback, panel);
  }

  private void alertSomeStuff(String title, String text) {
    Dialogs.alert(title, text, null);
  }

  private void confirmSomeStuff(String title, String text, ConfirmCallback callback) {
    Dialogs.confirm(title, text, callback);
  }
}