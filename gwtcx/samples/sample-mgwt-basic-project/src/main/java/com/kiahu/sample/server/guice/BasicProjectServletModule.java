/**
 * (C) Copyright 2012 Kiahu
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
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

public class BasicProjectServletModule extends ServletModule {

  @Override
  public void configureServlets() {
    bindConstants();
    bindFilters();
    bindServlets();
  }

  protected void bindConstants() {

    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    // bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);
  }

  protected void bindFilters() {
  }

  public static final String DEFAULT_SERVICE_PATH = "/";
  public static final String MANIFEST_SERVICE_PATH = "/manifest/*";

  protected void bindServlets() {

    serve(DEFAULT_SERVICE_PATH + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);

    // This registers a servlet (subclass of HttpServlet) called MGWTHtml5ManifestServlet
    // to serve any web requests using a path-style syntax (as you would in web.xml).
    // Note: Servlets must be bound as singletons @Singleton
    serve(MANIFEST_SERVICE_PATH).with(BasicProjectHtml5ManifestServlet.class);
  }
}
