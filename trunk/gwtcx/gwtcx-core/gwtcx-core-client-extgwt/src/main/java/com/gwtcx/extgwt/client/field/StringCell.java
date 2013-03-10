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

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.sencha.gxt.cell.core.client.form.TriggerFieldCell;
import com.sencha.gxt.core.client.GXT;
import com.sencha.gxt.core.client.dom.XElement;

public class StringCell extends TriggerFieldCell<String> {

  public interface StringCellAppearance extends TriggerFieldAppearance {

  }

  public StringCell() {
    this(GWT.<StringCellAppearance> create(StringCellAppearance.class));
  }

  public StringCell(StringCellAppearance appearance) {
    super(appearance);
    setPropertyEditor(new LookUpFieldPropertyEditor());
  }

  @Override
  protected boolean isFocusClick(XElement parent, XElement target) {

    boolean result = parent.isOrHasChild(target);

    return result;
  }

  @Override
  protected void onNavigationKey(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {

    Log.debug("onNavigationKey()");

    if (event.getKeyCode() == KeyCodes.KEY_DOWN) {
      event.stopPropagation();
      event.preventDefault();
      onTriggerClick(context, parent.<XElement> cast(), event, value, valueUpdater);
    }
  }

  @Override
  protected void onTriggerClick(Context context, XElement parent, NativeEvent event, String value, ValueUpdater<String> updater) {
    super.onTriggerClick(context, parent, event, value, updater);

    Log.debug("onTriggerClick()");

    if (!isReadOnly() && !isDisabled()) {

      // blur is firing after the expand so context info on expand is being cleared
      // when value change fires lastContext and lastParent are null without this code
      if (GXT.isChrome() && lastParent != null && lastParent != parent) {
        getInputElement(lastParent).blur();
      }
    }
  }
}
