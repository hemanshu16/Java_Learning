package com.rest.webservices.restfulwebservices.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

		private UserRepository repository;
		private PostRepository postRepository;
		public UserJpaResource(UserRepository repository,PostRepository postRepository) {
			super();
		
			this.repository = repository;
			this.postRepository = postRepository;
		}
		
		@GetMapping(path="/jpa/users")
		public List<User> getAllUsers()
		{
			return repository.findAll();
		}
		
		
		@GetMapping(path="/jpa/users/{id}")
		public EntityModel<User> getSpecificUser(@PathVariable int id)
		{
		    Optional<User> user = repository.findById(id);
		     if(user.isEmpty())
		     {
		    	 throw new UserNotFoundException("id :- " + id);
		     }
		     EntityModel<User> entityUser = EntityModel.of(user.get());
		     WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		     entityUser.add(link.withRel("users")); 
		     return entityUser;
		}
		@PostMapping(path="/jpa/users")
		public ResponseEntity<User> CreateUser(@Valid @RequestBody User  user)
		{
			User saveduser = repository.save(user);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(saveduser.getId())
							.toUri();
			return ResponseEntity.created(location).build();
		}
		
		@DeleteMapping(path="/jpa/users/{id}")
		public void deleteUser(@PathVariable int id)
		{
			repository.deleteById(id);
		}
		
		@GetMapping(path="/jpa/users/{id}/posts")
		public List<Post> getALLUser(@PathVariable int id)
		{
			Optional<User> user = repository.findById(id);
			if(user.isEmpty())
			{
				throw new UserNotFoundException("id :- " + id);
			}
			return user.get().getPosts();
		}
		
		@PostMapping(path="/jpa/users/{id}/posts")
		public ResponseEntity<Post> createNewPost(@PathVariable int id,@Valid @RequestBody Post post)
		{
			Optional<User> user = repository.findById(id);
			if(user.isEmpty())
			{
				throw new UserNotFoundException("id :- " + id);
			}
			post.setUser(user.get());
			Post savedpost = postRepository.save(post);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedpost.getId())
					.toUri();
			return ResponseEntity.created(location).build();
			
		}
}
