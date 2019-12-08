import java.util.TreeSet;

public class TestEmployee {
public static void main(String[] args) {
	 EmployeeAge e1=new  EmployeeAge();
	 EmployeeName e2=new  EmployeeName();
	 EmployeeSal e3=new  EmployeeSal();
	
	
	
	TreeSet<Employee> t=new TreeSet(e3);
	t.add(new Employee("Aniket",24,50000));
	t.add(new Employee("Nishant",25,5000));
	t.add(new Employee("Vivek",26,500));
	
	for(Employee e:t)
	{
		System.out.println("emoloyee name is "+e.name);
		System.out.println("emoloyee age is "+e.age);
		System.out.println("emoloyee salary is "+e.sal);
		System.out.println("-----------------------");
	}

}
}
