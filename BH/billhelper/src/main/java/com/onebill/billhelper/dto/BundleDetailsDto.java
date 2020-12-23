package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BundleDetailsDto implements Serializable{

	private static final long serialVersionUID = -5668589930484540636L;

	private int bundleDetailId;
	
	private String bundleType;
	
	private String bundleDetails;
	
	private Bundle bundle;
}
