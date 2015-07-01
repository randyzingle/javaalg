package com.bms.setup;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;

public class MainRunner {
  public static void main(String[] args) {
    ArrayList<String> plist = new ArrayList<String>();
    plist.add("Baldur");
    plist.add("Mymir");
    plist.add("Butters");
    for (String s: plist) {
      System.out.println(s);
    }

    try {
      // read a file
      System.out.println("Trying to read the hello file...");
      System.out.println("Working Directory = " + System.getProperty("user.dir"));
      BufferedReader br = new BufferedReader(new FileReader("src/main/resources/hello.txt"));
      String s = null;
      while ( (s = br.readLine()) != null) {
        System.out.println(s);
      }

      // convert an annotated POJO to json
      ObjectMapper mapper = new ObjectMapper();
      Person p = new Person();
      p.firstName = "Baldur";
      p.lastName = "Zingle";
      s = mapper.writeValueAsString(p);
      System.out.println("Json object: ");
      System.out.println(s);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}