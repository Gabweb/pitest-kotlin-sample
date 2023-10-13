package de.esolutions.pitest.showcase

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.Subject
class ReproductionSample {

    private val subject: Subject<List<Location>> = BehaviorSubject.create()

    val observableIntValue =
        subject.map { it.filter(Location::locationPredicate) }.skip(1)

    val observableIntValue0 =
        subject.map { it.filter(Location::locationPredicate) }
            .skip(1)

    val observableIntValue1 =
        subject.distinct().skip(1)

    val observableIntValue2 =
        subject
            .distinct()
            .skip(1)

    fun intList(): Observable<Int> {
        val intList = listOf(1, 2, 3) // expected to be swapped (no swapping on vararg?)

        intList
            .sorted() // expected to be removed
            .filter { it == 1 }
            .filter(Int::intPredicate) // expected to be removed
            .distinct() // expected to be removed
            .forEach {
                println(it)
            }

        val intObservable = Observable.fromIterable(intList)
        intObservable
            .filter { it == 1 }
            .filter(Int::intPredicate)
            .distinct()
            .sorted()
            .skip(1)
            .subscribe {
                println(it)
            }

        val intObservable2 = Observable.just(intList)
            .map { it.filter(Int::intPredicate) } // filter expected to be removed
            .map(List<Int>::filterIntList)
            .subscribe {
                println(it)
            }

        return intObservable
    }

    fun stringList(): Observable<String> {
        val stringList = listOf("1", "2", "3") // expected to be swapped (no swapping on vararg?)

        stringList.sorted() // sorted expected to be removed
            .filter { it == "1" } // filter or condition expected to be removed / expected boolean return value to be replaced
            .filter(String::stringPredicate) // expected to be removed
            .distinct() // expected to be removed
            .forEach {
                println(it)
            }

        val stringObservable = Observable.fromIterable(stringList)
        stringObservable
            .filter { it == "1" }
            .filter(String::stringPredicate)
            .distinct()
            .sorted()
            .skip(1)
            .subscribe {
                println(it)
            }

        return stringObservable
    }

    fun locationList(): Observable<Location> {
        val locationList =
            listOf(
                Location("1"),
                Location("2"),
                Location("3")
            ) // expected to be swapped (no swapping on vararg?)

        locationList.sorted() // sorted expected to be removed
            .filter { it.name == "1" } // filter or condition expected to be removed / expected boolean return value to be replaced
            .filter(Location::locationPredicate) // expected to be removed
            .distinct() // expected to be removed
            .forEach {
                println(it)
            }

        val locationObservable = Observable.fromIterable(locationList)
        locationObservable
            .filter { it.name == "1" }
            .filter(Location::locationPredicate)
            .distinct()
            .sorted()
            .skip(1)
            .subscribe {
                println(it)
            }

        return locationObservable
    }
}

private fun List<Int>.filterIntList(): List<Int> {
    return filter(Int::intPredicate)
}

private fun List<Location>.filterLocationList(): List<Location> {
    return filter(Location::locationPredicate)
}

private fun Int.intPredicate(): Boolean {
    println("")
    return this == 1
}

private fun String.stringPredicate(): Boolean {
    println("")
    return this == "1"
}

private fun Location.locationPredicate(): Boolean {
    println("")
    return this.name == ""
}

data class Location(val name: String) : Comparable<Location> {
    override fun compareTo(other: Location) = name.compareTo(other.name)
}
