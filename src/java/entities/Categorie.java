package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    public Categorie() {
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // ✅ Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
