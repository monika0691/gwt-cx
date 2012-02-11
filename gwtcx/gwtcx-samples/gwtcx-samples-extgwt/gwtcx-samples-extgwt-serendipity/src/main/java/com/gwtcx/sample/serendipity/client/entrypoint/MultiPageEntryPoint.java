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

package com.gwtcx.sample.serendipity.client.entrypoint;

import com.google.gwt.core.client.GWT;
import com.gwtcx.client.entrypoint.AbstractMultiPageEntryPoint;
import com.gwtcx.sample.serendipity.client.gin.GinjectorProvider;
import com.gwtcx.sample.serendipity.client.gin.SerendipityGinjector;
import com.gwtcx.sample.serendipity.client.i18n.SerendipityConstants;
import com.gwtcx.sample.serendipity.client.i18n.SerendipityMessages;
import com.gwtcx.sample.serendipity.client.theme.SerendipityClientBundle;
import com.gwtcx.sample.serendipity.client.util.I18nUtil;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public abstract class MultiPageEntryPoint extends AbstractMultiPageEntryPoint {

  protected final SerendipityGinjector ginjector = ((GinjectorProvider) GWT.create(GinjectorProvider.class)).get();

  protected void bind() {

    SerendipityClientBundle.INSTANCE.css().ensureInjected();

    I18nUtil.init();

    // this is required by gwt-platform's proxy generator
    // see also Serendipity.gwt.xml
    //   <define-configuration-property name="gin.ginjector" is-multi-valued="false" />
    //   <set-configuration-property name="gin.ginjector" value="com.gwtcx.sample.serendipity.client.gin.SerendipityGinjector" />
    DelayedBindRegistry.bind(getSerendipityGinjector());
  }

  public static SerendipityConstants getConstant() {
    return com.gwtcx.sample.serendipity.client.util.I18nUtil.getConstant();
  }

  public static SerendipityMessages getMessage() {
    return com.gwtcx.sample.serendipity.client.util.I18nUtil.getMessage();
  }

  public SerendipityGinjector getSerendipityGinjector() {
    return ginjector;
  }
}