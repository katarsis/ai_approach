package TicTacToe;

public class Board implements Cloneable{

	private int [][] boardsFlag;
	private final int CROSS_FLAG = 1;
	private final int ZERO_FLAG =0;
	private final int NONE_FLAG =-1;
	public final int DIMENSION_SIZE =3;
	
	public Board()
	{
		boardsFlag =  new int [DIMENSION_SIZE][DIMENSION_SIZE];
		for(int i=0; i<DIMENSION_SIZE;i++)
		{
			for(int j=0;j<DIMENSION_SIZE;j++)
			{
				boardsFlag[i][j]=NONE_FLAG;
			}
		}
	}
	
	public Board(int [][] piecesFeild)
	{
		boardsFlag =  new int [DIMENSION_SIZE][DIMENSION_SIZE];
		for(int i=0; i<DIMENSION_SIZE;i++)
		{
			for(int j=0;j<DIMENSION_SIZE;j++)
			{
				boardsFlag[i][j]=piecesFeild[i][j];
			}
		}
	}
		
	public boolean isEmptyFeild(int xPosition, int yPosition)
	{
		if(boardsFlag[xPosition][yPosition]==NONE_FLAG)
			return true;
		return false;
	}
	
	public void setCrossAt(int xPosition, int yPosition)
	{
		boardsFlag[xPosition][yPosition]=CROSS_FLAG;
	}
	
	public void setZeroAt(int xPosition,int yPosition)
	{
		boardsFlag[xPosition][yPosition]=ZERO_FLAG;
	}
	
	public void print()
	{
		for(int i=0;i<DIMENSION_SIZE;i++)
		{
			String outline="";
			for(int j=0;j<DIMENSION_SIZE;j++)
			{
				outline+=boardsFlag[i][j]==this.CROSS_FLAG ? "X":"0";
				outline+="|";
			}
			System.out.println(outline);
		}
		System.out.println("---------------");
	}


	public int getBoardsFlagAt(int xPos, int yPos) 
	{
		return boardsFlag[xPos][yPos];
	}


	public Board clone() throws CloneNotSupportedException{
		Board returnBoard = new Board(boardsFlag);
		return returnBoard;
	}
}

