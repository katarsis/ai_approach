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
	
	public boolean isWin(int pice)
	{
		boolean isWinState = true;
		//First step see all verticals for watch fin state
		//  if fin state is find return true
		for (int i=0;i<boardState.DIMENSION_SIZE;i++)
		{
			isWinState = true;
			for(int j=0;j<boardState.DIMENSION_SIZE;j++)
				if(boardState.getBoardsFlagAt(i, j)!=pice)
					isWinState = false;
			if(isWinState)
				return true;
		}
		// second step see all horizontal for watch fin state
		// if fin state is find return true
		for (int i=0;i<boardState.DIMENSION_SIZE;i++)
		{
			isWinState = true;
			for(int j=0;j<boardState.DIMENSION_SIZE;j++)
				if(boardState.getBoardsFlagAt(j, i)!=pice)
					isWinState = false;
			if(isWinState)
				return true;
		}
		// Third step see 1-9 diagonal for watch fin state
		// if fin state is find return true
		isWinState = true;
		for (int i=0;i<boardState.DIMENSION_SIZE;i++)
			for(int j=0;j<boardState.DIMENSION_SIZE;j++)
				if(boardState.getBoardsFlagAt(j, i)!=pice)
					isWinState = false;
		if(isWinState)
			return true;
		// Fourth step see 7-3 diagonal for watch fin state
		// if fin state is find return true
		// else return false
		isWinState = true;	
		for (int i=boardState.DIMENSION_SIZE;i>=0;i--)
			for(int j=0;j<boardState.DIMENSION_SIZE;j++)
				if(boardState.getBoardsFlagAt(i, j)!=pice)
					isWinState = false;
		return isWinState;
	}
}
