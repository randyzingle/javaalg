package com.bms.setup;

import com.fasterxml.jackson.annotation.*;

public class Person {
  
  @JsonProperty("firstName")
  public String firstName;

  @JsonProperty("lastName")
  public String lastName;
  
}