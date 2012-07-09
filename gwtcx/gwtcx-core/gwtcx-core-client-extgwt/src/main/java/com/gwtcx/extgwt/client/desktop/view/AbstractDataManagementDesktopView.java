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

package com.gwtcx.extgwt.client.desktop.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.UiHandlers;

/**
 * AbstractDataManagementView
 */
public abstract class AbstractDataManagementDesktopView<C extends UiHandlers> extends AbstractSettingsDesktopView<C> {

  @Inject
  public AbstractDataManagementDesktopView(String filename) {
    super(filename);

    Log.debug("AbstractDataManagementView()");
  }

  /*

  @Override
  public SafeHtml getIcon(String data) {

    if ("data_maps".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.dataMaps());
    } else if ("data_imports".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(SettingsIcons.INSTANCE.dataImports());
    } else if ("data_import_templates".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.dataImportTemplates());
    } else if ("sample_data".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(SettingsIcons.INSTANCE.sampleData());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder48());
    }
  }

  */
}
