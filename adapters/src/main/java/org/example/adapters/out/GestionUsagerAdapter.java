package org.example.adapters.out;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.adapters.model.UsagerEntity;
import org.example.adapters.repository.UsagerRepository;
import org.example.domain.model.Usager;
import org.example.domain.ports.out.GestionUsagerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GestionUsagerAdapter implements GestionUsagerRepository {

    private final UsagerRepository usagerRepository;

    /**
     * Cette methode permet d'enregistrer un nouvel usager
     *
     * @param usager
     * @return Usager
     */
    @Override
    public Usager save(Usager usager) throws Exception {
        UsagerEntity usagerDB = usagerRepository.findByEmailContainingIgnoreCase(usager.getEmail());
        if (usagerDB != null && !Objects.equals(usagerDB.getId(), usager.getId())) {
            throw new Exception("Un usager existe avec cet email");
        }
        //Instancier un nouvel objet de type usagerEntity
        UsagerEntity usagerToCreate = new UsagerEntity();


        //Sauvegarder
        usagerToCreate = usagerRepository.save(converteToEntity(usager));

        return converteToDomain(usagerToCreate);
    }

    /**
     * Supprimer un usager
     *
     * @param usager
     */
    @Override
    public void delete(Usager usager) {
        usagerRepository.delete(converteToEntity(usager));
    }

    /**
     * Rechercher un usager par son id
     *
     * @param id
     * @return
     */
    @Override
    public Usager findById(Integer id) {
        Optional<UsagerEntity> optionalUsager = usagerRepository.findById(id);
        //Verifier si l'usager existe
        if (optionalUsager.isEmpty()) {
            throw new EntityNotFoundException("Cet usager est introuvable");
        }
        return converteToDomain(optionalUsager.get());
    }

    /**
     * Rechercher des usagers par un nom
     *
     * @param name
     * @return
     */
    @Override
    public List<Usager> findByName(String name) {
        return usagerRepository.findByNomIsContainingIgnoreCase(name)
                .stream()
                .map(this::converteToDomain)
                .toList();
    }
    @Override
    public Usager findByEmail(String email) {
        return converteToDomain(usagerRepository.findByEmailContainingIgnoreCase(email));
    }

    /**
     * Cette methode permet de convertir usager en usagerEntity
     *
     * @param usager
     * @return
     */
    private UsagerEntity converteToEntity(Usager usager) {
        return UsagerEntity.toEntity(usager);
    }

    /**
     * Cette methode permet de convertir usagerEntity en usager
     *
     * @param usagerEntity
     * @return
     */
    private Usager converteToDomain(UsagerEntity usagerEntity) {
        return UsagerEntity.toDomainUsager(usagerEntity);
    }
}
