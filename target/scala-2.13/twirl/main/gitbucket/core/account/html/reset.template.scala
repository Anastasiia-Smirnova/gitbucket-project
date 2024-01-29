
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object reset extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Reset your password")/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h2>Reset your password</h2>
      <form action=""""),_display_(/*6.22*/context/*6.29*/.path),format.raw/*6.34*/("""/reset" method="POST" validate="true" autocomplete="off">
        <fieldset class="form-group">
          Enter your email address to reset your password.
          <input type="text" name="mailAddress" id="mailAddress" class="form-control" value=""  value="" style="max-width: 400px;"/>
          <span id="error-mailAddress" class="error"></span>
        </fieldset>
        <input type="submit" class="btn btn-success" value="Submit"/>
      </form>
    </div>
  </div>
""")))}),format.raw/*16.2*/("""
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
                  SOURCE: src/main/twirl/gitbucket/core/account/reset.scala.html
                  HASH: 52fc43ffeacd8a9d3b451736ea182ed6e682d488
                  MATRIX: 610->1|759->58|776->67|822->105|860->106|889->109|1044->238|1059->245|1084->250|1588->724
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|23->6|23->6|23->6|33->16
                  -- GENERATED --
              */
          