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

package com.gwtcx.sample.basic.client.entrypoint;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Window;

import com.gwtcx.sample.basic.client.gin.BasicGinjector;
import com.gwtcx.sample.basic.client.gin.GinjectorProvider;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class Basic implements EntryPoint {

  protected final BasicGinjector ginjector = ((GinjectorProvider) GWT.create(GinjectorProvider.class)).get();

  private long startTimeMillis;

  public void onModuleLoad() {

    // Defer all application initialisation code to onModuleLoad2() so that the
    // UncaughtExceptionHandler can catch any unexpected exceptions.
    Log.setUncaughtExceptionHandler();

    Log.debug("onModuleLoad()");

    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
      public void execute() {
        onModuleLoad2();
      }
    });
  }

  private void onModuleLoad2() {

    try {

      if (! Log.isLoggingEnabled()) {
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

      // this is required by gwt-platform's proxy generator
      // see also Basic.gwt.xml
      //   <define-configuration-property name="gin.ginjector" is-multi-valued="false" />
      //   <set-configuration-property name="gin.ginjector" value="com.gwtcx.sample.basic.client.gin.BasicGinjector" />
      DelayedBindRegistry.bind(getGinjector());

      getGinjector().getPlaceManager().revealCurrentPlace();

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

  public BasicGinjector getGinjector() {
    return ginjector;
  }
}
