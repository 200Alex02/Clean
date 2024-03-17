package com.feature.data.data_source.local

import android.app.Application
import android.content.Context
import com.feature.data.model.PlayerDto
import com.google.gson.Gson
import javax.inject.Inject


private const val SHARED_PREFS_NAME = "player_prefs"
private const val KEY_PLAYERS = "players"

internal class LocalDataSource @Inject constructor(
    application: Application
) {
    private val sharedPreferences =
        application.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val playersJson = sharedPreferences.getString(KEY_PLAYERS, "")

    fun getPlayersFromCash(): List<PlayerDto> {
        return if (playersJson.isNullOrEmpty()) {
            emptyList()
        } else {
            gson.fromJson(playersJson, Array<PlayerDto>::class.java).toList()
        }
    }

    fun savePlayers(players: List<PlayerDto>) {
        val playersJson = gson.toJson(players)
        sharedPreferences.edit().putString(KEY_PLAYERS, playersJson).apply()
    }
}