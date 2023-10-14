import entidades.Persona;
import jdk.jshell.execution.Util;
import util.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        String document, name, lastname, phoneNumber, mail;

        int age;


        Scanner entrada = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>();

        while (true) {

            System.out.println(
                    "Seleccione una acción:\n1: Agregar persona\n2: Editar persona\n3: Mostrar personas\n4: eliminar Persona\n5:salir");
            int opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    name = Utilities.capturarString("Ingrese por favor el nombre");
                    document = Utilities.capturarString("Ingrese por favor el documento");
                    lastname = Utilities.capturarString("Ingrese por favor el apellido");
                    phoneNumber = Utilities.capturarString("Ingrese por favor el telefono");
                    mail = Utilities.capturarString("Ingrese por favor el mail");
                    age = Utilities.capturarInt("Ingrese por favor la edad");
                    Persona personaNueva = new Persona(document, name, lastname, phoneNumber, age, mail);
                    personaNueva.setAge(age);
                    personaNueva.setDocument(document);
                    personaNueva.setName(name);
                    personaNueva.setLastname(lastname);
                    personaNueva.setPhoneNumber(phoneNumber);
                    personaNueva.setMail(mail);
                    String validarEmail = Utilities.isValidEmail(personaNueva.getMail());
                    System.out.println(validarEmail);
                    String validatePhoneNumber = Utilities.isValidPhoneNumber(personaNueva.getPhoneNumber());
                    System.out.println(validatePhoneNumber);

                    boolean personaDuplicada = false;
                    for (Persona p : listaPersonas) {
                        if (p.getDocument().equals(document) &&
                                p.getName().equals(name) &&
                                p.getLastname().equals(lastname) &&
                                p.getPhoneNumber().equals(phoneNumber) &&
                                p.getMail().equals(mail)) {
                            personaDuplicada = true;
                            break;
                        }
                    }

                    if (personaDuplicada) {
                        System.out.println("Persona duplicada. No se ha agregado a la lista.");
                    } else {
                        listaPersonas.add(personaNueva);
                        System.out.println("Persona agregada con éxito.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el índice de la persona que desea editar: ");
                    int indice = entrada.nextInt();
                    entrada.nextLine(); // Consumir el salto de línea
                    listaPersonas = editarPersona(listaPersonas, indice);

                    break;
                case 3:
                    imprimirContactos(listaPersonas);
                    break;
                case 4:
                    System.out.println("Ingrese el índice de la persona que desea eliminar: ");
                    int indiceAEliminar = entrada.nextInt();
                    entrada.nextLine();

                    eliminarPersona(listaPersonas, indiceAEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    entrada.close(); // Cerrar el Scanner al salir del programa
                    System.exit(0);
                default:
                    System.out.println("No es una opción valida");
            }
        }


    }

    public static void imprimirContactos(List<Persona> listaPersonas) {
        System.out.println("Personas Ingresadas:");
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona persona = listaPersonas.get(i);
            System.out.println("Índice: " + i + ", Nombre: " + persona.getName() + ", Apellido: " + persona.getLastname() + ", documento: " + persona.getDocument());
        }
    }

    public static List<Persona> editarPersona(List<Persona> listaPersonas, int indice) {
        String document, name, lastname, phoneNumber, mail;
        int age;

        Scanner entrada = new Scanner(System.in); // Eliminar el try-with-resources

        name = Utilities.capturarString("Ingrese por favor el nombre");
        document = Utilities.capturarString("Ingrese por favor el documento");
        lastname = Utilities.capturarString("Ingrese por favor el apellido");
        phoneNumber = Utilities.capturarString("Ingrese por favor el telefono");
        mail = Utilities.capturarString("Ingrese por favor el mail");
        age = Utilities.capturarInt("Ingrese por favor la edad");
        Persona personaEditada = new Persona(document, name, lastname, phoneNumber, age, mail);
        personaEditada.setAge(age);
        personaEditada.setDocument(document);
        personaEditada.setName(name);
        personaEditada.setLastname(lastname);
        personaEditada.setPhoneNumber(phoneNumber);
        personaEditada.setMail(mail);
        listaPersonas.set(indice, personaEditada);
        personaEditada.setAge(age);
        personaEditada.setDocument(document);
        personaEditada.setName(name);
        personaEditada.setLastname(lastname);
        personaEditada.setPhoneNumber(phoneNumber);
        personaEditada.setMail(mail);
        String validarEmail = Utilities.isValidEmail(personaEditada.getMail());
        System.out.println(validarEmail);
        String validatePhoneNumber = Utilities.isValidPhoneNumber(personaEditada.getPhoneNumber());
        System.out.println(validatePhoneNumber);
        boolean personaDuplicada = true;
        while ( !personaDuplicada){
        for (Persona p : listaPersonas) {
            if (p.getDocument().equals(document) &&
                    p.getName().equals(name) &&
                    p.getLastname().equals(lastname) &&
                    p.getPhoneNumber().equals(phoneNumber) &&
                    p.getMail().equals(mail)) {
                System.out.println(" la persona esta duplicada");

            }
            personaDuplicada = false;
        }
        }

        if (personaDuplicada) {
            System.out.println("Persona duplicada. No se ha agregado a la lista.");
        } else {
            listaPersonas.add(personaEditada);
            System.out.println("Persona agregada con éxito.");
        }


        return listaPersonas;
    }


    public static void eliminarPersona(List<Persona> listaPersonas, int indice) {
        if (indice >= 0 && indice < listaPersonas.size()) {
            listaPersonas.remove(indice);
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

}
