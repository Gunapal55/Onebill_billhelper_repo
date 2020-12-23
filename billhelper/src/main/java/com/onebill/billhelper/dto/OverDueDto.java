package com.onebill.billhelper.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onebill.billhelper.entity.Bundle;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown= true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OverDueDto implements Serializable{
	
	private static final long serialVersionUID = 7185082734382131590L;

	private int overDueId;

	private String chargeType;
	
	private int chargeAmount;
	
	private Bundle bundle;
}
