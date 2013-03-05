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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.sencha.gxt.widget.core.client.TabPanel;

public class InformationAdministrationTab extends ContactTab {

  private String[][] fieldSets = {
    {"General Information"}
  };

  /*

    {"Contact Preferences"},
    {"Service Preferences"},
    {"Billing"},
    {"Marketing"}

  */

  public InformationAdministrationTab(TabPanel tabPanel) {
    super(tabPanel);

    Log.debug("InformationAdministrationTab(TabPanel tabPanel)");

    setFieldSets(fieldSets);
    createFieldSets("Administration");
  }
}