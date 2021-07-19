package holders;

public class IdHolder {
	
	private static int Id = 0;
	
	/**
	 * to get the Id
	 * @return
	 */
	public static int getId() 
	{
		return Id;
	}
	/**
	 * add the Id
	 */
	public static void addId() 
	{
		Id++;
	}

}
