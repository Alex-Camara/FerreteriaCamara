
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
public class EscenarioAgregarVenta{
  
  public GridPane EscenaAgregarVenta(Stage primaryStage){
    
    Archivo.recuperarDatos();
    Label lMensajeInicial = new Label("Introduce la clave del articulo: ");
    TextField tClave = new TextField();
    
    Button bBuscar = new Button("buscar");
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
    
    gridPane.add(lMensajeInicial, 0, 0);
    gridPane.add(tClave, 0, 1);
    gridPane.add(bBuscar, 1, 0);
    gridPane.add(bSalir, 8, 1);
    
    bBuscar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        int clave;
        Articulo auxiliar;
        
        if (tClave.getText().trim().isEmpty() == false) {
          
          clave = Integer.parseInt(tClave.getText().trim()); 
          auxiliar = Archivo.buscarPorClave(clave); 
          System.out.println(clave);
          System.out.println(auxiliar);
      
          if (auxiliar != null) {

            String nombre = auxiliar.getNombre();
            String descripcion = auxiliar.getDescripcion();
            float precioCompra = auxiliar.getPrecio_compra();
            String tipoUnidad = auxiliar.getTipo_unidad();
            int cantidad = auxiliar.getExistencia();
            
        
            Label lClave = new Label(String.valueOf(clave));
            Label lNombre = new Label(nombre);
            Label lDescripcion = new Label(descripcion);
            Label lPrecioCompra = new Label(String.valueOf(precioCompra));
            Label lTipoUnidad = new Label(tipoUnidad);
            Label lCantidad = new Label(String.valueOf(cantidad));
            Button bCantidad = new Button("vender");
            
            gridPane.add(lClave, 3, 0);
              gridPane.add(lNombre, 3, 1);
              gridPane.add(lDescripcion, 4, 0);
              gridPane.add(lPrecioCompra, 4, 1);
              gridPane.add(lTipoUnidad, 5, 0);
              gridPane.add(lCantidad, 5, 1);
              gridPane.add(bCantidad, 6, 1);
            
            bCantidad.setOnAction(new EventHandler(){
      
              @Override
              public void handle(Event event) {
                
                Label lCantidadAVender = new Label("Introduce la cantidad de articulos a vender: ");
                TextField tCantidadAVender = new TextField();
                Button bGuardar = new Button("Guardar");
                
                gridPane.add(lCantidadAVender, 6, 0);
                gridPane.add(tCantidadAVender, 6, 1);
                gridPane.add(bGuardar, 7, 1);
               
                
                bGuardar.setOnAction(new EventHandler(){
                  @Override
                  public void handle(Event event) {
                    int cantidadAVender = Integer.valueOf(tCantidadAVender.getText().trim());
                    if (cantidadAVender <= cantidad) {
                  int nuevaExistencia;
                  nuevaExistencia = cantidad - cantidadAVender; //obtenemos nueva existencia
          
                  auxiliar.setExistencia(nuevaExistencia);
                  Archivo.guardarRegistrados();
                  Venta.registrarVenta(auxiliar, cantidad);
          
                  //agregar ventana emergente---------------------------------------
                  Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                  alerta.setTitle("Confirmación");
                  alerta.setHeaderText(null);
                  alerta.setContentText("La venta ha sido guardada tio!");
        
                  alerta.show();
                  }
                  }
                  
                });
              }
              });
      }  
    } else {
          Alert alerta = new Alert(Alert.AlertType.INFORMATION);
          alerta.setTitle("Confirmación");
          alerta.setHeaderText(null);
          alerta.setContentText("No existe un articulo con dicha clave");
        
          alerta.show();
        }
      }
    });
    return gridPane;
  }
}
