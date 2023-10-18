package ru.sedooj.morpheus.pages.main

import android.widget.TextClock
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import ru.sedooj.morpheus.R
import ru.sedooj.morpheus.design.RowBlockElement
import ru.sedooj.morpheus.design.RowBlockElementState
import ru.sedooj.morpheus.design.ScrollableCenteredScreenContentComponent
import ru.sedooj.morpheus.navigation.Screens

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    padding: PaddingValues
) {
    ScrollableCenteredScreenContentComponent(
        modifier = modifier,
        title = Screens.MAIN_PAGE.pageName,
        mainPaddingValue = padding,
        content = {
            ClockComponent()
            RowBlockElement(
                state = RowBlockElementState(
                    title = Screens.MAIN_PAGE.pageName,
                    icon = R.drawable.home,
                    alignment = Alignment.TopCenter,
                    description = "Некое описание, которое нужно просто для того, чтобы занять место на экране. Больше текста нахуй, заебала эта ебаторя блять"
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 15.dp)
            )
        }
    )
}

@Composable
fun ClockComponent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AndroidView(
            factory = { context ->
                TextClock(context).apply {
                    format12Hour?.let { this.format12Hour = "hh:mm" }
                    timeZone?.let { this.timeZone = it }
                    textSize.let { this.textSize = 40f }
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                }
            },
            modifier = Modifier
        )
    }
}
