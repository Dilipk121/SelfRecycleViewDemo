package com.example.selfrecycleviewdemo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikhaellopez.circularimageview.CircularImageView

class EmployeeAdapter(val context: Activity, val empArrayList: ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.empViewHolder>() {

        private lateinit var myListner : onItemClickListner

        interface onItemClickListner{

            fun onItemClick(position: Int)

        }

    fun setItemClickListner(listner: onItemClickListner){

        myListner = listner

    }

    inner class empViewHolder(itemView: View,listner: onItemClickListner) : RecyclerView.ViewHolder(itemView) {

        val emp_circular_image = itemView.findViewById<CircularImageView>(R.id.circularImageView)
        val emp_name_data = itemView.findViewById<TextView>(R.id.emp_name)
        val emp_email_data = itemView.findViewById<TextView>(R.id.emp_email)


        init {

        itemView.setOnClickListener {
            listner.onItemClick(adapterPosition) // pass getAdapterPosition...its pre defined
        }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): empViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.emp_list_view, parent, false)

        return empViewHolder(view,myListner) // return should be must
    }

    override fun getItemCount(): Int {
        return empArrayList.size
    }

    override fun onBindViewHolder(holder: empViewHolder, position: Int) {

        val currentItems = empArrayList[position]

        holder.emp_circular_image.setImageResource(currentItems.empImage)
        holder.emp_name_data.text = currentItems.empName
        holder.emp_email_data.text = currentItems.empEmail

    }


}