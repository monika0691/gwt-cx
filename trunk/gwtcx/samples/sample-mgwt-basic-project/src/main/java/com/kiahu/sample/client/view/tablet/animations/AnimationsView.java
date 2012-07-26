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

package com.kiahu.sample.client.view.tablet.animations;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.AnimationsPresenter;
import com.kiahu.sample.client.uihandlers.AnimationsUiHandlers;
import com.kiahu.sample.client.view.tablet.BasicCell;
import com.kiahu.sample.client.view.tablet.animations.Animation.AnimationNames;

public class AnimationsView extends ViewWithUiHandlers<AnimationsUiHandlers> implements
    AnimationsPresenter.MyView {

  public LayoutPanel panel;
  public HeaderButton backButton;

  public CellListWithHeader<Animation> cellList;
  public ArrayList<Animation> list;

  @Inject
  public AnimationsView() {
    super();

    Log.debug("AnimationsView()");

    createAndBindUi();

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;

    panel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    backButton = new HeaderButton();
    scrollPanel = new ScrollPanel();

	headerPanel.setLeftWidget(backButton);
	backButton.setBackButton(true);
	backButton.setVisible(!MGWT.getOsDetection().isAndroid());

    cellList = new CellListWithHeader<Animation>(new BasicCell<Animation>() {
      @Override
      public String getDisplayString(Animation model) {
        return model.getName();
      }

      @Override
      public boolean canBeSelected(Animation model) {
        return true;
      }
    });

    cellList.getCellList().setRound(true);

    scrollPanel.setWidget(cellList);
    scrollPanel.setScrollingEnabledX(false);

    panel.add(headerPanel);
    panel.add(scrollPanel);

    backButton.setText("Home");
    headerPanel.setCenter(NameTokens.animations);  // "Animations"

    cellList.getCellList().render(createAnimations());
  }

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    backButton.addTapHandler(new TapHandler() {
      @Override
      public void onTap(TapEvent event) {

    	if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneClicked(com.gwtcx.client.NameTokens.mainPage);
        }
      }
    });

    cellList.getCellList().addCellSelectedHandler(new CellSelectedHandler() {
      @Override
      public void onCellSelected(CellSelectedEvent event) {

        Animation animation = list.get(event.getIndex());

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneClicked(animation.getName());
        }
      }
    });
  }

  private List<Animation> createAnimations() {

    list = new ArrayList<Animation>();

    list.add(new Animation(AnimationNames.SLIDE, NameTokens.slide));
    list.add(new Animation(AnimationNames.SLIDE_UP, NameTokens.slideUp));
    list.add(new Animation(AnimationNames.DISSOLVE, NameTokens.dissolve));
    list.add(new Animation(AnimationNames.FADE, NameTokens.fade));
    list.add(new Animation(AnimationNames.FLIP, NameTokens.flip));
    list.add(new Animation(AnimationNames.POP, NameTokens.pop));
    list.add(new Animation(AnimationNames.SWAP, NameTokens.swap));

    return list;
  }

  @Override
  public Widget asWidget() {

    Log.debug("asWidget()");

    return panel;
  }
}