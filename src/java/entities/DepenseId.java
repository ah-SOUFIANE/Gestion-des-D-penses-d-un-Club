package entities;

import java.io.Serializable;
import java.util.Objects;

public class DepenseId implements Serializable {
    private int utilisateur;
    private int club;

    public DepenseId() {}

    public DepenseId(int utilisateur, int club) {
        this.utilisateur = utilisateur;
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepenseId)) return false;
        DepenseId that = (DepenseId) o;
        return utilisateur == that.utilisateur && club == that.club;
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateur, club);
    }
}
