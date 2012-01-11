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

package com.gwtcx.sample.serendipity.client.view;

import com.google.inject.Inject;
import com.gwtcx.sample.serendipity.client.presenter.ImportsPresenter;
import com.gwtcx.client.uihandlers.ImportsUiHandlers;
import com.gwtcx.smartgwt.client.view.AbstractImportsView;
import com.gwtcx.smartgwt.client.widgets.grid.ImportsContextAreaListGrid;
import com.gwtcx.smartgwt.client.widgets.toolbar.StatusBar;
import com.gwtcx.smartgwt.client.widgets.toolbar.ToolBar;

public class ImportsView extends AbstractImportsView<ImportsUiHandlers> implements
    ImportsPresenter.MyView {

  @Inject
  public ImportsView(ToolBar toolBar, ImportsContextAreaListGrid listGrid,
      StatusBar statusBar) {
    super(toolBar, listGrid, statusBar);
  }

  // @Override
  // protected void initToolBar() { }

  // @Override
  // protected void initStatusBar() { }
}