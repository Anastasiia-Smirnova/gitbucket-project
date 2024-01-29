
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object activity extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.Account,List[String],List[gitbucket.core.model.Activity],List[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account,
  groupNames: List[String],
  activities: List[gitbucket.core.model.Activity],
  extraMailAddresses: List[String])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*6.2*/gitbucket/*6.11*/.core.account.html.main(account, groupNames, "activity", extraMailAddresses)/*6.87*/{_display_(Seq[Any](format.raw/*6.88*/("""
  """),format.raw/*7.3*/("""<div class="pull-right">
    <a href=""""),_display_(/*8.15*/context/*8.22*/.path),format.raw/*8.27*/("""/"""),_display_(/*8.29*/{account.userName}),format.raw/*8.47*/(""".atom"><img src=""""),_display_(/*8.65*/helpers/*8.72*/.assets("/common/images/feed.png")),format.raw/*8.106*/("""" alt="activities"></a>
  </div>
  """),_display_(/*10.4*/gitbucket/*10.13*/.core.helper.html.activities(activities)),format.raw/*10.53*/("""
""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,groupNames:List[String],activities:List[gitbucket.core.model.Activity],extraMailAddresses:List[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,activities,extraMailAddresses)(context)

  def f:((gitbucket.core.model.Account,List[String],List[gitbucket.core.model.Activity],List[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,activities,extraMailAddresses) => (context) => apply(account,groupNames,activities,extraMailAddresses)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/activity.scala.html
                  HASH: 93ef37293d4a947ee07f89264e8ee4e6c405d763
                  MATRIX: 704->1|984->210|1047->246|1064->255|1148->331|1186->332|1215->335|1280->374|1295->381|1320->386|1348->388|1386->406|1430->424|1445->431|1500->465|1562->501|1580->510|1641->550|1673->552
                  LINES: 14->1|20->5|23->6|23->6|23->6|23->6|24->7|25->8|25->8|25->8|25->8|25->8|25->8|25->8|25->8|27->10|27->10|27->10|28->11
                  -- GENERATED --
              */
          