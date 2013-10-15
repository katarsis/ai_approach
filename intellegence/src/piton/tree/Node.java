package piton.tree;
/*
 * piton
 * this class implement abstract node of tree
 * 30/09/2013
 */
import java.util.ArrayList;

public class Node <T>{
	private T Content;
	private Node<T> Root;
	private ArrayList<Node<T>> Childs;
	
	public Node(T input_value)
	{
		this.Content = input_value;
		Root = null;
		Childs = new ArrayList<Node<T>>();
	}
	
	public Node(Node rt, T input){
		this.Root = rt;
		this.Content = input;
		this.Childs = new ArrayList<Node<T>>();
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
