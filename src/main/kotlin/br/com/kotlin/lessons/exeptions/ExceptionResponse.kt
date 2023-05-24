package br.com.kotlin.lessons.exeptions

import java.util.Date

class ExceptionResponse (
        val timestamp: Date,
        val message: String?,
        val details: String
)