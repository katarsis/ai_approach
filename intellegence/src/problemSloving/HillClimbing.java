package problemSloving;

import java.util.Random;

import exception.NonInitals;



public class HillClimbing {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TaskOfQueens task = new TaskOfQueens(0,0,0,0,0,0,0,0);
		int iteration = 0 ;
		for(int k=0; k<100; k++)
		{
			task = new TaskOfQueens(0,0,0,0,0,0,0,0);
			iteration =0;
			while (!task.isFinal()) {
				Point goingPoint = task.getPointAtColumnWithMinimumValue(randRange(0, task.DIMENSION));
				for(int i=0; i<task.DIMENSION;i++)
					task.clearSuqareAt(goingPoint
							.xPosition, i);
				task.setQueenAt(goingPoint.xPosition, goingPoint.yPosition);
				iteration++;
			}
			System.out.println(iteration);
		}
		System.out.println(task.toString());
		
	}
	
	public static int randRange(int minimum, int maximum)
	{
		int result =-1;
		Random rand = new Random();
		result =  rand.nextInt(maximum-minimum) + minimum;
		return result;
	}

}
