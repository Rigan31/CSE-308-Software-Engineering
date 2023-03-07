import java.util.ArrayList;
import java.util.HashMap;

class LoanClass{
    Accounts user;
    double loanMoney;
    char status;

    public LoanClass(Accounts u, double money){
        user = u;
        loanMoney = money;
        status = 'P';
    }
    public void SetStatus(char s){
        status = s;
    }
    public Accounts GetAccount(){
        return user;
    }
    public char GetStatus(){
        return status;
    }
    public double GetLoanMoney(){
        return loanMoney;
    }
}


public class Bank {
    private double savingsInterest;
    private double studentInterest;
    private double fixedInterest;
    HashMap<String, Accounts> accounts;
    HashMap<String, Employees> employees;
    double internalFund;
    ArrayList<LoanClass> loanlist;

    public Bank(double initialFund){
        internalFund = initialFund;
        accounts = new HashMap<>();
        employees = new HashMap<>();
        savingsInterest = 10;
        studentInterest = 5;
        fixedInterest = 15;
        loanlist = new ArrayList<>();

    }

    public boolean CreateAccount(String name, String type, double initialDeposit){
        if(accounts.get(name) != null){
            System.out.println("The username is already taken");
            return false;
        }

        Accounts newAccount;
        if(type.equals("Student")){
            newAccount = new Student(name, type, initialDeposit);
        }
        else if(type.equals("Savings")){
            newAccount = new Savings(name, type, initialDeposit);
        }
        else{
            if(initialDeposit < 100000){
                System.out.println("The initial deposit must be greater than 100000");
                return false;
            }
            newAccount = new Fixed(name, type, initialDeposit);
        }

        accounts.put(name, newAccount);
        System.out.println(type+" account for "+name+" Created; initial balance "+initialDeposit+"$");
        return true;

    }

    public void AccountDeposit(String name, double money){
        Accounts tmp = accounts.get(name);
        if(tmp == null){
            System.out.println("There is no account by this name");
            return;
        }
        boolean mm = tmp.Deposit(money);
        double currBalance = tmp.GetDeposit();
        if(mm){
            System.out.print(money+"$ deposited;");
        }
        else{
            System.out.print("Invalid transaction;");
        }

        System.out.println("current balance "+currBalance+"$");
    }

    public void AccountWithdraw(String name, double money){
        Accounts tmp = accounts.get(name);
        boolean mm = tmp.Withdraw(money);
        double currBalance = tmp.GetDeposit();

        if(mm){
            System.out.print(money+"$ withdrawn;");
        }
        else{
            System.out.print("Invalid transaction;");
        }

        System.out.println("current balance "+currBalance+"$");
    }

    public void RequestLoan(String name, double money){
        Accounts tmp = accounts.get(name);
        LoanClass newLoan = new LoanClass(tmp, money);
        loanlist.add(newLoan);
        System.out.println("Loan request successful, sent for approval");
    }

    public void AccountQuery(String name){
        Accounts tmp = accounts.get(name);
        double currBalance = tmp.GetDeposit();
        double loan = tmp.GetLoan();
        System.out.print("Current balance "+ currBalance+"$");
        if(loan != 0)
            System.out.print(", loan "+loan+"$");

        System.out.println();
    }

    public boolean HaveAccount(String name){
        Accounts tmp = accounts.get(name);
        if(tmp == null) return false;
        else return true;
    }


    public void CreateEmployee(String name, String type){
        Employees newEmployee = new Employees(name, type);
        employees.put(name, newEmployee);
    }

    public void LookupAccount(String accountName){
        Accounts tmp = accounts.get(accountName);
        if(tmp == null){
            System.out.println("There is no account by this name");
        }
        else{
            double currBalance = tmp.GetDeposit();
            System.out.print(accountName+"'s current balance "+ currBalance+"$");
            double loan = tmp.GetLoan();
            if(loan != 0){
                System.out.print(", loan "+loan+"$");
            }
            System.out.println();
        }
    }

    public boolean IsLoanList(String name){
        Employees tmp = employees.get(name);
        String type = tmp.GetType();
        if(type.equals("Cashier")) return false;

        for(LoanClass l: loanlist){
            if(l.status == 'P') return true;
        }
        return false;
    }

    public void ApproveLoan(String name){
        Employees tmp = employees.get(name);
        String empType = tmp.GetType();

        if(empType.equals("Cashier")){
            System.out.println("You don’t have permission for this operation");
        }
        else{
            for(LoanClass l : loanlist){
                Accounts user = l.GetAccount();
                String type = user.GetType();
                double loanMoney = l.GetLoanMoney();

                if(l.GetStatus() == 'P'){
                    double maxLoan = 0;
                    if(type.equals("Student")) maxLoan = 1000;
                    else if(type.equals("Savings")) maxLoan = 10000;
                    else maxLoan = 100000;


                    if(internalFund-loanMoney < 0){
                        l.SetStatus('C');
                        System.out.println("Loan for "+ user.GetName()+ " disapproved");
                    }
                    else if(loanMoney > maxLoan){
                        l.SetStatus('C');
                        System.out.println("Loan for "+ user.GetName()+ " disapproved");
                    }
                    else{
                        l.SetStatus('A');
                        System.out.println("Loan for " +user.GetName()+ " approved");

                        double deposit = user.GetDeposit();
                        deposit += loanMoney;
                        user.SetDeposit(deposit);
                        double loan = user.GetLoan();
                        loan += loanMoney;
                        user.SetLoan(loan);
                        internalFund -= loanMoney;
                    }
                }
            }
        }
    }

    public void ChangeInterestRate(String name, String accType, double newInterest){
        Employees tmp = employees.get(name);
        String empType = tmp.GetType();
        if(empType.equals("Director")){
            if(accType.equals("Student")) studentInterest = newInterest;
            else if(accType.equals("Fixed")) fixedInterest = newInterest;
            else savingsInterest = newInterest;

            System.out.println("The new interest of "+accType+" type account is "+newInterest);
        }
        else{
            System.out.println("You don’t have permission for this operation");
        }

    }

    public void SeeInternalFund(String name){
        Employees tmp = employees.get(name);
        String empType = tmp.GetType();
        if(empType.equals("Director")){
            System.out.println("Internal Fund is "+internalFund+"$");
        }
        else{
            System.out.println("You don’t have permission for this operation");
        }
    }



    public void OneYear(){
        for(Accounts a: accounts.values()){
            double tmpInterest = 0;
            if(a.GetType().equals("Student")) tmpInterest = studentInterest;
            else if(a.GetType().equals("Fixed")) tmpInterest = fixedInterest;
            else tmpInterest = savingsInterest;

            a.INC(tmpInterest);
        }

        System.out.println("1 year passed");
    }
}
