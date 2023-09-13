package me.darthwithap.android.kaholas_assignment.ui.call_logs.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.darthwithap.android.kaholas_assignment.R
import me.darthwithap.android.kaholas_assignment.ui.theme.Orange

@Composable
fun UploadButton(
    modifier: Modifier = Modifier,
    onUploadClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Orange)
            .clickable {
                onUploadClick()
            }
            .height(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.upload),
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.surface,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}