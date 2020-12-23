package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onebill.billhelper.entity.Products;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
public class BundleDto implements Serializable {

	private static final long serialVersionUID = -9212158082875616550L;

	private int bundleId;
	
	private String bundleDescription;
	
	private String bundleType;
	
	private String bundleDuration;
	
	private double bundleAmount;
	
	private Products products;
}
