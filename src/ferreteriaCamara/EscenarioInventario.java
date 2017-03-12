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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioInventario {
//radioButtonSeleccionado;
  
  /**---------------------------------------------------------------------------------------------
   * se le pasa el parametro de Escenario para que pueda reemplazar la escena anterior con esta.
   * @param primaryStage
   * @return 
   */
  public Scene EscenaInventario(Stage primaryStage){
    Label lPregunta1 = new Label("¿Que desea realizar?");
  
    RadioButton rbOpcion1 = new RadioButton("Agregar Articulo");
    RadioButton rbOpcion2 = new RadioButton("Eliminar Articulo");
    RadioButton rbOpcion3 = new RadioButton("Editar Articulo");
    RadioButton rbOpcion4 = new RadioButton("Buscar Articulo");
    RadioButton rbOpcion5 = new RadioButton("Ordenar Inventario");
    RadioButton rbOpcion6 = new RadioButton("Mostrar Inventario");
    RadioButton rbOpcion7 = new RadioButton("Salir");
    
    Button bAceptar = new Button("Aceptar");
  
    ToggleGroup radioGroup = new ToggleGroup();
    
    rbOpcion1.setToggleGroup(radioGroup);
    rbOpcion2.setToggleGroup(radioGroup);
    rbOpcion3.setToggleGroup(radioGroup);
    rbOpcion4.setToggleGroup(radioGroup);
    rbOpcion5.setToggleGroup(radioGroup);
    rbOpcion6.setToggleGroup(radioGroup);
    rbOpcion7.setToggleGroup(radioGroup);
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(lPregunta1, 0, 0);
    gridPane.add(rbOpcion1, 0, 1);
    gridPane.add(rbOpcion2, 0, 2);
    gridPane.add(rbOpcion3, 0, 3);
    gridPane.add(rbOpcion4, 0, 4);
    gridPane.add(rbOpcion5, 0, 5);
    gridPane.add(rbOpcion6, 0, 6);
    gridPane.add(rbOpcion7, 0, 7);
    gridPane.add(bAceptar, 0, 8);
  
    Scene escenaInventario = new Scene(gridPane);
    
    /**
     * Evento que sucede al presionar el boton Aceptar
     */
    bAceptar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        RadioButton radioButtonSeleccionado = (RadioButton)radioGroup.getSelectedToggle();
        String textoRadioButton = radioButtonSeleccionado.getText();
        //se invoca el metodo recurperDatos de la clase Archivo para cargar el inventario en 
        //el sistema
        Archivo.recuperarDatos();
        //opcion 1
        if (textoRadioButton.equals("Agregar Articulo")) {
          EscenarioAgregarArticulo escenaAgregarArt = new EscenarioAgregarArticulo();
          Scene escena = escenaAgregarArt.EscenaAgregarArticulo(primaryStage);
          primaryStage.setScene(escena);
          primaryStage.show();
        }
        if (textoRadioButton.equals("Buscar Articulo")) {
          EscenarioBuscarArticulo escenaBuscarArt = new EscenarioBuscarArticulo();
          Scene escena = escenaBuscarArt.EscenaBuscarArticulo(primaryStage);
          primaryStage.setScene(escena);
          primaryStage.show();
        }
        if (textoRadioButton.equals("Editar Articulo")) {
          EscenarioEditarArticulo escenaEditarArt = new EscenarioEditarArticulo();
          Scene escena = escenaEditarArt.EscenaEditarArticulo(primaryStage);
          primaryStage.setScene(escena);
          primaryStage.show();
        }
        if (textoRadioButton.equals("Eliminar Articulo")) {
          EscenarioEliminarArticulo escenaEliminarArt = new EscenarioEliminarArticulo();
          Scene escena = escenaEliminarArt.EscenaEliminarArticulo(primaryStage);
          primaryStage.setScene(escena);
          primaryStage.show();
        }
        //opcion 7
        if (textoRadioButton.equals("Mostrar Inventario")) {
          EscenarioMostrarInventario escenaMostrarInv = new EscenarioMostrarInventario();
          Scene escena = escenaMostrarInv.EscenaMostrarInventario(primaryStage);
          primaryStage.setScene(escena);
          primaryStage.show();
          Archivo.imprimirInventario();
        }
      }
      
    });
    
    return escenaInventario;
  } 
  
}
