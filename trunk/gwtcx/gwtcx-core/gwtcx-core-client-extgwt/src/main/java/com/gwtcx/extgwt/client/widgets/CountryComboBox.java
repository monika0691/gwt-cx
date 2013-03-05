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
import com.gwtcx.shared.dto.CountriesDto;
import com.sencha.gxt.cell.core.client.LabelProviderSafeHtmlRenderer;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.form.ComboBox;

public class CountryComboBox extends ComboBox<CountriesDto> {

  public interface CountryPropertyAccess extends PropertyAccess<CountriesDto> {
    ModelKeyProvider<CountriesDto> id();
    LabelProvider<CountriesDto> name();
  }

  public static final CountryPropertyAccess propertyAccess = GWT.create(CountryPropertyAccess.class);
  public static final ListStore<CountriesDto> listStore = new ListStore<CountriesDto>(propertyAccess.id());

  public CountryComboBox(ComboBoxCell<CountriesDto> cell) {
    super(cell);
    redraw();

    Log.debug("CountryComboBox(ComboBoxCell<CountriesDto> cell)");
  }

  @UiConstructor
  public CountryComboBox(ListStore<CountriesDto> store, LabelProvider<? super CountriesDto> labelProvider) {
    this(new ComboBoxCell<CountriesDto>(store, labelProvider, new LabelProviderSafeHtmlRenderer<CountriesDto>(labelProvider)));

    this.setAllowBlank(false);
    this.setTriggerAction(TriggerAction.ALL);
    // this.setValue(store.get(0));

    Log.debug("CountryComboBox(ListStore<CountriesDto> store, LabelProvider<? super CountriesDto> labelProvider)");
  }

  public static String getLabel() {
    return I18nUtil.getConstant().countryLabel();
  }

  public static ListStore<CountriesDto> getCountryStore() {
    return listStore;
  }

  public static CountryPropertyAccess getProperty() {
    return propertyAccess;
  }
}

/*

public class CountryComboBox<T> extends ComboBox<T> {

  public CountryComboBox(ComboBoxCell<T> cell) {
    super(cell);
    redraw();
  }

  @UiConstructor
  public CountryComboBox(ListStore<T> store, LabelProvider<? super T> labelProvider) {
    this(new ComboBoxCell<T>(store, labelProvider, new LabelProviderSafeHtmlRenderer<T>(labelProvider)));
  }
}

*/