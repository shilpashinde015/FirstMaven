package MavenFirst.FirstPrjMaven;

import java.util.List;
public class Places {
	Location location;
	int accuracy;
	String name;
	String phone_number;
	String address;
	List<String> types;
	String website;
	String language;
	public Places(Location loc,int acc,String name,String num,String add,List<String> typ,String web,String lag) {
		location=loc;
		accuracy=acc;
		this.name=name;
		phone_number=num;
		address=add;
		types=typ;
		website=web;
		language=lag;
		
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
class Location {
	Double lat;
	Double lng;
	public Location(Double a,Double b) {
		lat=a;
		lng=b;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}