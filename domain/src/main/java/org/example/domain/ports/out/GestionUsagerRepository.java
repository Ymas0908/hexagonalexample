package org.example.domain.ports.out;

import org.example.domain.model.Usager;

import java.util.List;


public interface GestionUsagerRepository {
    Usager save(Usager usager) throws Exception;


    void delete(Usager usager);

    Usager findById(Integer id);

    List<Usager> findByName(String name);

    Usager findByEmail(String email);
}
