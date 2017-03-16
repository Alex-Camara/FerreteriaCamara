package ferreteriaCamara;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author Miguel Alejandro Cámara Árciga
 */
public class Venta {
    public static ArrayList<ArticuloVendido> articuloVendido = new ArrayList<ArticuloVendido>();

  /**-------------------------------------------------------------------------------------------
  * metodo estandar para seliarizar un objeto.
  * para registrar las ventas
  */
  public static void guardarVendidos(){
    try{
      FileOutputStream fos= new FileOutputStream("vendido.ser");
      ObjectOutputStream oos= new ObjectOutputStream(fos);
      //escribimos el ArrayList en el archivo
      oos.writeObject(articuloVendido);
      oos.close();
      fos.close();
      }catch(IOException ioe){
      }
  }
    
  /**-------------------------------------------------------------------------------------------
  * Metodo estandar para leer objetos serializados en el archivo "vendido.ser"
  * @return 
  */
  public static List recuperarRegistroVenta(){
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("vendido.ser"));
      articuloVendido = (ArrayList<ArticuloVendido>) in.readObject(); 
      in.close();
    } catch(IOException | ClassNotFoundException e) {
    }
    return articuloVendido;
  }
  
  /**
   * --------------------------------------------------------------------------------------------
   * @param art
   * @param cantidad 
   */
  public static void registrarVenta(Articulo art, int cantidad){
    ArticuloVendido aVendido = new ArticuloVendido();
    int PORCENTAJE_GANANCIA = 50;
    float precio_total;
    float precio_ganancia = 0;
    float precio_original = art.getPrecio_compra();
    float iva;
    //se crea una instancia de la clase Calendar de java.util para obtener la fecha actual
    Calendar fecha = Calendar.getInstance();
    String dia;
    String mes;
    String anio;
    //asignamos la fecha actual a cada variable string.
    dia = Integer.toString(fecha.get(Calendar.DATE));
    mes = Integer.toString(fecha.get(Calendar.MONTH));
    anio = Integer.toString(fecha.get(Calendar.YEAR));
    
    //la ganacia va a ser igual a el precio original + el porcentaje de ganacia
    precio_ganancia = precio_original + ((precio_original*PORCENTAJE_GANANCIA) / 100);
    
    iva = calcularIVA(precio_ganancia);
    precio_total = precio_ganancia + iva;
    
    System.out.println("CONFIRMACION DE VENTA: \n"
                          + "FECHA: " + dia + " del mes " + mes + " del " + anio + "\n"
                          + "CLAVE: " + art.getClave() +"\n"
                          + "CANTIDAD A VENDER: " + cantidad +"\n"
                          + "NOMBRE: " + art.getNombre() +"\n"
                          + "DESCRIPCION: " + art.getDescripcion() +"\n"
                          + "CANTIDAD EN EXISTENCIA: " + art.getExistencia()+"\n"
                          + "PRECIO DEL PRODUCTO: " + precio_ganancia +"\n"
                          + "IVA: " + iva + "\n"
                          + "PRECIO TOTAL: " + precio_total + "\n");
  
    articuloVendido.add(aVendido);
    aVendido.setDia(dia);
    aVendido.setMes(mes);
    aVendido.setAnio(anio);
    aVendido.setClave(art.getClave());
    aVendido.setNombre(art.getNombre());
    aVendido.setTipo_unidad(art.getTipo_unidad());
    aVendido.setDescripcion(art.getDescripcion());
    aVendido.setPrecio_venta(precio_total);
    aVendido.setPrecio_compra(precio_original);
    guardarVendidos();
  }
  
  /**
   * -------------------------------------------------------------------------------------------
   * @param costo
   * @return 
   */
  public static float calcularIVA(float costo){
    int IVA = 16;
    float impuesto;
    
    return impuesto = (costo*IVA)/100;
  }
}
