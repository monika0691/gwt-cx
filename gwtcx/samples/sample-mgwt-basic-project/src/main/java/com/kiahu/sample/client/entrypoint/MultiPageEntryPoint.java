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

package com.kiahu.sample.client.entrypoint;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.gwtcx.client.entrypoint.AbstractMultiPageEntryPoint;
import com.gwtplatform.mvp.client.DelayedBindRegistry;
import com.kiahu.sample.client.gin.BasicProjectGinjector;
import com.kiahu.sample.client.gin.GinjectorProvider;
import com.kiahu.sample.client.i18n.BasicProjectConstants;
import com.kiahu.sample.client.i18n.BasicProjectMessages;
import com.kiahu.sample.client.theme.BasicProjectClientBundle;
import com.kiahu.sample.client.util.I18nUtil;

public abstract class MultiPageEntryPoint extends AbstractMultiPageEntryPoint {

  protected final BasicProjectGinjector ginjector = ((GinjectorProvider) GWT.create(GinjectorProvider.class)).get();

  protected void bind() {

    BasicProjectClientBundle.INSTANCE.css().ensureInjected();
    StyleInjector.inject(BasicProjectClientBundle.INSTANCE.media().getText());

    I18nUtil.init();

    // this is required by gwt-platform's proxy generator
    // see also .gwt.xml
    //   <define-configuration-property name="gin.ginjector" is-multi-valued="false" />
    //   <set-configuration-property name="gin.ginjector" value="com.kaihu.sample.client.gin.BasicProjectGinjector" />
    DelayedBindRegistry.bind(getBasicProjectGinjector());
  }

  public static BasicProjectConstants getConstant() {
    return com.kiahu.sample.client.util.I18nUtil.getConstant();
  }

  public static BasicProjectMessages getMessage() {
    return com.kiahu.sample.client.util.I18nUtil.getMessage();
  }

  public BasicProjectGinjector getBasicProjectGinjector() {
    return ginjector;
  }
}