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

package com.gwtcx.extgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Masthead implements IsWidget {

  protected static final String DEFAULT_NAME_TEXT = "Serendipity";
  protected static final String DEFAULT_SIGNED_IN_USER_TEXT = "Administrator";
  protected static final String DEFAULT_SIGNED_IN_ORGANISATION_TEXT = "Kiahu";

  @UiTemplate("com.gwtcx.extgwt.client.widgets.Masthead.ui.xml")
  public interface MastheadUiBinder extends UiBinder<Widget, Masthead> { }

  private static MastheadUiBinder uiBinder = GWT.create(MastheadUiBinder.class);

  protected Widget widget;

  @UiField FlowPanel westLayout;
  @UiField FlowPanel eastLayout;
  @UiField Label name;
  @UiField HTML signedInUser;

  public Masthead() {
    super();

    Log.debug("Masthead()");

    createAndBindUi();

    this.name.setText(DEFAULT_NAME_TEXT);
    this.signedInUser.setHTML("<b>" + DEFAULT_SIGNED_IN_USER_TEXT + "</b> <br />" + DEFAULT_SIGNED_IN_ORGANISATION_TEXT);

    bindCustomEventHandlers();
  }

  protected void bindCustomEventHandlers() {

    /*

    this.eventBus.addHandler(MastheadUpdateEvent.getType(), new MastheadUpdateEventHandler() {
        @Override
        public void onUpdateMasthead(MastheadUpdateEvent event) {

          String text = event.getText();

          setSignedInUserText(text);

          Log.debug("onUpdateMasthead() - " + text);
        }
      });

      */
  }

  protected void createAndBindUi() {
    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  protected String getNameText() {
    return name.getText();
  }

  public void setNameText(String text) {
    name.setText(text);
  }

  protected String getSignedInUserHtml() {
    return signedInUser.getHTML();
  }

  protected void setSignedInUserHtml(String user, String organisation) {
    signedInUser.setHTML("<b>" + user + "</b> <br />" + organisation);
  }
}

/*

       <!--
      <gwt:Label ui:field="signedInOrganisation" styleName="gwtcx-Masthead-SignedInOrganisation" />
      -->


          <gwtcx:Masthead ui:field="masthead" styleName="gwtcx-Masthead">
          </gwtcx:Masthead>


  // UiBinder requires a default (zero args) constructor

  // protected static SimpleEventBus eventBus = GWT.create(SimpleEventBus.class);

  // UiBinder requires a default (zero args) constructor
  public Masthead() {
    super();

    this.name = new Label();
    this.name.setStyleName(MASTHEAD_NAME_STYLE_NAME);
    this.name.setText(getName());
    this.add(this.name);
  }


  interface MastheadUiBinder extends UiBinder<Component, Masthead> { }

  private static MastheadUiBinder uiBinder = GWT.create(MastheadUiBinder.class);

  private final Widget widget;

  @UiField
  private Label name;

@Inject
public Masthead(final Label name) {
  super();

  this.name = name;
  this.name.setStyleName(MASTHEAD_NAME_STYLE_NAME);
  this.name.setText(getName());

  this.add(this.name);



  @UiFactory
  public Masthead createMasthead() {
    return new Masthead(name);
  }


}

*/

/*


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.gwtcx.client.event.MastheadUpdateEvent;
import com.gwtcx.client.event.MastheadUpdateEventHandler;
import com.gwtcx.extgwt.client.StyleTokens;

public class Masthead extends FlowPanel {

  protected static final String DEFAULT_NAME_TEXT = "Serendipity";
  protected static final String DEFAULT_SIGNED_IN_USER_TEXT = "Administrator";
  protected static final String DEFAULT_SIGNED_IN_ORGANISATION_TEXT = "Kiahu";

  protected final EventBus eventBus;
  protected final HorizontalPanel westLayout;
  protected final HorizontalPanel eastLayout;
  protected final Label name;
  protected final Label signedInUser;
  protected final Label signedInOrganisation;

  @Inject
  public Masthead(final EventBus eventBus, final HorizontalPanel westLayout, final HorizontalPanel eastLayout,
      final Label name, final Label signedInUser, final Label signedInOrganisation) {
    super();

    this.eventBus= eventBus;
    this.westLayout = westLayout;
    this.eastLayout = eastLayout;
    this.name = name;
    this.signedInUser = signedInUser;
    this.signedInOrganisation = signedInOrganisation;

    this.setStyleName(StyleTokens.MASTHEAD_STYLE_NAME);
    this.westLayout.setStyleName(StyleTokens.MASTHEAD_CONTAINER_WEST_STYLE_NAME);
    this.eastLayout.setStyleName(StyleTokens.MASTHEAD_CONTAINER_EAST_STYLE_NAME);
    this.name.setStyleName(StyleTokens.MASTHEAD_NAME_STYLE_NAME);
    this.signedInUser.setStyleName(StyleTokens.MASTHEAD_SIGNED_IN_USER_STYLE_NAME);
    this.signedInOrganisation.setStyleName(StyleTokens.MASTHEAD_SIGNED_IN_ORGANISATION_STYLE_NAME);

    this.name.setText(DEFAULT_NAME_TEXT);
    this.signedInUser.setText(DEFAULT_SIGNED_IN_USER_TEXT);
    this.signedInOrganisation.setText(DEFAULT_SIGNED_IN_ORGANISATION_TEXT);

    this.westLayout.add(this.name);
    this.eastLayout.add(this.signedInUser);
    this.eastLayout.add(this.signedInOrganisation);

    this.add(this.westLayout);
    this.add(this.eastLayout);

    bindCustomEventHandlers();
  }

  protected void bindCustomEventHandlers() {

    this.eventBus.addHandler(MastheadUpdateEvent.getType(), new MastheadUpdateEventHandler() {
        @Override
        public void onUpdateMasthead(MastheadUpdateEvent event) {

          String text = event.getText();

          setSignedInUserText(text);

          Log.debug("onUpdateMasthead() - " + text);
        }
      });
  }

  protected String getNameText() {
    return name.getText();
  }

  public void setNameText(String text) {
    name.setText(text);
  }

  protected String getSignedInUserText() {
    return signedInUser.getText();
  }

  protected void setSignedInUserText(String text) {
    signedInUser.setText(text);
  }
}


*/
