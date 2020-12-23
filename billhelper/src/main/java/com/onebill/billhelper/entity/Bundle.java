package com.onebill.billhelper.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "bundle_info")
public class Bundle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bndl_id")
	private int bundleId;

	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "bndl_desc")
	private String bundleDescription;

	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "bndl_type")
	private String bundleType;

	@NotNull
	@Size(min = 1, max = 16)
	@Column(name = "bndl_dura")
	private String bundleDuration;

	@NotNull
	@Column(name = "bndl_amout")
	private Double bundleAmount;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "prd_id")
	private Products products;

	@OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BundleDetails> details;

	@OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<OverDue> due;

	@OneToMany(mappedBy = "bundle", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AddtionalCharges> addCharges;

}
