package presenter;

import controllers.MainNavigationController;
import repositories.Repository;

import static org.junit.jupiter.api.Assertions.*;

class HomePresenterTest {

    HomePresenter homePresenter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        Repository repository = new Repository();
        MainNavigationController navigationController = new MainNavigationController();
        Long defaultTeamId = 1L;
        Long defaultInboxId = 5L;

        homePresenter = new HomePresenter(repository, navigationController, defaultTeamId, defaultInboxId);

    }

    @org.junit.jupiter.api.Test
    void loading() {

        fail("This test has yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void update() {
        fail("This test has yet to be implemented");
    }

}
