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
import com.gwtcx.client.RegExTokens;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;

public class EntitySection<T> {

  public final static int FIELD_LABEL = 0;
  public final static int HTML_DATA = 1;
  public final static int REGEX = 2;
  public final static int ALLOW_BLANKS = 3;
  public final static int EMPTY_TEXT = 4;

  private HtmlLayoutContainer panel;

  private String[][] fields = null;
  private TextField [] textFields = null;

  @SuppressWarnings("unused")
  private EntitySection() { }

  public EntitySection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    // createFields();
  }

  // protected void createFields() {
  //   Log.warn("Don't forget to @Override createFields()");
  // }

  protected void createFields() {

    Log.debug("createFields()");

    // you must call setFields(String[][] fields) in the constructor of your derived class
    if (fields == null) { return; }

    textFields = new TextField[getNumberOfRows()];

    Log.debug("NumberOfRows: " + getNumberOfRows());

    try {
      for (int row = 0; row < getNumberOfRows(); row++) {

        Log.debug("FieldLabel: " + fields[row][FIELD_LABEL] + " HtmlData: " + fields[row][HTML_DATA]);

        textFields[row] = new TextField();
        getPanel().add(new FieldLabel(textFields[row], fields[row][FIELD_LABEL]), new HtmlData(fields[row][HTML_DATA]));
        textFields[row].addValidator(new RegExValidator(fields[row][REGEX], "Regular Expression: " + fields[row][REGEX]));

        if (fields[row][ALLOW_BLANKS].contentEquals(RegExTokens.TRUE)) {
          textFields[row].setAllowBlank(true);

          Log.debug("setAllowBlank(true)");
        } else {
          textFields[row].setAllowBlank(false);

          Log.debug("setAllowBlank(false)");
        }

        if (fields[row][EMPTY_TEXT].length() != 0) {
          textFields[row].setEmptyText(fields[row][EMPTY_TEXT]);
        }
      }
    } catch (Exception e) {
      Log.error("Unable to create fields: " + e);
    }
  }

  public int getNumberOfRows() {
    return fields.length;
  }

  public HtmlLayoutContainer getPanel() { return panel; }

  public EntitySection<T> setPanel(HtmlLayoutContainer panel) {
    this.panel = panel;
    return this;
  }

  protected String[][] getFields() {
    return fields;
  }

  protected EntitySection<T> setFields(String[][] fields) {
    this.fields = fields;
    return this;
  }

  public TextField[] getTextFields() {
    return textFields;
  }

  public EntitySection<T> setTextFields(TextField[] textFields) {
    this.textFields = textFields;
    return this;
  }

  public void setFields(T dto) {
    Log.warn("Don't forget to @Override setFields()");
  }

  public void getFields(T dto) {
    Log.warn("Don't forget to @Override getFields()");
  }
}


/*

private String[][] fields = {
  {I18nUtil.getConstant().salutationLabel(), ".salutation", RegExTokens.ALPHANUMERIC_0_8, RegExTokens.TRUE, "Rob"},
  {I18nUtil.getConstant().givenNameLabel(), ".givenName", RegExTokens.ALPHANUMERIC_1_16, RegExTokens.FALSE, "Robert"},
  {I18nUtil.getConstant().middleNameLabel(), ".middleName", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, "James"},
  {I18nUtil.getConstant().familyNameLabel(), ".familyName", RegExTokens.ALPHANUMERIC_1_32, RegExTokens.FALSE, "Ferguson"},
  {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu Pty Limited"},

  {I18nUtil.getConstant().businessPhoneLabel(), ".businessPhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
  {I18nUtil.getConstant().homePhoneLabel(), ".homePhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
  {I18nUtil.getConstant().mobilePhoneLabel(), ".mobilePhone", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
  {I18nUtil.getConstant().faxLabel(), ".fax", RegExTokens.AU_TELEPHONE_10_20, RegExTokens.TRUE, ""},
  {I18nUtil.getConstant().emailLabel(), ".email", RegExTokens.EMAIL, RegExTokens.TRUE, ""}
};

*/
