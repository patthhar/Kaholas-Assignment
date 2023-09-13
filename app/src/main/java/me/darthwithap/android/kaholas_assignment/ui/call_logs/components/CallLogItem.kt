package me.darthwithap.android.kaholas_assignment.ui.call_logs.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.darthwithap.android.kaholas_assignment.R
import me.darthwithap.android.kaholas_assignment.domain.models.CallLog
import me.darthwithap.android.kaholas_assignment.ui.theme.Orange
import me.darthwithap.android.kaholas_assignment.util.gradientSurface
import java.sql.Timestamp

@Composable
fun CallLogItem(
    modifier: Modifier = Modifier,
    formatDate: (Timestamp) -> String,
    formatDuration: (Int) -> String,
    callLog: CallLog
) {
    Box(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            .gradientSurface()
            .padding(8.dp),

        ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = callLog.phoneNo,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colorScheme.onSurface)
                        .padding(4.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = callLog.callType.name,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.surface,
                            fontSize = 10.sp
                        )
                    )
                }
            }
            Text(
                text = stringResource(
                    id = R.string.date_and_duration,
                    formatDate(callLog.date),
                    formatDuration(callLog.durationInSeconds)
                ),
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(id = R.string.from_number, callLog.fromNumber),
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.tertiary)
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Orange),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mic),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.surface
                    )
                }

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    text = callLog.recordingFileName,
                    style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.tertiary),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            // OnRecordingPlay
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }


        }
    }
}