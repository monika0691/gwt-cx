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

package com.gwtcx.sample.serendipity.client.entrypoint;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtcx.sample.serendipity.client.gin.SerendipityGinjector;
import com.gwtcx.sample.serendipity.client.i18n.SerendipityConstants;
import com.gwtcx.sample.serendipity.client.i18n.SerendipityMessages;
import com.gwtcx.sample.serendipity.client.theme.SerendipityClientBundle;
import com.gwtcx.sample.serendipity.client.util.GinUtil;
import com.gwtcx.sample.serendipity.client.util.I18nUtil;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

@SuppressWarnings("deprecation")
public abstract class MultiPageEntryPoint implements EntryPoint {
	
  private long startTimeMillis;
	
  public void onModuleLoad() {
    // Defer all application initialisation code to onModuleLoad2() so that the
	// UncaughtExceptionHandler can catch any unexpected exceptions.
    Log.setUncaughtExceptionHandler();

	DeferredCommand.addCommand(new Command() {
	  public void execute() {
	    onModuleLoad2();
	  }
	});
  }

  private void onModuleLoad2() {
	  
	try {
		
	  if (!Log.isLoggingEnabled()) {
	    Window.alert("Logging is disabled.");
      }		
	  
      // Use a code guard e.g. "if (Log.isDebugEnabled() {...}"
      // to ensure unnecessary code is complied out when log_level=OFF
      // or any log_level higher than DEBUG
      if (Log.isDebugEnabled()) {
        startTimeMillis = System.currentTimeMillis();
      }
      
      // No code guard necessary as the code will be
      // complied out when log_level=OFF
      Log.debug("onModuleLoad2()");
		
      GinUtil.init();
	    
	  SerendipityClientBundle.INSTANCE.css().ensureInjected();  

      I18nUtil.init();    

	  // this is required by gwt-platform proxy's generator
	  DelayedBindRegistry.bind(GinUtil.getGinjector());

	  // get Host Page name
	  Dictionary dictionary = Dictionary.getDictionary("Pages");
	  revealCurrentPlace(dictionary.get("page"));

	  // hide the animated 'loading.gif'
	  RootPanel.get("loading").setVisible(false);	
	  
      // Use a code guard e.g. "if (Log.isDebugEnabled() {...}"
      // to ensure unnecessary code is complied out when log_level=OFF
      // or any log_level higher than DEBUG
      if (Log.isDebugEnabled()) {
        long endTimeMillis = System.currentTimeMillis();
        float durationSeconds = (endTimeMillis - startTimeMillis) / 1000F;
        Log.debug("Duration: " + durationSeconds + " seconds");
      }	  
      
    } catch (Exception e) {
      Log.error("e: " + e);
      e.printStackTrace();

      Window.alert(e.getMessage());
    }
  }

  protected abstract void revealCurrentPlace(String page);

  public static String getRelativeURL(String url) {
    // .html files are located relative to the applications host page
    // e.g. /modulename/ModuleName.html not
    //      /modulename/modulename/hosted.html
    return GWT.getHostPageBaseURL() + url;
  }

  public static SerendipityConstants getConstant() {
    return com.gwtcx.sample.serendipity.client.util.I18nUtil.getConstant();
  }

  public static SerendipityMessages getMessage() {
    return com.gwtcx.sample.serendipity.client.util.I18nUtil.getMessage();
  }

  public static SerendipityGinjector getSerendipityGinjector() {
    return GinUtil.getGinjector();
  }
}