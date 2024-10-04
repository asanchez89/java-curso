package org.curso.presentacion;

import org.curso.datos.EstudianteDAO;
import org.curso.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        var estudianteDao = new EstudianteDAO();

        while(!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un erro al ejecutar operacion:"+e.getMessage());
            }
        }
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDao) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 ->{
                System.out.println("Listado de Estudiantes...");
                var estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Introduce el ID del estudiante a buscar:");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDao.buscarEstudiantePorId(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("Estudiante no encontrado: "+estudiante);
            }
            case 3 -> {
                System.out.println("Agregar Estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var tel = consola.nextLine();
                System.out.print("Correo: ");
                var mail = consola.nextLine();
                var estudiante = new Estudiante(nombre, apellido, tel, mail);
                var agregado = estudianteDao.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante no agregado: "+estudiante);

            }
            case 4 -> {
                System.out.println("Modificar Estudiante: ");
                System.out.print("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var tel = consola.nextLine();
                System.out.print("Correo: ");
                var mail = consola.nextLine();
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, tel, mail);
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Se modificó el estudiante: "+estudiante);
                else
                    System.out.println("No se modificó el estudiante: "+estudiante);
            }
            case 5 -> {
                System.out.println("Eliminar Estudiante: ");
                System.out.print("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: "+estudiante);
                else
                    System.out.println("Estudiante no eliminado: "+estudiante);
            }
            case 6 -> {
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion no reconocida");
        }
        return salir;
    }

    private static void mostrarMenu() {
        System.out.print("""
                *** Sistema de Estudiantes ***
                1. Listar Estudiante
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elige una opcion:
                """);
    }
}