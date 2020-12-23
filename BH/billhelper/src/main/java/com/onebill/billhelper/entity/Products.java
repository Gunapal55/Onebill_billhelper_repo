package com.onebill.billhelper.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "product_info")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prd_id")
	private int productId;

	@NotNull
    @Size(min = 1, max = 45)
	@Column(name = "prd_name")
	private String productName;

	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "prd_type")
	private String productType;

	@OneToMany(mappedBy = "products")
	@JsonIgnore
	private List<Bundle> bundle;

}
