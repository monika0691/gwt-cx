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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtcx.client.event.MastheadUpdateEvent;
import com.gwtcx.client.event.MastheadUpdateEventHandler;
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

  private final EventBus eventBus;
  private final Label name;

  @Inject
  public EntityMasthead(final EventBus eventBus, final Label name) {
    super();

    this.eventBus = eventBus;

    this.eventBus.addHandler(MastheadUpdateEvent.getType(), new MastheadUpdateEventHandler() {
      @Override
      public void onUpdateMasthead(MastheadUpdateEvent event) {

        String text = event.getText();

        setLabelContents(text);

        Log.debug("onUpdateMasthead() - " + text);
      }
    });

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
    // name = new Label();
    this.name = name;
    this.name.setStyleName(ENTITY_MASTHEAD_NAME_STYLE_NAME);
    this.name.setWidth(DEFAULT_WIDTH);

    // initialise the East layout container
    HLayout eastLayout = new HLayout();
    eastLayout.setHeight(MASTHEAD_HEIGHT);
    eastLayout.setWidth(EAST_WIDTH);
    eastLayout.addMember(this.name);
    // westLayout.addMember(name);

    // add the West and East layout containers to the Masthead layout container
    this.addMember(westLayout);
    this.addMember(eastLayout);
  }

  public void setLabelContents(String contents) {
    name.setContents(contents);
  }
}
