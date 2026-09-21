package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val sampleStudents = listOf(
                    Student("ليان", "Computer Science", "3.95", "layan@domain.com", "Al Khobar"),
                    Student("سارة", "Computer Science", "3.80", "sara@domain.com", "Dammam"),
                    Student("نورة", "Software Engineering", "3.90", "noura@domain.com", "Riyadh")
                )
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentListScreen(
                        students = sampleStudents,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}