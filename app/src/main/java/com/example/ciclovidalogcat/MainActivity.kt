package com.example.ciclovidalogcat

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var campUsuary:EditText?=null
    var campoId:EditText?=null
    var campocontraseña:EditText?=null
    var txtUsuario:TextView?=null
    var txtId:TextView?=null
    var txtcontraseña:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
        cargarDatos()
    }

    private fun iniciarComponentes() {

        var btnGuardar:Button=findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener { guardarDatos() }

        var btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener { cargarDatos() }

        campUsuary=findViewById(R.id.campoUser)
        campoId=findViewById(R.id.campoId)
        campocontraseña=findViewById(R.id.campoPass)
        txtUsuario=findViewById(R.id.txtUsuario)
        txtId=findViewById(R.id.txtId)
        txtcontraseña=findViewById(R.id.txtPass)
    }

    private fun guardarDatos() {

        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var usuario= campUsuary?.text.toString()
        var id= campoId?.text.toString()
        var pass= campocontraseña?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",usuario)
        editor.putString("id",id)
        editor.putString("pass",pass)

        txtUsuario?.text=usuario
        txtId?.text=id
        txtcontraseña?.text=pass

        editor.commit()

        Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()
    }

    private fun cargarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var user: String? =preferences.getString("user","No existe la información")
        var id: String? =preferences.getString("id","No existe la información")
        var pass: String? =preferences.getString("pass","No existe la información")

        txtUsuario?.text=user
        txtId?.text=id
        txtcontraseña?.text=pass
    }
}