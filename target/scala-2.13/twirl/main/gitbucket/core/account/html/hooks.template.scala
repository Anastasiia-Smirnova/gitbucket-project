
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object hooks extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[gitbucket.core.model.Account,List[(gitbucket.core.model.AccountWebHook, Set[gitbucket.core.model.WebHook.Event])],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account,
  webHooks: List[(gitbucket.core.model.AccountWebHook, Set[gitbucket.core.model.WebHook.Event])],
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main("Service Hooks")/*5.43*/{_display_(Seq[Any](format.raw/*5.44*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.account.html.menu("hooks", account.userName, account.isGroupAccount)/*6.87*/{_display_(Seq[Any](format.raw/*6.88*/("""
    """),_display_(/*7.6*/gitbucket/*7.15*/.core.helper.html.information(info)),format.raw/*7.50*/("""
    """),format.raw/*8.5*/("""<div class="panel panel-default">
      <div class="panel-heading strong">
        Webhooks
      </div>
      <div class="panel-body">
        <p>
          These webhooks notify external services when certain events occur within any of your repositories.
          When any of the specified events occur, GitBucket will send a POST request to all of the endpoints (URLs) you provide.
          Learn more about this feature on the <a href="https://github.com/gitbucket/gitbucket/wiki/API-WebHook" target="_blank" rel="noopener">GitBucket Wiki</a>.
        </p>
        <a href=""""),_display_(/*18.19*/helpers/*18.26*/.url(account.userName)),format.raw/*18.48*/("""/_hooks/new" class="btn btn-success pull-right" style="margin-bottom: 10px;">Add webhook</a>

        <table class="table table-condensed" style="margin-bottom:0px;">
          """),_display_(/*21.12*/webHooks/*21.20*/.map/*21.24*/ { case (webHook, events) =>_display_(Seq[Any](format.raw/*21.52*/("""
          """),format.raw/*22.11*/("""<tr><td style="vertical-align: middle;">
            <a href=""""),_display_(/*23.23*/helpers/*23.30*/.url(account.userName)),format.raw/*23.52*/("""/_hooks/edit?url="""),_display_(/*23.70*/helpers/*23.77*/.urlEncode(webHook.url)),format.raw/*23.100*/("""" class="css-truncate" style="max-width:360px">
              <span class="css-truncate-target">"""),_display_(/*24.50*/webHook/*24.57*/.url),format.raw/*24.61*/("""</span>
            </a>
            <em class="css-truncate" style="max-width: 225px;">(<span class="css-truncate-target">"""),_display_(/*26.100*/events/*26.106*/.map(_.name).mkString(", ")),format.raw/*26.133*/("""</span>)</em>
          </td><td>
            <div class="btn-group pull-right">
              <a href=""""),_display_(/*29.25*/helpers/*29.32*/.url(account.userName)),format.raw/*29.54*/("""/_hooks/edit?url="""),_display_(/*29.72*/helpers/*29.79*/.urlEncode(webHook.url)),format.raw/*29.102*/("""" class="btn btn-default">
                <span class="octicon octicon-pencil" aria-label="Edit hook"></span>
              </a>
              <a href=""""),_display_(/*32.25*/helpers/*32.32*/.url(account.userName)),format.raw/*32.54*/("""/_hooks/delete?url="""),_display_(/*32.74*/helpers/*32.81*/.urlEncode(webHook.url)),format.raw/*32.104*/("""" class="btn btn-danger" onclick="return confirm('delete webhook for """),_display_(/*32.174*/webHook/*32.181*/.url),format.raw/*32.185*/(""" """),format.raw/*32.186*/("""?')">
                <span class="octicon octicon-x" aria-label="Remove hook"></span>
              </a>
            </div>
          </td></tr>
          """)))}),format.raw/*37.12*/("""
        """),format.raw/*38.9*/("""</table>
      </div>
    </div>
  """)))}),format.raw/*41.4*/("""
""")))}),format.raw/*42.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,webHooks:List[(gitbucket.core.model.AccountWebHook, Set[gitbucket.core.model.WebHook.Event])],info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,webHooks,info)(context)

  def f:((gitbucket.core.model.Account,List[(gitbucket.core.model.AccountWebHook, Set[gitbucket.core.model.WebHook.Event])],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,webHooks,info) => (context) => apply(account,webHooks,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/hooks.scala.html
                  HASH: 410c928b6b99e045626ca3c6b418547b91777af7
                  MATRIX: 736->1|1020->214|1083->250|1100->259|1140->291|1178->292|1207->296|1224->305|1306->379|1344->380|1375->386|1392->395|1447->430|1478->435|2086->1016|2102->1023|2145->1045|2350->1223|2367->1231|2380->1235|2446->1263|2485->1274|2575->1337|2591->1344|2634->1366|2679->1384|2695->1391|2740->1414|2864->1511|2880->1518|2905->1522|3057->1646|3073->1652|3122->1679|3254->1784|3270->1791|3313->1813|3358->1831|3374->1838|3419->1861|3600->2015|3616->2022|3659->2044|3706->2064|3722->2071|3767->2094|3865->2164|3882->2171|3908->2175|3938->2176|4126->2333|4162->2342|4228->2378|4260->2380
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|25->8|35->18|35->18|35->18|38->21|38->21|38->21|38->21|39->22|40->23|40->23|40->23|40->23|40->23|40->23|41->24|41->24|41->24|43->26|43->26|43->26|46->29|46->29|46->29|46->29|46->29|46->29|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|49->32|54->37|55->38|58->41|59->42
                  -- GENERATED --
              */
          