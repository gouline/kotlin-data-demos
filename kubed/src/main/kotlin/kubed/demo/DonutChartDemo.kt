package kubed.demo

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.transform.Translate
import javafx.stage.Stage
import kubed.color.scheme.schemeCategory10
import kubed.scale.scaleOrdinal
import kubed.selection.selectAll
import kubed.shape.*
import kotlin.math.min

class DonutChartDemo: Application() {
    override fun start(primaryStage: Stage) {
        val width = 960.0
        val height = 500.0
        val radius = min(width, height) / 2.0

        val root = Group()
        root.translateXProperty().bind(primaryStage.widthProperty().divide(2))
        root.translateYProperty().bind(primaryStage.heightProperty().divide(2))

        data class AgeGroup(val label: String, val population: Int)
        val data = listOf(AgeGroup("<5", 2704659), AgeGroup("5-13", 4499890), AgeGroup("14-17", 2159981),
                AgeGroup("18-24", 3853788), AgeGroup("25-44", 14106543), AgeGroup("45-64", 8819342), AgeGroup("≥65", 612463))

        val color = scaleOrdinal<String, Color> {
            range(schemeCategory10())
            //range(listOf(Color.web("#98abc5"), Color.web("#8a89a6"), Color.web("#7b6888"), Color.web("#6b486b"),
            //             Color.web("#a05d56"), Color.web("#d0743c"), Color.web("#ff8c00")))
            domain(data.map { it.label })
        }

        val arc = arc<PieWedge<AgeGroup>> {
            startAngle { d, _ -> d.startAngle }
            endAngle { d, _ -> d.endAngle }
            fill { d, _ -> color(d.data.label) }

            stroke(Color.WHITE)
            outerRadius(radius - 10)
            innerRadius(radius - 70)
        }

        val text = text<PieWedge<AgeGroup>> {
            text { d, _ -> d.data.label }
            textAnchor(TextAnchor.MIDDLE)
            font(Font("sans-serif", 10.0))
        }

        val pie = pie<AgeGroup> {
            value { d, _, _ -> d.population.toDouble() }
        }

        val g = root.selectAll<PieWedge<AgeGroup>>(".arc")
                    .data(pie(data))
                    .enter()
                    .append { _, _, _ -> Group() }
                    .classed("arc")

        g.append { d, _, _ -> arc(d) }

        g.append { d, _, _ -> text(d) }
         .transform { d, _, _ ->
             val c = arc.centroid(d)
             listOf(Translate(c.x, c.y))
         }

        val scene = Scene(root)
        primaryStage.scene = scene
        primaryStage.width = width
        primaryStage.height = height
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            launch(DonutChartDemo::class.java, *args)
        }
    }
}
