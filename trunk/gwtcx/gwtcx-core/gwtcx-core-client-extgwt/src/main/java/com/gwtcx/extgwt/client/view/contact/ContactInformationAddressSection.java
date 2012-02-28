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

package com.gwtcx.extgwt.client.view.contact;

import com.gwtcx.client.util.I18nUtil;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ContactInformationAddressSection {

  protected HtmlLayoutContainer panel;

  protected TextField addressName;
  protected TextField addressLine1;
  protected TextField addressLine2;
  protected TextField addressLine3;
  protected TextField city;
  protected TextField state;
  protected TextField postalCode;
  // protected ComboBox<> country;
  // protected ComboBox<> addressType;
  protected TextField country;
  protected TextField addressType;

  public ContactInformationAddressSection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    createFields();
  }

  public void createFields() {

    addressName = new TextField();
    panel.add(new FieldLabel(addressName,  I18nUtil.getConstant().addressNameLabel()), new HtmlData(".addressName"));

    addressLine1 = new TextField();
    panel.add(new FieldLabel(addressLine1, I18nUtil.getConstant().addressLine1Label()), new HtmlData(".addressLine1"));

    addressLine2 = new TextField();
    panel.add(new FieldLabel(addressLine2, I18nUtil.getConstant().addressLine2Label()), new HtmlData(".addressLine2"));

    addressLine3 = new TextField();
    panel.add(new FieldLabel(addressLine3, I18nUtil.getConstant().addressLine3Label()), new HtmlData(".addressLine3"));

    city = new TextField();
    panel.add(new FieldLabel(city, I18nUtil.getConstant().cityLabel()), new HtmlData(".city"));

    state = new TextField();
    panel.add(new FieldLabel(state, I18nUtil.getConstant().stateLabel()), new HtmlData(".state"));

    postalCode = new TextField();
    panel.add(new FieldLabel(postalCode, I18nUtil.getConstant().postalCodeLabel()), new HtmlData(".postalCode"));

    country = new TextField();
    panel.add(new FieldLabel(country, I18nUtil.getConstant().countryLabel()), new HtmlData(".country"));

    addressType = new TextField();
    panel.add(new FieldLabel(addressType, I18nUtil.getConstant().addressTypeLabel()), new HtmlData(".addressType"));

  }
}

/*

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