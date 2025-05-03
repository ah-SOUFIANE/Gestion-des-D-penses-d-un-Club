package service;

import dao2.CategorieDao;
import entities.Categorie;
import java.util.List;

public class CategorieService {

    private final CategorieDao categorieDao;

    public CategorieService() {
        this.categorieDao = new CategorieDao();
    }

    public List<Categorie> findAll() {
        return categorieDao.findAll();
    }
}
