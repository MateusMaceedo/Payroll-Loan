package br.com.solicita.aprovacao.parcela.infra.adapters.database

import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity

interface SolicitaAprovacaoRepository {
    suspend fun criaNovaAprovacao(aProvacaEntity: AprovacaEntity): AprovacaEntity
    suspend fun consultaNovaAprovaca(): List<AprovacaEntity>
    suspend fun consultaNovaAprovacaoPorId(anId: Long): AprovacaEntity?
}