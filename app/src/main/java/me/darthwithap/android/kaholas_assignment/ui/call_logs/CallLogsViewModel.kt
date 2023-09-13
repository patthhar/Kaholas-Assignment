package me.darthwithap.android.kaholas_assignment.ui.call_logs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import me.darthwithap.android.kaholas_assignment.domain.models.CallLog
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

class CallLogsViewModel : ViewModel() {
    private val _callLogs = mutableStateOf(listOf<CallLog>())
    val callLogs: State<List<CallLog>> get() = _callLogs

    private val _lastSyncTime = mutableStateOf(Timestamp(System.currentTimeMillis()))
    val lastSyncTime: State<Timestamp> get() = _lastSyncTime

    init {
        // Will make a call to repository to get the call logs
        // _callLogs = repository.getCallLogs()

        _callLogs.value = CallLog.mockDataSet
    }

    fun onSyncClick() {
        // Logic for syncing call logs
//        viewModelScope.launch {
//            repository.syncCallLogs()
//        }
        // Update the callLogs state and lastSyncTime state after fetching

        // _callLogs.vale =
        _lastSyncTime.value = Timestamp(System.currentTimeMillis())
    }

    fun formatLastSyncTime(lastSync: Timestamp): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(lastSync)
    }

    fun formatTimestamp(timestamp: Timestamp): String {
        val formatter = SimpleDateFormat("EEEE dd MMMM yyyy HH:mm:ss", Locale.ENGLISH)
        return formatter.format(timestamp)
    }

    fun formatDuration(durationInSeconds: Int): String {
        return when {
            durationInSeconds < 60 -> "${durationInSeconds}s"
            durationInSeconds < 3600 -> {
                val minutes = durationInSeconds / 60
                val seconds = durationInSeconds % 60
                "${minutes}m" + if (seconds > 0) " ${seconds}s" else ""
            }
            else -> {
                val hours = durationInSeconds / 3600
                val minutes = (durationInSeconds % 3600) / 60
                val seconds = durationInSeconds % 60
                "${hours}h" +
                        (if (minutes > 0) " ${minutes}m" else "") +
                        (if (seconds > 0) " ${seconds}s" else "")
            }
        }
    }
}