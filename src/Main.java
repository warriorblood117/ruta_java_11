import entidades.Persona;
import jdk.jshell.execution.Util;
import util.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String document, name, lastname, phoneNumber, mail;

        int age;


        Scanner entrada = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>();

        while (true) {

            System.out.println(
                    "Seleccione una acción:\n1: Agregar persona\n2: Editar persona\n3: Mostrar personas\n4: eliminar Persona\n5:salir");
            int opcion = entrada.nextInt();
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
                    entrada.nextLine(); // Limpia el salto de línea

                    if (indice >= 0 && indice < listaPersonas.size()) {
                        listaPersonas = editarPersona(listaPersonas, indice);
                    } else {
                        System.out.println("Índice no válido.");
                    }
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
            System.out.println(persona);
        }
    }

    public static List<Persona> editarPersona(List<Persona> listaPersonas, int indice) {
        String document, name, lastname, phoneNumber, mail;

        int age;

        try (Scanner entrada = new Scanner(System.in)) {
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

            Persona personaEditada = new Persona(document, name, lastname, phoneNumber, age, mail);

            listaPersonas.set(indice, personaEditada);
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
