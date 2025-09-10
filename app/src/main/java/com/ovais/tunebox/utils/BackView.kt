package com.ovais.tunebox.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.ovais.tunebox.R


private const val BACK_ICON = "Go Back "

@Composable
fun BackView(
    onClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    Image(
        painter = painterResource(R.drawable.ic_arrow_right),
        contentDescription = BACK_ICON,
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = rememberRipple()
        ) {
            onClick()
        }
    )
}