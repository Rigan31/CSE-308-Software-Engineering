import java.util.Set;

public class Fixed extends Accounts {

    public Fixed(String name, String type, double initialDeposit) {
        super(name, type, initialDeposit);
    }

    public boolean Deposit(double money){
        double deposit = GetDeposit();
        if(money < 50000)
            return false;
        deposit += money;
        SetDeposit(deposit);
        return true;
    }
    public boolean Withdraw(double money){
        int year = GetYear();
        double deposit = GetDeposit();
        if(year == 0 || (deposit-money) < 0)
            return false;
        deposit -= money;
        SetDeposit(deposit);
        return true;
    }
}
