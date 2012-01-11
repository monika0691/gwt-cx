package com.gwtcx.sample.basic.client.gin;

import com.google.gwt.core.client.GWT;

public class DesktopGinjectorImpl implements com.gwtcx.sample.basic.client.gin.DesktopGinjector {
  public com.google.gwt.event.shared.EventBus getEventBus() {
    return get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$();
  }
  
  public com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter> getMainPagePresenter() {
    return get_Key$type$com$google$inject$Provider$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$$_annotation$$none$$();
  }
  
  public com.gwtplatform.mvp.client.proxy.PlaceManager getPlaceManager() {
    return get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$();
  }
  
  public com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> getResponsePresenter() {
    return get_Key$type$com$google$gwt$inject$client$AsyncProvider$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter>, annotation=[none]]
   */
  private com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter> create_Key$type$com$google$inject$Provider$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter>() { 
      public com.gwtcx.sample.basic.client.presenter.MainPagePresenter get() { 
        return get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter>, annotation=[none]]
   */
  private com.google.inject.Provider<com.gwtcx.sample.basic.client.presenter.MainPagePresenter> get_Key$type$com$google$inject$Provider$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter$RootView declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.RootPresenter$RootView, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$(com.gwtplatform.mvp.client.RootPresenter.RootView injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.RootPresenter.RootView create_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.mvp.client.RootPresenter.RootView.class);
    assert created instanceof com.gwtplatform.mvp.client.RootPresenter.RootView;
    com.gwtplatform.mvp.client.RootPresenter.RootView result = (com.gwtplatform.mvp.client.RootPresenter.RootView) created;
    
    memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter$RootView declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.RootPresenter$RootView, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.RootPresenter.RootView get_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.place.BasicPlaceManager declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.place.BasicPlaceManager, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$(com.gwtcx.sample.basic.client.place.BasicPlaceManager injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.place.BasicPlaceManager com$gwtcx$sample$basic$client$place$BasicPlaceManager_BasicPlaceManager_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtplatform.mvp.client.proxy.TokenFormatter _1, java.lang.String _2) {
    return new com.gwtcx.sample.basic.client.place.BasicPlaceManager(_0, _1, _2);
  }
  
  private com.gwtcx.sample.basic.client.place.BasicPlaceManager create_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.place.BasicPlaceManager result = com$gwtcx$sample$basic$client$place$BasicPlaceManager_BasicPlaceManager_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$(), get_Key$type$java$lang$String$_annotation$$com$gwtcx$sample$basic$client$place$DefaultPlace$());
    memberInject_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.place.BasicPlaceManager declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.place.BasicPlaceManager, annotation=[none]]
   */
  private com.gwtcx.sample.basic.client.place.BasicPlaceManager get_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$() {
    return create_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.MainPagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyView create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyView$_annotation$$none$$() {
    return get_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.MainPagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyView get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyView$_annotation$$none$$() {
    return create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$(com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter_ResponsePagePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyView _1, com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy _2, com.gwtplatform.mvp.client.proxy.PlaceManager _3, com.gwtplatform.dispatch.shared.DispatchAsync _4, com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget _5) {
    return new com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter(_0, _1, _2, _3, _4, _5);
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter result = com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter_ResponsePagePresenter_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyView$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$());
    memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$(com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor create_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor.class);
    assert created instanceof com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor;
    com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor result = (com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.DefaultSecurityCookieAccessor get_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindSingletonPresenterWidget(AbstractPresenterModule.java:362)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget.MyView create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$() {
    return get_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$();
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget.MyView singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindSingletonPresenterWidget(AbstractPresenterModule.java:362)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget.MyView get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.gwt.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.gwt.event.shared.SimpleEventBus, annotation=[none]]
   */
  private void memberInject_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$(com.google.gwt.event.shared.SimpleEventBus injectee) {
    
  }
  
  private com.google.gwt.event.shared.SimpleEventBus create_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$() {
    Object created = GWT.create(com.google.gwt.event.shared.SimpleEventBus.class);
    assert created instanceof com.google.gwt.event.shared.SimpleEventBus;
    com.google.gwt.event.shared.SimpleEventBus result = (com.google.gwt.event.shared.SimpleEventBus) created;
    
    memberInject_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.google.gwt.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.gwt.event.shared.SimpleEventBus, annotation=[none]]
   */
  private com.google.gwt.event.shared.SimpleEventBus get_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$() {
    return create_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultExceptionHandler declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultExceptionHandler, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$(com.gwtplatform.dispatch.client.DefaultExceptionHandler injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.DefaultExceptionHandler create_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.DefaultExceptionHandler.class);
    assert created instanceof com.gwtplatform.dispatch.client.DefaultExceptionHandler;
    com.gwtplatform.dispatch.client.DefaultExceptionHandler result = (com.gwtplatform.dispatch.client.DefaultExceptionHandler) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.DefaultExceptionHandler declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.DefaultExceptionHandler, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.DefaultExceptionHandler get_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
   */
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry create_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$();
  }
  
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
   */
  private com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$ = create_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.TokenFormatter declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:48)
   */
  private com.gwtplatform.mvp.client.proxy.TokenFormatter create_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.proxy.TokenFormatter singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:48)
   */
  private com.gwtplatform.mvp.client.proxy.TokenFormatter get_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$proxy$TokenFormatter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.DispatchAsync declared at:
   *   protected com.gwtplatform.dispatch.shared.DispatchAsync com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.provideDispatchAsync(com.gwtplatform.dispatch.client.ExceptionHandler,com.gwtplatform.dispatch.shared.SecurityCookieAccessor,com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry)
   */
  private native com.gwtplatform.dispatch.shared.DispatchAsync com$gwtplatform$dispatch$client$gin$DispatchAsyncModule_provideDispatchAsync_methodInjection(com.gwtplatform.dispatch.client.gin.DispatchAsyncModule injectee, com.gwtplatform.dispatch.client.ExceptionHandler _0, com.gwtplatform.dispatch.shared.SecurityCookieAccessor _1, com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry _2) /*-{
    return injectee.@com.gwtplatform.dispatch.client.gin.DispatchAsyncModule::provideDispatchAsync(Lcom/gwtplatform/dispatch/client/ExceptionHandler;Lcom/gwtplatform/dispatch/shared/SecurityCookieAccessor;Lcom/gwtplatform/dispatch/client/actionhandler/ClientActionHandlerRegistry;)(_0, _1, _2);
  }-*/;
  
  private com.gwtplatform.dispatch.shared.DispatchAsync create_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$() {
    return com$gwtplatform$dispatch$client$gin$DispatchAsyncModule_provideDispatchAsync_methodInjection(new com.gwtplatform.dispatch.client.gin.DispatchAsyncModule(), get_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$(), get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$());
  }
  
  private com.gwtplatform.dispatch.shared.DispatchAsync singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   protected com.gwtplatform.dispatch.shared.DispatchAsync com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.provideDispatchAsync(com.gwtplatform.dispatch.client.ExceptionHandler,com.gwtplatform.dispatch.shared.SecurityCookieAccessor,com.gwtplatform.dispatch.client.actionhandler.ClientActionHandlerRegistry)
   */
  private com.gwtplatform.dispatch.shared.DispatchAsync get_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$ = create_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$dispatch$shared$DispatchAsync$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindSingletonPresenterWidget(AbstractPresenterModule.java:361)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$(com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection_(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget_ResponseDialogPresenterWidget_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget.MyView _1) {
    return new com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget(_0, _1);
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget result = com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget_ResponseDialogPresenterWidget_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$MyView$_annotation$$none$$());
    memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindSingletonPresenterWidget(AbstractPresenterModule.java:361)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponseDialogPresenterWidget get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponseDialogPresenterWidget$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.MainPagePresenter$MyProxy declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$(com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$() {
    Object created = GWT.create(com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy.class);
    assert created instanceof com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy;
    com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy result = (com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy) created;
    
    memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.RootPresenter declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection__(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$(com.gwtplatform.mvp.client.RootPresenter injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection__(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.gwtplatform.mvp.client.RootPresenter com$gwtplatform$mvp$client$RootPresenter_RootPresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtplatform.mvp.client.RootPresenter.RootView _1) {
    return new com.gwtplatform.mvp.client.RootPresenter(_0, _1);
  }
  
  private com.gwtplatform.mvp.client.RootPresenter create_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$() {
    com.gwtplatform.mvp.client.RootPresenter result = com$gwtplatform$mvp$client$RootPresenter_RootPresenter_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$RootPresenter$RootView$_annotation$$none$$());
    memberInject_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtplatform.mvp.client.RootPresenter singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
   */
  private com.gwtplatform.mvp.client.RootPresenter get_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.ResponsePageView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$(com.gwtcx.sample.basic.client.view.ResponsePageView injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.view.ResponsePageView com$gwtcx$sample$basic$client$view$ResponsePageView_ResponsePageView_methodInjection() {
    return new com.gwtcx.sample.basic.client.view.ResponsePageView();
  }
  
  private com.gwtcx.sample.basic.client.view.ResponsePageView create_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.view.ResponsePageView result = com$gwtcx$sample$basic$client$view$ResponsePageView_ResponsePageView_methodInjection();
    memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.view.ResponsePageView singleton_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private com.gwtcx.sample.basic.client.view.ResponsePageView get_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.ResponseDialogView$Binder declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.view.ResponseDialogView$Binder, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$(com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder create_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$() {
    Object created = GWT.create(com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder.class);
    assert created instanceof com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder;
    com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder result = (com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder) created;
    
    memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.ResponseDialogView$Binder declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.view.ResponseDialogView$Binder, annotation=[none]]
   */
  private com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder get_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$() {
    return create_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$(com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry injectee) {
    
  }
  
  private com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry create_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry.class);
    assert created instanceof com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry;
    com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry result = (com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry) created;
    
    memberInject_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry declared at:
   *   Implicit binding for Key[type=com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry, annotation=[none]]
   */
  private com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry get_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$actionhandler$DefaultClientActionHandlerRegistry$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:50)
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:50)
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalytics get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalytics$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyView create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyView$_annotation$$none$$() {
    return get_Key$type$com$gwtcx$sample$basic$client$view$ResponsePageView$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter$MyView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:126)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyView get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyView$_annotation$$none$$() {
    return create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$() {
    Object created = GWT.create(com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl.class);
    assert created instanceof com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl;
    com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl result = (com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl) created;
    
    memberInject_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.googleanalytics.GoogleAnalyticsImpl get_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$googleanalytics$GoogleAnalyticsImpl$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.ResponseDialogView declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.view.ResponseDialogView, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$(com.gwtcx.sample.basic.client.view.ResponseDialogView injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.view.ResponseDialogView com$gwtcx$sample$basic$client$view$ResponseDialogView_ResponseDialogView_methodInjection(com.gwtcx.sample.basic.client.view.ResponseDialogView.Binder _0, com.google.gwt.event.shared.EventBus _1) {
    return new com.gwtcx.sample.basic.client.view.ResponseDialogView(_0, _1);
  }
  
  private com.gwtcx.sample.basic.client.view.ResponseDialogView create_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.view.ResponseDialogView result = com$gwtcx$sample$basic$client$view$ResponseDialogView_ResponseDialogView_methodInjection(get_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$Binder$_annotation$$none$$(), get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.ResponseDialogView declared at:
   *   Implicit binding for Key[type=com.gwtcx.sample.basic.client.view.ResponseDialogView, annotation=[none]]
   */
  private com.gwtcx.sample.basic.client.view.ResponseDialogView get_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$() {
    return create_Key$type$com$gwtcx$sample$basic$client$view$ResponseDialogView$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter$MyProxy declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$(com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$() {
    Object created = GWT.create(com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy.class);
    assert created instanceof com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy;
    com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy result = (com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy) created;
    
    memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
   */
  private com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter.MyProxy get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter>, annotation=[none]]
   */
  private com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> create_Key$type$com$google$gwt$inject$client$AsyncProvider$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$$_annotation$$none$$() {
    return new com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter>() { 
        public void get(final com.google.gwt.user.client.rpc.AsyncCallback<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> callback) { 
          com.google.gwt.core.client.GWT.runAsync(new com.google.gwt.core.client.RunAsyncCallback() { 
            public void onSuccess() { 
              callback.onSuccess(get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$_annotation$$none$$()); 
            }
            public void onFailure(Throwable ex) { 
               callback.onFailure(ex); 
            } 
        }); 
        }
     };
    
  }
  
  
  /**
   * Binding for com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> declared at:
   *   Implicit binding for Key[type=com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter>, annotation=[none]]
   */
  private com.google.gwt.inject.client.AsyncProvider<com.gwtcx.sample.basic.client.presenter.ResponsePagePresenter> get_Key$type$com$google$gwt$inject$client$AsyncProvider$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$$_annotation$$none$$() {
    return create_Key$type$com$google$gwt$inject$client$AsyncProvider$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$(com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView injectee) {
    
  }
  
  private com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView_MainPageDesktopView_methodInjection() {
    return new com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView();
  }
  
  private com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView create_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView result = com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView_MainPageDesktopView_methodInjection();
    memberInject_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView singleton_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:124)
   */
  private com.gwtcx.sample.basic.client.view.desktop.MainPageDesktopView get_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$view$desktop$MainPageDesktopView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.PlaceManager declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:51)
   */
  private com.gwtplatform.mvp.client.proxy.PlaceManager create_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$() {
    return get_Key$type$com$gwtcx$sample$basic$client$place$BasicPlaceManager$_annotation$$none$$();
  }
  
  private com.gwtplatform.mvp.client.proxy.PlaceManager singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:51)
   */
  private com.gwtplatform.mvp.client.proxy.PlaceManager get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.SecurityCookieAccessor declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:180)
   */
  private com.gwtplatform.dispatch.shared.SecurityCookieAccessor create_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$DefaultSecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.shared.SecurityCookieAccessor declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:180)
   */
  private com.gwtplatform.dispatch.shared.SecurityCookieAccessor get_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$shared$SecurityCookieAccessor$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for java.lang.String declared at:
   *   com.gwtcx.sample.basic.client.gin.SharedGinModule.configure(SharedGinModule.java:57)
   */
  private java.lang.String create_Key$type$java$lang$String$_annotation$$com$gwtcx$sample$basic$client$place$DefaultPlace$() {
    return "MainPage";
  }
  
  
  /**
   * Binding for java.lang.String declared at:
   *   com.gwtcx.sample.basic.client.gin.SharedGinModule.configure(SharedGinModule.java:57)
   */
  private java.lang.String get_Key$type$java$lang$String$_annotation$$com$gwtcx$sample$basic$client$place$DefaultPlace$() {
    return create_Key$type$java$lang$String$_annotation$$com$gwtcx$sample$basic$client$place$DefaultPlace$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.event.shared.EventBus declared at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:47)
   */
  private com.google.gwt.event.shared.EventBus create_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$() {
    return get_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  private com.google.gwt.event.shared.EventBus singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:47)
   */
  private com.google.gwt.event.shared.EventBus get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ = create_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$(com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter injectee) {
    
  }
  
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter_ParameterTokenFormatter_methodInjection() {
    return new com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter();
  }
  
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter create_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$() {
    com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter result = com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter_ParameterTokenFormatter_methodInjection();
    memberInject_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.proxy.ParameterTokenFormatter get_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$mvp$client$proxy$ParameterTokenFormatter$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtcx.sample.basic.client.presenter.MainPagePresenter declared at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private native void com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___(com.gwtplatform.mvp.client.HandlerContainerImpl injectee, com.gwtplatform.mvp.client.AutobindDisable _0) /*-{
    injectee.@com.gwtplatform.mvp.client.HandlerContainerImpl::automaticBind(Lcom/gwtplatform/mvp/client/AutobindDisable;)(_0);
  }-*/;
  
  private void memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$(com.gwtcx.sample.basic.client.presenter.MainPagePresenter injectee) {
    com$gwtplatform$mvp$client$HandlerContainerImpl_automaticBind_methodInjection___(injectee, get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$());
    
  }
  
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter com$gwtcx$sample$basic$client$presenter$MainPagePresenter_MainPagePresenter_methodInjection(com.google.gwt.event.shared.EventBus _0, com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyView _1, com.gwtcx.sample.basic.client.presenter.MainPagePresenter.MyProxy _2, com.gwtplatform.mvp.client.proxy.PlaceManager _3) {
    return new com.gwtcx.sample.basic.client.presenter.MainPagePresenter(_0, _1, _2, _3);
  }
  
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$() {
    com.gwtcx.sample.basic.client.presenter.MainPagePresenter result = com$gwtcx$sample$basic$client$presenter$MainPagePresenter_MainPagePresenter_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyView$_annotation$$none$$(), get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$(), get_Key$type$com$gwtplatform$mvp$client$proxy$PlaceManager$_annotation$$none$$());
    memberInject_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:123)
   */
  private com.gwtcx.sample.basic.client.presenter.MainPagePresenter get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$ = create_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.ExceptionHandler declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:179)
   */
  private com.gwtplatform.dispatch.client.ExceptionHandler create_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$() {
    return get_Key$type$com$gwtplatform$dispatch$client$DefaultExceptionHandler$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.gwtplatform.dispatch.client.ExceptionHandler declared at:
   *   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:179)
   */
  private com.gwtplatform.dispatch.client.ExceptionHandler get_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$() {
    return create_Key$type$com$gwtplatform$dispatch$client$ExceptionHandler$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.gwtplatform.mvp.client.AutobindDisable declared at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.AutobindDisable, annotation=[none]]
   */
  private void memberInject_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$(com.gwtplatform.mvp.client.AutobindDisable injectee) {
    
  }
  
  private native com.gwtplatform.mvp.client.AutobindDisable com$gwtplatform$mvp$client$AutobindDisable_AutobindDisable_methodInjection() /*-{
    return @com.gwtplatform.mvp.client.AutobindDisable::new()();
  }-*/;
  
  private com.gwtplatform.mvp.client.AutobindDisable create_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$() {
    com.gwtplatform.mvp.client.AutobindDisable result = com$gwtplatform$mvp$client$AutobindDisable_AutobindDisable_methodInjection();
    memberInject_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$(result);
    return result;
  }
  
  private com.gwtplatform.mvp.client.AutobindDisable singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.gwtplatform.mvp.client.AutobindDisable, annotation=[none]]
   */
  private com.gwtplatform.mvp.client.AutobindDisable get_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$() {
    if (singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ == null) {
      singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$ = create_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$();
    }
    return singleton_Key$type$com$gwtplatform$mvp$client$AutobindDisable$_annotation$$none$$;
  }
  
  public DesktopGinjectorImpl() {
    // Eager singleton bound at:
    //   com.gwtplatform.dispatch.client.gin.DispatchAsyncModule.configure(DispatchAsyncModule.java:181)
    get_Key$type$com$gwtplatform$dispatch$client$actionhandler$ClientActionHandlerRegistry$_annotation$$none$$();
    // Eager singleton bound at:
    //   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
    get_Key$type$com$gwtcx$sample$basic$client$presenter$MainPagePresenter$MyProxy$_annotation$$none$$();
    // Eager singleton bound at:
    //   com.gwtplatform.mvp.client.gin.DefaultModule.configure(DefaultModule.java:49)
    get_Key$type$com$gwtplatform$mvp$client$RootPresenter$_annotation$$none$$();
    // Eager singleton bound at:
    //   com.gwtplatform.mvp.client.gin.AbstractPresenterModule.bindPresenter(AbstractPresenterModule.java:125)
    get_Key$type$com$gwtcx$sample$basic$client$presenter$ResponsePagePresenter$MyProxy$_annotation$$none$$();
    
  }
  
}
