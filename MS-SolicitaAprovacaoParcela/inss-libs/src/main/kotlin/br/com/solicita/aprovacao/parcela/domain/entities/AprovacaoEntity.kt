package br.com.solicita.aprovacao.parcela.domain.entities

import br.com.solicita.aprovacao.parcela.domain.Entity
import br.com.solicita.aprovacao.parcela.domain.exceptions.InvalidCepFormatException
import br.com.solicita.aprovacao.parcela.domain.exceptions.RequiredFieldException
import java.util.*

data class NewAddress(
        // validar informações do contrato
        val cep: String,
        val street: String,
        val district: String,
        val city: String,
        val state: String
) {
    fun create() = AprovacaoEntity(UUID.randomUUID(), cep, street, district, city, state)
}


data class AprovacaoEntity(
        override val uuid: UUID,
        val cep: String,
        val street: String,
        val district: String,
        val city: String,
        val state: String
) : Entity {
    init {
        if (cep == null || cep == "")
            throw RequiredFieldException("cep")

        if (!cep.matches(Regex("[0-9]{8}")))
            throw InvalidCepFormatException()

        if (street == null || street == "")
            throw RequiredFieldException("street")

        if (district == null || district == "")
            throw RequiredFieldException("district")

        if (city == null || city == "")
            throw RequiredFieldException("city")

        if (state == null || state == "")
            throw RequiredFieldException("state")
    }
}