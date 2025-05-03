package service;

import dao2.ClubDao;
import entities.Club;
import java.util.List;

public class ClubService {

    private final ClubDao clubDao;

    public ClubService() {
        this.clubDao = new ClubDao();
    }

    public List<Club> findAll() {
        return clubDao.findAll();
    }
}
