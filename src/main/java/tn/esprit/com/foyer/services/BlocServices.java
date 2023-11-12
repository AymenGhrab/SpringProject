package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.entities.Foyer;
import tn.esprit.com.foyer.repositories.BlocRepository;
import tn.esprit.com.foyer.repositories.FoyerRepository;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class BlocServices implements IBlocService{
    BlocRepository blocRepository;
    FoyerRepository foyerRepository ;

    public Foyer addFoyerWithBloc (Foyer foyer)
    {
   Foyer F =   foyerRepository.save(foyer) ;

        foyer.getBloc().forEach(B ->
                {
                  B.setFoyer(F);
                  blocRepository.save(B)  ;


                });

    return F  ;
    }
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
