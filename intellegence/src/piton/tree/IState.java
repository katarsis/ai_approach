package piton.tree;

import java.util.ArrayList;

public interface IState<E> {

	public boolean IsPossibleState();
	public boolean IsFinState();
	public void Print();
	public ArrayList<E> getAllChild(E input);
	
}
