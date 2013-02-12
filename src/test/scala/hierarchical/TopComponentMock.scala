package hierarchical

import org.scalatest.mock.EasyMockSugar

trait RepositoryComponentMock
extends RepositoryComponent
with EasyMockSugar {
  val projectRepository = mock[ProjectRepository]
  val userRepository = mock[UserRepository]
}

trait ServiceComponentMock
extends ServiceComponent
with EasyMockSugar {
  self: RepositoryComponent =>
  val projectService = mock[ProjectService]
  val userService = mock[UserService]
}

trait TopComponentMock
extends TopComponent
with ServiceComponentMock
with RepositoryComponentMock
