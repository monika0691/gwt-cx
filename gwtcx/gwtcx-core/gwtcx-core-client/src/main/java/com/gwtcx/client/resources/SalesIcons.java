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
public interface SalesIcons extends ClientBundle {

  public static final SalesIcons INSTANCE = GWT.create(SalesIcons.class);

  // com\gwtcx\public\gwtcx\skins\aqua\images\icons\16

  // @Source("com/gwtcx/skins/aqua/images/icons/16/activities.png")
  @Source("com/gwtcx/public/gwtcx/skins/aqua/images/icons/16/activities.png")
  ImageResource activities();

  // @Source("com/gwtcx/skins/aqua/images/icons/16/calendar.png")
  @Source("com/gwtcx/public/gwtcx/skins/aqua/images/icons/16/calendar.png")
  ImageResource calendar();

}
