package org.example.adapters.in;

import lombok.AllArgsConstructor;
import org.example.domain.model.Articles;
import org.example.domain.ports.in.GererArticles;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GererArticleAdapter {

    private final GererArticles gererArticles;

    public Articles create(Articles articles)  {
        return gererArticles.ajouterArticles(articles);
    }
    public void delete(Integer integer) {
        gererArticles.supprimerArticles(integer);
    }
    public Articles findById(Integer id)  {
        return gererArticles.rechercherArticlesParId(id);
    }
    public List<Articles> findByName(String name) {
        return gererArticles.rechercherArticlesParNom(name);
    }
    public Articles update(Articles articles) {

        return gererArticles.modifierArticles(articles);
    }

    public Articles findByLibelle(String libelle) {
        return gererArticles.rechercherArticlesBylibelle(libelle);
    }

    public Articles findByStatus(String statut) {
        return gererArticles.rechercherArticlesParStatut(statut);
    }

}
