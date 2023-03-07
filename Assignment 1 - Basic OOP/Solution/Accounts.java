public class Accounts {
    private String name;
    private String accountType;
    private double deposit;
    private int year;
    private double loan;
    private double serviceCharge;
    private double loanInterest;

    public Accounts(String name, String type, double initialDeposit){
        this.name = name;
        this.accountType = type;
        this.deposit = initialDeposit;
        this.year = 0;
        this.loan = 0;
        this.serviceCharge = 500;
        this.loanInterest = 10;

    }

    public boolean Deposit(double money){
        deposit += money;
        return true;
    }

    public boolean Withdraw(double money){
        return true;
    }


    public double GetDeposit(){
        return deposit;
    }

    public double GetLoan(){
        return loan;
    }

    public String GetType(){
        return accountType;
    }

    public String GetName(){
        return name;
    }

    public int GetYear(){
        return year;
    }

    public void SetDeposit(double money){
        deposit = money;
    }

    public void SetLoan(double money){
        loan = money;
    }



    public void INC(double interest){
        double totalInterest = (deposit*interest)/100;
        double totalLoanInterest = (loan*loanInterest)/100;

        deposit = deposit+totalInterest-totalLoanInterest;
        year++;
        if(accountType.equals("Student")) return;

        deposit -= serviceCharge;

    }



}
