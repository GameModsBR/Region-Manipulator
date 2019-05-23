package br.com.gamemods.regionmanipulator

import br.com.gamemods.nbtmanipulator.NbtCompound
import br.com.gamemods.nbtmanipulator.NbtFile
import java.util.*

data class Chunk(var lastModified: Date, var nbtFile: NbtFile) {
    val compound: NbtCompound
        get() = nbtFile.compound

    val dataVersion: Int
        get() = compound.getInt("DataVersion")

    val level: NbtCompound
        get() = compound.getCompound("Level")

    val position: ChunkPos
        get() = level.let {
            ChunkPos(it.getInt("xPos"), it.getInt("zPos"))
        }
}