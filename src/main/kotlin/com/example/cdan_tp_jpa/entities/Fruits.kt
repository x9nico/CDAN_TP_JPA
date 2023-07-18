package com.example.cdan_tp_jpa.entities

import jakarta.persistence.*

@Entity
@Table(name = "fruits")
data class Fruits(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val nom: String = "",

    @Column(nullable = false)
    var actif: Boolean = true
)