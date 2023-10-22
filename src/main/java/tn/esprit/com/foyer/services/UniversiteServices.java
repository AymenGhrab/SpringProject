package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Universite;
import tn.esprit.com.foyer.repositories.UniversteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServices implements IUniversiteService{
    UniversteRepository universteRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universteRepository.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
        return universteRepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        return universteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversity(long idUniversite) {
        return universteRepository.findById(idUniversite).get();
    }

    @Override
    public void removeUniversity(long idUniversite) {
        universteRepository.deleteById(idUniversite);
    }
}