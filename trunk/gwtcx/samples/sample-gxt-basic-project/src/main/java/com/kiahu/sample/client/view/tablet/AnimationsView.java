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

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.kiahu.sample.client.presenter.tablet.AnimationsPresenter;
import com.kiahu.sample.client.uihandlers.AnimationsUiHandlers;
import com.kiahu.sample.client.view.tablet.Animation.AnimationNames;

public class AnimationsView extends ViewWithUiHandlers<AnimationsUiHandlers> implements
    AnimationsPresenter.MyView {

  public LayoutPanel panel;

  // @UiField
  public SimplePanel westPanel;
  // @UiField
  public SimplePanel centerPanel;

  public LayoutPanel navigationPaneLayoutPanel;
  public LayoutPanel contextAreaLayoutPanel;

  public CellListWithHeader<Animation> cellList;
  public ArrayList<Animation> animationlist;

  @Inject
  public AnimationsView() {
    super();

    Log.debug("AnimationsView()");

    createAndBindUi();

    bindCustomUiHandlers();
  }

  protected void createAndBindUi() {

    Log.debug("createAndBindUi()");

    panel = new LayoutPanel();

    westPanel = new SimplePanel();
    getWestPanel().getElement().setId("NavigationPane");
    getWestPanel().getElement().addClassName("landscapeonly");

    // AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);
    // final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();
    // new OrientationRegionHandler(navContainer, tabletPortraitOverlay, navDisplay);
    // new MasterRegionHandler(clientFactory.getEventBus(), "nav", tabletPortraitOverlay);

    centerPanel = new SimplePanel();
    getCenterPanel().getElement().setId("ContextArea");

    getPanel().add(getWestPanel());
    getPanel().add(getCenterPanel());

    createNavigationPane();

    createContextArea();
  }

  // Ext GWT Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    cellList.getCellList().addCellSelectedHandler(
        new CellSelectedHandler() {

      @Override
      public void onCellSelected(CellSelectedEvent event) {

        Animation animation = animationlist.get(event.getIndex());

        if (getUiHandlers() != null) {
          getUiHandlers().onNavigationPaneClicked(animation.getName());
        }
      }
    });
  }

  private void createNavigationPane() {

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;

    navigationPaneLayoutPanel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    navigationPaneLayoutPanel.add(headerPanel);

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

    navigationPaneLayoutPanel.add(scrollPanel);

    getWestPanel().add(navigationPaneLayoutPanel);



    headerPanel.setCenter("Animations");

    cellList.getCellList().render(createAnimations());
  }


  private void createContextArea() {

    HeaderPanel headerPanel;
    ScrollPanel scrollPanel;
    RoundPanel round;

    contextAreaLayoutPanel = new LayoutPanel();
    headerPanel = new HeaderPanel();
    scrollPanel = new ScrollPanel();

    contextAreaLayoutPanel.add(headerPanel);

    round = new RoundPanel();

    round.add(new HTML("<br />"));
    round.add(new HTML("mgwt Showcase"));
    round.add(new HTML("Version 1.1.2-SNAPSHOT"));
    round.add(new HTML("<br />"));

    scrollPanel.setWidget(round);
    scrollPanel.setScrollingEnabledX(false);

    contextAreaLayoutPanel.add(scrollPanel);

    getCenterPanel().add(contextAreaLayoutPanel);




    // view.setTitle("About");
    headerPanel.setCenter("About");
  }

  private List<Animation> createAnimations() {

    animationlist = new ArrayList<Animation>();

    animationlist.add(new Animation(AnimationNames.SLIDE, "Slide"));
    animationlist.add(new Animation(AnimationNames.SLIDE_UP, "Slide up"));
    animationlist.add(new Animation(AnimationNames.DISSOLVE, "Dissolve"));
    animationlist.add(new Animation(AnimationNames.FADE, "Fade"));
    animationlist.add(new Animation(AnimationNames.FLIP, "Flip"));
    animationlist.add(new Animation(AnimationNames.POP, "Pop"));
    animationlist.add(new Animation(AnimationNames.SWAP, "Swap"));

    return animationlist;
  }

  @Override
  public Widget asWidget() {

    Log.debug("asWidget()");

    return panel;
  }

  public LayoutPanel getPanel() {
    return panel;
  }

  public SimplePanel getWestPanel() {
    return westPanel;
  }

  public SimplePanel getCenterPanel() {
    return centerPanel;
  }
}