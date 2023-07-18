package com.example.cdan_tp_jpa.entities

import jakarta.persistence.*
import java.time.LocalDate


@Entity
data class Commandes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nomClient: String = "",

    @Column(nullable = false)
    val numeroTelephone: String = "",

    @Column(nullable = false)
    val jourRecuperation: LocalDate = LocalDate.now(),

    // Autres attributs...

    @ManyToMany
    val fruits: Set<Fruits> = HashSet(),

    @ManyToMany
    val legumes: Set<Legumes> = HashSet()
)