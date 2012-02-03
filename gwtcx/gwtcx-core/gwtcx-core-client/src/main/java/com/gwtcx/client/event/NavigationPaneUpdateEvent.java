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

package com.gwtcx.client.event;

// import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;

public class NavigationPaneUpdateEvent extends GwtEvent<NavigationPaneUpdateEventHandler> {

  private static final Type<NavigationPaneUpdateEventHandler> TYPE = new Type<NavigationPaneUpdateEventHandler>();

  public static Type<NavigationPaneUpdateEventHandler> getType() { return TYPE; }

  public static void fire(EventBus eventBus, String name, String displayName) {
    eventBus.fireEvent(new NavigationPaneUpdateEvent(name, displayName));
  }

  private final String name;
  private final String displayName;

  public NavigationPaneUpdateEvent(String name, String displayName) {
    this.name = name;
    this.displayName = displayName;
  }

  public String getName() {
    return name;
  }

  public String getDisplayName() {
    return displayName;
  }

  @Override
  protected void dispatch(NavigationPaneUpdateEventHandler handler) {
    handler.onUpdateNavigationPane(this);
  }

  @Override
  public Type<NavigationPaneUpdateEventHandler> getAssociatedType() {
    return getType();
  }
}
