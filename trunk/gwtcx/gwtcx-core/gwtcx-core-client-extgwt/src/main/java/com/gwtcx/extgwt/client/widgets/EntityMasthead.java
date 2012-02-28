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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * EntityMasthead
 */
public class EntityMasthead implements IsWidget {

  @UiTemplate("com.gwtcx.extgwt.client.widgets.EntityMasthead.ui.xml")
  public interface MastheadUiBinder extends UiBinder<Widget, EntityMasthead> { }

  private static MastheadUiBinder uiBinder = GWT.create(MastheadUiBinder.class);

  protected Widget widget;

  public EntityMasthead() {
    super();

    Log.debug("EntityMasthead()");

    createAndBindUi();

    bindCustomEventHandlers();
  }

  protected void bindCustomEventHandlers() {

  }

  protected void createAndBindUi() {
    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }
}