package com.logMonitorDeepak;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("test");
String str = "2018-09-01 22:46:28.285  INFO 14140 --- [     Thread-133] ConfigServletWebServerApplicationContext : Closing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@19cf03a0: startup date [Sat Sep 01 22:46:17 IST 2018]; root of context hierarchy";
//String str = "	at com.logMonitorDeepak.IndexController.result(IndexController.java:34)";

//if(str.toLowerCase().matches("(?at).*at.*")) {
//	System.out.println("str:"+true);
//}

String container = "aBc  De  Fg";
String content = "at";
//System.out.println("containerContainsContent:"+containerContainsContent);
boolean isPresent = str.indexOf("at ") != -1 ? true : false;
System.out.println("isPresent:"+isPresent);

	}

	

}
