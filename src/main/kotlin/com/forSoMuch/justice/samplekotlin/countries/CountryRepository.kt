package com.forSoMuch.justice.samplekotlin.countries

import io.spring.guides.gs_producing_web_service.Country
import io.spring.guides.gs_producing_web_service.Currency
import org.springframework.stereotype.Repository

@Repository
class CountryRepository {
    fun findCountry(name: String): Country {
        val country = Country()

        country.capital = "Fancy Capital"
        country.currency = Currency.EUR
        country.name = "Best Country"
        country.population = 1000

        return country
    }
}