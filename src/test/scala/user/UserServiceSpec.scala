package user

import org.easymock.EasyMock.reset
import org.scalatest.FlatSpec

class UserServiceSpec
extends FlatSpec
with ComponentRegistryMock
with UserServiceComponentImpl {

  behavior of "UserServiceImpl.create"

  it should "delegate to UserRepository.create" in {
    val user = User("charlie", "swordfish")
    expecting {
      userRepository.create(user)
    }
    whenExecuting(userRepository) {
      userService.create(user.username, user.password)
    }
    reset(userRepository)
  }
}
