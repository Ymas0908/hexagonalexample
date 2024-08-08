package org.example.domain.service;

import org.example.domain.DomainConfig.DomaineService;
import org.example.domain.model.Usager;
import org.example.domain.ports.in.GererUsager;
import org.example.domain.ports.out.GestionUsagerRepository;

import java.util.List;


@DomaineService
public class GererUsagerService implements GererUsager {

    private final GestionUsagerRepository gestionUsagerRepository;

    public GererUsagerService(GestionUsagerRepository gestionUsagerRepository) {
        this.gestionUsagerRepository = gestionUsagerRepository;
    }

    @Override
    public Usager ajouterUsager(Usager usager) throws Exception {
        if (!verifierSyntaxeUsager(usager)) {
            throw new Exception("Veuillez renseigner correctement les champs");
        }

        return gestionUsagerRepository.save(usager);
    }

    @Override
    public Usager modifierUsager(Usager usager) throws Exception {
        //Verifier si l'usager existe
        Usager usagerToUpdate = gestionUsagerRepository.findById(usager.getId());
        if (usager.getNom() != null) {
            usagerToUpdate.setNom(usager.getNom());
        }
        if (usager.getPrenom() != null) {
            usagerToUpdate.setPrenom(usager.getPrenom());
        }
        if (usager.getEmail() != null) {
            usagerToUpdate.setEmail(usager.getEmail());
        }
        if (usager.getMotDePasse() != null) {
            usagerToUpdate.setMotDePasse(usager.getMotDePasse());
        }
        //Verifier les champs
        if (!verifierSyntaxeUsager(usagerToUpdate)) {
            throw new Exception("Remplir convenablement des champs");
        }

        return gestionUsagerRepository.save(usagerToUpdate);
    }

    @Override
    public void supprimerUsager(Integer idUsager) {
        Usager toDelete = gestionUsagerRepository.findById(idUsager);
        gestionUsagerRepository.delete(toDelete);
    }

    @Override
    public List<Usager> rechercherUsagerParNom(String usager) {
        return gestionUsagerRepository.findByName(usager);
    }

    @Override
    public Usager rechercherUsagerParId(Integer id) {
        return gestionUsagerRepository.findById(id);
    }

    private boolean verifierSyntaxeUsager(Usager usager) {
        return !usager.getNom().isBlank()
                && usager.getNom().length() >= 2
                && !usager.getPrenom().isBlank()
                && usager.getPrenom().length() >= 2
                && !usager.getEmail().isBlank()
                && usager.getEmail().length() >= 5;
    }
}
