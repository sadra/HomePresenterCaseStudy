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
        return new ArrayList<Team>();
    }

    public Collection<Inbox> getInboxes(){
        return new ArrayList<Inbox>();
    }

}
