package com.hugo;

import com.hugo.Model.User;
import com.hugo.Repository.UserRepository;
import com.hugo.Service.UserService;

import java.io.IOException;

import static com.hugo.Utils.MenuUtils.*;

public class Main {
    public static void main(String[] args) throws IOException {

        UserService userService = new UserService(new UserRepository());
        boolean on = true;

        while(on){

            switch (mainMenu()){
                case 1:
                    userService.saveUser(getUserToSave());
                    System.out.println("Usuário Cadastrado!");
                    System.out.println("");
                    break;
                case 2:
                    userService.deleteUserById(getUserIdToDelete());
                    System.out.println("Usuário deletado!");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    for(User user:userService.getAllUsers()){
                        System.out.println(user);
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Obrigado por usar o sistema.");
                    on = false;
            }

        }


    }
}