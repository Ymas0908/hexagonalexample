// Importation des bibliothèques nécessaires
package org.example.adapters.controller;

import lombok.AllArgsConstructor;
import org.example.adapters.in.GererArticleAdapter;
import org.example.domain.model.Articles;
import org.example.domain.model.Usager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Articles")
class ArticleController {

    // Déclaration d'une dépendance gérée par Spring
    private final GererArticleAdapter gererArticleAdapter;
    /**
     * Crée un nouvel usager
     *
     * @param articles L'objet usager à créer
     * @return ResponseEntity contenant l'usager créé
     * @throws Exception
     */

    @PostMapping("/save")
    public ResponseEntity<Articles> save(@RequestBody Articles articles)  {
        return ResponseEntity.ok(gererArticleAdapter.create(articles));
    }
    /**
     * Met à jour un article existant
     *
     * @param articles L'objet usager à mettre à jour
     * @return ResponseEntity contenant l'usager mis à jour
     * @throws Exception
     */
    @PutMapping("/updatearticle")
    public ResponseEntity<Articles> update(@RequestBody Articles articles)  {
        return ResponseEntity.ok(gererArticleAdapter.update(articles));
    }
    /**
     * Supprime un article par son ID
     *
     * @param articleId L'ID de l'article à supprimer
     */
    @DeleteMapping("/supprimer/{articleId}")
    public void supprimer(@PathVariable Integer articleId) {
        gererArticleAdapter.delete(articleId);
    }
    /**
     * Recherche un article par son ID
     *
     * @param articleId L'ID de l'usager à rechercher
     * @return ResponseEntity contenant l'usager trouvé
     */
    @GetMapping("/rechercherParId/{articledId}")
    public ResponseEntity<Articles> rechercherParId(@PathVariable Integer articleId){
        return ResponseEntity.ok(gererArticleAdapter.findById(articleId));
    }
    /**
     * Recherche un article par son nom
     *
     * @param nom Le nom de l'article à rechercher
     * @return ResponseEntity contenant l'usager：
     */
    @GetMapping("rechercherarticleParNom/{nom}")
    public ResponseEntity<List<Articles>> rechercherParNom(@PathVariable String nom) {
        return ResponseEntity.ok(gererArticleAdapter.findByName(nom));
    }

   @GetMapping("rechercherarticleParLibelle/{libelle}")
    public ResponseEntity <Articles> rechercherParLibelle(@PathVariable String libelle) {
        return ResponseEntity.ok(gererArticleAdapter.findByLibelle(libelle));
    }


    @GetMapping("/rechercherparstatut/{statut}")
    public ResponseEntity rechercherParStatut(@PathVariable String statut) {
        return ResponseEntity.ok(gererArticleAdapter.findByStatus(statut));
    }



}
