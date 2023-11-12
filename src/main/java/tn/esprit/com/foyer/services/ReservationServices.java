package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Chambre;
import tn.esprit.com.foyer.entities.Reservation;
import tn.esprit.com.foyer.repositories.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ReservationServices implements IReservationService {
    ReservationRepository reservationRepository;

    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin )

    {


        return reservationRepository.findByAnneeReservationBetween(dateDebut, dateFin);
    }



    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}