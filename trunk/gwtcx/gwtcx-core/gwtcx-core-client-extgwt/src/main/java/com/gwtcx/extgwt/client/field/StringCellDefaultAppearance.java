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

package com.gwtcx.extgwt.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.field.TriggerFieldDefaultAppearance;
import com.gwtcx.extgwt.client.field.StringCell.StringCellAppearance;

// See: com\sencha\gxt\theme\base\client\field DateCellDefaultAppearance.java

public class StringCellDefaultAppearance extends TriggerFieldDefaultAppearance implements StringCellAppearance {

  public interface StringCellResources extends TriggerFieldResources {

    @Source({"ValueBaseField.css", "TextField.css", "TriggerField.css"})
    StringCellStyle css();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource textBackground();

    @Source("lookupFieldArrow.png")
    ImageResource triggerArrow();

    @Source("lookupFieldArrowOver.png")
    ImageResource triggerArrowOver();

    @Source("lookupFieldArrowClick.png")
    ImageResource triggerArrowClick();

    @Source("lookupFieldArrowFocus.png")
    ImageResource triggerArrowFocus();

    ImageResource triggerArrowFocusOver();

    ImageResource triggerArrowFocusClick();
  }

  public interface StringCellStyle extends TriggerFieldStyle {

  }

  public StringCellDefaultAppearance() {
    this(GWT.<StringCellResources> create(StringCellResources.class));
  }

  public StringCellDefaultAppearance(StringCellResources resources) {
    super(resources);
  }

}
