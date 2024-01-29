
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object files extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.DiffInfo],Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: gitbucket.core.model.Issue,
  pullreq: gitbucket.core.model.PullRequest,
  diffs: Seq[gitbucket.core.util.JGitUtil.DiffInfo],
  commits: Seq[gitbucket.core.util.JGitUtil.CommitInfo],
  comments: Seq[gitbucket.core.model.Comment],
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*8.2*/gitbucket/*8.11*/.core.pulls.html.menu("files", issue, pullreq, commits, comments, diffs.size, isManageable, repository)/*8.114*/ {_display_(Seq[Any](format.raw/*8.116*/("""
  """),_display_(/*9.4*/gitbucket/*9.13*/.core.helper.html.diff(
    diffs,
    repository,
    commits.headOption.map(_.id),
    Some(pullreq.commitIdFrom),
    true,
    Some(pullreq.issueId),
    isManageable,
    true
  )),format.raw/*18.4*/("""
  """),format.raw/*19.3*/("""<div id="comment-list" style="display: none;">
    """),_display_(/*20.6*/gitbucket/*20.15*/.core.issues.html.commentlist(Some(issue), comments.toList, isManageable, repository, Some(pullreq))),format.raw/*20.115*/("""
  """),format.raw/*21.3*/("""</div>
""")))}),format.raw/*22.2*/("""
"""))
      }
    }
  }

  def render(issue:gitbucket.core.model.Issue,pullreq:gitbucket.core.model.PullRequest,diffs:Seq[gitbucket.core.util.JGitUtil.DiffInfo],commits:Seq[gitbucket.core.util.JGitUtil.CommitInfo],comments:Seq[gitbucket.core.model.Comment],isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,pullreq,diffs,commits,comments,isManageable,repository)(context)

  def f:((gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.DiffInfo],Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,pullreq,diffs,commits,comments,isManageable,repository) => (context) => apply(issue,pullreq,diffs,commits,comments,isManageable,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/files.scala.html
                  HASH: e7f5167299fd28ffc88a0d36d6b76aeec1a624ae
                  MATRIX: 854->1|1334->389|1351->398|1463->501|1503->503|1532->507|1549->516|1753->700|1783->703|1861->755|1879->764|2001->864|2031->867|2069->875
                  LINES: 14->1|25->8|25->8|25->8|25->8|26->9|26->9|35->18|36->19|37->20|37->20|37->20|38->21|39->22
                  -- GENERATED --
              */
          