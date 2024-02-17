package com.example.weather;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Weatherent {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String city;
	    private double temperature;
	    private double pressure;
	    private int humidity;
		public Long getId() {
			return id;
		}
		public String getCity() {
			return city;
		}
		public double getTemperature() {
			return temperature;
		}
		public double getPressure() {
			return pressure;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setTemperature(double temperature) {
			this.temperature = temperature;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		public Weatherent(Long id, String city, double temperature, double pressure, int humidity) {
			super();
			this.id = id;
			this.city = city;
			this.temperature = temperature;
			this.pressure = pressure;
			this.humidity = humidity;
		}
		public Weatherent() {
			super();
			// TODO Auto-generated constructor stub
		}
	    


}
