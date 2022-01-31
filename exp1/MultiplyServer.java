import java.rmi.Naming;

public class MultiplyServer{

	public static void main(String[] args) {

		try
		{
			Naming.rebind("Multiply",new Multiply());
			System.out.println("Server is connected and waiting for client");

		}
		catch(Exception e)
		{
			System.out.println("Exception : "+ e);
		}

	}
}