package models;

public class Current {

    private Team currentTeam;
    private Inbox currentInbox;

    public Current(Team currentTeam, Inbox currentInbox) {
        this.currentTeam = currentTeam;
        this.currentInbox = currentInbox;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public Inbox getCurrentInbox() {
        return currentInbox;
    }
}
