
package gitbucket.core.settings.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,gitbucket.core.service.RepositoryService.RepositoryInfo,Html,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(active: String, repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(body: Html)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*3.1*/("""<ul class="nav nav-tabs" style="margin-bottom: 20px;">
  <li"""),_display_(if(active=="options")/*4.28*/{_display_(Seq[Any](format.raw/*4.29*/(""" """),format.raw/*4.30*/("""class="active"""")))} else {null} ),format.raw/*4.45*/(""">
    <a href=""""),_display_(/*5.15*/helpers/*5.22*/.url(repository)),format.raw/*5.38*/("""/settings/options">Options</a>
  </li>
  <li"""),_display_(if(active=="collaborators")/*7.34*/{_display_(Seq[Any](format.raw/*7.35*/(""" """),format.raw/*7.36*/("""class="active"""")))} else {null} ),format.raw/*7.51*/(""">
    <a href=""""),_display_(/*8.15*/helpers/*8.22*/.url(repository)),format.raw/*8.38*/("""/settings/collaborators">Collaborators</a>
  </li>
  """),_display_(if(!repository.branchList.isEmpty)/*10.38*/{_display_(Seq[Any](format.raw/*10.39*/("""
    """),format.raw/*11.5*/("""<li"""),_display_(if(active=="branches")/*11.31*/{_display_(Seq[Any](format.raw/*11.32*/(""" """),format.raw/*11.33*/("""class="active"""")))} else {null} ),format.raw/*11.48*/(""">
      <a href=""""),_display_(/*12.17*/helpers/*12.24*/.url(repository)),format.raw/*12.40*/("""/settings/branches">Branches</a>
    </li>
  """)))} else {null} ),format.raw/*14.4*/("""
  """),format.raw/*15.3*/("""<li"""),_display_(if(active=="issues")/*15.27*/{_display_(Seq[Any](format.raw/*15.28*/(""" """),format.raw/*15.29*/("""class="active"""")))} else {null} ),format.raw/*15.44*/(""">
    <a href=""""),_display_(/*16.15*/helpers/*16.22*/.url(repository)),format.raw/*16.38*/("""/settings/issues">Issues</a>
  </li>
  <li"""),_display_(if(active=="hooks")/*18.26*/{_display_(Seq[Any](format.raw/*18.27*/(""" """),format.raw/*18.28*/("""class="active"""")))} else {null} ),format.raw/*18.43*/(""">
    <a href=""""),_display_(/*19.15*/helpers/*19.22*/.url(repository)),format.raw/*19.38*/("""/settings/hooks">Service Hooks</a>
  </li>
  <li"""),_display_(if(active=="deploykeys")/*21.31*/{_display_(Seq[Any](format.raw/*21.32*/(""" """),format.raw/*21.33*/("""class="active"""")))} else {null} ),format.raw/*21.48*/(""">
    <a href=""""),_display_(/*22.15*/helpers/*22.22*/.url(repository)),format.raw/*22.38*/("""/settings/deploykey">Deploy Keys</a>
  </li>
  <li"""),_display_(if(active=="danger")/*24.27*/{_display_(Seq[Any](format.raw/*24.28*/(""" """),format.raw/*24.29*/("""class="active"""")))} else {null} ),format.raw/*24.44*/(""">
    <a href=""""),_display_(/*25.15*/helpers/*25.22*/.url(repository)),format.raw/*25.38*/("""/settings/danger">Danger Zone</a>
  </li>
  """),_display_(/*27.4*/gitbucket/*27.13*/.core.plugin.PluginRegistry().getRepositorySettingTabs.map/*27.71*/ { tab =>_display_(Seq[Any](format.raw/*27.80*/("""
    """),_display_(/*28.6*/tab(repository, context)/*28.30*/.map/*28.34*/ { link =>_display_(Seq[Any](format.raw/*28.44*/("""
      """),format.raw/*29.7*/("""<li"""),_display_(if(active==link.id)/*29.30*/{_display_(Seq[Any](format.raw/*29.31*/(""" """),format.raw/*29.32*/("""class="active"""")))} else {null} ),format.raw/*29.47*/(""">
        <a href=""""),_display_(/*30.19*/helpers/*30.26*/.url(repository)),format.raw/*30.42*/("""/"""),_display_(/*30.44*/link/*30.48*/.path),format.raw/*30.53*/("""">"""),_display_(/*30.56*/link/*30.60*/.label),format.raw/*30.66*/("""</a>
      </li>
    """)))}),format.raw/*32.6*/("""
  """)))}),format.raw/*33.4*/("""
"""),format.raw/*34.1*/("""</ul>
"""),_display_(/*35.2*/body),format.raw/*35.6*/("""
"""))
      }
    }
  }

  def render(active:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,body:Html,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(active,repository)(body)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo) => (Html) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (active,repository) => (body) => (context) => apply(active,repository)(body)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/settings/menu.scala.html
                  HASH: 9413d74ab4f5179fae2c3f78bc5634ed3494f974
                  MATRIX: 678->1|901->153|964->188|1072->270|1110->271|1138->272|1196->287|1238->303|1253->310|1289->326|1387->398|1425->399|1453->400|1511->415|1553->431|1568->438|1604->454|1719->542|1758->543|1790->548|1843->574|1882->575|1911->576|1970->591|2015->609|2031->616|2068->632|2157->678|2187->681|2238->705|2277->706|2306->707|2365->722|2408->738|2424->745|2461->761|2550->823|2589->824|2618->825|2677->840|2720->856|2736->863|2773->879|2873->952|2912->953|2941->954|3000->969|3043->985|3059->992|3096->1008|3194->1079|3233->1080|3262->1081|3321->1096|3364->1112|3380->1119|3417->1135|3488->1180|3506->1189|3573->1247|3620->1256|3652->1262|3685->1286|3698->1290|3746->1300|3780->1307|3830->1330|3869->1331|3898->1332|3957->1347|4004->1367|4020->1374|4057->1390|4086->1392|4099->1396|4125->1401|4155->1404|4168->1408|4195->1414|4247->1436|4281->1440|4309->1441|4342->1448|4366->1452
                  LINES: 14->1|17->2|20->3|21->4|21->4|21->4|21->4|22->5|22->5|22->5|24->7|24->7|24->7|24->7|25->8|25->8|25->8|27->10|27->10|28->11|28->11|28->11|28->11|28->11|29->12|29->12|29->12|31->14|32->15|32->15|32->15|32->15|32->15|33->16|33->16|33->16|35->18|35->18|35->18|35->18|36->19|36->19|36->19|38->21|38->21|38->21|38->21|39->22|39->22|39->22|41->24|41->24|41->24|41->24|42->25|42->25|42->25|44->27|44->27|44->27|44->27|45->28|45->28|45->28|45->28|46->29|46->29|46->29|46->29|46->29|47->30|47->30|47->30|47->30|47->30|47->30|47->30|47->30|47->30|49->32|50->33|51->34|52->35|52->35
                  -- GENERATED --
              */
          