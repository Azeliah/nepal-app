package com.example.sundmadnepal.helpers

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TtsManager : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var locale: Locale? = null

    /**
     * This is used to provide a listener for the TTS,
     * without having every single class that uses TTS, having to implement the OnInitListener.
     * @status: status of the init, whether it was a success or not
     */
    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){

            val result = tts!!.setLanguage(locale)

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                Log.e("TTS", "The language trying to be set is not supported!")
        } else
            Log.e("TTS", "Init failed, status was: $status")
    }

    /**
     * Function to initialize the text to speech.
     * @context: the context of the file you call this method from
     * @locale: the language you want to be spoken, by default it will use the locale language of the phone
     * @return: Returns the TTS object, which should be destroyed in OnDestroyView function in fragments
     */
    fun initializeTts(context: Context, lcl: Locale = Locale.getDefault()) : TextToSpeech{
        tts = TextToSpeech(context, this)
        locale = lcl
        return tts as TextToSpeech
    }

    /**
     * @text: The string that will be read out loud
     * @return: Returns a flag (Boolean), if false this means that the tts has NOT been initialized yet
     */
    fun speakOut(text: String) {
        if(tts == null)
            Log.e("TTS", "The TTS has NOT been initialized yet, please call function 'initializeTts', before using the speakOut function.")

        val bundle = Bundle()
        bundle.putInt(TextToSpeech.Engine.KEY_PARAM_STREAM, AudioManager.STREAM_MUSIC)
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, bundle, null) //Flushes the queue if any other text is going to be read out loud
    }

    /**
     * Used to stop the tts
     * Should also be implemented in the onDestroyView for the different fragments
     */
    public override fun onDestroy() {
        if (tts != null) {
            Log.w("TTS", "Stopping/shutting down TTS")
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}