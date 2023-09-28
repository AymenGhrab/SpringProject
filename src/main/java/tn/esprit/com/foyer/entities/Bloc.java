package tn.esprit.com.foyer.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBloc")
    private Long idFoyer; // Clé primaire
    private String nomBloc;
    private Long capaciteBloc;
}
