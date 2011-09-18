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

package com.gwtcx.sample.serendipity.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtcx.server.servlet.FileDownloadServlet;
import com.gwtcx.server.servlet.FileUploadServlet;
import com.gwtcx.server.servlet.ReportServlet;
import com.gwtcx.shared.SharedTokens;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;
import com.gwtplatform.dispatch.shared.SecurityCookie;

public class SerendipityServletModule extends ServletModule {

  @Override
  public void configureServlets() {
    bindConstants();
    bindFilters();
    bindServlets();
  }

  protected void bindConstants() {
    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);
  }

  protected void bindFilters() {
  }

  /*

  protected void bindServlets() {
    // For GWT 2.0.4
    serve("/serendipity/" + ActionImpl.DEFAULT_SERVICE_NAME).with(
        DispatchServiceImpl.class);
  }

  */

  // <!--
  // This Guice listener hijacks all further filters and servlets.
  // Extra filters and servlets have to be configured in your
  // ServletModule#configureServlets() by calling
  // serve(String).with(Class<? extends HttpServlet>) and
  // filter(String).through(Class<? extends Filter).
  // -->

  public static final String DEFAULT_SERVICE_PATH = "/";
  public static final String REPORTS_SERVICE_PATH = "/reports/*";
  public static final String FILE_UPLOAD_SERVICE_PATH = "/upload";
  public static final String FILE_DOWNLOAD_SERVICE_PATH = "/download/*";

  protected void bindServlets() {
    // For GWT 2.1.1
    serve(DEFAULT_SERVICE_PATH + ActionImpl.DEFAULT_SERVICE_NAME).with(
        DispatchServiceImpl.class);

    // This registers a servlet (subclass of HttpServlet) called ReportServlet
    // to serve any web requests using a path-style syntax (as you would in web.xml).
    serve(REPORTS_SERVICE_PATH).with(ReportServlet.class);
    serve(FILE_UPLOAD_SERVICE_PATH).with(FileUploadServlet.class);
    serve(FILE_DOWNLOAD_SERVICE_PATH).with(FileDownloadServlet.class);
  }
}
