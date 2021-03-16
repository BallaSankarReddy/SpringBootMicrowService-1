package com.eurekaserver.registration.service;

import java.util.stream.Stream;

public class Test {
public static void main(String[] args) {
	Integer x =9; // 7
	Integer y =7; // 9
	
	x=x+y;
	y=x-y;
	x=x-y;
	

	//System.out.println(x +" "+y);
	Stream<Integer> limit = Stream.iterate(0, n->n+1).limit(10);
	 long count = Stream.iterate(0, n->n+1).limit(10).
			 count();
	System.out.println(count);


}
}
