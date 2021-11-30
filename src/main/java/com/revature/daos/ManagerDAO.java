package com.revature.daos;

import java.util.List;

import com.revature.entities.Manager;

public interface ManagerDAO {

//	CRUD
	Manager createManager(Manager manager);

//	READ
	Manager getManagerById(int mgid);

	List<Manager> getAllManagers();

//	Update
	Manager updateManager(Manager manager);

//	DELETE
	boolean deleteManager(Manager manager);
}
