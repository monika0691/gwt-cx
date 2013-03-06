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

package com.gwtcx.extgwt.client.desktop.view;

import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.UiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

/**
 * AbstractDashboardsView
 */
public abstract class AbstractDashboardsView<C extends UiHandlers> extends ViewWithUiHandlers<C> {

  protected VerticalLayoutContainer panel;

  // @Inject
  public AbstractDashboardsView() {
    super();

    panel = new VerticalLayoutContainer();
    // panel.setStyleName(StyleTokens.contextArea);
    panel.setWidth(AbstractPagingView.CONTEXT_AREA_WIDTH);
    panel.setHeight(AbstractPagingView.CONTEXT_AREA_HEIGHT);

    bindCustomUiHandlers();
  }

  protected void bindCustomUiHandlers() { }

  @Override
  public Widget asWidget() {
    return panel;
  }

  public VerticalLayoutContainer getPanel() {
    return panel;
  }

  public void setPanel(VerticalLayoutContainer panel) {
    this.panel = panel;;
  }
}
