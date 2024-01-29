
package gitbucket.core.search.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issues extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[gitbucket.core.service.RepositorySearchService.IssueSearchResult],Boolean,String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[gitbucket.core.service.RepositorySearchService.IssueSearchResult],
  pullRequest: Boolean,
  query: String,
  page: Int,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*6.2*/import gitbucket.core.view.helpers
/*7.2*/import gitbucket.core.service.RepositorySearchService


Seq[Any](_display_(/*8.2*/gitbucket/*8.11*/.core.html.main("Search Results", Some(repository))/*8.62*/{_display_(Seq[Any](format.raw/*8.63*/("""
  """),_display_(/*9.4*/gitbucket/*9.13*/.core.search.html.menu(if(pullRequest) "pulls" else "issues", query, repository)/*9.93*/{_display_(Seq[Any](format.raw/*9.94*/("""
    """),_display_(if(query.nonEmpty)/*10.24*/ {_display_(Seq[Any](format.raw/*10.26*/("""
      """),_display_(if(issues.isEmpty)/*11.26*/ {_display_(Seq[Any](format.raw/*11.28*/("""
        """),format.raw/*12.9*/("""<h4>We couldn't find any """),_display_(/*12.35*/{if(pullRequest) "pull requests" else "issues"}),format.raw/*12.82*/(""" """),format.raw/*12.83*/("""matching '"""),_display_(/*12.94*/query),format.raw/*12.99*/("""'</h4>
      """)))}else/*13.14*/{_display_(Seq[Any](format.raw/*13.15*/("""
        """),format.raw/*14.9*/("""<h4>We've found """),_display_(/*14.26*/issues/*14.32*/.size),format.raw/*14.37*/(""" """),_display_(/*14.39*/helpers/*14.46*/.plural(issues.size, if(pullRequest) "pull request" else "issue")),format.raw/*14.111*/("""</h4>
      """)))}),format.raw/*15.8*/("""
    """)))} else {null} ),format.raw/*16.6*/("""
    """),_display_(/*17.6*/issues/*17.12*/.drop((page - 1) * RepositorySearchService.IssueLimit).take(RepositorySearchService.IssueLimit).map/*17.111*/ { issue =>_display_(Seq[Any](format.raw/*17.122*/("""
      """),format.raw/*18.7*/("""<div class="block">
        <div class="pull-right muted">
          """),_display_(if(issue.isClosed)/*20.30*/{_display_(Seq[Any](format.raw/*20.31*/("""
            """),format.raw/*21.13*/("""<span class="label label-danger">Closed</span>
          """)))} else {null} ),format.raw/*22.12*/("""
          """),format.raw/*23.11*/("""#"""),_display_(/*23.13*/issue/*23.18*/.issueId),format.raw/*23.26*/("""
        """),format.raw/*24.9*/("""</div>
        <h4 style="margin-top: 0px;"><a href=""""),_display_(/*25.48*/helpers/*25.55*/.url(repository)),format.raw/*25.71*/("""/"""),_display_(if(issue.isPullRequest)/*25.96*/{_display_(Seq[Any](format.raw/*25.97*/("""pull""")))}else/*25.108*/{_display_(Seq[Any](format.raw/*25.109*/("""issues""")))}),format.raw/*25.116*/("""/"""),_display_(/*25.118*/issue/*25.123*/.issueId),format.raw/*25.131*/("""">"""),_display_(/*25.134*/issue/*25.139*/.title),format.raw/*25.145*/("""</a></h4>
        """),_display_(if(issue.highlightText.nonEmpty)/*26.42*/{_display_(Seq[Any](format.raw/*26.43*/("""
          """),format.raw/*27.11*/("""<pre>"""),_display_(/*27.17*/Html(issue.highlightText)),format.raw/*27.42*/("""</pre>
        """)))} else {null} ),format.raw/*28.10*/("""
        """),format.raw/*29.9*/("""<div class="small muted">
          Opened by <a href=""""),_display_(/*30.31*/helpers/*30.38*/.url(issue.openedUserName)),format.raw/*30.64*/("""" class="username">"""),_display_(/*30.84*/issue/*30.89*/.openedUserName),format.raw/*30.104*/("""</a>
          """),_display_(/*31.12*/gitbucket/*31.21*/.core.helper.html.datetimeago(issue.registeredDate)),format.raw/*31.72*/("""
          """),_display_(if(issue.commentCount > 0)/*32.38*/{_display_(Seq[Any](format.raw/*32.39*/("""
            """),format.raw/*33.13*/("""&nbsp;&nbsp;<i class="octicon octicon-comment"></i>
            <span class="strong">"""),_display_(/*34.35*/issue/*34.40*/.commentCount),format.raw/*34.53*/("""</span> """),_display_(/*34.62*/helpers/*34.69*/.plural(issue.commentCount, "comment")),format.raw/*34.107*/("""
          """)))} else {null} ),format.raw/*35.12*/("""
        """),format.raw/*36.9*/("""</div>
      </div>
    """)))}),format.raw/*38.6*/("""
    """),_display_(/*39.6*/gitbucket/*39.15*/.core.helper.html.paginator(page, issues.size, RepositorySearchService.IssueLimit, 10,
      s"${helpers.url(repository)}/search?q=${helpers.urlEncode(query)}&type=${if(pullRequest) "pulls" else "issues"}")),format.raw/*40.120*/("""
  """)))}),format.raw/*41.4*/("""
""")))}),format.raw/*42.2*/("""
"""))
      }
    }
  }

  def render(issues:List[gitbucket.core.service.RepositorySearchService.IssueSearchResult],pullRequest:Boolean,query:String,page:Int,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,pullRequest,query,page,repository)(context)

  def f:((List[gitbucket.core.service.RepositorySearchService.IssueSearchResult],Boolean,String,Int,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,pullRequest,query,page,repository) => (context) => apply(issues,pullRequest,query,page,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/search/issues.scala.html
                  HASH: ba6c2cc760f397712b7eb01194d863069ca62132
                  MATRIX: 756->1|1087->261|1129->297|1211->352|1228->361|1287->412|1325->413|1354->417|1371->426|1459->506|1497->507|1548->531|1588->533|1641->559|1681->561|1717->570|1770->596|1838->643|1867->644|1905->655|1931->660|1968->680|2007->681|2043->690|2087->707|2102->713|2128->718|2157->720|2173->727|2260->792|2303->805|2352->811|2384->817|2399->823|2508->922|2558->933|2592->940|2707->1028|2746->1029|2787->1042|2889->1100|2928->1111|2957->1113|2971->1118|3000->1126|3036->1135|3117->1189|3133->1196|3170->1212|3222->1237|3261->1238|3290->1249|3330->1250|3369->1257|3399->1259|3414->1264|3444->1272|3475->1275|3490->1280|3518->1286|3596->1337|3635->1338|3674->1349|3707->1355|3753->1380|3813->1396|3849->1405|3932->1461|3948->1468|3995->1494|4042->1514|4056->1519|4093->1534|4136->1550|4154->1559|4226->1610|4291->1648|4330->1649|4371->1662|4484->1748|4498->1753|4532->1766|4568->1775|4584->1782|4644->1820|4700->1832|4736->1841|4791->1866|4823->1872|4841->1881|5069->2087|5103->2091|5135->2093
                  LINES: 14->1|21->6|22->7|25->8|25->8|25->8|25->8|26->9|26->9|26->9|26->9|27->10|27->10|28->11|28->11|29->12|29->12|29->12|29->12|29->12|29->12|30->13|30->13|31->14|31->14|31->14|31->14|31->14|31->14|31->14|32->15|33->16|34->17|34->17|34->17|34->17|35->18|37->20|37->20|38->21|39->22|40->23|40->23|40->23|40->23|41->24|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|42->25|43->26|43->26|44->27|44->27|44->27|45->28|46->29|47->30|47->30|47->30|47->30|47->30|47->30|48->31|48->31|48->31|49->32|49->32|50->33|51->34|51->34|51->34|51->34|51->34|51->34|52->35|53->36|55->38|56->39|56->39|57->40|58->41|59->42
                  -- GENERATED --
              */
          