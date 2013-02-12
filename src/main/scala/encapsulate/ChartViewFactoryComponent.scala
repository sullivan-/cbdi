package encapsulate

trait ChartViewFactoryComponent {
  val chartViewFactory: ChartViewFactory
  trait ChartViewFactory {
    def create(chart: Chart): ChartView
  }
}

trait ChartViewFactoryComponentImpl extends ChartViewFactoryComponent {
  self: HistogramViewFactoryComponent with ScatterPlotViewFactoryComponent =>
  override val chartViewFactory: ChartViewFactory = new ChartViewFactoryImpl
  private class ChartViewFactoryImpl extends ChartViewFactory {
    override def create(chart: Chart) = {
      chart match {
        case c: Histogram => histogramViewFactory.create(c)
        case c: ScatterPlot => scatterPlotViewFactory.create(c)
      }
    }
  }
}
