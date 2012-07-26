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

package com.kiahu.sample.client.view.tablet.ui;

import com.kiahu.sample.client.event.UIEntrySelectedEvent.UIEntry;

public class Item {

  private String displayString;
  private final UIEntry entry;

  public Item(String displayString, UIEntry entry) {

	this.displayString = displayString;
    this.entry = entry;
  }

  public String getDisplayString() {
    return displayString;
  }

  public UIEntry getEntry() {
    return entry;
  }
}