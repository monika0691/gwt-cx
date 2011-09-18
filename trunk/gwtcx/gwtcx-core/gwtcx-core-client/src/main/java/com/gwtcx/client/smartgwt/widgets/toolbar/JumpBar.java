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

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;

public class JumpBar extends HLayout {

  public static final String JUMPBAR_STYLE_NAME = "gwtcx-JumpBar";
  public static final String JUMPBAR_LABEL_STYLE_NAME = "gwtcx-JumpBar-Label";

  public static final int JUMPBAR_HEIGHT = 23;
  // private static final String JUMPBAR_HEIGHT = "23px";

  private static final String ALL_LABEL_DISPLAY_NAME = "All";
  private static final String WIDTH = "*";

  public JumpBar() {
    super();

    // initialise the JumpBar layout container
    this.setStyleName(JUMPBAR_STYLE_NAME);
    this.setHeight(JUMPBAR_HEIGHT);

    // initialise the LayoutSpacer
    LayoutSpacer paddingLeft = new LayoutSpacer();
    paddingLeft.setWidth(8);
    this.addMember(paddingLeft);

    // initialise the All label
    Label allLabel = new Label();
    allLabel.setBaseStyle(JUMPBAR_LABEL_STYLE_NAME);
    allLabel.setContents(ALL_LABEL_DISPLAY_NAME);
    allLabel.setAlign(Alignment.LEFT);
    allLabel.setOverflow(Overflow.HIDDEN);
    allLabel.setWidth(24);
    this.addMember(allLabel);

    // initialise the LayoutSpacer
    LayoutSpacer allLabelPadding = new LayoutSpacer();
    allLabelPadding.setWidth(WIDTH);
    this.addMember(allLabelPadding);

    String alphabet = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
    String labelContents = "A";

    for (int i = 0; i < 27; i++) {
      Label label = new Label();
      label.setBaseStyle(JUMPBAR_LABEL_STYLE_NAME);
      labelContents = alphabet.substring(i, i + 1);
      label.setContents(labelContents);
      label.setAlign(Alignment.CENTER);
      label.setOverflow(Overflow.HIDDEN);
      label.setWidth(20);

      this.addMember(label);

      if (i < 26) {
        LayoutSpacer padding = new LayoutSpacer();
        padding.setWidth(WIDTH);
        this.addMember(padding);
      }
    }

    // add the LayoutSpacer to the JumpBar layout container
    LayoutSpacer paddingRight = new LayoutSpacer();
    paddingRight.setWidth(8);
    this.addMember(paddingRight);
  }
}
