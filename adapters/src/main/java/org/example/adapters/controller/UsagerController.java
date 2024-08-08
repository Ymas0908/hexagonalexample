package org.example.adapters.controller;

import lombok.AllArgsConstructor;
import org.example.adapters.in.GererUsagerAdapter;
import org.example.domain.model.Usager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/usager")
class UsagerController {

    private final GererUsagerAdapter gererUsagerAdapter;

    /**
     * Creer un usager
     *
     * @param usager
     * @return Usager
     * @throws Exception
     */
    @PostMapping("/creer")
    public ResponseEntity<Usager> save(@RequestBody Usager usager) throws Exception {

        return ResponseEntity.ok(gererUsagerAdapter.create(usager));
    }

    @PutMapping("/update")
    public ResponseEntity<Usager> update(@RequestBody Usager usager) throws Exception {
        return ResponseEntity.ok(gererUsagerAdapter.update(usager));
    }

    @DeleteMapping("/supprimer/{usagerId}")
    public void supprimer(@PathVariable Integer usagerId) {
        gererUsagerAdapter.delete(usagerId);
    }

    @GetMapping("/rechercherParId/{usagerId}")
    public ResponseEntity<Usager> rechercherParId(@PathVariable Integer usagerId) {
        return ResponseEntity.ok(gererUsagerAdapter.findById(usagerId));
    }

    @GetMapping("rechercherParNom/{nom}")
    public ResponseEntity<List<Usager>> rechercherParNom(@PathVariable String nom) {
        return ResponseEntity.ok(gererUsagerAdapter.findByName(nom));
    }
}
