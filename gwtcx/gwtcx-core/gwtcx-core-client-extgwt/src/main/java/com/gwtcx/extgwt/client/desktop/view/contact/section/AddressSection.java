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

package com.gwtcx.extgwt.client.desktop.view.contact.section;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.extgwt.client.widgets.AddressTypeComboBox;
import com.gwtcx.extgwt.client.widgets.CountryComboBox;
import com.gwtcx.shared.dto.AddressTypesDto;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtcx.shared.dto.CountriesDto;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

public class AddressSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.AddressDto

  // FIELD_LABEL, HTML_DATA, REGEX, ALLOW_BLANKS, EMPTY_TEXT
  private String[][] textFieldTemplate = {
    {I18nUtil.getConstant().addressNameLabel(), ".addressName", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().addressLine1Label(), ".addressLine1", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().addressLine2Label(), ".addressLine2", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().addressLine3Label(), ".addressLine3", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().cityLabel(), ".city", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().stateLabel(), ".state", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().postalCodeLabel(), ".postalCode", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""},
  };

  protected CountryComboBox country;          // Australia
  protected AddressTypeComboBox addressType;  // Mailing

  public AddressSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("AddressSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();

    createComboBoxFields();
  }

  public void createComboBoxFields() {

    CountryComboBox.getCountryStore().addAll(getCountries());
    country = new CountryComboBox(CountryComboBox.getCountryStore(), CountryComboBox.getProperty().name());
    country.setValue(CountryComboBox.getCountryStore().get(0));

    AddressTypeComboBox.getAddressTypeStore().addAll(getAddressTypes());
    addressType = new AddressTypeComboBox(AddressTypeComboBox.getAddressTypeStore(), AddressTypeComboBox.getProperty().name());
    addressType.setValue(AddressTypeComboBox.getAddressTypeStore().get(0));

    getPanel().add(new FieldLabel(country, CountryComboBox.getLabel()), new HtmlData(".country"));
    getPanel().add(new FieldLabel(addressType, AddressTypeComboBox.getLabel()), new HtmlData(".addressType"));
  }

  @Override
  public void setFields(ContactRepresentation dto) {

  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }

  public static List<CountriesDto> getCountries() {

    List<CountriesDto> countries = new ArrayList<CountriesDto>();

    countries.add(new CountriesDto("1", "Australia"));
    countries.add(new CountriesDto("2", "New Zealand"));

    return countries;
  }

  public static List<AddressTypesDto> getAddressTypes() {

    List<AddressTypesDto> addressTypes = new ArrayList<AddressTypesDto>();

    addressTypes.add(new AddressTypesDto("1", "Business"));
    addressTypes.add(new AddressTypesDto("2", "Home"));
    addressTypes.add(new AddressTypesDto("3", "Mailing"));
    addressTypes.add(new AddressTypesDto("4", "Priority"));
    addressTypes.add(new AddressTypesDto("5", "Other"));

    return addressTypes;
  }
}

