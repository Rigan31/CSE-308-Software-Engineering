import java.util.Scanner;

public class mainClass {
    public static void Bot(){
        Bank bank = new Bank(1000000);

        // creating employees
        bank.CreateEmployee("MD", "Director");
        bank.CreateEmployee("S1", "Officer");
        bank.CreateEmployee("S2", "Officer");
        bank.CreateEmployee("C1", "Cashier");
        bank.CreateEmployee("C2", "Cashier");
        bank.CreateEmployee("C3", "Cashier");
        bank.CreateEmployee("C4", "Cashier");
        bank.CreateEmployee("C5", "Cashier");

        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");

        Scanner sc = new Scanner(System.in);
        String currUser = null;
        boolean isEmp = false;
        String[] emp = {"MD", "S1", "S2", "C1","C2", "C3", "C4", "C5"};


        while(true) {
            String input = sc.nextLine();
            String[] tokens = input.split(" ");


            if(tokens[0].equals("Open")){
                if(currUser != null){
                    System.out.println("First close your account.");
                    continue;
                }
                String name = tokens[1];
                for(String s : emp){
                    if(name.equals(s))
                        isEmp = true;
                }
                if(isEmp) {
                    System.out.print(name + " active");
                    if (bank.IsLoanList(name)) System.out.println(", there are loan approvals pending");
                    else System.out.println();
                    currUser = name;
                }
                else{
                    if(bank.HaveAccount(name)) {
                        System.out.println("Welcome back, " + name);
                        currUser = name;
                    }
                    else{
                        System.out.println("There is no account by this name");
                        currUser = null;
                    }
                }


            }
            else if(tokens[0].equals("Close")){
                if(isEmp){
                    System.out.println("Operations for "+ currUser +" closed");
                }
                else{
                    System.out.println("Transaction Closed for "+currUser);
                }
                currUser = null;
                isEmp = false;
            }
            else if(tokens[0].equals("Create")){
                boolean mm = bank.CreateAccount(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                if(mm){
                    currUser = tokens[1];
                    isEmp = false;
                }
            }
            else if(tokens[0].equals("Deposit")){
                if(currUser == null){
                    System.out.println("First open your account");
                    continue;
                }
                if(isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.AccountDeposit(currUser, Double.parseDouble(tokens[1]));
            }
            else if(tokens[0].equals("Withdraw")){
                if(currUser == null){
                    System.out.println("First open your account");
                    continue;
                }
                if(isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.AccountWithdraw(currUser, Double.parseDouble(tokens[1]));
            }
            else if(tokens[0].equals("Request")){
                if(currUser == null){
                    System.out.println("First open your account");
                    continue;
                }
                if(isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.RequestLoan(currUser, Double.parseDouble(tokens[1]));
            }
            else if(tokens[0].equals("Query")){
                if(currUser == null){
                    System.out.println("First open your account");
                    continue;
                }
                if(isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.AccountQuery(currUser);
            }
            else if(tokens[0].equals("Lookup")){
                if(!isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                String name = tokens[1];
                bank.LookupAccount(name);

            }
            else if(tokens[0].equals("Approve")){
                if(!isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.ApproveLoan(currUser);
            }
            else if(tokens[0].equals("Change")){
                if(!isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.ChangeInterestRate(currUser, tokens[1], Double.parseDouble(tokens[2]));
            }
            else if(tokens[0].equals("See")){
                if(!isEmp){
                    System.out.println("You don’t have permission for this operation");
                    continue;
                }
                bank.SeeInternalFund(currUser);
            }
            else if(tokens[0].equals("INC")){
                bank.OneYear();
            }
        }

    }


    public static void main(String[] args) {
        Bot();
    }


}