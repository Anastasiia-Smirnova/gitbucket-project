
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object checkicon extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(condition: => Boolean):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(if(condition)/*2.15*/{_display_(Seq[Any](format.raw/*2.16*/("""
  """),format.raw/*3.3*/("""<i class="octicon octicon-check"></i>
""")))}else/*4.8*/{_display_(Seq[Any](format.raw/*4.9*/("""
  """),format.raw/*5.3*/("""<i class="octicon"></i>
""")))}))
      }
    }
  }

  def render(condition:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(condition)

  def f:((=> Boolean) => play.twirl.api.HtmlFormat.Appendable) = (condition) => apply(condition)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/checkicon.scala.html
                  HASH: 2a352730fa3eb3099e59aa6db99dd085830c8dad
                  MATRIX: 587->1|718->39|756->40|785->43|845->88|882->89|911->92
                  LINES: 14->1|19->2|19->2|20->3|21->4|21->4|22->5
                  -- GENERATED --
              */
          