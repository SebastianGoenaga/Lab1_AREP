package arep.cal_media_desv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Sebastian Goenaga
 * 
 * Calculadora de medias y desviaciones
 * estandararep
 *
 */
public class Calculadora 
{

	public static void main( String[] args ) throws IOException
    {
        FileReader fr = new FileReader("datos.txt");
        BufferedReader bf = new BufferedReader(fr);
        String dato;
        LinkedList<Double> datos = new LinkedList<Double>();
        while ((dato = bf.readLine())!=null) {
        	   datos.add(Double.parseDouble(dato));
        	}
        System.out.println(media(datos));
        System.out.println(desviacion(datos));
        bf.close();
    }
    
    /**
     * Calcula la media de un conjunto de datos
     * 
     * @param LinkedList<Float>
     * Son los datos apartir de los cuales
     * se calculará la media
     * 
     * @return float
     * Media
     * 
     */
    private static double media(LinkedList<Double> datos) {
    	
    	double suma = 0;
    	int n = datos.size();
    	for (Double dato : datos) {
    		suma += dato;
		}
    	return suma/n;
    	
    }
    
    /**
     * Calcula la desviacion estandar de un conjunto de datos
     * 
     * @param LinkedList<Float>
     * Son los datos apartir de los cuales
     * se calculará la desviación estandar
     * 
     * @return float
     * Desviación estandar
     * 
     */
    private static double desviacion(LinkedList<Double> datos) {
    	double suma = 0;
    	int n = datos.size();
    	double media = media(datos);
    	for (Double dato : datos) {
    		suma += Math.pow(dato-media, 2);
		}
    	
    	return Math.sqrt(suma/(n-1));
    }
    
    
}
