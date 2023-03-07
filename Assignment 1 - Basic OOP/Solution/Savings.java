public class Savings extends Accounts {

    public Savings(String name, String type, double initialDeposit) {
        super(name, type, initialDeposit);
    }

    public boolean Withdraw(double money){
        double deposit = GetDeposit();
        if((deposit-money)< 1000)
            return false;
        deposit -= money;
        SetDeposit(deposit);
        return true;
    }
}