/*

    // CountryPropertyAccess countryPropertyAccess = GWT.create(CountryPropertyAccess.class);
    // ListStore<CountriesDto> countryStore = new ListStore<CountriesDto>(countryPropertyAccess.id());
    // countryStore.addAll(getCountries());

    // country = new ComboBox<CountriesDto>(countryStore, countryPropertyAccess.name());
    // country.setAllowBlank(false);
    // country.setTriggerAction(TriggerAction.ALL);
    // country.setValue(countryStore.get(0));

    // AddressTypeProperties addressTypeProperty = GWT.create(AddressTypeProperties.class);
    // ListStore<AddressTypesDto> addressTypeStore = new ListStore<AddressTypesDto>(addressTypeProperty.id());
    // addressTypeStore.addAll(getAddressTypes());

    // addressType = new ComboBox<AddressTypesDto>(addressTypeStore, addressTypeProperty.name());
    // addressType.setAllowBlank(false);
    // addressType.setTriggerAction(TriggerAction.ALL);
    // addressType.setValue(addressTypeStore.get(1));


public class AddressSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  protected TextField addressName;                  // Stamford Residences
  protected TextField addressLine1;                 // 33A 171 Gloucester Street
  protected TextField addressLine2;
  protected TextField addressLine3;
  protected TextField city;                         // Sydney
  protected TextField state;                        // NSW
  protected TextField postalCode;                   // 2000
  protected ComboBox<CountriesDto> country;         // Australia
  // protected String location;                     // 33A 171 Gloucester Street Sydney NSW
  protected ComboBox<AddressTypesDto> addressType;  // Home

  public interface CountryProperties extends PropertyAccess<CountriesDto> {
    ModelKeyProvider<CountriesDto> id();
    LabelProvider<CountriesDto> name();
  }

  public interface AddressTypeProperties extends PropertyAccess<AddressTypesDto> {
    ModelKeyProvider<AddressTypesDto> id();
    LabelProvider<AddressTypesDto> name();
  }

  public AddressSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("ContactInformationAddressSection()");

    createFields();
  }

  public void createFields() {

    addressName = new TextField();
    getPanel().add(new FieldLabel(addressName,  I18nUtil.getConstant().addressNameLabel()), new HtmlData(".addressName"));

    addressLine1 = new TextField();
    getPanel().add(new FieldLabel(addressLine1, I18nUtil.getConstant().addressLine1Label()), new HtmlData(".addressLine1"));

    addressLine2 = new TextField();
    getPanel().add(new FieldLabel(addressLine2, I18nUtil.getConstant().addressLine2Label()), new HtmlData(".addressLine2"));

    addressLine3 = new TextField();
    getPanel().add(new FieldLabel(addressLine3, I18nUtil.getConstant().addressLine3Label()), new HtmlData(".addressLine3"));

    city = new TextField();
    getPanel().add(new FieldLabel(city, I18nUtil.getConstant().cityLabel()), new HtmlData(".city"));

    state = new TextField();
    getPanel().add(new FieldLabel(state, I18nUtil.getConstant().stateLabel()), new HtmlData(".state"));

    postalCode = new TextField();
    getPanel().add(new FieldLabel(postalCode, I18nUtil.getConstant().postalCodeLabel()), new HtmlData(".postalCode"));



    CountryProperties countryProperty = GWT.create(CountryProperties.class);
    ListStore<CountriesDto> countryStore = new ListStore<CountriesDto>(countryProperty.id());
    countryStore.addAll(getCountries());

    country = new ComboBox<CountriesDto>(countryStore, countryProperty.name());
    country.setAllowBlank(false);
    country.setTriggerAction(TriggerAction.ALL);
    country.setValue(countryStore.get(0));

    getPanel().add(new FieldLabel(country, I18nUtil.getConstant().countryLabel()), new HtmlData(".country"));



    AddressTypeProperties addressTypeProperty = GWT.create(AddressTypeProperties.class);
    ListStore<AddressTypesDto> addressTypeStore = new ListStore<AddressTypesDto>(addressTypeProperty.id());
    addressTypeStore.addAll(getAddressTypes());

    addressType = new ComboBox<AddressTypesDto>(addressTypeStore, addressTypeProperty.name());
    addressType.setAllowBlank(false);
    addressType.setTriggerAction(TriggerAction.ALL);
    addressType.setValue(addressTypeStore.get(1));

    getPanel().add(new FieldLabel(addressType, I18nUtil.getConstant().addressTypeLabel()), new HtmlData(".addressType"));

  }

  @Override
  public void setFields(ContactRepresentation dto) {

  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }

  public static List<CountriesDto> getCountries() {

    List<CountriesDto> countries = new ArrayList<CountriesDto>();

    countries.add(new CountriesDto("1", "Australia"));
    countries.add(new CountriesDto("2", "New Zealand"));

    return countries;
  }

  public static List<AddressTypesDto> getAddressTypes() {

    List<AddressTypesDto> addressTypes = new ArrayList<AddressTypesDto>();

    addressTypes.add(new AddressTypesDto("1", "Business"));
    addressTypes.add(new AddressTypesDto("2", "Home"));
    addressTypes.add(new AddressTypesDto("3", "Mailing"));
    addressTypes.add(new AddressTypesDto("4", "Priority"));
    addressTypes.add(new AddressTypesDto("5", "Other"));

    return addressTypes;
  }
}

*/

/*

    // country.setForceSelection(true);

    // country.addValueChangeHandler(new ValueChangeHandler<CountriesDto>() {
    //   @Override
    //   public void onValueChange(ValueChangeEvent<CountriesDto> event) {
    //     Info.display("Selected", "You selected " + event.getValue());
    //   }
    // });

    // country = new TextField();
    // panel.add(new FieldLabel(country, I18nUtil.getConstant().countryLabel()), new HtmlData(".country"));


    TextField rowSpacer1 = new TextField();
    rowSpacer1.setVisible(false);
    FieldLabel rowSpacer1Label = new FieldLabel(rowSpacer1, "rowSpacer1");
    rowSpacer1Label.setVisible(false);
    panel.add(rowSpacer1Label, new HtmlData(".rowSpacer1"));



    StockProperties props = GWT.create(StockProperties.class);
    ListStore<Stock> store = new ListStore<Stock>(props.symbol());
    store.addAll(TestData.getStocks());

    ComboBox<Stock> combo = new ComboBox<Stock>(store, props.name());
    combo.addValueChangeHandler(new ValueChangeHandler<Stock>() {

      @Override
      public void onValueChange(ValueChangeEvent<Stock> event) {
        Info.display("Selected", "You selected " + event.getValue());
      }
    });
    combo.setAllowBlank(true);
    combo.setForceSelection(true);
    combo.setTriggerAction(TriggerAction.ALL);

    p.add(new FieldLabel(combo, "Company"), new VerticalLayoutData(1, -1));

*/