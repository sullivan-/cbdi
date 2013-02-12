package hierarchical

trait ProjectRepositoryComponent {
  val projectRepository: ProjectRepository
  trait ProjectRepository {
    def create(project: Project): Unit
  }
}

trait ProjectRepositoryComponentImpl extends ProjectRepositoryComponent {
  override val projectRepository: ProjectRepository = new ProjectRepositoryImpl
  private class ProjectRepositoryImpl extends ProjectRepository {
    override def create(project: Project) = println("create " + project)
  }
}
