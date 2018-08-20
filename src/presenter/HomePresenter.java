package presenter;

import controllers.MainNavigationController;
import interfaces.Presenter;
import models.Inbox;
import models.Team;
import models.User;
import repositories.Repository;
import views.View;

import java.util.Collection;

public class HomePresenter implements Presenter {

    private User mUser;
    private Team currentTeam;
    private Inbox currentInbox;
    private Long defaultTeamId;
    private Long defaultInboxId;
    private Collection<Team> mTeams;
    private Collection<Inbox> mInboxes;
    private boolean isShowingTeams;

    private View mView;
    private Repository mRepository;
    private MainNavigationController mNavigationController;
    private Team defaultTeam = new Team();
    private Inbox defaultInbox = new Inbox();

    public HomePresenter(Repository repository, MainNavigationController navigationController
            , Long defaultTeamId, Long defaultInboxId) {
        super();

        this.mRepository = repository;
        this.mNavigationController = navigationController;
        this.defaultTeamId = defaultTeamId;
        this.defaultInboxId = defaultInboxId;
    }

    @Override
    public void loadUser() {
        mUser = mRepository.getUser();
    }

    @Override
    public void loadTeams() {
        mTeams = mRepository.getTeams();
        if(currentTeam == null && mTeams != null && !mTeams.isEmpty()){
            updateCurrentTeam(defaultTeam);
        }
    }

    @Override
    public void loadInboxes(final Team team) {
        mInboxes = mRepository.getInboxes();
        if(currentInbox == null && mInboxes != null && !mInboxes.isEmpty()){
            updateCurrentInbox(defaultInbox);
        }
    }

    @Override
    public void updateCurrentTeam(Team team) {
        currentTeam = team;
        currentInbox = null;
        loadInboxes(currentTeam);
        mView.setSelectedTeam(currentTeam);
    }

    @Override
    public void updateCurrentInbox(Inbox inbox) {
        currentInbox = inbox;
        mNavigationController.navigateToInbox(currentTeam, inbox);
        mView.setSelectedInbox(currentInbox);
    }

}