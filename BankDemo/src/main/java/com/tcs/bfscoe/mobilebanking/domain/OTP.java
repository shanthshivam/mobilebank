package com.tcs.bfscoe.mobilebanking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value="OTP", description="OTP wrapper containing App Package, Device ID, Mobile Number and OTP")
public class OTP {


	@ApiModelProperty(value = "Device ID")
	private String deviceId;
	@ApiModelProperty(value = "Mobile Number")
	private int mobileNumber;
	@ApiModelProperty(value = "App Package Name")
	private String appPackage;
	@ApiModelProperty(value = "One Time Password")
	private int oneTimePassword;
	
	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getAppPackage() {
		return appPackage;
	}
	
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
		
	public int getOneTimePassword() {
		return oneTimePassword;
	}
	
	public void setOneTimePassword(int oneTimePassword) {
		this.oneTimePassword = oneTimePassword;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
