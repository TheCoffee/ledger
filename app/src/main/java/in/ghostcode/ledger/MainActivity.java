package in.ghostcode.ledger;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Expense> expenses = new ArrayList<>();
    RecyclerViewExpenseAdapter adapter;
    private Spinner expenseType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView)
                findViewById(R.id.expenses_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        expenses.add(new Expense(1, "Bus", "Travel", "2/10/16", "18"));
        adapter = new RecyclerViewExpenseAdapter(expenses);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_add_expense, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Enter Expense");
                builder.setView(dialogView);

                final EditText expenseTitle = (EditText) dialogView.findViewById(R.id.expense_title);
                final EditText expenseAmount = (EditText) dialogView.findViewById(R.id.expense_amount);
                final DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker);
                expenseType = (Spinner) dialogView.findViewById(R.id.expense_spinner);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String title = expenseTitle.getText().toString();
                        String amount = expenseAmount.getText().toString();
                        String date = datePicker.getDayOfMonth() + "/" +
                                datePicker.getMonth() + "/" +
                                datePicker.getYear();
                        String eType= expenseType.getSelectedItem().toString();

                        String[] expenseTypes= getResources().getStringArray(R.array.expense_types);
                        if (!eType.equals(expenseTypes[0]) && !title.equals("") && !amount.equals("")) {
                            Expense expense = new Expense(title, eType, date, amount);
                            expenses.add(expense);
                            adapter.notifyDataSetChanged();
                        }


                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
