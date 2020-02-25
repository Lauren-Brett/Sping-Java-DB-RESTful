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

        Folder folder2 = new Folder("Life Admin", user1);
        folderRepository.save(folder2);

        File file1 = new File("code", "xml", 6, folder1);
        fileRepository.save(file1);

        File file2 = new File("test", "html", 8, folder1);
        fileRepository.save(file2);

        File file3 = new File("notes", "doc", 4, folder2);
        fileRepository.save(file3);

        user1.addFolder(folder1);
        user1.addFolder(folder2);
        userRepository.save(user1);

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);
        folderRepository.save(folder1);
        folderRepository.save(folder2);





    }

}
