package Daily_Problem.2025.10;

public class 26_2043_SimpleBankSystem {
    long[] arr;
    int n;
    public Bank(long[] balance) {
        n = balance.length;
        this.arr = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if(account1 < n && account2 < n && arr[account1] >= money) {
            arr[account1] -= money;
            arr[account2] += money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        account--;
        if(account < n) {
            arr[account] += money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        account--;
        if(account < n && arr[account] >= money) {
            arr[account] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */