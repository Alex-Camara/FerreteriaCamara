/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
  
    TabPane tabPane =  new TabPane();
    
    //Agregar Venta
    Tab tabAgregar = new Tab();
    tabAgregar.setText("Registrar Venta");
    tabAgregar.setClosable(false);
    
        //agregamo el gridpane del escenario AgregarArticulo
    EscenarioAgregarVenta escenaAgregarVenta = new EscenarioAgregarVenta();
    GridPane gpAgregarVenta = escenaAgregarVenta.EscenaAgregarVenta(primaryStage);
    
    tabAgregar.setContent(gpAgregarVenta);
    
    //Mostrar registros
    Tab tabMostrarReg = new Tab();
    tabMostrarReg.setText("Mostrar Ventas");
    tabMostrarReg.setClosable(false);
    
        //agregamo el gridpane del escenario AgregarArticulo
    EscenarioMostrarVenta escenaMostrarVenta = new EscenarioMostrarVenta();
    GridPane gpMostrarVenta = escenaMostrarVenta.EscenaMostrarVenta(primaryStage);
    
    tabMostrarReg.setContent(gpMostrarVenta);

    /*
    Tab tabBuscar = new Tab();
    tabBuscar.setText("Buscar Registro por fecha");
    tabBuscar.setClosable(false);
    
        //agregamo el gridpane del escenario EditarArticulo
    //EscenarioBuscarArticulo escenaBuscarArt = new EscenarioBuscarArticulo();
    //GridPane gpBuscarArt = escenaBuscarArt.EscenaBuscarArticulo(primaryStage);
    
    //tabBuscar.setContent(gpBuscarArt);
*/
    
    //agregamos los tabs al tabPane
    //tabPane.getTabs().add(tabBuscar);
    tabPane.getTabs().add(tabAgregar);
    tabPane.getTabs().add(tabMostrarReg);
    
     //Scene escenaInventario = new Scene(tabPane, 300,250);
    
    Scene escenaInventario = new Scene(tabPane, 1000,500);
    return escenaInventario;
    
  } 
}
