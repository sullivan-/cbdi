package gotchas

trait Service1Component {
  val service1: Service1
  trait Service1 {
    def announce(): Unit
  }
}

trait Service1ComponentImpl extends Service1Component {
  override val service1: Service1 = new Service1Impl
  private class Service1Impl extends Service1 {
    override def announce() = println("hi from Service1!")
  }
}

trait Service2Component {
  val service2: Service2
  trait Service2
}

trait Service2ComponentImpl extends Service2Component {
  self: Service1Component =>
  override val service2: Service2 = new Service2Impl
  private class Service2Impl extends Service2 {
    service1.announce()
  }
}

trait TopComponent1
extends Service1Component
with Service2Component

trait TopComponent1Impl
extends TopComponent1
with Service1ComponentImpl
with Service2ComponentImpl

trait TopComponent2
extends Service2Component
with Service1Component

// this throws NullPointerException when initializing Service2Impl
trait TopComponent2Impl
extends TopComponent2
with Service2ComponentImpl
with Service1ComponentImpl
