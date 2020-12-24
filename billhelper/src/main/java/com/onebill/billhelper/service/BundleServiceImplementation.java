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

		BundleDto addBundle = null;
		try {
			addBundle = bundledao.createBundle(bundle);

			if (addBundle != null) {
				return addBundle;
			} else {
				throw new BillhelperException("Unable to add create bundle new bundle");
			}
		} catch (Exception e) {
			throw new BillhelperException("Cannot create bundle for " + bundle.getBundleDescription() + " of duration "
					+ bundle.getBundleDuration() + " and for amount of " + bundle.getBundleAmount());
		}
	}

	@Override
	public BundleDto updateBundle(BundleDto bundle) {
		BundleDto updateBundle = null;
		try {
			updateBundle = bundledao.updateBundle(bundle);
			if (updateBundle != null) {
				return updateBundle;

			} else {
				throw new BillhelperException(
						"Unable to update for given bundle id: " + bundle.getBundleId() + " and bundle description "
								+ bundle.getBundleDescription() + " for amount of " + bundle.getBundleAmount());
			}
		} catch (Exception e) {
			throw new BillhelperException(
					"Unable to update for given bundle id: " + bundle.getBundleId() + " and bundle description "
							+ bundle.getBundleDescription() + " for amount of " + bundle.getBundleAmount());

		}
	}

	@Override
	public BundleDto removeBundle(BundleDto bundle) {
		BundleDto removeBundle = null;
		try {
			removeBundle = bundledao.removeBundle(bundle);
			if (removeBundle != null) {
				return removeBundle;

			} else {
				throw new BillhelperException(
						"Unable to remove the bunle with id: " + bundle.getBundleId() + " and bundle description "
								+ bundle.getBundleDescription() + " for amount of " + bundle.getBundleAmount());
			}
		} catch (Exception e) {
			throw new BillhelperException(
					"Unable to remove the bunle with id: " + bundle.getBundleId() + " and bundle description "
							+ bundle.getBundleDescription() + " for amount of " + bundle.getBundleAmount());
		}
	}

	@Override
	public List<BundleDto> getAllBundle() {
		List<BundleDto> bundleList = null;
		try {
			bundleList = bundledao.getAllBundle();
			if (bundleList != null) {
				return bundleList;
			} else {
				throw new BillhelperException("No bundle found to disply please create new one's");

			}
		} catch (Exception e) {
			throw new BillhelperException("No bundle found to disply please create new one's");
		}
	}

	@Override
	public BundleDto getBundleById(int bundleId) {
		BundleDto bundle = null;
		try {
			bundle = bundledao.getBundleById(bundleId);

			if (bundle != null) {
				return bundle;

			} else {
				throw new BillhelperException("Unable to find the bundle for the given bundle id " + bundleId);
			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to find the bundle for the given bundle id " + bundleId);
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
		List<BundleDetailsDto> bundleDetailList = null;
		try {
			bundleDetailList = bundledao.getAllBundleDetails();

			if (bundleDetailList != null) {

				return bundleDetailList;

			} else {
				throw new BillhelperException("No bundle found to disply please create new one's");
			}
		} catch (Exception e) {
			throw new BillhelperException("No bundle found to disply please create new one's");
		}
	}

	@Override
	public BundleDetailsDto getBundleDetailById(int bundleDetailId) {
		BundleDetailsDto bundleDetail = null;
		try {
			bundleDetail = bundledao.getBundleDetailById(bundleDetailId);

			if (bundleDetail != null) {
				return bundleDetail;

			} else {
				throw new BillhelperException("No details found for the given id: " + bundleDetailId);
			}
		} catch (Exception e) {
			throw new BillhelperException("No details found for the given id: " + bundleDetailId);

		}
	}

	@Override
	public OverDueDto addOverDue(OverDueDto overDue) {
		OverDueDto addDue = null;
		try {
			addDue = bundledao.addOverDue(overDue);

			if (addDue != null) {
				return addDue;
			} else {
				throw new BillhelperException("Unable to create overdue for over due type" + overDue.getChargeType()
						+ " and for amount " + overDue.getChargeAmount());
			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to create overdue for over due type" + overDue.getChargeType()
					+ " and for amount " + overDue.getChargeAmount());
		}
	}

	@Override
	public OverDueDto updateOverDue(OverDueDto overDue) {
		OverDueDto updateDue = null;
		try {
			updateDue = bundledao.updateOverDue(overDue);
			if (updateDue != null) {

				return updateDue;

			} else {
				throw new BillhelperException("Unable to find the Overdue of id " + overDue.getOverDueId()
						+ " please enter valid id and try again");

			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to find the Overdue of id " + overDue.getOverDueId()
					+ " please enter valid id and try again");
		}
	}

	@Override
	public OverDueDto deleteOverDue(OverDueDto overDue) {
		OverDueDto deleteDue = null;
		try {
			deleteDue = bundledao.deleteOverDue(overDue);
			if (deleteDue != null) {
				return overDue;

			} else {
				throw new BillhelperException("Failed to delet the record for given overdue id: "
						+ overDue.getOverDueId() + " please try again with the valid id");

			}
		} catch (Exception e) {
			throw new BillhelperException("Failed to delet the record for given overdue id: " + overDue.getOverDueId()
					+ " please try again with the valid id");
		}
	}

	@Override
	public OverDueDto getOverDueById(int overDueId) {
		OverDueDto due = null;
		try {
			due = bundledao.getOverDueById(overDueId);
			if (due != null) {
				return due;

			} else {
				throw new BillhelperException("Unable to get the record for the given id: " + overDueId
						+ " please enter the valid id and try again");
			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to get the record for the given id: " + overDueId
					+ " please enter the valid id and try again");
		}
	}

	@Override
	public AdditionalChargesDto addAdditionalCharges(AdditionalChargesDto additional) {
		AdditionalChargesDto addAddCharges = null;
		try {
			addAddCharges = bundledao.addAdditionalCharges(additional);

			if (addAddCharges != null) {
				return addAddCharges;
			} else {
				throw new BillhelperException("Unable to add the additional charges and document ");
			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to add the additional charges on " + addAddCharges.getChargeType()
					+ " for amount of " + addAddCharges.getChargeAmount() + " and document "
					+ addAddCharges.getRequiredDocuments());
		}
	}

	@Override
	public AdditionalChargesDto updateAddtionalCharges(AdditionalChargesDto additional) {
		AdditionalChargesDto updateAddCharges = null;
		try {
			updateAddCharges = bundledao.updateAdditionalCharges(additional);

			if (updateAddCharges != null) {

				return updateAddCharges;

			} else {
				throw new BillhelperException(
						"No matching record found for update please enter valid details to update");
			}
		} catch (Exception e) {
			throw new BillhelperException("No matching record found for id: " + updateAddCharges.getChargeId()
					+ " for type " + updateAddCharges.getChargeType() + " and for amount of  "
					+ updateAddCharges.getChargeAmount() + " with document type of "
					+ updateAddCharges.getRequiredDocuments());
		}
	}

	@Override
	public AdditionalChargesDto deleteAdditionalCharges(AdditionalChargesDto additional) {
		try {

			if (additional != null) {
				return additional;

			} else {
				throw new BillhelperException("Unable to remove the record please provide valid data");

			}
		} catch (Exception e) {
			throw new BillhelperException("Unable to remove the record for id " + additional.getChargeId());
		}
	}

	@Override
	public AdditionalChargesDto getAdditionalChargesById(int additionalId) {
		AdditionalChargesDto addDetails = null;
		try {
			addDetails = bundledao.getAdditionalChargesById(additionalId);
			if (addDetails != null) {
				return addDetails;
			} else {
				throw new BillhelperException("No details found for the given id: " + additionalId);

			}
		} catch (Exception e) {
			throw new BillhelperException("No details found for the given id: " + additionalId);
		}
	}
}
