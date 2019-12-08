
public class Student {
String studName;
int age;
public Student(String studName, int age) {
	super();
	this.studName = studName;
	this.age = age;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((studName == null) ? 0 : studName.hashCode());
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
	Student other = (Student) obj;
	if (age != other.age)
		return false;
	if (studName == null) {
		if (other.studName != null)
			return false;
	} else if (!studName.equals(other.studName))
		return false;
	return true;
}


}
