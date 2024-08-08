package org.example.domain.ports.out;

import org.example.domain.model.Articles;


public interface GestionArticlesRepository {
    Articles save(Articles articles) ;
    Articles findById(Integer id);
    Articles findByType(String type);
    Articles findByLibelle(String libelle);
    Articles findByQuantiteDisponible(Integer quantitedisponible);
     Articles findByReferenceArticle(String referenceArticle);
    Articles disable(Articles articles);



    void delete(Articles articles);
}
