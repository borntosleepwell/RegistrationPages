package com.cobacoba.testpages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Binding data parcelable dari intent
        val user = intent.getParcelableExtra<User>("userData")
        if (user != null){
            val txtHiUser = findViewById<TextView>(R.id.txtHiUser)
            txtHiUser.text = "Hi, " + user.nama

            // Data ke cardview
            findViewById<TextView>(R.id.hasilNama).text = user.nama
            findViewById<TextView>(R.id.hasilNIM).text = user.nim
            findViewById<TextView>(R.id.hasilProdi).text = user.prodi
            findViewById<TextView>(R.id.hasilGender).text = user.jenisKelamin
            findViewById<TextView>(R.id.hasilHobi).text = user.hobi

        }
        val btnJournal = findViewById<Button>(R.id.btnGoToJournal)
        btnJournal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Kita asumsikan MainActivity adalah List Screen
            startActivity(intent)
        }

    }
}