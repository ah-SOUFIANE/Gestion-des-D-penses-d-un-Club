package test;

import dao2.CategorieDao;
import entities.Categorie;

public class TestCategorie {
    public static void main(String[] args) {
        CategorieDao dao = new CategorieDao();

        dao.create(new Categorie("Logistique"));

        for (Categorie c : dao.findAll()) {
            System.out.println(c.getNom());
        }
    }
}
