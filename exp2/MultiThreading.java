class Execute 
{   
    public int arr[]={1,2,3,4,5,6,7,8,9,10};
    static int indx=0;
    synchronized public void printAr()
    {   
        while(indx!=10)
        {   
            notify();
            System.out.println("Child " +Thread.currentThread().getName() +" printing "+ arr[indx]);
            indx++;
            try
            {  
                wait();
            }
            catch(Exception e){System.out.println(e);} 
        }
        notifyAll();
    }
    
}

class ChildThread extends Thread {
    Execute e;
    ChildThread(Execute e)
    {
        this.e=e; 
    }
    public void run()
    {  
        e.printAr();
    }
}

public class MultiThreading
{
	public static void main(String[] args) {
        System.out.println("Current Thread : "+Thread.currentThread().getName());
		Execute e=new Execute();
		ChildThread m=new ChildThread(e);
		ChildThread n = new ChildThread(e);
		m.start();
		n.start();
        try{
            m.join();
        }   
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        try{
            n.join();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Current Thread : "+Thread.currentThread().getName());
	}
}