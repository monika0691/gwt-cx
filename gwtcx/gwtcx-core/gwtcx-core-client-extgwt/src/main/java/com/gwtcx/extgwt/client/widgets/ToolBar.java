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
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.tips.ToolTipConfig;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;

/**
 * ToolBar
 */
public class ToolBar implements IsWidget {

  public interface ToolBarUiBinder extends UiBinder<Widget, ToolBar> { }

  private static ToolBarUiBinder uiBinder = GWT.create(ToolBarUiBinder.class);

  protected Widget widget;

  @UiField com.sencha.gxt.widget.core.client.toolbar.ToolBar toolBar;

  @Inject
  public ToolBar() {
    super();

    Log.debug("ToolBar()");

    createAndBindUi();
  }

  protected void createAndBindUi() {
    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  public ToolTipConfig createToolTipConfig(String title, String body) {
    ToolTipConfig config = new ToolTipConfig();
    config.setTitleHtml(title);
    config.setBodyHtml(body);
    // config.setMouseOffset(new int[] {0, 0});
    // config.setAnchor(Side.TOP);
    config.setTrackMouse(true);
    return config;
  }

  public TextButton addTextButton(String text, ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton(text);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public TextButton addTextButton(ImageResource icon,  ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton();
    button.setIcon(icon);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public TextButton addTextButton(ImageResource icon, String text, ToolTipConfig config, SelectHandler handler) {

    TextButton button = new TextButton(text);
    button.setIcon(icon);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public ToggleButton addToggleButton(String text, ToolTipConfig config, SelectHandler handler) {

    ToggleButton button = new ToggleButton(text);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public ToggleButton addToggleButton(ImageResource icon, String text, ToolTipConfig config, SelectHandler handler) {

    ToggleButton button = new ToggleButton(text);
    button.setIcon(icon);

    if (config != null)
      button.setToolTipConfig(config);

    if (handler != null)
      button.addSelectHandler(handler);

    toolBar.add(button);

    return button;
  }

  public LabelToolItem addLabel(String text) {

    LabelToolItem label = new LabelToolItem(text);

    toolBar.add(label);

    return label;
  }

  /*

  public Label addLabel(String text) {

    Label label = new Label(text);

    toolBar.add(label);

    return label;
  }

  */

  public void addSeparator() {
    toolBar.add(new SeparatorToolItem());
  }

  public void addFill() {
    toolBar.add(new FillToolItem());
  }

  public void setPack(BoxLayoutPack pack) {
    toolBar.setPack(pack);
  }

  public void setSpacing(int spacing) {
    toolBar.setSpacing(spacing);
  }

  public void setSize(String width, String height) {
    toolBar.setSize(width, height);
  }

  public void setWidth(String width) {
    toolBar.setWidth(width);
  }

  public void setHeight(String height) {
    toolBar.setWidth(height);
  }
}

/*


  enum Category {
    NORMAL("Normal Buttons", "Normal"), MENU("Menu Buttons", "Menu"), MENUBOTTOM("Menu (Arrow on bottom)",
        "Menu Bottom"), SPLIT("Split Buttons", "Split"), SPLITBOTTOM("Split Buttons (Arrow on bottom)", "Split Bottom"), TOGGLE(
        "Toggle Buttons", "Toggle");

    private String text;
    private String desc;

    Category(String text, String desc) {
      this.text = text;
      this.desc = desc;
    }

    String getText() {
      return text;
    }
  }

  enum Type {

    BOTTOM("Icon and Text (bottom)"), ICON("Icon Only"), LEFT("Icon and Text (left)"), RIGHT("Icon and Text (right)"), TEXT(
        "Text Only"), TOP("Icon and Text (top)");

    private String text;

    Type(String text) {
      this.text = text;
    }

    String getText() {
      return text;
    }
  }


  private ContentPanel cp;
  private CardLayoutContainer con;
  private ExampleStyle style;

  private Map<Category, FlowLayoutContainer> created = new HashMap<Category, FlowLayoutContainer>();

  private FlowLayoutContainer createButtons(Category cat) {
    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);
    vp.setWidth("400px");

    for (Type type : Type.values()) {
      vp.add(format(type.getText()));

      HorizontalPanel hp = new HorizontalPanel();
      hp.setSpacing(5);

      CellButtonBase<?> small = createButton(cat, type);
      CellButtonBase<?> medium = createButton(cat, type);
      CellButtonBase<?> large = createButton(cat, type);

      configureButton(small, type, ButtonScale.SMALL);
      configureButton(medium, type, ButtonScale.MEDIUM);
      configureButton(large, type, ButtonScale.LARGE);

      hp.add(small);
      hp.add(medium);
      hp.add(large);

      vp.add(hp);
    }

    FlowLayoutContainer f = new FlowLayoutContainer();
    f.getScrollSupport().setScrollMode(ScrollMode.AUTO);
    f.add(vp);

    con.add(f);

    return f;
  }

  @Override
  public Widget asWidget() {
    ExampleResources bundle = GWT.create(ExampleResources.class);

    this.style = bundle.style();
    this.style.ensureInjected();

    cp = new ContentPanel(GWT.<ContentPanelAppearance> create(FramedPanelAppearance.class));
    cp.setPixelSize(500, 400);
    cp.getBody().getStyle().setBackgroundColor("white");
    cp.getBody().addClassName(ThemeStyles.getStyle().border());

    con = new CardLayoutContainer();
    cp.add(con);

    ToggleGroup group = new ToggleGroup();

    for (Category cat : Category.values()) {
      final ToggleButton btn = new ToggleButton(cat.desc);
      btn.setData("cat", cat);
      btn.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event) {
          if (event.getValue() == true) {
            onClick((Category) btn.getData("cat"));
          }
        }
      });

      group.add(btn);
      cp.addButton(btn);
    }

    ToggleButton normal = (ToggleButton)cp.getButtonBar().getWidget(0);
    normal.setValue(true, true);

    VerticalPanel vp = new VerticalPanel();
    vp.setSpacing(10);
    vp.add(cp);
    return vp;
  }

  private void onClick(Category cat) {
    FlowLayoutContainer vp = created.get(cat);
    if (vp == null) {
      vp = createButtons(cat);
      created.put(cat, vp);
    }
    con.setWidget(vp);
    cp.setHeadingText(cat.getText());
  }

  private void configureButton(CellButtonBase<?> btn, Type type, ButtonScale scale) {
    btn.setScale(scale);
    switch (type) {

      case LEFT:
        btn.setIconAlign(IconAlign.LEFT);
        break;
      case RIGHT:
        btn.setIconAlign(IconAlign.RIGHT);
        break;
      case BOTTOM:
        btn.setIconAlign(IconAlign.BOTTOM);
        break;
      case TOP:
        btn.setIconAlign(IconAlign.TOP);
        break;
    }

    switch (type) {
      case ICON:
        setIcon(btn, scale);
        break;
      case TEXT:
        btn.setText("Add User");
        break;
      default: {
        setIcon(btn, scale);
        btn.setText("Add User");
      }
    }
  }

  private CellButtonBase<?> createButton(Category cat, Type type) {
    CellButtonBase<?> btn = null;
    switch (cat) {
      case NORMAL:
        btn = new TextButton();
        break;
      case TOGGLE:
        btn = new ToggleButton();
        break;
      case MENU:
        btn = new TextButton();
        btn.setMenu(createMenu());
        break;
      case MENUBOTTOM:
        btn = new TextButton();
        btn.setMenu(createMenu());
        btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
        break;
      case SPLIT:
        btn = new SplitButton();
        btn.setMenu(createMenu());
        break;
      case SPLITBOTTOM:
        btn = new SplitButton();
        btn.setMenu(createMenu());
        btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
        break;
    }
    return btn;
  }

  private Menu createMenu() {
    Menu menu = new Menu();
    menu.add(new MenuItem("Menu Item 1"));
    menu.add(new MenuItem("Menu Item 2"));
    menu.add(new MenuItem("Menu Item 3"));
    return menu;
  }

  private HTML format(String text) {
    HTML html = new HTML(text);
    html.addStyleName(style.section());
    return html;
  }

  private void setIcon(CellButtonBase<?> btn, ButtonScale scale) {
    switch (scale) {
      case SMALL:
        btn.setIcon(Resources.IMAGES.add16());
        break;
      case MEDIUM:
        btn.setIcon(Resources.IMAGES.add24());
        break;

      case LARGE:
        btn.setIcon(Resources.IMAGES.add32());
        break;
    }
  }
}


*/

/*

  <ui:with type="com.gwtcx.client.resources.SalesIcons" field="icons" />


  <ui:style>
    .background {
      background-color: white;
    }
  </ui:style>

          <button:TextButton text="New" icon="{icons.activities}">
          </button:TextButton>

          <toolbar:SeparatorToolItem />

          <toolbar:FillToolItem />


*/