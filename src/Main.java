import controllers.MainNavigationController;
import presenter.HomePresenter;
import repositories.Repository;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Repository repository = new Repository();
        MainNavigationController navigationController = new MainNavigationController();
        Long defaultTeamId = 0L;
        Long defaultInboxId = 0L;

        HomePresenter homePresenter = new HomePresenter(repository, navigationController, defaultTeamId, defaultInboxId);

    }

}
