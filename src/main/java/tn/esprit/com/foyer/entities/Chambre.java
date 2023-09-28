package tn.esprit.com.foyer.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Chambre")
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre")
    private Long idChambre; // Clé primaire
    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;
}
