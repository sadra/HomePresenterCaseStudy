package views;

import models.Inbox;
import models.Team;

public class View {

    private Team selectedTeam;
    private Inbox selectedInbox;


    public View() {
    }

    public void setSelectedTeam(Team currentTeam) {
        selectedTeam = currentTeam;
    }

    public void setSelectedInbox(Inbox currentInbox) {
        selectedInbox = currentInbox;
    }

    public Team getSelectedTeam() {
        return selectedTeam;
    }

    public Inbox getSelectedInbox() {
        return selectedInbox;
    }
}
