package br.com.solicita.aprovacao.parcela.core.usecases.impl

import br.com.solicita.aprovacao.parcela.core.usecases.BuscaAprovacaoUseCase
import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity
import br.com.solicita.aprovacao.parcela.infra.adapters.database.SolicitaAprovacaoRepository

class BuscaAprovacaoUseCaseImpl(
    private val solicitaAprovacaoRepository: SolicitaAprovacaoRepository
) : BuscaAprovacaoUseCase
{
    override suspend fun execute(): List<AprovacaEntity> {
        TODO("Implementar regra de negocio")
    }
}