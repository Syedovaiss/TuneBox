package com.ovais.tunebox.audio

import android.content.ComponentName
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import kotlinx.coroutines.guava.await


@Composable
fun rememberMediaController(context: Context): MediaController? {
    var controller by remember { mutableStateOf<MediaController?>(null) }

    LaunchedEffect(Unit) {
        val token = SessionToken(context, ComponentName(context, AudioPlaybackService::class.java))
        controller = MediaController.Builder(context, token).buildAsync().await()
    }

    return controller
}