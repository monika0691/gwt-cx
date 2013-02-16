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

package com.kiahu.sample.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.ext.servlet.ServletAdapter;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.kiahu.sample.server.restlet.ContactsResource;
import com.kiahu.sample.server.restlet.GuiceRouter;

@Singleton
@SuppressWarnings("serial")
public class RestletServlet extends HttpServlet {

  private static final String contactsPath = "/contacts";

  @Inject
  private Injector injector;
  private Context context;
  private ServletAdapter adapter;

  @Override
  public void init() throws ServletException
  {
    context = new Context();
    Application application = new Application();
    application.setContext(context);
    application.setInboundRoot(new GuiceRouter(injector, context)
    {
      @Override
      protected void attachRoutes()
      {
        attach(contactsPath, ContactsResource.class);
      }
    });
    adapter = new ServletAdapter(getServletContext());
    adapter.setNext(application);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws
      ServletException, IOException
  {
    adapter.service(request, response);
  }
}
