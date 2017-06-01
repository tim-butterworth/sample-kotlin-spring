package com.forSoMuch.justice.samplekotlin.countries

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition
import org.springframework.xml.xsd.SimpleXsdSchema
import org.springframework.xml.xsd.XsdSchema

@EnableWs
@Configuration
class SOAPConfig : WsConfigurerAdapter() {

    @Bean
    fun countriesSchema(): XsdSchema {
        val classPathResource = ClassPathResource("countries.xsd")

        println(classPathResource.path)
        println(classPathResource.file.absolutePath)

        return SimpleXsdSchema(classPathResource)
    }

    @Bean("messageDispatcherServlet")
    fun servlet(applicationContext: ApplicationContext): ServletRegistrationBean {
        val servlet = MessageDispatcherServlet()

        servlet.setApplicationContext(applicationContext)
        servlet.isTransformWsdlLocations = true

        return ServletRegistrationBean(servlet, "/ws/*")
    }

    @Bean("countries")
    fun defaultWsdl11Definition(countriesSchema: XsdSchema): DefaultWsdl11Definition {
        val wsdl11Definition = DefaultWsdl11Definition()

        wsdl11Definition.setPortTypeName("CountriesPort")
        wsdl11Definition.setLocationUri("/ws")
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service")
        wsdl11Definition.setSchema(countriesSchema)

        return wsdl11Definition
    }
}