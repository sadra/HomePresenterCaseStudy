package presenter;

import controllers.MainNavigationController;
import interfaces.LoadingInterface;
import interfaces.UpdateInterface;
import models.Current;
import models.Inbox;
import models.Team;
import models.User;
import repositories.Repository;
import views.View;

import java.util.Collection;

public class HomePresenter implements LoadingInterface, UpdateInterface {

    private User mUser;
    private Team currentTeam;
    private Inbox currentInbox;
    private Long defaultTeamId;
    private Long defaultInboxId;
    private Collection<Team> mTeams;
    private Collection<Inbox> mInboxes;

    private View mView = new View();
    private Repository mRepository = new Repository();
    private MainNavigationController mNavigationController = new MainNavigationController();
    private Team defaultTeam = new Team();
    private Inbox defaultInbox = new Inbox();

    public HomePresenter(Repository repository, MainNavigationController navigationController
            , Long defaultTeamId, Long defaultInboxId) {
        super();

        this.mRepository = repository;
        this.mNavigationController = navigationController;
        this.defaultTeamId = defaultTeamId;
        this.defaultInboxId = defaultInboxId;
        loading();
    }

    @Override
    public void loading() {
        mUser = mRepository.getUser();
        mTeams = mRepository.getTeams();
        if(shouldTeamUpdated()){
            update();
        }
    }

    @Override
    public void update() {
        updateCurrentTeam(defaultTeam);
    }

    private void updateCurrentTeam(Team team) {
        currentTeam = team;
        loadInboxes(currentTeam);
        mView.setSelectedTeam(currentTeam);
    }


    private void loadInboxes(final Team team) {
        mInboxes = mRepository.getInboxes();
        if(shouldInboxUpdated()){
            updateCurrentInbox(defaultInbox);
        }
    }

    private void updateCurrentInbox(Inbox inbox) {
        currentInbox = inbox;
        mNavigationController.navigateToInbox(currentTeam, inbox);
        mView.setSelectedInbox(currentInbox);
    }


    private boolean shouldInboxUpdated(){
        return currentInbox == null && mInboxes != null && !mInboxes.isEmpty();
    }

    private boolean shouldTeamUpdated(){
        return currentTeam == null && mTeams != null && !mTeams.isEmpty();
    }


}