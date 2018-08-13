package com.komputation.cpu.demos.and

import com.komputation.cpu.network.network
import com.komputation.demos.and.BinaryAndData
import com.komputation.initialization.heInitialization
import com.komputation.instructions.continuation.activation.Activation
import com.komputation.instructions.continuation.dense.dense
import com.komputation.instructions.entry.input
import com.komputation.instructions.loss.logisticLoss
import com.komputation.loss.printLoss
import com.komputation.matrix.floatMatrix
import com.komputation.optimization.stochasticGradientDescent
import java.util.*

fun main(args: Array<String>) {

    val inputDimension = 2
    val outputDimension = 1
    val batchSize = 4

    val random = Random(1)
    val initialization = heInitialization(random)

    val optimization = stochasticGradientDescent(0.1f)

    val classifier = network(
            batchSize,
            input(inputDimension),
            dense(outputDimension, Activation.Sigmoid, initialization, optimization)
    )

    classifier.training(
            BinaryAndData.inputs,
            BinaryAndData.targets,
            10_000,
            logisticLoss(),
            printLoss)
            .run()

    val predict = { input: FloatArray ->
        val prediction = classifier.predict(floatMatrix(2, 1, *input))
        println("predict(${Arrays.toString(input)}) = ${Arrays.toString(prediction)}")
    }

    predict(floatArrayOf(0f, 0f))
    predict(floatArrayOf(1f, 0f))
    predict(floatArrayOf(0f, 1f))
    predict(floatArrayOf(1f, 1f))
    predict(floatArrayOf(1f, 1f))
}
