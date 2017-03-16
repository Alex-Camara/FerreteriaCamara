/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioBuscarArticulo{
  
  public GridPane EscenaBuscarArticulo(Stage primaryStage){
    
    Label lInstruccionClave = new Label("Buscar por clave");
    TextField tClave = new TextField();
    Label lInstruccionNombre = new Label("Buscar por nombre");
    TextField tNombre = new TextField();
        
    Button bBuscar = new Button("Buscar");
    Button bSalir = new Button("Salir");
    
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(lInstruccionClave, 0, 0);
    gridPane.add(tClave, 0, 1);
    gridPane.add(lInstruccionNombre, 1, 0);
    gridPane.add(tNombre, 1, 1);
    
    gridPane.add(bBuscar, 0, 3);
    gridPane.add(bSalir, 1, 3);
    
   // Scene escenaBuscarArticulo = new Scene(gridPane);
    
    bBuscar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        
        Articulo auxiliar;
        
        String nombre = tNombre.getText().trim();
 
        int clave;
        String descripcion;
        float precioCompra;
        String tipoUnidad;
        int cantidad;
        
        //si el campo de clave tiene algo y el campo de nombre esta vacio
        if (tClave.getText().trim().isEmpty() == false && nombre.isEmpty() == true ) {
            clave = Integer.parseInt(tClave.getText().trim()); 
            auxiliar = Archivo.buscarPorClave(clave); 
            
            if (auxiliar != null) {
              
              nombre = auxiliar.getNombre();
              descripcion = auxiliar.getDescripcion();
              precioCompra = auxiliar.getPrecio_compra();
              tipoUnidad = auxiliar.getTipo_unidad();
              cantidad = auxiliar.getExistencia();
              
              Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
              
              confirmacion.setTitle("Confirmación");
              confirmacion.setHeaderText(null);
              confirmacion.setContentText("Clave: " + clave
                                          + "\nNombre: " + nombre 
                                          + "\nDescripción: " +descripcion
                                          + "\nPrecio de compra: " + precioCompra
                                          + "\ntipoUnidad: " + tipoUnidad
                                          + "\ncantidad: " + cantidad);
              
              confirmacion.showAndWait();
          }
            else {
              Alert sinCoincidencias = new Alert(Alert.AlertType.WARNING);
              sinCoincidencias.setHeaderText(null);
              sinCoincidencias.setContentText("No se encontro ningun articulo con dicha clave");
              sinCoincidencias.show();
            }
        }
        if (tClave.getText().trim().isEmpty() == true && nombre.isEmpty() == false) {
          auxiliar = Archivo.buscarPorNombre(nombre);
          if (auxiliar != null) {
              clave = auxiliar.getClave();
              descripcion = auxiliar.getDescripcion();
              precioCompra = auxiliar.getPrecio_compra();
              tipoUnidad = auxiliar.getTipo_unidad();
              cantidad = auxiliar.getExistencia();
              
              Alert confirmacion = new Alert(Alert.AlertType.INFORMATION);
              
              confirmacion.setTitle("Confirmación");
              confirmacion.setHeaderText(null);
              confirmacion.setContentText("Clave: " + clave
                                          + "\nNombre: " + nombre 
                                          + "\nDescripción: " +descripcion
                                          + "\nPrecio de compra: " + precioCompra
                                          + "\ntipoUnidad: " + tipoUnidad
                                          + "\ncantidad: " + cantidad);
              
              confirmacion.showAndWait();
          }
            else {
              Alert sinCoincidencias = new Alert(Alert.AlertType.WARNING);
              sinCoincidencias.setHeaderText(null);
              sinCoincidencias.setContentText("No se encontro ningun articulo con dicho nombre");
              sinCoincidencias.show();
            }
        } 
        if (tClave.getText().trim().isEmpty() == true && nombre.isEmpty() == true) {
          //mostrar alerta
          Alert alerta = new Alert(Alert.AlertType.WARNING);
          alerta.setHeaderText(null);
          alerta.setContentText("debes ingresar el nombre o la clave del articulo a buscar");
          alerta.show();
        }
        if (tClave.getText().trim().isEmpty() == false && nombre.isEmpty() == false) {
          //mostrar alerta
          Alert alerta = new Alert(Alert.AlertType.WARNING);
          alerta.setHeaderText(null);
          alerta.setContentText("solo debes llenar un campo");
          alerta.show();
        }
      }
      
    });
    
    bSalir.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
          Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(null);
        alerta.setContentText("¿seguro que desea salir?");
        
        Optional<ButtonType> result = alerta.showAndWait();
        
        if (result.get() == ButtonType.OK) {
          primaryStage.close();
        } else {
          alerta.close();
        }
      }
      
    });
    
    return gridPane;
  }
}
