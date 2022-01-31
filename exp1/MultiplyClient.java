import java.rmi.Naming;
import java.util.*;
public class MultiplyClient{
	public static void main(String[] args) {
		try
		{		
			MultiplyInterface ai=(MultiplyInterface)Naming.lookup("//localhost/Multiply");
			System.out.println("Enter two numbers to multiply");
			Scanner sc= new Scanner(System.in);
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			int op=ai.multiply(n1,n2);
			System.out.println("Multiplication is : "+op);
		}
		catch(Exception e)
		{
			System.out.println("Client Exception : "+ e);
		}
	}
}