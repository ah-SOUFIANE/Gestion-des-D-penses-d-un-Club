package controlleur;

import entities.Utilisateur;
import service.ServiceUtilisateur;
import util.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Authentification", urlPatterns = {"/Authentification"})
public class Authentification extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u = su.getByEmail(email);

        if (u != null) {
            if (u.getMotDePasse().equals(Util.md5(password))) {
                HttpSession session = request.getSession();
                session.setAttribute("utilisateur", u);
                u.setEtat(1);
                su.update(u);

                if ("admin".equalsIgnoreCase(u.getRole())) {
                    response.sendRedirect("adminDashboard.jsp");
                } else {
                    response.sendRedirect("userDashboard.jsp");
                }

            } else {
                response.sendRedirect("login.jsp?msg=Mot de passe incorrect");
            }
        } else {
            response.sendRedirect("login.jsp?msg=Email introuvable");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Contrôleur d'authentification de l'utilisateur";
    }
}
