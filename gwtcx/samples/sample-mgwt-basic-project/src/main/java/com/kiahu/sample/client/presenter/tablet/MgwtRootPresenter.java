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

package com.kiahu.sample.client.presenter.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationEndCallback;
import com.googlecode.mgwt.ui.client.dialog.TabletPortraitOverlay;
import com.googlecode.mgwt.ui.client.layout.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.layout.OrientationRegionHandler;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;
import com.kiahu.sample.client.entrypoint.MainPageEntryPoint;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent.RevealAnimatableDisplayContentHandler;

public class MgwtRootPresenter extends RootPresenter implements RevealAnimatableDisplayContentHandler{

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetNavigationPaneContent = new Type<RevealContentHandler<?>>();

  // Use this in leaf presenters, inside their {@link #revealInParent} method.
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_SetContextAreaContent = new Type<RevealContentHandler<?>>();

  /**
   * {@link MgwtRootPresenter}'s AnimatableDisplay view.
   */
  public static class AnimatableDisplayView extends RootView {

    private boolean usingRootLayoutPanel = false;
    private boolean isAnimatable = false;
    private Animation animation = null;

    private void setUsingRootLayoutPanel(boolean usingRootLayoutPanel) {
	  this.usingRootLayoutPanel = usingRootLayoutPanel;
	  isAnimatable = false;
    }

    public void setAnimation(Animation animation) {
	  this.animation = animation;
	  isAnimatable = true;
    }

    @Override
    public void setInSlot(Object slot, Widget content) {

	  Log.debug("setInSlot()");

	  if (isAnimatable) {

        if (slot == TYPE_SetNavigationPaneContent) {

          Log.debug("slot == TYPE_SetNavigationPaneContent");

          setNavigationPaneContent(content);

       } else if (slot == TYPE_SetContextAreaContent) {

         Log.debug("slot == TYPE_SetContextAreaContent");

         setContextAreaContent(content);
       }
	 }
	 else {

	   assert slot == rootSlot : "Unknown slot used in the root proxy.";

	   if (usingRootLayoutPanel) {
		 RootPanel.get().clear();
		 RootLayoutPanel.get().clear();
		 RootPanel.get().add(RootLayoutPanel.get());

		 if (content != null) {
		   RootLayoutPanel.get().add(content);
	     }
	   } else {
	     RootLayoutPanel.get().clear();
	     RootPanel.get().clear();

		 if (content != null) {
		   RootPanel.get().add(content);
		 }
	   }
	  }
    }

    private boolean navigationPaneFirstSlot = true;
    private boolean initialiseNavigationPane = true;
    private AnimatableDisplay navigationPaneDisplay = null;

    private void setNavigationPaneContent(Widget content) {

	  if (navigationPaneDisplay == null) {
	    navigationPaneDisplay = GWT.create(AnimatableDisplay.class);
	  }

	  if (initialiseNavigationPane) {

	    Log.debug("initialiseNavigationPane...");

	    final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

	    new OrientationRegionHandler(MainPageEntryPoint.getWestPanel(), tabletPortraitOverlay, navigationPaneDisplay);
	    new MasterRegionHandler(MgwtRootPresenter.eventBus, "NavigationPane", tabletPortraitOverlay);

	    MainPageEntryPoint.getWestPanel().setWidget(navigationPaneDisplay);

	    navigationPaneDisplay.setFirstWidget(content);
	    navigationPaneDisplay.animate(null, navigationPaneFirstSlot, new AnimationEndCallback() {
	      @Override
		  public void onAnimationEnd() {
		    //something can be done with the new content displayed
		  }
		});

		initialiseNavigationPane = false;
	    navigationPaneFirstSlot = false;
		return;
      }

	  if (navigationPaneFirstSlot) {
		navigationPaneDisplay.setFirstWidget(content);
	    navigationPaneDisplay.animate(animation, navigationPaneFirstSlot, new AnimationEndCallback() {
	      @Override
		  public void onAnimationEnd() {
		    //something can be done with the new content displayed
		  }
	    });

	    navigationPaneFirstSlot = false;
      }
	  else {
	    navigationPaneDisplay.setSecondWidget(content);
	    navigationPaneDisplay.animate(animation, navigationPaneFirstSlot, new AnimationEndCallback() {
		  @Override
		  public void onAnimationEnd() {
			//something can be done with the new content displayed
          }
		});

	    navigationPaneFirstSlot = true;
      }
    }

    private boolean contextAreaFirstSlot = true;
    private boolean initialiseContextArea = true;
    private AnimatableDisplay contextAreaDisplay = null;

    private void setContextAreaContent(Widget content) {

	  if (contextAreaDisplay == null) {
	    contextAreaDisplay = GWT.create(AnimatableDisplay.class);
	  }

	  if (initialiseContextArea) {

	    Log.debug("initialiseContextArea...");

	    MainPageEntryPoint.getCenterPanel().setWidget(contextAreaDisplay);

	    contextAreaDisplay.setFirstWidget(content);
	    contextAreaDisplay.animate(null, contextAreaFirstSlot, new AnimationEndCallback() {
	      @Override
		  public void onAnimationEnd() {
		    //something can be done with the new content displayed
		  }
		});

		initialiseContextArea = false;
	    contextAreaFirstSlot = false;
		return;
      }

	  if (contextAreaFirstSlot) {
		contextAreaDisplay.setFirstWidget(content);
	    contextAreaDisplay.animate(animation, contextAreaFirstSlot, new AnimationEndCallback() {
	      @Override
		  public void onAnimationEnd() {
		    //something can be done with the new content displayed
		  }
	    });

	    contextAreaFirstSlot = false;
      }
	  else {
	    contextAreaDisplay.setSecondWidget(content);
	    contextAreaDisplay.animate(animation, contextAreaFirstSlot, new AnimationEndCallback() {
		  @Override
		  public void onAnimationEnd() {
			//something can be done with the new content displayed
          }
		});

	    contextAreaFirstSlot = true;
      }
    }
  }

  private static final Object rootSlot = new Object();
  private static EventBus eventBus;

  @Inject
  public MgwtRootPresenter(final EventBus eventBus, final AnimatableDisplayView view) {
    super(eventBus, view);

    MgwtRootPresenter.eventBus = eventBus;
  }

  @Override
  public AnimatableDisplayView getView() {
    return (AnimatableDisplayView) super.getView();
  }

  @Override
  protected void onBind() {
	super.onBind();
	addRegisteredHandler(RevealAnimatableDisplayContentEvent.getType(), this);
  }

  @Override
  public void onRevealAnimatableDisplayContent(final RevealAnimatableDisplayContentEvent event) {

	Log.debug("onRevealAnimatableDisplayContent()");

	getView().setAnimation(event.getAnimation());
	setInSlot(event.getSlot(), event.getContent());
  }

  @Override
  public void onRevealRootContent(final RevealRootContentEvent revealContentEvent) {

	Log.debug("onRevealRootContent()");

	getView().setUsingRootLayoutPanel(false);
	setInSlot(rootSlot, revealContentEvent.getContent());
  }

  @Override
  public void onRevealRootLayoutContent(final RevealRootLayoutContentEvent revealContentEvent) {

	Log.debug("onRevealRootLayoutContent()");

	getView().setUsingRootLayoutPanel(true);
	setInSlot(rootSlot, revealContentEvent.getContent());
  }


  @Override
  public void onRevealRootPopupContent(final RevealRootPopupContentEvent revealContentEvent) {

	Log.debug("onRevealRootPopupContent()");

	addToPopupSlot(revealContentEvent.getContent());
  }
}