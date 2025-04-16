package dao2;

import entities.Depense;

public class DepenseDao extends AbstractDao<Depense> {
    public DepenseDao() {
        super(Depense.class);
    }

    // 🔍 Exemple de méthode personnalisée si besoin :
    // public List<Depense> findByClub(Club club) { ... }
}
