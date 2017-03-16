
package ferreteriaCamara;

import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
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
public class EscenarioMostrarInventario {

  public GridPane EscenaMostrarInventario(Stage primaryStage) {
    
    List inventario;
    inventario = Archivo.recuperarDatos();
    
    ListView<Articulo> list = new ListView<>();
    ObservableList<Articulo> items =FXCollections.observableArrayList(
        inventario
    );
    list.setItems(items);
    
    Button bAgregar = new Button("Agregar");
    Button bEditar = new Button("Editar");
    Button bEliminar = new Button("Eliminar");
    Button bSalir = new Button("Salir");
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(list, 0, 0);
    gridPane.add(bAgregar, 1, 1);
    gridPane.add(bSalir, 2, 1);
    gridPane.add(bEditar, 3, 1);
    gridPane.add(bEliminar, 4, 1);
    
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
    
    bAgregar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
          
          EscenarioAgregarArticulo escenarioAgregar = new EscenarioAgregarArticulo();
          //se manda a llamar a la escena de EscenaAgregarArticulo del EscenarioAgregarArticulo
          GridPane gpAgregarArticulo = escenarioAgregar.EscenaAgregarArticulo2(primaryStage);
          Scene escena = new Scene(gpAgregarArticulo);

          primaryStage.setScene(escena);
          primaryStage.show();
      }
      
    });
    
    bEditar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        int clave;
        ObservableList<Articulo> seleccionado = list.getSelectionModel().getSelectedItems();
        
        if (seleccionado.isEmpty() == false) {
          Articulo auxiliar = seleccionado.get(0);
          clave = auxiliar.getClave();
          System.out.println(clave);
          
          EscenarioEditarArticulo escenarioEditarArt = new EscenarioEditarArticulo();
          //se manda a llamar a la escena de EscenaDatosPresentes del Escenario Editar Datos
          GridPane gpEditarArticulo = escenarioEditarArt.EscenaDatosPresentes(primaryStage, auxiliar, clave);
          Scene escena = new Scene(gpEditarArticulo);

          primaryStage.setScene(escena);
          primaryStage.show();
        }
      }
      
    });
    
    bEliminar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        int clave;
        ObservableList<Articulo> seleccionado = list.getSelectionModel().getSelectedItems();
        
        if (seleccionado.isEmpty() == false) {
          Articulo auxiliar = seleccionado.get(0);
          clave = auxiliar.getClave();
          System.out.println(clave);
          
          EscenarioEliminarArticulo escenarioEliminar = new EscenarioEliminarArticulo();
          //se manda a llamar a la escena de EscenaDatosPresentes del Escenario Editar Datos
          escenarioEliminar.EscenaEliminarArticulo(clave);
        }
      }
      
    });
    
    return gridPane;
  }
  
}
