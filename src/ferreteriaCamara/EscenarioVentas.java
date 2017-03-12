/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
public class EscenarioVentas{
  
  public Scene EscenaVentas(Stage primaryStage) {
  
    Label lPregunta1 = new Label("¿Que desea realizar?");
  
    RadioButton rbOpcion1 = new RadioButton("Registrar Venta");
    RadioButton rbOpcion2 = new RadioButton("Mostrar Registro de Ventas");
    RadioButton rbOpcion3 = new RadioButton("Buscar Registro por fecha");
    RadioButton rbOpcion6 = new RadioButton("Salir");
    
    Button bAceptar = new Button("Aceptar");
  
    ToggleGroup radioGroup = new ToggleGroup();
    
    rbOpcion1.setToggleGroup(radioGroup);
    rbOpcion2.setToggleGroup(radioGroup);
    rbOpcion3.setToggleGroup(radioGroup);
    rbOpcion6.setToggleGroup(radioGroup);
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(lPregunta1, 0, 0);
    gridPane.add(rbOpcion1, 0, 1);
    gridPane.add(rbOpcion2, 0, 2);
    gridPane.add(rbOpcion3, 0, 3);
    gridPane.add(rbOpcion6, 0, 6);
    gridPane.add(bAceptar, 0, 7);
  
    Scene escenaVentas = new Scene(gridPane);
    
    return escenaVentas;
  }
}
