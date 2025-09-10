package com.ovais.tunebox.audio

import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaLibraryService
import androidx.media3.session.MediaSession

class AudioPlaybackService : MediaLibraryService() {
    private var player: ExoPlayer? = null
    private var mediaLibrarySession: MediaLibrarySession? = null

    override fun onCreate() {
        super.onCreate()
        player = ExoPlayer.Builder(this).build()
        player?.let {
            mediaLibrarySession = MediaLibrarySession.Builder(
                this,
                it,
                object : MediaLibrarySession.Callback {}
            ).build()
        }
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaLibrarySession? {
        return mediaLibrarySession
    }

    override fun onDestroy() {
        mediaLibrarySession?.release()
        player?.release()
        super.onDestroy()
    }
}