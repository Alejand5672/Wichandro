// Luis Alejandro Hernández Márquez (241424)
package com.wichandro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AdministradorPokemon {
    private Map<String, Pokemon> mapaPokemon;
    private Set<String> coleccionUsuario;

    public AdministradorPokemon(int tipoMapa) {
        this.mapaPokemon = FabricaMapas.obtenerMapa(tipoMapa);
        this.coleccionUsuario = new HashSet<>();
    }

    public void cargarPokemones(String rutaArchivo) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
        for (String linea : lineas.subList(1, lineas.size())) { // Saltar encabezado
            String[] datos = linea.split(",");
            if (datos.length >= 3) {
                mapaPokemon.put(datos[0], new Pokemon(datos[0], datos[1], datos[2]));
            }
        }
    }

    public void agregarPokemonAColeccion(String nombre) {
        if (mapaPokemon.containsKey(nombre)) {
            if (!coleccionUsuario.contains(nombre)) {
                coleccionUsuario.add(nombre);
                System.out.println(nombre + " agregado a la colección.");
            } else {
                System.out.println("Este Pokémon ya está en tu colección.");
            }
        } else {
            System.out.println("Pokémon no encontrado.");
        }
    }

    public void mostrarDatosPokemon(String nombre) {
        System.out.println(mapaPokemon.getOrDefault(nombre, new Pokemon("Desconocido", "-", "-")));
    }

    public void mostrarColeccionUsuario() {
        coleccionUsuario.stream()
                .map(mapaPokemon::get)
                .sorted(Comparator.comparing(Pokemon::getTipo1))
                .forEach(System.out::println);
    }

    public void mostrarTodosLosPokemones() {
        mapaPokemon.values().stream()
                .sorted(Comparator.comparing(Pokemon::getTipo1))
                .forEach(System.out::println);
    }

    public void mostrarPokemonPorHabilidad(String habilidad) {
        mapaPokemon.values().stream()
                .filter(p -> p.getHabilidad().equalsIgnoreCase(habilidad))
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Mapa (1: HashMap, 2: TreeMap, 3: LinkedHashMap): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        AdministradorPokemon administrador = new AdministradorPokemon(opcion);
        administrador.cargarPokemones("pokemon_data_pokeapi.csv");

        int eleccion;
        do {
            System.out.println("\nMenú: 1) Agregar Pokémon 2) Mostrar datos 3) Mostrar colección 4) Mostrar todos 5) Buscar por habilidad 6) Salir");
            eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    administrador.agregarPokemonAColeccion(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    administrador.mostrarDatosPokemon(scanner.nextLine());
                    break;
                case 3:
                    administrador.mostrarColeccionUsuario();
                    break;
                case 4:
                    administrador.mostrarTodosLosPokemones();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    administrador.mostrarPokemonPorHabilidad(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (eleccion != 6);

        scanner.close();
    }
}