package com.revature.services;

import com.revature.entities.Manager;

import java.util.List;

public interface ManagerService {

//    CRUD
	Manager createManager(Manager manager);

//    Read
	Manager getManagerById(int mgid);

	Manager getManagerByName(String name);

	Manager getManagerByEmail(String email);

	List<Manager> getAllManagers();

//    Update
	Manager updateManager(Manager manager);

//    Delete
	boolean deleteManager(Manager manager);
}
