package com.hugo.Utils;

import com.hugo.Model.User;

import java.util.Scanner;

public class MenuUtils {

    static Scanner scan = new Scanner(System.in);

    public static int mainMenu(){
        System.out.println("Bem Vindo ao Cadastro de usuários do Hugo, o que deseja fazer?");
        System.out.println();
        System.out.println("1 - Salvar novo usuário");
        System.out.println("2 - Deletar usuário salvo");
        System.out.println("3 - Ver todos os usuários salvos");
        System.out.println("4 - Sair");

        return scan.nextInt();
    }

    public static User getUserToSave(){
        User user = new User();

        System.out.print("ID: ");
        user.setId(scan.nextLong());
        scan.nextLine();
        System.out.print("Nome Completo: ");
        user.setFullName(scan.nextLine());
        System.out.print("Idade: ");
        user.setAge(Integer.parseInt(scan.nextLine()));
        System.out.print("Emprego: ");
        user.setJob(scan.nextLine());

        return user;
    }


    public static Long getUserIdToDelete(){
        System.out.print("Digite o ID do usuário que deseja deletar: ");
        return scan.nextLong();
    }
}
