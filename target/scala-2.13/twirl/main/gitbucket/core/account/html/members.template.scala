
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object members extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[gitbucket.core.model.Account,List[gitbucket.core.model.GroupMember],List[String],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, members: List[gitbucket.core.model.GroupMember], extraMailAddresses: List[String], isGroupManager: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.account.html.main(account, Nil, "members", extraMailAddresses, isGroupManager)/*3.95*/{_display_(Seq[Any](format.raw/*3.96*/("""
  """),_display_(if(members.isEmpty)/*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
    """),format.raw/*5.5*/("""No members
  """)))}else/*6.10*/{_display_(Seq[Any](format.raw/*6.11*/("""
    """),_display_(/*7.6*/members/*7.13*/.map/*7.17*/ { member =>_display_(Seq[Any](format.raw/*7.29*/("""
      """),format.raw/*8.7*/("""<div class="block">
        <div class="block-header">
          """),_display_(/*10.12*/helpers/*10.19*/.avatarLink(member.userName, 20)),format.raw/*10.51*/(""" """),format.raw/*10.52*/("""<a href=""""),_display_(/*10.62*/helpers/*10.69*/.url(member.userName)),format.raw/*10.90*/("""">"""),_display_(/*10.93*/member/*10.99*/.userName),format.raw/*10.108*/("""</a>
          """),_display_(if(member.isManager)/*11.32*/{_display_(Seq[Any](format.raw/*11.33*/(""" """),format.raw/*11.34*/("""(Manager) """)))} else {null} ),format.raw/*11.45*/("""
        """),format.raw/*12.9*/("""</div>
      </div>
    """)))}),format.raw/*14.6*/("""
  """)))}),format.raw/*15.4*/("""
""")))}),format.raw/*16.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,members:List[gitbucket.core.model.GroupMember],extraMailAddresses:List[String],isGroupManager:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,members,extraMailAddresses,isGroupManager)(context)

  def f:((gitbucket.core.model.Account,List[gitbucket.core.model.GroupMember],List[String],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,members,extraMailAddresses,isGroupManager) => (context) => apply(account,members,extraMailAddresses,isGroupManager)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/members.scala.html
                  HASH: bc781ae148e37d534b59d03f0c9f7f55192ca71a
                  MATRIX: 701->1|974->203|1037->239|1054->248|1146->332|1184->333|1233->356|1271->357|1302->362|1338->382|1376->383|1407->389|1422->396|1434->400|1483->412|1516->419|1609->485|1625->492|1678->524|1707->525|1744->535|1760->542|1802->563|1832->566|1847->572|1878->581|1941->617|1980->618|2009->619|2064->630|2100->639|2155->664|2189->668|2221->670
                  LINES: 14->1|17->2|20->3|20->3|20->3|20->3|21->4|21->4|22->5|23->6|23->6|24->7|24->7|24->7|24->7|25->8|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|31->14|32->15|33->16
                  -- GENERATED --
              */
          