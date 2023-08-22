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

    //@ManyToMany(mappedBy = "commandes_fruits", fetch = FetchType.LAZY)
    //val commandes_fruits: Set<Fruits> = HashSet(),

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "commandes_has_legumes", // Nom table intermédiaire (pivot)
        joinColumns = [JoinColumn(name="commandes")], // ID de cette table dans la table intermédiaire
        inverseJoinColumns = [JoinColumn( name="legumes")]) // ID de la table légume dans la table intermédiaire
    val commandes_legumes: List<Legumes>? = ArrayList()
)