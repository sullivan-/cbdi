package user

trait UserServiceComponent {
  val userService: UserService
  trait UserService {
    def create(username: String, password: String): Unit
  }
}

trait UserServiceComponentImpl extends UserServiceComponent {
  self: UserRepositoryComponent =>
  override val userService: UserService = new UserServiceImpl
  private class UserServiceImpl extends UserService {
    override def create(username: String, password: String) =
      userRepository.create(User(username, password))
  }
}
