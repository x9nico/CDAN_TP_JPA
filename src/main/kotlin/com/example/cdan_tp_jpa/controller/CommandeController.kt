package com.example.cdan_tp_jpa.controller

import com.example.cdan_tp_jpa.entities.Commandes
import com.example.cdan_tp_jpa.repositories.CommandeRepository
import com.example.cdan_tp_jpa.repositories.LegumeRepository
import jakarta.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class CommandeController(@Autowired private val commandeRepository: CommandeRepository,
                         @Autowired private val legumeRepository: LegumeRepository
) {

    @GetMapping("/")
    fun afficherFormulaireCommande(model: Model, httpSession: HttpSession): String {
        //val fruitsActivés = fruitsRepository.findByActif(true);
        //println(fruitsActivés)
        val légumesActivés = legumeRepository.findByActif(true)
        //model.addAttribute("fruits", fruitsActivés)
        val legumes = légumesActivés.filter { it.is_legume == true }
        val fruits = légumesActivés.filter { it.is_legume == false }
        model.addAttribute("legumes", legumes)
        model.addAttribute("fruits", fruits)
        model.addAttribute("commande", Commandes())
        return "formulaire-commande"
    }

    @PostMapping("/commande")
    fun enregistrerCommande(@ModelAttribute("commande") commande: Commandes): String {
        println("commande=$commande")
        commandeRepository.save(commande)
        return "confirmation-commande"
    }

    @GetMapping("/admin")
    fun afficherPageAdmin(model: Model): String {
        //val fruits = fruitRepository.findAll()
        val légumes = legumeRepository.findAll()
        //model.addAttribute("fruits", fruits)
        model.addAttribute("legumes", légumes)
        return "admin-page"
    }

    /*@PostMapping("/admin/activerFruit/{fruitId}")
    fun activerFruit(@PathVariable("fruitId") fruitId: Long): String {
        val fruit = fruitRepository.findById(fruitId)
        fruit.ifPresent {
            it.actif = true
            fruitRepository.save(it)
        }
        return "redirect:/admin"
    }

    @PostMapping("/admin/desactiverFruit/{fruitId}")
    fun desactiverFruit(@PathVariable("fruitId") fruitId: Long): String {
        val fruit = fruitRepository.findById(fruitId)
        fruit.ifPresent {
            it.actif = false
            fruitRepository.save(it)
        }
        return "redirect:/admin"
    }*/

    @PostMapping("/admin/supprimerLegume/{legumeId}")
    fun supprimerLegume(@PathVariable("legumeId") legumeId: Long): String {
        legumeRepository.deleteById(legumeId)
        return "redirect:/admin"
    }

    @PostMapping("/admin/activerLegume/{legumeId}")
    fun activerLegume(@PathVariable("legumeId") legumeId: Long): String {
        val legumes = legumeRepository.findById(legumeId)
        legumes.ifPresent {
            it.actif = true
            legumeRepository.save(it)
        }
        return "redirect:/admin"
    }

    @PostMapping("/admin/desactiverLegume/{legumeId}")
    fun desactiverLegume(@PathVariable("legumeId") legumeId: Long): String {
        val legume = legumeRepository.findById(legumeId)
        legume.ifPresent {
            it.actif = false
            legumeRepository.save(it)
        }
        return "redirect:/admin"
    }
}