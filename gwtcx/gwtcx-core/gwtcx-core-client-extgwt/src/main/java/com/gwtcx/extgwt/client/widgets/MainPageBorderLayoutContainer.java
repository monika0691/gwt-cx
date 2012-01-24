package com.gwtcx.extgwt.client.widgets;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class MainPageBorderLayoutContainer extends BorderLayoutContainer {

  {
    monitorWindowResize = true;
    Window.enableScrolling(false);
    Window.setMargin("0px");
    setPixelSize(Window.getClientWidth(), Window.getClientHeight());
  }

  @Inject
  public MainPageBorderLayoutContainer() {
    super();

    Log.debug("MainPageBorderLayoutContainer()");
  }

  @Inject
  public MainPageBorderLayoutContainer(BorderLayoutAppearance appearance) {
    super(appearance);

    Log.debug("MainPageBorderLayoutContainer(BorderLayoutAppearance appearance)");
  }

  @Override
  protected void onWindowResize(int width, int height) {

    Log.debug("onWindowResize(width: " + width + " height: " + height);

    setPixelSize(width, height);
  }
}
