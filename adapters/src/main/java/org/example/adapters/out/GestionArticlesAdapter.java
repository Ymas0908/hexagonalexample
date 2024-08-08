package org.example.adapters.out;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.adapters.model.ArticlesEntity;
import org.example.adapters.repository.ArticlesRepository;
import org.example.domain.model.Articles;
import org.example.domain.ports.out.GestionArticlesRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class GestionArticlesAdapter implements GestionArticlesRepository {

    private final ArticlesRepository articlesRepository;

    /**
     * Cette methode permet de convertir articlesEntity en article
     *
     * @param articlesEntity
     * @return
     */
    private Articles convertToDomain(ArticlesEntity articlesEntity) {
        return ArticlesEntity.toDomainArticles(articlesEntity);
    }
    /**
     * Cette methode permet de convertir un article en articlesEntity
     *
     * @param articles
     * @return
     */
    private ArticlesEntity convertToEntity(Articles articles) {
        return ArticlesEntity.toEntity(articles);
    }

    @Override
    public Articles save(Articles articles) {
        ArticlesEntity articlesEntity = convertToEntity(articles);
        System.out.println(articlesEntity.getId());
        ArticlesEntity savedEntity = articlesRepository.save(articlesEntity);
        return convertToDomain(savedEntity);
    }

    @Override
    public Articles findById(Integer id) {
        Optional<ArticlesEntity> optionalArticles = articlesRepository.findById(id);
        if (optionalArticles.isEmpty()) {
            throw new EntityNotFoundException("Cet article est introuvable");
        }
        return convertToDomain(optionalArticles.get());
    }

    @Override
    public Articles findByType(String type) {
        Optional<ArticlesEntity> optionalArticles = Optional.ofNullable(articlesRepository.findByType(type));
        if (optionalArticles.isEmpty()) {
            throw new EntityNotFoundException("Aucun article trouvé pour ce type");
        }
        return convertToDomain(optionalArticles.get());
    }

    @Override
    public Articles findByLibelle(String libelle) {
        Optional<ArticlesEntity> optionalArticles = Optional.ofNullable(articlesRepository.findByLibelle(libelle));
        if (optionalArticles.isEmpty()) {
            throw new EntityNotFoundException("Cet article est introuvable");
        }
        return convertToDomain(optionalArticles.get());
    }

    @Override
    public Articles findByQuantiteDisponible(Integer quantitedisponible) {
        Optional<ArticlesEntity> optionalArticles = Optional.ofNullable(articlesRepository.findByQuantitedisponible(quantitedisponible));
        if (optionalArticles.isEmpty()) {
            throw new EntityNotFoundException("Cet article est introuvable");
        }
        return convertToDomain(optionalArticles.get());
    }

    @Override
    public Articles findByReferenceArticle(String referenceArticle) {
        Optional<ArticlesEntity> optionalArticles = Optional.ofNullable(articlesRepository.findByReferenceArticle(referenceArticle));
        if (optionalArticles.isEmpty()) {
            throw new EntityNotFoundException("Cet article est introuvable");
        }
        return convertToDomain(optionalArticles.get());
    }

    @Override
    public Articles disable(Articles articles)  {
        ArticlesEntity articlesEntity = convertToEntity(articles);
        ArticlesEntity savedEntity = articlesRepository.save(articlesEntity);
        return convertToDomain(savedEntity);
    }



    @Override
    public void delete(Articles articles) {
        ArticlesEntity articlesEntity = convertToEntity(articles);
        articlesRepository.delete(articlesEntity);
    }


}
