
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object conversation extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template19[gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Int,List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Map[String, String],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: gitbucket.core.model.Issue,
  pullreq: gitbucket.core.model.PullRequest,
  commits: Seq[gitbucket.core.util.JGitUtil.CommitInfo],
  comments: Seq[gitbucket.core.model.Comment],
  changedFileSize: Int,
  issueLabels: List[gitbucket.core.model.Label],
  issueAssignees: List[gitbucket.core.model.IssueAssignee],
  collaborators: List[String],
  milestones: List[(gitbucket.core.model.Milestone, Int, Int)],
  priorities: List[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  customFields: List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],
  isEditable: Boolean,
  isManageable: Boolean,
  isManageableForkedRepository: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  forkedRepository: Option[gitbucket.core.service.RepositoryService.RepositoryInfo],
  flash: Map[String, String])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*19.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*20.2*/gitbucket/*20.11*/.core.pulls.html.menu("conversation", issue, pullreq, commits, comments, changedFileSize, isManageable, repository, flash)/*20.133*/{_display_(Seq[Any](format.raw/*20.134*/("""
  """),format.raw/*21.3*/("""<link href=""""),_display_(/*21.16*/helpers/*21.23*/.assets("/vendors/jsdifflib/diffview.css")),format.raw/*21.65*/("""" type="text/css" rel="stylesheet" />
  <div class="col-md-9">
    <div id="comment-list">
      """),_display_(/*24.8*/gitbucket/*24.17*/.core.issues.html.commentlist(Some(issue), comments.toList, isManageable, repository, Some(pullreq))),format.raw/*24.117*/("""
    """),format.raw/*25.5*/("""</div>
    """),_display_(/*26.6*/defining(comments.flatMap {
      case comment: gitbucket.core.model.IssueComment => Some(comment)
      case other => None
    }.exists(_.action == "merge"))/*29.35*/{ merged =>_display_(Seq[Any](format.raw/*29.46*/("""
      """),_display_(if(!issue.closed)/*30.25*/{_display_(Seq[Any](format.raw/*30.26*/("""
        """),format.raw/*31.9*/("""<div class="check-conflict" style="display: none; margin-bottom: 20px;">
          <div class="issue-comment-box" style="background-color: #fbeed5">
            <div class="box-content" style="border: 1px solid #c09853; padding: 10px;">
              <img src=""""),_display_(/*34.26*/helpers/*34.33*/.assets("/common/images/indicator.gif")),format.raw/*34.72*/(""""/> Checking...
            </div>
          </div>
        </div>
      """)))} else {null} ),format.raw/*38.8*/("""
      """),_display_(if(isManageableForkedRepository && issue.closed && merged &&
        forkedRepository.map(r => (r.branchList.contains(pullreq.requestBranch) && r.repository.defaultBranch != pullreq.requestBranch)).getOrElse(false))/*40.155*/{_display_(Seq[Any](format.raw/*40.156*/("""
        """),format.raw/*41.9*/("""<div class="issue-comment-box" style="background-color: #d0eeff;">
          <div class="box-content" style="border: 1px solid #87a8c9; padding: 10px;">
            <a href=""""),_display_(/*43.23*/helpers/*43.30*/.url(repository)),format.raw/*43.46*/("""/pull/"""),_display_(/*43.53*/issue/*43.58*/.issueId),format.raw/*43.66*/("""/delete_branch" class="btn btn-info pull-right delete-branch" data-name=""""),_display_(/*43.140*/pullreq/*43.147*/.requestBranch),format.raw/*43.161*/("""">Delete branch</a>
            <div>
              <span class="strong">Pull request successfully merged and closed</span>
            </div>
            <span class="small muted">You're all set. The <span class="label label-info monospace">"""),_display_(/*47.101*/pullreq/*47.108*/.requestBranch),format.raw/*47.122*/("""</span> branch can now be safely deleted.</span>
          </div>
        </div>
      """)))} else {null} ),format.raw/*50.8*/("""
      """),_display_(/*51.8*/gitbucket/*51.17*/.core.issues.html.commentform(issue, !merged, isEditable, isManageable, repository)),format.raw/*51.100*/("""
    """)))}),format.raw/*52.6*/("""
  """),format.raw/*53.3*/("""</div>
  <div class="col-md-3">
    """),_display_(/*55.6*/gitbucket/*55.15*/.core.issues.html.issueinfo(
      Some(issue),
      comments.toList,
      issueLabels,
      issueAssignees,
      collaborators,
      milestones,
      priorities,
      None,
      labels,
      customFields,
      isManageable,
      repository
    )),format.raw/*68.6*/("""
  """),format.raw/*69.3*/("""</div>
  <script>
  $(function()"""),format.raw/*71.15*/("""{"""),format.raw/*71.16*/("""
    """),_display_(if(commits.nonEmpty)/*72.26*/{_display_(Seq[Any](format.raw/*72.27*/("""
      """),format.raw/*73.7*/("""const checkConflict = $('.check-conflict').show();
      if(checkConflict.length)"""),format.raw/*74.31*/("""{"""),format.raw/*74.32*/("""
        """),format.raw/*75.9*/("""$.get('"""),_display_(/*75.17*/helpers/*75.24*/.url(repository)),format.raw/*75.40*/("""/pull/"""),_display_(/*75.47*/issue/*75.52*/.issueId),format.raw/*75.60*/("""/mergeguide', function(data)"""),format.raw/*75.88*/("""{"""),format.raw/*75.89*/(""" """),format.raw/*75.90*/("""$('.check-conflict').html(data); """),format.raw/*75.123*/("""}"""),format.raw/*75.124*/(""");
      """),format.raw/*76.7*/("""}"""),format.raw/*76.8*/("""
    """)))} else {null} ),format.raw/*77.6*/("""
    """),format.raw/*78.5*/("""$('.delete-branch').click(function(e)"""),format.raw/*78.42*/("""{"""),format.raw/*78.43*/("""
      """),format.raw/*79.7*/("""const branchName = $(e.target).data('name');
      return confirm('Are you sure you want to remove the ' + branchName + ' branch?');
    """),format.raw/*81.5*/("""}"""),format.raw/*81.6*/(""");
  """),format.raw/*82.3*/("""}"""),format.raw/*82.4*/(""");
  </script>
""")))}),format.raw/*84.2*/("""
"""))
      }
    }
  }

  def render(issue:gitbucket.core.model.Issue,pullreq:gitbucket.core.model.PullRequest,commits:Seq[gitbucket.core.util.JGitUtil.CommitInfo],comments:Seq[gitbucket.core.model.Comment],changedFileSize:Int,issueLabels:List[gitbucket.core.model.Label],issueAssignees:List[gitbucket.core.model.IssueAssignee],collaborators:List[String],milestones:List[(gitbucket.core.model.Milestone, Int, Int)],priorities:List[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],customFields:List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],isEditable:Boolean,isManageable:Boolean,isManageableForkedRepository:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,forkedRepository:Option[gitbucket.core.service.RepositoryService.RepositoryInfo],flash:Map[String, String],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,pullreq,commits,comments,changedFileSize,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isManageableForkedRepository,repository,forkedRepository,flash)(context)

  def f:((gitbucket.core.model.Issue,gitbucket.core.model.PullRequest,Seq[gitbucket.core.util.JGitUtil.CommitInfo],Seq[gitbucket.core.model.Comment],Int,List[gitbucket.core.model.Label],List[gitbucket.core.model.IssueAssignee],List[String],List[(gitbucket.core.model.Milestone, Int, Int)],List[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[(gitbucket.core.model.CustomField, Option[gitbucket.core.model.IssueCustomField])],Boolean,Boolean,Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[gitbucket.core.service.RepositoryService.RepositoryInfo],Map[String, String]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,pullreq,commits,comments,changedFileSize,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isManageableForkedRepository,repository,forkedRepository,flash) => (context) => apply(issue,pullreq,commits,comments,changedFileSize,issueLabels,issueAssignees,collaborators,milestones,priorities,labels,customFields,isEditable,isManageable,isManageableForkedRepository,repository,forkedRepository,flash)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/conversation.scala.html
                  HASH: e11316e459c0e9107e78c36db87feb18ee22dd15
                  MATRIX: 1216->1|2230->943|2294->979|2312->988|2444->1110|2484->1111|2514->1114|2554->1127|2570->1134|2633->1176|2757->1274|2775->1283|2897->1383|2929->1388|2967->1400|3134->1558|3183->1569|3235->1594|3274->1595|3310->1604|3599->1866|3615->1873|3675->1912|3792->1986|4043->2209|4083->2210|4119->2219|4321->2394|4337->2401|4374->2417|4408->2424|4422->2429|4451->2437|4553->2511|4570->2518|4606->2532|4877->2775|4894->2782|4930->2796|5061->2884|5095->2892|5113->2901|5218->2984|5254->2990|5284->2993|5347->3030|5365->3039|5642->3296|5672->3299|5732->3331|5761->3332|5814->3358|5853->3359|5887->3366|5996->3447|6025->3448|6061->3457|6096->3465|6112->3472|6149->3488|6183->3495|6197->3500|6226->3508|6282->3536|6311->3537|6340->3538|6402->3571|6432->3572|6468->3581|6496->3582|6545->3588|6577->3593|6642->3630|6671->3631|6705->3638|6869->3775|6897->3776|6929->3781|6957->3782|7003->3798
                  LINES: 14->1|34->19|37->20|37->20|37->20|37->20|38->21|38->21|38->21|38->21|41->24|41->24|41->24|42->25|43->26|46->29|46->29|47->30|47->30|48->31|51->34|51->34|51->34|55->38|57->40|57->40|58->41|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|60->43|64->47|64->47|64->47|67->50|68->51|68->51|68->51|69->52|70->53|72->55|72->55|85->68|86->69|88->71|88->71|89->72|89->72|90->73|91->74|91->74|92->75|92->75|92->75|92->75|92->75|92->75|92->75|92->75|92->75|92->75|92->75|92->75|93->76|93->76|94->77|95->78|95->78|95->78|96->79|98->81|98->81|99->82|99->82|101->84
                  -- GENERATED --
              */
          