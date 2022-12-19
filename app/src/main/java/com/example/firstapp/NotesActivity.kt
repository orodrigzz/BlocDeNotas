package com.example.firstapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityNotesBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private val llmanager = LinearLayoutManager(this)
    private var ad: InterstitialAd? = null

    private var notes = listOf(
        "NotaPredeterminada1",
        "NotaPredeterminada2",
        "NotaPredeterminada3",
        "NotaPredeterminada4",
        "NotaPredeterminada5",
        "NotaPredeterminada6",
        "NotaPredeterminada7",
        "NotaPredeterminada8",
        "NotaPredeterminada9",
        "NotaPredeterminada10",
        "NotaPredeterminada11",
        "NotaPredeterminada12",
        "NotaPredeterminada13")

    private var lista = notes.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = NotesRecyclerViewAdapter(lista,this)

        MobileAds.initialize(this)

        val somethif = this

        binding.addButton.setOnClickListener {
            createNota()
        }
    }

    private fun createNota(){
        val nota = Nota(
            "NotaCreada"
        )

        lista.add(index = 3, nota.toString())
        binding.particlesRecyclerView.adapter?.notifyItemInserted(3)
        llmanager.scrollToPositionWithOffset(3,10)

    }
    override fun onResume() {
        super.onResume()

        val request = AdRequest.Builder().build()
        binding.adView.loadAd(request)
        binding.adView.adListener = object : AdListener() {
            override fun onAdClicked() {
                super.onAdClicked()
            }

            override fun onAdClosed() {
                super.onAdClosed()
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
            }

            override fun onAdOpened() {
                super.onAdOpened()
            }
        }

        loadAd(this)
    }

    fun loadAd(activity: Activity) {
        val request = AdRequest.Builder().build()

        InterstitialAd.load(
            activity,
            "ca-app-pub-3940256099942544/1033173712",
            request,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(loadedAd: InterstitialAd) {
                    ad = loadedAd
                }
            })
    }
}