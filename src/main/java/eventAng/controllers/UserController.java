package eventAng.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eventAng.repository.UsersRepository;

import eventAng.domain.Users;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	UsersRepository uRep;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Users> findAll(){
		List<Users> ul=uRep.findAll();
		for(Users u:ul){
			System.out.println(u.getName());
		}
		return ul;

	}
	
	
	

}
