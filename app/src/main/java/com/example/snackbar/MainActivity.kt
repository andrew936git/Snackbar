package com.example.snackbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var textTV: TextView
    private lateinit var editTextET: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textTV = findViewById(R.id.textTV)
        editTextET = findViewById(R.id.editTextET)

        saveButton = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val str = editTextET.getText().toString()
            textTV.text = str
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClick(view: View) {
        Snackbar.make(
            view,
            "Подтвердите удаление",
            Snackbar.LENGTH_LONG
        ).setAction("Удалить"){
            editTextET.text.clear()
            textTV.text = "Результат"
            Snackbar.make(
                view,
                "Данные удалены",
                Snackbar.LENGTH_LONG).show()
        }.show()

    }

}