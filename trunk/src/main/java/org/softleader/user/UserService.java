package org.softleader.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<UserDto> cache = new ArrayList<UserDto>();

	public UserService() {
		cache.add(new UserDto(1L, "Ronan", "Yang", "ronan.yang", 0));
		cache.add(new UserDto(2L, "Tim", "Lee", "tim.lee", 0));
		cache.add(new UserDto(3L, "Jammy", "Wang", "jammy.wang", 0));
		cache.add(new UserDto(4L, "Kat", "Huang", "kat.huang", 1));
		cache.add(new UserDto(5L, "Jerry", "Chiang", "jerry.chiang", 1));
		cache.add(new UserDto(6L, "Glen", "Chuang", "glen.chuang", 1));
		cache.add(new UserDto(7L, "Caty", "Tsai", "caty.tasi", 0));
		cache.add(new UserDto(8L, "Wilson", "Wang", "wilson.wang", 1));
		cache.add(new UserDto(9L, "Zoe", "Liu", "zoe.liu", 0));
		cache.add(new UserDto(10L, "Van", "Lin", "van.lin", 1));
	}

	public List<UserDto> getAll() {
		return cache;
	}

	public UserDto getByUserName(String username) {
		for (UserDto user : cache) {
			if (user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
