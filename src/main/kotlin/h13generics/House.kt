package h13generics

import h10.Human

class House<T: Human>(var t: T) {

    override fun toString(): String {
        return "This house is owned by [${t.toString()}] and it says [${t.greet()}]."
    }
}