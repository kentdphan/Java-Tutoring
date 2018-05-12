public class Sleep
{
    public void sleeper(long sleepTime) {
	//start sleeper() 
	System.out.println("Sleeping until next generation...");
	try
	    {
		Thread.sleep(sleepTime);
	    }
	catch(Exception ex)
	    {
		System.out.println("Exception:"+ex.getStackTrace());
	    }
    } 
}