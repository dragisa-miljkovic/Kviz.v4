package rs.ac.ftn.kviz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import rs.ac.ftn.kviz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val kvizViewModel: KvizViewModel by viewModels()

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

        binding.tekstPitanjaView.setOnClickListener {
            azurirajPitanje()
        }

        binding.dugmeSledece.setOnClickListener {
            kvizViewModel.prelazakNaSledece()
            azurirajPitanje()
        }

        binding.dugmePrethodno.setOnClickListener {
            kvizViewModel.prelazakNaPrethodno()
            azurirajPitanje()
        }

        azurirajPitanje()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "pozvana metoda onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "pozvana metoda onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "pozvana metoda onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "pozvana metoda onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "pozvana metoda onDestroy()")
    }

    private fun azurirajPitanje() {
        val tekstPitanjaResId = kvizViewModel.tekstTrenutnogPitanja // Nova linija
        binding.tekstPitanjaView.setText(tekstPitanjaResId)
    }

    private fun proveriOdgovor(korisnickiOdgovor: Boolean) {
        val tacanOdgovor = kvizViewModel.odgovorNaTrenutnoPitanje
        val porukaResId = if (korisnickiOdgovor == tacanOdgovor) {
            R.string.tacno_toast
        } else {
            R.string.netacno_toast
        }
        Toast.makeText(this, porukaResId, Toast.LENGTH_SHORT)
            .show()
    }
}

