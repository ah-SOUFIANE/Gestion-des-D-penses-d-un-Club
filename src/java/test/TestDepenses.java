package test;

import dao2.DepenseDao;
import dao2.ClubDao;
import dao2.CategorieDao;
import dao2.UtilisateurDao;
import entities.Depense;
import entities.Club;
import entities.Categorie;
import entities.Utilisateur;

import java.util.Date;

public class TestDepenses {

    public static void main(String[] args) {
        DepenseDao dd = new DepenseDao();
        ClubDao cd = new ClubDao();
        CategorieDao catd = new CategorieDao();
        UtilisateurDao ud = new UtilisateurDao();

        Club club = cd.findById(1);
        Categorie cat = catd.findById(1);
        Utilisateur user = ud.findById(1);

//        Depense d1 = new Depense("Achat câbles", 450.0, new Date(), cat, club, user);
//        dd.create(d1);

        for (Depense d : dd.findAll()) {
            System.out.println(d.getLibelle() + " - " + d.getMontant() + " DH");
        }
    }
}
