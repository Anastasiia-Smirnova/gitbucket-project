
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edithook extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.WebHook,Set[gitbucket.core.model.WebHook.Event],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webHook: gitbucket.core.model.WebHook,
  events: Set[gitbucket.core.model.WebHook.Event],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  create: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main("Settings", Some(repository))/*6.56*/{_display_(Seq[Any](format.raw/*6.57*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.html.menu("settings", repository)/*7.52*/{_display_(Seq[Any](format.raw/*7.53*/("""
    """),_display_(/*8.6*/gitbucket/*8.15*/.core.settings.html.menu("hooks", repository)/*8.60*/{_display_(Seq[Any](format.raw/*8.61*/("""
      """),_display_(/*9.8*/gitbucket/*9.17*/.core.settings.html.edithookform(
        webHook, events, create,
        helpers.url(repository) + "/settings/hooks/new",
        helpers.url(repository) + "/settings/hooks/edit",
        helpers.url(repository) + "/settings/hooks/delete",
        helpers.url(repository) + "/settings/hooks/test"
      )),format.raw/*15.8*/("""
    """)))}),format.raw/*16.6*/("""
  """)))}),format.raw/*17.4*/("""
""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(webHook:gitbucket.core.model.WebHook,events:Set[gitbucket.core.model.WebHook.Event],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,create:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(webHook,events,repository,create)(context)

  def f:((gitbucket.core.model.WebHook,Set[gitbucket.core.model.WebHook.Event],gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (webHook,events,repository,create) => (context) => apply(webHook,events,repository,create)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/edithook.scala.html
                  HASH: 5549644e0de483095657d20558747194df922829
                  MATRIX: 747->1|1053->236|1116->272|1133->281|1186->326|1224->327|1253->331|1270->340|1317->379|1355->380|1386->386|1403->395|1456->440|1494->441|1527->449|1544->458|1870->764|1906->770|1940->774|1972->776
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|25->8|25->8|26->9|26->9|32->15|33->16|34->17|35->18
                  -- GENERATED --
              */
          