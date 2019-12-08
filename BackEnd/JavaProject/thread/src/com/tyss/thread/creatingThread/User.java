package com.tyss.thread.creatingThread;

public class User extends Thread{
Pvr p;
public User(Pvr p)
{
	this.p=p;
}

@Override
public void run()
{
	p.confirmTickets();
}
}
