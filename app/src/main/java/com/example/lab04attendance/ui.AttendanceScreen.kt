package com.example.lab04attendance

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

// Task 2: Data Class الخاصة بالحالة
data class AttendanceUiState(
    val sessionTitle: String = "",
    val checkedInCount: Int = 0,
    val isCheckedIn: Boolean = false
)

// Task 3: الشاشة الرئيسية (Stateless)
@Composable
fun AttendanceScreen(
    uiState: AttendanceUiState,
    onCheckIn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = uiState.sessionTitle, style = MaterialTheme.typography.headlineMedium)
        Text(text = "Checked in: ${uiState.checkedInCount}")
        Button(
            onClick = onCheckIn,
            enabled = !uiState.isCheckedIn
        ) {
            Text(if (uiState.isCheckedIn) "Checked In" else "Check In")
        }
    }
}

// Task 4: الـ Route للتحكم بالحالة
@Composable
fun AttendanceRoute() {
    var uiState by remember {
        mutableStateOf(AttendanceUiState("CSC 402 Week 4", 12, false))
    }

    AttendanceScreen(
        uiState = uiState,
        onCheckIn = {
            uiState = uiState.copy(
                checkedInCount = uiState.checkedInCount + 1,
                isCheckedIn = true
            )
        }
    )
}

// Task 3: المعاينات Previews
@Preview(showBackground = true, name = "Not checked in yet")
@Composable
private fun AttendanceScreenPreviewUnchecked() {
    AttendanceScreen(
        uiState = AttendanceUiState("CSC 402 Week 4", 12, false),
        onCheckIn = {}
    )
}

@Preview(showBackground = true, name = "Already checked in")
@Composable
private fun AttendanceScreenPreviewChecked() {
    AttendanceScreen(
        uiState = AttendanceUiState("CSC 402 Week 4", 13, true),
        onCheckIn = {}
    )
}