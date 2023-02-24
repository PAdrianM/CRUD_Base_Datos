package controlador;

import conexionBd.Conexion;
import dao.PersonaDao;
import modelo.Persona;

import java.util.List;
import java.util.Scanner;

public class PersonaControlador {
    public static void main(String[] args) {

        Conexion conectado = new Conexion();
        Scanner s = new Scanner (System.in);

        Persona persona = new Persona(0);
        Conexion conexion = new Conexion();
        PersonaDao personaEditor = new PersonaDao(conexion);

        System.out.println("============================================================");
        System.out.println("MENU ADMINISTRADOR");
        System.out.println("Ingrese la Letra de las Opciones en Mayuscula" +
                "\n A-Para insertar un registro de Persona" +
                "\n B-Para mostrar los registros de la tabla Persona" +
                "\n C-Para buscar los datos de una persona");
        String opcion = (s.next());

        switch (opcion){
            case "A": //Insertar
                System.out.println("Ingrese el Nombre de la Persona: ");
                persona.setNombre(s.next());


                System.out.println("Ingrese el Apellido de la Persona: ");
                persona.setApellido(s.next());

                System.out.println("Segun la siguienta lista ingrese el 'NUMERO' del municipio al que pertenece");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Numero Municipio" + "              " + "Nombre");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Ingrese el Numero segun el Municipio de la: ");
                persona.setMunicipio_idMunicipio(s.nextInt());

                System.out.println("Ingrese el CUI de la Persona: ");
                persona.setCUI(s.next());

                boolean respuestaUsuario = personaEditor.Insert(persona);

                if (respuestaUsuario){
                    System.out.println("Registro guardado exitosamente");
                }else {
                    System.out.println("Error: Error al momento de guardar el registro");
                }

                break;

            case "B":
                List<Persona> tablaPersona = personaEditor.selectAll();
                for (Persona persona1: tablaPersona){
                System.out.println("==========================");
                System.out.println("                          ");
                System.out.println("idPersona " +persona1.getIdPersona());
                System.out.println("Nombre " +persona1.getNombre());
                System.out.println("Apellido " +persona1.getApellido());
                System.out.println("Municipio_idMunicipio " +persona1.getMunicipio_idMunicipio());
                System.out.println("CUI " +persona1.getCUI());
                System.out.println("==========================");

            }
                break;

            default: System.out.println("Escriba la letra Correctamente");


        }

    }
}
