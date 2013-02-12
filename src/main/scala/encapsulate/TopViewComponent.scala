package encapsulate
 
trait TopViewComponent {
  val topView: TopView
  trait TopView {
    def display(): Unit
  }
}

trait TopViewComponentImpl extends TopViewComponent {
  // self-type to, e.g., HistogramViewFactoryComponent here will not compile
  self: ChartViewFactoryComponent =>
  override val topView: TopView = new TopViewImpl
  private class TopViewImpl extends TopView {
    override def display() {
      // ...
    }

    private def displayChart(chart: Chart) {
      chartViewFactory.create(chart)
      // ...
    }
  }
}
