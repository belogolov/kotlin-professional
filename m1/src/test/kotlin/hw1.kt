import kotlin.test.Test
import kotlin.test.assertEquals

/*
* Реализовать функцию, которая преобразует список словарей строк в ФИО
* Функцию сделать с использованием разных функций для разного числа составляющих имени
* Итого, должно получиться 4 функции
*
* Для успешного решения задания, требуется раскомментировать тест, тест должен выполняться успешно
* */
class HomeWork1Test {

    @Test
    fun mapListToNamesTest() {
        val input = listOf(
            mapOf(
                "first" to "Иван",
                "middle" to "Васильевич",
                "last" to "Рюрикович",
            ),
            mapOf(
                "first" to "Петька",
            ),
            mapOf(
                "first" to "Сергей",
                "last" to "Королев",
            ),
        )
        val expected = listOf(
            "Рюрикович Иван Васильевич",
            "Петька",
            "Королев Сергей",
        )
        val res = mapListToNames(input)
        assertEquals(expected, res)
    }
}

private fun mapListToNames(input: List<Map<String, String>>): List<String> {
    return input.map {
        with(it.keys) {
            when {
                containsAll(setOf("last", "first", "middle")) -> mapToLFM(it)
                containsAll(setOf("last", "first")) -> mapToLF(it)
                containsAll(setOf("first")) -> mapToF(it)
                else -> ""
            }
        }
    }
}

private fun mapToLFM(input: Map<String, String>) = "${input["last"]} ${input["first"]} ${input["middle"]}"
private fun mapToLF(input: Map<String, String>) = "${input["last"]} ${input["first"]}"
private fun mapToF(input: Map<String, String>) = "${input["first"]}"
