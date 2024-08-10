import java.util.Scanner;

class atm{
    float Balance;
    int Pin= 1234;

    Scanner sc=new Scanner(System.in);

    public void checkpin(){
        System.out.println("Enter pin: ");
        Scanner sc=new Scanner(System.in);
        int enterpin=sc.nextInt();
        if(enterpin==Pin){
            menu();
        }else{
            System.out.println("Enter a valid pin:");
            checkpin();
        }

    }
    public void menu(){
        System.out.println("Enter your choice:");
        System.out.println("1. check A/C Balance");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Deposite Money");
        System.out.println("4.Change Pin");
        System.out.println("5.EXIT");

        Scanner sc=new Scanner(System.in);
        int opt = sc.nextInt();

        if(opt==1){
            checkBalance();
        }
        else if(opt==2){
            WithDrawMoney();
        }else if(opt==3){
            DepositeMoney();
        }else if(opt==4){
           changePin();
        }else if(opt==5 ){
            return;
        }
        else {
            System.out.println("Enter Valid choice ");
        }


    }

     public void checkBalance(){
        System.out.println("Balance:  "+ Balance);
        menu();

    }
    public void WithDrawMoney(){
        System.out.println("Enter amount to withdraw:");
        Scanner sc=new Scanner(System.in);
        float amount= sc.nextFloat();

        if(amount>Balance){
            System.out.println("Insufficinet Balance");
        }else{
            Balance= Balance-amount;
            System.out.println("Money withdraw Succesfully");
            menu();
        }
    }

    public void DepositeMoney(){
        System.out.println("Enter the amount : ");
        Scanner sc = new Scanner(System.in);
        float amount=sc.nextFloat();
        Balance= Balance + amount;
        System.out.println("Money Deposite  succesfully");
        menu();

    }

    public void changePin(){
        System.out.println("Enter old Pin ");
        Scanner sc= new Scanner(System.in);
        int oldpin= sc.nextInt();

        if(oldpin==Pin){
            System.out.println("Enter New Pin");
            Newpin();
        }else {
            System.out.println("Incorrect Pin");
            changePin();
        }
    }

    public void Newpin(){
        Scanner sc=new Scanner(System.in);
        int pin= sc.nextInt();
        
        int temp = pin;
        pin= Pin;
        Pin=temp;
        checkpin();
     
    }
 }


public class atmmachine {
    public static void main(String[] args) {
        atm obj= new atm();
        obj.checkpin();
    }
    
}
