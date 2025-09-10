package com.ovais.tunebox.features.home.data

import androidx.annotation.RawRes

data class AudioFile(
    val title: String,
    val recitedBy: String,
    @param:RawRes val file: Int,
    val thumbnail: String,
    var previous: AudioFile? = null,
    var next: AudioFile? = null
) {
    companion object {
        private const val IMAGE_1 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSiJTyLzniapZjMGI80x1ebcDiALOfNITYk1w&s"
        private const val IMAGE_2 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfkVenxzoD1TkY0ECB5H2iVsfcxIHnfZ1-6A&s"
        private const val IMAGE_3 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQirX4ofrrQEa8irv7BuuC6Qe7OCKN8-g7wGg&s"
        private const val IMAGE_4 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBFvAoN9g-atGIn5O-svd_qpyE37pTPXR4jA&s"
        private const val IMAGE_5 =
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBFvAoN9g-atGIn5O-svd_qpyE37pTPXR4jA&s"
        val randomImage = listOf<String>(
            IMAGE_1,
            IMAGE_2,
            IMAGE_3,
            IMAGE_4,
            IMAGE_5,
        ).random()
    }

}