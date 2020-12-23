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
@Table(name = "bndl_details")
public class BundleDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bndl_dtl_id")
	private int bundleDetailId;

	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "bdnle_type")
	private String bundleType;

	@NotNull
	@Size(min = 1, max = 120)
	@Column(name = "bndl_details")
	private String bundleDetails;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "bundle_id")
	private Bundle bundle;

}
