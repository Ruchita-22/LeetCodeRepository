class Bank {
    Map<Integer, Long> bank = null;

    public Bank(long[] balance) {
        bank = new HashMap();
        for(int i = 1; i <= balance.length; i++){
            bank.put(i,balance[i-1]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!bank.containsKey(account1) || !bank.containsKey(account2))  return false;
        if(bank.get(account1) < money)  return false;
        bank.put(account1, bank.get(account1) - money);
        bank.put(account2, bank.get(account2) + money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!bank.containsKey(account))  return false;
        bank.put(account, bank.get(account) + money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!bank.containsKey(account))  return false;
        if(bank.get(account) < money)  return false;
        bank.put(account, bank.get(account) - money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */