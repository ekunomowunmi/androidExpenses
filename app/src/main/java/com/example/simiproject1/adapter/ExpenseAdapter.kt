package com.example.simiproject1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simiproject1.ExpensesActivity
import com.example.simiproject1.R
import com.example.simiproject1.model.Expense

//import com.example.affirmations.model.Affirmation
//import kotlinx.android.synthetic.main.list_item.view.*

class ExpenseAdapter(private val context: Context, private val items:List<Expense>)
    :RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ExpenseViewHolder(adapterLayout)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val item = items[position]
        holder.desc.text = item.description
        holder.amt.text = item.amount.toString()
//        holder.textView.text =  context.resources.getString(item.stringResourceId)
//        holder.imageView.setImageResource(item.imageResourceId)
    }

    class ExpenseViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        val desc:TextView = view.findViewById<TextView>(R.id.description)
        val amt:TextView = view.findViewById<TextView>(R.id.amount)
    }
}