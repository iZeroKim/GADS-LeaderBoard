package com.example.leaderboardproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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
        submitBtn.setOnClickListener {submitProject()}
    }

    fun submitProject(){
        SubmitProjectApi.retrofitService.submitproject(
            findViewById<TextView>(R.id.firstname).text.toString(),
            findViewById<TextView>(R.id.lastname).text.toString(),
            findViewById<TextView>(R.id.emailaddress).text.toString(),
            findViewById<TextView>(R.id.githublink).text.toString()
        ).enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@SubmitActivity, "Success: ${response.toString()}", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@SubmitActivity, "Success: ${t.toString()}", Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

