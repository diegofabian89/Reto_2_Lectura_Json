package com.main;

import org.json.JSONArray;
import org.json.JSONObject;
import com.entities.Heroe;
import com.entities.Heroes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Ruta del archivo JSON donde se guardan los datos
    private static final String url = "src/main/resources/examen.json";

    public static void main(String[] args) throws RuntimeException {
        // Se crea un objeto de la clase Heroes (que contiene la lista de héroes)
        Heroes heroes = new Heroes("Heroes");
        Scanner sc = new Scanner(System.in);
        String opcion;
        boolean salida = false;

        // Ciclo para añadir héroes mientras no se decida salir
        while (!salida) {
            System.out.println("Bienvenido, introduce los datos de tu héroe: Para terminar pulsa * ");
            // Se añaden los datos del héroe introducido por el usuario
            if (heroes.addHeroe(introDatos())) {
                System.out.println("Héroe añadido.");
                System.out.println("¿Deseas continuar añadiendo héroes? Presiona cualquier tecla || Para salir presiona * ");
                opcion = sc.nextLine();
            } else {
                // Si no se puede añadir el héroe, termina el programa
                System.out.println("error al introducir datos");
                return;
            }

            // Si el usuario ingresa "*", se termina el ciclo
            if (opcion.equals("*")) {
                salida = true;
                System.out.println("Procediendo a guardar los datos de tu héroe, Adiós...");
            }
        }

        // Se lee el archivo JSON existente y se añaden los héroes a él
        JSONObject objetoLeido = lecturaJSon();
        //metodo para la sobrescritura de los datos
        escrituraJSon(heroes, objetoLeido);
    }

    // Método para escribir los héroes en el archivo JSON
    private static void escrituraJSon(Heroes heroes, JSONObject archivo) {
        // Se obtiene el array de héroes del archivo JSON
        JSONArray jsonHeroes = archivo.getJSONArray("heroes");

        if (!heroes.getHeroes().isEmpty()) {
            // Si hay héroes, se añaden al JSON
            for (Heroe h : heroes.getHeroes()) {
                // Se obtiene el objeto JSON del héroe
                JSONObject objHero = h.getJsonObject();
                // Se añade al array
                jsonHeroes.put(objHero);
            }
            // Se actualiza el array de héroes en el objeto JSON
            archivo.put("heroes", jsonHeroes);

            // Se escribe el archivo JSON con los nuevos datos
            try (FileWriter fileWriter = new FileWriter(url)) {
                // Se escribe con una indentación de 4 espacios
                fileWriter.write(archivo.toString(4));
                System.out.println("Escritura exitosa");
            } catch (IOException e) {
                System.out.println("Error de escritura: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("No existe el heroe");
        }
    }

    // Método para introducir los datos de un héroe
    private static Heroe introDatos() {
        // Se crea un objeto Heroe
        Heroe heroe = new Heroe();
        String dato;
        int num;
        Scanner sc = new Scanner(System.in);

        // Se solicitan los datos del héroe al usuario
        System.out.println("Introduzca un nombre del héroe: ");
        dato = sc.nextLine();
        heroe.setHeroName(dato);

        System.out.println("Introduzca la identidad del héroe: ");
        dato = sc.nextLine();
        heroe.setNombre(dato);

        System.out.println("Introduzca el link del héroe: ");
        dato = sc.nextLine();
        heroe.setLink(dato);

        System.out.println("Introduzca el link de imagen del héroe: ");
        dato = sc.nextLine();
        heroe.setImg(dato);

        System.out.println("Introduzca el tamaño del héroe: ");
        //se evalua si el dato introducido es un int en caso contrario se agrega un valor sero a size
        if (sc.hasNextInt()) {
            // Se obtiene el size como un entero
            num = sc.nextInt();
        } else {
            // Si el dato no es un número, se asigna 0
            num = 0;
        }
        // Se asigna el tamaño al héroe
        heroe.setSize(num);
        // Se devuelve el héroe con los datos introducidos
        return heroe;
    }

    // Método para leer el archivo JSON existente
    private static JSONObject lecturaJSon() {
        // Se crea un objeto File con la ruta del archivo
        File file = new File(url);

        // Si el archivo existe, se lee su contenido
        if (file.exists()) {
            //try with resources para un cierre automatico tras la lectura del archivo
            try (FileReader fileReader = new FileReader(file)) {
                StringBuilder stringBuilder = new StringBuilder();
                int i;
                // Se lee el archivo carácter por carácter y se agrega al StringBuilder
                while ((i = fileReader.read()) != -1) {
                    //casteo de la variable tipo int a tipo char
                    stringBuilder.append((char) i);
                }
                // Se crea un objeto JSONObject con el contenido leído
                return new JSONObject(stringBuilder.toString());
            } catch (IOException e) {
                System.out.println("Error de lectura: " + e.getMessage());
                throw new RuntimeException(e);
            }
        } else {
            // Si el archivo no existe, se devuelve un JSONObject vacío
            return new JSONObject();
        }
    }
}
