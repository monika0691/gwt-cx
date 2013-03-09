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

import com.allen_sauer.gwt.log.client.Log;
// import com.google.gwt.core.client.JavaScriptObject;
import com.sencha.gxt.widget.core.client.event.ParseErrorEvent;
import com.sencha.gxt.widget.core.client.form.TriggerField;

public class LookUpField extends TriggerField<String> {

  public LookUpField() {
    this(new LookUpFieldPropertyEditor());

    Log.debug("LookUpField()");
  }

  public LookUpField(StringCell cell) {
    this(cell, new LookUpFieldPropertyEditor());

    Log.debug("LookUpField(DateCell cell)");
  }

  public LookUpField(StringCell cell, LookUpFieldPropertyEditor propertyEditor) {
    super(cell);
    setPropertyEditor(propertyEditor);
    redraw();

    Log.debug("LookUpField(DateCell cell, DateTimePropertyEditor propertyEditor)");
  }

  public LookUpField(LookUpFieldPropertyEditor propertyEditor) {
    this(new StringCell(), propertyEditor);

    Log.debug("(DateTimePropertyEditor propertyEditor)");
  }

  @Override
  public StringCell getCell() {

    Log.debug("getCell()");

    return (StringCell) super.getCell();
  }

  @Override
  public LookUpFieldPropertyEditor getPropertyEditor() {

    Log.debug("getPropertyEditor()");

    return (LookUpFieldPropertyEditor) super.getPropertyEditor();
  }

  protected void expand() {

    Log.debug("LookUpField - expand()");

    getCell().expand(createContext(), getElement(), getValue(), valueUpdater);
  }

  // AbstractPagingPresenter

  /*

  public static final int DEFAULT_MAX_RESULTS = 50;

  public static final String ID = "id";
  public static final String ACTIVITY = "activity";
  public static final String NEW = "new";
  public static final String EDIT = "edit";
  public static final String PARAMETER_SEPERATOR = "&";
  public static final String NAME = "_blank";
  public static final String FEATURES = "width=880, height=540, location=no";

  public static void openHostFile(String filename, String queryString, String id, String features) {

    StringBuilder url = new StringBuilder();
    url.append(filename).append("?");

    String arg0Name = URL.encodeQueryString(ID);
    url.append(arg0Name);
    url.append("=");
    String arg0Value = URL.encodeQueryString(id);
    url.append(GwtCxEntryPoint.encodeBase64(arg0Value));
    Log.debug("Window.open() arg0Value: " + arg0Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg0Value));
    url.append(PARAMETER_SEPERATOR);

    String arg1Name = URL.encodeQueryString(ACTIVITY);
    url.append(arg1Name);
    url.append("=");
    String arg1Value = URL.encodeQueryString(queryString);
    url.append(GwtCxEntryPoint.encodeBase64(arg1Value));
    Log.debug("Window.open() arg1Value: " + arg1Value + " Base64: " + GwtCxEntryPoint.encodeBase64(arg1Value));

    Window.open(GwtCxEntryPoint.getRelativeURL(url.toString()), NAME, features);
  }

  */

  @Override
  protected void onCellParseError(ParseErrorEvent event) {
    super.onCellParseError(event);

    Log.debug("onCellParseError()");

    /*

    String value = event.getException().getMessage();
    String f = getPropertyEditor().getFormat().getPattern();
    String msg = DefaultMessages.getMessages().dateField_invalidText(value, f);
    parseError = msg;
    forceInvalid(msg);

    */
  }
}