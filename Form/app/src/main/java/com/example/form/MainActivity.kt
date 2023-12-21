package com.example.form

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import com.example.form.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val paises = arrayOf("Argentina", "Bolivia", "Chile", "Colombia","Ecuador", "México")

        val adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, paises)

        binding.actvPaises.setAdapter(adapter)
        binding.actvPaises.setOnItemClickListener { _, _, position, _ ->
            binding.etLugarNacimiento.requestFocus()
            Toast.makeText(this, paises[position],Toast.LENGTH_SHORT).show()
        }

        binding.etFechaNacimiento.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener { tiempoEnMiliSegundos->
                val fechaStr = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
                    timeZone = TimeZone.getTimeZone("UTC")
                }.format(tiempoEnMiliSegundos)
                binding.etFechaNacimiento.setText(fechaStr)
            }
            picker.show(supportFragmentManager,picker.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_send){
            if (validarCampos() ) {
                val nombre: String = findViewById<TextInputEditText>(R.id.etNombre).text.toString().trim()
                val apellido = binding.etApellidos.text.toString().trim()
                val altura = binding.etHeight.text.toString().trim()
                val fechaCunpleaños= binding.etFechaNacimiento.text.toString().trim()
                val pais = binding.actvPaises.text.toString().trim()
                val lugarNacimiento = binding.etLugarNacimiento.text.toString().trim()
                val notas = binding.etNotas.text.toString().trim()
                //Toast.makeText(this,"$nombre $apellido", LENGTH_SHORT).show()

                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.dialog_title))
                builder.setMessage(joinDta(nombre, apellido, altura, fechaCunpleaños, pais, lugarNacimiento, notas))
                builder.setNegativeButton(getString(R.string.dialog_cancel), null)
                builder.setPositiveButton(
                    getString(R.string.dialog_ok)
                ) { _, _ ->
                    with(binding){
                        etNombre.text?.clear()
                        etApellidos.text?.clear()
                        etHeight.text?.clear()
                        etFechaNacimiento.text?.clear()
                        actvPaises.text?.clear()
                        etLugarNacimiento.text?.clear()
                        etNotas.text?.clear()
                    }
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun joinDta(vararg fields:String):String{
        var result = ""

        fields.forEach { field ->
            if(field.isNotEmpty()) {
                result += "$field\n"
            }
        }
        return result
    }

    private fun validarCampos():Boolean{
        var isValid = true

        if(binding.etHeight.text.isNullOrEmpty()){
            binding.etHeight.run {
                error = getString(R.string.help_requirido)
                requestFocus()
            }
            isValid= false

        }
        else if (binding.etHeight.text.toString().toInt() < 50){
            binding.tilHeight.run {
                error = getString(R.string.help_requirido_valido)
                requestFocus()
            }
            isValid = false
        }
        else{
            binding.tilHeight.error = null
        }

        if(binding.etApellidos.text.isNullOrEmpty()){
            binding.tilApellido.run {
                error = getString(R.string.help_requirido)
                requestFocus()
            }
            isValid= false

        }else{
            binding.tilApellido.error = null
        }

        if(binding.etNombre.text.isNullOrEmpty()){
            binding.tilNombre.run {
                error = getString(R.string.help_requirido)
                requestFocus()
            }
            isValid= false

        }else{
            binding.tilNombre.error = null
        }

        return isValid
    }


}