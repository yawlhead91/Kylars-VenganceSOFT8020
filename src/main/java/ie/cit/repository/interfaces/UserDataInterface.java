package ie.cit.repository.interfaces;

import java.util.List;

import ie.cit.model.UserData;

public interface UserDataInterface {
	public UserData get(int id);
	public void save(UserData ud);
	public void remove(UserData ud);
	public List<UserData> findAll();
}
