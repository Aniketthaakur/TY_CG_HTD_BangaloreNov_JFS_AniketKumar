import java.io.FileInputStream;
import java.io.IOException;

public class fileInput {
public static void main(String[] args) {
	
	try {
		FileInputStream f1 = new FileInputStream("anu.txt");
		int j=0;
	while((j=f1.read())!=-1)
{
	System.out.println((char)j);
}
	}catch (Exception e) {
  System.out.println(e.getMessage());
}

}
}
