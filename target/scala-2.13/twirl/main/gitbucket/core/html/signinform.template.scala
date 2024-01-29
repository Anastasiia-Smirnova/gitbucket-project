
package gitbucket.core.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object signinform extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[gitbucket.core.service.SystemSettingsService.SystemSettings,Option[Any],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(systemSettings: gitbucket.core.service.SystemSettingsService.SystemSettings,
  userName: Option[Any] = None,
  password: Option[Any] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""<div class="panel panel-default">
  <div class="panel-heading strong">Sign in</div>
  <ul class="list-group list-group-flush">
    """),_display_(if(context.settings.oidcAuthentication)/*7.45*/{_display_(Seq[Any](format.raw/*7.46*/("""
      """),format.raw/*8.7*/("""<li class="list-group-item">
        <form action=""""),_display_(/*9.24*/context/*9.31*/.path),format.raw/*9.36*/("""/signin/oidc" method="POST">
          <input type="hidden" name="hash"/>
          <input type="submit" class="btn btn-success" value="Sign in with OpenID Connect"
          onClick="this.form.hash.value = window.location.hash;"/>
        </form>
      </li>
    """)))} else {null} ),format.raw/*15.6*/("""
    """),format.raw/*16.5*/("""<li class="list-group-item">
      <form action=""""),_display_(/*17.22*/context/*17.29*/.path),format.raw/*17.34*/("""/signin" method="POST" validate="true" autocomplete="off">
        <div class="form-group">
          <label for="userName">Username:</label>
          <span id="error-userName" class="error"></span>
          <input type="text" name="userName" id="userName" class="form-control" autofocus value=""""),_display_(/*21.99*/userName),format.raw/*21.107*/(""""/>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <span id="error-password" class="error"></span>
          <input type="password" name="password" id="password" class="form-control" value=""""),_display_(/*26.93*/password),format.raw/*26.101*/(""""/>
          """),_display_(if(systemSettings.basicBehavior.allowResetPassword)/*27.63*/{_display_(Seq[Any](format.raw/*27.64*/("""
            """),format.raw/*28.13*/("""<a href=""""),_display_(/*28.23*/context/*28.30*/.path),format.raw/*28.35*/("""/reset">Forgot password?</a>
          """)))} else {null} ),format.raw/*29.12*/("""
        """),format.raw/*30.9*/("""</div>
        <input type="hidden" name="hash"/>
        <div>
          <input type="submit" class="btn btn-success btn-block" value="Sign in" onClick="this.form.hash.value = window.location.hash;"/>
        </div>
      </form>
    </li>
  </ul>
</div>
"""),_display_(if(systemSettings.basicBehavior.allowAccountRegistration)/*39.59*/{_display_(Seq[Any](format.raw/*39.60*/("""
  """),format.raw/*40.3*/("""<div class="panel panel-default">
    <ul class="list-group list-group-flush">
      <li class="list-group-item text-center">
        <a href=""""),_display_(/*43.19*/context/*43.26*/.path),format.raw/*43.31*/("""/register">Create account</a>
      </li>
    </ul>
  </div>
""")))} else {null} ),format.raw/*47.2*/("""
"""))
      }
    }
  }

  def render(systemSettings:gitbucket.core.service.SystemSettingsService.SystemSettings,userName:Option[Any],password:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(systemSettings,userName,password)(context)

  def f:((gitbucket.core.service.SystemSettingsService.SystemSettings,Option[Any],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (systemSettings,userName,password) => (context) => apply(systemSettings,userName,password)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/signinform.scala.html
                  HASH: 63622114db6231cc94bec340c4a48aee82ed1271
                  MATRIX: 691->1|979->196|1176->367|1214->368|1247->375|1325->427|1340->434|1365->439|1673->704|1705->709|1782->759|1798->766|1824->771|2149->1069|2179->1077|2458->1329|2488->1337|2581->1403|2620->1404|2661->1417|2698->1427|2714->1434|2740->1439|2824->1479|2860->1488|3201->1802|3240->1803|3270->1806|3441->1950|3457->1957|3483->1962|3588->2024
                  LINES: 14->1|21->4|24->7|24->7|25->8|26->9|26->9|26->9|32->15|33->16|34->17|34->17|34->17|38->21|38->21|43->26|43->26|44->27|44->27|45->28|45->28|45->28|45->28|46->29|47->30|56->39|56->39|57->40|60->43|60->43|60->43|64->47
                  -- GENERATED --
              */
          