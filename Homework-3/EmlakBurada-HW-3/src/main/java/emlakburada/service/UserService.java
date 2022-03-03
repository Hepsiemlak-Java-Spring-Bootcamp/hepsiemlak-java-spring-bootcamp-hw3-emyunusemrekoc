package main.java.emlakburada.service;

import emlakburada.client.request.AddressRequest;
import emlakburada.client.request.BannerRequest;
import emlakburada.dto.AdvertRequest;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.AdvertResponse;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Advert;
import emlakburada.model.RealEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.model.User;
import emlakburada.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static int userId = 0;

	public UserResponse saveUser(UserRequest request) {
		User savedUser = userRepository.saveUser(convertToUser(request));

		return convertToUserResponse(savedUser);
	}

	public List<UserResponse> findAll() {

		List<UserResponse> userList = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			userList.add(convertToUserResponse(user));
		}
		return userList;

	}

	public UserResponse findByUserId(int userId) {
		User user = userRepository.findByUserId(userId);
		return convertToUserResponse(user);
	}

	private UserResponse convertToUserResponse(User savedUser) {
		UserResponse response = new UserResponse();
		response.setName(savedUser.getName());
		response.setEmail(savedUser.getEmail());
		response.setKullaniciTipi(savedUser.getKullaniciTipi());
		response.setId(savedUser.getId());

		return response;
	}

	private User convertToUser(UserRequest userRequest) {
		User user = new User();
		userId++;

		user.setId(userId);
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setKullaniciTipi(userRequest.getKullaniciTipi());

		return user;
	}

}
