package com.example.reto1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cbAndroid = findViewById<CheckBox>(R.id.cbAndroid)
        val cbReact = findViewById<CheckBox>(R.id.cbReact)
        val cbFlutter = findViewById<CheckBox>(R.id.cbFlutter)

        cbAndroid.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                println("Android seleccionado")
            } else {
                println("Android desmarcado")
            }
        }

        cbReact.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                println("React Seleccionado")
            } else {
                println("React desmarcado")
            }
        }

        cbFlutter.setOnCheckedChangeListener{_, isChecked ->
            if (isChecked) {
                println("Flutter seleccionado")
            } else {
                println("Flutter desmarcado")
            }
        }

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnGuardar.setOnClickListener {
            val resultado = """
                Tecnologías seleccionadas:
                
                Android: ${if (cbAndroid.isChecked) "Seleccionado" else "No seleccionado"}
                React: ${if (cbReact.isChecked) "Seleccionado" else "No seleccionado"}
                Flutter: ${if (cbFlutter.isChecked) "Seleccionado" else "No seleccionado"}
            """.trimIndent()

            txtResultado.text = resultado
        }

    }
}