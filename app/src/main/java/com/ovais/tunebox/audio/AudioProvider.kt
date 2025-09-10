package com.ovais.tunebox.audio

import com.ovais.tunebox.R
import com.ovais.tunebox.utils.Provider

typealias AudioResources = Int

class AudioProvider : Provider<List<AudioResources>> {
    override fun get(): List<AudioResources> {
        return listOf(
            R.raw.haal_e_dil,
            R.raw.kaabe_ki_ronaq,
            R.raw.muhammad_ka_roza,
            R.raw.mera_dil_badal_de,
            R.raw.mere_nabi_pyare_nabi,
        )
    }
}