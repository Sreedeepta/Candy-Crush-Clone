package j4k.candycrush.audio

import com.soywiz.klock.seconds
import com.soywiz.korau.sound.NativeSound
import com.soywiz.korau.sound.NativeSoundChannel
import com.soywiz.korge.view.Stage
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.async.delay
import com.soywiz.korio.async.launch
import j4k.candycrush.lib.loadMusic

/**
 * Jukebox which plays background music in a random order.
 */
class JukeBox(val stage: Stage) {

    private var playing: NativeSoundChannel? = null
    private val playList = mutableListOf<NativeSound>()
    private var started = false
    var activated = true

    companion object {
        suspend operator fun invoke(injector: AsyncInjector, receiver: JukeBox.() -> Unit): JukeBox {
            injector.mapSingleton {
                JukeBox(get()).apply {
                    receiver.invoke(this)
                }
            }
            return injector.get()
        }
    }

    suspend fun init() {
        if (activated && playList.isEmpty()) {
            playList += loadMusic("monkey_drama.mp3")
            playList += loadMusic("monkey_island_puzzler.mp3")
        }
    }

    fun play() {
        if (activated && !started) {
            stage.launch {
                init()
                delay(2.seconds)
                loopMusicPlaylist()
            }
        }
    }

    private suspend fun loopMusicPlaylist() {
        started = true
        while (started) {
            val nextSong: NativeSound = playList.random()
            playing = nextSong.play()
            delay(nextSong.length.coerceAtLeast(2.seconds))
            playing?.stop()
        }
    }

    fun stop() {
        playing?.stop()
        started = false
    }

}