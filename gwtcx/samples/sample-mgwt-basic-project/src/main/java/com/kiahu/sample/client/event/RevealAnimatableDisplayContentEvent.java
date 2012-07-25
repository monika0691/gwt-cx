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

package com.kiahu.sample.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtplatform.mvp.client.Presenter;

public class RevealAnimatableDisplayContentEvent extends
    GwtEvent<RevealAnimatableDisplayContentEvent.RevealAnimatableDisplayContentHandler> {

  public interface RevealAnimatableDisplayContentHandler extends EventHandler {
    void onRevealAnimatableDisplayContent(
      RevealAnimatableDisplayContentEvent event);
  }

  public interface RevealAnimatableDisplayContentHasHandlers extends HasHandlers {
    HandlerRegistration addRevealAnimatableDisplayContentHandler(
      RevealAnimatableDisplayContentHandler handler);
  }

  public static Type<RevealAnimatableDisplayContentHandler> TYPE = new Type<RevealAnimatableDisplayContentHandler>();

  public static Type<RevealAnimatableDisplayContentHandler> getType() { return TYPE; }

  public static void fire(HasHandlers source, Object slot, Presenter<?, ?> content, Animation animation) {
    source.fireEvent(new RevealAnimatableDisplayContentEvent(slot, content, animation));
  }

  private Object slot;
  private Presenter<?,?> content;
  private Animation animation;

  public RevealAnimatableDisplayContentEvent(Object slot, Presenter<?, ?> content,Animation animation) {
	this.slot = slot;
    this.content = content;
    this.animation=animation;
  }

  public Object getSlot() {
    return slot;
  }

  public Presenter<?, ?> getContent() {
    return content;
  }

  public Animation getAnimation() {
    return animation;
  }

  @Override
  protected void dispatch(RevealAnimatableDisplayContentHandler handler) {
    handler.onRevealAnimatableDisplayContent(this);
  }

  @Override
  public Type<RevealAnimatableDisplayContentHandler> getAssociatedType() {
    return getType();
  }
}
