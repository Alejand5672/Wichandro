package com.wichandro;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class AdministradorPokemonTest {

    @Test
    public void testAgregarPokemonAColeccion() {
        AdministradorPokemon admin = new AdministradorPokemon(1); // Usar HashMap
        try {
            admin.cargarPokemones("pokemon_data_pokeapi.csv");
        } catch (Exception e) {
            fail("Error al cargar el archivo CSV: " + e.getMessage());
        }

        // Agregar un Pokémon existente
        admin.agregarPokemonAColeccion("Pikachu");

        // Verificar que el Pokémon se agregó correctamente
        // (No podemos acceder directamente a la colección, pero podemos verificar el comportamiento)
        admin.mostrarColeccionUsuario(); // Debería mostrar "Pikachu"

        // Intentar agregar el mismo Pokémon nuevamente
        admin.agregarPokemonAColeccion("Pikachu"); // Debería mostrar un mensaje de que ya está en la colección

        // Intentar agregar un Pokémon que no existe
        admin.agregarPokemonAColeccion("PokemonInexistente"); // Debería mostrar un mensaje de que no se encontró
    }

    @Test
    public void testMostrarDatosPokemon() {
        AdministradorPokemon admin = new AdministradorPokemon(1); // Usar HashMap
        try {
            admin.cargarPokemones("pokemon_data_pokeapi.csv");
        } catch (Exception e) {
            fail("Error al cargar el archivo CSV: " + e.getMessage());
        }

        // Verificar los datos de un Pokémon existente
        admin.mostrarDatosPokemon("Pikachu"); // Debería mostrar los datos de Pikachu

        // Verificar los datos de un Pokémon que no existe
        admin.mostrarDatosPokemon("PokemonInexistente"); // Debería mostrar un Pokémon "Desconocido"
    }

    private AdministradorPokemon administrador;

    @Before
    public void setUp() {
        administrador = new AdministradorPokemon(1); // Usar HashMap
    }


    @Test(expected = IOException.class)
    public void testCargarPokemonesArchivoNoExistente() throws IOException {
        String rutaArchivo = "archivo_inexistente.csv"; // Archivo que no existe
        administrador.cargarPokemones(rutaArchivo);
    }
    
    @Test
public void testAgregarPokemonAColeccionExistente() {
    administrador.getMapaPokemon().put("Pikachu", new Pokemon("Pikachu", "Eléctrico", "Estático"));
    administrador.agregarPokemonAColeccion("Pikachu");
    assertTrue(administrador.getColeccionUsuario().contains("Pikachu"));
}

@Test
public void testAgregarPokemonAColeccionNoExistente() {
    administrador.agregarPokemonAColeccion("Charizard");
    assertFalse(administrador.getColeccionUsuario().contains("Charizard"));
}
}

