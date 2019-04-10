package pl.issd;

import java.util.Scanner;


public class UserPanel {

    User currentUser = null;
    Boolean logOutFlag = false;


    public UserPanel(User user) {
        this.currentUser = user;
        WelcomeScreen();
    }

    public void WelcomeScreen(){
        System.out.println("\n Nice to see you "+currentUser.GetName()+" !");
        UserFunctions();
    }

    private void UserFunctions(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nCJ-Bank: How can I help you?\n");
        while(true){
            System.out.println("1. Store some money.");
            System.out.println("2. Withdraw some money.");
            System.out.println("3. Check balance.");
            System.out.println("4. Change password.");
            System.out.println("5. Log out.");


            String number = in.nextLine();

            switch (number){
                case "1" :
                case "1.":
                    PayIn();
                    break;
                case "2":
                case "2.":
                    Widthdraw();
                    break;
                case "3":
                case "3.":
                    CheckBalance();
                    break;
                case "4":
                case "4.":
                    ChangePassword();
                    break;
                case "5":
                case "5.":
                    Logout();
                    break;
                default:
                    System.out.println("Unknown command! Please try again");
            }

            if (logOutFlag){
                logOutFlag = false;
                break;
            }
        }
    }

    private void PayIn(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nGood goblin is smiling...\n");
        System.out.println("How much money do you want to store? Current balance is: " + currentUser.ChceckAccountBalance()+" gold \n");
        Double money = in.nextDouble();
        if (money == 0.0){
            System.out.println("Your balance is still the same, anyway, do you need something else?\n");
        }else{
            currentUser.PayIn(money);
            System.out.println("Your current balance is now: "+currentUser.ChceckAccountBalance()+"\n");
        }
    }

    private void Widthdraw(){
        Scanner in = new Scanner(System.in);
        Double currentBalance = currentUser.ChceckAccountBalance();
        System.out.println("One of the goblins went for your sack of money...");
        System.out.println("How much money would you like to withdraw? Current balance is: " + currentBalance +" gold\n");
        Double money = in.nextDouble();
        if (currentBalance - money < 0){
            System.out.println("Oh sh*t man! Are you trying to rob us?! We don't give loans to critters like you!");
            System.out.println("Anyway, nice try fella... \n");
        } else{
            currentUser.PayOut(money);
            System.out.println("\n Here you are! Don't spend it on girls and stupid things! \n Your current balance is: "+currentUser.ChceckAccountBalance());
        }
        System.out.println("\n Do you need anything else?");
    }

    private void CheckBalance(){
        Double currentBalance = currentUser.ChceckAccountBalance();
        System.out.println("Your current balance is: "+currentBalance);
        System.out.println("\n Do you need anything else?");
    }

    private void ChangePassword(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter current password: ");
        String currentPassword = in.nextLine();
        if (currentUser.ComparePassword(currentPassword)){
            System.out.println("Please enter new password: ");
            String newPassword = in.nextLine();
            currentUser.ChangePassword(newPassword);
            System.out.println("Password changed succesfully.");
        }else {
            System.out.println("Password does not match, please try again later...");
        }
    }

    private void Logout(){
        System.out.println("Logging out...");
        currentUser = null;
        logOutFlag = true;
    }

}
