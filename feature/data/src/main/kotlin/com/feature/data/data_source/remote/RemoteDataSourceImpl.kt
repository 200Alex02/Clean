package com.feature.data.data_source.remote

import com.feature.data.model.PlayerDto
import javax.inject.Inject
import kotlin.random.Random

val listPlayers = listOf(
    PlayerDto(1, "Irog", "Khuev", 22),
    PlayerDto(2, "Dima", "Krot", 45),
    PlayerDto(3, "ilya", "Dildo", 23),
    PlayerDto(4, "Nice", "Dick", 26),
    PlayerDto(5, "Nice", "Coc", 25),
    PlayerDto(6, "Big", "Nigger", 53),
    PlayerDto(7, "Dildo", "Ivanov", 54),
    PlayerDto(8, "Sanya", "Leykin", 234),
    PlayerDto(9, "Adrian", "Konstantionv", 55),
    PlayerDto(10, "Dima", "Ivanov", 43)
)

internal class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {

    override fun getRemotePlayers(): List<PlayerDto> {
        return if (Random.nextBoolean()) {
            return listPlayers
        } else {
            error("Failed to fetch remote players")
        }
    }
}