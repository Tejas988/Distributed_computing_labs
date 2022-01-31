import java.rmi.*;
import java.rmi.server.*;

public class Multiply extends UnicastRemoteObject implements MultiplyInterface{
	
	Multiply() throws RemoteException{
		super();
	}
	public int multiply(int n1,int n2) throws RemoteException{
		int num1=n1;
		int num2=n2;
		return num1*num2;
	}
}