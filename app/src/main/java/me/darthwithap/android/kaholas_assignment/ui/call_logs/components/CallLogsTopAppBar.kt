package me.darthwithap.android.kaholas_assignment.ui.call_logs.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import me.darthwithap.android.kaholas_assignment.R
import me.darthwithap.android.kaholas_assignment.ui.theme.quicksandFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallLogTopAppBar(
    timestamp: String,
    onSettingsClick: () -> Unit,
    onSync: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.shadow(
            elevation = 6.dp
        ),
        title = {
            Column {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = stringResource(id = R.string.call_logs),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = quicksandFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                )
                Text(
                    text = stringResource(id = R.string.timestamp_subtitle, timestamp),
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontFamily = quicksandFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
        },
        actions = {
            IconButton(onClick = onSettingsClick, modifier = Modifier.offset(x = (16).dp)) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = stringResource(id = R.string.settings)
                )
            }
            IconButton(onClick = onSync) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sync),
                    contentDescription = stringResource(id = R.string.sync)
                )
            }
        }
    )
}
