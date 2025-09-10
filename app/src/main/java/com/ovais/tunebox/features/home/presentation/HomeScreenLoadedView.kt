package com.ovais.tunebox.features.home.presentation

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import androidx.annotation.OptIn
import androidx.annotation.RawRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import com.ovais.tunebox.R
import com.ovais.tunebox.audio.rememberMediaController
import com.ovais.tunebox.core.ui.theme.ColorPrimary
import com.ovais.tunebox.core.ui.theme.ColorSecondary
import com.ovais.tunebox.utils.BackView
import com.ovais.tunebox.utils.BottomPlayerStateView

private const val FAVOURITE_LIST = "Favourite List"
private const val RAW = "raw"

@SuppressLint("LocalContextResourcesRead")
@OptIn(UnstableApi::class)
@Composable
fun HomeScreenLoadedView(
    imageUrl: String?,
    title: String?,
    recitedBy: String?,
    isPlaying: Boolean,
    @RawRes file: Int?,
    onAction: (HomeAction) -> Unit
) {

    val context = LocalContext.current
    val controller = rememberMediaController(LocalContext.current)
    LaunchedEffect(controller, file) {
        if (controller != null && file != null) {
            val uri = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(context.packageName)
                .appendPath(RAW)
                .appendPath(context.resources.getResourceEntryName(file))
                .build()

            controller.setMediaItem(MediaItem.fromUri(uri))
            controller.prepare()
        }
    }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            controller?.play()
        } else {
            controller?.pause()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BackView {
                onAction(HomeAction.BackPress)
            }
            Text(
                stringResource(R.string.now_playing),
                color = ColorPrimary,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(R.drawable.ic_fav_list),
                contentDescription = FAVOURITE_LIST,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                ) {
                    onAction(HomeAction.FavouriteList)
                }
            )
        }

        Spacer(Modifier.weight(1f))
        PlayerThumbnailView(imageUrl)

        Text(
            title.orEmpty(),
            color = ColorPrimary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp
                ),
            textAlign = TextAlign.Center
        )
        Text(
            recitedBy.orEmpty(),
            color = ColorSecondary,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp
                ),
        )
        Spacer(Modifier.weight(1f))
        BottomPlayerStateView(
            isPlaying = isPlaying,
            onPrevious = {
                onAction(HomeAction.Previous)
            },
            onNext = {
                onAction(HomeAction.Next)
            },
            onCenterIconTap = {
                onAction(HomeAction.CenterIcon)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 40.dp
                )
        )

    }
}

@Preview(showBackground = true, backgroundColor = 1)
@Composable
private fun HomeScreenLoadedPreview() {
    HomeScreenLoadedView(
        title = LoremIpsum(5).values.joinToString(),
        recitedBy = LoremIpsum(3).values.joinToString(),
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQntUL2rueJjIOiuAOOuaUcCLukY2qF61oAxg&s",
        onAction = {},
        isPlaying = true,
        file = R.raw.haal_e_dil
    )
}