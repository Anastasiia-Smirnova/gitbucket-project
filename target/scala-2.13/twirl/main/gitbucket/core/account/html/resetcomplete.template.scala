
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object resetcomplete extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Reset your password")/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h2>Reset your password</h2>
      <p>
        Password has been updated. <a href=""""),_display_(/*7.46*/context/*7.53*/.path),format.raw/*7.58*/("""/signin">Sign-in</a> with new password.
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
                  SOURCE: src/main/twirl/gitbucket/core/account/resetcomplete.scala.html
                  HASH: 83cc6ce94d58ab8bde2afbeb359815824809ab5f
                  MATRIX: 618->1|767->58|784->67|830->105|868->106|897->109|1086->272|1101->279|1126->284|1228->356
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|24->7|24->7|24->7|28->11
                  -- GENERATED --
              */
          