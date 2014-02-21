package problemSloving;

import java.util.Random;

import exception.NonInitals;



public class HillClimbing {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TaskOfQueens task = new TaskOfQueens(0,1,2,2,4,5,5,7);
		Random rand = new Random(task.DIMENSION);
		
		while (!task.isFinal()) {
			Point goingPoint = task.getPointAtColumnWithMinimumValue(rand.nextInt());
			for(int i=0; i<task.DIMENSION;i++)
				task.clearSuqareAt(goingPoint.xPosition, i);
			task.setQueenAt(goingPoint.xPosition, goingPoint.yPosition);
			System.out.println(task.toString());
			
		
		}
		
		
	}

}
