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

package com.gwtcx.extgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.shared.dto.AddressTypesDto;
import com.sencha.gxt.cell.core.client.LabelProviderSafeHtmlRenderer;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.form.ComboBox;

public class AddressTypeComboBox  extends ComboBox<AddressTypesDto> {

  public interface AddressTypePropertyAccess extends PropertyAccess<AddressTypesDto> {
    ModelKeyProvider<AddressTypesDto> id();
    LabelProvider<AddressTypesDto> name();
  }

  public static final AddressTypePropertyAccess propertyAccess = GWT.create(AddressTypePropertyAccess.class);
  public static final ListStore<AddressTypesDto> listStore = new ListStore<AddressTypesDto>(propertyAccess.id());

  public AddressTypeComboBox(ComboBoxCell<AddressTypesDto> cell) {
    super(cell);
    redraw();

    Log.debug("AddressTypeComboBox(ComboBoxCell<AddressTypesDto> cell)");
  }

  @UiConstructor
  public AddressTypeComboBox(ListStore<AddressTypesDto> store, LabelProvider<? super AddressTypesDto> labelProvider) {
    this(new ComboBoxCell<AddressTypesDto>(store, labelProvider, new LabelProviderSafeHtmlRenderer<AddressTypesDto>(labelProvider)));

    this.setAllowBlank(false);
    this.setTriggerAction(TriggerAction.ALL);
    // this.setValue(store.get(0));

    Log.debug("AddressTypeComboBox(ListStore<AddressTypesDto> store, LabelProvider<? super AddressTypesDto> labelProvider)");
  }

  public static String getLabel() {
    return I18nUtil.getConstant().addressTypeLabel();
  }

  public static ListStore<AddressTypesDto> getAddressTypeStore() {
    return listStore;
  }

  public static AddressTypePropertyAccess getProperty() {
    return propertyAccess;
  }
}