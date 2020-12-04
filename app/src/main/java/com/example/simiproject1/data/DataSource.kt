package com.example.simiproject1.data

import com.example.simiproject1.R
import com.example.simiproject1.model.Expense

class DataSource {
    var publicExpenses = mutableListOf<Expense>()
    fun loadExpenses() :MutableList<Expense>{
        val expenses = mutableListOf<Expense>(
            Expense("Food",1000),
            Expense("Transport", 2000),
            Expense("Bills", 3000),
            Expense("Tithes", 4000),
            Expense("Family", 7000)
        )
         publicExpenses.addAll(expenses)
        return publicExpenses
    }

    fun addExpense(newExpense:Expense):MutableList<Expense>{
        loadExpenses()
        publicExpenses.add(newExpense)
        return publicExpenses
//        loadExpenses()
    }
}