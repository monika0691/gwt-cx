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

package com.gwtcx.client.smartgwt.theme;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

/**
 * AquaClientBundle client bundle.
 */
public interface AquaClientBundle extends ClientBundle {

  static final AquaClientBundle INSTANCE = GWT.create(AquaClientBundle.class);

  @NotStrict
  @Source("aqua.css")
  public CssResource css();

  /*

  // located in .. resources\com\gwtcx\core\client
  @Source("toolbar.png")
  // @Source("../gwtcx/skins/aqua/images/toolbar.png")
  ImageResource toolbarBackground();

  @Source("toolbar.png")
  ImageResource entityMainLayoutBackground();

  // located in .. resources\com\gwtcx\core\client
  @Source("gwtcx.css")
  GwtCxCssResource css();

  interface GwtCxCssResource extends CssResource {

    // @ClassName("gwtcx-Entity-MainLayout")
    // public String gwtcxEntityMainLayout();

    @ClassName("gwtcx-Wizard-Header")
    public String gwtcxWizardHeader();

  }

  */
}
