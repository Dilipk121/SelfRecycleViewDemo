package com.example.selfrecycleviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var ourRecyclerView: RecyclerView
    lateinit var dataArrayList: ArrayList<Employee>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ourRecyclerView = findViewById(R.id.recyclerView)


        val employee_image = arrayOf(
            R.drawable.g1,
            R.drawable.m1,
            R.drawable.g2,
            R.drawable.m2,
            R.drawable.g3,
            R.drawable.m3,
            R.drawable.g4,
            R.drawable.m4,
            R.drawable.m5,
            R.drawable.m6
        )

        val employee_names = arrayOf(
            "Saumya Singh",
            "Dilip Boss",
            "Radha Kumari",
            "Vishal Khana",
            "Jyoti Jha",
            "Rahul Verma",
            "Harsha Rai",
            "Mukul Aggarwal",
            "Anurag Saini",
            "Varun Malhotra"
        )

        val employee_emails = arrayOf(
            "saumya.singh@gmail.com",
            "dilip.boss@gmail.com",
            "radha.kumari@gmail.com",
            "vishal.khana@gmail.com",
            "jyoti.jha@gmail.com",
            "rahul.verma@gmail.com",
            "harsha.rai@gmail.com",
            "mukul.aggarwal@gmail.com",
            "anurag.saini@gmail.com",
            "varun.malhotra@gmail.com"
        )

        //set layout for recycler view
        ourRecyclerView.layoutManager = LinearLayoutManager(this) //its manage the list items like vertical or horizontal


        dataArrayList = arrayListOf()

        for (i in employee_names.indices){

            val all_data = Employee(employee_image[i],employee_names[i],employee_emails[i])
            dataArrayList.add(all_data)
        }

        val myAdapter = EmployeeAdapter(this,dataArrayList)
        ourRecyclerView.adapter = myAdapter



        myAdapter.setItemClickListner(object : EmployeeAdapter.onItemClickListner{

            override fun onItemClick(position: Int) {
                //on clicking each item

                val intent = Intent(applicationContext,EmployeeDetailsActivity::class.java)

                intent.putExtra("empImageD",dataArrayList[position].empImage)
                intent.putExtra("empNameD",dataArrayList[position].empName)
                intent.putExtra("empEmailD",dataArrayList[position].empEmail)

                startActivity(intent)

            }
        })


    }
}