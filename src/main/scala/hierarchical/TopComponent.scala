package hierarchical

trait RepositoryComponent
extends ProjectRepositoryComponent
with UserRepositoryComponent

trait RepositoryComponentImpl
extends RepositoryComponent
with ProjectRepositoryComponentImpl
with UserRepositoryComponentImpl {
  // do not self-type to ServiceComponent here as it breaks design constraint!
}

trait ServiceComponent
extends ProjectServiceComponent
with UserServiceComponent {
 self: RepositoryComponent =>
}

trait ServiceComponentImpl
extends ServiceComponent
with ProjectServiceComponentImpl
with UserServiceComponentImpl {
 self: RepositoryComponent =>
}

trait TopComponent
extends ServiceComponent
with RepositoryComponent

trait TopComponentImpl
extends TopComponent
with ServiceComponentImpl
with RepositoryComponentImpl
