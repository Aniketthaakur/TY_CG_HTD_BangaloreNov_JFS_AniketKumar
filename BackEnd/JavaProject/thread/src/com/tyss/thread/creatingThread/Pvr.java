package com.tyss.thread.creatingThread;

public class Pvr {

	synchronized	void confirmTickets()
	{
		for(int i=0;i<4;i++)
		{
			System.out.println(i);
//			try {
//				wait();
//			} catch (InterruptedException e1) {
//				System.out.println(e1.getMessage());
//			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	synchronized void  leaveMe()
	{
		System.out.println("notify called");
		notify();
	}

}
