package br.com.kotlin.lessons

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinLessonsApplication

fun main(args: Array<String>) {
	runApplication<KotlinLessonsApplication>(*args)
}
