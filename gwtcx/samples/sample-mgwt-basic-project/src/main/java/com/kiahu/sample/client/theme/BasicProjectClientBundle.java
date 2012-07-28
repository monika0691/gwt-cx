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

package com.kiahu.sample.client.theme;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface BasicProjectClientBundle extends ClientBundle {

  public static final BasicProjectClientBundle INSTANCE = GWT.create(BasicProjectClientBundle.class);

  // See MultiPageEntryPoint

  @NotStrict
  @Source("com/kiahu/sample/client/theme/BasicProject.css")
  public CssResource css();

  @Source("com/kiahu/sample/client/theme/Media.css")
  public CssResource mgwtCss();

  // This is a very nasty workaround because GWT CssResource does not support @media correctly!
  // @Source("com/kiahu/sample/client/theme/Media.css")
  // TextResource media();
}
