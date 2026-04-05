package com.cobacoba.testpages

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val etNama = findViewById<EditText>(R.id.etNama2)
        val etNIM = findViewById<EditText>(R.id.etNIM2)
        val spinProdi = findViewById<Spinner>(R.id.spinProdi)
        val rbMale = findViewById<RadioButton>(R.id.rbMale)
        val rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        val cbMusic = findViewById<CheckBox>(R.id.cbMusic)
        val cbMovie = findViewById<CheckBox>(R.id.cbMovie)
        val cbSport = findViewById<CheckBox>(R.id.cbSport)
        val btnRegister = findViewById<Button>(R.id.btnLogin)

        // Biar bisa klik salah satu RadioButton
        rbMale.setOnClickListener {
            rbMale.isChecked = true
            rbFemale.isChecked = false
        }
        rbFemale.setOnClickListener {
            rbMale.isChecked = false
            rbFemale.isChecked = true
        }
        btnRegister.setOnClickListener {
            val namaInput = etNama.text.toString()
            val nimInput = etNIM.text.toString()
            val prodiInput = spinProdi.selectedItem.toString() ?: ""

            // Validasi Nama NIM dan Gender
            if(namaInput.isEmpty()){
                etNama.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if(nimInput.isEmpty()){
                etNIM.error = "NIM tidak boleh kosong"
                return@setOnClickListener
            }
            if (!rbMale.isChecked && !rbFemale.isChecked){
                Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mengambil nilai  gender
            val genderFix = if (rbMale.isChecked) "Male" else "Female"

            // nilai hobi
            val hobiFix = mutableListOf<String>()
            if (cbMusic.isChecked) hobiFix.add("Music")
            if (cbMovie.isChecked) hobiFix.add("Movie")
            if (cbSport.isChecked) hobiFix.add("Sport")
            val hobiInput = hobiFix.joinToString(", ")

            // Bagian parcelable
            val userData = User(
                nama = namaInput,
                nim = nimInput,
                prodi = prodiInput,
                jenisKelamin = genderFix,
                hobi = hobiFix.toString()
            )

            // Intent
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("userData", userData)
            startActivity(intent)
        }

        }


}
