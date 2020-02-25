package com.codeclan.example.Folders.components;

import com.codeclan.example.Folders.models.File;
import com.codeclan.example.Folders.models.Folder;
import com.codeclan.example.Folders.models.User;
import com.codeclan.example.Folders.repositories.FileRepository;
import com.codeclan.example.Folders.repositories.FolderRepository;
import com.codeclan.example.Folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User user1 = new User("Dolly");
        userRepository.save(user1);

        Folder folder1 = new Folder("Codeclan", user1);
        folderRepository.save(folder1);

        File file1 = new File("code", "xml", 6, folder1);


    }

}
