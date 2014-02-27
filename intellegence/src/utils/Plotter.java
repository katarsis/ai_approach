package utils;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class Plotter extends ApplicationFrame {

	String [] dataMassive; 
	
	public Plotter(String []inpt, int sizeX, int sizeY) {
		super("plot");
		final DefaultCategoryDataset dataSet = createDataSet(inpt);
		final JFreeChart chart = createChart(dataSet);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(sizeX, sizeY));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
	}
	
	public Plotter(int []inpt, int sizeX, int sizeY) {
		super("plot");
		final DefaultCategoryDataset dataSet = createDataSet(inpt);
		final JFreeChart chart = createChart(dataSet);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(sizeX, sizeY));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
	}
	
	public Plotter(double []inpt, int sizeX, int sizeY) {
		super("plot");
		final DefaultCategoryDataset dataSet = createDataSet(inpt);
		final JFreeChart chart = createChart(dataSet);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(sizeX, sizeY));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
	}
	
	private DefaultCategoryDataset createDataSet(String[] dataSet)
	{
		DefaultCategoryDataset series = new DefaultCategoryDataset();
		for(int i =0; i<dataSet.length;i++)
			series.addValue(Double.valueOf(dataSet[i]), "SERIES", String.valueOf(i));
		return series;
	}
	
	private DefaultCategoryDataset createDataSet(double[] dataSet)
	{
		DefaultCategoryDataset series = new DefaultCategoryDataset();
		for(int i =0; i<dataSet.length;i++)
			series.addValue(Double.valueOf(dataSet[i]), "SERIES", String.valueOf(i));
		return series;
	} 
	
	private DefaultCategoryDataset createDataSet(int[] dataSet)
	{
		DefaultCategoryDataset series = new DefaultCategoryDataset();
		for(int i =0; i<dataSet.length;i++)
			series.addValue(Double.valueOf(dataSet[i]), "SERIES", String.valueOf(i));
		return series;
	} 
	
	public JFreeChart createChart(CategoryDataset dataSet){
		 final JFreeChart localJFreeChart = ChartFactory.createLineChart(
		            "Plot",
		            "X",   
		            "Y",   
		            dataSet,
		            PlotOrientation.VERTICAL,
		            true,   
		            true,   
		            false   
		        );

			CategoryPlot localCategoryPlot = (CategoryPlot) localJFreeChart
					.getPlot();
			NumberAxis localNumberAxis = (NumberAxis) localCategoryPlot
					.getRangeAxis();
			localNumberAxis.setStandardTickUnits(NumberAxis
					.createIntegerTickUnits());
			LineAndShapeRenderer localLineAndShapeRenderer = (LineAndShapeRenderer) localCategoryPlot
					.getRenderer();
			localLineAndShapeRenderer.setSeriesShapesVisible(0, false);
			localLineAndShapeRenderer.setSeriesShapesVisible(1, false);
			localLineAndShapeRenderer.setSeriesShapesVisible(2, true);
			localLineAndShapeRenderer.setSeriesLinesVisible(2, false);
			localLineAndShapeRenderer.setSeriesShape(2,
					ShapeUtilities.createDiamond(4.0F));
			localLineAndShapeRenderer.setDrawOutlines(true);
			localLineAndShapeRenderer.setUseFillPaint(true);
			localLineAndShapeRenderer.setBaseFillPaint(Color.white);
			return localJFreeChart;
	
	}
}
