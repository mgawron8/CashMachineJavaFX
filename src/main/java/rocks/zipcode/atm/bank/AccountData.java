package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public final class AccountData {

    private final int id;
    private final String name;
    private final String email;

    private final Float balance;

    AccountData(int id, String name, String email, Float balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        if(balance < 0){
            return "ACCOUNT IS OVERDRAWN!" + '\n' +
                    "Account id: " + id + '\n' +
                    "Name: " + name + '\n' +
                    "Email: " + email + '\n' +
                    "Balance: " + balance;
        }else {
            return "Account id: " + id + '\n' +
                    "Name: " + name + '\n' +
                    "Email: " + email + '\n' +
                    "Balance: " + balance;
        }
    }
}
