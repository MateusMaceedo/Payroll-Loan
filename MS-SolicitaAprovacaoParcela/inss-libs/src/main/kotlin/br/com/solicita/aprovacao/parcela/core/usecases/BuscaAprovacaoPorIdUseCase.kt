package br.com.solicita.aprovacao.parcela.core.usecases

import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity

interface BuscaAprovacaoPorIdUseCase {
    suspend fun execute(anId: Long): AprovacaEntity?
}