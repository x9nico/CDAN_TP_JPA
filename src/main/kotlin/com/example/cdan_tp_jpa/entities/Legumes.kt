package com.example.cdan_tp_jpa.entities

import jakarta.persistence.*

@Entity
data class Legumes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nom: String = "",

    @Column(nullable = false)
    var actif : Boolean = true,
)