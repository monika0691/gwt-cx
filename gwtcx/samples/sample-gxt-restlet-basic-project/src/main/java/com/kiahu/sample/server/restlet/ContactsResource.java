package com.kiahu.sample.server.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ContactsResource extends ServerResource {

  @Get
  public String represent() {
    return "hello, world";
  }
}
