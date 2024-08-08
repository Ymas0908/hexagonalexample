package org.example.adapters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.model.Usager;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usager")
@Entity
public class UsagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    /**
     * Cette methode permet de convertir un objet du domain en un objet de persistence
     *
     * @param usagerEntity
     * @return Usager
     */
    public static Usager toDomainUsager(UsagerEntity usagerEntity) {
        return new Usager(
                usagerEntity.getId(),
                usagerEntity.getNom(),
                usagerEntity.getPrenom(),
                usagerEntity.getEmail(),
                usagerEntity.getMotDePasse()
        );
    }


    /**
     * Cette methode permet de convertir un objet de persistence en un objet du domain
     *
     * @param usager
     * @return UsagerEntity
     */
    public static UsagerEntity toEntity(Usager usager) {
        return new UsagerEntity(
                usager.getId(),
                usager.getNom(),
                usager.getPrenom(),
                usager.getEmail(),
                usager.getMotDePasse()
        );
    }
}
