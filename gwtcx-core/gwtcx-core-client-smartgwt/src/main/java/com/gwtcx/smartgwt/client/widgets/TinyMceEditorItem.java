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

package com.gwtcx.smartgwt.client.widgets;

import com.smartgwt.client.widgets.form.fields.CanvasItem;

public class TinyMceEditorItem extends CanvasItem {

  private TinyMceEditor editorCanvas;

  public TinyMceEditorItem(String name) {
    super(name);

    editorCanvas = new TinyMceEditor(name);
    this.setCanvas(editorCanvas);
  }

  @Override
  public void setWidth(String width) {
    super.setWidth(width);

    editorCanvas.setWidth(width);
  }

  @Override
  public void setWidth(int width) {
    super.setWidth(width);

    editorCanvas.setWidth(width);
  }

  @Override
  public void setHeight(String height) {
    super.setHeight(height);

    editorCanvas.setHeight(height);
  }

  @Override
  public void setHeight(int height) {
    super.setHeight(height);

    editorCanvas.setHeight(height);
  }

  @Override
  public Object getValue() {
    return getEditorValue(editorCanvas.getID() + "_ta");
  }

  private native String getEditorValue(String id) /*-{
      if ($wnd.tinyMCE.getInstanceById(id)) {
      return $wnd.tinyMCE.getInstanceById(id).getContent();
    }

    return null;
  }-*/;

  @Override
  public void setValue(String value) {
    super.setValue(value);
    if (editorCanvas.isLoaded())
       setEditorValue(editorCanvas.getID() + "_ta", value + " isLoaded");
    else
       editorCanvas.setContents(value);
  }

  private native void setEditorValue(String id, String value) /*-{
    if ($wnd.tinyMCE.getInstanceById(id)) {
      $wnd.tinyMCE.getInstanceById(id).setContent(value);
    }
  }-*/;
}
