package com.example.cdan_tp_jpa.repositories

import com.example.cdan_tp_jpa.entities.Fruits
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FruitRepository : JpaRepository<Fruits, Long> {
    fun findByActif(actif: Boolean) : List<Fruits>
}