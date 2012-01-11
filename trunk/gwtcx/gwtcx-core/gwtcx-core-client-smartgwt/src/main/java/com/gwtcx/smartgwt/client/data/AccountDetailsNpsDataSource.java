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

package com.gwtcx.smartgwt.client.data;

import com.google.gwt.core.client.GWT;

public class AccountDetailsNpsDataSource extends NavigationPaneSectionDataSource {

  private static final String DATA_SOURCE = "AccountDetailsNps";
  // private static final String URL_PREFIX = "datasource/data/AccountDetailsNps";
  protected static final String URL_PREFIX = GWT.getModuleName() + "/gwtcx/smartgwt/" + "datasource/data/AccountDetailsNps";
  private static final String URL_SUFFIX = ".xml";

  private static AccountDetailsNpsDataSource instance = null;

  public static AccountDetailsNpsDataSource getInstance() {

    if (instance == null) {
      instance = new AccountDetailsNpsDataSource(DATA_SOURCE);
    }

    return instance;
  }

  public AccountDetailsNpsDataSource(String id) {
    super(id);

    setDataURL(URL_PREFIX, URL_SUFFIX);
  }
}
