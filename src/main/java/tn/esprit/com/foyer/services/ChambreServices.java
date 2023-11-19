package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.entities.Chambre;
import tn.esprit.com.foyer.repositories.BlocRepository;
import tn.esprit.com.foyer.repositories.ChambreRepository;

import java.sql.Time;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServices implements IChambreService{
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc)
    {
    Bloc b = blocRepository.findByNomBloc(nomBloc);
        for(int i=0;i<numChambre.size();i++)
    {
      long k=  numChambre.get(i);
        System.out.println(k);
        Chambre ch = chambreRepository.findById(k).get();
      ch.setBloc(b);
      chambreRepository.save(ch);
    }
        return b;
    }
    @Scheduled(fixedRate = 300000)
    void pourcentageChambreParTypeChambre()
    {
    log.info("start pourcentageChambreParTypeChambre");
    float nbtotal = chambreRepository.findAll().size();
    log.info("Le nombre total des chambres est : " + nbtotal);
    float nbSimple = chambreRepository.findAll().stream().filter(chambre -> chambre.getTypeC().toString().equals("SIMPLE")).count();
    float nbDouble = chambreRepository.findAll().stream().filter(chambre -> chambre.getTypeC().toString().equals("DOUBLE")).count();
    float nbTriple = chambreRepository.findAll().stream().filter(chambre -> chambre.getTypeC().toString().equals("TRIPLE")).count();
    float pourcentageSimple = (nbSimple/nbtotal)*100;
    float pourcentageDouble = (nbDouble/nbtotal)*100;
    float pourcentageTriple = (nbTriple/nbtotal)*100;

        log.info("Le pourcentage des chambres simples est  : " + ( pourcentageSimple + "%"));
        log.info("Le pourcentage des chambres doubles est  : " + ( pourcentageDouble + "%"));
        log.info("Le pourcentage des chambres triples est  : " + ( pourcentageTriple + "%"));
    }

    @Scheduled(fixedRate = 10000)
    void nbPlacesDisponibleParChambreAnneeEnCours() {
    log.info("nbPlacesDisponibleParChambreAnneeEnCours");
        chambreRepository.findAll().stream().forEach(

                chambre -> {
                    int max;
                    int nbReservation;
                   if (chambre.getTypeC().toString().equals("SIMPLE"))
                   {
                       max=1;
                   }
                   else if (chambre.getTypeC().toString().equals("DOUBLE"))
                   {
                       max=2;
                   }
                   else {
                       max =3;
                   }

                   nbReservation=chambre.getReservations().size();
                   int placeDispo = max-nbReservation;
                   log.info("nombre de places disponibles  en " + Year.now().getValue() +" dans la chambre numero " + chambre.getNumeroChambre() + "est : " + placeDispo);




                }
        );

    }


}
