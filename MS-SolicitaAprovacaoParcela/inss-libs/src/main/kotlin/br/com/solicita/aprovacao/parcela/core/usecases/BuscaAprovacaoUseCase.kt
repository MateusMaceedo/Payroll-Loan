package br.com.solicita.aprovacao.parcela.core.usecases

import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity

interface BuscaAprovacaoUseCase {
    suspend fun execute(): List<AprovacaEntity>
}