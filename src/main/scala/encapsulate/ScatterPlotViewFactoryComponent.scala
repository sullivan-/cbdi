package encapsulate

trait ScatterPlotViewFactoryComponent {
  val scatterPlotViewFactory: ScatterPlotViewFactory
  trait ScatterPlotViewFactory {
    def create(scatterPlot: ScatterPlot): ScatterPlotView
  }
}

trait ScatterPlotViewFactoryComponentImpl extends ScatterPlotViewFactoryComponent {
  override val scatterPlotViewFactory: ScatterPlotViewFactory = new ScatterPlotViewFactoryImpl
  private class ScatterPlotViewFactoryImpl extends ScatterPlotViewFactory {
    override def create(scatterPlot: ScatterPlot) = {
      new ScatterPlotView(scatterPlot)
    }
  }
}
