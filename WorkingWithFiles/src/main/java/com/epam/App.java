package com.epam;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException, IOException {


        User user = User.builder()
                .name("sasi")
                .address("vzm")
                .grade(9.5)
                .isActive(true)
                .salary(100000)
                .build();

        User user2 = User.builder()
                .name("vamsi")
                .address("vzm")
                .grade(9.5)
                .isActive(true)
                .salary(100000)
                .build();

        Customer customer = Customer.builder()
                .name("Vamsi")
                .mail("vamsi@gmail.com").build();

        List<User> users = new ArrayList<>(Arrays.asList(user,user2));

//
//        try (ObjectInputStream obs = new ObjectInputStream(new FileInputStream("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"))){
//
//            List<User> usersList = (List<User>) obs.readObject();
//            System.out.println(usersList);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"));
//            ObjectInputStream obs = new ObjectInputStream(bis)
//        ) {
//            List<User> usersList = (List<User>) obs.readObject();
//            System.out.println(usersList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        //this is to get reference of the file
        //Path file = Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop").resolve("git-link.txt");
        //Path file = Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\git-link.txt");
        //Path file = Paths.get("C://Users//Shasank_Gadipilli//Desktop//git-link.txt");
        //Path file = Path.of("C://Users//Shasank_Gadipilli//Desktop//git-link.txt");
        //Path file = Path.of("C","Users","Shasank_Gadipilli","Desktop").resolve("git-link.txt");

        //common file operations

//        Path path = Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\git-link.txt");
//
//        //check whether file exists or not.
//        System.out.println(Files.exists(path));
//
//        //to check last modified time of the file
//        System.out.println(Files.getLastModifiedTime(path));
//
//        //comparing two files
//        System.out.println(Files.mismatch(path,Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\git-link.txt")));


        //creating temp files and directories

//        Path path1 = Files.createTempFile(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop"),"sasi",".jpg");
//        System.out.println(Files.exists(path1));
//
//        Path path2 = Files.createTempDirectory(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop"),"sasi");
//        System.out.println(Files.exists(path2));
//        Path path3 = Files.createTempDirectory("sasi");
//        System.out.println(path3);

        //creating files and directories
//        Path files = Files.createFile(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"));
//        System.out.println(files);

//        Path directories = Files.createDirectories(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\sasi"));
//        System.out.println(Files.exists(directories));


        //creating file and write string and read string from file.


        //Path paths = Files.createFile(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"));
//        Files.writeString(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"), "This is sample text.\nthis is shasank", StandardOpenOption.APPEND);
//
//        String str = Files.readString(Path.of("C:\\Users\\Shasank_Gadipilli\\Desktop\\shasank.txt"));
//        System.out.println(str);


    }
}
