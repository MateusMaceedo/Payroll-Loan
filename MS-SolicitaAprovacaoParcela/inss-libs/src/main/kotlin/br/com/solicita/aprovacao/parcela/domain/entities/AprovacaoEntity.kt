package br.com.solicita.aprovacao.parcela.domain.entities

import br.com.solicita.aprovacao.parcela.core.utils.SnowflakeID
import java.time.Instant

data class AprovacaEntity(
        //TODO: Validar o contrato de persistencia
        val id: Long,
        val movieId: Long,
        val version: Int,
        val name: String,
        val createdAt: Instant,
        val updatedAt: Instant,
) {

    companion object {
        fun newProduction(name: String, movieId: Long): AprovacaEntity {
            val id = SnowflakeID.nextId()
            val now = Instant.now()
            return AprovacaEntity(
                    id = id,
                    version = 0,
                    movieId = movieId,
                    name = name,
                    createdAt = now,
                    updatedAt = now,
            )
        }
    }
}
