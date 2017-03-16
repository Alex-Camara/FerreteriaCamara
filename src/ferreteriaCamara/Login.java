/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteriaCamara;

import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Miguel Alejandro Cámara Árciga
 */
public class Login extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    Label texto = new Label("Ferreteria Camara");  
    
    Label lUsuario = new Label("Usuario: ");
    
    Label lPassword = new Label("Contraseña: ");
    
    TextField tUsuario = new TextField();
    tUsuario.setText("");
    
    PasswordField tPassword = new PasswordField();
    tPassword.setText("");
    
    Button bIngresar = new Button("Ingresar");
    
    bIngresar.setOnAction(new EventHandler(){
      @Override
      public void handle(Event event) {
        Administrador admin = new Administrador();
        Registrador registrador1 = new Registrador();
        //checamos si los campos estan llenos
        if (tUsuario.getText().trim().isEmpty() == false) {
          //checamos si el usuario es correcto y la contraseña coinciden con los de la clase Admin
          if (tUsuario.getText().equals(admin.getUsuario()) && 
              tPassword.getText().equals(admin.getContrasenia())){
            //abrir una nueva ventana
            EscenarioAdministrador escenarioAdmin = new EscenarioAdministrador();
            Scene escena;
            escena = escenarioAdmin.EscenaAdministrador(primaryStage);
            primaryStage.setScene(escena);
            primaryStage.show();
          }
          //checamos si el usuario es correcto y la contraseña coinciden con los de la clase Empleado
          if (tUsuario.getText().equals(registrador1.getUsuario()) && 
              tPassword.getText().equals(registrador1.getContrasenia())) {
            //se abre la ventana de inventario, pues solo tiene acceso a esta.
              EscenarioVentas escenaVentas = new EscenarioVentas();
            Scene escena = escenaVentas.EscenaVentas(primaryStage);
            primaryStage.setScene(escena);
            primaryStage.show();
          }
          if (tUsuario.getText().equals(registrador1.getUsuario()) && 
              tPassword.getText().equals(registrador1.getContrasenia()) == false) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setHeaderText(null);
            alerta.setContentText("Usuario Incorrecto");
            alerta.show();
          }
        } else {
          Alert alerta = new Alert(Alert.AlertType.WARNING);
          alerta.setHeaderText(null);
          alerta.setContentText("Debes llenar todos los campos");
          alerta.show();
        }        
      }
    });
    
    GridPane gridPane= new GridPane();
    
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setVgap(5);
    gridPane.setHgap(5);
    
    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
    
    gridPane.add(texto, 0, 0);
    gridPane.add(lUsuario, 0, 1);
    gridPane.add(tUsuario, 1, 1);
    gridPane.add(lPassword, 0, 2);
    gridPane.add(tPassword, 1, 2);
    //gridPane.add(bIngresar, 1, 3);

    HBox hbbIngresar = new HBox(10);
    hbbIngresar.setAlignment(Pos.BOTTOM_RIGHT);
    hbbIngresar.getChildren().add(bIngresar);
    gridPane.add(hbbIngresar, 1, 4);
    
    //gridPane.setStyle("-fx-background-color: BEIGE;");
    
    Scene escena1 = new Scene(gridPane,300, 150);
    
    primaryStage.setTitle("!Bienvenido!");
    primaryStage.setScene(escena1);
    //agregamos hoja CSS de estilo a la escena
    //AquaFx.style();
    primaryStage.show();
    AquaFx.style();
       
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
