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

package com.kiahu.sample.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationEndCallback;
import com.gwtplatform.mvp.client.RootPresenter;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealRootPopupContentEvent;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent.RevealAnimatableDisplayContentHandler;

public class MgwtRootPresenter extends RootPresenter implements RevealAnimatableDisplayContentHandler{

     public static class AnimatableDisplayView extends RootView {

       private boolean usingRootLayoutPanel;

       private void setUsingRootLayoutPanel(boolean usingRootLayoutPanel) {
              this.usingRootLayoutPanel = usingRootLayoutPanel;
              initializing=true;
              isAnimatable=false;
            }

       boolean isAnimatable=false;
       protected AnimatableDisplay display=null;
       boolean firstSlot=true;
       boolean initializing=true;
       Animation animation;

       public void setAnimation(Animation animation){
           this.animation=animation;
           isAnimatable=true;
       }

       @Override
       public void setInSlot(Object slot, Widget content) {
           if(isAnimatable){
               if(display==null) display = GWT.create(AnimatableDisplay.class);
               if(initializing){
                   // TODO Next 2 lines are a dirty workaround for
                   // http://code.google.com/p/google-web-toolkit/issues/detail?id=4737
                   RootLayoutPanel.get().clear();
                   RootPanel.get().clear();
                   RootPanel.get().add(display);
                   display.setFirstWidget(content);
                   display.animate(null, firstSlot, new AnimationEndCallback() {
                        @Override
                        public void onAnimationEnd() {
                            //something can be done with the new content displayed
                        }
                    });
                   initializing=false;
                   firstSlot=false;
                   return;
               }

               if(firstSlot){
                   display.setFirstWidget(content);
                   display.animate(animation, firstSlot, new AnimationEndCallback() {
                        @Override
                        public void onAnimationEnd() {
                            //something can be done with the new content displayed
                        }
                    });
                   firstSlot=false;
               }
               else{
                   display.setSecondWidget(content);
                   display.animate(animation, firstSlot, new AnimationEndCallback() {
                        @Override
                        public void onAnimationEnd() {
                            //something can be done with the new content displayed
                        }
                    });
                   firstSlot=true;
               }
           }
           else{
               assert slot == rootSlot : "Unknown slot used in the root proxy.";

                  if (usingRootLayoutPanel) {
                    // TODO Next 3 lines are a dirty workaround for
                    // http://code.google.com/p/google-web-toolkit/issues/detail?id=4737
                    RootPanel.get().clear();
                    RootLayoutPanel.get().clear();
                    RootPanel.get().add(RootLayoutPanel.get());
                    if (content != null) {
                      RootLayoutPanel.get().add(content);
                    }
                  } else {
                    // TODO Next 2 lines are a dirty workaround for
                    // http://code.google.com/p/google-web-toolkit/issues/detail?id=4737
                    RootLayoutPanel.get().clear();
                    RootPanel.get().clear();
                    if (content != null) {
                      RootPanel.get().add(content);
                    }
                  }
           }

       }
     }

     private static final Object rootSlot = new Object();
     AnimatableDisplayView display;

     @Inject
     public MgwtRootPresenter( EventBus eventBus, AnimatableDisplayView display ) {
         super( eventBus, display);
         this.display=display;
     }

     @Override
      protected void onBind() {
        super.onBind();
        addRegisteredHandler(RevealAnimatableDisplayContentEvent.getType(), this);
     }

    @Override
    public void onRevealAnimatableDisplayContent(RevealAnimatableDisplayContentEvent event) {
        display.setAnimation(event.getAnimation());
        setInSlot(rootSlot, event.getContent());
    }

    @Override
      public void onRevealRootContent(
          final RevealRootContentEvent revealContentEvent) {
        display.setUsingRootLayoutPanel(false);
        setInSlot(rootSlot, revealContentEvent.getContent());
      }

      public void onRevealRootLayoutContent(
          final RevealRootLayoutContentEvent revealContentEvent) {
        display.setUsingRootLayoutPanel(true);
        setInSlot(rootSlot, revealContentEvent.getContent());
      }

      @Override
      public void onRevealRootPopupContent(
          final RevealRootPopupContentEvent revealContentEvent) {
        addToPopupSlot(revealContentEvent.getContent());
      }

}