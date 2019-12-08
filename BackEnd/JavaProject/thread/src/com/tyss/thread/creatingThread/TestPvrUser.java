package com.tyss.thread.creatingThread;

public class TestPvrUser {
public static void main(String[] args) {
   System.out.println("main started");	
   Pvr p=new Pvr();
   
   User u=new User(p);
   u.start();
   
   User u1=new User(p);
   u1.start();
//   
//   try {
//	Thread.sleep(1000);
//} catch (InterruptedException e) {
//	System.out.println(e.getMessage());
//}
   
   p.leaveMe();
   System.out.println("main Ended");

}
}
