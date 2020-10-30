package ru.bmstu.iu4.task03

import ru.bmstu.iu4.task03.desc.Person
import ru.inforion.lab403.common.extensions.parseJson
import java.io.File

object Start {


    @JvmStatic
    fun main(args: Array<String>) {

        val data = File("generated.json").readText().parseJson<List<Person>>()

        val maxlen = 13

        val table = table().also {
            it.addRow(listOf("Name", "Gender", "Age", "Company", "Balance"), maxlen)
        }

        data.forEach {
            val values = listOf(
                    it.name.replace(" ", "_"),
                    it.gender,
                    it.age.toString(),
                    it.company,
                    it.balance)
            table.addRow(values, maxlen)
        }

        val res = table.stringify()


    }

}