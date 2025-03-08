package rs.ac.ftn.kviz

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import rs.ac.ftn.kviz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // private lateinit var tacnoDugme: Button
    // private lateinit var netacnoDugme: Button

    private val bankaPitanja = listOf(
        Pitanje(R.string.pitanje_kotlin, true),
        Pitanje(R.string.pitanje_java, false),
        Pitanje(R.string.pitanje_c, true),
        Pitanje(R.string.pitanje_pajton, false),
        Pitanje(R.string.pitanje_javascript, false),
        Pitanje(R.string.pitanje_cplusplus, true))

    private var indeks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dugmeTacno.setOnClickListener {
            proveriOdgovor(true)
        }

        binding.dugmeNetacno.setOnClickListener {
            proveriOdgovor(false)
        }

        binding.dugmeSledece.setOnClickListener {
            indeks = (indeks + 1) % bankaPitanja.size // Vrtimo ukrug
            azurirajPitanje()
        }

        binding.tekstPitanjaView.setOnClickListener {
            indeks = (indeks + 1) % bankaPitanja.size // Vrtimo ukrug
            azurirajPitanje()
        }

        binding.dugmePrethodno.setOnClickListener {
            indeks = (indeks - 1 + bankaPitanja.size) % bankaPitanja.size // Vrtimo ukrug
            azurirajPitanje()
        }

        azurirajPitanje()
    }
    private fun azurirajPitanje() {
        val tekstPitanjaResId = bankaPitanja[indeks].tekstResId
        binding.tekstPitanjaView.setText(tekstPitanjaResId)
    }

    private fun proveriOdgovor(korisnickiOdgovor: Boolean) {
        val tacanOdgovor = bankaPitanja[indeks].odgovor
        val porukaResId = if (korisnickiOdgovor == tacanOdgovor) {
            R.string.tacno_toast
        } else {
            R.string.netacno_toast
        }
        Toast.makeText(this, porukaResId, Toast.LENGTH_SHORT)
            .show()
    }
}

