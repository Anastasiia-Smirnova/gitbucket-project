
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object edithook extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.AccountWebHook,Set[gitbucket.core.model.WebHook.Event],gitbucket.core.model.Account,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webHook: gitbucket.core.model.AccountWebHook,
  events: Set[gitbucket.core.model.WebHook.Event],
  account: gitbucket.core.model.Account,
  create: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.html.main("Service Hooks")/*6.43*/{_display_(Seq[Any](format.raw/*6.44*/("""
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.account.html.menu("hooks", account.userName, account.isGroupAccount)/*7.87*/{_display_(Seq[Any](format.raw/*7.88*/("""
    """),_display_(/*8.6*/gitbucket/*8.15*/.core.settings.html.edithookform(
      webHook, events, create,
      helpers.url(account.userName) + "/_hooks/new",
      helpers.url(account.userName) + "/_hooks/edit",
      helpers.url(account.userName) + "/_hooks/delete",
      helpers.url(account.userName) + "/_hooks/test"
    )),format.raw/*14.6*/("""
  """)))}),format.raw/*15.4*/("""
""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(webHook:gitbucket.core.model.AccountWebHook,events:Set[gitbucket.core.model.WebHook.Event],account:gitbucket.core.model.Account,create:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(webHook,events,account,create)(context)

  def f:((gitbucket.core.model.AccountWebHook,Set[gitbucket.core.model.WebHook.Event],gitbucket.core.model.Account,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (webHook,events,account,create) => (context) => apply(webHook,events,account,create)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/edithook.scala.html
                  HASH: 98a6e04da929b441ef7d5d9818e83ca62ce37479
                  MATRIX: 726->1|1009->213|1072->249|1089->258|1129->290|1167->291|1196->295|1213->304|1295->378|1333->379|1364->385|1381->394|1687->680|1721->684|1753->686
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|25->8|25->8|31->14|32->15|33->16
                  -- GENERATED --
              */
          