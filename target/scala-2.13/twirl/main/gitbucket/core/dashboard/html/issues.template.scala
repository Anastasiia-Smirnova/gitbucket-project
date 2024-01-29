
package gitbucket.core.dashboard.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object issues extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[List[(gitbucket.core.service.IssuesService.IssueInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])],Int,Int,Int,gitbucket.core.service.IssuesService.IssueSearchCondition,String,List[String],List[gitbucket.core.service.RepositoryService.RepositoryInfo],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

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


Seq[Any](_display_(/*10.2*/gitbucket/*10.11*/.core.html.main("Issues")/*10.36*/{_display_(Seq[Any](format.raw/*10.37*/("""
  """),_display_(/*11.4*/gitbucket/*11.13*/.core.dashboard.html.sidebar(recentRepositories)/*11.61*/{_display_(Seq[Any](format.raw/*11.62*/("""
    """),_display_(/*12.6*/gitbucket/*12.15*/.core.dashboard.html.tab(enableNewsFeed, "issues")),format.raw/*12.65*/("""
    """),format.raw/*13.5*/("""<div class="container">
      """),_display_(/*14.8*/gitbucket/*14.17*/.core.dashboard.html.issuesnavi("issues", filter, openCount, closedCount, condition)),format.raw/*14.101*/("""
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
                  SOURCE: src/main/twirl/gitbucket/core/dashboard/issues.scala.html
                  HASH: cd1a688ff12fbb23fc0db44bb2baaeb31730f7da
                  MATRIX: 914->1|1488->482|1506->491|1540->516|1579->517|1609->521|1627->530|1684->578|1723->579|1755->585|1773->594|1844->644|1876->649|1933->680|1951->689|2057->773|2091->781|2109->790|2227->886|2259->891|2299->901|2331->903
                  LINES: 14->1|27->10|27->10|27->10|27->10|28->11|28->11|28->11|28->11|29->12|29->12|29->12|30->13|31->14|31->14|31->14|32->15|32->15|32->15|33->16|34->17|35->18
                  -- GENERATED --
              */
          