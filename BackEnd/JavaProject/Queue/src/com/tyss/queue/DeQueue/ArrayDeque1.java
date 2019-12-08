package com.tyss.queue.DeQueue;

import java.util.ArrayDeque;

public class ArrayDeque1 {
public static void main(String[] args) {
	ArrayDeque<String> a=new ArrayDeque<String>();
	a.add("Ani");
	a.add("ket");
	a.add("puja");
	a.addFirst("Thakur");
	a.addLast("Aniket");
	System.out.println(a);
	System.out.println(a.getFirst());
	System.out.println(a.getLast());
	a.remove("Ani");
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	a.removeLast();
	System.out.println(a);
	a.offer("priya");
	a.add("Bijeet");
	System.out.println(a);
	a.removeFirstOccurrence("priya");
	System.out.println(a);
	a.addLast("ket");
	System.out.println(a);
	a.removeLastOccurrence("ket");
	System.out.println(a);
	System.out.println(a.peek());
	System.out.println(a.peekFirst());
	System.out.println(a.peekLast());
	System.out.println(a.poll());
	System.out.println(a);
	System.out.println(a.pollFirst());
	System.out.println(a);
	System.out.println(a.pollLast());
	System.out.println(a);
	a.offer("anikey");
	a.offer("Divya");
	a.offer("Anu");
	System.out.println(a);
	System.out.println(a.offerFirst("anikey"));
	a.offerLast("Anu");
	System.out.println(a);
	a.push("aniket");
	System.out.println(a);
	System.out.println(a.pop());
	System.out.println(a.element());
	
}
}
