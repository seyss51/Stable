package com.stable.app.audio

import android.media.AudioManager
import android.media.ToneGenerator

class BeepManager {

    private val tone = ToneGenerator(
        AudioManager.STREAM_MUSIC,
        100
    )

    fun countdown() {

        tone.startTone(
            ToneGenerator.TONE_PROP_BEEP,
            120
        )

    }

    fun go() {

        tone.startTone(
            ToneGenerator.TONE_PROP_ACK,
            300
        )

    }

    fun rest() {

        tone.startTone(
            ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,
            250
        )

    }

    fun resume() {

        tone.startTone(
            ToneGenerator.TONE_PROP_BEEP2,
            250
        )

    }

    fun finish() {

        repeat(3) {

            tone.startTone(
                ToneGenerator.TONE_PROP_ACK,
                150
            )

            Thread.sleep(250)

        }

    }

    fun release() {

        tone.release()

    }

}