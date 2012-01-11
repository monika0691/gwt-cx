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

package com.gwtcx.smartgwt.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.gwtcx.smartgwt.client.entrypoint.SmartGwtEntryPoint;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.smartgwt.client.types.ContentsType;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class AbstractHighlightsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  private static final String CONTEXT_AREA_WIDTH = "*";
  private static final String CONTEXT_AREA_HEIGHT = "100%";

  private VLayout panel;
  private HTMLPane htmlPane;

  // @Inject
  public AbstractHighlightsView() {
    super();

    Log.debug("HighlightsView()");

    panel = new VLayout();

    // initialise the HighlightsView layout container
    panel.setStyleName("gwtcx-ContextArea");
    panel.setWidth(CONTEXT_AREA_WIDTH);
    panel.setHeight(CONTEXT_AREA_HEIGHT);

    htmlPane = new HTMLPane();
    htmlPane.setRedrawOnResize(false);
    htmlPane.setContentsURL(SmartGwtEntryPoint.getRelativeURL("Highlights.html"));
    htmlPane.setContentsType(ContentsType.PAGE);

    panel.addMember(htmlPane);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() { }

  @Override
  public Widget asWidget() {
    return panel;
  }
}

/*

    panel.addResizedHandler(new ResizedHandler() {
      @Override
      public void onResized(ResizedEvent event) {
        Log.debug("onResized(event)");

        int height = panel.getVisibleHeight();
        htmlPane.setHeight(height);
      }
    });

*/