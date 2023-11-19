package tn.esprit.com.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.foyer.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {



}
