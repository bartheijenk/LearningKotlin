package h14


class MyCollection<E> : Collection<E> {

    private var next: Element<E>? = null
    private lateinit var last: Element<E>

    override var size: Int = 0

    override fun contains(element: E): Boolean {
        return true
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        return true
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<E> {
        return ElementIterator()
    }

    fun push(e: E) {
        when {
            isEmpty() -> {
                next = Element(e)
                last = next!!
            }
            else -> {
                val newElement = Element(e)
                last.next = newElement
                last = newElement
            }
        }
        size++
    }

    fun pop(): E? {
        return if (isNotEmpty()) {
            this.size--
            val temp = this.next!!
            this.next = if (this.next?.next == null) {
                null
            } else {
                this.next!!.next!!
            }
            temp.e
        } else
            null

    }

    private inner class ElementIterator : Iterator<E> {
        var current = next
        var upcoming = current?.next
        override fun hasNext(): Boolean {
            return upcoming != current
        }

        override fun next(): E {
            val output = current?.e
            current = current?.next
            upcoming = current?.next
            return output!!
        }

    }

}

private class Element<E>(val e: E) {
    var next: Element<E>? = null
}
