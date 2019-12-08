
public class Employee {
String empName;
int empAge;
public Employee(String empName, int empAge) {
	super();
	this.empName = empName;
	this.empAge = empAge;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empAge;
	result = prime * result + ((empName == null) ? 0 : empName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (empAge != other.empAge)
		return false;
	if (empName == null) {
		if (other.empName != null)
			return false;
	} else if (!empName.equals(other.empName))
		return false;
	return true;
}
@Override
public String toString() {
	return "Employee [empName=" + empName + ", empAge=" + empAge + "]";
}

}
