package com.project.bookcatalog.console;
import java.util.Scanner;

public class BookCatalogConsoleApp {

    private static final String API_URL = "https://gutendex.com/books/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestTemplate restTemplate = new RestTemplate();

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Buscar un libro por ID");
            System.out.println("3. Agregar un libro");
            System.out.println("4. Eliminar un libro");
            System.out.println("5. Buscar libros por consulta");
            System.out.println("6. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (option) {
                case 1:
                    // Ver todos los libros
                    String allBooks = restTemplate.getForObject(API_URL, String.class);
                    System.out.println(allBooks);
                    break;
                case 2:
                    // Buscar un libro por ID
                    System.out.print("Ingrese el ID del libro: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();  // Consumir la nueva línea
                    String book = restTemplate.getForObject(API_URL + "/" + id, String.class);
                    System.out.println(book);
                    break;
                case 3:
                    // Agregar un libro
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String author = scanner.nextLine();
                    System.out.print("Ingrese el idioma del libro: ");
                    String language = scanner.nextLine();
                    System.out.print("Ingrese la URL de descarga del libro: ");
                    String downloadUrl = scanner.nextLine();
                    Book newBook = new Book(null, title, author, language, downloadUrl);
                    restTemplate.postForLocation(API_URL, newBook);
                    System.out.println("Libro agregado exitosamente.");
                    break;
                case 4:
                    // Eliminar un libro
                    System.out.print("Ingrese el ID del libro a eliminar: ");
                    Long deleteId = scanner.nextLong();
                    scanner.nextLine();  // Consumir la nueva línea
                    restTemplate.delete(API_URL + "/" + deleteId);
                    System.out.println("Libro eliminado exitosamente.");
                    break;
                case 5:
                    // Buscar libros por consulta
                    System.out.print("Ingrese la consulta de búsqueda: ");
                    String query = scanner.nextLine();
                    String searchResults = restTemplate.getForObject(API_URL + "/search?query=" + query, String.class);
                    System.out.println(searchResults);
                    break;
                case 6:
                    // Salir
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
