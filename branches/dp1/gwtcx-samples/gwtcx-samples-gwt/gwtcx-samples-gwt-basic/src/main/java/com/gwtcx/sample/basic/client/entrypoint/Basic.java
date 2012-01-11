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

package com.gwtcx.sample.basic.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.gwtcx.sample.basic.client.gin.BasicGinjector;
import com.gwtcx.sample.basic.client.gin.GinjectorProvider;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class Basic implements EntryPoint {

  protected final BasicGinjector ginjector = ((GinjectorProvider) GWT.create(GinjectorProvider.class)).get();

  public void onModuleLoad() {

    // this is required by gwt-platform's proxy generator
    // see also Basic.gwt.xml
    //   <define-configuration-property name="gin.ginjector" is-multi-valued="false" />
    //   <set-configuration-property name="gin.ginjector" value="com.gwtcx.sample.basic.client.gin.BasicGinjector" />
    DelayedBindRegistry.bind(ginjector);

    ginjector.getPlaceManager().revealCurrentPlace();
  }
}
