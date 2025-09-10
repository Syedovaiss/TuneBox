package com.ovais.tunebox.features.home.presentation

import com.ovais.tunebox.features.home.data.AudioFile
import com.ovais.tunebox.utils.RandomStringProvider
import com.ovais.tunebox.utils.TuneBoxMapper


class AudioMapper(
    private val randomStringProvider: RandomStringProvider
) : TuneBoxMapper<List<Int>, AudioFile?> {

    private var head: AudioFile? = null
    private var tail: AudioFile? = null
    private val isEmpty: Boolean
        get() = size == 0
    private var size = 0

    override fun map(from: List<Int>): AudioFile? {
        from.forEach {
            append(it)
        }
        return head
    }

    private fun append(resourceId: Int) {
        val item = AudioFile(
            title = randomStringProvider.get(5),
            recitedBy = randomStringProvider.get(3),
            file = resourceId,
            thumbnail = AudioFile.randomImage
        )
        if (isEmpty) {
            head = item
            tail = item
        } else {
            val temp = tail
            temp?.next = item
            item.previous = temp
            tail = item
        }
        size++
    }

}