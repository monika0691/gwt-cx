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

package com.gwtcx.extgwt.client.field;

import java.text.ParseException;

import com.sencha.gxt.widget.core.client.form.PropertyEditor;

public class LookupFieldPropertyEditor extends PropertyEditor<String>{

  public LookupFieldPropertyEditor() {

  }

  @Override
  public String render(String object) {

    return object.toString();
  }

  @Override
  public String parse(CharSequence text) throws ParseException {

    return text.toString();
  }
}
