
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object error extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Option[Throwable],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, e: Option[Throwable]=None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Error")/*2.35*/{_display_(Seq[Any](format.raw/*2.36*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h1>"""),_display_(/*5.12*/title),format.raw/*5.17*/("""</h1>
      """),_display_(if(context.loginAccount.map{_.isAdmin}.getOrElse(false))/*6.64*/{_display_(Seq[Any](format.raw/*6.65*/("""
        """),_display_(/*7.10*/e/*7.11*/.map/*7.15*/ { ex =>_display_(Seq[Any](format.raw/*7.23*/("""
          """),format.raw/*8.11*/("""<h2>"""),_display_(/*8.16*/ex/*8.18*/.toString),format.raw/*8.27*/("""</h2>
          <table class="table table-condensed table-striped table-hover">
            <tbody>
            """),_display_(/*11.14*/ex/*11.16*/.getStackTrace.map/*11.34*/{ st =>_display_(Seq[Any](format.raw/*11.41*/("""
            """),format.raw/*12.13*/("""<tr><td>"""),_display_(/*12.22*/st),format.raw/*12.24*/("""</td></tr>
            """)))}),format.raw/*13.14*/("""
            """),format.raw/*14.13*/("""</tbody>
          </table>
        """)))}),format.raw/*16.10*/("""
      """)))}else/*17.14*/{_display_(Seq[Any](format.raw/*17.15*/("""
        """),format.raw/*18.9*/("""<div>Please contact your administrator.</div>
      """)))}),format.raw/*19.8*/("""
    """),format.raw/*20.5*/("""</div>
  </div>
""")))}),format.raw/*22.2*/("""
"""))
      }
    }
  }

  def render(title:String,e:Option[Throwable],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(title,e)(context)

  def f:((String,Option[Throwable]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (title,e) => (context) => apply(title,e)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/error.scala.html
                  HASH: 0bf26e7eb729aead57f469667861c175938ae09b
                  MATRIX: 627->1|816->98|833->107|865->131|903->132|932->135|1042->219|1067->224|1162->293|1200->294|1236->304|1245->305|1257->309|1302->317|1340->328|1371->333|1381->335|1410->344|1550->457|1561->459|1588->477|1633->484|1674->497|1710->506|1733->508|1788->532|1829->545|1897->582|1928->596|1967->597|2003->606|2086->659|2118->664|2165->681
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|22->5|22->5|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|28->11|28->11|28->11|28->11|29->12|29->12|29->12|30->13|31->14|33->16|34->17|34->17|35->18|36->19|37->20|39->22
                  -- GENERATED --
              */
          