
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[gitbucket.core.model.Account,List[String],String,List[String],Boolean,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: gitbucket.core.model.Account, groupNames: List[String], active: String, extraMailAddresses: List[String],
  isGroupManager: Boolean = false)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*4.2*/gitbucket/*4.11*/.core.html.main(account.userName)/*4.44*/{_display_(Seq[Any](format.raw/*4.45*/("""
  """),format.raw/*5.3*/("""<div class="main-sidebar">
    <div class="sidebar">
      <div class="user-panel">
        <div class="pull-left image">"""),_display_(/*8.39*/helpers/*8.46*/.avatar(account.userName, 40)),format.raw/*8.75*/("""</div>
        <div class="pull-left info">
          <p>"""),_display_(/*10.15*/account/*10.22*/.userName),format.raw/*10.31*/("""</p>
          """),_display_(/*11.12*/account/*11.19*/.fullName),format.raw/*11.28*/("""
        """),format.raw/*12.9*/("""</div>
      </div>
      <div style="padding-left: 10px; padding-right: 10px;">
        """),_display_(/*15.10*/account/*15.17*/.description.map/*15.33*/ { description =>_display_(Seq[Any](format.raw/*15.50*/("""
          """),format.raw/*16.11*/("""<p style="color: #999">"""),_display_(/*16.35*/description),format.raw/*16.46*/("""</p>
        """)))}),format.raw/*17.10*/("""
        """),_display_(/*18.10*/account/*18.17*/.url.map/*18.25*/ { url =>_display_(Seq[Any](format.raw/*18.34*/("""
          """),format.raw/*19.11*/("""<p style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
            <i class="octicon octicon-home"></i>
            """),_display_(if(url.startsWith("http://") || url.startsWith("https://"))/*21.73*/{_display_(Seq[Any](format.raw/*21.74*/("""
              """),format.raw/*22.15*/("""<a href=""""),_display_(/*22.25*/url),format.raw/*22.28*/("""">"""),_display_(/*22.31*/url),format.raw/*22.34*/("""</a>
            """)))}else/*23.20*/{_display_(Seq[Any](format.raw/*23.21*/("""
            """),format.raw/*24.13*/("""<span style="color: #999">"""),_display_(/*24.40*/url),format.raw/*24.43*/("""</span>
            """)))}),format.raw/*25.14*/("""
          """),format.raw/*26.11*/("""</p>
        """)))}),format.raw/*27.10*/("""
        """),_display_(if(context.settings.showMailAddress)/*28.46*/{_display_(Seq[Any](format.raw/*28.47*/("""
          """),format.raw/*29.11*/("""<p style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
            <i class="octicon octicon-mail"></i> <a href="mailto:"""),_display_(/*30.67*/account/*30.74*/.mailAddress),format.raw/*30.86*/("""">"""),_display_(/*30.89*/account/*30.96*/.mailAddress),format.raw/*30.108*/("""</a>
          </p>
          """),_display_(/*32.12*/extraMailAddresses/*32.30*/.map/*32.34*/ { mail =>_display_(Seq[Any](format.raw/*32.44*/("""
            """),format.raw/*33.13*/("""<p style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
              <i class="octicon octicon-mail"></i> <a href="mailto:"""),_display_(/*34.69*/mail),format.raw/*34.73*/("""">"""),_display_(/*34.76*/mail),format.raw/*34.80*/("""</a>
            </p>
          """)))}),format.raw/*36.12*/("""
        """)))} else {null} ),format.raw/*37.10*/("""
        """),format.raw/*38.9*/("""<p style="color: #999">
          <i class="octicon octicon-clock"></i> Joined on """),_display_(/*39.60*/helpers/*39.67*/.date(account.registeredDate)),format.raw/*39.96*/("""
        """),format.raw/*40.9*/("""</p>
      </div>
      """),_display_(if(groupNames.nonEmpty)/*42.31*/{_display_(Seq[Any](format.raw/*42.32*/("""
        """),format.raw/*43.9*/("""<ul class="sidebar-menu">
          <li class="header">Groups</li>
          """),_display_(/*45.12*/groupNames/*45.22*/.map/*45.26*/ { groupName =>_display_(Seq[Any](format.raw/*45.41*/("""
            """),format.raw/*46.13*/("""<li>"""),_display_(/*46.18*/helpers/*46.25*/.avatarLink(groupName, 20, tooltip = true, label = true)),format.raw/*46.81*/("""</li>
          """)))}),format.raw/*47.12*/("""
        """),format.raw/*48.9*/("""</ul>
      """)))} else {null} ),format.raw/*49.8*/("""
    """),format.raw/*50.5*/("""</div>
  </div>
  <div class="content-wrapper">
    <div class="content body">
      <ul class="nav nav-tabs" style="margin-bottom: 5px;">
        <li"""),_display_(if(active == "repositories")/*55.41*/{_display_(Seq[Any](format.raw/*55.42*/(""" """),format.raw/*55.43*/("""class="active"""")))} else {null} ),format.raw/*55.58*/("""><a href=""""),_display_(/*55.69*/helpers/*55.76*/.url(account.userName)),format.raw/*55.98*/("""?tab=repositories">Repositories</a></li>
        """),_display_(if(account.isGroupAccount)/*56.36*/{_display_(Seq[Any](format.raw/*56.37*/("""
          """),format.raw/*57.11*/("""<li"""),_display_(if(active == "members")/*57.38*/{_display_(Seq[Any](format.raw/*57.39*/(""" """),format.raw/*57.40*/("""class="active"""")))} else {null} ),format.raw/*57.55*/("""><a href=""""),_display_(/*57.66*/helpers/*57.73*/.url(account.userName)),format.raw/*57.95*/("""?tab=members">Members</a></li>
        """)))}else/*58.16*/{_display_(Seq[Any](format.raw/*58.17*/("""
          """),format.raw/*59.11*/("""<li"""),_display_(if(active == "activity")/*59.39*/{_display_(Seq[Any](format.raw/*59.40*/(""" """),format.raw/*59.41*/("""class="active"""")))} else {null} ),format.raw/*59.56*/("""><a href=""""),_display_(/*59.67*/helpers/*59.74*/.url(account.userName)),format.raw/*59.96*/("""?tab=activity">Public activity</a></li>
        """)))}),format.raw/*60.10*/("""
        """),format.raw/*63.11*/("""
        """),_display_(/*64.10*/gitbucket/*64.19*/.core.plugin.PluginRegistry().getProfileTabs.map/*64.67*/ { tab =>_display_(Seq[Any](format.raw/*64.76*/("""
          """),_display_(/*65.12*/tab(account, context)/*65.33*/.map/*65.37*/ { link =>_display_(Seq[Any](format.raw/*65.47*/("""
            """),format.raw/*66.13*/("""<li"""),_display_(if(active == link.id)/*66.38*/{_display_(Seq[Any](format.raw/*66.39*/(""" """),format.raw/*66.40*/("""class="active"""")))} else {null} ),format.raw/*66.55*/("""><a href=""""),_display_(/*66.66*/context/*66.73*/.path),format.raw/*66.78*/("""/"""),_display_(/*66.80*/link/*66.84*/.path),format.raw/*66.89*/("""">"""),_display_(/*66.92*/link/*66.96*/.label),format.raw/*66.102*/("""</a></li>
          """)))}),format.raw/*67.12*/("""
        """)))}),format.raw/*68.10*/("""
        """),_display_(if(context.loginAccount.isDefined && context.loginAccount.get.userName == account.userName)/*69.101*/{_display_(Seq[Any](format.raw/*69.102*/("""
          """),format.raw/*70.11*/("""<li class="pull-right">
            <div class="button-group">
              <a href=""""),_display_(/*72.25*/helpers/*72.32*/.url(account.userName)),format.raw/*72.54*/("""/_edit" class="btn btn-default">Edit your profile</a>
            </div>
          </li>
        """)))} else {null} ),format.raw/*75.10*/("""
        """),_display_(if(context.loginAccount.isDefined && account.isGroupAccount && isGroupManager)/*76.88*/{_display_(Seq[Any](format.raw/*76.89*/("""
          """),format.raw/*77.11*/("""<li class="pull-right">
            <div class="button-group">
              <a href=""""),_display_(/*79.25*/helpers/*79.32*/.url(account.userName)),format.raw/*79.54*/("""/_editgroup" class="btn btn-default">Edit group</a>
            </div>
          </li>
        """)))} else {null} ),format.raw/*82.10*/("""
      """),format.raw/*83.7*/("""</ul>
      """),_display_(/*84.8*/body),format.raw/*84.12*/("""
    """),format.raw/*85.5*/("""</div>
  </div>
""")))}),format.raw/*87.2*/("""
"""))
      }
    }
  }

  def render(account:gitbucket.core.model.Account,groupNames:List[String],active:String,extraMailAddresses:List[String],isGroupManager:Boolean,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account,groupNames,active,extraMailAddresses,isGroupManager)(body)(context)

  def f:((gitbucket.core.model.Account,List[String],String,List[String],Boolean) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account,groupNames,active,extraMailAddresses,isGroupManager) => (body) => (context) => apply(account,groupNames,active,extraMailAddresses,isGroupManager)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/main.scala.html
                  HASH: becc8b668cc9d44a8f8899670adbdb8773f16baa
                  MATRIX: 684->1|972->218|1035->254|1052->263|1093->296|1131->297|1160->300|1308->422|1323->429|1372->458|1457->516|1473->523|1503->532|1546->548|1562->555|1592->564|1628->573|1745->663|1761->670|1786->686|1841->703|1880->714|1931->738|1963->749|2008->763|2045->773|2061->780|2078->788|2125->797|2164->808|2388->1005|2427->1006|2470->1021|2507->1031|2531->1034|2561->1037|2585->1040|2626->1064|2665->1065|2706->1078|2760->1105|2784->1108|2836->1129|2875->1140|2920->1154|2993->1200|3032->1201|3071->1212|3240->1354|3256->1361|3289->1373|3319->1376|3335->1383|3369->1395|3427->1426|3454->1444|3467->1448|3515->1458|3556->1471|3727->1615|3752->1619|3782->1622|3807->1626|3871->1659|3925->1669|3961->1678|4071->1761|4087->1768|4137->1797|4173->1806|4248->1854|4287->1855|4323->1864|4428->1942|4447->1952|4460->1956|4513->1971|4554->1984|4586->1989|4602->1996|4679->2052|4727->2069|4763->2078|4819->2091|4851->2096|5057->2275|5096->2276|5125->2277|5184->2292|5222->2303|5238->2310|5281->2332|5384->2408|5423->2409|5462->2420|5516->2447|5555->2448|5584->2449|5643->2464|5681->2475|5697->2482|5740->2504|5803->2550|5842->2551|5881->2562|5936->2590|5975->2591|6004->2592|6063->2607|6101->2618|6117->2625|6160->2647|6240->2696|6277->2844|6314->2854|6332->2863|6389->2911|6436->2920|6475->2932|6505->2953|6518->2957|6566->2967|6607->2980|6659->3005|6698->3006|6727->3007|6786->3022|6824->3033|6840->3040|6866->3045|6895->3047|6908->3051|6934->3056|6964->3059|6977->3063|7005->3069|7057->3090|7098->3100|7227->3201|7267->3202|7306->3213|7420->3300|7436->3307|7479->3329|7621->3427|7736->3515|7775->3516|7814->3527|7928->3614|7944->3621|7987->3643|8127->3739|8161->3746|8200->3759|8225->3763|8257->3768|8304->3785
                  LINES: 14->1|18->3|21->4|21->4|21->4|21->4|22->5|25->8|25->8|25->8|27->10|27->10|27->10|28->11|28->11|28->11|29->12|32->15|32->15|32->15|32->15|33->16|33->16|33->16|34->17|35->18|35->18|35->18|35->18|36->19|38->21|38->21|39->22|39->22|39->22|39->22|39->22|40->23|40->23|41->24|41->24|41->24|42->25|43->26|44->27|45->28|45->28|46->29|47->30|47->30|47->30|47->30|47->30|47->30|49->32|49->32|49->32|49->32|50->33|51->34|51->34|51->34|51->34|53->36|54->37|55->38|56->39|56->39|56->39|57->40|59->42|59->42|60->43|62->45|62->45|62->45|62->45|63->46|63->46|63->46|63->46|64->47|65->48|66->49|67->50|72->55|72->55|72->55|72->55|72->55|72->55|72->55|73->56|73->56|74->57|74->57|74->57|74->57|74->57|74->57|74->57|74->57|75->58|75->58|76->59|76->59|76->59|76->59|76->59|76->59|76->59|76->59|77->60|78->63|79->64|79->64|79->64|79->64|80->65|80->65|80->65|80->65|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|81->66|82->67|83->68|84->69|84->69|85->70|87->72|87->72|87->72|90->75|91->76|91->76|92->77|94->79|94->79|94->79|97->82|98->83|99->84|99->84|100->85|102->87
                  -- GENERATED --
              */
          