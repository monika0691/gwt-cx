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

package com.kiahu.sample.client.view.tablet.ui;

import java.util.LinkedList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowFooter;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowHeader;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowStandardHandler;
import com.googlecode.mgwt.ui.client.widget.base.PullArrowStandardHandler.PullActionHandler;
import com.googlecode.mgwt.ui.client.widget.base.PullPanel;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.PullToRefreshPresenter;
import com.kiahu.sample.client.util.ChromeWorkaround;
import com.kiahu.sample.client.view.tablet.BasicCell;

public class PullToRefreshView extends AbstractUiView implements PullToRefreshPresenter.MyView {

  public PullPanel pullToRefresh;
  public CellList<Topic> cellList;

  public PullArrowHeader pullArrowHeader;
  public PullArrowFooter pullArrowFooter;

  public int counter;
  public List<Topic> list;

  @Inject
  public PullToRefreshView() {
    super();

    Log.debug("PullToRefreshView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

	pullToRefresh = new PullPanel();
	pullArrowHeader = new PullArrowHeader();
	pullArrowFooter = new PullArrowFooter();

	pullToRefresh.setHeader(pullArrowHeader);
	pullToRefresh.setFooter(pullArrowFooter);

	cellList = new CellList<Topic>(new BasicCell<Topic>() {
	  @Override
	  public String getDisplayString(Topic model) {
	    return model.getName();
      }
	});

    panel.remove(scrollPanel);
	panel.add(pullToRefresh);
	pullToRefresh.add(cellList);

	ChromeWorkaround.maybeUpdateScroller(scrollPanel);

    headerPanel.setCenter(NameTokens.pullToRefresh);
	pullArrowHeader.setHTML("pull down");
	pullArrowFooter.setHTML("pull up");

    cellList.render(createTopics());
  }

  private boolean failedHeader = false;
  private boolean failedFooter = false;

  // mgwt Event and GWT Handler Mapping should be done here.
  protected void bindCustomUiHandlers() {

    Log.debug("bindCustomUiHandlers()");

    PullArrowStandardHandler headerHandler = new PullArrowStandardHandler(pullArrowHeader, pullToRefresh);

    headerHandler.setErrorText("Error");
	headerHandler.setLoadingText("Loading");
	headerHandler.setNormalText("pull down");
	headerHandler.setPulledText("release to load");
	headerHandler.setPullActionHandler(new PullActionHandler() {
	  @Override
	  public void onPullAction(final AsyncCallback<Void> callback) {

	    new Timer() {
		  @Override
		  public void run() {

		  if (failedHeader) {
		    callback.onFailure(null);
		  } else {
		    for (int i = 0; i < 5; i++) {
			  list.add(0, new Topic("generated Topic " + (counter + 1), counter));
				counter++;
			}

			cellList.render(list);
			pullToRefresh.refresh();

			callback.onSuccess(null);
		  }
		    failedHeader = !failedHeader;
		  }
	    }.schedule(1000);
	  }
	});

	pullToRefresh.setHeaderPullhandler(headerHandler);

    PullArrowStandardHandler footerHandler = new PullArrowStandardHandler(pullArrowFooter, pullToRefresh);

    footerHandler.setErrorText("Error");
	footerHandler.setLoadingText("Loading");
	footerHandler.setNormalText("pull up");
	footerHandler.setPulledText("release to load");
	footerHandler.setPullActionHandler(new PullActionHandler() {
	  @Override
	  public void onPullAction(final AsyncCallback<Void> callback) {

	    new Timer() {
		  @Override
		  public void run() {

		  if (failedFooter) {
		    callback.onFailure(null);
		  } else {
		    for (int i = 0; i < 5; i++) {
			  list.add(list.size(), new Topic("generated Topic " + (counter + 1), counter));
				counter++;
			}

			cellList.render(list);
			pullToRefresh.refresh();

			callback.onSuccess(null);
		  }
		    failedFooter = !failedFooter;
		  }
	    }.schedule(1000);
	  }
    });

	pullToRefresh.setFooterPullHandler(footerHandler);
  }

  private List<Topic> createTopics() {

	list = new LinkedList<Topic>();

	while (counter < 20) {
	  list.add(new Topic("Topic " + (counter + 1), counter));
	  counter++;
	}

	return list;
  }
}