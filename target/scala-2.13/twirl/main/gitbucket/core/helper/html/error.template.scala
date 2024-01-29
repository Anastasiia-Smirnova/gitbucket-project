
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object error extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Option[Any],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(error: Option[Any]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(error.isDefined)/*2.21*/{_display_(Seq[Any](format.raw/*2.22*/("""
"""),format.raw/*3.1*/("""<div class='alert alert-danger'>
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    """),_display_(/*5.6*/error),format.raw/*5.11*/("""
"""),format.raw/*6.1*/("""</div>
""")))} else {null} ))
      }
    }
  }

  def render(error:Option[Any]): play.twirl.api.HtmlFormat.Appendable = apply(error)

  def f:((Option[Any]) => play.twirl.api.HtmlFormat.Appendable) = (error) => apply(error)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/error.scala.html
                  HASH: 83f936adea8d74c25aff17a8dbbd8846cc970957
                  MATRIX: 587->1|721->42|759->43|786->44|927->160|952->165|979->166
                  LINES: 14->1|19->2|19->2|20->3|22->5|22->5|23->6
                  -- GENERATED --
              */
          