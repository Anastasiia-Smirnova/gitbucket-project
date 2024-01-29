
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commits extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],Seq[gitbucket.core.model.Comment],Int,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: gitbucket.core.model.Issue,
  pullreq: gitbucket.core.model.PullRequest,
  commits: Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],
  comments: Seq[gitbucket.core.model.Comment],
  changedFileSize: Int,
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*9.2*/gitbucket/*9.11*/.core.pulls.html.menu("commits", issue, pullreq, commits.flatten.map(_._1), comments, changedFileSize, isManageable, repository)/*9.139*/{_display_(Seq[Any](format.raw/*9.140*/("""
  """),format.raw/*10.3*/("""<table class="table table-bordered table-hover">
  """),_display_(/*11.4*/commits/*11.11*/.map/*11.15*/ { day =>_display_(Seq[Any](format.raw/*11.24*/("""
    """),format.raw/*12.5*/("""<tr>
      <th rowspan=""""),_display_(/*13.21*/day/*13.24*/.size),format.raw/*13.29*/("""" width="100">"""),_display_(/*13.44*/helpers/*13.51*/.date(day.head._1.commitTime)),format.raw/*13.80*/("""</th>
      """),_display_(/*14.8*/day/*14.11*/.zipWithIndex.map/*14.28*/ { case ((commit, status), i) =>_display_(Seq[Any](format.raw/*14.60*/("""
        """),_display_(if(i != 0)/*15.20*/{_display_(Seq[Any](format.raw/*15.21*/(""" """),format.raw/*15.22*/("""<tr> """)))} else {null} ),format.raw/*15.28*/("""
        """),format.raw/*16.9*/("""<td>
          <div class="pull-right text-right">
            <a href=""""),_display_(/*18.23*/helpers/*18.30*/.url(repository)),format.raw/*18.46*/("""/commit/"""),_display_(/*18.55*/commit/*18.61*/.id),format.raw/*18.64*/("""" class="monospace commit-message strong"><i class="octicon octicon-diff" style="color: black;"></i>"""),_display_(/*18.165*/commit/*18.171*/.id.substring(0, 7)),format.raw/*18.190*/("""</a><br>
            <a href=""""),_display_(/*19.23*/helpers/*19.30*/.url(repository)),format.raw/*19.46*/("""/tree/"""),_display_(/*19.53*/commit/*19.59*/.id),format.raw/*19.62*/("""" class="button-link">Browse files »</a>
          </div>
          <div>
            <div class="commit-avatar-image">"""),_display_(/*22.47*/helpers/*22.54*/.avatarLink(commit, 40)),format.raw/*22.77*/("""</div>
            <div>
              <a href=""""),_display_(/*24.25*/helpers/*24.32*/.url(repository)),format.raw/*24.48*/("""/commit/"""),_display_(/*24.57*/commit/*24.63*/.id),format.raw/*24.66*/("""" class="commit-message strong">"""),_display_(/*24.99*/helpers/*24.106*/.link(commit.summary, repository)),format.raw/*24.139*/("""</a>
              """),_display_(if(commit.description.isDefined)/*25.48*/{_display_(Seq[Any](format.raw/*25.49*/("""
                """),format.raw/*26.17*/("""<a href="javascript:void(0)" onclick="$('#description-"""),_display_(/*26.72*/commit/*26.78*/.id),format.raw/*26.81*/("""').toggle();" class="omit">...</a>
              """)))} else {null} ),format.raw/*27.16*/("""
              """),format.raw/*28.15*/("""<br>
              """),_display_(if(commit.description.isDefined)/*29.48*/{_display_(Seq[Any](format.raw/*29.49*/("""
                """),format.raw/*30.17*/("""<pre id="description-"""),_display_(/*30.39*/commit/*30.45*/.id),format.raw/*30.48*/("""" style="display: none;" class="commit-description">"""),_display_(/*30.101*/helpers/*30.108*/.link(commit.description.get, repository)),format.raw/*30.149*/("""</pre>
              """)))} else {null} ),format.raw/*31.16*/("""
              """),format.raw/*32.15*/("""<div>
                """),_display_(if(commit.isDifferentFromAuthor)/*33.50*/ {_display_(Seq[Any](format.raw/*33.52*/("""
                  """),_display_(/*34.20*/helpers/*34.27*/.user(commit.authorName, commit.authorEmailAddress, "username")),format.raw/*34.90*/("""
                  """),format.raw/*35.19*/("""<span class="muted">authored """),_display_(/*35.49*/gitbucket/*35.58*/.core.helper.html.datetimeago(commit.authorTime)),format.raw/*35.106*/("""</span>
                  <span class="octicon octicon-arrow-right" style="margin-top : -2px;"></span>
                """)))} else {null} ),format.raw/*37.18*/("""
                """),_display_(/*38.18*/helpers/*38.25*/.user(commit.committerName, commit.committerEmailAddress, "username")),format.raw/*38.94*/("""
                """),format.raw/*39.17*/("""<span class="muted">committed """),_display_(/*39.48*/gitbucket/*39.57*/.core.helper.html.datetimeago(commit.commitTime)),format.raw/*39.105*/("""</span>
                """),_display_(/*40.18*/status/*40.24*/.map/*40.28*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*40.58*/("""
                  """),_display_(/*41.20*/gitbucket/*41.29*/.core.helper.html.commitstatus(commit.id, summary, statuses)),format.raw/*41.89*/("""
                """)))}),format.raw/*42.18*/("""
              """),format.raw/*43.15*/("""</div>
            </div>
          </div>
        </td>
        </tr>
      """)))}),format.raw/*48.8*/("""
  """)))}),format.raw/*49.4*/("""
  """),format.raw/*50.3*/("""</table>
""")))}),format.raw/*51.2*/("""
"""))
      }
    }
  }

  def render(issue:gitbucket.core.model.Issue,pullreq:gitbucket.core.model.PullRequest,commits:Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],comments:Seq[gitbucket.core.model.Comment],changedFileSize:Int,isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,pullreq,commits,comments,changedFileSize,isManageable,repository)(context)

  def f:((gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[Seq[(gitbucket.core.util.JGitUtil.CommitInfo, Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])])]],Seq[gitbucket.core.model.Comment],Int,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,pullreq,commits,comments,changedFileSize,isManageable,repository) => (context) => apply(issue,pullreq,commits,comments,changedFileSize,isManageable,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/commits.scala.html
                  HASH: d0ec00ef34b0646519d68711fae51bdd80a354c3
                  MATRIX: 909->1|1431->452|1494->488|1511->497|1648->625|1687->626|1717->629|1795->681|1811->688|1824->692|1871->701|1903->706|1955->731|1967->734|1993->739|2035->754|2051->761|2101->790|2140->803|2152->806|2178->823|2248->855|2295->875|2334->876|2363->877|2413->883|2449->892|2549->965|2565->972|2602->988|2638->997|2653->1003|2677->1006|2806->1107|2822->1113|2863->1132|2921->1163|2937->1170|2974->1186|3008->1193|3023->1199|3047->1202|3194->1322|3210->1329|3254->1352|3330->1401|3346->1408|3383->1424|3419->1433|3434->1439|3458->1442|3518->1475|3535->1482|3590->1515|3669->1567|3708->1568|3753->1585|3835->1640|3850->1646|3874->1649|3968->1699|4011->1714|4090->1766|4129->1767|4174->1784|4223->1806|4238->1812|4262->1815|4343->1868|4360->1875|4423->1916|4489->1938|4532->1953|4614->2008|4654->2010|4701->2030|4717->2037|4801->2100|4848->2119|4905->2149|4923->2158|4993->2206|5157->2326|5202->2344|5218->2351|5308->2420|5353->2437|5411->2468|5429->2477|5499->2525|5551->2550|5566->2556|5579->2560|5647->2590|5694->2610|5712->2619|5793->2679|5842->2697|5885->2712|5993->2790|6027->2794|6057->2797|6097->2807
                  LINES: 14->1|23->8|26->9|26->9|26->9|26->9|27->10|28->11|28->11|28->11|28->11|29->12|30->13|30->13|30->13|30->13|30->13|30->13|31->14|31->14|31->14|31->14|32->15|32->15|32->15|32->15|33->16|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|35->18|36->19|36->19|36->19|36->19|36->19|36->19|39->22|39->22|39->22|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|42->25|42->25|43->26|43->26|43->26|43->26|44->27|45->28|46->29|46->29|47->30|47->30|47->30|47->30|47->30|47->30|47->30|48->31|49->32|50->33|50->33|51->34|51->34|51->34|52->35|52->35|52->35|52->35|54->37|55->38|55->38|55->38|56->39|56->39|56->39|56->39|57->40|57->40|57->40|57->40|58->41|58->41|58->41|59->42|60->43|65->48|66->49|67->50|68->51
                  -- GENERATED --
              */
          