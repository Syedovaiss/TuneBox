package com.ovais.tunebox.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovais.tunebox.R

private const val PREVIOUS_ICON = "Play Previous Audio"
private const val NEXT_ICON = "Play Next Audio"
private const val PAUSE_ICON = "Pause Audio"
private const val PLAY_ICON = "Play Audio"

@Composable
fun BottomPlayerStateView(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onCenterIconTap: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_previous),
            contentDescription = PREVIOUS_ICON,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(40.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                ) {
                    onPrevious()
                }
        )
        Image(
            painter = painterResource(
                if (isPlaying.not()) R.drawable.ic_play else R.drawable.ic_pause
            ),
            contentDescription = if (isPlaying.not()) PLAY_ICON else PAUSE_ICON,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(40.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                ) {
                    onCenterIconTap()
                }
        )

        Image(
            painter = painterResource(R.drawable.ic_next),
            contentDescription = NEXT_ICON,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .size(40.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                ) {
                    onNext()
                }
        )
    }

}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
private fun BottomStatePreview() {
    BottomPlayerStateView(
        isPlaying = false,
        onCenterIconTap = {},
        onPrevious = {},
        onNext = {}
    )
}