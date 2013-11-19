package piton.tree;

import java.util.ArrayList;

import TicTacToe.IGameState;
import TicTacToe.StateGame;

/*
 * abstract class for encapsulation operation with tree
 * @author (name = piton)
 * @version 1.0 
 * */
public class Tree {

	/*
	 * the root of tree
	 */
	private Node Root; 
	private static final int INF_MIN=-999;
	private static final int INF_MAX = 999;
	
	/*
	 * Constructor
	 * @param rootOfTree	initialization of root node of tree for  
	 */
	public Tree(Node rootOfTree)
	{
		this.Root = rootOfTree;
	}
	
	/*
	 * Procedure which return list of nodes who located in the critical path 
	 * @param 	listNode	the end goal list path for his we want to see	
	 * @return	pathOutput	the list of nodes on the critical path
	 */
	public ArrayList<Node> printRedPathTree(Node listNode){
		ArrayList<Node> pathOutput = new ArrayList<Node>();
		Node currentNode =  listNode;
		while (currentNode!= null)
		{
			pathOutput.add(currentNode);
			currentNode =  currentNode.GetParent();
		}
		return pathOutput;
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
			ArrayList<Node> Childs = getAllChild(CurrentNode);
			
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
			ArrayList<Node> Childs = getAllChild(CurrentNode);
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
	
	/*
	 * 
	 * 
	 */
	public static ArrayList<Node> getAllChild(Node input)
	{
	 // create list of new elements 
	  ArrayList<Node> Result = new ArrayList<Node>();
	  IState CurrentState = (IState)input.GetContent();
	 // if too match depth then return null 
	  if(input.indexDepth>6)
	  return null;
	 // for each state in input item change vice versa
	  
	  try{
		 ArrayList<IState> childState = CurrentState.getAllChild(CurrentState);
		 for(int i=0;i<childState.size();i++)
		 {
			 Node<IState> NewNode = new Node<IState>(childState.get(i));
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
	 * implement procedure of min max search
	 * @param	currentState	the current state of human stage
	 * @param	maxDepth		the max node depth for terminal state
	 * @return	goalNode		the computer step state	
	 */
	public static IGameState getMinMaxStep(IGameState currentStep, int maxDepth)
	{
		/*
		 * implements min max algoritm
		 * for each possible children of current states
		 * if gamer is computer then find max of score
		 * if gamer is man then minimazing of scope
		 * return answer state in node       
		 */
		StateGame fristStage = (StateGame)currentStep.getInstance();
		IGameState currentState =  fristStage;
		IGameState answer = null;
		//FIXME create a static procedure or delete input parametr
		
		ArrayList<IState> childrenStates = currentState.getAllChild(currentState);
	
		
		if(fristStage.IsFinState()||maxDepth==0)
			return fristStage;
		if(fristStage.getCurrentGamer() ==  fristStage.COMP_GAMER)
		{
			int bestScore = INF_MIN;
			for(IState child: childrenStates)
			{
				IGameState possibleChild = Tree.getMinMaxStep((IGameState)child, maxDepth-1);
				if(possibleChild.getHeuristicValue(fristStage.thisAgeAt)>bestScore)
				{
					bestScore = possibleChild.getHeuristicValue(fristStage.thisAgeAt);
					answer= (IGameState)child;
				}
			} 
		}
		else if(fristStage.getCurrentGamer() == fristStage.HUMAN_GAMER)
		{
			int bestScore = INF_MAX;
			for(IState child: childrenStates)
			{
				IGameState possibleChild = Tree.getMinMaxStep((IGameState)child, maxDepth-1);
				if(possibleChild.getHeuristicValue(fristStage.thisAgeAt)<bestScore)
				{
					bestScore = possibleChild.getHeuristicValue(fristStage.thisAgeAt);
					answer= (IGameState)child;
				}
			}
		}
		return answer;
		
	}
}
