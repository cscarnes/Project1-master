package com.revature.daos;

import java.util.List;

import com.revature.entities.Reimbursement;

public interface ReimbursementDAO {

//	CRUD
	Reimbursement createReimbursement(Reimbursement reimbursement);

//	Read
	Reimbursement getReimbursementById(int rid);

	List<Reimbursement> getAllReimbursement();

//	Update
	Reimbursement updateReimbursement(Reimbursement reimbursement);

//	Delete
	boolean deleteReimbursement(Reimbursement reimbursement);

}
