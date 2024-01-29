
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object editgroup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[gitbucket.core.model.Account,List[gitbucket.core.model.GroupMember],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account,
  members: List[gitbucket.core.model.GroupMember],
  info: Option[Any])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*5.2*/gitbucket/*5.11*/.core.html.main("Edit group")/*5.40*/{_display_(Seq[Any](format.raw/*5.41*/("""
  """),_display_(/*6.4*/gitbucket/*6.13*/.core.account.html.menu("profile", account.userName, true)/*6.71*/{_display_(Seq[Any](format.raw/*6.72*/("""
    """),_display_(/*7.6*/gitbucket/*7.15*/.core.helper.html.information(info)),format.raw/*7.50*/("""
    """),format.raw/*8.5*/("""<h2>Edit group</h2>
    <form id="form" method="post" action=""""),_display_(/*9.44*/context/*9.51*/.path),format.raw/*9.56*/("""/"""),_display_(/*9.58*/account/*9.65*/.userName),format.raw/*9.74*/("""/_editgroup" validate="true" autocomplete="off">
      """),_display_(/*10.8*/gitbucket/*10.17*/.core.account.html.groupform(Some(account), members, false)),format.raw/*10.76*/("""
      """),format.raw/*11.7*/("""<fieldset class="border-top">
        <div class="pull-right">
          <a href=""""),_display_(/*13.21*/helpers/*13.28*/.url(account.userName)),format.raw/*13.50*/("""/_deletegroup" id="delete" class="btn btn-danger">Delete group</a>
        </div>
        <input type="submit" class="btn btn-success" value="Update group"/>
      </fieldset>
    </form>
  """)))}),format.raw/*18.4*/("""
""")))}),format.raw/*19.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,members:List[gitbucket.core.model.GroupMember],info:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members,info)(context)

  def f:((gitbucket.core.model.Account,List[gitbucket.core.model.GroupMember],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members,info) => (context) => apply(account,members,info)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/editgroup.scala.html
                  HASH: 4b9a0ff1cd5d7d7d99c520f0f72f7a19d37a011d
                  MATRIX: 694->1|931->167|994->203|1011->212|1048->241|1086->242|1115->246|1132->255|1198->313|1236->314|1267->320|1284->329|1339->364|1370->369|1459->432|1474->439|1499->444|1527->446|1542->453|1571->462|1653->518|1671->527|1751->586|1785->593|1895->676|1911->683|1954->705|2175->896|2207->898
                  LINES: 14->1|19->4|22->5|22->5|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|25->8|26->9|26->9|26->9|26->9|26->9|26->9|27->10|27->10|27->10|28->11|30->13|30->13|30->13|35->18|36->19
                  -- GENERATED --
              */
          