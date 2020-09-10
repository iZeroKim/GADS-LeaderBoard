package com.example.leaderboardproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.leaderboardproject.network.submission.SubmitProjectApi
import com.google.android.material.appbar.AppBarLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {
    lateinit var appBarLayout: AppBarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        appBarLayout = findViewById<AppBarLayout>(R.id.appBarSubmit)
        var backArrow = findViewById<ImageView>(R.id.backArrow)
        var submitBtn = findViewById<Button>(R.id.submitProjectBtn)
        backArrow.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        submitBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.dialog_sure, null)
            val cancelBtn  = dialogLayout.findViewById<ImageView>(R.id.imagefailure)
            val acceptBtn = dialogLayout.findViewById<Button>(R.id.yesButton)
            builder.setView(dialogLayout)
            builder.show()

            cancelBtn.setOnClickListener {
                builder.show().dismiss()
            }
            acceptBtn.setOnClickListener {
                submitProject()
            }
            }
    }

    fun submitProject(){
        SubmitProjectApi.retrofitService.submitproject(
            findViewById<TextView>(R.id.firstname).text.toString(),
            findViewById<TextView>(R.id.lastname).text.toString(),
            findViewById<TextView>(R.id.emailaddress).text.toString(),
            findViewById<TextView>(R.id.githublink).text.toString()
        ).enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                val builder = AlertDialog.Builder(this@SubmitActivity)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_success, null)
                builder.setView(dialogLayout)
                builder.show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                val builder = AlertDialog.Builder(this@SubmitActivity)
                val inflater = layoutInflater
                val dialogLayout = inflater.inflate(R.layout.dialog_failure, null)
                builder.setView(dialogLayout)
                builder.show()
            }
        })
    }


}

