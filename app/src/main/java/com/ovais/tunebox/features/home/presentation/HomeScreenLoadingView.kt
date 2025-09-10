package com.ovais.tunebox.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ovais.tunebox.utils.ShimmerCardPlaceholder

@Composable
fun HomeScreenLoadingView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 150.dp
                )
        ) {
            ShimmerCardPlaceholder(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 50.dp
                    )
                    .height(300.dp)
            )
        }
        ShimmerCardPlaceholder(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 40.dp
                )
                .height(32.dp)
        )
        ShimmerCardPlaceholder(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 64.dp,
                    vertical = 16.dp
                )
                .height(28.dp)
        )
        Spacer(Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp, start = 16.dp, end = 16.dp)
        ) {
            ShimmerCardPlaceholder(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    )
                    .size(50.dp)
            )
            ShimmerCardPlaceholder(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    )
                    .size(50.dp)
            )
            ShimmerCardPlaceholder(
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp
                    )
                    .size(50.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenLoadingPreview() {
    HomeScreenLoadingView()
}