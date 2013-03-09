package com.gwtcx.extgwt.client.field;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.field.TriggerFieldDefaultAppearance;
import com.gwtcx.extgwt.client.field.StringCell.StringCellAppearance;

// See: com\sencha\gxt\theme\base\client\field DateCellDefaultAppearance.java

public class StringCellDefaultAppearance extends TriggerFieldDefaultAppearance implements StringCellAppearance {

  public interface StringCellResources extends TriggerFieldResources {

    @Source({"ValueBaseField.css", "TextField.css", "TriggerField.css"})
    StringCellStyle css();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource textBackground();

    @Source("lookUpFieldArrow.png")
    ImageResource triggerArrow();

    @Source("lookUpFieldArrowOver.png")
    ImageResource triggerArrowOver();

    @Source("lookUpFieldArrowClick.png")
    ImageResource triggerArrowClick();

    @Source("lookUpFieldArrowFocus.png")
    ImageResource triggerArrowFocus();

    ImageResource triggerArrowFocusOver();

    ImageResource triggerArrowFocusClick();
  }

  public interface StringCellStyle extends TriggerFieldStyle {

  }

  public StringCellDefaultAppearance() {
    this(GWT.<StringCellResources> create(StringCellResources.class));
  }

  public StringCellDefaultAppearance(StringCellResources resources) {
    super(resources);
  }

}
