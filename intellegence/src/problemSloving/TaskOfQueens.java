package problemSloving;

import org.omg.CORBA.PUBLIC_MEMBER;

import exception.NonInitals;

public class TaskOfQueens {

	public int[][] chessBoard;
	public static final int DIMENSION =8;
	private static final int QUEEN_FLAG =1;
	
	public TaskOfQueens()
	{
		chessBoard =  new int[DIMENSION][DIMENSION];
		for(int i=0; i<DIMENSION; i++)
			for(int j=0; j<DIMENSION; j++)
				chessBoard[i][j] =0;
	}
	
	public TaskOfQueens(int ... posVer)
	{
		chessBoard =  new int[DIMENSION][DIMENSION];
		for(int i=0; i<DIMENSION; i++)
			for(int j=0; j<DIMENSION; j++)
				chessBoard[i][j] =0;
	
		for(int i=0; i< posVer.length; i++)
		{
			setQueenAt(i, posVer[i]);
		}
	}
	
	public void clearSuqareAt(int xPosition, int yPosition)
	{
		chessBoard[xPosition][yPosition] = 0;
	}
	
	public void setQueenAt(int xPosition,  int yPosition)
	{
		chessBoard[xPosition][yPosition]=QUEEN_FLAG;
	}
	
	@Override
	public String toString()
	{
		String result="";
		for(int i=0;i< DIMENSION ;i++)
		{
			String buf="";
			for(int j=0; j< DIMENSION ; j++)
			{
				buf+="|"+chessBoard[j][i]+"|";
			}
			buf+=System.lineSeparator();
			result+=buf;
			
		}
		result+="------------------------------"+System.lineSeparator();
		return result;
	}
	
	
	public String print(int [][] printing)
	{
		String result="";
		for(int i=0;i< DIMENSION ;i++)
		{
			String buf="";
			for(int j=0; j< DIMENSION ; j++)
			{
				buf+="|"+printing[j][i]+"|";
			}
			buf+=System.lineSeparator();
			result+=buf;
			
		}
		result+="------------------------------"+System.lineSeparator();
		return result;
	}
	
	public int[][] getAttackedFeild()
	{
		int resultMatrix[][]=  new int[DIMENSION][DIMENSION];
		for(int i=0; i< DIMENSION; i++)
			for(int j=0; j<DIMENSION; j++)
			{
				resultMatrix[i][j] = getCountAttakedQueen(i, j);
			}
		return resultMatrix;
	}
	
	public int getCountAttakedQueen(int xPosition, int yPosition)
	{
		int result=0;
		//serch by diagonal
		for(int i=xPosition,k=yPosition; i<DIMENSION && k<DIMENSION;i++,k++)
		{
			if(i==xPosition && k== yPosition)
			continue;
			if(chessBoard[i][k]==QUEEN_FLAG)
			{
				result++;
			}
		}
		for(int x=xPosition, y=yPosition ; x>=0&&y<DIMENSION ; x--, y++)
		{
			if(x==xPosition && y== yPosition)
				continue;
			if(chessBoard[x][y]==QUEEN_FLAG)
			{
				result++;
			}
		}
		for(int x=xPosition, y=yPosition ; x<DIMENSION&&y>=0 ; x++, y--)
		{
			if(x==xPosition && y== yPosition)
				continue;
			if(chessBoard[x][y]==QUEEN_FLAG)
			{
				result++;
			}
		}
		for(int x=xPosition, y=yPosition ; x>=0&&y>=0 ; x--, y--)
		{
			if(x==xPosition && y== yPosition)
				continue;
			if(chessBoard[x][y]==QUEEN_FLAG)
			{
				result++;
			}
		}
		//search by horizontal
		for(int x=0; x<DIMENSION; x++)
		{
			if(x==xPosition)
				continue;
			if(chessBoard[x][yPosition]==QUEEN_FLAG)
				result++;
		}
		//search by vertical 
		for(int y=0; y<DIMENSION; y++)
		{
			if(y==yPosition)
				continue;
			if(chessBoard[xPosition][y] == QUEEN_FLAG)
				result++;
		}
		return result;
	}
	
	public boolean isFinal()
	{
		boolean result = true;
		for(int xPosition=0; xPosition<DIMENSION; xPosition++)
			for(int yPosition=0; yPosition<DIMENSION; yPosition++)
			{
				if(chessBoard[xPosition][yPosition]==QUEEN_FLAG)
				{
					if(getCountAttakedQueen(xPosition, yPosition)!=0)
						result= false;
				}
			}
		return result;
	}
	
	/*
	 * return the minimum free costs point 
	 * 
	 */
	public Point getPointWithMinimumValue() 
	{
		int minimum = Integer.MIN_VALUE;
		Point result = new Point();
		
		int[][] map =  getAttackedFeild();
		for(int i=0; i<DIMENSION;i++)
			for(int j=0; j<DIMENSION;j++)
			{
				if(map[i][j]> minimum && map[i][j]!=QUEEN_FLAG)
				{
					result.xPosition =i;
					result.yPosition =j;
				}
			}
		System.out.println(print(getAttackedFeild()));
		return result;
	}
	
	/*
	 * get miminum value for selected columns
	 */
	public Point getPointAtColumnWithMinimumValue(int columnNumber)
	{
		int minimum = Integer.MAX_VALUE;
		Point result =  new Point();
		int [][] map = getAttackedFeild();
		for(int i=0;i<DIMENSION;i++)
		{
			if(map[columnNumber][i]< minimum && chessBoard[columnNumber][i]!=QUEEN_FLAG)
			{
				result.xPosition = columnNumber;
				result.yPosition = i;
				minimum = map[columnNumber][i];
			}
		}
		return result; 
	}
}
