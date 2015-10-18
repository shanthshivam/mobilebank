package com.tcs.bfscoe.mobilebanking.dto.error;
import java.util.ArrayList;
import java.util.List;
 
public class ValidationErrorDTO {
 
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();
 
    public ValidationErrorDTO() {
 
    }
 
    public List<FieldErrorDTO> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }
 
    //Getter is omitted.
}