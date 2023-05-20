package br.com.solicita.aprovacao.parcela.controllers

import br.com.solicita.aprovacao.parcela.core.usecases.BuscaAprovacaoPorIdUseCase
import br.com.solicita.aprovacao.parcela.core.usecases.BuscaAprovacaoUseCase
import br.com.solicita.aprovacao.parcela.core.usecases.SolicitaAprovacaoUseCase
import br.com.solicita.aprovacao.parcela.domain.entities.AprovacaEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/aprovacoes")
class AprovacaoController(
        private val buscaAprovacaoPorIdUseCase: BuscaAprovacaoPorIdUseCase,
        private val buscaAprovacaoUseCase: BuscaAprovacaoUseCase,
        private val solicitaAprovacaoUseCase: SolicitaAprovacaoUseCase)
{

    @GetMapping("/{id}")
    suspend fun buscaPorId(@PathVariable("id") id: Long): ResponseEntity<AprovacaEntity> {
        val aprovacao = buscaAprovacaoPorIdUseCase.execute(id)
        return if (aprovacao != null) {
            ResponseEntity.ok(aprovacao)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    suspend fun buscaTodas(): ResponseEntity<List<AprovacaEntity>> {
        val aprovacoes = buscaAprovacaoUseCase.execute()
        return ResponseEntity.ok(aprovacoes)
    }

    @PostMapping
    suspend fun solicitaAprovacao(@RequestBody command: SolicitaAprovacaoUseCase.SolicitaNovaAprovacaoParcela): ResponseEntity<AprovacaEntity> {
        val aprovacao = solicitaAprovacaoUseCase.execute(command)
        return ResponseEntity.status(HttpStatus.CREATED).body(aprovacao)
    }
}