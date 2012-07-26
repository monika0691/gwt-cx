package com.kiahu.sample.client.presenter.tablet;

import com.allen_sauer.gwt.log.client.Log;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.Animation;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Place;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.kiahu.sample.client.NameTokens;
import com.kiahu.sample.client.event.RevealAnimatableDisplayContentEvent;

public class FadePresenter extends
    Presenter<FadePresenter.MyView, FadePresenter.MyProxy> {

  //
  //
  // don't forget to update your Ginjector & SharedGinModule
  //
  @ProxyCodeSplit
  @NameToken(NameTokens.fade)
  public interface MyProxy extends Proxy<FadePresenter>, Place {
  }

  public interface MyView extends View {
  }

  @Inject
  public FadePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
    super(eventBus, view, proxy);

    Log.debug("FadePresenter()");
  }

  @Override
  protected void revealInParent() {
    RevealAnimatableDisplayContentEvent.fire(this, MgwtRootPresenter.TYPE_SetContextAreaContent, this, getAnimation());
  }

  private Animation getAnimation(){
    return Animation.FADE;
  }
}