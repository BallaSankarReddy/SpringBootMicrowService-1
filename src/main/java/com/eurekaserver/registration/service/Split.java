package com.eurekaserver.registration.service;

public class Split {
public static void main(String[] args) {
	String input = "2020-02-11T:36:30.072Z".replaceAll("[T,Z,-,:,.]", "-") ;
	System.out.println(input);
	String[] stringarray = input.split(".");
	
	String[] bits = input.split("-");
	String lastOne = bits[bits.length-1];
	System.out.println(lastOne);

}
}
