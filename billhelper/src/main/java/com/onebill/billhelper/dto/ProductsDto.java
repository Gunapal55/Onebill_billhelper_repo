package com.onebill.billhelper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onebill.billhelper.entity.Bundle;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@NoArgsConstructor
public class ProductsDto implements Serializable {

	private static final long serialVersionUID = -5720691410702639419L;

	private int productId;
	
	private String productName;
	
	private String productType;
	
	private List<Bundle> bundle = new ArrayList<Bundle>();

}
