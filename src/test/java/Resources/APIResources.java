package Resources;

//enum is special class in java which has collection of constants or methods
public enum APIResources {

	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resources;
	APIResources(String resources){
		this.resources=resources;
		
	}
	
	public String getResource() {
		return resources;
	}
	
}