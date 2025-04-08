package rs.ac.ftn.kviz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val TRENUTNI_KLJUC_INDEKSA = "TRENUTNI_KLJUC_INDEKSA"

class KvizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val bankaPitanja = listOf(
        Pitanje(R.string.pitanje_kotlin, true),
        Pitanje(R.string.pitanje_java, false),
        Pitanje(R.string.pitanje_c, true),
        Pitanje(R.string.pitanje_pajton, false),
        Pitanje(R.string.pitanje_javascript, false),
        Pitanje(R.string.pitanje_cplusplus, true))


    private var indeks: Int
        get() = savedStateHandle.get(TRENUTNI_KLJUC_INDEKSA) ?: 0
        set(vrednost) = savedStateHandle.set(TRENUTNI_KLJUC_INDEKSA, vrednost)

    val odgovorNaTrenutnoPitanje: Boolean
        get() = bankaPitanja[indeks].odgovor

    val tekstTrenutnogPitanja: Int
        get() = bankaPitanja[indeks].tekstResId

    fun prelazakNaSledece() {
        // Ovo ispod komentarisemo
        // Log.d(TAG, "Azuriranje teksta pitanja", Exception()) // Nova linija
        indeks = (indeks + 1) % bankaPitanja.size
    }

    fun prelazakNaPrethodno() {
        indeks = (indeks -1 + bankaPitanja.size) % bankaPitanja.size
    }
}