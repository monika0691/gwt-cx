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

package com.gwtcx.extgwt.client.desktop.view.contact.section;

import com.gwtcx.client.util.I18nUtil;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ElectronicAddressSection {

  protected HtmlLayoutContainer panel;

  // See: com.gwtcx.shared.dto.gwtcxContactDto

  protected TextField businessPhone;
  protected TextField homePhone;
  protected TextField mobilePhone;
  protected TextField fax;
  // protected TextField pager;
  protected TextField email;

  public ElectronicAddressSection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    createFields();
  }

  public void createFields() {

    businessPhone = new TextField();
    // businessPhone.addValidator(new RegExValidator(PHONE_VALIDATION_REGEX, "Please enter a ..."));
    panel.add(new FieldLabel(businessPhone, I18nUtil.getConstant().businessPhoneLabel()), new HtmlData(".businessPhone"));

    homePhone = new TextField();
    panel.add(new FieldLabel(homePhone, I18nUtil.getConstant().homePhoneLabel()), new HtmlData(".homePhone"));

    mobilePhone = new TextField();
    panel.add(new FieldLabel(mobilePhone, I18nUtil.getConstant().mobilePhoneLabel()), new HtmlData(".mobilePhone"));

    fax = new TextField();
    panel.add(new FieldLabel(fax, I18nUtil.getConstant().faxLabel()), new HtmlData(".fax"));

    email = new TextField();
    // email.addValidator(new RegExValidator(EMAIL_VALIDATION_REGEX, "Please enter a ..."));
    panel.add(new FieldLabel(email, I18nUtil.getConstant().emailLabel()), new HtmlData(".email"));
  }
}
