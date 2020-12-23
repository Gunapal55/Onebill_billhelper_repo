package com.onebill.billhelper.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onebill.billhelper.dto.AdditionalChargesDto;
import com.onebill.billhelper.dto.BundleDetailsDto;
import com.onebill.billhelper.dto.BundleDto;
import com.onebill.billhelper.dto.OverDueDto;
import com.onebill.billhelper.service.BundleServiceImplementation;

class BundleServiceTest {

	private BundleServiceImplementation bundleService;
	private BundleDto bundleDto;
	private BundleDetailsDto bundleDetailsDto;
	private OverDueDto overDueDto;
	private AdditionalChargesDto addChargesDto;

	@BeforeEach
	void setUp() {

		bundleService = new BundleServiceImplementation();
		bundleService.setBundledao(new BundleDaoTestStub());
		bundleDto = new BundleDto();
		bundleDto.setBundleType("Mobile services");
		bundleDto.setBundleDescription("Enjoy Unlimited data, calls and messages");
		bundleDto.setBundleDuration("84 days");

		bundleService = new BundleServiceImplementation();
		bundleService.setBundledao(new BundleDaoTestStub());
		bundleDetailsDto = new BundleDetailsDto();
		bundleDetailsDto.setBundleDetailId(1);
		bundleDetailsDto.setBundleDetails("Unlimited calls from Jio to Jio");

		bundleService = new BundleServiceImplementation();
		bundleService.setBundledao(new BundleDaoTestStub());
		overDueDto = new OverDueDto();
		overDueDto.setOverDueId(1);
		overDueDto.setChargeType("per GB of usage");
		overDueDto.setChargeAmount(25);

		bundleService = new BundleServiceImplementation();
		bundleService.setBundledao(new BundleDaoTestStub());
		addChargesDto = new AdditionalChargesDto();
		addChargesDto.setChargeId(1);
		addChargesDto.setChargeType("Installation charges");
		addChargesDto.setChargeAmount(200);
		addChargesDto.setRequiredDocuments("PAN card");

	}

	@Test
	void testCreateBundle() {
		BundleDto bundle = bundleService.createBundle(bundleDto);
		assertEquals(bundle.getBundleDescription(), bundleDto.getBundleDescription());
	}

	@Test
	void testUpdateBundle() {
		BundleDto bundle = bundleService.updateBundle(bundleDto);
		assertNotEquals(bundleDto, bundle);
	}

	@Test
	void testRemoveBundle() {
		BundleDto bundle = bundleService.removeBundle(bundleDto);
		assertEquals(bundleDto.getBundleDescription(), bundle.getBundleDescription());

	}

	@Test
	void testGetAllBundle() {
		List<BundleDto> bundleList = bundleService.getAllBundle();
		assertNotNull(bundleList);
	}

	@Test
	void testAddBundleDetails() {
		BundleDetailsDto bundleDetails = bundleService.addBundleDetails(bundleDetailsDto);
		assertEquals(bundleDetails.getBundleDetails(), bundleDetailsDto.getBundleDetails());
	}

	@Test
	void testUpdateBundleDetails() {
		BundleDetailsDto bundleDetails = bundleService.updateBundleDetails(bundleDetailsDto);
		assertNotEquals(bundleDetailsDto, bundleDetails);
	}

	@Test
	void testRemoveDetails() {
		BundleDetailsDto bundleDetails = bundleService.removeDetails(bundleDetailsDto);
		assertEquals(bundleDetailsDto.getBundleDetails(), bundleDetails.getBundleDetails());

	}

	@Test
	void testGetAllBundleDetails() {
		List<BundleDetailsDto> bundleDetailsList = bundleService.getAllBundleDetails();
		assertNotNull(bundleDetailsList);
	}

	@Test
	void testGetBundleById() {
		BundleDto bundle = bundleService.getBundleById(1);
		assertEquals(1, bundle.getBundleId());
	}

	@Test
	void testGetBundleDetailById() {
		BundleDetailsDto bundleDetails = bundleService.getBundleDetailById(1);
		assertEquals(1, bundleDetails.getBundleDetailId());
	}

	@Test
	void testAddOverDue() {
		OverDueDto overDue = bundleService.addOverDue(overDueDto);
		assertEquals(overDue.getChargeType(), overDueDto.getChargeType());
	}

	@Test
	void testDeleteOverDue() {
		OverDueDto overDue = bundleService.deleteOverDue(overDueDto);
		assertEquals(overDueDto.getChargeType(), overDue.getChargeType());
	}

	@Test
	void testGetOverDueById() {
		OverDueDto overDue = bundleService.getOverDueById(1);
		assertEquals(1, overDue.getOverDueId());
	}

	@Test
	void testAddAdditionalCharges() {
		AdditionalChargesDto additionalCharge = bundleService.addAdditionalCharges(addChargesDto);
		assertEquals(additionalCharge.getChargeType(), addChargesDto.getChargeType());
	}

	@Test
	void testUpdateAdditionalCharges() {
		AdditionalChargesDto additionalCharge = bundleService.updateAddtionalCharges(addChargesDto);
		assertNotEquals(addChargesDto, additionalCharge);
	}

	@Test
	void testDeleteAdditionalCharges() {
		AdditionalChargesDto additionalCharge = bundleService.deleteAdditionalCharges(addChargesDto);
		assertEquals(addChargesDto.getChargeType(), additionalCharge.getChargeType());
	}

	@Test
	void testGetAdditionalChargesById() {
		AdditionalChargesDto additionalCharge = bundleService.getAdditionalChargesById(1);
		assertEquals(1, additionalCharge.getChargeId());
	}

}
