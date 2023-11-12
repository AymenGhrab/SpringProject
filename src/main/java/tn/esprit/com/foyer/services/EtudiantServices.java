package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Etudiant;
import tn.esprit.com.foyer.entities.Reservation;
import tn.esprit.com.foyer.repositories.EtudiantRepository;
import tn.esprit.com.foyer.repositories.ReservationRepository;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class EtudiantServices implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository ;


    public Etudiant affecterEtudiantAReservation (String nomEt , String prenomEt, String idReservation)
    {

     Etudiant E = etudiantRepository.findByNomEtAndPrenomEt(nomEt,prenomEt) ;
     Reservation R= reservationRepository.findByIdReservation(idReservation) ;
     Set <Reservation> reservations = E.getReservations() ;

        reservations.add(R) ;

     E.setReservations(reservations);
        etudiantRepository.save(E);

        return E ;




     }


    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();

    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }



}
