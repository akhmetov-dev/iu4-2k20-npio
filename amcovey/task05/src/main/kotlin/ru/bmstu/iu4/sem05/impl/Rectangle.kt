package ru.bmstu.iu4.sem05.impl

import ru.bmstu.iu4.sem05.abstracts.AbstractFigure
import ru.bmstu.iu4.sem05.common.Plot
import java.io.Writer

class Rectangle(val lb: Point, val rt: Point, tag: Int): AbstractFigure(tag) {

    val width get() = rt.x - lb.x
    val height get() = rt.y - lb.y

    override fun area(): Int = width * height

    override fun stringify() = "Rectangle(tag=$tag)"

    override fun draw(plot: Plot) {
        val rectangleLines = listOf(
            Line(rt, Point(rt.x, lb.y)),
            Line(lb, Point(rt.x, lb.y)),
            Line(Point(lb.x, rt.y), rt),
            Line(Point(lb.x, rt.y), lb)
        )

        rectangleLines.forEach { it.draw(plot) }
    }

    override fun print(writer: Writer) {
        writer.write(stringify())
    }

    init {
        require(lb.x < rt.x)
        require(lb.y > rt.y)
    }
}