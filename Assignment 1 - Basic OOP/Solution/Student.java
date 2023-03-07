public class Student extends Accounts {

    public Student(String name, String type, double initialDeposit) {
        super(name, type, initialDeposit);
    }


    public boolean Withdraw(double money){
        double deposit = GetDeposit();
        if(money > 10000 || (deposit-money) < 0)
            return false;
        deposit -= money;
        SetDeposit(deposit);
        return true;
    }


}
