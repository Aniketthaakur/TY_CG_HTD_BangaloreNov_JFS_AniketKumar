import java.io.FileOutputStream;
import java.io.IOException;

public class FileOUTPUT {
public static void main(String[] args) {
	try {
	FileOutputStream f1=new FileOutputStream("ani.txt");
	
	String s="Divya bogar";
	byte b[]=s.getBytes();
	
		f1.write(b);
		System.out.println("sucess.....");
	} catch (IOException e) {
     System.out.println(e.getMessage());
	}
}
}
