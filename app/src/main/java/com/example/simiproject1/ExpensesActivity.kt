package com.example.simiproject1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simiproject1.adapter.ExpenseAdapter
import com.example.simiproject1.data.DataSource
import com.example.simiproject1.databinding.ActivityExpensesBinding
import com.example.simiproject1.model.Expense
import kotlinx.android.synthetic.main.activity_expenses.*

class ExpensesActivity() : AppCompatActivity() {
    private lateinit var binding:ActivityExpensesBinding
    private var data = mutableListOf<Expense>()
    var description: String = ""
    var amount: String = ""
    var fromAdd:Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpensesBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_expenses)
//        setContentView(binding.root)
//        var num = income
        var extras = getIntent().extras
        var valueExtra = ""
       var description:String
        var amount:String
        if(extras != null){
            valueExtra = extras.getString("TOTAL_INCOME").toString()
             description = extras.getString("DESCRIPTION").toString()
             amount = extras.getString("AMOUNT").toString()
            if(description !== "null" && amount !== "null"){
                description = extras.getString("DESCRIPTION").toString()
                amount = extras.getString("AMOUNT").toString()
                fromAdd = true
//                valueExtra = extras.getString("TOTAL_INCOME").toString()
                var ex = Expense(description!!, amount!!.toInt())
//                data.add(ex)
                data = DataSource().addExpense(ex)
            } else {

            }

        } else {

        }

        income_on_expense.text = valueExtra.toString()
        balance.text = (getBalance(valueExtra)).toString()
        add_expense.setOnClickListener {
            var i = Intent(this, DailyExpenseActivity::class.java)
            i.putExtra("TOTAL_INCOME",valueExtra)
            startActivity(i)
        }
        if(fromAdd == false){
            data = DataSource().loadExpenses()
        }



//        expense_list.adapter = ExpenseAdapter(this, data)
//        expense_list.setHasFixedSize(true)
        var ex: RecyclerView = findViewById(R.id.expense_list)
        ex.layoutManager = LinearLayoutManager(this)
        ex.adapter = ExpenseAdapter(this, data)
//        setContentView(binding.root)
    }

    private fun getBalance(income: String):Int{
        var incomez = income.toInt()
        var data = DataSource().loadExpenses()
        var totalExpense = 0
        var incomeValue = 0
        for (datum in data){
            totalExpense+= datum.amount
        }
        if(incomez !== null){
             incomeValue = incomez
        }
        return incomeValue - totalExpense
    }
}