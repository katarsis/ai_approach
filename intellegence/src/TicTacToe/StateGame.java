package TicTacToe;

import java.util.ArrayList;

import piton.tree.IState;

public class StateGame implements IState{

	private Board boardState;
	
	@Override
	public boolean IsPossibleState() {
		// all states possible then all get from empty feild
		return true;
	}

	@Override
	public boolean IsFinState() {
		// TODO Auto-generated method stub
		/*
		 * First step see all horizontal for watch fin state
		 * if fin state is find return true
		 * second step see all verticals for watch fin state
		 * if fin state is find return true
		 * Third step see 1-9 diagonal for watch fin state
		 * if fin state is find return true
		 * Fourth step see 7-3 diagonal for watch fin state
		 * if fin state is find return true
		 * else return false
		 */
		return false;
	}

	@Override
	public void Print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList getAllChild(Object input) {
		// TODO Auto-generated method stub
		return null;
	}

}
