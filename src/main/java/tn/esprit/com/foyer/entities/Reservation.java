package tn.esprit.com.foyer.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @Column(name = "idReservation", length = 50)
    private String idReservation; // Clé primaire
    private Date anneeReservation;
    private boolean estValide;
    @ManyToMany(mappedBy="reservations", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    public Reservation() {
    }

    public Reservation(String idReservation, Date anneeReservation, boolean estValide, Set<Etudiant> etudiants) {
        this.idReservation = idReservation;
        this.anneeReservation = anneeReservation;
        this.estValide = estValide;
        this.etudiants = etudiants;
    }

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public Date getAnneeReservation() {
        return anneeReservation;
    }

    public void setAnneeReservation(Date anneeReservation) {
        this.anneeReservation = anneeReservation;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}