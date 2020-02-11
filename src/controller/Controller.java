package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.logic.Feature;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	static final String DATA_PATH = "./data/comparendos_dei_2018_small.geojson";
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \nCargando datos de comparendos...");
				    modelo = new Modelo();
				    modelo.loadDataLists(DATA_PATH);
				    Feature firstQueue = modelo.getFrontQueue();
				    Feature firstStack = modelo.getTopStack();
				    int featuresNumber = modelo.getFeaturesSize();

				    view.printGeneralFeaturesInfo(firstQueue, firstStack, featuresNumber);
					break;
					
				case 3:
					if(modelo != null){
						view.printMessage("\nTipo de infraccion: ");
						String infractionType = lector.next();
						view.printMessage("\nNumero de infracciones: ");
						int infractionsNumber = lector.nextInt();
						view.printMessage("--------- \nProcesando consulta...");
						ArrayList<Feature> lastFeatures = modelo.getLastNFeaturesOf(infractionType, infractionsNumber);
	
						for( Feature feature : lastFeatures){
							view.printFeature(feature);
						}
					}
					else{
						view.printMessage("No se han cargado los datos");	
					}
					
					break;
					
				case 4: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
