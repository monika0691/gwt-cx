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

package com.kiahu.sample.client.view.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.gwtcx.client.uihandlers.MainPageUiHandlers;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.kiahu.sample.client.presenter.MainPageTabletPresenter;

public class MainPageTabletView extends ViewWithUiHandlers<MainPageUiHandlers> implements
    MainPageTabletPresenter.MyView {

  LayoutPanel layoutPanel;

  @Inject
  public MainPageTabletView() {
    super();

    Log.debug("MainPageTabletView()");

    createAndBindUi();

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    layoutPanel = new LayoutPanel();
    Button button = new Button("Hello mgwt");
    layoutPanel.add(button);

    // setViewport(uiBinder.createAndBindUi(this));
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

  }

  @Override
  public Widget asWidget() {
    return layoutPanel;
  }
}