package interfaces;

import models.Inbox;
import models.Team;

public interface Presenter{
    void loadUser();
    void loadTeams();
    void loadInboxes(Team team);
    void updateCurrentTeam(Team team);
    void updateCurrentInbox(Inbox inbox);
}
