package ie.cit.repository.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.model.UserData;
import ie.cit.repository.interfaces.UserDataInterface;
import ie.cit.repository.interfaces.UserDataServiceInterface;

@Service
public class UserDataService implements UserDataServiceInterface {
	
	@Autowired
	UserDataInterface userDataRepo;

	@Override
	public UserData get(int id) {
		return userDataRepo.get(id);
	}

	@Override
	public void save(UserData ud) {
		userDataRepo.save(ud);
	}

	@Override
	public void remove(UserData ud) {
		userDataRepo.remove(ud);
	}

	@Override
	public List<UserData> findAll() {
		return userDataRepo.findAll();
	}
	
}