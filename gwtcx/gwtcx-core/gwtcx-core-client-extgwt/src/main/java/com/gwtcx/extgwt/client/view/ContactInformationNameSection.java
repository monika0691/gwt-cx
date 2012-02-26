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

package com.gwtcx.extgwt.client.view;

import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ContactInformationNameSection {

  protected HtmlLayoutContainer panel;

  protected TextField salutation;
  protected TextField givenName;
  protected TextField middleName;
  protected TextField familyName;
  // protected TextField correspondence;
  // protected TextField jobTitle;
  // protected TextField occupation;
  // protected TextField parentCustomer;
  // protected TextField currency;

  public ContactInformationNameSection(final HtmlLayoutContainer panel) {

    this.panel = panel;

    createFields();
  }

  public void createFields() {

    salutation = new TextField();
    panel.add(new FieldLabel(salutation, "Salutation"), new HtmlData(".salutation"));

    givenName = new TextField();
    panel.add(new FieldLabel(givenName, "Given Name"), new HtmlData(".givenName"));

    middleName = new TextField();
    panel.add(new FieldLabel(middleName, "Middle Name"), new HtmlData(".middleName"));

    familyName = new TextField();
    familyName.setAllowBlank(false);
    // familyName.setValue("Ferguson");
    panel.add(new FieldLabel(familyName, "Family Name"), new HtmlData(".familyName"));

  }
}
