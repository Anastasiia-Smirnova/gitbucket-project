
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object mergecheck extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(hasConflict: Boolean):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div style="margin-top: 8px;">
  """),_display_(if(hasConflict)/*3.19*/{_display_(Seq[Any](format.raw/*3.20*/("""
    """),format.raw/*4.5*/("""<i class="octicon octicon-x" style="color: #bd2c00"></i>
    <span class="strong" style="color: #bd2c00;">Can’t automatically merge.</span>
    <span class="muted">Don’t worry, you can still create the pull request.</span>
  """)))}else/*7.10*/{_display_(Seq[Any](format.raw/*7.11*/("""
    """),format.raw/*8.5*/("""<i class="octicon octicon-check" style="color: #6cc644"></i>
    <span class="strong" style="color: #6cc644">Able to merge.</span>
    <span class="muted">These branches can be automatically merged.</span>
  """)))}),format.raw/*11.4*/("""
"""),format.raw/*12.1*/("""</div>
"""))
      }
    }
  }

  def render(hasConflict:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(hasConflict)

  def f:((Boolean) => play.twirl.api.HtmlFormat.Appendable) = (hasConflict) => apply(hasConflict)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/mergecheck.scala.html
                  HASH: 7b266fa36d1d3c9000e05147bd6b1adf73e7fdde
                  MATRIX: 587->1|703->24|778->73|816->74|847->79|1095->311|1133->312|1164->317|1403->526|1431->527
                  LINES: 14->1|19->2|20->3|20->3|21->4|24->7|24->7|25->8|28->11|29->12
                  -- GENERATED --
              */
          