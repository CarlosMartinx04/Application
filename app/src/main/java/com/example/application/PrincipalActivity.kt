package com.example.application

import android.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application.databinding.ActivityPrincipalBinding
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        fragmentos(Inicio())
        var barra_menu = findViewById<BottomNavigationView>(R.id.navegador)

        barra_menu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.inicio->fragmentos(Inicio())
                R.id.notificaciones->fragmentos(Notificaciones())
                R.id.perfil->fragmentos(Perfil())
            }
            true
        }
    }

    fun fragmentos(fragment:androidx.fragment.app.Fragment){
        var fragment_manager=supportFragmentManager
        var transaction=fragment_manager.beginTransaction()
        transaction.replace(R.id.contenedorPrincipal,fragment).commit()
    }

}