
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object application extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[gitbucket.core.model.Account,List[gitbucket.core.model.AccessToken],Option[(gitbucket.core.model.AccessToken, String)],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account,
  personalTokens: List[gitbucket.core.model.AccessToken],
  generatedToken: Option[(gitbucket.core.model.AccessToken, String)])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main("Applications")/*4.42*/{_display_(Seq[Any](format.raw/*4.43*/("""
  """),_display_(/*5.4*/gitbucket/*5.13*/.core.account.html.menu("application", context.loginAccount.get.userName, false)/*5.93*/{_display_(Seq[Any](format.raw/*5.94*/("""
    """),format.raw/*6.5*/("""<div class="panel panel-default">
      <div class="panel-heading strong">Personal access tokens</div>
      <div class="panel-body">
        """),_display_(if(personalTokens.isEmpty && generatedToken.isEmpty)/*9.62*/{_display_(Seq[Any](format.raw/*9.63*/("""
          """),format.raw/*10.11*/("""No tokens.
        """)))}else/*11.16*/{_display_(Seq[Any](format.raw/*11.17*/("""
          """),format.raw/*12.11*/("""Tokens you have generated which can be used to access the GitBucket API.
          <hr style="margin-top: 10px;">
        """)))}),format.raw/*14.10*/("""
        """),_display_(/*15.10*/generatedToken/*15.24*/.map/*15.28*/ { case (token, tokenString) =>_display_(Seq[Any](format.raw/*15.59*/("""
          """),format.raw/*16.11*/("""<div class="alert alert-info">
            Make sure to copy your new personal access token now. You won't be able to see it again!
          </div>
          <a href=""""),_display_(/*19.21*/context/*19.28*/.path),format.raw/*19.33*/("""/"""),_display_(/*19.35*/account/*19.42*/.userName),format.raw/*19.51*/("""/_personalToken/delete/"""),_display_(/*19.75*/token/*19.80*/.accessTokenId),format.raw/*19.94*/("""" class="btn btn-sm btn-danger pull-right">Delete</a>
          <div style="width: 50%;">
            """),_display_(/*21.14*/gitbucket/*21.23*/.core.helper.html.copy("generated-token", "generated-token-copy", tokenString)/*21.101*/{_display_(Seq[Any](format.raw/*21.102*/("""
              """),format.raw/*22.15*/("""<input type="text" value=""""),_display_(/*22.42*/tokenString),format.raw/*22.53*/("""" class="form-control input-sm" id="generated-token" readonly>
            """)))}),format.raw/*23.14*/("""
          """),format.raw/*24.11*/("""</div>
          <hr style="margin-top: 10px;">
        """)))}),format.raw/*26.10*/("""
        """),_display_(/*27.10*/personalTokens/*27.24*/.zipWithIndex.map/*27.41*/ { case (token, i) =>_display_(Seq[Any](format.raw/*27.62*/("""
          """),_display_(if(i != 0)/*28.22*/{_display_(Seq[Any](format.raw/*28.23*/("""
            """),format.raw/*29.13*/("""<hr>
          """)))} else {null} ),format.raw/*30.12*/("""
          """),format.raw/*31.11*/("""<strong style="line-height: 30px;">"""),_display_(/*31.47*/token/*31.52*/.note),format.raw/*31.57*/("""</strong>
          <a href=""""),_display_(/*32.21*/context/*32.28*/.path),format.raw/*32.33*/("""/"""),_display_(/*32.35*/account/*32.42*/.userName),format.raw/*32.51*/("""/_personalToken/delete/"""),_display_(/*32.75*/token/*32.80*/.accessTokenId),format.raw/*32.94*/("""" class="btn btn-sm btn-danger pull-right">Delete</a>
        """)))}),format.raw/*33.10*/("""
      """),format.raw/*34.7*/("""</div>
    </div>
    <form method="POST" action=""""),_display_(/*36.34*/context/*36.41*/.path),format.raw/*36.46*/("""/"""),_display_(/*36.48*/account/*36.55*/.userName),format.raw/*36.64*/("""/_personalToken" validate="true" autocomplete="off">
      <div class="panel panel-default">
        <div class="panel-heading strong">Generate new token</div>
        <div class="panel-body">
          <fieldset>
            <label for="note" class="strong">Token description</label>
            <div><span id="error-note" class="error"></span></div>
            <input type="text" name="note" id="note" class="form-control"/>
            <p class="muted">What is this token for?</p>
          </fieldset>
          <input type="submit" class="btn btn-success" value="Generate token"/>
        </div>
      </div>
    </form>
  """)))}),format.raw/*50.4*/("""
""")))}),format.raw/*51.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,personalTokens:List[gitbucket.core.model.AccessToken],generatedToken:Option[(gitbucket.core.model.AccessToken, String)],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,personalTokens,generatedToken)(context)

  def f:((gitbucket.core.model.Account,List[gitbucket.core.model.AccessToken],Option[(gitbucket.core.model.AccessToken, String)]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,personalTokens,generatedToken) => (context) => apply(account,personalTokens,generatedToken)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/application.scala.html
                  HASH: 829fd1669133ea7682c645ebdfb6dd9f6d4fb643
                  MATRIX: 735->1|1049->223|1066->232|1105->263|1143->264|1172->268|1189->277|1277->357|1315->358|1346->363|1567->558|1605->559|1644->570|1687->596|1726->597|1765->608|1919->731|1956->741|1979->755|1992->759|2061->790|2100->801|2296->970|2312->977|2338->982|2367->984|2383->991|2413->1000|2464->1024|2478->1029|2513->1043|2643->1146|2661->1155|2749->1233|2789->1234|2832->1249|2886->1276|2918->1287|3025->1363|3064->1374|3152->1431|3189->1441|3212->1455|3238->1472|3297->1493|3346->1515|3385->1516|3426->1529|3486->1545|3525->1556|3588->1592|3602->1597|3628->1602|3685->1632|3701->1639|3727->1644|3756->1646|3772->1653|3802->1662|3853->1686|3867->1691|3902->1705|3996->1768|4030->1775|4108->1826|4124->1833|4150->1838|4179->1840|4195->1847|4225->1856|4885->2486|4917->2488
                  LINES: 14->1|21->4|21->4|21->4|21->4|22->5|22->5|22->5|22->5|23->6|26->9|26->9|27->10|28->11|28->11|29->12|31->14|32->15|32->15|32->15|32->15|33->16|36->19|36->19|36->19|36->19|36->19|36->19|36->19|36->19|36->19|38->21|38->21|38->21|38->21|39->22|39->22|39->22|40->23|41->24|43->26|44->27|44->27|44->27|44->27|45->28|45->28|46->29|47->30|48->31|48->31|48->31|48->31|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|50->33|51->34|53->36|53->36|53->36|53->36|53->36|53->36|67->50|68->51
                  -- GENERATED --
              */
          