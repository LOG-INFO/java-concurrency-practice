package info.log.domain

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream


data class Person(
    val id: UUID? = null,
    val name: String? = null,
    val age: Int = 0,
) {

    companion object {
        private val NAMES = listOf("Alex", "Cafri", "Henny", "Hyejung", "Leo", "Reaver", "Richard", "Ted")
        private val RANDOM = Random()
        private fun createRandomly(): Person {
            return Person(
                UUID.randomUUID(),
                NAMES[RANDOM.nextInt(NAMES.size)],
                RANDOM.nextInt(50)
            )
        }

        @Throws(InterruptedException::class)
        fun createPeopleListRandomly(): List<Person> {
            Thread.sleep(200)
            return IntStream.range(0, 50).boxed()
                .map { e: Int? -> createRandomly() }
                .collect(Collectors.toList())
        }

        fun createPeopleFluxRandomly(): Flux<Person> {
            return Mono.delay(Duration.of(200, ChronoUnit.MILLIS))
                .flatMapMany { Flux.range(0, 50) }
                .map { createRandomly() }
        }
    }
}

