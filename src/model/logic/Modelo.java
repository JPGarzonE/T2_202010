package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.DataNode;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	private IStack<Feature> stack;

	private IQueue<Feature> queue;

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * 
	 * @param tamano
	 */
	public Modelo() {
		stack = new Stack<Feature>();
		queue = new Queue<Feature>();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo
	 * 
	 * @return numero de elementos presentes en el modelo
	 */
	public int getFeaturesSize() {
		return stack.size();
	}

	public Feature getFrontQueue() {
		return queue.getFront();
	}

	public Feature getTopStack() {
		return stack.getTop();
	}

	public void loadDataLists(String path) {
		loadGson(path);
	}

	public void loadGson(String path) {

		try {
			System.out.println(path);
			JsonReader reader = new JsonReader(new FileReader(path));
			JsonElement featuresElement = JsonParser.parseReader(reader).getAsJsonObject().get("features");
			JsonArray jsonFeaturesArray = featuresElement.getAsJsonArray();

			for (JsonElement element : jsonFeaturesArray) {

				String elemType = element.getAsJsonObject().get("type").getAsString();

				JsonElement elemProperties = element.getAsJsonObject().get("properties");

				int elemId = elemProperties.getAsJsonObject().get("OBJECTID").getAsInt();
				String elemDate = elemProperties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String elemDetectionMethod = elemProperties.getAsJsonObject().get("MEDIO_DETE").getAsString();
				String elemVehicleClass = elemProperties.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String elemServiceType = elemProperties.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String elemInfraction = elemProperties.getAsJsonObject().get("INFRACCION").getAsString();
				String elemInfractionReason = elemProperties.getAsJsonObject().get("DES_INFRAC").getAsString();
				String elemLocality = elemProperties.getAsJsonObject().get("LOCALIDAD").getAsString();

				JsonElement elemGeometry = element.getAsJsonObject().get("geometry");

				String elemGeomType = elemGeometry.getAsJsonObject().get("type").getAsString();
				JsonArray elemGeomCoordinates = elemGeometry.getAsJsonObject().get("coordinates").getAsJsonArray();
				ArrayList<Integer> elemCoordinates = new ArrayList<Integer>();

				for (JsonElement elemCoord : elemGeomCoordinates) {
					int actualCoord = elemCoord.getAsInt();
					elemCoordinates.add(actualCoord);
				}

				Feature feature = new Feature(elemType, elemId, elemDate, elemDetectionMethod, elemVehicleClass,
						elemServiceType, elemInfraction, elemInfractionReason, elemLocality, elemGeomType,
						elemCoordinates);

				loadDataNode(feature);

			}

		} catch (FileNotFoundException e) {
			System.out.println("ERROR! File not found");
		}

	}

	// For stack (pila)
	public ArrayList<Feature> getLastNFeaturesOf(String infractionType, int infractionsNumber) {

		DataNode<Feature> actualNode = stack.getTopNode();
		ArrayList<Feature> lastNFeatures = new ArrayList<>();
		
		while( actualNode != null && actualNode.next != null && lastNFeatures.size() < infractionsNumber ){
			
			if( actualNode.nodeInfo.getInfraction().equalsIgnoreCase(infractionType)) {
				lastNFeatures.add(stack.pop());
			}
			else{
				stack.pop();
			}
						
			actualNode = actualNode.next();
		}
		
		return lastNFeatures;
		
	}

	private void loadDataNode(Feature feature) {
		stack.push(feature);
		queue.enqueue(feature);
	}

}
