package com.example.cdan_tp_jpa.controller

import com.example.cdan_tp_jpa.entities.Commandes
import com.example.cdan_tp_jpa.repositories.CommandeRepository
import com.example.cdan_tp_jpa.repositories.FruitRepository
import com.example.cdan_tp_jpa.repositories.LegumeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class CommandeController(@Autowired private val commandeRepository: CommandeRepository,
                         @Autowired private val fruitRepository: FruitRepository,
                         @Autowired private val legumeRepository: LegumeRepository
) {

    @GetMapping("/")
    fun afficherFormulaireCommande(model: Model): String {
        val fruitsActivés = fruitRepository.findByActif(true)
        val légumesActivés = legumeRepository.findByActif(true)
        model.addAttribute("fruits", fruitsActivés)
        model.addAttribute("legumes", légumesActivés)
        model.addAttribute("commande", Commandes())
        return "formulaire-commande"
    }

    @PostMapping("/commande")
    fun enregistrerCommande(@ModelAttribute("commande") commande: Commandes): String {
        commandeRepository.save(commande)
        return "confirmation-commande"
    }

    @GetMapping("/admin")
    fun afficherPageAdmin(model: Model): String {
        val fruits = fruitRepository.findAll()
        val légumes = legumeRepository.findAll()
        model.addAttribute("fruits", fruits)
        model.addAttribute("legumes", légumes)
        return "admin-page"
    }

    @PostMapping("/admin/activer/{fruitId}")
    fun activerFruit(@PathVariable("fruitId") fruitId: Long): String {
        val fruit = fruitRepository.findById(fruitId)
        fruit.ifPresent {
            it.actif = true
            fruitRepository.save(it)
        }
        return "redirect:/admin"
    }

    @PostMapping("/admin/desactiver/{fruitId}")
    fun desactiverFruit(@PathVariable("fruitId") fruitId: Long): String {
        val fruit = fruitRepository.findById(fruitId)
        fruit.ifPresent {
            it.actif = false
            fruitRepository.save(it)
        }
        return "redirect:/admin"
    }

    @PostMapping("/admin/supprimer/{fruitId}")
    fun supprimerFruit(@PathVariable("fruitId") fruitId: Long): String {
        fruitRepository.deleteById(fruitId)
        return "redirect:/admin"
    }
}