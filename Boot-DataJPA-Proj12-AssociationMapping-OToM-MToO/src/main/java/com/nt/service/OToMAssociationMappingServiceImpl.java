package com.nt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service("OtoMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public void saveDataUsingParent() {

		// create object for Person class
		Person per = new Person("Krushna", "pune");

		// create child object
		PhoneNumber ph1 = new PhoneNumber(99999999L, "airtel", "personal");
		PhoneNumber ph2 = new PhoneNumber(88888888L, "vi", "office");

		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);

		// add child to parent
		Set<PhoneNumber> phoneSet = new HashSet();
		phoneSet.add(ph1);
		phoneSet.add(ph2);
		per.setContactDetails(phoneSet);

		// save the parent object
		personRepo.save(per);
		System.out.println("Person and his associated PhoneNumbers are saved(parent to child");

	}

	@Override
	public void saveDataUsingChild() {
		// create Parent object
		Person per = new Person("ramesh", "vizag");

		// create child objects
		PhoneNumber ph1 = new PhoneNumber(88888899L, "airtel", "personal");
		PhoneNumber ph2 = new PhoneNumber(77777777L, "vi", "office");

		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);

		// add childs to parent
		Set<PhoneNumber> phonesSet = new HashSet();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);

		// save the parent object
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);

		System.out.println("person and his associated phoneNumber are saved(child to parent)");
	}

	@Override
	public void loadDataUsingParent() {
		Iterable<Person> it = personRepo.findAll();
		it.forEach(per -> {
			System.out.println("parent:: " + per);

		});

	}

	// delete data using parent by id
	// In OToM association if we delete parent obj then chaild obj also deleted

	@Override
	public String deleteByPerson(int personId) {
		// load the Parent obj
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {
			personRepo.delete(opt.get());
			return "Person and his phoneNumbers are deleted";
		}
		return "Person not found";
	}

	// Deleting only childs of parent in OneToMany Association

	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		// load Parent object
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {

			// get all childs of a parent
			Set<PhoneNumber> childs = opt.get().getContactDetails();

			// remove parent like from childs
			childs.forEach(ph -> {
				ph.setPersonInfo(null);
			});
			// delete all child object
			phoneRepo.deleteAll(childs);

			return childs.size() + "Phonenumbers of " + personId + " person are deleted";

		} else {
			return "::+person is not found for deltaion";
		}
	}

	// adding to a child to existing childs of a parent
	@Override
	public void addNewChildToAParentById(int personId) {
		// load the parent object
		Optional<Person> opt = personRepo.findById(personId);
		if (opt.isPresent()) {

			Person per = opt.get();

			// get the childs of a parent
			Set<PhoneNumber> childs = per.getContactDetails();

			// create the new child object
			PhoneNumber ph = new PhoneNumber(77777777L, "vodafone", "personal");

			// link child to parent
			ph.setPersonInfo(per);
			childs.add(ph);
			phoneRepo.save(ph);
			System.out.println("New child is added to the existing child of a parent");
		} else {
			System.out.println(personId + " person not found for the operation");
		}
	}
}
