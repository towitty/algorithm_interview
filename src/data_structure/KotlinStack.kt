package data_structure

import java.util.Stack

class KotlinStack<E> {
    private val stack = mutableListOf<E>()

    fun push(element: E) = stack.add(element)

    fun pop(): E = stack.removeLast()

    fun peek(): E = stack.last()
}