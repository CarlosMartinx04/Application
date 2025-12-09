package com.example.application

import android.app.Fragment
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application.databinding.ActivityPrincipalBinding

class PrincipalActivity : AppCompatActivity() {
    lateinit var binding:ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_principal)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentos(Inicio())

        binding.navegador.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Inicio->fragmentos(Inicio())
                R.id.Notificaciones->fragmentos(Notificaciones())
                R.id.Perfil->fragmentos(Perfil())
            }
            true
        }
    }

    fun fragmentos(fragment: androidx.fragment.app.Fragment){
        var fragment_manager=supportFragmentManager
        var transaction=fragment_manager.beginTransaction()
        transaction.replace(R.id.contenedorPrincipal,fragment).commit()
    }

}