
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object labellist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[gitbucket.core.model.Label],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issueLabels: List[gitbucket.core.model.Label]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(issueLabels.isEmpty)/*2.25*/{_display_(Seq[Any](format.raw/*2.26*/("""
  """),format.raw/*3.3*/("""<li><span class="muted">None yet</span></li>
""")))} else {null} ),format.raw/*4.2*/("""
"""),_display_(/*5.2*/issueLabels/*5.13*/.map/*5.17*/ { label =>_display_(Seq[Any](format.raw/*5.28*/("""
  """),format.raw/*6.3*/("""<li><span class="issue-label" style="background-color: #"""),_display_(/*6.60*/label/*6.65*/.color),format.raw/*6.71*/("""; color: #"""),_display_(/*6.82*/label/*6.87*/.fontColor),format.raw/*6.97*/(""";">"""),_display_(/*6.101*/label/*6.106*/.labelName),format.raw/*6.116*/("""</span></li>
""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(issueLabels:List[gitbucket.core.model.Label]): play.twirl.api.HtmlFormat.Appendable = apply(issueLabels)

  def f:((List[gitbucket.core.model.Label]) => play.twirl.api.HtmlFormat.Appendable) = (issueLabels) => apply(issueLabels)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/labellist.scala.html
                  HASH: e7159f8539540abcaaca7518b26099a6fe785d5f
                  MATRIX: 612->1|777->73|815->74|844->77|932->123|959->125|978->136|990->140|1038->151|1067->154|1150->211|1163->216|1189->222|1226->233|1239->238|1269->248|1300->252|1314->257|1345->267|1388->281
                  LINES: 14->1|19->2|19->2|20->3|21->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|23->6|23->6|23->6|23->6|23->6|23->6|24->7
                  -- GENERATED --
              */
          