
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object hooks extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[List[(gitbucket.core.model.WebHook, Set[gitbucket.core.model.WebHook.Event])],gitbucket.core.service.RepositoryService.RepositoryInfo,Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webHooks: List[(gitbucket.core.model.WebHook, Set[gitbucket.core.model.WebHook.Event])],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main("Settings", Some(repository))/*5.56*/{_display_(Seq[Any](format.raw/*5.57*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.html.menu("settings", repository)/*6.52*/{_display_(Seq[Any](format.raw/*6.53*/("""
    """),_display_(/*7.6*/gitbucket/*7.15*/.core.settings.html.menu("hooks", repository)/*7.60*/{_display_(Seq[Any](format.raw/*7.61*/("""
      """),_display_(/*8.8*/gitbucket/*8.17*/.core.helper.html.information(info)),format.raw/*8.52*/("""
      """),format.raw/*9.7*/("""<div class="panel panel-default">
        <div class="panel-heading strong">
          Webhooks
        </div>
        <div class="panel-body">
          <p>
            Webhooks notify external services when certain events occur within this repository.
            When any of the specified events occur, GitBucket will send a POST request to all of the endpoints (URLs) you provide.
            Learn more about this feature on the <a href="https://github.com/gitbucket/gitbucket/wiki/API-WebHook" target="_blank" rel="noopener">GitBucket Wiki</a>.
          </p>
          <a href=""""),_display_(/*19.21*/helpers/*19.28*/.url(repository)),format.raw/*19.44*/("""/settings/hooks/new" class="btn btn-success pull-right" style="margin-bottom: 10px;">Add webhook</a>

          <table class="table table-condensed" style="margin-bottom:0px;">
            """),_display_(/*22.14*/webHooks/*22.22*/.map/*22.26*/ { case (webHook, events) =>_display_(Seq[Any](format.raw/*22.54*/("""
              """),format.raw/*23.15*/("""<tr><td style="vertical-align: middle;">
                <a href=""""),_display_(/*24.27*/helpers/*24.34*/.url(repository)),format.raw/*24.50*/("""/settings/hooks/edit?url="""),_display_(/*24.76*/helpers/*24.83*/.urlEncode(webHook.url)),format.raw/*24.106*/("""" class="css-truncate" style="max-width:360px">
                  <span class="css-truncate-target">"""),_display_(/*25.54*/webHook/*25.61*/.url),format.raw/*25.65*/("""</span>
                </a>
                <em class="css-truncate" style="max-width: 225px;">(<span class="css-truncate-target">"""),_display_(/*27.104*/events/*27.110*/.map(_.name).mkString(", ")),format.raw/*27.137*/("""</span>)</em>
              </td><td>
                <div class="btn-group pull-right">
                  <a href=""""),_display_(/*30.29*/helpers/*30.36*/.url(repository)),format.raw/*30.52*/("""/settings/hooks/edit?url="""),_display_(/*30.78*/helpers/*30.85*/.urlEncode(webHook.url)),format.raw/*30.108*/("""" class="btn btn-default">
                    <span class="octicon octicon-pencil"></span>
                  </a>
                  <a href=""""),_display_(/*33.29*/helpers/*33.36*/.url(repository)),format.raw/*33.52*/("""/settings/hooks/delete?url="""),_display_(/*33.80*/helpers/*33.87*/.urlEncode(webHook.url)),format.raw/*33.110*/("""" class="btn btn-danger" onclick="return confirm('delete webhook for """),_display_(/*33.180*/webHook/*33.187*/.url),format.raw/*33.191*/(""" """),format.raw/*33.192*/("""?')">
                    <span class="octicon octicon-x"></span>
                  </a>
                </div>
              </td></tr>
            """)))}),format.raw/*38.14*/("""
          """),format.raw/*39.11*/("""</table>
        </div>
      </div>
    """)))}),format.raw/*42.6*/("""
  """)))}),format.raw/*43.4*/("""
""")))}),format.raw/*44.2*/("""
"""))
      }
    }
  }

  def render(webHooks:List[(gitbucket.core.model.WebHook, Set[gitbucket.core.model.WebHook.Event])],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(webHooks,repository,info)(context)

  def f:((List[(gitbucket.core.model.WebHook, Set[gitbucket.core.model.WebHook.Event])],gitbucket.core.service.RepositoryService.RepositoryInfo,Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (webHooks,repository,info) => (context) => apply(webHooks,repository,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/hooks.scala.html
                  HASH: 176f0532918cd1e8240fa9f4ce4024ab7ed8fdbf
                  MATRIX: 757->1|1064->237|1127->273|1144->282|1197->327|1235->328|1264->332|1281->341|1328->380|1366->381|1397->387|1414->396|1467->441|1505->442|1538->450|1555->459|1610->494|1643->501|2256->1087|2272->1094|2309->1110|2526->1300|2543->1308|2556->1312|2622->1340|2665->1355|2759->1422|2775->1429|2812->1445|2865->1471|2881->1478|2926->1501|3054->1602|3070->1609|3095->1613|3255->1745|3271->1751|3320->1778|3464->1895|3480->1902|3517->1918|3570->1944|3586->1951|3631->1974|3801->2117|3817->2124|3854->2140|3909->2168|3925->2175|3970->2198|4068->2268|4085->2275|4111->2279|4141->2280|4322->2430|4361->2441|4433->2483|4467->2487|4499->2489
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|26->9|36->19|36->19|36->19|39->22|39->22|39->22|39->22|40->23|41->24|41->24|41->24|41->24|41->24|41->24|42->25|42->25|42->25|44->27|44->27|44->27|47->30|47->30|47->30|47->30|47->30|47->30|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|55->38|56->39|59->42|60->43|61->44
                  -- GENERATED --
              */
          