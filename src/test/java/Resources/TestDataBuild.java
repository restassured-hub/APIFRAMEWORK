package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;

public class TestDataBuild {
	
public AddPlace testDataBuild(String string1,String string2,String string3) {
	
	AddPlace a=new AddPlace();
	a.setAccuracy(50);
	a.setAddress(string3);
	a.setLanguage(string2);
	
	a.setName(string1);
	a.setPhone_number("9742950754");
	a.setWebsite("http://googl.com");
	List<String>  myList=new ArrayList<String>();
	myList.add("BookStroe");
	myList.add("Flowers");
	a.setTypes(myList);
	
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	a.setLocation(l);
	return a;
}

public String deletePlacePayload(String placeid) {
	return "{\r\n    \"place_id\":\""+placeid+"\"\r\n}";
}

}
