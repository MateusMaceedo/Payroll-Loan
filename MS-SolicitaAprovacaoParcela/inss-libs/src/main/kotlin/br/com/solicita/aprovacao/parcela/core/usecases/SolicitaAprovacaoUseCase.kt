package br.com.solicita.aprovacao.parcela.core.usecases

import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity

interface SolicitaAprovacaoUseCase {

    suspend fun execute(aCommand: SolicitaNovaAprovacaoParcela): AprovacaEntity

    data class SolicitaNovaAprovacaoParcela(
            val nome: String,
            val id: Long
    )
}