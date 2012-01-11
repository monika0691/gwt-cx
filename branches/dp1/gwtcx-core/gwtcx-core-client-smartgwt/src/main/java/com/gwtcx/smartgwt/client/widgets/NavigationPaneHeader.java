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

package com.gwtcx.smartgwt.client.widgets;

import com.gwtcx.client.util.I18nUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class NavigationPaneHeader extends HLayout {

  public static final String NAVIGATION_PANE_HEADER_STYLE_NAME = "gwtcx-NavigationPane-Header";
  public static final String NAVIGATION_PANE_HEADER_LABEL_STYLE_NAME = "gwtcx-NavigationPane-Header-Label";
  public static final String CONTAXT_AREA_HEADER_LABEL_STYLE_NAME = "gwtcx-ContextArea-Header-Label";

  public static final String WEST_WIDTH = "20%";
  public static final int NAVIGATION_PANE_HEADER_HEIGHT = 27;
  // public static final String NAVIGATION_PANE_HEADER_HEIGHT = "27px";

  private Label navigationPaneHeaderLabel;
  private Label contextAreaHeaderLabel;

  public NavigationPaneHeader() {
    super();

    // initialise the Navigation Pane Header layout container
    this.setStyleName(NAVIGATION_PANE_HEADER_STYLE_NAME);
    this.setHeight(NAVIGATION_PANE_HEADER_HEIGHT);

    // initialise the Navigation Pane Header Label
    navigationPaneHeaderLabel = new Label();
    navigationPaneHeaderLabel.setStyleName(NAVIGATION_PANE_HEADER_LABEL_STYLE_NAME);
    navigationPaneHeaderLabel.setWidth(WEST_WIDTH);
    navigationPaneHeaderLabel.setContents(I18nUtil.getConstant().workplace());
    navigationPaneHeaderLabel.setAlign(Alignment.LEFT);
    navigationPaneHeaderLabel.setOverflow(Overflow.HIDDEN);

    // initialise the Context Area Header Label
    contextAreaHeaderLabel = new Label();
    contextAreaHeaderLabel.setStyleName(CONTAXT_AREA_HEADER_LABEL_STYLE_NAME);
    contextAreaHeaderLabel.setContents(I18nUtil.getConstant().activities());
    contextAreaHeaderLabel.setAlign(Alignment.LEFT);
    contextAreaHeaderLabel.setOverflow(Overflow.HIDDEN);

    // add the Labels to the Navigation Pane Header layout container
    this.addMember(navigationPaneHeaderLabel);
    this.addMember(contextAreaHeaderLabel);
  }

  public Label getNavigationPaneHeaderLabel() {
    return navigationPaneHeaderLabel;
  }

  public Label getContextAreaHeaderLabel() {
    return contextAreaHeaderLabel;
  }

  public void setNavigationPaneHeaderLabelContents(String contents) {
    navigationPaneHeaderLabel.setContents(contents);
  }

  public String getNavigationPaneHeaderLabelContents() {
    return navigationPaneHeaderLabel.getContents();
  }

  public void setContextAreaHeaderLabelContents(String contents) {
    contextAreaHeaderLabel.setContents(contents);
  }

  public String getContextAreaHeaderLabelContents() {
    return contextAreaHeaderLabel.getContents();
  }
}
