package com.vmotta.cleanarch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CleanArchApp

fun main(args: Array<String>) {
    runApplication<CleanArchApp>(*args)
}