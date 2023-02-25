package controlador;

import conexionBd.Conexion;
import dao.EditorTablaMunicipio;
import dao.EditorTablaPersona;
import modelo.Municipios;
import modelo.Persona;

import java.util.List;
import java.util.Scanner;

public class PersonaControlador {
    public static void main(String[] args) {

        String opcion;

        boolean continuar = true;

        Conexion conectado = new Conexion();
        Scanner s = new Scanner(System.in);

        Persona persona = new Persona(0);
        Conexion conexion = new Conexion();
        EditorTablaPersona personaEditor = new EditorTablaPersona(conexion);
        EditorTablaMunicipio municipioEditor = new EditorTablaMunicipio(conexion);

        do {
            System.out.println("============================================================");
            System.out.println("MENU ADMINISTRADOR");
            System.out.println("Ingrese la Letra de las Opciones en Mayuscula" +
                    "\n A-Para insertar un registro de Persona" +
                    "\n B-Para mostrar los registros de la tabla Persona" +
                    "\n C-Para buscar los datos de una persona" +
                    "\n D-Para Salir del Programa");
            opcion = (s.next());
            if (opcion.equals("D")) {
                continuar = false;
            } else {
                switch (opcion) {
                    case "A": //Insertar datos a la Tabla Persona
                        System.out.println("Ingrese el Nombre de la Persona: ");
                        persona.setNombre(s.next());

                        System.out.println("Ingrese el Apellido de la Persona: ");
                        persona.setApellido(s.next());

                        System.out.println("Acontinuacion se presenta la tabla \"Municipio\"");
                        List<Municipios> tablaMunicipio = municipioEditor.selectAllMunicipio();
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.printf("%10s %18s %35s  ", "Numero Municipio", "Nombre", "Departamento_idDepartamento");
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        for (Municipios municipios : tablaMunicipio) {
                            System.out.format("%10s %25s %20s",
                                    municipios.getIdMunicipio(), municipios.getNombre(), municipios.getDepartamento_idDepartamento());
                            System.out.println();
                        }
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        int tamaño;
                        do {
                            System.out.println("Ingrese el Numero segun el Municipio \"al que pertenece\": ");
                            persona.setMunicipio_idMunicipio(s.nextInt());
                            tamaño = persona.getMunicipio_idMunicipio();
                            if (tamaño > 9) {
                                System.out.println("Solo puede ingresar el numero de Municipio que hay en la tabla");
                            } else if (tamaño <= 9) {
                                System.out.println("Municipio Valido");
                                int size; //Validar Tamaño de CUI
                                System.out.println("Ingrese el CUI de la Persona: ");
                                persona.setCUI(s.next());
                                size = persona.getCUI().length();
                                if (size == 13) {
                                    System.out.println("Formato correcto");
                                } else {
                                    System.out.println("Formato Incorrecto: Debe ingresar los 13 digitos completos \"No mas, ni Menos\", de su CUI!!!!");
                                }

                                boolean respuestaUsuario = personaEditor.Insert(persona);

                                if (size < 13) {
                                    System.out.println("Vuelva a intentarlo");
                                    break;
                                } else if (respuestaUsuario) {
                                    System.out.println("Registro guardado exitosamente");
                                } else {
                                    System.out.println("Error: Error al momento de guardar el registro");
                                }
                                break;
                            }
                        } while (continuar);
                        break;

                    case "B"://Ver registroS Tabla Persona
                        List<Persona> tablaPersona = personaEditor.selectAll();
                        System.out.println("Ingrese el CUI de la persona que desea Buscar: ");
                        persona.setCUI(s.next());
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.printf("%10s %10s %20s %28s %20s", "idPersona", "Nombre", "Apellido", "Municipio_idMunicipio", "CUI");
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        for (Persona persona1 : tablaPersona) {
                            System.out.format("%6s %15s %18s %25s %25s",
                                    persona1.getIdPersona(), persona1.getNombre(), persona1.getApellido(), persona1.getMunicipio_idMunicipio(), persona1.getCUI());
                            System.out.println();
                        }
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        break;

                    case "C"://Mandar a Traer los datos de una unica Persona
                        List<Persona> buscarPersona = personaEditor.selectAll();
                        System.out.println("Ingrese el CUI perteneciente a su DPI ");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.printf("%10s %10s %20s %28s %20s", "idPersona", "Nombre", "Apellido", "Municipio_idMunicipio", "CUI");
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        for (Persona persona1 : buscarPersona) {
                            System.out.format("%6s %15s %18s %25s %25s",
                                    persona1.getIdPersona(), persona1.getNombre(), persona1.getApellido(), persona1.getMunicipio_idMunicipio(), persona1.getCUI());
                            System.out.println();
                        }
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        break;


                    default:
                        System.out.println("Escriba la letra Correctamente");
                }
            }
        } while (continuar);
        System.out.println("Saliendo de Administrador de Base 1.0");
    }
}

