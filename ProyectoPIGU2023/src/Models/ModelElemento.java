/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DatosDTO.ElementoQuimicoDTO;
import Views.principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModelElemento {
    List<ElementoQuimicoDTO> elementos = new ArrayList<ElementoQuimicoDTO>();

    public ModelElemento() {
        llenarElementos();
    }
    
    
    
    public  void llenarElementos(){
        elementos.add(new ElementoQuimicoDTO(1,6.94f,3,"Li", "LITIO", "Amarillo")); //0
        elementos.add(new ElementoQuimicoDTO(2,26.96f,13,"Al", "ALUMINIO","Amarillo")); //1
        elementos.add(new ElementoQuimicoDTO(3,47.87f,23,"Ti", "VANADIO", "Amarillo"));   //2
        elementos.add(new ElementoQuimicoDTO(4,74.92f,33,"As", "ARSENICO","CAFE"));  //3
        elementos.add(new ElementoQuimicoDTO(5,98f,43,"Tc", "TECNECIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(6,126.90f,53,"I" ,"YODO","VERDE"));  //3
        elementos.add(new ElementoQuimicoDTO(7,151.96f,63, "Eu", "EUROPIO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(8,180.95f,73,"Ta", "TANTALIO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(9,208.98f,83,"Tl", "BISMUTO","amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(10,237f,93,"Np", "NEPTUNIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(11,262f,103,"Lr", "LAURENCIO","Amarillo"));  //3
        elementos.add(new ElementoQuimicoDTO(12,0f,113, "Uut","UNUNBLUM","Amarillo"));  //3
    }
    
    public void Aceptar(int recNo,int id, Float masa_atómica, int número_atómico, String símbolo_químico, String nombre, String color){
        if (recNo == -1){
            elementos.add(new ElementoQuimicoDTO(id,masa_atómica,número_atómico, símbolo_químico, nombre,color ));
        }else{
            elementos.get(recNo).setId(id);
            elementos.get(recNo).setNúmero_atómico(número_atómico);
            elementos.get(recNo).setNombre(nombre);
            elementos.get(recNo).setMasa_atómica(masa_atómica);
            elementos.get(recNo).setSímbolo_químico(símbolo_químico);
            elementos.get(recNo).setColor(color);
        }
        
    }
    public int lastItemList(){
        return  elementos.get(elementos.size()-1).getId();
    }

    public void setDatos(principal db) {
        DefaultTableModel modeloTabla = (DefaultTableModel) db.tblElementos.getModel();
        limpiarTable(modeloTabla);
        int columnas = modeloTabla.getColumnCount();
         Object[] datos = new Object[columnas];
        for (int i = 0; i < elementos.size(); i++) {
            datos[0] = i;
            datos[1] = elementos.get(i).getId();
            datos[2] = elementos.get(i).getNúmero_atómico();
            datos[3] = elementos.get(i).getNombre();
            datos[4] = elementos.get(i).getMasa_atómica();
            datos[5] = elementos.get(i).getSímbolo_químico();
            datos[6] = elementos.get(i).getColor();
            modeloTabla.addRow(datos);
        }
    }
    
    public void limpiarTable(DefaultTableModel modeloTabla) {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i = i - 1;
        }
    }
    public boolean ExportarInfo() {
        String ruta = System.getProperty("user.home");
        String url = ruta+"\\OneDrive\\Escritorio\\tblElementosQumicosMatricula.txt";
        System.out.println("Inico guardar archivo");
        File archivo = new File(url);
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            for (ElementoQuimicoDTO quimico : elementos) {
                escribir.print("ID: "+quimico.getId()+ "  ");
                escribir.print("Num. Atomico: "+quimico.getNúmero_atómico()+ "  ");
                escribir.print("Masa Atomica: "+quimico.getMasa_atómica()+ "  ");
                escribir.print("Nombre: "+quimico.getNombre() + "  ");
                escribir.print("Simbolo: "+quimico.getSímbolo_químico()+ "  ");
                escribir.print("Color: "+quimico.getColor()+ "\n\n");
            }
            escribir.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Error en crear archivo "+ex.getMessage());
            return false;
        }
    }
    
    public void Actualizar(int filaActual, principal db){
        if (filaActual != -1){
            db.txt_recNo.setText(""+db.tblElementos.getValueAt(filaActual, 0));
            db.txt_id.setText("" + db.tblElementos.getValueAt(filaActual, 1));
            db.txt_numAtom.setText("" + db.tblElementos.getValueAt(filaActual, 2));
            db.txt_Nombre.setText("" + db.tblElementos.getValueAt(filaActual, 3));
            db.txt_masa.setText("" + db.tblElementos.getValueAt(filaActual, 4));
            db.txt_simbolo.setText("" + db.tblElementos.getValueAt(filaActual, 5));
            db.txt_color.setText("" + db.tblElementos.getValueAt(filaActual, 6));

        }else{
            System.out.println("Es necesario Seleccionar un registro");
        }
    }
    
    public void removeRow(int filaActual){
        if (filaActual != -1){
           System.out.println(filaActual);
            JOptionPane.showMessageDialog(null, "Se elimino el registro: "+filaActual);
           elementos.remove(filaActual);
        }
    }
    
    public void LimpiarCampos(principal db){
        int contador = Integer.parseInt(db.ilbd.getText());
        db.txt_Nombre.setText("");
        db.txt_masa.setText("");
        db.txt_numAtom.setText("");
        db.txt_simbolo.setText("");
        db.txt_id.setText(""+(contador+1));
        db.txt_Nombre.requestFocus(true);
    }
    
}
