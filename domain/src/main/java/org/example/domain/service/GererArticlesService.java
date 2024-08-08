package org.example.domain.service;

import org.example.domain.DomainConfig.DomaineService;
import org.example.domain.model.Articles;
import org.example.domain.ports.in.GererArticles;
import org.example.domain.ports.out.GestionArticlesRepository;

import java.util.List;


@DomaineService
public class GererArticlesService implements GererArticles {
    private final GestionArticlesRepository gestionArticlesRepository;


    public GererArticlesService(GestionArticlesRepository gestionArticlesRepository) {
        this.gestionArticlesRepository = gestionArticlesRepository;
    }

    @Override
    public Articles ajouterArticles(Articles articles) {
        return gestionArticlesRepository.save(articles);
    }
    @Override
    public Articles modifierArticles(Articles articles)  {
        articles.setId(articles.getId());
        return gestionArticlesRepository.save(articles);
    }
    @Override
    public void supprimerArticles(Integer idArticle) {
        Articles toDelete = gestionArticlesRepository.findById(idArticle);
        gestionArticlesRepository.delete(toDelete);
    }
    @Override
    public List<Articles> rechercherArticlesParNom(String articles) {
        return (List<Articles>) gestionArticlesRepository.findByLibelle(articles);
    }

    @Override
    public Articles rechercherArticlesBylibelle(String articles) {
        return gestionArticlesRepository.findByLibelle(articles);
    }

    @Override
    public Articles rechercherArticlesParStatut(String referenceArticle) {
        return gestionArticlesRepository.findByReferenceArticle(referenceArticle);
    }



    @Override
    public Articles rechercherArticlesParId(Integer id) {
        return gestionArticlesRepository.findById(id);
    }
}


