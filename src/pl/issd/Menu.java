package pl.issd;
import java.util.Scanner;
import java.util.*;


public class Menu {

    static Scanner in = new Scanner(System.in);

    static List <User> userList = new ArrayList<>();

    public static void Start(){
        GenerateUsers();

        while(true){
            System.out.println("\nCJ-Bank: Choose option number, then press ENTER.\n");
            System.out.println("1. Login to bank account.");
            System.out.println("2. Create a brand new bank account.");
            String number = in.nextLine();

            switch (number){
                case "1" :
                case "1.":
                    LogIn();
                    break;
                case "2":
                case "2.":
                    Register();
                    break;
                default:
                    System.out.println("Unknown command! Please try again");
            }
        }

    }

    private static void GenerateUsers(){
        User Zbyszek = new User("zbyszek67","Zbyszek","Niedbała","52","xd");
        User Marchew = new User("meff99","Matthew","Prom","16","xd");
        userList.add(Marchew);
        userList.add(Zbyszek);
    }

    private static void LoadUsersFromFile(){

        //Method statement

    }

    private static void LogIn() {
        System.out.println("Logging into system...");
        String login;
        String password;

        System.out.println("\n Login: ");
        login = in.nextLine();
        System.out.println("\n Password: ");
        password = in.nextLine();
        System.out.println("\n Authenticating...");

        for (User user:
             userList) {
            String userLogin = user.GetLogin();
            if (userLogin.equals(login)){
                if (user.ComparePassword(password)){
                    System.out.println("Successfull login");
                    UserPanel session = new UserPanel(user);
                }else{
                    System.out.println("Invalid password");
                }
            }else{
                System.out.println("User has been not found");
            }
        }

    }

    private static void Register(){


        System.out.println("Creating new account...");
        Scanner in = new Scanner(System.in);
        System.out.println("Tell me more about yourself... \n");
        System.out.println("Desired login: \n");
        String login = in.nextLine();
        System.out.println("Your first name: \n");
        String firstName = in.nextLine();
        System.out.println("Your last name: \n");
        String lastName = in.nextLine();
        System.out.println("Your age: \n");
        String age = in.nextLine();
        System.out.println("New password: \n");
        String password = in.nextLine();
        System.out.println("Re-type password: \n");
        String password2 = in.nextLine();


        if (password2.equals(password)){
            User newUser = new User(login,firstName,lastName,age,password);
            userList.add(newUser);
            System.out.println("Congratulations! Now you can work with your brand new account!\n Thank you for trusting us...");
        }else{
            System.out.println("Opps, password don't match... You have to re-type everything else once again - atleast you will learn how to use keyboard :)...");
        }

    }

}
