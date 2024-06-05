package com.mhendrif.jetheroes.data

import com.mhendrif.jetheroes.model.Hero
import com.mhendrif.jetheroes.model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes
            .filter {
                it.name.contains(query.trim(), ignoreCase = true)
            }
    }
}