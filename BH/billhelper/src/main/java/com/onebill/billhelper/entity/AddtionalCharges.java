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

import lombok.Data;

@Entity
@Table(name = "extra_charges")
@Data
public class AddtionalCharges {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chargeId;

	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "charg_for")
	private String chargeType;

	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "charg_amt")
	private int chargeAmount;

	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "req_docs")
	private String requiredDocuments;

	@ManyToOne
	@JoinColumn(name = "bundle_id")
	private Bundle bundle;

}
