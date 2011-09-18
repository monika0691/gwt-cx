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

package com.gwtcx.client.smartgwt.widgets;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.tab.Tab;

public class EntityTab extends Tab {

  public static final String DEFAULT_TITLE_SUFFIX = " ";
  public static final String DEFAULT_FIELD_WIDTH = "*";

  protected DynamicForm form;

  public EntityTab(String title) {
    super(title);

    this.setWidth(70);
    this.setCanClose(false);

    form = new DynamicForm();
    // form.setWidth100();
    form.setMargin(4);
    form.setNumCols(4);
    form.setCellPadding(4);  // 2
    form.setAutoFocus(false);
    form.setWrapItemTitles(false);

    // no ":" after the field name
    form.setTitleSuffix(DEFAULT_TITLE_SUFFIX);
    form.setRequiredTitleSuffix(DEFAULT_TITLE_SUFFIX);

    // this.setPane(form);
  }

  public DynamicForm getForm() {
    return form;
  }

  public void setFields(Object object) {
  }

  public void getFields(Object object) {
    // return null;
  }
}
