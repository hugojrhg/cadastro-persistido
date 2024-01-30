package com.hugo.Utils;

import com.hugo.Model.User;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileUtils {

    public File directory = new File("C:\\CursoJAVA\\Workspace\\cadastro-persistido");
    public File file = new File(directory, "UserRepository.txt");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    public FileUtils() throws FileNotFoundException {
    }

    public void createNewFile() throws IOException {

        directory.mkdir();
        if(file.exists()){
            System.out.println("Arquivo já existe");
        }else{
            try {
                file.createNewFile();
                System.out.println("Arquivo criado e pronto para uso");
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }

    public void readFile() throws IOException {
        Set<User> users = transformStringListToUserSet(getUserInFileAsList());
        for (User user:users){
            System.out.println(user.toString());
        }
    }

    public List<String> getUserInFileAsList() throws IOException {

        List<String> usersInFileList = new ArrayList<>();
        String line = "";

        while ((line = bufferedReader.readLine()) != null){
            if (line != null & !line.isEmpty()){
                usersInFileList.add(line);
            }
        }

        fileReader.close();
        bufferedReader.close();
        return usersInFileList;

    }

    public Set<User> transformStringListToUserSet(List<String> usersList) {

        Set<User> users = new HashSet<>();

        for (String userFromList:usersList){
            String[] userArray = userFromList.split(",");

            User user = new User();
            user.setId(Long.valueOf(userArray[0]));
            user.setFullName(userArray[1]);
            user.setAge(Integer.valueOf(userArray[2]));
            user.setJob(userArray[3]);

            users.add(user);
        }

        return users;
    }

}
