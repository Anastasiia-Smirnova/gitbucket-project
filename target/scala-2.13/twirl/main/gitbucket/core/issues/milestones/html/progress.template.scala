
package gitbucket.core.issues.milestones.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object progress extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Int,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(total: Int, progress: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="progress" style="height: 12px; margin-bottom: 8px;">
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow=""""),_display_(/*3.85*/((progress.toDouble / total.toDouble * 100).toInt)),format.raw/*3.135*/("""" aria-valuemin="0" aria-valuemax="100" style="width: """),_display_(/*3.190*/((progress.toDouble / total.toDouble * 100).toInt)),format.raw/*3.240*/("""%">
  </div>
</div>
"""))
      }
    }
  }

  def render(total:Int,progress:Int): play.twirl.api.HtmlFormat.Appendable = apply(total,progress)

  def f:((Int,Int) => play.twirl.api.HtmlFormat.Appendable) = (total,progress) => apply(total,progress)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/milestones/progress.scala.html
                  HASH: 74f589322c977d1a6eddf77dea51b19962417e6d
                  MATRIX: 597->1|718->29|893->178|964->228|1046->283|1117->333
                  LINES: 14->1|19->2|20->3|20->3|20->3|20->3
                  -- GENERATED --
              */
          