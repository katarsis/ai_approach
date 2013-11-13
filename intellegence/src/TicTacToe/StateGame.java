package TicTacToe;

import java.util.ArrayList;

import piton.tree.IState;
import piton.tree.State;

public class StateGame implements IGameState, Cloneable{

	private Board boardState;
	final int GAMER_CROSS = 0;
	final int GAMER_ZERO = 1;
	final int UNDEFINED = -999;
	public int thisAgeAt;
	public int utility;
	@Override
	public boolean IsPossibleState() {
		// all states possible then all get from empty feild
		return true;
	}

	public StateGame()
	{
		boardState =  new Board();
		utility = this.UNDEFINED;
	}
	@Override
	public boolean IsFinState() {
		return false;
	}

	@Override
	public void Print() {
		//print feild of piece
		this.boardState.print();
	}

	public ArrayList<IState> getAllChild(IState input) {
		ArrayList<IState> childsState =  new ArrayList<IState>();
		// for each position out inverted gamer piece
		for(int xPosition = 0; xPosition<boardState.DIMENSION_SIZE;xPosition++)
			for(int yPosition =0; yPosition<boardState.DIMENSION_SIZE;yPosition++)
			{
				try 
				{
					if(boardState.isEmptyFeild(xPosition, yPosition))
					{
						StateGame child = new StateGame();
						child.boardState = this.boardState.clone();
						child.thisAgeAt = getInvertGamer();
						childsState.add(child);
					} 
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		 // return this
		return childsState;
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
	
	public StateGame clone() throws CloneNotSupportedException {
		StateGame cloneState = new StateGame();
		cloneState.boardState = this.boardState.clone();
		return cloneState;
	}
	
	public int getInvertGamer(){
		return this.thisAgeAt == this.GAMER_ZERO ? this.GAMER_CROSS: this.GAMER_ZERO;
	}

	@Override
	public int getMinMaxValue() {
		utility = this.UNDEFINED;
		if(thisAgeAt== this.GAMER_CROSS){
			if(isWin(GAMER_CROSS))utility =1 ;
			else if(isWin(GAMER_ZERO)) utility =-1;
			else utility = 0;
		}
		else {
			if(isWin(GAMER_CROSS))utility = -1;
			else if(isWin(GAMER_ZERO))utility = 1;
			else utility = 0;
		}
		return utility;
	}
}
