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

package com.gwtcx.extgwt.client.widgets.grid;

import com.gwtcx.extgwt.client.data.ContextAreaModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;

/**
 * ContextAreaModelListStore
 */
public class ContextAreaModelListStore extends ListStore<ContextAreaModel> {

  /*

  public static ModelKeyProvider<ContextAreaModel> KP = new ModelKeyProvider<ContextAreaModel>() {
    @Override
    public String getKey(ContextAreaModel item) {
      return item.getColumn1Name();
    }
  };

  */

  /*

  public static SimpleKeyProvider<ContextAreaModel> KP = new SimpleKeyProvider<ContextAreaModel>() {
    @Override
    public Object getKey(ContextAreaModel item) {
       return item;
    }
  };

  */

  public static ModelKeyProvider<ContextAreaModel> KP = new ModelKeyProvider<ContextAreaModel>() {
    @Override
    public String getKey(ContextAreaModel item) {
      return item.getColumn1Name();
    }
  };

  public ContextAreaModelListStore() {
    super(KP);
  }
}
