
package gitbucket.core.account.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[String,String,Boolean,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, userName: String, group: Boolean)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="main-sidebar">
  <div class="sidebar">
    <ul class="sidebar-menu">
      """),_display_(if(group)/*5.17*/{_display_(Seq[Any](format.raw/*5.18*/("""
        """),format.raw/*6.9*/("""<li class="menu-item-hover """),_display_(if(active=="profile")/*6.58*/{_display_(Seq[Any](format.raw/*6.59*/("""active""")))} else {null} ),format.raw/*6.66*/("""">
          <a href=""""),_display_(/*7.21*/context/*7.28*/.path),format.raw/*7.33*/("""/"""),_display_(/*7.35*/userName),format.raw/*7.43*/("""/_editgroup">
            <i class="menu-icon octicon octicon-person"></i> <span>Profile</span>
          </a>
        </li>
        <li class="menu-item-hover """),_display_(if(active=="hooks")/*11.56*/{_display_(Seq[Any](format.raw/*11.57*/("""active""")))} else {null} ),format.raw/*11.64*/("""">
          <a href=""""),_display_(/*12.21*/context/*12.28*/.path),format.raw/*12.33*/("""/"""),_display_(/*12.35*/userName),format.raw/*12.43*/("""/_hooks">
            <i class="menu-icon octicon octicon-zap"></i> <span>Service Hooks</span>
          </a>
        </li>
      """)))}else/*16.14*/{_display_(Seq[Any](format.raw/*16.15*/("""
        """),format.raw/*17.9*/("""<li class="menu-item-hover """),_display_(if(active=="profile")/*17.58*/{_display_(Seq[Any](format.raw/*17.59*/("""active""")))} else {null} ),format.raw/*17.66*/("""">
          <a href=""""),_display_(/*18.21*/context/*18.28*/.path),format.raw/*18.33*/("""/"""),_display_(/*18.35*/userName),format.raw/*18.43*/("""/_edit">
            <i class="menu-icon octicon octicon-person"></i> <span>Profile</span>
          </a>
        </li>
        """),_display_(if(context.settings.ssh.enabled)/*22.42*/{_display_(Seq[Any](format.raw/*22.43*/("""
          """),format.raw/*23.11*/("""<li class="menu-item-hover """),_display_(if(active=="ssh")/*23.56*/{_display_(Seq[Any](format.raw/*23.57*/("""active""")))} else {null} ),format.raw/*23.64*/("""">
            <a href=""""),_display_(/*24.23*/context/*24.30*/.path),format.raw/*24.35*/("""/"""),_display_(/*24.37*/userName),format.raw/*24.45*/("""/_ssh">
              <i class="menu-icon octicon octicon-key"></i> <span>SSH Keys</span>
            </a>
          </li>
        """)))} else {null} ),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""<li class="menu-item-hover """),_display_(if(active=="gpg")/*29.54*/{_display_(Seq[Any](format.raw/*29.55*/("""active""")))} else {null} ),format.raw/*29.62*/("""">
          <a href=""""),_display_(/*30.21*/context/*30.28*/.path),format.raw/*30.33*/("""/"""),_display_(/*30.35*/userName),format.raw/*30.43*/("""/_gpg">
            <i class="menu-icon octicon octicon-key"></i> <span>GPG Keys</span>
          </a>
        </li>
        <li class="menu-item-hover """),_display_(if(active=="application")/*34.62*/{_display_(Seq[Any](format.raw/*34.63*/("""active""")))} else {null} ),format.raw/*34.70*/("""">
          <a href=""""),_display_(/*35.21*/context/*35.28*/.path),format.raw/*35.33*/("""/"""),_display_(/*35.35*/userName),format.raw/*35.43*/("""/_application">
            <i class="menu-icon octicon octicon-rocket"></i> <span>Applications</span>
          </a>
        </li>
        <li class="menu-item-hover """),_display_(if(active=="hooks")/*39.56*/{_display_(Seq[Any](format.raw/*39.57*/("""active""")))} else {null} ),format.raw/*39.64*/("""">
          <a href=""""),_display_(/*40.21*/context/*40.28*/.path),format.raw/*40.33*/("""/"""),_display_(/*40.35*/userName),format.raw/*40.43*/("""/_hooks">
            <i class="menu-icon octicon octicon-zap"></i> <span>Service Hooks</span>
          </a>
        </li>
        <li class="menu-item-hover """),_display_(if(active=="preferences")/*44.62*/{_display_(Seq[Any](format.raw/*44.63*/("""active""")))} else {null} ),format.raw/*44.70*/("""">
          <a href=""""),_display_(/*45.21*/context/*45.28*/.path),format.raw/*45.33*/("""/"""),_display_(/*45.35*/userName),format.raw/*45.43*/("""/_preferences">
            <i class="menu-icon octicon octicon-star"></i> <span>Preferences</span>
          </a>
        </li>
        """),_display_(/*49.10*/gitbucket/*49.19*/.core.plugin.PluginRegistry().getAccountSettingMenus.map/*49.75*/ { menu =>_display_(Seq[Any](format.raw/*49.85*/("""
          """),_display_(/*50.12*/menu(context)/*50.25*/.map/*50.29*/ { link =>_display_(Seq[Any](format.raw/*50.39*/("""
            """),format.raw/*51.13*/("""<li class="menu-item-hover """),_display_(if(active==link.id)/*51.60*/{_display_(Seq[Any](format.raw/*51.61*/("""active""")))} else {null} ),format.raw/*51.68*/("""">
              <a href=""""),_display_(/*52.25*/context/*52.32*/.path),format.raw/*52.37*/("""/"""),_display_(/*52.39*/link/*52.43*/.path),format.raw/*52.48*/("""">
                <i class="menu-icon octicon octicon-plug"></i> <span>"""),_display_(/*53.71*/link/*53.75*/.label),format.raw/*53.81*/("""</span>
              </a>
            </li>
          """)))}),format.raw/*56.12*/("""
        """)))}),format.raw/*57.10*/("""
      """)))}),format.raw/*58.8*/("""
    """),format.raw/*59.5*/("""</ul>
  </div>
</div>
<div class="content-wrapper">
  <div class="content body">
    """),_display_(/*64.6*/body),format.raw/*64.10*/("""
  """),format.raw/*65.3*/("""</div>
</div>
"""))
      }
    }
  }

  def render(active:String,userName:String,group:Boolean,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,userName,group)(body)(context)

  def f:((String,String,Boolean) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,userName,group) => (body) => (context) => apply(active,userName,group)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/account/menu.scala.html
                  HASH: 026fa3426282c63432f9411611417c6f85b4ef40
                  MATRIX: 636->1|845->117|968->214|1006->215|1041->224|1116->273|1154->274|1204->281|1253->304|1268->311|1293->316|1321->318|1349->326|1556->506|1595->507|1646->514|1696->537|1712->544|1738->549|1767->551|1796->559|1950->696|1989->697|2025->706|2101->755|2140->756|2191->763|2241->786|2257->793|2283->798|2312->800|2341->808|2529->969|2568->970|2607->981|2679->1026|2718->1027|2769->1034|2821->1059|2837->1066|2863->1071|2892->1073|2921->1081|3097->1213|3133->1222|3205->1267|3244->1268|3295->1275|3345->1298|3361->1305|3387->1310|3416->1312|3445->1320|3650->1498|3689->1499|3740->1506|3790->1529|3806->1536|3832->1541|3861->1543|3890->1551|4104->1738|4143->1739|4194->1746|4244->1769|4260->1776|4286->1781|4315->1783|4344->1791|4556->1976|4595->1977|4646->1984|4696->2007|4712->2014|4738->2019|4767->2021|4796->2029|4961->2167|4979->2176|5044->2232|5092->2242|5131->2254|5153->2267|5166->2271|5214->2281|5255->2294|5329->2341|5368->2342|5419->2349|5473->2376|5489->2383|5515->2388|5544->2390|5557->2394|5583->2399|5683->2472|5696->2476|5723->2482|5810->2538|5851->2548|5889->2556|5921->2561|6033->2647|6058->2651|6088->2654
                  LINES: 14->1|19->2|22->5|22->5|23->6|23->6|23->6|23->6|24->7|24->7|24->7|24->7|24->7|28->11|28->11|28->11|29->12|29->12|29->12|29->12|29->12|33->16|33->16|34->17|34->17|34->17|34->17|35->18|35->18|35->18|35->18|35->18|39->22|39->22|40->23|40->23|40->23|40->23|41->24|41->24|41->24|41->24|41->24|45->28|46->29|46->29|46->29|46->29|47->30|47->30|47->30|47->30|47->30|51->34|51->34|51->34|52->35|52->35|52->35|52->35|52->35|56->39|56->39|56->39|57->40|57->40|57->40|57->40|57->40|61->44|61->44|61->44|62->45|62->45|62->45|62->45|62->45|66->49|66->49|66->49|66->49|67->50|67->50|67->50|67->50|68->51|68->51|68->51|68->51|69->52|69->52|69->52|69->52|69->52|69->52|70->53|70->53|70->53|73->56|74->57|75->58|76->59|81->64|81->64|82->65
                  -- GENERATED --
              */
          