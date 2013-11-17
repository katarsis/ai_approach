package TicTacToe;

import java.util.ArrayList;

import piton.tree.IState;

public interface IGameState extends IState {
	
	public boolean IsPossibleState();
	public boolean IsFinState();
	public void Print();
	public ArrayList<IState> getAllChild(IState input);
	public int getMinMaxValue();
	public int getHeuristicValue();
	public Object getInstance();
}
