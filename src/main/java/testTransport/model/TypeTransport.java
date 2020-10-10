package testTransport.model;

import com.fasterxml.jackson.annotation.JsonValue;


public enum TypeTransport{
  AUTO("автомобіль"),
  BIKE("мотоцикл"),
  BUS("автобус"),
  TRAILER("причіп"),
  BOAT("лодка");

  private final String title;

  @JsonValue
  public String getTitle() {
    return title;
  }

  TypeTransport(String title){
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }


}
