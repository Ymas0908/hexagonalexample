package org.example.adapters.in;

import lombok.AllArgsConstructor;
import org.example.domain.model.Usager;
import org.example.domain.ports.in.GererUsager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GererUsagerAdapter {

    private final GererUsager gererUsager;

    public Usager create(Usager usager) throws Exception {
        return gererUsager.ajouterUsager(usager);
    }


    public void delete(Integer idUsager) {
        gererUsager.supprimerUsager(idUsager);
    }

    public Usager findById(Integer id) {
        return gererUsager.rechercherUsagerParId(id);
    }

    public List<Usager> findByName(String name) {
        return gererUsager.rechercherUsagerParNom(name);
    }


    public Usager update(Usager usager) throws Exception {
        return gererUsager.modifierUsager(usager);
    }
}
