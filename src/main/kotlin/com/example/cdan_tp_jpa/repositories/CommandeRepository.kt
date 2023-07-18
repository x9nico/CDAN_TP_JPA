package com.example.cdan_tp_jpa.repositories

import com.example.cdan_tp_jpa.entities.Commandes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommandeRepository : JpaRepository<Commandes, Long> {

}