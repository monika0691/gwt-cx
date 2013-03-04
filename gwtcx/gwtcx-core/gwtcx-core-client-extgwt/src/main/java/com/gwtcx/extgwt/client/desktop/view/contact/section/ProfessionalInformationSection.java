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

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.RegExTokens;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.EntitySection;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;

public class ProfessionalInformationSection extends EntitySection<ContactRepresentation> {

  // See: com.gwtcx.shared.dto.ContactDto

  private String[][] textFieldTemplate = {
    {I18nUtil.getConstant().departmentLabel(), ".department", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().managerLabel(), ".manager", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().managerPhonetLabel(), ".managerPhone", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().roleLabel(), ".role", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().assistentLabel(), ".assistent", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""},
    {I18nUtil.getConstant().assistentPhoneLabel(), ".assistentPhone", RegExTokens.ALPHANUMERIC_0_16, RegExTokens.TRUE, ""}
  };

  public ProfessionalInformationSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("ContactInformationNameSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();
  }

  @Override
  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");

    /*

    String field, fieldname, value = null;

    try {

      for (int row = 0; row < getNumberOfRows(); row++) {

        field = getFields()[row][HTML_DATA];
        fieldname = field.substring(1);  // remove the "." prefix
        value = dto.getFieldValue(fieldname);

        Log.debug("field: " + field + " fieldname: " + fieldname + " value: " + value);

        getTextFields()[row].setValue(value);
        getTextFields()[row].setEmptyText("");
      }
    } catch (Exception e) {
      Log.error("Unable to set fields: " + e);
    }

    */
  }

  @Override
  public void getFields(ContactRepresentation dto) {

    Log.debug("getFields()");

  }
}
