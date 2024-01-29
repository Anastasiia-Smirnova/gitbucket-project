
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object resetsent extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Reset your password")/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h2>Reset your password</h2>
      <p>
        Send an email to you. Check your mailbox.
      </p>
    </div>
  </div>
""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply()(context)

  def f:(() => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = () => (context) => apply()(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/resetsent.scala.html
                  HASH: f5b4c696458b74827500f60158204b16ab0668d7
                  MATRIX: 614->1|763->58|780->67|826->105|864->106|893->109|1123->309
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|28->11
                  -- GENERATED --
              */
          