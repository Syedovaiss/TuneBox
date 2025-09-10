package com.ovais.tunebox.features.home.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.ovais.tunebox.utils.PLACEHOLDER
import com.ovais.tunebox.utils.ShimmerCardPlaceholder


private const val THUMBNAIL_CONTENT_DESCRIPTION = "Audio Thumbnail"
private const val THUMBNAIL_ERROR_CONTENT_DESCRIPTION = "Audio Thumbnail Failed"

@Composable
fun PlayerThumbnailView(
    imageUrl: String?
) {
    val imageModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 32.dp, vertical = 16.dp)
        .height(300.dp)
        .clip(RoundedCornerShape(12.dp))

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = THUMBNAIL_CONTENT_DESCRIPTION,
        modifier = imageModifier,
        contentScale = ContentScale.Crop
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                ShimmerCardPlaceholder(
                    modifier = imageModifier
                )
            }

            is AsyncImagePainter.State.Error -> {
                AsyncImage(
                    model = PLACEHOLDER,
                    contentDescription = THUMBNAIL_ERROR_CONTENT_DESCRIPTION,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
            }

            else -> {
                SubcomposeAsyncImageContent(
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}