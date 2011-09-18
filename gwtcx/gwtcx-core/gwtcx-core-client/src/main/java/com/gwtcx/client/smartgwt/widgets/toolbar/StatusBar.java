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

package com.gwtcx.client.smartgwt.widgets.toolbar;

import com.gwtcx.client.GwtCxEntryPoint;
import com.gwtcx.client.util.I18nUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;

public class StatusBar extends HLayout {

  public static final String STATUSBAR_STYLE_NAME = "gwtcx-StatusBar";
  public static final String STATUSBAR_LABEL_STYLE_NAME = "gwtcx-StatusBar-Label";

  public static final String RESULTSET_FIRST_BUTTON = "statusbar/resultsetfirst.png";
  public static final String RESULTSET_PREVIOUS_BUTTON = "statusbar/resultsetprevious.png";
  public static final String RESULTSET_NEXT_BUTTON = "statusbar/resultsetnext.png";

  public static final int STATUSBAR_HEIGHT = 23;
  // private static final String STATUSBAR_HEIGHT = "23px";

  private static final int BUTTON_SIZE = 12; // 9
  private static final int LABEL_WIDTH = 50;

  private final Label selectedLabel;
  private final ImgButton resultSetFirstButton;
  private final ImgButton resultSetPreviousButton;
  private final Label pageNumberLabel;
  private final ImgButton resultSetNextButton;

  public StatusBar() {
    super();

    // initialise the StatusBar layout container
    this.setStyleName(STATUSBAR_STYLE_NAME);
    this.setHeight(STATUSBAR_HEIGHT);

    // initialise the Selected label
    selectedLabel = new Label();
    selectedLabel.setStyleName(STATUSBAR_LABEL_STYLE_NAME);
    selectedLabel.setContents(I18nUtil.getMessage().selected(0, 50));
    selectedLabel.setAlign(Alignment.LEFT);
    selectedLabel.setOverflow(Overflow.HIDDEN);

    // initialise the Result Set First button
    resultSetFirstButton = new ImgButton();
    resultSetFirstButton.setShowRollOver(false);
    resultSetFirstButton.setShowDisabled(true);
    resultSetFirstButton.setShowDown(false);
    resultSetFirstButton.setSize(BUTTON_SIZE);
    resultSetFirstButton.setLayoutAlign(VerticalAlignment.CENTER);
    resultSetFirstButton.setSrc(GwtCxEntryPoint.getThemedResource(RESULTSET_FIRST_BUTTON));
    // requires resultsetfirst_Disabled.png
    resultSetFirstButton.disable();
    resultSetFirstButton.setAlign(Alignment.RIGHT);

    // initialise the Result Set Previous button
    resultSetPreviousButton = new ImgButton();
    resultSetPreviousButton.setShowRollOver(false);
    resultSetPreviousButton.setShowDisabled(true);
    resultSetPreviousButton.setShowDown(false);
    resultSetPreviousButton.setSize(BUTTON_SIZE);
    resultSetPreviousButton.setLayoutAlign(VerticalAlignment.CENTER);
    resultSetPreviousButton.setSrc(GwtCxEntryPoint.getThemedResource(RESULTSET_PREVIOUS_BUTTON));
    // requires resultsetprevious_Disabled.png
    resultSetPreviousButton.disable();
    resultSetPreviousButton.setAlign(Alignment.RIGHT);

    // initialise the Page Number label
    pageNumberLabel = new Label();
    pageNumberLabel.setStyleName(STATUSBAR_LABEL_STYLE_NAME);
    pageNumberLabel.setContents(I18nUtil.getMessage().page(1));

    // TO DO: fix this
    pageNumberLabel.setWidth(LABEL_WIDTH);
    // pageNumberLabel.setWidth("*");
    pageNumberLabel.setAlign(Alignment.RIGHT);
    pageNumberLabel.setOverflow(Overflow.HIDDEN);

    // initialise the Result Set Next button
    resultSetNextButton = new ImgButton();
    resultSetNextButton.setShowRollOver(false);
    resultSetNextButton.setShowDisabled(true);
    resultSetNextButton.setShowDown(false);
    resultSetNextButton.setSize(BUTTON_SIZE);
    resultSetNextButton.setLayoutAlign(VerticalAlignment.CENTER);
    resultSetNextButton.setSrc(GwtCxEntryPoint.getThemedResource(RESULTSET_NEXT_BUTTON));
    // requires resultsetnext_Disabled.png
    resultSetNextButton.disable();
    resultSetNextButton.setAlign(Alignment.RIGHT);

    // add the widgets to the StatusBar layout container
    this.addMember(selectedLabel);
    // force right alignment
    Label alignRight = new Label("&nbsp;");
    alignRight.setAlign(Alignment.RIGHT);
    alignRight.setOverflow(Overflow.HIDDEN);
    this.addMember(alignRight);
    this.addMember(resultSetFirstButton);
    this.addMember(resultSetPreviousButton);
    this.addMember(pageNumberLabel);
    this.addMember(resultSetNextButton);
    // add some padding
    LayoutSpacer paddingRight = new LayoutSpacer();
    paddingRight.setWidth(8);
    this.addMember(paddingRight);
  }

  public Label getSelectedLabel() {
    return selectedLabel;
  }

  public ImgButton getResultSetFirstButton() {
    return resultSetFirstButton;
  }

  public ImgButton getResultSetPreviousButton() {
    return resultSetPreviousButton;
  }

  public Label getPageNumberLabel() {
    return pageNumberLabel;
  }

  public ImgButton getResultSetNextButton() {
    return resultSetNextButton;
  }
}
