/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopigu2023;

import Views.principal;

public class ProyectoPIGU2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Braulio63913());
        imprimirElementos();
    }
    
    public static String Braulio63913(){
        String nombre = "Braulio Rafael ";
        String apellido = "Huicab May";
        String Carrera = "Ingenieria en Sistemas Computacionales";
        return "Soy el Alumno "+nombre +apellido +" y estudio la carrera: "+Carrera ;
    }
    
    public static void imprimirElementos(){
        principal mn = new principal();
//        mn.txt_elemntos.setText("LITIO\n"
//                + "ALUMINIO\n"
//                + "VANADIO\n"
//                + "ARSENICO\n"
//                + "TECNECIO\n"
//                + "YODO\n"
//                + "EUROPIO\n"
//                + "TATALIO\n"
//                + "BISMUTO\n"
//                + "NEPTUNIO\n"
//                + "LAURENCIO\n"
//                + "UNUNBLUM");
        mn.setVisible(true);
    }
    
}
