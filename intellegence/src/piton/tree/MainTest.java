package piton.tree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map.Entry;



public class MainTest {

	public static void main(String[] args) throws CloneNotSupportedException, NodeException {
		//create the initial state which all position on the left side
		Node<State> initalState = new  Node<State>(new State(true, true, true, "L"));
		Node goalNode = searchInDepth(initalState);
				// searchInFront(initalState);
		//print the slove
		Tree desizionTree = new Tree(initalState);
		ArrayList<Node> criticalPath = desizionTree.printRedPathTree(goalNode);
		for(int i=criticalPath.size()-1; i>=0;i--)
		{
			State StateNow = (State)criticalPath.get(i).GetContent();
			StateNow.Print();
		}
}
	
	public static ArrayList<Node<State>> GetAllChild(Node input)
	{
	 // create list of new elements 
	  ArrayList<Node<State>> Result = new ArrayList<Node<State>>();
	  State CurrentState = (State)input.GetContent();
	 // if too match depth then return null 
	  if(input.indexDepth>6)
	  return null;
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
				NewNode.indexDepth = input.indexDepth+1;
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
				NewNode.indexDepth = input.indexDepth+1;
				input.AddChild(NewNode);
				Result.add(NewNode);
		 }
	  }
	  catch(Exception ex){ex.printStackTrace();}
	 // return list 
	
	 return Result;
		
		
	}
	
	/*
	 * realization search on the tree in the front
	 * @param	initalNodeInput	the startState of the search
	 * @return	goalNode	the goal node of the search
	 */
	public static Node searchInFront(Node initalNodeInput){
		//create the initial state which all position on the left side
		Node<State> initalState = initalNodeInput;
		ArrayList<Node> fringe = new ArrayList<Node>();
		Node<State> goalNode = new Node<State>(new State());
		//add this state to list of searching states
		fringe.add(initalState);
		try
		{
			//get item from the list of searching
			while(!fringe.isEmpty()){
				Node<State> CurrentNode = fringe.get(0); 
				State CurrentState =  (State)CurrentNode.GetContent();	
			//if this state is goal return this
				if (CurrentState.IsFinState()){
			//break cycle
					goalNode = CurrentNode;
					break;
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
		return goalNode;
	}
	
	/*
	 * Realization search on the tree in the depth 
	 * @param	initalNodeInput	the startState of the search
	 * @return	goalNode	the goal node of the search
	 */
	public static Node searchInDepth(Node initalNodeInput)
	{
		Node<State> initalState = initalNodeInput;
		ArrayList<Node> fringe = new ArrayList<Node>();
		Node<State> goalNode = new Node<State>(new State());
		int currentDepth =0;
		//add this state to list of searching states
		fringe.add(initalState);
		try
		{
			//get item from the list of searching
			while(!fringe.isEmpty()){
			//get item with max depth
				Node<State> CurrentNode = fringe.get(getMaxDepthNode(fringe)); 
				State CurrentState =  (State)CurrentNode.GetContent();
			//if this state is goal return this
				if (CurrentState.IsFinState()){
			//break cycle
					goalNode = CurrentNode;
					break;
				}
			//else create all possible state from this position
			ArrayList<Node<State>> Childs = GetAllChild(CurrentNode);
			
			if(Childs!= null)fringe.addAll(Childs);
			//remove expanded state and add all his possible child state to the list of searching
			fringe.remove(CurrentNode);
			//return to step 2
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return goalNode;
		
	}
	
	/*
	 * @param	inputArrayNode
	 * @return	index of the node with max depth
	 */
	public static int getMaxDepthNode(ArrayList<Node> inputArrayNode)
	{
		int indexMax =0;
		for(int i=0; i<inputArrayNode.size()-1; i++)
			if(inputArrayNode.get(indexMax).indexDepth<inputArrayNode.get(i).indexDepth)
				indexMax = i;
 		return indexMax;
	}

}
