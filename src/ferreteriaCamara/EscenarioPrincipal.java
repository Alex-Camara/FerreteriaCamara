/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */

public class EscenarioPrincipal{
  
  /**--------------------------------------------------------------------------------------------
   * Metodo donde se elige entre las opciones de inventario y ventas, se le pasa el parametro
   * de Escenario para que pueda reemplazar la escena anterior con una de su eleccion.
   * @param primaryStage
   * @return 
   */
  public Scene EscenaPrincipal(Stage primaryStage) {
    
    /**
     * --------------------------OPCION 1 INVENTARIO--------------------------------------------
     */
    Button bInventario = new Button("Inventario");
    bInventario.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        //establecer escena 3 como nueva escena
        EscenarioInventario escenaInv = new EscenarioInventario();
        //se le pasa como argumento primaryStage, que es el escenario principal para que 
        //la ventana cambie a la siguiente escena
        Scene escena = (escenaInv.EscenaInventario(primaryStage));
        primaryStage.setScene(escena);
        primaryStage.show();
        
      }
      
    });
  /**
   * -------------------------OPCION 2 VENTAS-------------------------------------------------
   */
    Button bVentas = new Button("Ventas");
    
    bVentas.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        //establecer escena 3 como nueva escena
        EscenarioVentas escenaVen = new EscenarioVentas();
        Scene escena = (escenaVen.EscenaVentas(primaryStage));
        primaryStage.setScene(escena);
        primaryStage.show();
        
      }
      
    });
    
    /** proximamente.....
     * -----------------------------OPCION 3 AGREGAR USUARIO-----------------------------------
     */
    
    /**
     * proximamente......
     * -----------------------------OPCION 4 MODIFICAR USUARIO --------------------------------
     */
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(bInventario, 0, 0);
    gridPane.add(bVentas, 1, 0);
    
    Scene escenarioPrincipal = new Scene(gridPane);
    return escenarioPrincipal;
  }
}
