package com.kiahu.sample.server.guice;

import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.shared.ActionImpl;

public class BasicProjectServletModule extends ServletModule {

  @Override
  public void configureServlets() {
    bindConstants();
    bindFilters();
    bindServlets();
  }

  protected void bindConstants() {
    // Protect against XSRF attacks - securityCookieName = "JSESSIONID";
    // bindConstant().annotatedWith(SecurityCookie.class).to(SharedTokens.securityCookieName);
  }

  protected void bindFilters() {
  }

  public static final String DEFAULT_SERVICE_PATH = "/";

  protected void bindServlets() {
    serve(DEFAULT_SERVICE_PATH + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(
        DispatchServiceImpl.class);
  }
}
