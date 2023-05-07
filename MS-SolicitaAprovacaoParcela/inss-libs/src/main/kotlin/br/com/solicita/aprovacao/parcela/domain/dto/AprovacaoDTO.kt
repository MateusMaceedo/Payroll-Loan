package br.com.solicita.aprovacao.parcela.domain.dto

import br.com.solicita.aprovacao.parcela.core.utils.SnowflakeID
import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity
import java.time.Instant

data class AprovacaDTO(
        val id: Long?,
        val movieId: Long,
        val version: Int?,
        val name: String,
        val createdAt: Instant?,
        val updatedAt: Instant?
) {
    companion object {
        // TODO: método "fromEntity" para transformar a entidade em DTO;
        fun fromEntity(entity: AprovacaEntity): AprovacaDTO {
            return AprovacaDTO(
                    id = entity.id,
                    movieId = entity.movieId,
                    version = entity.version,
                    name = entity.name,
                    createdAt = entity.createdAt,
                    updatedAt = entity.updatedAt
            )
        }
    }

    // TODO: método "toEntity" para transformar o DTO em entidade.
    fun toEntity(): AprovacaEntity {
        return AprovacaEntity(
                id = this.id ?: SnowflakeID.nextId(),
                movieId = this.movieId,
                version = this.version ?: 0,
                name = this.name,
                createdAt = this.createdAt ?: Instant.now(),
                updatedAt = this.updatedAt ?: Instant.now()
        )
    }
}