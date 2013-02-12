package encapsulate

sealed abstract class ChartView(val chart: Chart)

class HistogramView(histogram: Histogram) extends ChartView(histogram)

class ScatterPlotView(scatterPlot: ScatterPlot) extends ChartView(scatterPlot)
