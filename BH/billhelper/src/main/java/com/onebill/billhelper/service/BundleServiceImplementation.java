package com.onebill.billhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.billhelper.dao.BundleDao;
import com.onebill.billhelper.dto.AdditionalChargesDto;
import com.onebill.billhelper.dto.BundleDetailsDto;
import com.onebill.billhelper.dto.BundleDto;
import com.onebill.billhelper.dto.OverDueDto;
import com.onebill.billhelper.exception.BillhelperException;

@Service
public class BundleServiceImplementation implements BundleService {

	@Autowired
	private BundleDao bundledao;

	public void setBundledao(BundleDao bundledao) {
		this.bundledao = bundledao;
	}

	@Override
	public BundleDto createBundle(BundleDto bundle) {

		BundleDto addBundle = bundledao.createBundle(bundle);
		if (addBundle != null) {
			return addBundle;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public BundleDto updateBundle(BundleDto bundle) {
		BundleDto updateBundle = bundledao.updateBundle(bundle);
		if (updateBundle != null) {

			return updateBundle;

		} else {
			throw new BillhelperException("No matching record found for update");
		}
	}

	@Override
	public BundleDto removeBundle(BundleDto bundle) {
		BundleDto removeBundle = bundledao.removeBundle(bundle);
		if (removeBundle != null) {

			return removeBundle;

		} else {
			throw new BillhelperException("No matching data found to remove");
		}
	}

	@Override
	public List<BundleDto> getAllBundle() {
		List<BundleDto> bundleList = bundledao.getAllBundle();
		if (bundleList != null) {

			return bundleList;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public BundleDto getBundleById(int bundleId) {
		BundleDto bundle = bundledao.getBundleById(bundleId);
		if (bundle != null) {
			return bundle;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public BundleDetailsDto addBundleDetails(BundleDetailsDto bundleDetail) {

		BundleDetailsDto addBundleDetail = bundledao.addBundleDetails(bundleDetail);
		if (addBundleDetail != null) {
			return addBundleDetail;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public BundleDetailsDto updateBundleDetails(BundleDetailsDto bundleDetail) {
		BundleDetailsDto updateBundleDetail = bundledao.updateBundleDetails(bundleDetail);
		if (updateBundleDetail != null) {

			return updateBundleDetail;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public BundleDetailsDto removeDetails(BundleDetailsDto bundleDetail) {
		BundleDetailsDto removeBundleDetail = bundledao.removeDetails(bundleDetail);
		if (removeBundleDetail != null) {
			return removeBundleDetail;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public List<BundleDetailsDto> getAllBundleDetails() {
		List<BundleDetailsDto> bundleDetailList = bundledao.getAllBundleDetails();
		if (bundleDetailList != null) {

			return bundleDetailList;

		} else {
			throw new BillhelperException("No plans found");

		}
	}

	@Override
	public BundleDetailsDto getBundleDetailById(int bundleDetailId) {
		BundleDetailsDto bundleDetail = bundledao.getBundleDetailById(bundleDetailId);
		if (bundleDetail != null) {
			return bundleDetail;

		} else {
			throw new BillhelperException("No plans found");
		}
	}

	@Override
	public OverDueDto addOverDue(OverDueDto overDue) {
		OverDueDto addDue = bundledao.addOverDue(overDue);
		if (addDue != null) {
			return addDue;
		} else {
			throw new BillhelperException("Please add due");
		}
	}

	@Override
	public OverDueDto updateOverDue(OverDueDto overDue) {
		OverDueDto updatedue = bundledao.updateOverDue(overDue);
		if (updatedue != null) {

			return updatedue;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public OverDueDto deleteOverDue(OverDueDto overDue) {
		if (overDue != null) {
			return overDue;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public OverDueDto getOverDueById(int overDueId) {
		OverDueDto due = bundledao.getOverDueById(overDueId);
		if (due != null) {
			return due;

		} else {
			throw new BillhelperException("No data found");
		}
	}

	@Override
	public AdditionalChargesDto addAddtionalCharges(AdditionalChargesDto addtional) {
		AdditionalChargesDto addAddCharges = bundledao.addAddtionalCharges(addtional);
		if (addAddCharges != null) {
			return addAddCharges;
		} else {
			throw new BillhelperException("Record already exists");
		}
	}

	@Override
	public AdditionalChargesDto updateAddtionalCharges(AdditionalChargesDto addtional) {
		AdditionalChargesDto updateAddCharges = bundledao.updateAddtionalCharges(addtional);
		if (updateAddCharges != null) {

			return updateAddCharges;

		} else {
			throw new BillhelperException("No matching record found for update");

		}
	}

	@Override
	public AdditionalChargesDto deleteAddtionalCharges(AdditionalChargesDto addtional) {
		if (addtional != null) {
			return addtional;

		} else {
			throw new BillhelperException("No matching data found to remove");

		}
	}

	@Override
	public AdditionalChargesDto getAddtionalChargesById(int addtionalId) {
		AdditionalChargesDto addDetails = bundledao.getAddtionalChargesById(addtionalId);
		if (addDetails != null) {
			return addDetails;

		} else {
			throw new BillhelperException("No data found");
		}
	}
}
