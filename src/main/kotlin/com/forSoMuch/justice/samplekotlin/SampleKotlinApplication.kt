package com.forSoMuch.justice.samplekotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SampleKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(SampleKotlinApplication::class.java, *args)
}
