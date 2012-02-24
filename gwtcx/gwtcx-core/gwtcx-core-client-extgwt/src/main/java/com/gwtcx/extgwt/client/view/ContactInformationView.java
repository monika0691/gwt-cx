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

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtcx.client.uihandlers.ContactInformationUiHandlers;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.gwtcx.client.presenter.ContactInformationPresenter;

public class ContactInformationView extends AbstractFormView<ContactInformationUiHandlers> implements
    ContactInformationPresenter.MyView {

  protected TabPanel tabPanel;

  @Inject
  public ContactInformationView(final EventBus eventBus) {
    super(eventBus);

    Log.debug("ContactInformationView()");

    this.tabPanel = new TabPanel();
    form.setWidget(tabPanel);

    VerticalLayoutContainer p = new VerticalLayoutContainer();
    p.setLayoutData(new MarginData(8));

    this.tabPanel.add(p, "Person Details");

    TextField firstName = new TextField();
    firstName.setAllowBlank(false);
    firstName.setValue("Darrell");
    p.add(new FieldLabel(firstName, "First Name"), new VerticalLayoutData(1, -1));

    TextField lastName = new TextField();
    lastName.setAllowBlank(false);
    lastName.setValue("Meyer");
    p.add(new FieldLabel(lastName, "Last Name"), new VerticalLayoutData(1, -1));

    TextField email = new TextField();
    email.setAllowBlank(false);
    p.add(new FieldLabel(email, "Email"), new VerticalLayoutData(1, -1));

    p = new VerticalLayoutContainer();
    p.setLayoutData(new MarginData(8));

    this.tabPanel.add(p, "Phone Numbers");

    TextField home = new TextField();
    home.setValue("888-888-888");
    p.add(new FieldLabel(home, "Home"), new VerticalLayoutData(1, -1));

    TextField business = new TextField();
    business.setValue("888-888-888");
    p.add(new FieldLabel(business, "Business"), new VerticalLayoutData(1, -1));
  }

  @Override
  public void setId(String id) {

    if (dto != null) {
      dto.setId(id);

      // set Masthead label and the browser window's title
      // setMastheadLabel(dto.getName());
    }
  }

}
