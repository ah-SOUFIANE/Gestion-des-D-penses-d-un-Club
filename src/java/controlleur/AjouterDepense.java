package controlleur;

import dao2.*;
import entities.*;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ajouterDepense") // ✅ Redirection vers la JSP avec GET
public class AjouterDepense extends HttpServlet {

    private final DepenseDao depenseDao = new DepenseDao();
    private final CategorieDao categorieDao = new CategorieDao();
    private final ClubDao clubDao = new ClubDao();
    private final UtilisateurDao utilisateurDao = new UtilisateurDao();

   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    // ✅ Charger les listes
    request.setAttribute("categories", categorieDao.findAll());
    request.setAttribute("clubs", clubDao.findAll());
    request.setAttribute("utilisateurs", utilisateurDao.findAll());

    // ✅ Rediriger vers le formulaire
    request.getRequestDispatcher("ajouterDepense.jsp").forward(request, response);
}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // ✅ Récupération des paramètres du formulaire
            String libelle = request.getParameter("libelle");
            double montant = Double.parseDouble(request.getParameter("montant"));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));

            int catId = Integer.parseInt(request.getParameter("categorie"));
            int clubId = Integer.parseInt(request.getParameter("club"));
            int userId = Integer.parseInt(request.getParameter("utilisateur"));

            // ✅ Chargement des objets associés
            Categorie categorie = categorieDao.findById(catId);
            Club club = clubDao.findById(clubId);
            Utilisateur utilisateur = utilisateurDao.findById(userId);

            // ✅ Création et insertion de la dépense
            Depense depense = new Depense(utilisateur, club, libelle, montant, date, categorie);
            depenseDao.create(depense);

            // ✅ Redirection vers la liste des dépenses
            response.sendRedirect("MesDepenses");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erreur : " + e.getMessage());

            // ✅ Recharge des listes pour ne pas casser la JSP
            request.setAttribute("categories", categorieDao.findAll());
            request.setAttribute("clubs", clubDao.findAll());
            request.setAttribute("utilisateurs", utilisateurDao.findAll());

            request.getRequestDispatcher("ajouterDepense.jsp").forward(request, response);
        }
    }
}
