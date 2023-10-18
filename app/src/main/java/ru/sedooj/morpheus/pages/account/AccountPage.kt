package ru.sedooj.morpheus.pages.account

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sedooj.morpheus.R
import ru.sedooj.morpheus.design.ProfileComponent
import ru.sedooj.morpheus.design.ProfileComponentState
import ru.sedooj.morpheus.design.RowBlockElement
import ru.sedooj.morpheus.design.RowBlockElementState
import ru.sedooj.morpheus.design.ScrollableCenteredScreenContentComponent
import ru.sedooj.morpheus.navigation.Screens

@Composable
fun AccountPage(
    modifier: Modifier = Modifier,
    padding: PaddingValues
) {
    ScrollableCenteredScreenContentComponent(
        modifier = modifier,
        title = Screens.ACCOUNT_PAGE.pageName,
        mainPaddingValue = padding,
        content = {
            ProfileComponent(
                state = ProfileComponentState(
                    photo = false,
                    username = "sedooj",
                    status = "Dev.",
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            RowBlockElement(
                state = RowBlockElementState(
                    title = "Ооо, чё???",
                    icon = R.drawable.info,
                    alignment = Alignment.TopCenter,
                    description = "Я хуй его знает что сюда писать, мне нужно список затестить."
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }
    )
}