package hierarchical

trait ProjectServiceComponent {
  val projectService: ProjectService
  trait ProjectService {
    def create(projectName: String): Unit
  }
}

trait ProjectServiceComponentImpl extends ProjectServiceComponent {
  self: ProjectRepositoryComponent =>
  override val projectService: ProjectService = new ProjectServiceImpl
  private class ProjectServiceImpl extends ProjectService {
    override def create(projectName: String) =
      projectRepository.create(Project(projectName))
  }
}
