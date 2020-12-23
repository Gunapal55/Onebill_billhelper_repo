package com.onebill.billhelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "overdue_info")
public class OverDue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ovr_id")
	private int overDueId;

	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "charge_type")
	private String chargeType;

	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "charg_amt")
	private int chargeAmount;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "bundle_id")
	private Bundle bundle;

}
