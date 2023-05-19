package br.com.kotlin.lessons

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {
    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
            @PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("The number is invalid!")

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
            @PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("The number is invalid!")

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
            @PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("The number is invalid!")

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
            @PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("The number is invalid!")

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
            @PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedOperationException("The number is invalid!")

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    @RequestMapping(value = ["/square-root/{number}"])
    fun squareRoot(
            @PathVariable(value="number") number: String?
    ): Double {

        if (!isNumeric(number))
            throw UnsupportedOperationException("The number is invalid!")

        return sqrt(convertToDouble(number))
    }

    private fun convertToDouble(stringNumber: String?): Double {
        if (stringNumber.isNullOrBlank()) return 0.0

        val number = stringNumber.replace(",".toRegex(), ".")

        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(stringNumber: String?): Boolean {
        if (stringNumber.isNullOrBlank()) return false

        val number = stringNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]""".toRegex())
    }
}