package br.com.solicita.aprovacao.parcela.domain.exceptions

class RequiredFieldException(requiredField: String) :
        RuntimeException("$requiredField is required")

class InvalidCepFormatException() :
        RuntimeException("invalid cep")

class InvalidUUIDFormatException() :
        RuntimeException("invalid uuid(universally unique identifier) format")