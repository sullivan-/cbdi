package gotchas

import org.easymock.EasyMock.reset
import org.scalatest.FlatSpec

class InitializationOrderSpec extends FlatSpec {

  behavior of "components that reference each other during initialization"
  it should "possibly cause NPE, depending on the order the components are declared" in {

    // should not throw exception
    new AnyRef with TopComponent1Impl

    intercept[NullPointerException] {
      new AnyRef with TopComponent2Impl
    }
  }
}
