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

package com.gwtcx.extgwt.client.desktop.view;

import com.allen_sauer.gwt.log.client.Log;
import com.sencha.gxt.widget.core.client.TabPanel;

public class EntityTab<T> {

  public final static int FIELD_SET_LABEL = 0;

  private TabPanel tabPanel;

  private String[][] fieldSets = null;

  @SuppressWarnings("unused")
  private EntityTab() { }

  public EntityTab(TabPanel tabPanel) {

    this.tabPanel = tabPanel;
  }

  public TabPanel getTabPanel() {
    return tabPanel;
  }

  public EntityTab<T> setTabPanel(TabPanel tabPanel) {
    this.tabPanel = tabPanel;
    return this;
  }

  public String[][] getFieldSets() {
    return fieldSets;
  }

  public EntityTab<T> setFieldSets(String[][] fieldSets) {
    this.fieldSets = fieldSets;
    return this;
  }

  public int getNumberOfRows() {
    return fieldSets.length;
  }

  public void setFields(T dto) {
    Log.warn("Don't forget to @Override setFields()");
  }

  public void getFields(T dto) {
    Log.warn("Don't forget to @Override getFields()");
  }
}
