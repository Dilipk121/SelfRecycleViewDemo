package com.example.selfrecycleviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mikhaellopez.circularimageview.CircularImageView

class EmployeeDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)


        val e_image = findViewById<CircularImageView>(R.id.emp_circularImageView)
        val e_name = findViewById<TextView>(R.id.tv_emp_name)
        val e_email = findViewById<TextView>(R.id.tv_emp_email)

        val em_name = intent.getStringExtra("empNameD")
        val em_email = intent.getStringExtra("empEmailD")
        val em_img = intent.getIntExtra("empImageD",0)

        e_image.setImageResource(em_img)
        e_name.text = em_name
        e_email.text = em_email

    }
}