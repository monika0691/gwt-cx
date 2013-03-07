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
 * NavigationPaneIcons client bundle.
 */
public interface NavigationPaneIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/icons/16/";

  public static final NavigationPaneIcons INSTANCE = GWT.create(NavigationPaneIcons.class);

  // Sales
  // @ImageOptions(preventInlining=true)
  @Source(urlPrefix + "activities.png")
  ImageResource activities();

  @Source(urlPrefix + "calendar.png")
  ImageResource calendar();

  @Source(urlPrefix + "dashboards.png")
  ImageResource dashboards();

  @Source(urlPrefix + "imports.png")
  ImageResource imports();

  @Source(urlPrefix + "accounts.png")
  ImageResource accounts();

  @Source(urlPrefix + "contacts.png")
  ImageResource contacts();

  @Source(urlPrefix + "queues.png")
  ImageResource queues();

  @Source(urlPrefix + "reports.png")
  ImageResource reports();

  // leads
  // opportunities

  // Settings

  @Source(urlPrefix + "administration.png")
  ImageResource administration();

  @Source(urlPrefix + "templates.png")
  ImageResource templates();

  @Source(urlPrefix + "datamanagement.png")
  ImageResource dataManagement();

  // Resource Centre

  @Source(urlPrefix + "highlights.png")
  ImageResource highlights();

  @Source(urlPrefix + "sales.png")
  ImageResource sales();

  @Source(urlPrefix + "settings.png")
  ImageResource settings();

  // Contacts

  @Source(urlPrefix + "information.png")
  ImageResource information();

  @Source(urlPrefix + "moreaddresses.png")
  ImageResource moreAddresses();

  @Source(urlPrefix + "history.png")
  ImageResource history();

  @Source(urlPrefix + "relationships.png")
  ImageResource relationships();

}
