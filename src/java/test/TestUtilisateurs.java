package test;

import dao2.UtilisateurDao;
import entities.Utilisateur;

import java.util.Date;

public class TestUtilisateurs {

    public static void main(String[] args) {
        UtilisateurDao ud = new UtilisateurDao();

        Utilisateur u = new Utilisateur("Yassine", "Salihi", "yassine@mail.com", "admin123", "admin", new Date(), null);
        ud.create(u);

        for (Utilisateur us : ud.findAll()) {
            System.out.println(us.getNom() + " - " + us.getEmail());
        }
    }
}
