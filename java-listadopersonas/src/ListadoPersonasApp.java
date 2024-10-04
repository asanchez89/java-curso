import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        var salir = false;
        while(!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+ e.getMessage());
            }
            System.out.println();
        }
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.println("Proporciona el email: ");
                var email = consola.nextLine();
                var persona = new Persona(nombre, tel, email);
                personas.add(persona);
                System.out.println("La lista tiene: "+personas.size());
            }
            case 2 -> {
                System.out.println("Listado de Personas: ");
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: "+opcion);
        }
        return salir;
    }

    private static void mostrarMenu() {
        System.out.print("""
                **** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opcion: ");
    }
}