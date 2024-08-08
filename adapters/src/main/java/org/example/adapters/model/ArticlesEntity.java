package org.example.adapters.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.model.Articles;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Articles")
@Entity
public class ArticlesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true)
    private Integer id;
    private String libelle;
    private String description;
    private Integer quantitedisponible;
    private String referenceArticle;
    private String type;
    private Integer prix;
    private String status;

    /**
     * Cette methode permet de convertir un objet de persistence en un objet du domain
     *
     * @param articles
     * @return ArticlesEntity
     */
    public static ArticlesEntity toEntity(Articles articles) {

        return new ArticlesEntity(
                articles.getId(),
                articles.getLibelle(),
                articles.getDescription(),
                articles.getQuantitedisponible(),
                articles.getReferenceArticle(),
                articles.getType(),
                articles.getPrix(),
                articles.getStatus()
        );
    }

    public static Articles toDomainArticles(ArticlesEntity articlesEntity) {
        return new Articles(
                        articlesEntity.getId(),
                        articlesEntity.getLibelle(),
                articlesEntity.getPrix(),
                articlesEntity.getDescription(),
                articlesEntity.getQuantitedisponible(),
                articlesEntity.getReferenceArticle(),
                articlesEntity.getType(),
                articlesEntity.getStatus()
                );

    }
}
