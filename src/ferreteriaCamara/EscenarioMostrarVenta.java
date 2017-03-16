/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioMostrarVenta{
    
    public GridPane EscenaMostrarVenta(Stage primaryStage){
    List registroVenta = Venta.recuperarRegistroVenta();
        
    ListView<ArticuloVendido> list = new ListView<>();
    ObservableList<ArticuloVendido> items =FXCollections.observableArrayList(
        registroVenta
    );
    list.setItems(items);
    
    Button bSalir = new Button("Salir");
    
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
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(list, 0, 0);
    gridPane.add(bSalir, 0, 1);
    
    return gridPane;
  }
  
}
