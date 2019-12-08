package com.tyss.thread.creatingThread;

public class Testthread2 {
public static void main(String[] args) {
	System.out.println("main strated");
	Thread2 t2=new Thread2();
	 Thread t1=new Thread(t2);
	 t1.start();
	 System.out.println("main ended");
}
}
