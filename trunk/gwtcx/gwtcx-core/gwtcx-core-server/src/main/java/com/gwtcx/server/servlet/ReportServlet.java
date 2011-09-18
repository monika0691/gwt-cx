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

package com.gwtcx.server.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.log4j.xml.DOMConfigurator;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Singleton;
import com.gwtcx.server.dao.BaseDao;

@Singleton
@SuppressWarnings("serial")
public class ReportServlet extends HttpServlet {

  // as per ReportsRecord
  private static final String REPORT_FILENAME = "reportFilename";
  // private static final String DEFAULT_REPORTS_SERVICE_PATH = "/reports/";
  private static final String DEFAULT_REPORTS_SERVICE_PATH = "/WEB-INF/classes/reports/";

  private final Object lock = new Object();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.processRequest(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    this.processRequest(request, response);
  }

  public void init(ServletConfig config) throws ServletException {
      super.init(config);

    DOMConfigurator.configure("log4j.xml");

    Log.debug("Report Servlet");

    getInitParameters();
  }

  private static final String PERSISTENCE_UNIT_NAME = "PU-NAME";
  private static final String DATA_SOURCE_NAME = "DS-NAME";

  protected static String puName = "HSQLDB-TOMCAT7-CP-PU";
  protected static String dsName = "jdbc/HSQLDB-TOMCAT7-CP";

  protected void getInitParameters() {

    ServletContext context = getServletContext();
    puName = context.getInitParameter(PERSISTENCE_UNIT_NAME);
    dsName = context.getInitParameter(DATA_SOURCE_NAME);

    Log.debug("puName: " + puName);
    Log.debug("dsName: " + dsName);

    BaseDao.setPersistenceUnitName(puName);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Log.info("Report Servlet");

    String reportFilename = request.getParameter(REPORT_FILENAME);
    String resourceName = DEFAULT_REPORTS_SERVICE_PATH + reportFilename;

    response.setContentType("application/pdf");
    ServletOutputStream servletOutputStream = response.getOutputStream();
    InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(resourceName);

    Connection connection = null;

    try {

      synchronized(lock) {
        Context initialContext = new InitialContext();
        Context localContext = (Context) initialContext.lookup("java:comp/env");
        // DataSource ds = (DataSource) localContext.lookup("jdbc/HSQLDB-TOMCAT7-CP");
        DataSource ds = (DataSource) localContext.lookup(dsName);
        connection = ds.getConnection();
      }

      JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
          new HashMap<Object, Object>(), connection);

      connection.close();
    }
    catch (Exception e) {
      // display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      response.getOutputStream().print(stringWriter.toString());
    }
    finally {
      servletOutputStream.flush();
      servletOutputStream.close();
    }
  }
}

/*


  protected void handleSubmit(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    DOMConfigurator.configure("log4j.xml");

    Log.info("Report Servlet");

    String reportFilename = request.getParameter(REPORT_FILENAME);

    // String resourceName = request.getSession().getServletContext().getRealPath("/") +
    //     DEFAULT_REPORTS_SERVICE_PATH + reportFilename;
    // Log.info("resourceName: " + resourceName);

    response.setContentType("application/pdf");
    ServletOutputStream servletOutputStream = response.getOutputStream();
    InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(DEFAULT_REPORTS_SERVICE_PATH + reportFilename);
    // InputStream reportStream = getServletConfig().getServletContext().getResourceAsStream(resourceName);

    // Connection connection;

    try {
      // Class.forName("org.hsqldb.jdbcDriver");
      Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:/db/serendipitydb", "sa", "");

      JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
          new HashMap<Object, Object>(), connection);

      connection.close();
    }
    catch (Exception e) {
      // display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      response.getOutputStream().print(stringWriter.toString());
    }
    finally {
      servletOutputStream.flush();
      servletOutputStream.close();
    }
  }



@Singleton
@SuppressWarnings("serial")
public class ReportServlet extends HttpServlet
{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException
  {
    ServletOutputStream servletOutputStream = response.getOutputStream();
    InputStream reportStream = getServletConfig().getServletContext()
        .getResourceAsStream("/reports/AccountsReport.jasper");

    try
    {
      JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream,
          new HashMap<Object, Object>(), new JREmptyDataSource());

      response.setContentType("application/pdf");
      servletOutputStream.flush();
      servletOutputStream.close();
    }
    catch (JRException e)
    {
      // display stack trace in the browser
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      response.getOutputStream().print(stringWriter.toString());
    }
  }
}

*/