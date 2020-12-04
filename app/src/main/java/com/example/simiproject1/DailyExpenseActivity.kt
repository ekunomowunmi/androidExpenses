package com.example.simiproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simiproject1.adapter.ExpenseAdapter
import com.example.simiproject1.data.DataSource
import com.example.simiproject1.model.Expense
import kotlinx.android.synthetic.main.activity_daily_expense.*
import kotlinx.android.synthetic.main.activity_expenses.*

class DailyExpenseActivity : AppCompatActivity() {
    var data = mutableListOf<Expense>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        var expense = listOf<String>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_expense)
        var extras = getIntent().extras
        var valueExtra = ""
        if(extras != null){
            valueExtra = extras.getString("TOTAL_INCOME").toString()
        }
        new_expense.setOnClickListener {
            if (description_input.text.isNotEmpty() && amount_input.text.isNotBlank()) {
                var desc = description_input.text.toString()
                var amt = amount_input.text.toString()

                var intent = Intent(this, ExpensesActivity::class.java)
                intent.putExtra("DESCRIPTION",desc)
                intent.putExtra("AMOUNT",amt)
                intent.putExtra("TOTAL_INCOME",valueExtra)

//                var ex = Expense(desc, amt.toInt())
//                data.add(ex)
//                DataSource().addExpense(ex)
                startActivity(intent)
            }
        }
        view_expenses.setOnClickListener {
            var i = Intent(this, ExpensesActivity::class.java)
            startActivity(i)
        }

//        var ex: RecyclerView = findViewById(R.id.expense_list)
//        ex.layoutManager = LinearLayoutManager(this)
//        ex.adapter = ExpenseAdapter(this, data)

//        var intent = Intent(this, ExpensesActivity::class.java)
//        intent.putExtra("TOTAL_INCOME",income)
//        startActivity(intent)


    }

    private fun addExpense(){
        var description = R.id.description_input.toString()
        var amount = R.id.amount_input.toString().toDoubleOrNull()
        var expense = listOf(description,amount)
//        return expense
    }
}