package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServices implements IBlocService{
    BlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return null;
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return null;
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return null;
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return null;
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {

    }

    @Override
    public void removeBloc(Long idBloc) {

    }
}
