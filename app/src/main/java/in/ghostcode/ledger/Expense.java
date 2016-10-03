package in.ghostcode.ledger;

/**
 * Created by Coffee on 10/2/16.
 */

public class Expense {
    private int id;
    private String title, expenseType, date, amount;

    public Expense() {
    }

    public Expense(String title, String expenseType, String date, String amount) {
        this.title = title;
        this.expenseType = expenseType;
        this.date = date;
        this.amount = amount;
    }

    public Expense(int id, String title, String expenseType, String date, String amount) {
        this.id = id;
        this.title = title;
        this.expenseType = expenseType;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
