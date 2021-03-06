package com.lcomputerstudy1.example.service;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.domain.User;
import com.lcomputerstudy1.example.mapper.UserMapper;

@Service
public class UserServicelmpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userMapper.readUser(username);
		user.setAuthorities(getAuthoritites(username));

//		if(user != null) {
//			user.setuName(user.getuName());
//			user.setUsername(user.getUsername());
//			user.setPassword(user.getPassword());
			
//		}

		return user;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthoritites(String username) {
		List<GrantedAuthority> authorities = userMapper.readAuthorities(username);
		return authorities;
	}
	
	@Override
	public void createUser(User user) {
		userMapper.createUser(user);
		userMapper.createAuthority(user);
		
	}
	
	@Override
	public void createAuthorities(User user) {
		userMapper.createAuthority(user);
	}
	
	@Override
	public User readUser(String username) {
		return userMapper.readUser(username);
	}


	@Override
	public int userCount(Pagination pagination) {
		return userMapper.userCount(pagination);
	}

	@Override
	public List<User> selectUserList(Pagination pagination) {
		return userMapper.selectUserList(pagination);
	}
	
	
}
