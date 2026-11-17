package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    // el primer numero, antes de pulsar +, -, * o /
    private var numero1 = 0.0
    private var operacion = ""
    private var operationdone = false

    // si es true, el siguiente numero borra lo que hay en pantalla
    private var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.parseColor("#6751A3")),
            navigationBarStyle = SystemBarStyle.light(Color.WHITE, Color.WHITE)
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.texto = "0"
        binding.executePendingBindings()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.raiz) { _, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.raiz.setPadding(0, barras.top, 0, 0)
            binding.contenido.setPadding(0, 0, 0, barras.bottom)
            insets
        }

        binding.boton0.setOnClickListener { pulsar("0") }
        binding.boton1.setOnClickListener { pulsar("1") }
        binding.boton2.setOnClickListener { pulsar("2") }
        binding.boton3.setOnClickListener { pulsar("3") }
        binding.boton4.setOnClickListener { pulsar("4") }
        binding.boton5.setOnClickListener { pulsar("5") }
        binding.boton6.setOnClickListener { pulsar("6") }
        binding.boton7.setOnClickListener { pulsar("7") }
        binding.boton8.setOnClickListener { pulsar("8") }
        binding.boton9.setOnClickListener { pulsar("9") }
        binding.botonPunto.setOnClickListener { pulsar(".") }
        binding.botonIgual.setOnClickListener { pulsar("=") }
        binding.botonDividir.setOnClickListener { pulsar("/") }
        binding.botonMultiplicar.setOnClickListener { pulsar("*") }
        binding.botonRestar.setOnClickListener { pulsar("-") }
        binding.botonSumar.setOnClickListener { pulsar("+") }
    }

    private fun pulsar(tecla: String) {
        var pantalla = binding.texto ?: "0"

        if (tecla == "0" || tecla == "1" || tecla == "2" || tecla == "3" || tecla == "4" ||
            tecla == "5" || tecla == "6" || tecla == "7" || tecla == "8" || tecla == "9"
        ) {
            operationdone = false
            if (pantalla == "0" || pantalla == "Error" || nuevoNumero) {
                pantalla = tecla
            } else {
                pantalla = pantalla + tecla
            }
            nuevoNumero = false
        } else if (tecla == ".") {
            operationdone = false
            if (pantalla == "Error" || nuevoNumero) {
                pantalla = "0."
                nuevoNumero = false
            } else if (pantalla.contains(".") == false) {
                pantalla = pantalla + "."
            }
        } else if (tecla == "+" || tecla == "-" || tecla == "*" || tecla == "/") {
            if (pantalla == "Error" || operationdone) {
                return
            }
            operationdone = true
            numero1 = pantalla.toDouble()
            pantalla = pantalla + tecla
            operacion = tecla
            nuevoNumero = true
        } else if (tecla == "=") {
            if (operacion == "" || pantalla == "Error" || operationdone) {
                return
            }

            val numero2 = pantalla.toDouble()
            var resultado = 0.0

            if (operacion == "+") {
                resultado = numero1 + numero2
            } else if (operacion == "-") {
                resultado = numero1 - numero2
            } else if (operacion == "*") {
                resultado = numero1 * numero2
            } else if (operacion == "/") {
                if (numero2 == 0.0) {
                    pantalla = "Error"
                    operacion = ""
                    nuevoNumero = true
                    binding.texto = pantalla
                    binding.executePendingBindings()
                    return
                }
                resultado = numero1 / numero2
            }

            // si el resultado es entero, no muestro el .0
            if (resultado == resultado.toLong().toDouble()) {
                pantalla = resultado.toLong().toString()
            } else {
                pantalla = resultado.toString()
            }

            operacion = ""
            nuevoNumero = true
        }

        binding.texto = pantalla
        binding.executePendingBindings()
    }
}
