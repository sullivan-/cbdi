package user

trait UserRepositoryComponent {
  val userRepository: UserRepository
  trait UserRepository {
    def create(user: User): Unit
  }
}

trait UserRepositoryComponentImpl extends UserRepositoryComponent {
  override val userRepository: UserRepository = new UserRepositoryImpl
  private class UserRepositoryImpl extends UserRepository {
    override def create(user: User) = println("create " + user)
  }
}
