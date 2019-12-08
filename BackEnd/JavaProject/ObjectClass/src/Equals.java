
public class Equals {
  String empName;
  int empId;
public Equals(String empName,int empId)
  {
	super();
	this.empName=empName;
	this.empId=empId;
}
  
  public boolean equals(Object obj)
  {
	  Equals e1=(Equals)obj;
	  if(e1.empId==this.empId)
	  {
		 if(e1.empName.equals(this.empName))
		 {
			 return true;
		 }
	  else
	  {
		  return false;
	  }
	  } else  {
  return false;
  
		 }
	  }}
  
  	  
