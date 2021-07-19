package calculation;

import properties.*;

public class Calculation {
	
	private String command ;
	
	Dishes ds = new Dishes();
	ListInfo li = new ListInfo();
	
	public Calculation(String command) 
	{
		this.command = command;
		
		if(command.equals("addTotal")) 
		{
			li.total += li.panFriedBun * ds.panFriedBun + li.eightTreasureRice * ds.eightTreasureRice + li.crab * ds.crab + li.soup * ds.soup;
			
			li.total += li.setOne * ds.setOne + li.setTwo * ds.setTwo;
		}
	}

}
