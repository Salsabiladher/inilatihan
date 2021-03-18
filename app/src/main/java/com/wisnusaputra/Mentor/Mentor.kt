package com.wisnusaputra.fruits

import java.io.Serializable

data class Mentor(
    var jenis: String ="",
    var detail: String="",
    var layanan: String ="",
    var photo: Int =0
) : Serializable