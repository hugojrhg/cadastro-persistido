package com.hugo.Repository;

import com.hugo.Model.User;
import com.hugo.Utils.FileUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepository {

    FileUtils fileUtils = new FileUtils();
    FileWriter fileWriter = new FileWriter(fileUtils.file, true);

    PrintWriter printWriter = new PrintWriter(fileWriter);

    private Set<User> userRepository = new HashSet<>();

    public UserRepository() throws IOException {
        //FileUtils fileUtils = new FileUtils();
        //fileUtils.createNewFile();
        this.userRepository = findAllUsers();
    }

    public void save(User user) throws IOException {

        userRepository.add(user);
        printWriter.println(user);
        printWriter.flush();
        //printWriter.close();

    }

    public void delete(User user) throws IOException {
        userRepository.remove(user);
        FileWriter fileCleaner = new FileWriter(fileUtils.file, false);
        fileCleaner.write("");
        fileCleaner.close();
        for(User userToWrite:userRepository){
            printWriter.println(userToWrite);
            printWriter.flush();
        }
    }

    public Set<User> findAllUsers() throws IOException {
        List<String> usersInFileAsString;
        usersInFileAsString = fileUtils.getUserInFileAsList();

        return fileUtils.transformStringListToUserSet(usersInFileAsString);
    }

    public Set<User> getUserRepository() {
        return userRepository;
    }
}
