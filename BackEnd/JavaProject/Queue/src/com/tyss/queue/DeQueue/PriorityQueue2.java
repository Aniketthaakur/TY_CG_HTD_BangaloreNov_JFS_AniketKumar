package com.tyss.queue.DeQueue;

import java.util.PriorityQueue;

public class PriorityQueue2 {
public static void main(String[] args) {
	PriorityQueue p=new PriorityQueue();
	p.offer(new Student(22,"anu"));
	p.offer(new Student(23,"shree"));

	p.offer(new Student(22,"anu"));
	
	for(Object o:p)
	{
		System.out.println(o);
	}
}
}
