package org.example.domain.model.enumeration;

import java.util.List;

public class Type {
    private String Electromenager;
    private String Mode;

    public static List<Type> getTypes() {
        return List.of((Type) Type.getTypes());
    }


}



