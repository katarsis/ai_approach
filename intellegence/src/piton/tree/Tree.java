package piton.tree;

import java.util.ArrayList;

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
	
}
