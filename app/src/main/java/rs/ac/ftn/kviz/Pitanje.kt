package rs.ac.ftn.kviz

import androidx.annotation.StringRes

data class Pitanje (
    @StringRes val tekstResId: Int,
    val odgovor: Boolean
)

