package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudentListItem(student: Student, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = student.name, style = MaterialTheme.typography.titleMedium)
            Text(text = student.program, style = MaterialTheme.typography.bodyMedium)
            Text(text = "GPA: ${student.gpa}", style = MaterialTheme.typography.bodySmall)
            Text(text = student.email, style = MaterialTheme.typography.bodySmall)
            Text(text = student.city, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun StudentListScreen(students: List<Student>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(students) { student ->
            StudentListItem(student = student)
        }
    }
}