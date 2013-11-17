package TicTacToe;

import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import piton.tree.IState;
import piton.tree.State;

public class StateGame implements IGameState, Cloneable{

	private Board boardState;
	public static final int GAMER_CROSS = 0;
	public static final int GAMER_ZERO = 1;
	public static int COMP_GAMER=-999;
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
		boolean result = false;
		//control if current gamer or it's opponent has win return true
		if (isWin(thisAgeAt)) result = true;
		else if (isWin(this.getInvertGamer()))  result = true;
		//if non exists empty field return true
		else if (noEmptyFeilds()) result = true;
		return result;
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
						if(child.thisAgeAt==GAMER_CROSS)
							child.boardState.setCrossAt(xPosition, yPosition);
						else
							child.boardState.setZeroAt(xPosition, yPosition);
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

	public boolean noEmptyFeilds()
	{
		boolean result =true;
		for(int i=0; i<boardState.DIMENSION_SIZE;i++)
		{
			for(int j=0;j<boardState.DIMENSION_SIZE;j++)
			{
				if(boardState.isEmptyFeild(i, j)) result=false;
			}
		}
		return result;
	}

	public int getHeuristic(int theGamer)
	{
		int result = 0;
		
		return result;
	}

	@Override
	public int getCurrentGamer() {
		
		return thisAgeAt;
	}

	@Override
	public int getHeuristicValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getInstance() {
		
		return this;
	}
	
	
}
