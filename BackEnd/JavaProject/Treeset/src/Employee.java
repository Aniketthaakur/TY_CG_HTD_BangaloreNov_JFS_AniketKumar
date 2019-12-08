
public class Employee implements Comparable<Employee> {
 String name;
 int age;
 double sal;
public Employee(String name, int age, double sal) {
	super();
	this.name = name;
	this.age = age;
	this.sal = sal;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", age=" + age + ", sal=" + sal + "]";
}
//@Override
//public int compareTo(Employee o) {
//    if(this.age>o.age)
//    {
//    	return 1;
//    	
//    }
//    else if(this.age<o.age)
//     {
//       	return -1;
//     }
//    else
//    {	
//    	return 0;
//}
//@Override
//public int compareTo(Employee o) {
//    if(this.sal>o.sal)
//    {
//    	return 1;
//    	
//    }
//    else if(this.sal<o.sal)
//     {
//       	return -1;
//     }
//    else
//    {	
//    	return 0;
//}

@Override
public int compareTo(Employee o) {
    
  return this.name.compareTo(o.name);
}
}
 

