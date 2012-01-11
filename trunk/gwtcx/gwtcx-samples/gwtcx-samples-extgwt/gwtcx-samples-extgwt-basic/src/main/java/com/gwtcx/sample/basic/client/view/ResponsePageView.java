/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
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

package com.gwtcx.sample.basic.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ResponsePageView extends ViewWithUiHandlers<ResponsePageUiHandlers> implements ResponsePagePresenter.MyView {

  HTMLPanel panel = new HTMLPanel("");


  @Inject
  public ResponsePageView() {

    Log.debug("ResponsePageView()");

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
        public void execute() {

          Log.debug("execute()");

          if (getUiHandlers() != null) {
            getUiHandlers().showResponseDialogBox();
          }
        }
      });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}

/*

  private final VerticalPanel dialogVPanel = new VerticalPanel();

  private final Dialog dialogBox = new Dialog();
  private TextButton closeButton;
  private final Label textToServerLabel= new Label();
  private final HTML serverResponseLabel= new HTML();


    dialogBox.setHeadingText("Remote Procedure Call");
    dialogBox.setAnimCollapse(true);

    dialogVPanel.addStyleName("dialogVPanel");
    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
    dialogVPanel.add(textToServerLabel);
    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
    dialogVPanel.add(serverResponseLabel);
    dialogVPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
    dialogBox.setPredefinedButtons(PredefinedButton.CLOSE);
    dialogBox.add(dialogVPanel);


    closeButton = dialogBox.getButtonById("close");
    dialogBox.setHideOnButtonClick(true);


    dialogBox.show();
    dialogBox.center();
    closeButton.focus();

*/
