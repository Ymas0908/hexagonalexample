package org.example.domain.model.enumeration;

import java.util.List;

public enum Statut {
    Disponible,
    NonDisponible;

    public static List<Statut> getStatuts() {
        return List.of(Statut.values());
    }
}



