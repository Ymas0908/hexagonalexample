package org.example.adapters.repository;

import org.example.adapters.model.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticlesRepository extends JpaRepository<ArticlesEntity, Integer> {
    ArticlesEntity findByDescription(String description);
    ArticlesEntity findByLibelle(String libelle);
    ArticlesEntity findByQuantitedisponible(Integer quantitedisponible);

    ArticlesEntity findByPrix(Integer prix);
    ArticlesEntity findByReferenceArticle(String referenceArticle);
    ArticlesEntity findByType(String type);



}
