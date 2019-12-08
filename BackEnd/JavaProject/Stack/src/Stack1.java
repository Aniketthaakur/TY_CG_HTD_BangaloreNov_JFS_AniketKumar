import java.util.Stack;

public class Stack1 {
public static void main(String[] args) {
	Stack s=new Stack();
	s.add(23);
	s.add(56);
	s.add(67);
	System.out.println(s);
	s.pop();
	System.out.println(s);
	System.out.println(s.peek());
	System.out.println(s);
	s.add(78);
	System.out.println(s.search(56));
	System.out.println(s);
}
}
