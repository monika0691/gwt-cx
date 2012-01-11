package com.gwtcx.shared.dto;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AddressDto_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.gwtcx.shared.dto.AddressDto instance) throws SerializationException {
    instance.addressId = (java.lang.Long) streamReader.readObject();
    instance.addressLine1 = streamReader.readString();
    instance.addressLine2 = streamReader.readString();
    instance.addressLine3 = streamReader.readString();
    instance.addressName = streamReader.readString();
    instance.addressType = streamReader.readString();
    instance.city = streamReader.readString();
    instance.country = streamReader.readString();
    instance.postalCode = streamReader.readString();
    instance.state = streamReader.readString();
    
  }
  
  public static com.gwtcx.shared.dto.AddressDto instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.gwtcx.shared.dto.AddressDto();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.gwtcx.shared.dto.AddressDto instance) throws SerializationException {
    streamWriter.writeObject(instance.addressId);
    streamWriter.writeString(instance.addressLine1);
    streamWriter.writeString(instance.addressLine2);
    streamWriter.writeString(instance.addressLine3);
    streamWriter.writeString(instance.addressName);
    streamWriter.writeString(instance.addressType);
    streamWriter.writeString(instance.city);
    streamWriter.writeString(instance.country);
    streamWriter.writeString(instance.postalCode);
    streamWriter.writeString(instance.state);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.gwtcx.shared.dto.AddressDto_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AddressDto_FieldSerializer.deserialize(reader, (com.gwtcx.shared.dto.AddressDto)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.gwtcx.shared.dto.AddressDto_FieldSerializer.serialize(writer, (com.gwtcx.shared.dto.AddressDto)object);
  }
  
}
