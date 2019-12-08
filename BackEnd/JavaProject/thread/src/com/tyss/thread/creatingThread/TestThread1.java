package com.tyss.thread.creatingThread;

public class TestThread1 {
public static void main(String[] args) {
	Thread1 t1=new Thread1();
	System.out.println("main started");
	t1.start();
	System.out.println("main ended");
}
}
