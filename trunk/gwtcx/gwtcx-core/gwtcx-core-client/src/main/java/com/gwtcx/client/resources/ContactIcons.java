package com.gwtcx.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * NavigationPaneIcons client bundle.
 */
public interface ContactIcons extends ClientBundle {

  public static final String urlPrefix = "com/gwtcx/public/gwtcx/skins/aqua/images/icons/16/";

  public static final ContactIcons INSTANCE = GWT.create(ContactIcons.class);

  @Source(urlPrefix + "contact.png")
  ImageResource generalTab();

  @Source(urlPrefix + "details.png")
  ImageResource detailsTab();

  @Source(urlPrefix + "administration.png")
  ImageResource administrationTab();

  @Source(urlPrefix + "notes.png")
  ImageResource notesTab();

}
