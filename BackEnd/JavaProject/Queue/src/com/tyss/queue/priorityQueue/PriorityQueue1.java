package com.tyss.queue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {
public static void main(String[] args) {
	Queue p=new PriorityQueue();
	p.offer(12);
	p.offer(23);
	p.offer(34);
	p.offer(323);
	p.offer(2);
	System.out.println(p);
	p.poll();
	System.out.println(p);
	p.poll();
	p.poll();
	System.out.println(p);
	for(Object o1:p)
	{
		System.out.println(o1);
	}
	System.out.println(p);
	System.out.println(p.peek());
	System.out.println(p.element());
}
}
