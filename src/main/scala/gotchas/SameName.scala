package gotchas

trait SameName1 {
  val sameName: SameName
  trait SameName
}

trait SameName1Impl extends SameName1 {
  override val sameName: SameName = new SameNameImpl
  private class SameNameImpl extends SameName
}

trait SameName2 {
  val sameName: SameName
  trait SameName
}

trait SameName2Impl extends SameName2 {
  override val sameName: SameName = new SameNameImpl
  private class SameNameImpl extends SameName
}

trait SameName1ParentComponent
extends SameName1

trait SameName1ParentComponentImpl
extends SameName1ParentComponent
with SameName1Impl

trait SameName2ParentComponent
extends SameName2

trait SameName2ParentComponentImpl
extends SameName2ParentComponent
with SameName2Impl

// even though SameName1 and SameName2 are scoped in such a way that only one
// of them would ever be available from a given referencing component, it still
// produces a compiler error to include them in a single containing component,
// like so:

// trait TopComponent
// extends SameName1ParentComponent
// with SameName2ParentComponent

// the compiler error is:
// [error] SameName.scala:37: overriding value sameName in trait SameName1 of type TopComponent.this.SameName;
// [error]  value sameName in trait SameName2 of type TopComponent.this.SameName has incompatible type
// [error] trait TopComponent
// [error]       ^
