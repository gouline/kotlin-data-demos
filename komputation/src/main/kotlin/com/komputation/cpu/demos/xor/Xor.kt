package com.komputation.cpu.demos.xor

import com.komputation.cpu.network.network
import com.komputation.demos.xor.XorData
import com.komputation.initialization.heInitialization
import com.komputation.instructions.continuation.activation.Activation
import com.komputation.instructions.continuation.dense.dense
import com.komputation.instructions.entry.input
import com.komputation.instructions.loss.logisticLoss
import com.komputation.loss.printLoss
import com.komputation.optimization.historical.nesterov
import java.util.*

fun main(args: Array<String>) {

    val inputDimension = 2
    val hiddenDimension = 2
    val outputDimension = 1
    val batchSize = 4

    val random = Random(1)

    val initialization = heInitialization(random)
    val optimization = nesterov(0.1f, 0.9f)

    network(
        batchSize,
        input(inputDimension),
        dense(hiddenDimension, Activation.Sigmoid, initialization, optimization),
        dense(outputDimension, Activation.Sigmoid, initialization, optimization)
    )
        .training(
            XorData.input,
            XorData.targets,
            10_000,
            logisticLoss(),
            printLoss)
        .run()

}