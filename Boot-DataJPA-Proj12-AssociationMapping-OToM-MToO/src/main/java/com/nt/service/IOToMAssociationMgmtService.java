package com.nt.service;

public interface IOToMAssociationMgmtService {

	public void saveDataUsingParent();

	public void saveDataUsingChild();

	public void loadDataUsingParent();

	public String deleteByPerson(int personId);

	public String deleteAllPhoneNumbersOfAPerson(int personId);

	public void addNewChildToAParentById(int personId);

}
