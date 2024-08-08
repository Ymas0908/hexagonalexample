package org.example.domain.ports.in;

import org.example.domain.model.Usager;

import java.util.List;


public interface GererUsager {

    Usager ajouterUsager(Usager usager) throws Exception;

    Usager modifierUsager(Usager usager) throws Exception;

    void supprimerUsager(Integer idUsager);

    List<Usager> rechercherUsagerParNom(String usager);

    Usager rechercherUsagerParId(Integer id);
}
