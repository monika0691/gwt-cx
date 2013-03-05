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
import com.gwtcx.shared.dto.common.EntityTypeDto;
import com.sencha.gxt.cell.core.client.LabelProviderSafeHtmlRenderer;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell;
import com.sencha.gxt.cell.core.client.form.ComboBoxCell.TriggerAction;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.form.ComboBox;

public class EntityTypeComboBox  extends ComboBox<EntityTypeDto> {

  public interface EntityTypePropertyAccess extends PropertyAccess<EntityTypeDto> {
    ModelKeyProvider<EntityTypeDto> id();
    LabelProvider<EntityTypeDto> name();
  }

  public static final EntityTypePropertyAccess propertyAccess = GWT.create(EntityTypePropertyAccess.class);

  public EntityTypeComboBox(ComboBoxCell<EntityTypeDto> cell) {
    super(cell);
    redraw();

    Log.debug("EntityTypeComboBox(ComboBoxCell<AddressTypesDto> cell)");
  }

  @UiConstructor
  public EntityTypeComboBox(ListStore<EntityTypeDto> store, LabelProvider<? super EntityTypeDto> labelProvider) {
    this(new ComboBoxCell<EntityTypeDto>(store, labelProvider, new LabelProviderSafeHtmlRenderer<EntityTypeDto>(labelProvider)));

    this.setAllowBlank(false);
    this.setTriggerAction(TriggerAction.ALL);
    // this.setValue(store.get(0));

    Log.debug("EntityTypeComboBox(ListStore<AddressTypesDto> store, LabelProvider<? super AddressTypesDto> labelProvider)");
  }

  public static String getLabel() {
    return I18nUtil.getConstant().addressTypeLabel();
  }

  public static EntityTypePropertyAccess getProperty() {
    return propertyAccess;
  }
}

/*

    CountryComboBox.getCountryStore().addAll(getCountries());
    country = new CountryComboBox(CountryComboBox.getCountryStore(), CountryComboBox.getProperty().name());
    country.setValue(CountryComboBox.getCountryStore().get(0));
    getPanel().add(new FieldLabel(country, CountryComboBox.getLabel()), new HtmlData(".country"));

public class CountryComboBox extends ComboBox<EntityTypeDto> {

  public interface CountryPropertyAccess extends PropertyAccess<EntityTypeDto> {
    ModelKeyProvider<EntityTypeDto> id();
    LabelProvider<EntityTypeDto> name();
  }

  public static final CountryPropertyAccess propertyAccess = GWT.create(CountryPropertyAccess.class);
  public static final ListStore<EntityTypeDto> listStore = new ListStore<EntityTypeDto>(propertyAccess.id());

  public CountryComboBox(ComboBoxCell<EntityTypeDto> cell) {
    super(cell);
    redraw();

    Log.debug("CountryComboBox(ComboBoxCell<CountriesDto> cell)");
  }

  @UiConstructor
  public CountryComboBox(ListStore<EntityTypeDto> store, LabelProvider<? super EntityTypeDto> labelProvider) {
    this(new ComboBoxCell<EntityTypeDto>(store, labelProvider, new LabelProviderSafeHtmlRenderer<EntityTypeDto>(labelProvider)));

    this.setAllowBlank(false);
    this.setTriggerAction(TriggerAction.ALL);
    // this.setValue(store.get(0));

    Log.debug("CountryComboBox(ListStore<CountriesDto> store, LabelProvider<? super CountriesDto> labelProvider)");
  }

  public static String getLabel() {
    return I18nUtil.getConstant().countryLabel();
  }

  public static ListStore<EntityTypeDto> getCountryStore() {
    return listStore;
  }

  public static CountryPropertyAccess getProperty() {
    return propertyAccess;
  }
}

*/