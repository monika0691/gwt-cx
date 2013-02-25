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

package com.kiahu.sample.server.restlet;

import com.kiahu.sample.shared.restlet.RootResource;

import org.restlet.data.MediaType;
import org.restlet.ext.wadl.DocumentationInfo;
import org.restlet.ext.wadl.MethodInfo;
import org.restlet.ext.wadl.RepresentationInfo;
import org.restlet.ext.wadl.WadlServerResource;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

public class RootServerResource extends WadlServerResource implements
    RootResource {

  @Override
  protected RepresentationInfo describe(MethodInfo methodInfo,
                                        Class<?> representationClass, Variant variant) {
    RepresentationInfo result = new RepresentationInfo(MediaType.TEXT_PLAIN);
    result.setIdentifier("root");

    DocumentationInfo doc = new DocumentationInfo();
    doc.setTitle("Basic Project Server Application");
    doc.setTextContent("Welcome to the Basic Project Server Application.");
    result.getDocumentations().add(doc);

    return result;
  }

  @Override
  protected void doInit() throws ResourceException {
    setAutoDescribing(false);
    setName("Root resource");
    setDescription("The root resource of the Basic Project Server Application.");
  }

  public String represent() {
    return "Welcome to the " + getApplication().getName() + ".";
  }
}
