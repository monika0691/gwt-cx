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

  // FIELD_LABEL, HTML_DATA, REGEX, ALLOW_BLANKS, EMPTY_TEXT
  private String[][] textFieldTemplate = null;

  private TextField [] textFields = null;  // new TextField[getNumberOfRows()];

  @SuppressWarnings("unused")
  private EntitySection() { }

  public EntitySection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    // createFields();
  }

  protected void createTextFields() {

    Log.debug("createTextFields()");

    // you must call setTextFieldTemplate() in the constructor of your derived class
    if (getTextFieldTemplate() == null) { return; }

    textFields = new TextField[getNumberOfTextFieldRows()];

    Log.debug("NumberOfTextFieldRows: " + getNumberOfTextFieldRows());

    try {

      for (int row = 0; row < getNumberOfTextFieldRows(); row++) {

        Log.debug("FieldLabel: " + getTextFieldTemplate()[row][FIELD_LABEL] + " HtmlData: " + getTextFieldTemplate()[row][HTML_DATA]);

        getTextFields()[row] = new TextField();
        getPanel().add(new FieldLabel(getTextFields()[row], getTextFieldTemplate()[row][FIELD_LABEL]), new HtmlData(getTextFieldTemplate()[row][HTML_DATA]));
        getTextFields()[row].addValidator(new RegExValidator(getTextFieldTemplate()[row][REGEX], "Regular Expression: " + getTextFieldTemplate()[row][REGEX]));

        if (getTextFieldTemplate()[row][ALLOW_BLANKS].contentEquals(RegExTokens.TRUE)) {

          getTextFields()[row].setAllowBlank(true);

          Log.debug("setAllowBlank(true)");
        } else {

          getTextFields()[row].setAllowBlank(false);

          Log.debug("setAllowBlank(false)");
        }

        if (getTextFieldTemplate()[row][EMPTY_TEXT].length() != 0) {
          getTextFields()[row].setEmptyText(getTextFieldTemplate()[row][EMPTY_TEXT]);
        }
      }
    } catch (Exception e) {
      Log.error("Unable to create fields: " + e);
    }
  }

  public HtmlLayoutContainer getPanel() { return panel; }

  public EntitySection<T> setPanel(HtmlLayoutContainer panel) {
    this.panel = panel;
    return this;
  }

  protected String[][] getTextFieldTemplate() {
    return textFieldTemplate;
  }

  protected EntitySection<T> setTextFieldTemplate(String[][] fields) {
    this.textFieldTemplate = fields;
    return this;
  }

  public int getNumberOfTextFieldRows() {
    return textFieldTemplate.length;
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
  {I18nUtil.getConstant().parentCustomerLabel(), ".parentCustomer", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, "Kiahu Pty Limited"}
};

*/
