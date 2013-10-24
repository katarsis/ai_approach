package piton.tree;
/*
 * this class implement abstract node of tree
 * @author piton
 * @version 1.0
 */
import java.util.ArrayList;

public class Node <T>{
	private T Content;
	private Node<T> Root;
	private ArrayList<Node<T>> Childs;
	public int indexDepth;
	
	public Node(T input_value)
	{
		this.Content = input_value;
		Root = null;
		Childs = new ArrayList<Node<T>>();
		indexDepth =0;
	}
	
	public Node(Node rt, T input){
		this.Root = rt;
		this.Content = input;
		this.Childs = new ArrayList<Node<T>>();
		indexDepth =0;
	}
	
	public void AddChild(Node<T> child)throws NodeException{
		child.Root = this;
		Childs.add(child);
	}
	
	public void RemoveChild(Node<T> child) throws NodeException{
		Childs.remove(Childs.indexOf(child));
	}
	
	
	public T GetChild(int i)
	{
		return Childs.get(i).Content;
	}
	
	public Node<T> GetParent()
	{
		return Root;
	}
	
	public T GetContent()
	{
		return Content;
	}
}
