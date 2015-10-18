package com.tcs.bfscoe.mobilebanking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Application Registration Payload", description = "Contains the Device ID, OTP and Mobile Number")
@Document(collection= "appregister")
public class AppRegistration {

	@ApiModelProperty(value= "Unique Identifier", required=true)
	@Id

	private String id;
	@ApiModelProperty(value= "Device Id")
	@Field
	private String deviceId;

	@ApiModelProperty(value= "One Time Password")
	@Field
	private int OTP;

	@ApiModelProperty(value= "Mobile Number")
	@Field
	private int mobileNumber;
	
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public int getOTP() {
		return OTP;
	}
	public void setOTP(int oTP) {
		OTP = oTP;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
