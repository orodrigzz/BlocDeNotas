package com.example.firstapp.particleslist

class Particle (var name : String, val family : Familiy ,val mass : String, val charge : String, val spin : String){

    enum class Familiy{
        QUARK, LEPTON, GAGUE_BOSSOM, HIGH_BOSSOM
    }
}
