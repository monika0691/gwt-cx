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

package com.gwtcx.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * ToolBarIcons client bundle.
 */
public interface ToolBarIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/toolbar/";

  public static final ToolBarIcons INSTANCE = GWT.create(ToolBarIcons.class);

  @Source(urlPrefix + "newactivity.png")
  ImageResource newActivity();

  @Source(urlPrefix + "newimport.png")
  ImageResource newImport();

  @Source(urlPrefix + "newaccount.png")
  ImageResource newAccount();

  @Source(urlPrefix + "newcontact.png")
  ImageResource newContact();

  @Source(urlPrefix + "newqueue.png")
  ImageResource newQueue();

  @Source(urlPrefix + "newreport.png")
  ImageResource newReport();

  @Source(urlPrefix + "printpreview.png")
  ImageResource printPreview();

  @Source(urlPrefix + "export.png")
  ImageResource export();

  @Source(urlPrefix + "mailmerge.png")
  ImageResource mailMerge();

  @Source(urlPrefix + "assign.png")
  ImageResource assign();

  @Source(urlPrefix + "delete.png")
  ImageResource delete();

  @Source(urlPrefix + "sendemail.png")
  ImageResource sendEmail();

  @Source(urlPrefix + "attach.png")
  ImageResource attach();

  @Source(urlPrefix + "refresh.png")
  ImageResource refresh();

  @Source(urlPrefix + "workflow.png")
  ImageResource workflow();

  @Source(urlPrefix + "reports.png")
  ImageResource reports();

  @Source(urlPrefix + "save.png")
  ImageResource save();

  @Source(urlPrefix + "saveandclose.png")
  ImageResource saveandclose();

  @Source(urlPrefix + "help.png")
  ImageResource help();
}