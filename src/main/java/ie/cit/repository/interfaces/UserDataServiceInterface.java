package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.UserData;

public interface UserDataServiceInterface {
	UserData get(int id);
	void save(UserData ud);
	void remove(UserData ud);
	List<UserData> findAll();
}
