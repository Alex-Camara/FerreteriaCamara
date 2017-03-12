
package ferreteriaCamara;

import java.util.List;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioMostrarInventario {

  public Scene EscenaMostrarInventario(Stage primaryStage) {
    
    List inventario;
    inventario = Archivo.recuperarDatos();
    
    ListView<Articulo> list = new ListView<>();
    ObservableList<Articulo> items =FXCollections.observableArrayList(
        inventario
    );
    list.setItems(items);
    
    Button bRegresar = new Button("Regresar");
    Button bAgregar = new Button("Agregar");
    Button bEditar = new Button("Editar");
    Button bEliminar = new Button("Eliminar");
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.add(list, 0, 0);
    gridPane.add(bAgregar, 1, 0);
    gridPane.add(bRegresar, 1, 1);
    gridPane.add(bEditar, 1, 2);
    gridPane.add(bEliminar, 1, 3);
    
    bRegresar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        EscenarioInventario escenaInv = new EscenarioInventario();
        Scene escena = escenaInv.EscenaInventario(primaryStage);
        primaryStage.setScene(escena);
        primaryStage.show();
      }
      
    });
    
    bAgregar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
          
          EscenarioAgregarArticulo escenarioAgregar = new EscenarioAgregarArticulo();
          //se manda a llamar a la escena de EscenaAgregarArticulo del EscenarioAgregarArticulo
          Scene escena = escenarioAgregar.EscenaAgregarArticulo(primaryStage);
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
          
          EscenarioEditarArticulo escenarioEditar = new EscenarioEditarArticulo();
          //se manda a llamar a la escena de EscenaDatosPresentes del Escenario Editar Datos
          Scene escena = escenarioEditar.EscenaDatosPresentes(primaryStage, auxiliar, clave);
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
          primaryStage.setScene(EscenaMostrarInventario(primaryStage));
        }
      }
      
    });
    
    Scene escenaMostrarInventario = new Scene(gridPane);
   
    return escenaMostrarInventario;
  }
  
}
