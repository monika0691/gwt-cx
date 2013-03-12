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

package com.gwtcx.extgwt.client.desktop.view.contact.tab;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.client.util.I18nUtil;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormView;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;

public class InformationNotesTab extends AbstractContactTab {

  public InformationNotesTab(TabPanel tabPanel) {
    super(tabPanel);

    Log.debug("InformationNotesTab(TabPanel tabPanel)");

    createFields(I18nUtil.getConstant().notesTabLabel(), "");  // notesTabIcon
  }

  @Override
  protected void createFields(String label, String icon) {

    createEditor();

    if (icon.length() != 0) {

      TabItemConfig config = new TabItemConfig(label);
      config.setIcon(getTabIcon(icon));

      getTabPanel().add(getLayoutContainer(), config);

    } else {

      getTabPanel().add(getLayoutContainer(), label);
    }
  }

  protected void createEditor() {

    getLayoutContainer().setSize(AbstractTabbedFormView.CONTEXT_AREA_WIDTH, AbstractTabbedFormView.CONTEXT_AREA_HEIGHT);
    getLayoutContainer().setLayoutData(new MarginData(AbstractTabbedFormView.DEFAULT_MARGIN));

    HtmlLayoutContainer htmlLayout = new HtmlLayoutContainer(getNotesHtmlLayout());
    htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormView.DEFAULT_MARGIN));

    HtmlEditor editor = new HtmlEditor();
    // editor.setWidth(300);
    // editor.setSize("400px", "300px");

    FieldLabel label = new FieldLabel(editor, "Notes");
    htmlLayout.add(label, new HtmlData(".editor"));

    label.setLabelAlign(LabelAlign.TOP);

    getLayoutContainer().add(htmlLayout, new VerticalLayoutData(1, -1));
  }

  public void getFields(ContactRepresentation dto) {

    Log.debug("getFields()");
  }

  public void setFields(ContactRepresentation dto) {

    Log.debug("setFields()");
  }

  // Widgets that are implemented using <table> or <frame> elements do not automatically fill the space provided by the layout.
  // In order to fix this, you will need to explicitly set these widgets width and height to 100%.

  private static native String getNotesHtmlLayout() /*-{
    return [ '<table width=100% cellpadding=0 cellspacing=0>',
        '<tr><td width=50%></td><td width=50%></td></tr>',
        '<tr><td class=editor colspan=2></td></tr>',,
        '</table>'
    ].join("");
  }-*/;
}

/*


    // need to call after everything is constructed
    List<FieldLabel> labels = FormPanelHelper.getFieldLabels(panel);
    for (FieldLabel lbl : labels) {
      lbl.setLabelAlign(LabelAlign.TOP);
    }



  public EntityTab<ContactRepresentation> setTabPanel(TabPanel tabPanel) {

    super.setTabPanel(tabPanel);

    Log.debug("setTabPanel(TabPanel tabPanel)");

    if (getTabPanel() != null) {

      VerticalLayoutContainer layout = new VerticalLayoutContainer();

      layout.setSize(AbstractTabbedFormDesktopView.CONTEXT_AREA_WIDTH, AbstractTabbedFormDesktopView.CONTEXT_AREA_HEIGHT);
      layout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

      createEditor(layout);

      getTabPanel().add(layout, "Notes");
    }

    return this;
  }


*/