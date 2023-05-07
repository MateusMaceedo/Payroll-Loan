package br.com.solicita.aprovacao.parcela.core.usecases.impl

import br.com.solicita.aprovacao.parcela.core.usecases.SolicitaAprovacaoUseCase
import br.com.solicita.aprovacao.parcela.domain.dto.AprovacaDTO
import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity
import br.com.solicita.aprovacao.parcela.infra.adapters.database.SolicitaAprovacaoRepository

class SolicitaAprovacaoUseCaseImpl(
        private val solicitaAprovacaoRepository: SolicitaAprovacaoRepository,
) : SolicitaAprovacaoUseCase {
    override suspend fun execute(aCommand: SolicitaAprovacaoUseCase.SolicitaNovaAprovacaoParcela): AprovacaEntity {
        TODO("Not yet implemented")
    }
}