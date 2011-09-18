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

package com.gwtcx.client.smartgwt.widgets;

import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class EntityMasthead extends HLayout {

  private static final int MASTHEAD_HEIGHT = 40;

  public static final String ENTITY_MASTHEAD_STYLE_NAME = "gwtcx-Entity-Masthead";
  public static final String ENTITY_MASTHEAD_LOGO_STYLE_NAME = "gwtcx-Entity-Masthead-Logo";
  public static final String ENTITY_MASTHEAD_NAME_STYLE_NAME = "gwtcx-Entity-Masthead-Name";

  private static final String WEST_WIDTH = "20%";
  private static final String EAST_WIDTH = "*";
  private static final String DEFAULT_WIDTH = "*";

  private Label name;

  public EntityMasthead() {
    super();

    // initialise the Masthead layout container
    this.setStyleName(ENTITY_MASTHEAD_STYLE_NAME);
    this.setHeight(MASTHEAD_HEIGHT);

    // initialise the Logo image
    // Img logo = new Img("icons/48/account.png", 46, 46);
    // logo.addStyleName(ENTITY_MASTHEAD_LOGO_STYLE_NAME);

    // initialise the West layout container
    HLayout westLayout = new HLayout();
    westLayout.setHeight(MASTHEAD_HEIGHT);
    westLayout.setWidth(WEST_WIDTH);
    // westLayout.addMember(logo);

    // initialise the Name label
    name = new Label();
    name.setStyleName(ENTITY_MASTHEAD_NAME_STYLE_NAME);
    name.setWidth(DEFAULT_WIDTH);

    // initialise the East layout container
    HLayout eastLayout = new HLayout();
    eastLayout.setHeight(MASTHEAD_HEIGHT);
    eastLayout.setWidth(EAST_WIDTH);
    eastLayout.addMember(name);
    // westLayout.addMember(name);

    // add the West and East layout containers to the Masthead layout container
    this.addMember(westLayout);
    this.addMember(eastLayout);
  }

  public void setLabelContents(String contents) {
    name.setContents(contents);
  }
}
