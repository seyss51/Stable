package com.stable.app.audio

class AudioRepository {

    private var settings =
        AudioSettings()

    fun settings() = settings

    fun update(
        value: AudioSettings
    ) {

        settings = value

    }

}