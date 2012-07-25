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

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class UIEntrySelectedEvent extends Event<UIEntrySelectedEvent.Handler> {

  public enum UIEntry {
    BUTTON_BAR, BUTTONS, ELEMENTS, POPUPS, PROGRESS_BAR, PROGRESS_INDICATOR, PULL_TO_REFRESH, SCROLL_WIDGET, SEARCH_BOX, SLIDER, TABBAR, FORMS, CAROUSEL, CAROUSEL_VERT, GROUP_LIST
  }

  public interface Handler {
    void onAnimationSelected(UIEntrySelectedEvent event);
}

  private static final Type<UIEntrySelectedEvent.Handler> TYPE = new Type<UIEntrySelectedEvent.Handler>();
  private final UIEntry entry;

  public static void fire(EventBus eventBus, UIEntry entry) {
    eventBus.fireEvent(new UIEntrySelectedEvent(entry));
  }

  public static HandlerRegistration register(EventBus eventBus, Handler handler) {
    return eventBus.addHandler(TYPE, handler);
  }

  @Override
  public com.google.web.bindery.event.shared.Event.Type<Handler> getAssociatedType() {
	return TYPE;
  }

  protected UIEntrySelectedEvent(UIEntry entry) {
    this.entry = entry;
  }

  @Override
  protected void dispatch(Handler handler) {
    handler.onAnimationSelected(this);
  }

  public static Type<UIEntrySelectedEvent.Handler> getType() {
    return TYPE;
  }

  public UIEntry getEntry() {
    return entry;
  }
}
