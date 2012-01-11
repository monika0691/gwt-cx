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

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;

public class MastheadUpdateEvent extends GwtEvent<MastheadUpdateEventHandler> {

  private static final Type<MastheadUpdateEventHandler> TYPE = new Type<MastheadUpdateEventHandler>();

  public static Type<MastheadUpdateEventHandler> getType() { return TYPE; }

  public static void fire(EventBus eventBus, String text) {
    eventBus.fireEvent(new MastheadUpdateEvent(text));
  }

  private final String text;

  public MastheadUpdateEvent(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  protected void dispatch(MastheadUpdateEventHandler handler) {
    handler.onUpdateMasthead(this);
  }

  @Override
  public Type<MastheadUpdateEventHandler> getAssociatedType() {
    return getType();
  }
}
