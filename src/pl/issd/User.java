package pl.issd;

public class User {

    private String logIn = "";
    private String firstName;
    private String lastName;
    private String age;
    private String password;
    private double accountBalance = 0;

    private User() {}

    public User(String logIn,String firstName, String lastName, String age, String password) {
        this.logIn = logIn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    public String GetLogin(){
        return this.logIn;
    }

    public boolean ComparePassword(String password){
        return this.password.equals(password);
    }

    public String GetName(){
        return this.firstName;
    }

    public int PayIn(double moneyAmmount){

        this.accountBalance += moneyAmmount;
        return 0;
    }

    public int PayOut(double moneyAmmount){

        this.accountBalance -= moneyAmmount;
        return 0;
    }

    public double ChceckAccountBalance(){
        return this.accountBalance;
    }

    public int Logout(){

        //Logout method declaration

        return 0;
    }

    public int ChangePassword(String oldPassword, String newPassword){

        //Change Password method declaration

        return 0;
    }

}
