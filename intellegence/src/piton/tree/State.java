package piton.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * implement state of task about wolf,koza,kapusta
 * @author piton 01/10/13   
 * 
 * */
public class State implements Cloneable,IState<State>{
	
	public HashMap<String, Boolean> Right_side;
	public HashMap<String, Boolean> Left_side;
	
	public String Locate;
	
	public State(boolean wolf, boolean koza, boolean kapusta, String locate){
		Right_side = new HashMap<String,Boolean>();
		Right_side.put("Wolf", false);
		Right_side.put("Cabbage", false);
		Right_side.put("Goat", false);
		
		Left_side = new HashMap<String,Boolean>();
		Left_side.put("Wolf", false);
		Left_side.put("Cabbage", false);
		Left_side.put("Goat", false);
		this.Locate = new String(locate);
		
		if (locate == "R" )
		{
			Right_side.put("Wolf", wolf);
			Right_side.put("Cabbage", kapusta);
			Right_side.put("Goat", koza);
		}
		else
		{
			Left_side.put("Wolf", wolf);
			Left_side.put("Cabbage", kapusta);
			Left_side.put("Goat", koza);
		}
	}
	
	public State() {
		// TODO Auto-generated constructor stub
	}

	public boolean IsPossibleState()
	{
		if(
				(Right_side.get("Wolf")&&Right_side.get("Goat")&&Locate.equals("L"))
				||(Right_side.get("Cabbage")&&Right_side.get("Goat")&&Locate.equals("L"))
				||(Left_side.get("Cabbage")&&Left_side.get("Goat")&&Locate.equals("R"))
				||(Left_side.get("Wolf")&&Left_side.get("Goat"))&&Locate.equals("R"))
		{
			return false;
		}
		else 
			return true;
	}
	
	public boolean IsFinState()
	{
		if (Right_side.get("Wolf")&&Right_side.get("Goat")&& Right_side.get("Cabbage"))
			return true;
		return false;
	}
	
	public void Print()
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("Lodka at:"+ this.Locate);
		System.out.println("Right side "+Right_side.get("Wolf").toString()+" "+Right_side.get("Cabbage").toString()+ " "+ Right_side.get("Goat").toString());
		System.out.println("Left side "+Left_side.get("Wolf").toString()+" "+Left_side.get("Cabbage").toString()+ " "+ Left_side.get("Goat").toString());
	}
	
	public State clone() throws CloneNotSupportedException {
        State clone = new State();//(State)super.clone();
        clone.Left_side = (HashMap<String, Boolean>)this.Left_side.clone();
        clone.Right_side= (HashMap<String, Boolean>)this.Right_side.clone();
        //clone.Locate = new String(this.Locate);
        return clone;
  }

	@Override
	public ArrayList<State> getAllChild(State input) {
		 // create list of new state 
		  ArrayList <State> Result = new ArrayList<State>();
		  State CurrentState = input;
		 // for each state in input item change vice versa
		  
		  try{
			  
		  for(Entry<String, Boolean> entry: CurrentState.Right_side.entrySet())
			{
				State NewState = new State(true, true, true, "L");
						NewState = CurrentState.clone();
				NewState.Locate = new String();
				NewState.Left_side.put(entry.getKey(), entry.getValue());
				NewState.Right_side.put(entry.getKey(), !entry.getValue());
				
				if(CurrentState.Locate.equals("L"))NewState.Locate = "R";
				else NewState.Locate ="L";
			 // if it's possible state adding in list	
				if (NewState.IsPossibleState()) {
					Result.add(NewState);
				}
			}
		// also get state when only plot change side
			  State NewState =  new State();
			  NewState = CurrentState.clone();
			  if(CurrentState.Locate.equals("L"))NewState.Locate = "R";
				else NewState.Locate ="L";
			  if (NewState.IsPossibleState()) {
					Result.add(NewState);
			 }
		  }
		  catch(Exception ex){ex.printStackTrace();}
		 // return list 
		
		 return Result;
		
	}
	
}
