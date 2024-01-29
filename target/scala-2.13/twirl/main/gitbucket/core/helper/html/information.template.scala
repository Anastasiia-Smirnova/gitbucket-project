
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object information extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Option[Any],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(info: Option[Any]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(info.isDefined)/*2.20*/{_display_(Seq[Any](format.raw/*2.21*/("""
  """),format.raw/*3.3*/("""<div class="alert alert-info">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    """),_display_(/*5.6*/info),format.raw/*5.10*/("""
  """),format.raw/*6.3*/("""</div>
""")))} else {null} ),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(info:Option[Any]): play.twirl.api.HtmlFormat.Appendable = apply(info)

  def f:((Option[Any]) => play.twirl.api.HtmlFormat.Appendable) = (info) => apply(info)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/information.scala.html
                  HASH: 9993ead6c9432612b87328355eab15cbab45505e
                  MATRIX: 593->1|725->40|763->41|792->44|931->158|955->162|984->165|1034->173
                  LINES: 14->1|19->2|19->2|20->3|22->5|22->5|23->6|24->7
                  -- GENERATED --
              */
          