
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object pulls extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,String,List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issues: List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],
  page: Int,
  openCount: Int,
  closedCount: Int,
  condition: gitbucket.core.service.IssuesService.IssueSearchCondition,
  filter: String,
  groups: List[String],
  recentRepositories: List[gitbucket.core.service.RepositoryService.RepositoryInfo],
  enableNewsFeed: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*10.2*/gitbucket/*10.11*/.core.html.main("Pull requests")/*10.43*/{_display_(Seq[Any](format.raw/*10.44*/("""
  """),_display_(/*11.4*/gitbucket/*11.13*/.core.dashboard.html.sidebar(recentRepositories)/*11.61*/{_display_(Seq[Any](format.raw/*11.62*/("""
    """),_display_(/*12.6*/gitbucket/*12.15*/.core.dashboard.html.tab(enableNewsFeed, "pulls")),format.raw/*12.64*/("""
    """),format.raw/*13.5*/("""<div class="container">
      """),_display_(/*14.8*/gitbucket/*14.17*/.core.dashboard.html.issuesnavi("pulls", filter, openCount, closedCount, condition)),format.raw/*14.100*/("""
      """),_display_(/*15.8*/gitbucket/*15.17*/.core.dashboard.html.issueslist(issues, page, openCount, closedCount, condition, filter, groups)),format.raw/*15.113*/("""
    """),format.raw/*16.5*/("""</div>
  """)))}),format.raw/*17.4*/("""
""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(issues:List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],page:Int,openCount:Int,closedCount:Int,condition:gitbucket.core.service.IssuesService.IssueSearchCondition,filter:String,groups:List[String],recentRepositories:List[gitbucket.core.service.RepositoryService.RepositoryInfo],enableNewsFeed:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issues,page,openCount,closedCount,condition,filter,groups,recentRepositories,enableNewsFeed)(context)

  def f:((List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,String,List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issues,page,openCount,closedCount,condition,filter,groups,recentRepositories,enableNewsFeed) => (context) => apply(issues,page,openCount,closedCount,condition,filter,groups,recentRepositories,enableNewsFeed)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/pulls.scala.html
                  HASH: c932b4bdbbbf4f3f96f525e273e0fbb80abfb633
                  MATRIX: 913->1|1487->482|1505->491|1546->523|1585->524|1615->528|1633->537|1690->585|1729->586|1761->592|1779->601|1849->650|1881->655|1938->686|1956->695|2061->778|2095->786|2113->795|2231->891|2263->896|2303->906|2335->908
                  LINES: 14->1|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|30->13|31->14|31->14|31->14|32->15|32->15|32->15|33->16|34->17|35->18
                  -- GENERATED --
              */
          