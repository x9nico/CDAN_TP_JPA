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
    var url : String = "",

    @Column(nullable = false)
    var actif : Boolean = true,

    @Column(nullable = false)
    var is_legume: Boolean? = false,

    //@ManyToMany(mappedBy = "legumes")
    //var commandes_legumes :List<Commandes>? = null,
)