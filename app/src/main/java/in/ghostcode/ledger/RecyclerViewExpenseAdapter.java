package in.ghostcode.ledger;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Coffee on 10/2/16.
 */

public class RecyclerViewExpenseAdapter extends RecyclerView.Adapter<RecyclerViewExpenseAdapter.ViewHolder> {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public RecyclerViewExpenseAdapter(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public RecyclerViewExpenseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewExpenseAdapter.ViewHolder holder, int position) {
        Expense expense = expenses.get(position);
        holder.titleView.setText(expense.getTitle());
        holder.expenseTypeView.setText(expense.getExpenseType());
        holder.amountView.setText(expense.getAmount());
        holder.dateView.setText(expense.getDate());
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleView, expenseTypeView, dateView, amountView;
        public ViewHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.expense_title);
            expenseTypeView = (TextView) itemView.findViewById(R.id.expense_type);
            dateView = (TextView) itemView.findViewById(R.id.expense_date);
            amountView = (TextView) itemView.findViewById(R.id.expense_amount);
        }
    }
}
