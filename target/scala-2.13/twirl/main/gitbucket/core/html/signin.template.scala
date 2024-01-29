
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object signin extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Option[Any],Option[Any],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userName: Option[Any] = None,
  password: Option[Any] = None,
  error: Option[Any] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Sign in")/*4.37*/{_display_(Seq[Any](format.raw/*4.38*/("""
  """),format.raw/*5.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
      <div class="signin-form">
        """),_display_(if(context.settings.basicBehavior.allowAnonymousAccess)/*8.65*/{_display_(Seq[Any](format.raw/*8.66*/("""
          """),_display_(/*9.12*/context/*9.19*/.settings.information.map/*9.44*/ { information =>_display_(Seq[Any](format.raw/*9.61*/("""
            """),format.raw/*10.13*/("""<div class="alert alert-info" style="background-color: white; color: #555; border-color: #4183c4; font-size: small; line-height: 120%;">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              """),_display_(/*12.16*/Html(information)),format.raw/*12.33*/("""
            """),format.raw/*13.13*/("""</div>
          """)))}),format.raw/*14.12*/("""
        """)))} else {null} ),format.raw/*15.10*/("""
        """),_display_(/*16.10*/gitbucket/*16.19*/.core.helper.html.error(error)),format.raw/*16.49*/("""
        """),_display_(/*17.10*/gitbucket/*17.19*/.core.html.signinform(context.settings, userName, password)),format.raw/*17.78*/("""
      """),format.raw/*18.7*/("""</div>
    </div>
  </div>
""")))}),format.raw/*21.2*/("""
"""))
      }
    }
  }

  def render(userName:Option[Any],password:Option[Any],error:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(userName,password,error)(context)

  def f:((Option[Any],Option[Any],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (userName,password,error) => (context) => apply(userName,password,error)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/signin.scala.html
                  HASH: 44f4b8e0bcb620c1fb8cabca350c3922d63b8084
                  MATRIX: 639->1|877->147|894->156|928->182|966->183|995->186|1190->355|1228->356|1266->368|1281->375|1314->400|1368->417|1409->430|1676->670|1714->687|1755->700|1804->718|1858->728|1895->738|1913->747|1964->777|2001->787|2019->796|2099->855|2133->862|2191->890
                  LINES: 14->1|21->4|21->4|21->4|21->4|22->5|25->8|25->8|26->9|26->9|26->9|26->9|27->10|29->12|29->12|30->13|31->14|32->15|33->16|33->16|33->16|34->17|34->17|34->17|35->18|38->21
                  -- GENERATED --
              */
          