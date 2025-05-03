package dao2;

import entities.Utilisateur;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UtilisateurDao extends AbstractDao<Utilisateur> {

    public UtilisateurDao() {
        super(Utilisateur.class);
    }

    // 🔍 Exemple : rechercher par email
    public Utilisateur findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        Utilisateur utilisateur = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateur = (Utilisateur) session
                .createQuery("from Utilisateur where email = :email")
                .setParameter("email", email)
                .uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return utilisateur;
    }

    // 🔍 Exemple : récupérer tous les utilisateurs avec un rôle spécifique
    public List<Utilisateur> findByRole(String role) {
        Session session = null;
        Transaction tx = null;
        List<Utilisateur> utilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session
                .createQuery("from Utilisateur where role = :role")
                .setParameter("role", role)
                .list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return utilisateurs;
    }

   
}