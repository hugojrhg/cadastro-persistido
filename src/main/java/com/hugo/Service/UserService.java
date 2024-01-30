package com.hugo.Service;

import com.hugo.Model.User;
import com.hugo.Repository.UserRepository;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) throws IOException {
        this.userRepo = userRepo;
    }

    public void saveUser(User user) throws IOException {

        if(userRepo.getUserRepository().contains(user)){
            System.out.println("Já existe um usuário com esse id");
        }else{
            userRepo.save(user);
        }

    }

    public void deleteUserById(Long id) throws IOException {

        User userToDelete = new User(id, null, 0, null);

        try{
            for(User user:userRepo.getUserRepository()){
                if(user.equals(userToDelete)){
                    userRepo.delete(user);
                    break;
                }
            }
        }catch (ConcurrentModificationException ex){
            ex.printStackTrace();
        }

    }

    public Set<User> getAllUsers() throws IOException {
        if (userRepo.getUserRepository().isEmpty()){
            System.out.println("Nenhum usuário cadastrado");
        }
        return userRepo.getUserRepository();
    }

}
