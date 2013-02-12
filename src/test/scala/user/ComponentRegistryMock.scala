package user

import org.scalatest.mock.EasyMockSugar

trait ComponentRegistryMock extends ComponentRegistry with EasyMockSugar {
  val userService = mock[UserService]
  val userRepository = mock[UserRepository]
}
