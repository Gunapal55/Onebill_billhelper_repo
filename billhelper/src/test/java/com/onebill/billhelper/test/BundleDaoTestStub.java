package com.onebill.billhelper.test;

import java.util.ArrayList;
import java.util.List;

import com.onebill.billhelper.dao.BundleDao;
import com.onebill.billhelper.dto.AdditionalChargesDto;
import com.onebill.billhelper.dto.BundleDetailsDto;
import com.onebill.billhelper.dto.BundleDto;
import com.onebill.billhelper.dto.OverDueDto;

import lombok.Data;

@Data
public class BundleDaoTestStub implements BundleDao {

	@Override
	public BundleDto createBundle(BundleDto bundle) {
		BundleDto dto = new BundleDto();
		dto.setBundleId(1);
		dto.setBundleType("Mobile services");
		dto.setBundleDescription("Enjoy Unlimited data, calls and messages");
		dto.setBundleDuration("84 days");
		return dto;
	}

	@Override
	public BundleDto updateBundle(BundleDto bundle) {
		BundleDto dto = new BundleDto();
		dto.setBundleId(1);
		dto.setBundleType("Mobile services");
		dto.setBundleDescription("Enjoy Unlimited data, calls and messages");
		dto.setBundleDuration("60 days");
		return dto;
	}

	@Override
	public BundleDto removeBundle(BundleDto bundle) {
		return bundle;
	}

	@Override
	public List<BundleDto> getAllBundle() {
		BundleDto dto1 = new BundleDto();
		dto1.setBundleId(1);
		dto1.setBundleType("Mobile services");
		dto1.setBundleDescription("Enjoy Unlimited data, calls and messages");
		dto1.setBundleDuration("60 days");
		BundleDto dto2 = new BundleDto();
		dto2.setBundleId(2);
		dto2.setBundleType("Media");
		dto2.setBundleDescription("Enjoy Unlimited Netflix & Hot Star");
		dto2.setBundleDuration("30 days");
		List<BundleDto> list1 = new ArrayList<>();
		list1.add(dto1);
		list1.add(dto2);
		return list1;
	}

	@Override
	public BundleDto getBundleById(int BundleId) {
		BundleDto dto1 = new BundleDto();
		dto1.setBundleId(1);
		dto1.setBundleType("Mobile services");
		dto1.setBundleDescription("Unlimited calls from jio to jio");
		dto1.setBundleDuration("60 days");
		return dto1;
	}

	@Override
	public BundleDetailsDto addBundleDetails(BundleDetailsDto bundleDetail) {
		BundleDetailsDto dto = new BundleDetailsDto();
		dto.setBundleDetailId(1);
		dto.setBundleDetails("Unlimited calls from Jio to Jio");
		return dto;
	}

	@Override
	public BundleDetailsDto updateBundleDetails(BundleDetailsDto bundleDetail) {
		BundleDetailsDto dto = new BundleDetailsDto();
		dto.setBundleDetailId(1);
		dto.setBundleDetails("Limited calls from Jio to others");
		dto.setBundleType("voice call services");
		return dto;

	}

	@Override
	public BundleDetailsDto removeDetails(BundleDetailsDto bundleDetail) {
		return bundleDetail;
	}

	@Override
	public List<BundleDetailsDto> getAllBundleDetails() {
		BundleDetailsDto dto1 = new BundleDetailsDto();
		dto1.setBundleDetailId(1);
		dto1.setBundleDetails("Calls jio to jio unlimited");
		BundleDetailsDto dto2 = new BundleDetailsDto();
		dto1.setBundleDetailId(2);
		dto1.setBundleDetails("Data 2Gb per day");
		List<BundleDetailsDto> list1 = new ArrayList<>();
		list1.add(dto1);
		list1.add(dto2);
		return list1;
	}

	@Override
	public BundleDetailsDto getBundleDetailById(int bundleDetailId) {
		BundleDetailsDto dto = new BundleDetailsDto();
		dto.setBundleDetailId(1);
		dto.setBundleDetails("Limited calls from Jio to others");
		dto.setBundleType("voice call services");
		return dto;
	}

	@Override
	public OverDueDto addOverDue(OverDueDto overDue) {
		OverDueDto dto = new OverDueDto();
		dto.setOverDueId(1);
		dto.setChargeType("per GB of usage");
		dto.setChargeAmount(20);
		return dto;
	}

	@Override
	public OverDueDto updateOverDue(OverDueDto overDue) {
		OverDueDto dto = new OverDueDto();
		dto.setOverDueId(1);
		dto.setChargeType("per GB of usage");
		dto.setChargeAmount(25);
		return dto;
	}

	@Override
	public OverDueDto deleteOverDue(OverDueDto overDue) {
		return overDue;
	}

	@Override
	public OverDueDto getOverDueById(int overDueId) {
		OverDueDto dto = new OverDueDto();
		dto.setOverDueId(1);
		dto.setChargeType("per GB of usage");
		dto.setChargeAmount(25);
		return dto;
	}

	@Override
	public AdditionalChargesDto addAdditionalCharges(AdditionalChargesDto additional) {
		AdditionalChargesDto dto = new AdditionalChargesDto();
		dto.setChargeId(1);
		dto.setChargeType("Installation charges");
		dto.setChargeAmount(200);
		dto.setRequiredDocuments("PAN card");
		return dto;
	}

	@Override
	public AdditionalChargesDto updateAdditionalCharges(AdditionalChargesDto additional) {
		AdditionalChargesDto dto = new AdditionalChargesDto();
		dto.setChargeId(1);
		dto.setChargeType("Installation charges");
		dto.setChargeAmount(350);
		dto.setRequiredDocuments("Aadhar card");
		return dto;
	}

	@Override
	public AdditionalChargesDto deleteAdditionalCharges(AdditionalChargesDto additional) {
		return additional;
	}

	@Override
	public AdditionalChargesDto getAdditionalChargesById(int additionalId) {
		AdditionalChargesDto dto = new AdditionalChargesDto();
		dto.setChargeId(1);
		dto.setChargeType("Installation charges");
		dto.setChargeAmount(350);
		dto.setRequiredDocuments("Aadhar card");
		return dto;
	}

}
