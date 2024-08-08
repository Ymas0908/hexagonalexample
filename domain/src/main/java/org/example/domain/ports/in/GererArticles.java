package org.example.domain.ports.in;

import org.example.domain.model.Articles;
import org.example.domain.model.Usager;

import java.util.List;


public interface GererArticles {

    Articles ajouterArticles(Articles articles) ;

    Articles modifierArticles(Articles articles);

    Articles rechercherArticlesParId(Integer id);
    void supprimerArticles(Integer idArticles);

    List<Articles> rechercherArticlesParNom(String articles);

    Articles rechercherArticlesBylibelle(String articles);
    Articles rechercherArticlesParStatut(String referenceArticle);



}
