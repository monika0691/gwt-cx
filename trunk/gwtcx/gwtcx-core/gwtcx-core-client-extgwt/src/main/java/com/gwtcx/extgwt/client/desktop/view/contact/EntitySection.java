package com.gwtcx.extgwt.client.desktop.view.contact;

import com.allen_sauer.gwt.log.client.Log;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;

public abstract class EntitySection<T> {

  private HtmlLayoutContainer panel;

  @SuppressWarnings("unused")
  private EntitySection() { }

  public EntitySection(final HtmlLayoutContainer panel) {

    this.panel = panel;
  }

  public HtmlLayoutContainer getPanel() { return panel; }

  public void createFields() {
    Log.warn("Don't forget to @Override createFields()");
  }

  public void setFields(T dto) {
    Log.warn("Don't forget to @Override setFields()");
  }

  public void getFields(T dto) {
    Log.warn("Don't forget to @Override getFields()");
  }
}
