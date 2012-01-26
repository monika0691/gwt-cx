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

package com.gwtcx.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * SalesIcons client bundle.
 */
public interface SettingsIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/icons/48/";

  public static final SettingsIcons INSTANCE = GWT.create(SettingsIcons.class);

  @Source(urlPrefix + "placeholder.png")
  ImageResource placeholder();

  @Source(urlPrefix + "announcements.png")
  ImageResource announcements();

  @Source(urlPrefix + "autonumbering.png")
  ImageResource autoNumbering();

  @Source(urlPrefix + "businessunits.png")
  ImageResource businessUnits();

  @Source(urlPrefix + "systemsettings.png")
  ImageResource systemSettings();

  @Source(urlPrefix + "users.png")
  ImageResource users();

  @Source(urlPrefix + "teams.png")
  ImageResource teams();

  @Source(urlPrefix + "privacypreferences.png")
  ImageResource privacyPreferences();

  @Source(urlPrefix + "productupdates.png")
  ImageResource productUpdates();

}
