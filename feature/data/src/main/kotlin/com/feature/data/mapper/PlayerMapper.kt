package com.feature.data.mapper

import com.feature.data.model.PlayerDto
import com.feature.domain.model.Player

fun PlayerDto.toDomainPlayer(): Player {
    return Player(
        name = this.name,
        surname = this.surname,
        age = this.age
    )
}