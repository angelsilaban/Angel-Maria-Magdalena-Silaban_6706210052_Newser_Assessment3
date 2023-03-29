package org.d3if0052.newser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            object : Thread() {
                override fun run() {
                    sleep(3000)
                    startActivity(
                        Intent(
                            this@MainActivity,
                            HomePageActivity::class.java
                        )
                    )
                    finish()
                }
            }.start()
        } catch (ex: Exception) {
            Toast.makeText(
                this@MainActivity,
                "Failed to start app!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}