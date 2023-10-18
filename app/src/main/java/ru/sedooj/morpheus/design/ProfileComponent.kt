package ru.sedooj.morpheus.design

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

data class ProfileComponentState(
    val photo: Boolean,
    val username: String = "No name",
    val status: String = "Пользователь",
)

@Composable
fun ProfileComponent(
    state: ProfileComponentState,
    modifier: Modifier
) {
    val expanded = remember { mutableStateOf(false) }
    val baseShape = MaterialTheme.shapes.medium

    Box(
        modifier = modifier
            .height(if (!expanded.value) 100.dp else 150.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded.value = !expanded.value
            }
            .border(
                border = BorderStroke(width = 1.dp, color = Color.White),
                shape = baseShape
            )
            .animateContentSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                if (!state.photo) {
                    CircularProgressIndicator()
                }
            }

            Box(
                modifier = Modifier.weight(5f)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        state.username,
                        modifier = Modifier
                            .fillMaxWidth(),
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start
                    )
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .border(
                                border = BorderStroke(width = 0.dp, color = Color.White),
                                shape = baseShape
                            )
                            .fillMaxWidth()
                    )
                    Text(
                        state.status,
                        overflow = if (expanded.value) TextOverflow.Visible else TextOverflow.Ellipsis
                    )
                }

            }
        }
    }
}