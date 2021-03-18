package com.wisnusaputra.fruits

import java.io.Serializable

data class Fruit(
    var name: String ="",
    var detail: String="",
    var manfaat: String ="",
    var photo: Int =0
) : Serializable