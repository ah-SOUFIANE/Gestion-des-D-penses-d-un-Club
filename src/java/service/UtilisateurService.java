package service;

import dao2.UtilisateurDao;
import entities.Utilisateur;
import java.util.List;

public class UtilisateurService {

    private final UtilisateurDao utilisateurDao;

    public UtilisateurService() {
        this.utilisateurDao = new UtilisateurDao();
    }

    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }
}
