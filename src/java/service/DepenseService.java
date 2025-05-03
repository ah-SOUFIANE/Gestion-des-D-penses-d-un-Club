package service;

import dao2.DepenseDao;
import entities.Depense;
import java.util.List;

public class DepenseService {
    private final DepenseDao dao;

    public DepenseService() {
        dao = new DepenseDao();
    }

    public List<Depense> findByUtilisateur(int idUtilisateur) {
        return dao.findByUtilisateur(idUtilisateur);
    }
}
