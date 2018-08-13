# Komputation Demos

***NOTE:** Developed by [Sebastian E. Kwiatkowski](https://github.com/sekwiatkowski) and originally hosted [here](https://github.com/sekwiatkowski/komputation).*

## CPU demos

- Boolean functions:
  - [AND](./src/main/kotlin/com/komputation/cpu/demos/and/AndSigmoid.kt)
  - [NOT](./src/main/kotlin/com/komputation/cpu/demos/not/Not.kt)
  - [XOR](./src/main/kotlin/com/komputation/cpu/demos/xor/Xor.kt)

- Total:
  - [Fixed length](./src/main/kotlin/com/komputation/cpu/demos/total/FixedLengthTotal.kt)
  - [Variable length](./src/main/kotlin/com/komputation/cpu/demos/total/VariableLengthTotal.kt)

- Running total:
  - Left-to-right:
    - [Fixed length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/lefttoright/FixedLengthRunningTotal.kt)
    - [Variable length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/lefttoright/VariableLengthRunningTotal.kt)
  - Right-to-left:
    - [Fixed length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/righttoleft/RightToLeftFixedLengthRunningTotal.kt)
    - [Variable length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/righttoleft/RightToLeftVariableLengthRunningTotal.kt)
  - Bidirectional:
    - [Fixed length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/bidirectional/BidirectionalFixedLengthRunningTotal.kt)
    - [Variable length](./src/main/kotlin/com/komputation/cpu/demos/runningtotal/bidirectional/BidirectionalVariableLengthRunningTotal.kt)

- Increment:
  - [One layer](./src/main/kotlin/com/komputation/cpu/demos/increment/Increment.kt)
  - [Two layers](./src/main/kotlin/com/komputation/cpu/demos/increment/IncrementTwice.kt)

- Word embedding toy problem:
  - [Feed-forward network](./src/main/kotlin/com/komputation/cpu/demos/embeddings/Embeddings.kt)
  - [CNN with one filter width](./src/main/kotlin/com/komputation/cpu/demos/embeddings/EmbeddingsWithConvolution.kt)
  - [CNN with two filter widths](./src/main/kotlin/com/komputation/cpu/demos/embeddings/EmbeddingsWithTwoFilterWidths.kt)

- [Sequence labeling toy problem](./src/main/kotlin/com/komputation/cpu/demos/sequencelabeling/SequenceLabeling.kt)

- [Computer vision toy problem](./src/main/kotlin/com/komputation/cpu/demos/lines/Lines.kt)

- MNIST:
  - [Minimal](./src/main/kotlin/com/komputation/cpu/demos/mnist/MnistMinimal.kt)
  - [Dropout](./src/main/kotlin/com/komputation/cpu/demos/mnist/MnistBatchDropout.kt)

- TREC:
  - [One filter width](./src/main/kotlin/com/komputation/cpu/demos/trec/TREC.kt)
  - [Two filter widths](./src/main/kotlin/com/komputation/cpu/demos/trec/TRECWithTwoFilterWidths.kt)
