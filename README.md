##### @autor Diego Fabian Ordonez Ontaneda

# Proyecto de Gestión de Héroes


Este proyecto permite gestionar una lista de héroes, añadiendo sus datos (nombre, identidad, link, imagen y tamaño) y almacenándolos en un archivo JSON. El archivo JSON mantiene tres secciones: héroes, villanos y equipos. Los héroes pueden ser añadidos al archivo sin sobrescribir los datos existentes.

## Requisitos

- Java 8 o superior
- Dependencias: `org.json` para manejar JSON.

## Estructura del Proyecto

El proyecto contiene las siguientes clases principales:

1. **Main.java**: Contiene el flujo principal del programa, donde se interactúa con el usuario para añadir héroes y almacenar los datos en un archivo JSON.
2. **Heroe.java**: Representa a un héroe, con atributos como nombre, identidad, link, imagen y tamaño. Proporciona un método `getJsonObject()` para convertir los datos del héroe a formato JSON.
3. **Heroes.java**: Contiene una lista de héroes y un método `addHeroe()` para añadir héroes a la lista.

### Estructura del JSON

El archivo JSON tiene el siguiente formato:

```json
{
  "heroes": [
    {
      "heroName": "Spider-Man",
      "nombre": "Peter Benjamin Parker",
      "link": "http://marvel.com/characters/54/spider-man",
      "img": "https://example.com/spiderman.png",
      "size": 40000
    },
    ...
  ],
  "villains": [
    ...
  ],
  "teams": [
    ...
  ]
}
```

## Características

- **Agregar Héroes**: El usuario puede agregar héroes con información detallada.
- **Almacenamiento en JSON**: Los héroes se almacenan en un archivo JSON.
- **Lectura y Escritura**: El programa puede leer un archivo JSON existente y agregar nuevos héroes a los datos existentes.
- **Interfaz de línea de comandos**: La interacción con el usuario se realiza a través de la consola.

## Estructura del Proyecto

- **`Main.java`**: Contiene la lógica principal de la aplicación, donde se gestionan los héroes y la interacción con el usuario.
- **`Heroe.java`**: Representa a un héroe con atributos como `heroName`, `nombre`, `link`, `img` y `size`.
- **`Heroes.java`**: Gestiona una lista de héroes.
- **`examen.json`**: El archivo donde se almacenan los héroes en formato JSON.

## Instalación

1. Clona este repositorio o descarga los archivos fuente.
2. Asegúrate de tener Java 8 o superior instalado.
3. Importa el proyecto a tu entorno de desarrollo favorito (por ejemplo, IntelliJ IDEA, Eclipse).
4. Asegúrate de que el archivo `examen.json` esté presente en la carpeta `src/main/resources/` (se creará si no existe).

## Uso

1. Ejecuta el archivo `Main.java`.
2. El programa te pedirá que introduzcas los datos de un héroe.
3. Después de introducir los datos, el programa guardará la información en el archivo `examen.json`.
4. Puedes seguir añadiendo héroes o salir escribiendo `*`.

## Ejemplo de Entrada

Introduzca un nombre del heroe: Torrente Introduzca el identidad del heroe: Jose Luis Torrente Introduzca el link del heroe: http://elbrazodelaley.com/characters/54/torrente-man Introduzca link de imagen del heroe: https://example.com/torrente.png Introduzca el size del heroe: 40000



## Estructura del Archivo JSON

El archivo `examen.json` tiene el siguiente formato:

```json
{
   "hero": "Heroes",
   "heroes": [
      {
         "hero": "Torrente",
         "name": "Jose Luis Torrente", 
         "link": "http://elbrazodelaley.com/characters/54/torrente-man",
         "img":  "https://dl.dropboxusercontent.com/u/19954023/marvel_force_chart_img/torrente.png",
         "size": 40000
      },
      ...
   ]
}
```


## Métodos Clave
- **`lecturaJSon()`**:Lee el archivo JSON existente y lo convierte en un objeto JSONObject. Si el archivo no existe, crea uno vacío.
- **`escrituraJSon(Heroes heroes, JSONObject archivo)`**: Agrega nuevos héroes al archivo JSON existente, sin sobrescribir los datos anteriores.
- **`introDatos()`**: Pide al usuario los datos de un héroe a través de la consola y los devuelve como un objeto Heroe.
### Explicación:

- **Estructura**: El archivo tiene una breve descripción del proyecto, instrucciones para instalar y usar el proyecto, y ejemplos de cómo interactuar con la aplicación.
- **Métodos**: Los métodos principales (`lecturaJSon`, `escrituraJSon`, `introDatos`) están descritos brevemente para que los desarrolladores puedan entender qué hacen.
- **Estructura del JSON**: Se explica cómo se organiza el archivo JSON que el programa lee y escribe.

