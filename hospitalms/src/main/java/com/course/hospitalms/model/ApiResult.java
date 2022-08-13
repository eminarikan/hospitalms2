package com.course.hospitalms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult {

	private boolean success;
	private String city;
	private List<Weather> result;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Weather> getResult() {
		return result;
	}
	public void setResult(List<Weather> result) {
		this.result = result;
	}
	
	
	
}
