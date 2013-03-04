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

package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.gwtcx.extgwt.client.desktop.view.AbstractTabbedFormDesktopView;
import com.gwtcx.shared.dto.ContactRepresentation;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;

public class InformationNotesTab extends ContactTab {

  public InformationNotesTab(TabPanel tabPanel) {
    super(tabPanel);

    Log.debug("InformationNotesTab(TabPanel tabPanel)");

    // setFieldSets(fieldSets);
    // createFieldSets("Notes");

    createEditor("Notes");
  }

  protected void createEditor(String tabLabel) {

    VerticalLayoutContainer layout = new VerticalLayoutContainer();

    layout.setSize(AbstractTabbedFormDesktopView.CONTEXT_AREA_WIDTH, AbstractTabbedFormDesktopView.CONTEXT_AREA_HEIGHT);
    layout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

    createEditor(layout);

    getTabPanel().add(layout, tabLabel);
  }

  protected void createEditor(VerticalLayoutContainer layoutContainer) {

    HtmlLayoutContainer htmlLayout = new HtmlLayoutContainer(getNotesHtmlLayout());
    htmlLayout.setLayoutData(new MarginData(AbstractTabbedFormDesktopView.DEFAULT_MARGIN));

    HtmlEditor editor = new HtmlEditor();
    // editor.setWidth(300);
    // editor.setSize("400px", "300px");

    FieldLabel label = new FieldLabel(editor, "Notes");
    htmlLayout.add(label, new HtmlData(".editor"));

    label.setLabelAlign(LabelAlign.TOP);

    layoutContainer.add(htmlLayout, new VerticalLayoutData(1, -1));
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