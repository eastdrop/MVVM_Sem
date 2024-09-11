package com.example.sem_11_mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.sem_11_mvvm.ui.main.MainFragment
import com.example.sem_11_mvvm.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.layout_main_fragment)
            }
        }
        /*enableEdgeToEdge()
        setContentView(R.layout.fragment_main_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_main_fragment)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        /*supportFragmentManager.commit {
            replace<MainFragment>(R.id.layout_main_fragment)
            setReorderingAllowed(true)
            addToBackStack("name") // Name can be null
        }*/


    }
}