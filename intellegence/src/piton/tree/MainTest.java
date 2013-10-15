package piton.tree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map.Entry;



public class MainTest {

	public static void main(String[] args) throws CloneNotSupportedException, NodeException {
		// TODO Auto-generated method stub
		
		//create the initial state which all position on the left side
		Node<State> input = new  Node<State>(new State(true, true, true, "L"));
		
		ArrayList<Node> fringe = new ArrayList<Node>();
		//add this state to list of searching states
		fringe.add(input);
		try
		{
			//get item from the list of searching
			while(!fringe.isEmpty()){
				Node<State> CurrentNode = fringe.get(0); 
				State CurrentState =  (State)CurrentNode.GetContent();	
			//if this state is goal return this
				if (CurrentState.IsFinState()){
			//print result
					while(CurrentNode!=null)
					{
						State StateNow = (State)CurrentNode.GetContent();
						StateNow.Print();
						CurrentNode = CurrentNode.GetParent();
					}
				}
			//else create all possible state from this position
			ArrayList<Node<State>> Childs = GetAllChild(CurrentNode);
			fringe.addAll(Childs);
			//remove expanded state and add all his possible child state to the list of searching
			fringe.remove(CurrentNode);
			//return to step 2
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		Tree SlovedTree =  new Tree(input);
	}
	
	public static ArrayList<Node<State>> GetAllChild(Node input)
	{
	 // create list of new elements 
	  ArrayList<Node<State>> Result = new ArrayList<Node<State>>();
	  State CurrentState = (State)input.GetContent();
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
				Node<State> NewNode = new Node<State>(NewState);
				input.AddChild(NewNode);
				Result.add(NewNode);
			}
		}
	// also get state when only plot change side
		  State NewState =  new State();
		  NewState = CurrentState.clone();
		  if(CurrentState.Locate.equals("L"))NewState.Locate = "R";
			else NewState.Locate ="L";
		  if (NewState.IsPossibleState()) {
				Node<State> NewNode = new Node<State>(NewState);
				input.AddChild(NewNode);
				Result.add(NewNode);
		 }
	  }
	  catch(Exception ex){ex.printStackTrace();}
	 // return list 
	 return Result;
		
		
	}

}
