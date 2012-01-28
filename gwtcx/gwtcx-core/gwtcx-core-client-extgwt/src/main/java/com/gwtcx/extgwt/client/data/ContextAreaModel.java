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

package com.gwtcx.extgwt.client.data;

import com.google.web.bindery.autobean.shared.AutoBean.PropertyName;

public interface ContextAreaModel {

  @PropertyName("column1Icon")
  String getColumn1Icon();

  @PropertyName("column1Name")
  String getColumn1Name();

  @PropertyName("column1DisplayName")
  String getColumn1DisplayName();

  @PropertyName("column1Description")
  String getColumn1Description();

  @PropertyName("column2Icon")
  String getColumn2Icon();

  @PropertyName("column2Name")
  String getColumn2Name();

  @PropertyName("column2DisplayName")
  String getColumn2DisplayName();

  @PropertyName("column2Description")
  String getColumn2Description();
}
