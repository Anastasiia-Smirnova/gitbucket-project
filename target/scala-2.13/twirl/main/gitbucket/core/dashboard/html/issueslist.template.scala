
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issueslist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,String,List[String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
  page: Int,
  openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  filter: String,
  groups: List[String])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers
/*9.2*/import gitbucket.core.service.IssuesService
/*10.2*/import gitbucket.core.service.IssuesService.IssueInfo


Seq[Any](format.raw/*11.1*/("""<table class="table table-bordered table-hover table-issues">
  <thead>
    <tr>
      <th style="background-color: #eee;">
        """),_display_(/*15.10*/gitbucket/*15.19*/.core.dashboard.html.header(openCount, closedCount, condition, groups)),format.raw/*15.89*/("""
      """),format.raw/*16.7*/("""</th>
    </tr>
  </thead>
  <tbody>
    """),_display_(/*20.6*/issues/*20.12*/.map/*20.16*/ { case (IssueInfo(issue, labels, milestone, priority, commentCount, commitId, assignedUserNames), status) =>_display_(Seq[Any](format.raw/*20.125*/("""
      """),format.raw/*21.7*/("""<tr>
        <td style="padding-top: 12px; padding-bottom: 12px;">
          <a href=""""),_display_(/*23.21*/context/*23.28*/.path),format.raw/*23.33*/("""/"""),_display_(/*23.35*/issue/*23.40*/.userName),format.raw/*23.49*/("""/"""),_display_(/*23.51*/issue/*23.56*/.repositoryName),format.raw/*23.71*/("""">"""),_display_(/*23.74*/issue/*23.79*/.userName),format.raw/*23.88*/("""/"""),_display_(/*23.90*/issue/*23.95*/.repositoryName),format.raw/*23.110*/("""</a>&nbsp;&#xFF65;
          """),_display_(if(issue.isPullRequest)/*24.35*/{_display_(Seq[Any](format.raw/*24.36*/("""
            """),format.raw/*25.13*/("""<a id="issue_"""),_display_(/*25.27*/(issue.issueId)),format.raw/*25.42*/("""_link" href=""""),_display_(/*25.56*/context/*25.63*/.path),format.raw/*25.68*/("""/"""),_display_(/*25.70*/issue/*25.75*/.userName),format.raw/*25.84*/("""/"""),_display_(/*25.86*/issue/*25.91*/.repositoryName),format.raw/*25.106*/("""/pull/"""),_display_(/*25.113*/issue/*25.118*/.issueId),format.raw/*25.126*/("""" class="issue-title">"""),_display_(/*25.149*/issue/*25.154*/.title),format.raw/*25.160*/("""</a>
          """)))}else/*26.18*/{_display_(Seq[Any](format.raw/*26.19*/("""
            """),format.raw/*27.13*/("""<a id="issue_"""),_display_(/*27.27*/(issue.issueId)),format.raw/*27.42*/("""_link" href=""""),_display_(/*27.56*/context/*27.63*/.path),format.raw/*27.68*/("""/"""),_display_(/*27.70*/issue/*27.75*/.userName),format.raw/*27.84*/("""/"""),_display_(/*27.86*/issue/*27.91*/.repositoryName),format.raw/*27.106*/("""/issues/"""),_display_(/*27.115*/issue/*27.120*/.issueId),format.raw/*27.128*/("""" class="issue-title">"""),_display_(/*27.151*/issue/*27.156*/.title),format.raw/*27.162*/("""</a>
          """)))}),format.raw/*28.12*/("""
          """),_display_(/*29.12*/status/*29.18*/.map/*29.22*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*29.52*/("""
            """),_display_(/*30.14*/gitbucket/*30.23*/.core.helper.html.commitstatus(commitId.get, summary, statuses)),format.raw/*30.86*/("""
          """)))}),format.raw/*31.12*/("""
          """),_display_(/*32.12*/labels/*32.18*/.map/*32.22*/ { label =>_display_(Seq[Any](format.raw/*32.33*/("""
            """),format.raw/*33.13*/("""<span class="label-color small" style="background-color: #"""),_display_(/*33.72*/label/*33.77*/.color),format.raw/*33.83*/("""; color: #"""),_display_(/*33.94*/label/*33.99*/.fontColor),format.raw/*33.109*/("""; padding-left: 4px; padding-right: 4px">"""),_display_(/*33.151*/label/*33.156*/.labelName),format.raw/*33.166*/("""</span>
          """)))}),format.raw/*34.12*/("""
          """),format.raw/*35.11*/("""<span class="pull-right muted">
            """),_display_(/*36.14*/assignedUserNames/*36.31*/.map/*36.35*/ { userName =>_display_(Seq[Any](format.raw/*36.49*/("""
              """),_display_(/*37.16*/helpers/*37.23*/.avatar(userName, 20, tooltip = true)),format.raw/*37.60*/("""
            """)))}),format.raw/*38.14*/("""
            """),_display_(if(commentCount > 0)/*39.34*/{_display_(Seq[Any](format.raw/*39.35*/("""
              """),format.raw/*40.15*/("""<a href=""""),_display_(/*40.25*/context/*40.32*/.path),format.raw/*40.37*/("""/"""),_display_(/*40.39*/issue/*40.44*/.userName),format.raw/*40.53*/("""/"""),_display_(/*40.55*/issue/*40.60*/.repositoryName),format.raw/*40.75*/("""/issues/"""),_display_(/*40.84*/issue/*40.89*/.issueId),format.raw/*40.97*/("""" class="issue-comment-count">
                <i class="octicon octicon-comment active"></i> """),_display_(/*41.65*/commentCount),format.raw/*41.77*/("""
              """),format.raw/*42.15*/("""</a>
            """)))}else/*43.20*/{_display_(Seq[Any](format.raw/*43.21*/("""
              """),format.raw/*44.15*/("""<a href=""""),_display_(/*44.25*/context/*44.32*/.path),format.raw/*44.37*/("""/"""),_display_(/*44.39*/issue/*44.44*/.userName),format.raw/*44.53*/("""/"""),_display_(/*44.55*/issue/*44.60*/.repositoryName),format.raw/*44.75*/("""/issues/"""),_display_(/*44.84*/issue/*44.89*/.issueId),format.raw/*44.97*/("""" class="issue-comment-count" style="color: silver;">
                <i class="octicon octicon-comment"></i> """),_display_(/*45.58*/commentCount),format.raw/*45.70*/("""
              """),format.raw/*46.15*/("""</a>
            """)))}),format.raw/*47.14*/("""
          """),format.raw/*48.11*/("""</span>
          <div class="small muted" style="margin-top: 2px;">
            #"""),_display_(/*50.15*/issue/*50.20*/.issueId),format.raw/*50.28*/(""" """),format.raw/*50.29*/("""opened by """),_display_(/*50.40*/helpers/*50.47*/.user(issue.openedUserName, styleClass="username")),format.raw/*50.97*/(""" """),_display_(/*50.99*/helpers/*50.106*/.datetime(issue.registeredDate)),format.raw/*50.137*/("""
            """),_display_(/*51.14*/milestone/*51.23*/.map/*51.27*/ { milestone =>_display_(Seq[Any](format.raw/*51.42*/("""
              """),format.raw/*52.15*/("""<span style="margin: 20px;"><a href=""""),_display_(/*52.53*/condition/*52.62*/.copy(milestone = Some(Some(milestone))).toURL),format.raw/*52.108*/("""" class="username"><i class="octicon octicon-milestone"></i> """),_display_(/*52.170*/milestone),format.raw/*52.179*/("""</a></span>
            """)))}),format.raw/*53.14*/("""
          """),format.raw/*54.11*/("""</div>
        </td>
      </tr>
    """)))}),format.raw/*57.6*/("""
    """),_display_(if(issues.isEmpty)/*58.24*/{_display_(Seq[Any](format.raw/*58.25*/("""
      """),format.raw/*59.7*/("""<tr>
        <td style="padding: 20px; background-color: #eee; text-align: center;">
          No results matched your search.
        </td>
      </tr>
    """)))} else {null} ),format.raw/*64.6*/("""
  """),format.raw/*65.3*/("""</tbody>
</table>
<div class="pull-right">
  """),_display_(/*68.4*/gitbucket/*68.13*/.core.helper.html.paginator(page, (if(condition.state == "open") openCount else closedCount), IssuesService.IssueLimit, 10, condition.toURL)),format.raw/*68.153*/("""
"""),format.raw/*69.1*/("""</div>
"""))
      }
    }
  }

  def render(issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,filter:String,groups:List[String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def f:((List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,String,List[String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,page,openCount,closedCount,condition,filter,groups) => (context) => apply(issues,page,openCount,closedCount,condition,filter,groups)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/issueslist.scala.html
                  HASH: b945e152f37b3a6bd8d687681e184d4335114b4d
                  MATRIX: 847->1|1287->370|1329->406|1381->451|1464->505|1624->638|1642->647|1733->717|1767->724|1835->766|1850->772|1863->776|2011->885|2045->892|2159->979|2175->986|2201->991|2230->993|2244->998|2274->1007|2303->1009|2317->1014|2353->1029|2383->1032|2397->1037|2427->1046|2456->1048|2470->1053|2507->1068|2587->1121|2626->1122|2667->1135|2708->1149|2744->1164|2785->1178|2801->1185|2827->1190|2856->1192|2870->1197|2900->1206|2929->1208|2943->1213|2980->1228|3015->1235|3030->1240|3060->1248|3111->1271|3126->1276|3154->1282|3193->1304|3232->1305|3273->1318|3314->1332|3350->1347|3391->1361|3407->1368|3433->1373|3462->1375|3476->1380|3506->1389|3535->1391|3549->1396|3586->1411|3623->1420|3638->1425|3668->1433|3719->1456|3734->1461|3762->1467|3809->1483|3848->1495|3863->1501|3876->1505|3944->1535|3985->1549|4003->1558|4087->1621|4130->1633|4169->1645|4184->1651|4197->1655|4246->1666|4287->1679|4373->1738|4387->1743|4414->1749|4452->1760|4466->1765|4498->1775|4568->1817|4583->1822|4615->1832|4665->1851|4704->1862|4776->1907|4802->1924|4815->1928|4867->1942|4910->1958|4926->1965|4984->2002|5029->2016|5090->2050|5129->2051|5172->2066|5209->2076|5225->2083|5251->2088|5280->2090|5294->2095|5324->2104|5353->2106|5367->2111|5403->2126|5439->2135|5453->2140|5482->2148|5604->2243|5637->2255|5680->2270|5721->2294|5760->2295|5803->2310|5840->2320|5856->2327|5882->2332|5911->2334|5925->2339|5955->2348|5984->2350|5998->2355|6034->2370|6070->2379|6084->2384|6113->2392|6251->2503|6284->2515|6327->2530|6376->2548|6415->2559|6525->2642|6539->2647|6568->2655|6597->2656|6635->2667|6651->2674|6722->2724|6751->2726|6768->2733|6821->2764|6862->2778|6880->2787|6893->2791|6946->2806|6989->2821|7054->2859|7072->2868|7140->2914|7230->2976|7261->2985|7317->3010|7356->3021|7424->3059|7475->3083|7514->3084|7548->3091|7749->3249|7779->3252|7851->3298|7869->3307|8031->3447|8059->3448
                  LINES: 14->1|23->8|24->9|25->10|28->11|32->15|32->15|32->15|33->16|37->20|37->20|37->20|37->20|38->21|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|40->23|41->24|41->24|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|43->26|43->26|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|44->27|45->28|46->29|46->29|46->29|46->29|47->30|47->30|47->30|48->31|49->32|49->32|49->32|49->32|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|51->34|52->35|53->36|53->36|53->36|53->36|54->37|54->37|54->37|55->38|56->39|56->39|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|57->40|58->41|58->41|59->42|60->43|60->43|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|61->44|62->45|62->45|63->46|64->47|65->48|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|68->51|68->51|68->51|68->51|69->52|69->52|69->52|69->52|69->52|69->52|70->53|71->54|74->57|75->58|75->58|76->59|81->64|82->65|85->68|85->68|85->68|86->69
                  -- GENERATED --
              */
          