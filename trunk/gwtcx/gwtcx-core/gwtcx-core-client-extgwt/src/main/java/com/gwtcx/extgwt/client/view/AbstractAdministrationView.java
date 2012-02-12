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
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.gwtcx.client.resources.ImageCell;
import com.gwtcx.client.resources.PlaceholderIcons;
import com.gwtcx.client.resources.ContextAreaIcons;
import com.gwtplatform.mvp.client.UiHandlers;

/**
 * AbstractAdministrationView
 */
public abstract class AbstractAdministrationView<C extends UiHandlers> extends AbstractSettingsView<C> {

  @Inject
  public AbstractAdministrationView(String filename) {
    super(filename);

    Log.debug("AbstractAdministrationView()");
  }

  @Override
  public SafeHtml getIcon(String data) {

    if ("announcements".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(ContextAreaIcons.INSTANCE.announcements());
    } else if ("auto_numbering".equalsIgnoreCase(data)) {
      return ImageCell.makeImage(ContextAreaIcons.INSTANCE.autoNumbering());
    } else if ("business_units".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.businessUnits());
    } else if ("system_settings".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.systemSettings());
    } else if ("users".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.users());
    } else if ("teams".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.teams());
    } else if ("privacy_preferences".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.privacyPreferences());
    } else if ("product_updates".equalsIgnoreCase(data)) {
        return ImageCell.makeImage(ContextAreaIcons.INSTANCE.productUpdates());
    } else {
      return ImageCell.makeImage(PlaceholderIcons.INSTANCE.placeholder48());
    }
  }
}
