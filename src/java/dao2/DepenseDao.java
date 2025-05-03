package dao2;

import entities.Depense;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public class DepenseDao extends AbstractDao<Depense> {

    public DepenseDao() {
        super(Depense.class);
    }

    @SuppressWarnings("unchecked") // ✅ Pour éviter le warning du cast
    public List<Depense> findByUtilisateur(int idUtilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Depense> list = (List<Depense>) session
            .createQuery("from Depense where utilisateur.id = :id")
            .setParameter("id", idUtilisateur)
            .list();

        session.getTransaction().commit();
        session.close();

        return list;
    }
}
