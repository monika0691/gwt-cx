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

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList.CellGroup;
import com.googlecode.mgwt.ui.client.widget.GroupingCellList.StandardCellGroup;
import com.googlecode.mgwt.ui.client.widget.HeaderList;
import com.googlecode.mgwt.ui.client.widget.celllist.Cell;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.presenter.tablet.ui.GroupListPresenter;

public class GroupListView extends AbstractUiView implements GroupListPresenter.MyView {

  public HeaderList<Header, Content> headerList;

  public class Header {

	private final String name;

	public Header(String name) {
	  this.name = name;
	}

	public String getName() {
	  return name;
	}
  }

  public class Content {

	private final String name;

	public Content(String name) {
	  this.name = name;
	}

	public String getName() {
	  return name;
	}
  }

  private static class ContentCell implements Cell<Content> {
	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, Content model) {
	  safeHtmlBuilder.appendEscaped(model.getName());
	}

	@Override
	public boolean canBeSelected(Content model) {
	  return true;
	}
  }

  private static class HeaderCell implements Cell<Header> {
	@Override
	public void render(SafeHtmlBuilder safeHtmlBuilder, Header model) {
	  safeHtmlBuilder.appendEscaped(model.getName());
	}

	@Override
	public boolean canBeSelected(Header model) {
	  return false;
	}
  }

  @Inject
  public GroupListView() {
    super();

    Log.debug("GroupListView()");
  }

  @Override
  protected void createAndBindUi() {
	super.createAndBindUi();

    Log.debug("createAndBindUi()");

    scrollPanel.removeFromParent();

	GroupingCellList<Header, Content> groupingCellList = new GroupingCellList<Header, Content>(new ContentCell(), new HeaderCell());
	headerList = new HeaderList<Header, Content>(groupingCellList);

	panel.add(headerList);

    headerPanel.setCenter(NameTokens.groupList);

    headerList.render(buildList());
  }

  protected static String[] labels = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };

  private List<CellGroup<Header, Content>> buildList() {

	ArrayList<CellGroup<Header, Content>> list = new ArrayList<CellGroup<Header, Content>>();

    for (int i = 0; i < labels.length; i++) {

      final Header header = new Header(labels[i]);
	  final ArrayList<Content> arrayList = new ArrayList<Content>();

	  // int max = (int) (Math.random() * 5);
	  int max = 2;

	  for (int j = 0; j < max; j++) {
	    arrayList.add(new Content("" + j));
	  }

	  CellGroup<Header, Content> cellGroup = new StandardCellGroup<Header, Content>(header.getName(), header, arrayList);

	  list.add(cellGroup);
	}

	return list;
  }
}