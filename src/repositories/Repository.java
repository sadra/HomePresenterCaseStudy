package repositories;

import models.Inbox;
import models.Team;
import models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Repository{

    public Repository() {
    }

    public User getUser() {
        return new User();
    }

    public Collection<Team> getTeams() {
        Collection<Team> teams = new ArrayList<Team>();
        teams.add(new Team());
        return teams;
    }

    public Collection<Inbox> getInboxes(){
        Collection<Inbox> inboxes = new ArrayList<Inbox>();
        inboxes.add(new Inbox());
        return inboxes;
    }

}
