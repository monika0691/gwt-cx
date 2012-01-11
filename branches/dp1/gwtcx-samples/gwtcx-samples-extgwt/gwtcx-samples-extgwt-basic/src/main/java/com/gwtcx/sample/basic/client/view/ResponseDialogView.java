package com.gwtcx.sample.basic.client.view;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget.MyView;
import com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class ResponseDialogView extends PopupViewImpl implements MyView {

  public interface Binder extends UiBinder<PopupPanel, ResponseDialogView> { }

  @UiField
  Label labelTextToServer;

  @UiField
  Label labelServerResponse;

  @UiField
  TextButton closeButton;

  private final PopupPanel widget;

  @Inject
  public ResponseDialogView(Binder uiBinder, EventBus eventBus) {
    super(eventBus);

    Log.debug("ResponseDialogView()");

    widget = uiBinder.createAndBindUi(this);
  }

  @Override
  public Widget asWidget() {
    return widget;
  }

  @UiHandler("closeButton")
  void onCloseButtonClicked(SelectEvent event) {

    Log.debug("onCloseButtonClicked()");

    ResponsePagePresenter.closeButtonClicked();

    widget.hide();
  }
}

