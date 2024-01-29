
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object header extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  groups: List[String])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*5.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*6.1*/("""<div id="table-issues-control">
  """),_display_(/*7.4*/gitbucket/*7.13*/.core.helper.html.dropdown("Visibility")/*7.53*/{_display_(Seq[Any](format.raw/*7.54*/("""
    """),format.raw/*8.5*/("""<li>
      <a href=""""),_display_(/*9.17*/(condition.copy(visibility = (if(condition.visibility == Some("private")) None else Some("private"))).toURL)),format.raw/*9.125*/("""">
        """),_display_(/*10.10*/gitbucket/*10.19*/.core.helper.html.checkicon(condition.visibility == Some("private"))),format.raw/*10.87*/("""
        """),format.raw/*11.9*/("""Private repository only
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*15.17*/(condition.copy(visibility = (if(condition.visibility == Some("public")) None else Some("public"))).toURL)),format.raw/*15.123*/("""">
        """),_display_(/*16.10*/gitbucket/*16.19*/.core.helper.html.checkicon(condition.visibility == Some("public"))),format.raw/*16.86*/("""
        """),format.raw/*17.9*/("""Public repository only
      </a>
    </li>
  """)))}),format.raw/*20.4*/("""
  """),_display_(/*21.4*/gitbucket/*21.13*/.core.helper.html.dropdown("Organization", filter = ("organization", "Find Organization..."))/*21.106*/{_display_(Seq[Any](format.raw/*21.107*/("""
    """),_display_(/*22.6*/groups/*22.12*/.map/*22.16*/ { group =>_display_(Seq[Any](format.raw/*22.27*/("""
      """),format.raw/*23.7*/("""<li>
        <a href=""""),_display_(/*24.19*/((if(condition.groups.contains(group)) condition.copy(groups = condition.groups - group) else condition.copy(groups = condition.groups + group)).toURL)),format.raw/*24.170*/("""">
          """),_display_(/*25.12*/gitbucket/*25.21*/.core.helper.html.checkicon(condition.groups.contains(group))),format.raw/*25.82*/("""
          """),_display_(/*26.12*/helpers/*26.19*/.avatar(group, 20)),format.raw/*26.37*/(""" """),_display_(/*26.39*/group),format.raw/*26.44*/("""
        """),format.raw/*27.9*/("""</a>
      </li>
    """)))}),format.raw/*29.6*/("""
  """)))}),format.raw/*30.4*/("""
  """),_display_(/*31.4*/gitbucket/*31.13*/.core.helper.html.dropdown("Sort")/*31.47*/{_display_(Seq[Any](format.raw/*31.48*/("""
    """),format.raw/*32.5*/("""<li>
      <a href=""""),_display_(/*33.17*/condition/*33.26*/.copy(sort="created",  direction="desc").toURL),format.raw/*33.72*/("""">
        """),_display_(/*34.10*/gitbucket/*34.19*/.core.helper.html.checkicon(condition.sort == "created"  && condition.direction == "desc")),format.raw/*34.109*/(""" """),format.raw/*34.110*/("""Newest
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*38.17*/condition/*38.26*/.copy(sort="created",  direction="asc" ).toURL),format.raw/*38.72*/("""">
        """),_display_(/*39.10*/gitbucket/*39.19*/.core.helper.html.checkicon(condition.sort == "created"  && condition.direction == "asc")),format.raw/*39.108*/(""" """),format.raw/*39.109*/("""Oldest
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*43.17*/condition/*43.26*/.copy(sort="comments", direction="desc").toURL),format.raw/*43.72*/("""">
       """),_display_(/*44.9*/gitbucket/*44.18*/.core.helper.html.checkicon(condition.sort == "comments"  && condition.direction == "desc")),format.raw/*44.109*/(""" """),format.raw/*44.110*/("""Most commented
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*48.17*/condition/*48.26*/.copy(sort="comments", direction="asc" ).toURL),format.raw/*48.72*/("""">
        """),_display_(/*49.10*/gitbucket/*49.19*/.core.helper.html.checkicon(condition.sort == "comments"  && condition.direction == "asc")),format.raw/*49.109*/(""" """),format.raw/*49.110*/("""Least commented
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*53.17*/condition/*53.26*/.copy(sort="updated",  direction="desc").toURL),format.raw/*53.72*/("""">
        """),_display_(/*54.10*/gitbucket/*54.19*/.core.helper.html.checkicon(condition.sort == "updated"  && condition.direction == "desc")),format.raw/*54.109*/(""" """),format.raw/*54.110*/("""Recently updated
      </a>
    </li>
    <li>
      <a href=""""),_display_(/*58.17*/condition/*58.26*/.copy(sort="updated",  direction="asc" ).toURL),format.raw/*58.72*/("""">
        """),_display_(/*59.10*/gitbucket/*59.19*/.core.helper.html.checkicon(condition.sort == "updated"  && condition.direction == "asc")),format.raw/*59.108*/(""" """),format.raw/*59.109*/("""Least recently updated
      </a>
    </li>
  """)))}),format.raw/*62.4*/("""
"""),format.raw/*63.1*/("""</div>
"""))
      }
    }
  }

  def render(openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,groups:List[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(openCount,closedCount,condition,groups)(context)

  def f:((Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,List[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (openCount,closedCount,condition,groups) => (context) => apply(openCount,closedCount,condition,groups)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/header.scala.html
                  HASH: facdc1b6c1597726a351f98cc50bb4c132eab0c3
                  MATRIX: 692->1|950->188|1013->223|1073->258|1090->267|1138->307|1176->308|1207->313|1254->334|1383->442|1422->454|1440->463|1529->531|1565->540|1662->610|1790->716|1829->728|1847->737|1935->804|1971->813|2048->860|2078->864|2096->873|2199->966|2239->967|2271->973|2286->979|2299->983|2348->994|2382->1001|2432->1024|2605->1175|2646->1189|2664->1198|2746->1259|2785->1271|2801->1278|2840->1296|2869->1298|2895->1303|2931->1312|2983->1334|3017->1338|3047->1342|3065->1351|3108->1385|3147->1386|3179->1391|3227->1412|3245->1421|3312->1467|3351->1479|3369->1488|3481->1578|3511->1579|3591->1632|3609->1641|3676->1687|3715->1699|3733->1708|3844->1797|3874->1798|3954->1851|3972->1860|4039->1906|4076->1917|4094->1926|4207->2017|4237->2018|4325->2079|4343->2088|4410->2134|4449->2146|4467->2155|4579->2245|4609->2246|4698->2308|4716->2317|4783->2363|4822->2375|4840->2384|4952->2474|4982->2475|5072->2538|5090->2547|5157->2593|5196->2605|5214->2614|5325->2703|5355->2704|5432->2751|5460->2752
                  LINES: 14->1|20->5|23->6|24->7|24->7|24->7|24->7|25->8|26->9|26->9|27->10|27->10|27->10|28->11|32->15|32->15|33->16|33->16|33->16|34->17|37->20|38->21|38->21|38->21|38->21|39->22|39->22|39->22|39->22|40->23|41->24|41->24|42->25|42->25|42->25|43->26|43->26|43->26|43->26|43->26|44->27|46->29|47->30|48->31|48->31|48->31|48->31|49->32|50->33|50->33|50->33|51->34|51->34|51->34|51->34|55->38|55->38|55->38|56->39|56->39|56->39|56->39|60->43|60->43|60->43|61->44|61->44|61->44|61->44|65->48|65->48|65->48|66->49|66->49|66->49|66->49|70->53|70->53|70->53|71->54|71->54|71->54|71->54|75->58|75->58|75->58|76->59|76->59|76->59|76->59|79->62|80->63
                  -- GENERATED --
              */
          