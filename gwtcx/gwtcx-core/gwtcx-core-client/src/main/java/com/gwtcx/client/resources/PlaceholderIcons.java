/**
 * (C) Copyright 2010-2013 Kiahu
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
 * Placeholders client bundle.
 */
public interface PlaceholderIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/placeholders/";

  public static final PlaceholderIcons INSTANCE = GWT.create(PlaceholderIcons.class);

  @Source(urlPrefix + "placeholder_16.png")
  ImageResource placeholder16x16();

  @Source(urlPrefix + "placeholder_24.png")
  ImageResource placeholder24x24();

  @Source(urlPrefix + "placeholder_32.png")
  ImageResource placeholder32x32();

  @Source(urlPrefix + "placeholder_48.png")
  ImageResource placeholder48x48();

}