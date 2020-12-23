package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class AdditionalChargesDto implements Serializable{

	
	private static final long serialVersionUID = -2074134551807630841L;

	private int chargeId;
	
	private String chargeType;
	
	private int chargeAmount;
	
	private String requiredDocuments;
	
	private Bundle bundle;
}
