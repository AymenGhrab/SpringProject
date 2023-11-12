package tn.esprit.com.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.foyer.entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

   public Reservation findByIdReservation(String id) ;

   public List<Reservation> findByAnneeReservationBetween(Date dateDebut, Date dateFin);

}
