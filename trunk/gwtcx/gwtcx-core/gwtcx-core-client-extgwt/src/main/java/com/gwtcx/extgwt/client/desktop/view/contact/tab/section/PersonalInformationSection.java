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
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;

public class PersonalInformationSection extends EntitySection<ContactRepresentation> {

  // FIELD_LABEL, HTML_DATA, REGEX, ALLOW_BLANKS, EMPTY_TEXT
  private String[][] textFieldTemplate = {
    {I18nUtil.getConstant().partnerNameLabel(), ".partnerName", RegExTokens.ALPHANUMERIC_0_32, RegExTokens.TRUE, ""}
  };

  protected EntityTypeComboBox gender;         // Male
  protected EntityTypeComboBox maritalStatus;  // Single

  protected DateField birthday;
  protected DateField anniversary;

  public PersonalInformationSection(final HtmlLayoutContainer panel) {
    super(panel);

    Log.debug("PersonalInformationSection()");

    setTextFieldTemplate(textFieldTemplate);

    createTextFields();

    createComboBoxFields();

    createDateFields();
  }

  public void createComboBoxFields() {

    // Gender - EntityTypeComboBox

    ListStore<EntityTypeDto> genderStore = new ListStore<EntityTypeDto>(EntityTypeComboBox.getProperty().id());
    genderStore.addAll(getGender());

    gender = new EntityTypeComboBox(genderStore, EntityTypeComboBox.getProperty().name());
    gender.setValue(genderStore.get(1));

    getPanel().add(new FieldLabel(gender, I18nUtil.getConstant().genderLabel()), new HtmlData(".gender"));

    // Marital Status - EntityTypeComboBox

    ListStore<EntityTypeDto> maritalStatusStore = new ListStore<EntityTypeDto>(EntityTypeComboBox.getProperty().id());
    maritalStatusStore.addAll(getMaritalStatus());

    maritalStatus = new EntityTypeComboBox(maritalStatusStore, EntityTypeComboBox.getProperty().name());
    maritalStatus.setValue(maritalStatusStore.get(0));

    getPanel().add(new FieldLabel(maritalStatus, I18nUtil.getConstant().maritalStatusLabel()), new HtmlData(".maritalStatus"));
  }

  public void createDateFields() {

    birthday = new DateField();
    getPanel().add(new FieldLabel(birthday, I18nUtil.getConstant().birthdayLabel()), new HtmlData(".birthday"));

    anniversary = new DateField();
    getPanel().add(new FieldLabel(anniversary, I18nUtil.getConstant().anniversaryLabel()), new HtmlData(".anniversary"));
  }

  @Override
  public void setFields(ContactRepresentation dto) {

  }

  @Override
  public void getFields(ContactRepresentation dto) {

  }

  // http://en.wikipedia.org/wiki/ISO_5218
  // The four codes specified in ISO/IEC 5218 are: 0 = not known, 1 = male, 2 = female, 9 = not applicable.
  public static List<EntityTypeDto> getGender() {

    List<EntityTypeDto> list = new ArrayList<EntityTypeDto>();

    list.add(new EntityTypeDto("1", "Not Known", "0"));
    list.add(new EntityTypeDto("2", "Male", "1"));
    list.add(new EntityTypeDto("3", "Female", "2"));
    list.add(new EntityTypeDto("4", "Not Applicable", "9"));

    return list;
  }

  // http://en.wikipedia.org/wiki/Marital_status
  public static List<EntityTypeDto> getMaritalStatus() {

    List<EntityTypeDto> list = new ArrayList<EntityTypeDto>();

    list.add(new EntityTypeDto("1", "Not Known", "N"));
    list.add(new EntityTypeDto("2", "Divorced", "D"));
    list.add(new EntityTypeDto("3", "Married", "M"));
    list.add(new EntityTypeDto("4", "Separated", "A"));
    list.add(new EntityTypeDto("5", "Single", "S"));
    list.add(new EntityTypeDto("6", "Widowed", "W"));
    list.add(new EntityTypeDto("7", "Not Applicable", "O"));

    return list;
  }
}
