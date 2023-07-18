package com.example.cdan_tp_jpa.repositories

import com.example.cdan_tp_jpa.entities.Legumes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LegumeRepository : JpaRepository<Legumes, Long> {
    fun findByActif(actif: Boolean) : List<Legumes>

}