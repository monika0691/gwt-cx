package com.gwtcx.shared.dto;

public class ContactDto extends EntityDto {

  private static final long serialVersionUID = 3434148714982575460L;

  protected String givenName;
  protected String middleName;
  protected String familyName;

  public ContactDto() {
    super();
  }

  public ContactDto(String id) {
    super(id);
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

}
