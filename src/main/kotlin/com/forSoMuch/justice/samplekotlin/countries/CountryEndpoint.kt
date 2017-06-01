package com.forSoMuch.justice.samplekotlin.countries

import io.spring.guides.gs_producing_web_service.GetCountryRequest
import io.spring.guides.gs_producing_web_service.GetCountryResponse
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload

@Endpoint
class CountryEndpoint(var countryRepository: CountryRepository) {

    @PayloadRoot(
            namespace = "http://spring.io/guides/gs-producing-web-service",
            localPart = "getCountryRequest"
    )
    @ResponsePayload
    fun getCountry(@RequestPayload request: GetCountryRequest): GetCountryResponse {
        val getCountryResponse = GetCountryResponse()
        getCountryResponse.country = countryRepository.findCountry(request.name)
        return getCountryResponse
    }
}