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

package com.kiahu.sample.server.guice;

import com.google.inject.servlet.ServletModule;
import com.kiahu.sample.server.servlet.RestletServlet;

public class BasicProjectServletModule extends ServletModule {

  private static final String urlPattern = "/RESTfulAPI/1.0/*";

  @Override
  public void configureServlets() {
    serve(urlPattern).with(RestletServlet.class);
  }
}