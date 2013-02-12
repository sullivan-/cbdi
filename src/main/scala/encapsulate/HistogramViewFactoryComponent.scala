package encapsulate

trait HistogramViewFactoryComponent {
  val histogramViewFactory: HistogramViewFactory
  trait HistogramViewFactory {
    def create(histogram: Histogram): HistogramView
  }
}

trait HistogramViewFactoryComponentImpl extends HistogramViewFactoryComponent {
  override val histogramViewFactory: HistogramViewFactory = new HistogramViewFactoryImpl
  private class HistogramViewFactoryImpl extends HistogramViewFactory {
    override def create(histogram: Histogram) = {
      new HistogramView(histogram)
    }
  }
}
