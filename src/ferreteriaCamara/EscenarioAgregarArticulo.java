package ferreteriaCamara;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class EscenarioAgregarArticulo{
  
  /**---------------------------------------------------------------------------------------------
   * regresa un tipo Scene para reemplazar en el escenario a la escena anterior
   * @return 
   */
  public Scene EscenaAgregarArticulo(Stage primaryStage){    
    Label lOpcion1 = new Label("Introduce los siguientes datos:");
    
    Label lClave = new Label("Clave: ");
    TextField tClave = new TextField();
    
    Label lNombre = new Label("Nombre del articulo: ");
    TextField tNombre = new TextField();
    
    Label lDescripcion = new Label("Descripcion: ");
    TextField tDescripcion = new TextField();
    
    Label lPrecioCompra = new Label("Precio de compra: ");
    TextField tPrecioCompra = new TextField();
    
    Label lTipoUnidad = new Label("Tipo de unidad: ");
    TextField tTipoUnidad = new TextField();
    
    Label lCantidad = new Label("Cantidad: ");
    TextField tCantidad = new TextField();    
    
    Button bGuardar = new Button("Guardar");
    Button bRegresar = new Button("Regresar");
    
    GridPane gridPane = new GridPane();
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    //f c
    gridPane.add(lOpcion1, 0, 0);
    gridPane.add(lClave, 0, 1);
    gridPane.add(tClave, 1, 1);
    gridPane.add(lNombre, 0, 2);
    gridPane.add(tNombre, 1, 2);
    gridPane.add(lDescripcion, 0, 3);
    gridPane.add(tDescripcion, 1, 3);
    gridPane.add(lPrecioCompra, 0, 4);
    gridPane.add(tPrecioCompra, 1, 4);
    gridPane.add(lTipoUnidad, 0, 5);
    gridPane.add(tTipoUnidad, 1, 5);
    gridPane.add(lCantidad, 0, 6);
    gridPane.add(tCantidad, 1, 6);
    gridPane.add(bGuardar, 0, 7);
    gridPane.add(bRegresar, 1, 7);
    
    Archivo ar = new Archivo();
   
    bGuardar.setOnAction(new EventHandler(){ 
      @Override
      public void handle(Event event) {
        //se crea un objeto del tipo archivo
        Archivo ar = new Archivo();
        //declaramos los objetos
        int clave; 
        String nombre;
        String descripcion;
        float precioCompra;
        String tipoUnidad;
        int cantidad;
        //se le asigna a las variables los valores ingresados por el usuario
        clave = Integer.parseInt(tClave.getText().trim());
        nombre = tNombre.getText();
        descripcion = tDescripcion.getText();
        precioCompra = Float.parseFloat(tPrecioCompra.getText().trim());
        tipoUnidad = tTipoUnidad.getText();
        cantidad = Integer.parseInt(tCantidad.getText().trim());
    
        //se manda a llamar el metodo Asignar datos de la clase Archivo
        ar.AsignarDatos(clave, nombre, descripcion, precioCompra, tipoUnidad, cantidad);
        //agregar ventana emergente---------------------------------------
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Confirmación");
        alerta.setTitle(null);
        alerta.setContentText("Los datos han sido guardados tio!");
        
        alerta.show();
        //fin ventana emergente--------------------------------------------        
        Archivo.imprimirInventario();
        
        EscenarioAgregarArticulo escenaAgregarArt;
        Scene escena = EscenaAgregarArticulo(primaryStage);
        primaryStage.setScene(escena);
        primaryStage.show();
      }
      
    });
    
    bRegresar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        EscenarioInventario escenaInv = new EscenarioInventario();
        Scene escena = escenaInv.EscenaInventario(primaryStage);
        primaryStage.setScene(escena);
        primaryStage.show();
      }
      
    });
    
    Scene escenaAgregarArticulo = new Scene(gridPane);
    
    return escenaAgregarArticulo;
  }
  
}
