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
public interface ContextAreaIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/icons/48/";

  public static final ContextAreaIcons INSTANCE = GWT.create(ContextAreaIcons.class);

  // Administration

  @Source(urlPrefix + "announcements.png")
  ImageResource announcements();

  @Source(urlPrefix + "auto_numbering.png")
  ImageResource autoNumbering();

  @Source(urlPrefix + "business_units.png")
  ImageResource businessUnits();

  @Source(urlPrefix + "system_settings.png")
  ImageResource systemSettings();

  @Source(urlPrefix + "users.png")
  ImageResource users();

  @Source(urlPrefix + "teams.png")
  ImageResource teams();

  @Source(urlPrefix + "privacy_preferences.png")
  ImageResource privacyPreferences();

  @Source(urlPrefix + "product_updates.png")
  ImageResource productUpdates();

  // Templates


  // Data Management

  @Source(urlPrefix + "data_maps.png")
  ImageResource dataMaps();

  @Source(urlPrefix + "data_imports.png")
  ImageResource dataImports();

  @Source(urlPrefix + "data_import_templates.png")
  ImageResource dataImportTemplates();

  @Source(urlPrefix + "sample_data.png")
  ImageResource sampleData();

}
