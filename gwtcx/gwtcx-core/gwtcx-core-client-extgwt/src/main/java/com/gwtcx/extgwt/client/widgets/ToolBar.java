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

package com.gwtcx.extgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;

/**
 * ToolBar
 */
public class ToolBar implements IsWidget {

  public interface ToolBarUiBinder extends UiBinder<Widget, ToolBar> { }

  private static ToolBarUiBinder uiBinder = GWT.create(ToolBarUiBinder.class);

  protected Widget widget;

  @UiField com.sencha.gxt.widget.core.client.toolbar.ToolBar toolBar;

  @Inject
  public ToolBar() {
    super();

    Log.debug("ToolBar()");

    createAndBindUi();

    // this.toolBar.setLayoutData(new VerticalLayoutData(1, -1));
  }

  protected void createAndBindUi() {
    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  public TextButton addButton(String text, ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton(text);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public TextButton addButton(ImageResource icon,  ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton();
    button.setIcon(icon);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public TextButton addButton(ImageResource icon, String text, ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton(text);
    button.setIcon(icon);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public void addSeparator() {
    toolBar.add(new SeparatorToolItem());
  }

  public void addFill() {
    toolBar.add(new FillToolItem());
  }
}

/*

  <ui:with type="com.gwtcx.client.resources.SalesIcons" field="icons" />


  <ui:style>
    .background {
      background-color: white;
    }
  </ui:style>

          <button:TextButton text="New" icon="{icons.activities}">
          </button:TextButton>

          <toolbar:SeparatorToolItem />

          <toolbar:FillToolItem />


*/