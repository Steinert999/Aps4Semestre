package br.com.ies.candyShop.services;

import java.util.List;

import br.com.ies.candyShop.dto.UserDTO;
import br.com.ies.candyShop.utils.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ies.candyShop.entity.User;
import br.com.ies.candyShop.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    UserRepository usersRepository;

    public User findUserById(Long id){
        return usersRepository.getOne(id);
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public void save(User user) {
        usersRepository.save(user);
    }

    public Long countUsers() {
        return usersRepository.count();
    }

    public boolean exists(Example<User> userExample) {
        if(usersRepository.exists(userExample)) {
            return true;
        }
        return false;
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

    public void deleteProduto(User user) {
        usersRepository.delete(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = usersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado com usuario ou Email utilizado :" + usernameOrEmail));
                return UserDTO.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id){
        User user = usersRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User", "id", id));
        return UserDTO.create(user);
    }
}
