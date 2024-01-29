
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object resetform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(token: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Reset your password")/*2.49*/{_display_(Seq[Any](format.raw/*2.50*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <h2>Reset your password</h2>
      <form action=""""),_display_(/*6.22*/context/*6.29*/.path),format.raw/*6.34*/("""/reset/form" method="POST" validate="true" autocomplete="off">
        <fieldset class="form-group">
          Enter new password:
          <input type="password" name="password" id="password" class="form-control" value="" style="max-width: 400px;"/>
          <span id="error-password" class="error"></span>
        </fieldset>
        <input type="submit" class="btn btn-success" value="Submit"/>
        <input type="hidden" name="token" id="token" value=""""),_display_(/*13.62*/token),format.raw/*13.67*/(""""/>
      </form>
    </div>
  </div>
""")))}),format.raw/*17.2*/("""
"""))
      }
    }
  }

  def render(token:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(token)(context)

  def f:((String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (token) => (context) => apply(token)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/resetform.scala.html
                  HASH: 66f3dd7c279ec5991134de58bc530c12db1d392b
                  MATRIX: 621->1|783->71|800->80|846->118|884->119|913->122|1068->251|1083->258|1108->263|1596->724|1622->729|1691->768
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|23->6|23->6|23->6|30->13|30->13|34->17
                  -- GENERATED --
              */
          