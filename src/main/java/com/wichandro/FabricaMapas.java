// Luis Alejandro Hernández Márquez (241424)
package com.wichandro;

import java.util.*;

public class FabricaMapas {
    public static Map<String, Pokemon> obtenerMapa(int opcion) {
        switch (opcion) {
            case 1: return new HashMap<>();
            case 2: return new TreeMap<>();
            case 3: return new LinkedHashMap<>();
            default: throw new IllegalArgumentException("Opción inválida");
        }
    }
}