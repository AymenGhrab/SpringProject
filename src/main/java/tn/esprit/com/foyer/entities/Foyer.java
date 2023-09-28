package tn.esprit.com.foyer.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Foyer")
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer")
    private Long idFoyer; // Clé primaire
    private String nomFoyer;
    private Long capaciteFoyer;
}
