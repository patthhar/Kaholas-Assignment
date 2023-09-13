package me.darthwithap.android.kaholas_assignment.ui.call_logs

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.darthwithap.android.kaholas_assignment.ui.call_logs.components.CallLogItem
import me.darthwithap.android.kaholas_assignment.ui.call_logs.components.CallLogTopAppBar
import me.darthwithap.android.kaholas_assignment.ui.call_logs.components.UploadButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallLogsScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val viewModel: CallLogsViewModel = viewModel()
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            CallLogTopAppBar(
                timestamp = viewModel.formatLastSyncTime(viewModel.lastSyncTime.value),
                onSettingsClick = {
                    // Handle on settings click
                    Toast.makeText(
                        context,
                        "Settings clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onSync = viewModel::onSyncClick
            )
        },
        bottomBar = {
            UploadButton {
                // Handle on upload click
                Toast.makeText(context, "Upload clicked", Toast.LENGTH_SHORT).show()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(4.dp)
        ) {
            LazyColumn {
                items(viewModel.callLogs.value) {
                    CallLogItem(
                        formatDate = viewModel::formatTimestamp,
                        formatDuration = viewModel::formatDuration,
                        callLog = it
                    )
                }
            }
        }
    }

}