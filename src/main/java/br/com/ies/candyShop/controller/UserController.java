package br.com.ies.candyShop.controller;

import br.com.ies.candyShop.dto.UserDTO;
import br.com.ies.candyShop.entity.User;
import br.com.ies.candyShop.repository.ProdutoRepository;
import br.com.ies.candyShop.repository.UserRepository;
import br.com.ies.candyShop.utils.Anotations.CurrentUser;
import br.com.ies.candyShop.utils.exceptions.ResourceNotFoundException;
import br.com.ies.candyShop.utils.payloads.UserIdentityAvailability;
import br.com.ies.candyShop.utils.payloads.UserProfile;
import br.com.ies.candyShop.utils.payloads.UserSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserDTO currentUser){
        return new UserSummary(currentUser.getId(), currentUser.getUsername(),currentUser.getName());
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username){
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email){
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());
    }




}
