package piton.tree;

import java.util.ArrayList;

public interface IState {

	public boolean IsPossibleState();
	public boolean IsFinState();
	public void Print();
	public ArrayList<IState> getAllChild(IState input);
	public int getCurrentGamer();
}
