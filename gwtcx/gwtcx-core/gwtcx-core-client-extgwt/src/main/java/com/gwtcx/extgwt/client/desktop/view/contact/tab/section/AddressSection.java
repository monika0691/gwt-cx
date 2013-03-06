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

package com.gwtcx.extgwt.client.desktop.view.contact.tab.section;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.extgwt.client.widgets.EntityTypeComboBox;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.gwtcx.shared.dto.common.EntityTypeDto;
import com.sencha.gxt.data.shared.ListStore;
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
    {I18nUtil.getConstant().postalCodeLabel(), ".postalCode", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, ""}
  };

  protected EntityTypeComboBox country;      // Australia
  protected EntityTypeComboBox addressType;  // Mailing

  public AddressSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("AddressSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();

    createComboBoxFields();
  }

  public void createComboBoxFields() {

    // Country - EntityTypeComboBox

    ListStore<EntityTypeDto> countryStore = new ListStore<EntityTypeDto>(EntityTypeComboBox.getProperty().id());
    countryStore.addAll(getCountries());

    country = new EntityTypeComboBox(countryStore, EntityTypeComboBox.getProperty().name());
    country.setValue(countryStore.get(0));

    getPanel().add(new FieldLabel(country, I18nUtil.getConstant().countryLabel()), new HtmlData(".country"));

    // Address Type - EntityTypeComboBox

    ListStore<EntityTypeDto> addressTypeStore = new ListStore<EntityTypeDto>(EntityTypeComboBox.getProperty().id());
    addressTypeStore.addAll(getAddressTypes());

    addressType = new EntityTypeComboBox(addressTypeStore, EntityTypeComboBox.getProperty().name());
    addressType.setValue(addressTypeStore.get(0));

    getPanel().add(new FieldLabel(addressType, I18nUtil.getConstant().addressTypeLabel()), new HtmlData(".addressType"));
  }

  @Override
  public void setFields(ContactRepresentation dto) {

  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }

  public static List<EntityTypeDto> getCountries() {

    List<EntityTypeDto> countries = new ArrayList<EntityTypeDto>();

    countries.add(new EntityTypeDto("1", "Australia"));
    countries.add(new EntityTypeDto("2", "New Zealand"));

    return countries;
  }

  public static List<EntityTypeDto> getAddressTypes() {

    List<EntityTypeDto> addressTypes = new ArrayList<EntityTypeDto>();

    addressTypes.add(new EntityTypeDto("1", "Business"));
    addressTypes.add(new EntityTypeDto("2", "Home"));
    addressTypes.add(new EntityTypeDto("3", "Mailing"));
    addressTypes.add(new EntityTypeDto("4", "Priority"));
    addressTypes.add(new EntityTypeDto("5", "Other"));

    return addressTypes;
  }
}

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