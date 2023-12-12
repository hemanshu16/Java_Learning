package com.rest.webservices.restfulwebservices.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserResource {

		private UserDaoService userDaoService;
		
		public UserResource(UserDaoService userDaoService) {
			super();
		
			this.userDaoService = userDaoService;
		}
		
		@GetMapping(path="/users")
		public List<User> getAllUsers()
		{
			return userDaoService.findAll();
		}
		
		
		@GetMapping(path="/users/{id}")
		public EntityModel<User> getSpecificUser(@PathVariable int id)
		{
		     User user = userDaoService.findOne(id);
		     if(user == null)
		     {
		    	 throw new UserNotFoundException("id :- " + id);
		     }
		     EntityModel<User> entityUser = EntityModel.of(user);
		     WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		     entityUser.add(link.withRel("users")); 
		     return entityUser;
		}
		@PostMapping(path="/users")
		public ResponseEntity<User> CreateUser(@Valid @RequestBody User  user)
		{
			User saveduser = userDaoService.save(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(saveduser.getId())
							.toUri();
			return ResponseEntity.created(location).build();
		}
		
		@DeleteMapping(path="/users/{id}")
		public void deleteUser(@PathVariable int id)
		{
			userDaoService.deleteById(id);
		}
}
