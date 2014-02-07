package problemSloving;

public class HillClimbing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskOfQueens task = new TaskOfQueens(0,0,0,0,0,0,0,0);
		
		while (!task.isFinal()) {
			Point goingPoint = task.getPointWithMinimumValue();
			for(int i=0; i<task.DIMENSION;i++)
				task.clearSuqareAt(goingPoint.xPosition, i);
			task.setQueenAt(goingPoint.xPosition, goingPoint.yPosition);
			System.out.println(task.toString());
		}
		
		
	}

}
