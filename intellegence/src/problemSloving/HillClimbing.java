package problemSloving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.jfree.ui.RefineryUtilities;

import utils.Plotter;
import exception.NonInitals;



public class HillClimbing {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		TaskOfQueens task = new TaskOfQueens(0,0,0,0,0,0,0,0);
		int iteration = 0 ;
		ArrayList <String> dataSeries =  new ArrayList();
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
			dataSeries.add(String.valueOf(iteration));
			System.out.println(iteration);
		}      
		System.out.println(task.toString());
		Collections.sort(dataSeries,new Comparator<String>() {
			public int compare(String a, String b)
			{
				return Integer.signum(Integer.valueOf(a)-Integer.valueOf(b));
			}
		});
		Object[] ObjectList = dataSeries.toArray();
		String[]items =  Arrays.copyOf(ObjectList,ObjectList.length,String[].class);
		
		  final Plotter demo = new Plotter(items,1500,800);
	
	}
	
	public static int randRange(int minimum, int maximum)
	{
		int result =-1;
		Random rand = new Random();
		result =  rand.nextInt(maximum-minimum) + minimum;
		return result;
	}

}
