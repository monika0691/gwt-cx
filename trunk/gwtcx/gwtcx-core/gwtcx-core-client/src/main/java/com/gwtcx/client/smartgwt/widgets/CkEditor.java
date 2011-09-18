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

package com.gwtcx.client.smartgwt.widgets;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;

public class CkEditor extends Canvas {

  {
    setOverflow(Overflow.VISIBLE);
    setCanDragResize(false);
    setRedrawOnResize(false);
    setZIndex(0);
  }

  private boolean initialised = false;

  public CkEditor(String id){
    super(id);

    addDrawHandler(new DrawHandler() {
      @Override
      public void onDraw(DrawEvent event) {
        loadCKEditor();
        }
      });
    }

  @Override
  public String getInnerHTML() {

    if (this.getContents() != null) {
      return "<textarea style='width=100%;height=100%' id=" +
              this.getID() + "_ta>" +
              getContents()+"</textarea>";
      }

    return "<textarea style='width=100%;height=100%' id=" + this.getID() + "_ta></textarea>";
  }

  // @Override
  // public void draw() {
  //   super.draw();
  //   loadCKEditor();
  // }

  protected native void loadCKEditor() /*-{

    if (! this.@com.gwtcx.client.smartgwt.widgets.CkEditor::initialised) {
      var editorId = this.@com.gwtcx.client.smartgwt.widgets.CkEditor::getID()() + "_ta";
      $wnd.CKEDITOR.replace(editorId);
      this.@com.gwtcx.client.smartgwt.widgets.CkEditor::initialised = true;
    }
  }-*/;

  public boolean isLoaded() {
    return initialised;
  }
}
