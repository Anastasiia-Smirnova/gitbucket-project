
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object commentlist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[Option[gitbucket.core.model.Issue],List[gitbucket.core.model.Comment],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[gitbucket.core.model.PullRequest],Option[String],Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(issue: Option[gitbucket.core.model.Issue],
  comments: List[gitbucket.core.model.Comment],
  isManageable: Boolean,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pullreq: Option[gitbucket.core.model.PullRequest] = None,
  commitId: Option[String] = None,
  renderScript: Boolean = true)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*8.2*/import gitbucket.core.view.helpers
/*9.2*/import gitbucket.core.util.StringUtil._

def /*10.2*/issueOrPullRequest/*10.20*/():play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*10.24*/(""" """),_display_(if(issue.exists(_.isPullRequest))/*10.59*/( "pull request" )else/*10.81*/( "issue" )),format.raw/*10.92*/(""" """)))};def /*11.2*/showFormattedComment/*11.22*/(comment: gitbucket.core.model.IssueComment):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.68*/("""
"""),format.raw/*12.1*/("""<div class="panel panel-default issue-comment-box" id="comment-"""),_display_(/*12.65*/comment/*12.72*/.commentId),format.raw/*12.82*/("""">
  <div class="panel-heading">
    """),_display_(/*14.6*/helpers/*14.13*/.avatarLink(comment.commentedUserName, 20)),format.raw/*14.55*/("""
    """),_display_(/*15.6*/helpers/*15.13*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*15.75*/("""
    """),format.raw/*16.5*/("""<span class="muted">
      """),_display_(if(comment.action == "comment")/*17.39*/{_display_(Seq[Any](format.raw/*17.40*/("""
        """),format.raw/*18.9*/("""commented
      """)))}else/*19.14*/{_display_(Seq[Any](format.raw/*19.15*/("""
        """),format.raw/*20.9*/("""referenced the """),_display_(/*20.25*/issueOrPullRequest()),format.raw/*20.45*/("""
      """)))}),format.raw/*21.8*/("""
      """),format.raw/*22.7*/("""<a href="#comment-"""),_display_(/*22.26*/comment/*22.33*/.commentId),format.raw/*22.43*/("""">
        """),_display_(/*23.10*/gitbucket/*23.19*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*23.72*/("""
      """),format.raw/*24.7*/("""</a>
    </span>
    """),_display_(if(comment.action != "commit" && comment.action != "merge" && comment.action != "refer"
    && (isManageable || context.loginAccount.map(_.userName == comment.commentedUserName).getOrElse(false)))/*27.109*/{_display_(Seq[Any](format.raw/*27.110*/("""
      """),format.raw/*28.7*/("""<span class="pull-right">
        <a href="#" data-comment-id=""""),_display_(/*29.39*/comment/*29.46*/.commentId),format.raw/*29.56*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>&nbsp;
        <a href="#" data-comment-id=""""),_display_(/*30.39*/comment/*30.46*/.commentId),format.raw/*30.56*/(""""><i class="octicon octicon-x" aria-label="Remove"></i></a>
      </span>
    """)))} else {null} ),format.raw/*32.6*/("""
  """),format.raw/*33.3*/("""</div>
  <div class="panel-body markdown-body" id="commentContent-"""),_display_(/*34.61*/comment/*34.68*/.commentId),format.raw/*34.78*/("""">
    """),_display_(/*35.6*/helpers/*35.13*/.markdown(
      markdown           = comment.content,
      repository         = repository,
      branch             = repository.repository.defaultBranch,
      enableWikiLink     = false,
      enableRefsLink     = true,
      enableLineBreaks   = true,
      enableTaskList     = true,
      hasWritePermission = isManageable
    )),format.raw/*44.6*/("""
  """),format.raw/*45.3*/("""</div>
</div>
""")))};
Seq[Any](format.raw/*10.94*/("""
"""),format.raw/*47.2*/("""
"""),_display_(if(issue.isDefined)/*48.21*/{_display_(Seq[Any](format.raw/*48.22*/("""
  """),format.raw/*49.3*/("""<div class="panel panel-default issue-comment-box">
    <div class="panel-heading">
      """),_display_(/*51.8*/helpers/*51.15*/.avatarLink(issue.get.openedUserName, 20)),format.raw/*51.56*/("""
      """),_display_(/*52.8*/helpers/*52.15*/.user(issue.get.openedUserName, styleClass="username strong")),format.raw/*52.76*/("""
      """),format.raw/*53.7*/("""<span class="muted">commented """),_display_(/*53.38*/gitbucket/*53.47*/.core.helper.html.datetimeago(issue.get.registeredDate)),format.raw/*53.102*/("""</span>
      <span class="pull-right">
        """),_display_(if(isManageable || context.loginAccount.map(_.userName == issue.get.openedUserName).getOrElse(false))/*55.111*/{_display_(Seq[Any](format.raw/*55.112*/("""
          """),format.raw/*56.11*/("""<a href="#" data-issue-id=""""),_display_(/*56.39*/issue/*56.44*/.get.issueId),format.raw/*56.56*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>
        """)))} else {null} ),format.raw/*57.10*/("""
      """),format.raw/*58.7*/("""</span>
    </div>
    <div class="panel-body markdown-body" id="issueContent">
      """),_display_(/*61.8*/helpers/*61.15*/.markdown(
        markdown           = issue.get.content getOrElse "No description provided.",
        repository         = repository,
        branch             = repository.repository.defaultBranch,
        enableWikiLink     = false,
        enableRefsLink     = true,
        enableLineBreaks   = true,
        enableTaskList     = true,
        hasWritePermission = isManageable
      )),format.raw/*70.8*/("""
    """),format.raw/*71.5*/("""</div>
  </div>
""")))} else {null} ),format.raw/*73.2*/("""
"""),_display_(/*74.2*/comments/*74.10*/.map/*74.14*/ {/*75.3*/case comment: gitbucket.core.model.IssueComment =>/*75.53*/ {_display_(Seq[Any](format.raw/*75.55*/("""
    """),_display_(/*76.6*/comment/*76.13*/.action/*76.20*/ match/*76.26*/ {/*77.7*/case "commit" =>/*77.23*/ {_display_(Seq[Any](format.raw/*77.25*/("""
        """),_display_(/*78.10*/defining({
          val (content, id) = " ([a-f0-9]{40})$".r.findFirstMatchIn(comment.content)
          .map(m => (m.before.toString -> Some(m.group(1))))
          .getOrElse(comment.content -> None)
          val head = content.take(100).takeWhile(_ != '\n')
          (id, head, if(head == content){ None }else{ Some(content.drop(head.length).dropWhile(_ == '\n')) }.filter(_.nonEmpty))
        })/*84.11*/{ case (commitId, head, rest) =>_display_(Seq[Any](format.raw/*84.43*/("""
          """),format.raw/*85.11*/("""<div class="discussion-item discussion-item-commit">
            <div class="discussion-item-header">
              <span class="discussion-item-icon"><i class="octicon octicon-bookmark"></i></span>
              """),_display_(/*88.16*/helpers/*88.23*/.avatarLink(comment.commentedUserName, 16)),format.raw/*88.65*/("""
              """),_display_(/*89.16*/helpers/*89.23*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*89.85*/("""
              """),format.raw/*90.15*/("""added a commit that referenced this """),_display_(/*90.52*/issueOrPullRequest()),format.raw/*90.72*/("""
              """),_display_(/*91.16*/gitbucket/*91.25*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*91.78*/("""
            """),format.raw/*92.13*/("""</div>
            <div style="discussion-item-content">
              """),_display_(/*94.16*/commitId/*94.24*/.map/*94.28*/{ id =>_display_(Seq[Any](format.raw/*94.35*/("""
                """),format.raw/*95.17*/("""<span class="pull-right"><a href=""""),_display_(/*95.52*/context/*95.59*/.path),format.raw/*95.64*/("""/"""),_display_(/*95.66*/repository/*95.76*/.owner),format.raw/*95.82*/("""/"""),_display_(/*95.84*/repository/*95.94*/.name),format.raw/*95.99*/("""/commit/"""),_display_(/*95.108*/id),format.raw/*95.110*/("""" class="monospace">"""),_display_(/*95.131*/id/*95.133*/.substring(0, 7)),format.raw/*95.149*/("""</a></span>
              """)))}),format.raw/*96.16*/("""
              """),format.raw/*97.15*/("""<span class="discussion-item-content-head"><i class="octicon octicon-git-commit"></i></span>
              """),_display_(/*98.16*/helpers/*98.23*/.link(head, repository)),format.raw/*98.46*/("""
              """),_display_(/*99.16*/rest/*99.20*/.map/*99.24*/{ content =>_display_(Seq[Any](format.raw/*99.36*/("""
                """),format.raw/*100.17*/("""<a href="javascript:void(0)" class="omit" onclick="$(this.parentNode).find('.discussion-item-content-text').toggle()">...</a>
                <pre class="reset discussion-item-content-text" style="display:none">"""),_display_(/*101.87*/helpers/*101.94*/.link(content, repository)),format.raw/*101.120*/("""</pre>
              """)))}),format.raw/*102.16*/("""
            """),format.raw/*103.13*/("""</div>
          </div>
        """)))}),format.raw/*105.10*/("""
      """)))}/*107.7*/case "refer" =>/*107.22*/ {_display_(Seq[Any](format.raw/*107.24*/("""
        """),format.raw/*108.9*/("""<div class="discussion-item discussion-item-refer">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-bookmark"></i></span>
            """),_display_(/*111.14*/helpers/*111.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*111.63*/("""
            """),_display_(/*112.14*/helpers/*112.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*112.83*/("""
            """),format.raw/*113.13*/("""referenced the """),_display_(/*113.29*/issueOrPullRequest()),format.raw/*113.49*/("""
            """),_display_(/*114.14*/gitbucket/*114.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*114.76*/("""
          """),format.raw/*115.11*/("""</div>
          <div style="discussion-item-content">
            """),_display_(/*117.14*/defining(comment.content.split(":"))/*117.50*/{/*118.15*/case Array(issueId, rest @ _*) =>/*118.48*/ {_display_(_display_(/*118.51*/helpers/*118.58*/.issueLink(repository.owner, repository.name, issueId.toInt, rest.mkString(":"))))}}),format.raw/*119.14*/("""
          """),format.raw/*120.11*/("""</div>
        </div>
      """)))}/*123.7*/case "refer_global" =>/*123.29*/ {_display_(Seq[Any](format.raw/*123.31*/("""
        """),format.raw/*124.9*/("""<div class="discussion-item discussion-item-refer">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-bookmark"></i></span>
            """),_display_(/*127.14*/helpers/*127.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*127.63*/("""
            """),_display_(/*128.14*/helpers/*128.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*128.83*/("""
            """),format.raw/*129.13*/("""referenced the """),_display_(/*129.29*/issueOrPullRequest()),format.raw/*129.49*/("""
            """),_display_(/*130.14*/gitbucket/*130.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*130.76*/("""
          """),format.raw/*131.11*/("""</div>
          <div style="discussion-item-content">
          """),_display_(/*133.12*/defining(comment.content.split(":"))/*133.48*/{/*134.13*/case Array(issueId, ownerName, repositoryName, rest @ _*) =>/*134.73*/ {_display_(Seq[Any](format.raw/*134.75*/("""
              """),_display_(/*135.16*/helpers/*135.23*/.issueGlobalLink(ownerName, repositoryName, issueId.toInt, rest.mkString(":"))),format.raw/*135.101*/("""
          """)))}}),format.raw/*136.13*/("""
          """),format.raw/*137.11*/("""</div>
        </div>
      """)))}/*140.7*/case "merge" =>/*140.22*/ {_display_(Seq[Any](format.raw/*140.24*/("""
        """),_display_(/*141.10*/showFormattedComment(comment)),format.raw/*141.39*/("""
        """),format.raw/*142.9*/("""<div class="discussion-item discussion-item-merge">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-git-merge"></i></span>
            """),_display_(/*145.14*/helpers/*145.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*145.63*/("""
            """),_display_(/*146.14*/helpers/*146.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*146.83*/("""
            """),format.raw/*147.13*/("""merged commit
            <code>"""),_display_(/*148.20*/pullreq/*148.27*/.map(_.commitIdTo.substring(0, 7))),format.raw/*148.61*/("""</code> into
            """),_display_(if(pullreq.get.requestUserName == repository.owner)/*149.65*/{_display_(Seq[Any](format.raw/*149.66*/("""
              """),format.raw/*150.15*/("""<code>"""),_display_(/*150.22*/pullreq/*150.29*/.map(_.branch)),format.raw/*150.43*/("""</code> from <code>"""),_display_(/*150.63*/pullreq/*150.70*/.map(_.requestBranch)),format.raw/*150.91*/("""</code>
            """)))}else/*151.20*/{_display_(Seq[Any](format.raw/*151.21*/("""
              """),format.raw/*152.15*/("""<code>"""),_display_(/*152.22*/pullreq/*152.29*/.map(_.userName)),format.raw/*152.45*/(""":"""),_display_(/*152.47*/pullreq/*152.54*/.map(_.branch)),format.raw/*152.68*/("""</code> from <code>"""),_display_(/*152.88*/pullreq/*152.95*/.map(_.requestUserName)),format.raw/*152.118*/(""":"""),_display_(/*152.120*/pullreq/*152.127*/.map(_.requestBranch)),format.raw/*152.148*/("""</code>
            """)))}),format.raw/*153.14*/("""
            """),_display_(/*154.14*/gitbucket/*154.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*154.76*/("""
          """),format.raw/*155.11*/("""</div>
        </div>
      """)))}/*158.7*/case "close" | "close_comment" =>/*158.40*/ {_display_(Seq[Any](format.raw/*158.42*/("""
        """),_display_(if(comment.action == "close_comment")/*159.47*/{_display_(Seq[Any](format.raw/*159.48*/("""
          """),_display_(/*160.12*/showFormattedComment(comment)),format.raw/*160.41*/("""
        """)))} else {null} ),format.raw/*161.10*/("""
        """),format.raw/*162.9*/("""<div class="discussion-item discussion-item-close">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-circle-slash"></i></span>
            """),_display_(/*165.14*/helpers/*165.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*165.63*/("""
            """),_display_(/*166.14*/helpers/*166.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*166.83*/("""
            """),format.raw/*167.13*/("""closed this """),_display_(/*167.26*/issueOrPullRequest()),format.raw/*167.46*/("""
            """),_display_(/*168.14*/gitbucket/*168.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*168.76*/("""
          """),format.raw/*169.11*/("""</div>
        </div>
      """)))}/*172.7*/case "reopen" | "reopen_comment" =>/*172.42*/ {_display_(Seq[Any](format.raw/*172.44*/("""
        """),_display_(if(comment.action == "reopen_comment")/*173.48*/{_display_(Seq[Any](format.raw/*173.49*/("""
          """),_display_(/*174.12*/showFormattedComment(comment)),format.raw/*174.41*/("""
        """)))} else {null} ),format.raw/*175.10*/("""
        """),format.raw/*176.9*/("""<div class="discussion-item discussion-item-reopen">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-primitive-dot"></i></span>
            """),_display_(/*179.14*/helpers/*179.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*179.63*/("""
            """),_display_(/*180.14*/helpers/*180.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*180.83*/("""
            """),format.raw/*181.13*/("""reopened the """),_display_(/*181.27*/issueOrPullRequest()),format.raw/*181.47*/("""
            """),_display_(/*182.14*/gitbucket/*182.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*182.76*/("""
          """),format.raw/*183.11*/("""</div>
        </div>
      """)))}/*186.7*/case "delete_branch" =>/*186.30*/ {_display_(Seq[Any](format.raw/*186.32*/("""
        """),format.raw/*187.9*/("""<div class="discussion-item discussion-item-delete_branch">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-git-branch"></i></span>
            """),_display_(/*190.14*/helpers/*190.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*190.63*/("""
            """),_display_(/*191.14*/helpers/*191.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*191.83*/("""
            """),format.raw/*192.13*/("""deleted the <code>"""),_display_(/*192.32*/pullreq/*192.39*/.map(_.requestBranch)),format.raw/*192.60*/("""</code> branch
            """),_display_(/*193.14*/gitbucket/*193.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*193.76*/("""
          """),format.raw/*194.11*/("""</div>
        </div>
      """)))}/*197.7*/case "add_label" =>/*197.26*/ {_display_(Seq[Any](format.raw/*197.28*/("""
        """),format.raw/*198.9*/("""<div class="discussion-item discussion-item-add-label">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-tag"></i></span>
            """),_display_(/*201.14*/helpers/*201.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*201.63*/("""
            """),_display_(/*202.14*/helpers/*202.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*202.83*/("""
            """),format.raw/*203.13*/("""added the <code>"""),_display_(/*203.30*/comment/*203.37*/.content),format.raw/*203.45*/("""</code> label
            """),_display_(/*204.14*/gitbucket/*204.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*204.76*/("""
          """),format.raw/*205.11*/("""</div>
        </div>
      """)))}/*208.7*/case "delete_label" =>/*208.29*/ {_display_(Seq[Any](format.raw/*208.31*/("""
        """),format.raw/*209.9*/("""<div class="discussion-item discussion-item-delete-label">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-tag"></i></span>
            """),_display_(/*212.14*/helpers/*212.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*212.63*/("""
            """),_display_(/*213.14*/helpers/*213.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*213.83*/("""
            """),format.raw/*214.13*/("""removed the <code>"""),_display_(/*214.32*/comment/*214.39*/.content),format.raw/*214.47*/("""</code> label
            """),_display_(/*215.14*/gitbucket/*215.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*215.76*/("""
          """),format.raw/*216.11*/("""</div>
        </div>
      """)))}/*219.7*/case "change_priority" =>/*219.32*/ {_display_(Seq[Any](format.raw/*219.34*/("""
        """),format.raw/*220.9*/("""<div class="discussion-item discussion-item-change-priority">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-flame"></i></span>
            """),_display_(/*223.14*/helpers/*223.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*223.63*/("""
            """),_display_(/*224.14*/helpers/*224.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*224.83*/("""
            """),format.raw/*225.13*/("""changed priority from <code>"""),_display_(/*225.42*/comment/*225.49*/.content.split(":")/*225.68*/(0)),format.raw/*225.71*/("""</code> to <code>"""),_display_(/*225.89*/comment/*225.96*/.content.split(":")/*225.115*/(1)),format.raw/*225.118*/("""</code>
            """),_display_(/*226.14*/gitbucket/*226.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*226.76*/("""
          """),format.raw/*227.11*/("""</div>
        </div>
      """)))}/*230.7*/case "change_milestone" =>/*230.33*/ {_display_(Seq[Any](format.raw/*230.35*/("""
        """),format.raw/*231.9*/("""<div class="discussion-item discussion-item-change-milestone">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-milestone"></i></span>
            """),_display_(/*234.14*/helpers/*234.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*234.63*/("""
            """),_display_(/*235.14*/helpers/*235.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*235.83*/("""
            """),format.raw/*236.13*/("""changed milestone from <code>"""),_display_(/*236.43*/comment/*236.50*/.content.split(":")/*236.69*/(0)),format.raw/*236.72*/("""</code> to <code>"""),_display_(/*236.90*/comment/*236.97*/.content.split(":")/*236.116*/(1)),format.raw/*236.119*/("""</code>
            """),_display_(/*237.14*/gitbucket/*237.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*237.76*/("""
          """),format.raw/*238.11*/("""</div>
        </div>
      """)))}/*241.7*/case "assign" =>/*241.23*/ {_display_(Seq[Any](format.raw/*241.25*/(""" """),format.raw/*241.58*/("""
        """),format.raw/*242.9*/("""<div class="discussion-item discussion-item-assign">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-person"></i></span>
            """),_display_(/*245.14*/helpers/*245.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*245.63*/("""
            """),_display_(/*246.14*/helpers/*246.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*246.83*/("""
            """),format.raw/*247.13*/("""changed assignee from <code>"""),_display_(/*247.42*/comment/*247.49*/.content.split(":")/*247.68*/(0)),format.raw/*247.71*/("""</code> to <code>"""),_display_(/*247.89*/comment/*247.96*/.content.split(":")/*247.115*/(1)),format.raw/*247.118*/("""</code>
            """),_display_(/*248.14*/gitbucket/*248.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*248.76*/("""
          """),format.raw/*249.11*/("""</div>
        </div>
      """)))}/*252.7*/case "add_assignee" =>/*252.29*/ {_display_(Seq[Any](format.raw/*252.31*/("""
        """),format.raw/*253.9*/("""<div class="discussion-item discussion-item-assign">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-person"></i></span>
            """),_display_(/*256.14*/helpers/*256.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*256.63*/("""
            """),_display_(/*257.14*/helpers/*257.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*257.83*/("""
            """),format.raw/*258.13*/("""assigned <code>"""),_display_(/*258.29*/comment/*258.36*/.content),format.raw/*258.44*/("""</code>
            """),_display_(/*259.14*/gitbucket/*259.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*259.76*/("""
          """),format.raw/*260.11*/("""</div>
        </div>
      """)))}/*263.7*/case "delete_assignee" =>/*263.32*/ {_display_(Seq[Any](format.raw/*263.34*/("""
        """),format.raw/*264.9*/("""<div class="discussion-item discussion-item-assign">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-person"></i></span>
            """),_display_(/*267.14*/helpers/*267.21*/.avatarLink(comment.commentedUserName, 16)),format.raw/*267.63*/("""
            """),_display_(/*268.14*/helpers/*268.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*268.83*/("""
            """),format.raw/*269.13*/("""unassigned <code>"""),_display_(/*269.31*/comment/*269.38*/.content),format.raw/*269.46*/("""</code></code>
            """),_display_(/*270.14*/gitbucket/*270.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*270.76*/("""
          """),format.raw/*271.11*/("""</div>
        </div>
      """)))}/*274.7*/case "change_title" =>/*274.29*/ {_display_(Seq[Any](format.raw/*274.31*/("""
        """),format.raw/*275.9*/("""<div class="discussion-item discussion-item-pencil">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-pencil"></i></span>
            """),_display_(/*278.14*/helpers/*278.21*/.avatar(comment.commentedUserName, 16)),format.raw/*278.59*/("""
            """),_display_(/*279.14*/helpers/*279.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*279.83*/("""
            """),format.raw/*280.13*/("""changed title from <code>"""),_display_(/*280.39*/convertLineSeparator(comment.content, "LF")/*280.82*/.split("\n")/*280.94*/(0)),format.raw/*280.97*/("""</code> to <code>"""),_display_(/*280.115*/convertLineSeparator(comment.content, "LF")/*280.158*/.split("\n")/*280.170*/(1)),format.raw/*280.173*/("""</code>
            """),_display_(/*281.14*/gitbucket/*281.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*281.76*/("""
          """),format.raw/*282.11*/("""</div>
        </div>
      """)))}/*285.7*/case "change_base_branch" =>/*285.35*/ {_display_(Seq[Any](format.raw/*285.37*/("""
        """),format.raw/*286.9*/("""<div class="discussion-item discussion-item-pencil">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-pencil"></i></span>
            """),_display_(/*289.14*/helpers/*289.21*/.avatar(comment.commentedUserName, 16)),format.raw/*289.59*/("""
            """),_display_(/*290.14*/helpers/*290.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*290.83*/("""
            """),format.raw/*291.13*/("""changed base branch from <code>"""),_display_(/*291.45*/convertLineSeparator(comment.content, "LF")/*291.88*/.split("\n")/*291.100*/(0)),format.raw/*291.103*/("""</code> to <code>"""),_display_(/*291.121*/convertLineSeparator(comment.content, "LF")/*291.164*/.split("\n")/*291.176*/(1)),format.raw/*291.179*/("""</code>
            """),_display_(/*292.14*/gitbucket/*292.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*292.76*/("""
          """),format.raw/*293.11*/("""</div>
        </div>
      """)))}/*296.7*/case "delete_comment" =>/*296.31*/ {_display_(Seq[Any](format.raw/*296.33*/("""
        """),format.raw/*297.9*/("""<div class="discussion-item discussion-item-delete-comment">
          <div class="discussion-item-header">
            <span class="discussion-item-icon"><i class="octicon octicon-trashcan"></i></span>
            """),_display_(/*300.14*/helpers/*300.21*/.avatar(comment.commentedUserName, 16)),format.raw/*300.59*/("""
            """),_display_(/*301.14*/helpers/*301.21*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*301.83*/("""
            """),format.raw/*302.13*/("""deleted the comment
            """),_display_(/*303.14*/gitbucket/*303.23*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*303.76*/("""
          """),format.raw/*304.11*/("""</div>
        </div>
      """)))}/*307.7*/case _ =>/*307.16*/ {_display_(Seq[Any](format.raw/*307.18*/("""
        """),_display_(/*308.10*/showFormattedComment(comment)),format.raw/*308.39*/("""
      """)))}}),format.raw/*310.6*/("""
  """)))}/*312.3*/case comments: gitbucket.core.model.CommitComments =>/*312.56*/ {_display_(Seq[Any](format.raw/*312.58*/("""
    """),_display_(/*313.6*/gitbucket/*313.15*/.core.helper.html.commitcomments(comments, isManageable, repository, commitId.orElse(pullreq.map(_.commitIdTo)))),format.raw/*313.127*/("""
  """)))}/*315.3*/case comment: gitbucket.core.model.CommitComment =>/*315.54*/ {_display_(Seq[Any](format.raw/*315.56*/("""
    """),format.raw/*316.5*/("""<div class="panel panel-default commit-comment-box commit-comment-"""),_display_(/*316.72*/comment/*316.79*/.commentId),format.raw/*316.89*/("""">
      <div class="panel-heading">
        """),_display_(/*318.10*/helpers/*318.17*/.avatarLink(comment.commentedUserName, 20)),format.raw/*318.59*/("""
        """),_display_(/*319.10*/helpers/*319.17*/.user(comment.commentedUserName, styleClass="username strong")),format.raw/*319.79*/("""
        """),format.raw/*320.9*/("""<span class="muted">
          commented
          <a href="#comment-"""),_display_(/*322.30*/comment/*322.37*/.commentId),format.raw/*322.47*/("""">"""),_display_(/*322.50*/gitbucket/*322.59*/.core.helper.html.datetimeago(comment.registeredDate)),format.raw/*322.112*/("""</a>
          on
          <a href=""""),_display_(/*324.21*/helpers/*324.28*/.url(repository)),format.raw/*324.44*/("""/commit/"""),_display_(/*324.53*/comment/*324.60*/.commitId),format.raw/*324.69*/("""" class="monospace">"""),_display_(/*324.90*/comment/*324.97*/.commitId.substring(0, 7)),format.raw/*324.122*/("""</a>
        </span>
        """),_display_(if((isManageable || context.loginAccount.map(_.userName == comment.commentedUserName).getOrElse(false)))/*326.114*/{_display_(Seq[Any](format.raw/*326.115*/("""
          """),format.raw/*327.11*/("""<span class="pull-right">
            <a href="#" data-comment-id=""""),_display_(/*328.43*/comment/*328.50*/.commentId),format.raw/*328.60*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>&nbsp;
            <a href="#" data-comment-id=""""),_display_(/*329.43*/comment/*329.50*/.commentId),format.raw/*329.60*/(""""><i class="octicon octicon-x" aria-label="Remove"></i></a>
          </span>
        """)))} else {null} ),format.raw/*331.10*/("""
      """),format.raw/*332.7*/("""</div>
      <div class="panel-body markdown-body commit-commentContent-"""),_display_(/*333.67*/comment/*333.74*/.commentId),format.raw/*333.84*/("""">
        """),_display_(/*334.10*/helpers/*334.17*/.markdown(
          markdown           = comment.content,
          repository         = repository,
          branch             = repository.repository.defaultBranch,
          enableWikiLink     = false,
          enableRefsLink     = true,
          enableLineBreaks   = true,
          enableTaskList     = true,
          hasWritePermission = isManageable
        )),format.raw/*343.10*/("""
      """),format.raw/*344.7*/("""</div>
    </div>
  """)))}}),format.raw/*347.2*/("""
"""),_display_(if(renderScript)/*348.18*/{_display_(Seq[Any](format.raw/*348.19*/("""
"""),format.raw/*349.1*/("""<script>
$(function()"""),format.raw/*350.13*/("""{"""),format.raw/*350.14*/("""
"""),_display_(if(issue.isDefined)/*351.21*/{_display_(Seq[Any](format.raw/*351.22*/("""
  """),format.raw/*352.3*/("""$('.issue-comment-box i.octicon-pencil').click(function()"""),format.raw/*352.60*/("""{"""),format.raw/*352.61*/("""
    """),format.raw/*353.5*/("""let id  = $(this).closest('a').data('comment-id');
    let url = '"""),_display_(/*354.17*/helpers/*354.24*/.url(repository)),format.raw/*354.40*/("""/issue_comments/_data/' + id;
    let $content = $('#commentContent-' + id);

    if(!id)"""),format.raw/*357.12*/("""{"""),format.raw/*357.13*/("""
      """),format.raw/*358.7*/("""id  = $(this).closest('a').data('issue-id');
      url = '"""),_display_(/*359.15*/helpers/*359.22*/.url(repository)),format.raw/*359.38*/("""/issues/_data/' + id;
      $content = $('#issueContent');
    """),format.raw/*361.5*/("""}"""),format.raw/*361.6*/("""

    """),format.raw/*363.5*/("""$.get(url, """),format.raw/*363.16*/("""{"""),format.raw/*363.17*/(""" """),format.raw/*363.18*/("""dataType : 'html' """),format.raw/*363.36*/("""}"""),format.raw/*363.37*/(""", function(data)"""),format.raw/*363.53*/("""{"""),format.raw/*363.54*/("""
      """),format.raw/*364.7*/("""$content.empty().html(data);
    """),format.raw/*365.5*/("""}"""),format.raw/*365.6*/(""");
    return false;
  """),format.raw/*367.3*/("""}"""),format.raw/*367.4*/(""");
  $('.issue-comment-box i.octicon-x').click(function()"""),format.raw/*368.55*/("""{"""),format.raw/*368.56*/("""
    """),format.raw/*369.5*/("""if(confirm('Are you sure you want to delete this?')) """),format.raw/*369.58*/("""{"""),format.raw/*369.59*/("""
      """),format.raw/*370.7*/("""const id = $(this).closest('a').data('comment-id');
      $.post('"""),_display_(/*371.16*/helpers/*371.23*/.url(repository)),format.raw/*371.39*/("""/issue_comments/delete/' + id, function(data)"""),format.raw/*371.84*/("""{"""),format.raw/*371.85*/("""
        """),format.raw/*372.9*/("""if(data > 0) """),format.raw/*372.22*/("""{"""),format.raw/*372.23*/("""
          """),format.raw/*373.11*/("""$('#comment-' + id).remove();
        """),format.raw/*374.9*/("""}"""),format.raw/*374.10*/("""
      """),format.raw/*375.7*/("""}"""),format.raw/*375.8*/(""");
    """),format.raw/*376.5*/("""}"""),format.raw/*376.6*/("""
    """),format.raw/*377.5*/("""return false;
  """),format.raw/*378.3*/("""}"""),format.raw/*378.4*/(""");
""")))} else {null} ),format.raw/*379.2*/("""
  """),format.raw/*380.3*/("""$(document).on('click', '.commit-comment-box i.octicon-pencil', function()"""),format.raw/*380.77*/("""{"""),format.raw/*380.78*/("""
    """),format.raw/*381.5*/("""const id  = $(this).closest('a').data('comment-id');
    const url = '"""),_display_(/*382.19*/helpers/*382.26*/.url(repository)),format.raw/*382.42*/("""/commit_comments/_data/' + id;
    const $content = $('.commit-commentContent-' + id, $(this).closest('.commit-comment-box'));

    $.get(url, """),format.raw/*385.16*/("""{"""),format.raw/*385.17*/(""" """),format.raw/*385.18*/("""dataType : 'html' """),format.raw/*385.36*/("""}"""),format.raw/*385.37*/(""", function(data)"""),format.raw/*385.53*/("""{"""),format.raw/*385.54*/("""
      """),format.raw/*386.7*/("""$content.empty().html(data);
    """),format.raw/*387.5*/("""}"""),format.raw/*387.6*/(""");

    return false;
  """),format.raw/*390.3*/("""}"""),format.raw/*390.4*/(""");

  $(document).on('click', '.commit-comment-box i.octicon-x', function()"""),format.raw/*392.72*/("""{"""),format.raw/*392.73*/("""
    """),format.raw/*393.5*/("""if(confirm('Are you sure you want to delete this?')) """),format.raw/*393.58*/("""{"""),format.raw/*393.59*/("""
      """),format.raw/*394.7*/("""const id = $(this).closest('a').data('comment-id');
      $.post('"""),_display_(/*395.16*/helpers/*395.23*/.url(repository)),format.raw/*395.39*/("""/commit_comments/delete/' + id,
      function(data)"""),format.raw/*396.21*/("""{"""),format.raw/*396.22*/("""
        """),format.raw/*397.9*/("""if(data > 0) """),format.raw/*397.22*/("""{"""),format.raw/*397.23*/("""
          """),format.raw/*398.11*/("""const comment = $('.commit-comment-' + id);

          // diff view
          const tr = comment.closest('.not-diff');
          if(tr.length > 0)"""),format.raw/*402.28*/("""{"""),format.raw/*402.29*/("""
            """),format.raw/*403.13*/("""if(tr.prev('.not-diff').length == 0)"""),format.raw/*403.49*/("""{"""),format.raw/*403.50*/("""
              """),format.raw/*404.15*/("""tr.next('.not-diff:has(.reply-comment)').remove();
            """),format.raw/*405.13*/("""}"""),format.raw/*405.14*/("""
            """),format.raw/*406.13*/("""tr.remove();
          """),format.raw/*407.11*/("""}"""),format.raw/*407.12*/("""

          """),format.raw/*409.11*/("""// comment list view
          const panel = comment.closest('div.panel:has(.commit-comment-box)');
          if(panel.length > 0)"""),format.raw/*411.31*/("""{"""),format.raw/*411.32*/("""
            """),format.raw/*412.13*/("""comment.parent('.commit-comment-box').remove();
            if(panel.has('.commit-comment-box').length == 0)"""),format.raw/*413.61*/("""{"""),format.raw/*413.62*/("""
              """),format.raw/*414.15*/("""panel.remove();
            """),format.raw/*415.13*/("""}"""),format.raw/*415.14*/("""
          """),format.raw/*416.11*/("""}"""),format.raw/*416.12*/(""" """),format.raw/*416.13*/("""else """),format.raw/*416.18*/("""{"""),format.raw/*416.19*/("""
            """),format.raw/*417.13*/("""comment.remove();
          """),format.raw/*418.11*/("""}"""),format.raw/*418.12*/("""
        """),format.raw/*419.9*/("""}"""),format.raw/*419.10*/("""
      """),format.raw/*420.7*/("""}"""),format.raw/*420.8*/(""");
    """),format.raw/*421.5*/("""}"""),format.raw/*421.6*/("""
    """),format.raw/*422.5*/("""return false;
  """),format.raw/*423.3*/("""}"""),format.raw/*423.4*/(""");

  $('div[class*=commit-commentContent-]').on('click', ':checkbox', function(ev)"""),format.raw/*425.80*/("""{"""),format.raw/*425.81*/("""
    """),format.raw/*426.5*/("""const $commentContent = $(ev.target).parents('div[class*=commit-commentContent-]'),
        commentId = $commentContent.attr('class').match(/commit-commentContent-.+/)[0].replace(/commit-commentContent-/, ''),
        checkboxes = $commentContent.find(':checkbox');
    $.get('"""),_display_(/*429.13*/helpers/*429.20*/.url(repository)),format.raw/*429.36*/("""/commit_comments/_data/' + commentId, """),format.raw/*429.74*/("""{"""),format.raw/*429.75*/(""" """),format.raw/*429.76*/("""dataType : 'html' """),format.raw/*429.94*/("""}"""),format.raw/*429.95*/(""",
      function(responseContent)"""),format.raw/*430.32*/("""{"""),format.raw/*430.33*/("""
        """),format.raw/*431.9*/("""$.ajax("""),format.raw/*431.16*/("""{"""),format.raw/*431.17*/("""
          """),format.raw/*432.11*/("""url: '"""),_display_(/*432.18*/helpers/*432.25*/.url(repository)),format.raw/*432.41*/("""/commit_comments/edit/' + commentId,
          type: 'POST',
          data: """),format.raw/*434.17*/("""{"""),format.raw/*434.18*/("""
            """),format.raw/*435.13*/("""issueId : 0,
            content : applyTaskListCheckedStatus(responseContent, checkboxes)
          """),format.raw/*437.11*/("""}"""),format.raw/*437.12*/(""",
          success: function(data) """),format.raw/*438.35*/("""{"""),format.raw/*438.36*/("""
            """),format.raw/*439.13*/("""$('.commit-commentContent-' + commentId).html(data.content);
          """),format.raw/*440.11*/("""}"""),format.raw/*440.12*/("""
        """),format.raw/*441.9*/("""}"""),format.raw/*441.10*/(""");
      """),format.raw/*442.7*/("""}"""),format.raw/*442.8*/("""
    """),format.raw/*443.5*/(""");
  """),format.raw/*444.3*/("""}"""),format.raw/*444.4*/(""");

"""),_display_(if(issue.isDefined)/*446.21*/{_display_(Seq[Any](format.raw/*446.22*/("""
  """),format.raw/*447.3*/("""$('#issueContent').on('click', ':checkbox', function(ev)"""),format.raw/*447.59*/("""{"""),format.raw/*447.60*/("""
    """),format.raw/*448.5*/("""const checkboxes = $('#issueContent :checkbox');
    $.get('"""),_display_(/*449.13*/helpers/*449.20*/.url(repository)),format.raw/*449.36*/("""/issues/_data/"""),_display_(/*449.51*/issue/*449.56*/.get.issueId),format.raw/*449.68*/("""', """),format.raw/*449.71*/("""{"""),format.raw/*449.72*/(""" """),format.raw/*449.73*/("""dataType : 'html' """),format.raw/*449.91*/("""}"""),format.raw/*449.92*/(""",
      function(responseContent)"""),format.raw/*450.32*/("""{"""),format.raw/*450.33*/("""
        """),format.raw/*451.9*/("""$.ajax("""),format.raw/*451.16*/("""{"""),format.raw/*451.17*/("""
          """),format.raw/*452.11*/("""url: '"""),_display_(/*452.18*/helpers/*452.25*/.url(repository)),format.raw/*452.41*/("""/issues/edit/"""),_display_(/*452.55*/issue/*452.60*/.get.issueId),format.raw/*452.72*/("""',
          type: 'POST',
          data: """),format.raw/*454.17*/("""{"""),format.raw/*454.18*/("""
            """),format.raw/*455.13*/("""title   : $('#issueTitle').text(),
            content : applyTaskListCheckedStatus(responseContent, checkboxes)
          """),format.raw/*457.11*/("""}"""),format.raw/*457.12*/("""
        """),format.raw/*458.9*/("""}"""),format.raw/*458.10*/(""");
      """),format.raw/*459.7*/("""}"""),format.raw/*459.8*/("""
    """),format.raw/*460.5*/(""");
  """),format.raw/*461.3*/("""}"""),format.raw/*461.4*/(""");

  $('div[id^=commentContent-]').on('click', ':checkbox', function(ev)"""),format.raw/*463.70*/("""{"""),format.raw/*463.71*/("""
    """),format.raw/*464.5*/("""const $commentContent = $(ev.target).parents('div[id^=commentContent-]'),
        commentId = $commentContent.attr('id').replace(/commentContent-/, ''),
        checkboxes = $commentContent.find(':checkbox');
    $.get('"""),_display_(/*467.13*/helpers/*467.20*/.url(repository)),format.raw/*467.36*/("""/issue_comments/_data/' + commentId, """),format.raw/*467.73*/("""{"""),format.raw/*467.74*/(""" """),format.raw/*467.75*/("""dataType : 'html' """),format.raw/*467.93*/("""}"""),format.raw/*467.94*/(""",
      function(responseContent)"""),format.raw/*468.32*/("""{"""),format.raw/*468.33*/("""
        """),format.raw/*469.9*/("""$.ajax("""),format.raw/*469.16*/("""{"""),format.raw/*469.17*/("""
          """),format.raw/*470.11*/("""url: '"""),_display_(/*470.18*/helpers/*470.25*/.url(repository)),format.raw/*470.41*/("""/issue_comments/edit/' + commentId,
          type: 'POST',
          data: """),format.raw/*472.17*/("""{"""),format.raw/*472.18*/("""
            """),format.raw/*473.13*/("""issueId : 0,
            content : applyTaskListCheckedStatus(responseContent, checkboxes)
          """),format.raw/*475.11*/("""}"""),format.raw/*475.12*/("""
        """),format.raw/*476.9*/("""}"""),format.raw/*476.10*/(""");
      """),format.raw/*477.7*/("""}"""),format.raw/*477.8*/("""
    """),format.raw/*478.5*/(""");
  """),format.raw/*479.3*/("""}"""),format.raw/*479.4*/(""");
""")))} else {null} ),format.raw/*480.2*/("""
"""),format.raw/*481.1*/("""}"""),format.raw/*481.2*/(""");
</script>
""")))} else {null} ),format.raw/*483.2*/("""
"""))
      }
    }
  }

  def render(issue:Option[gitbucket.core.model.Issue],comments:List[gitbucket.core.model.Comment],isManageable:Boolean,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pullreq:Option[gitbucket.core.model.PullRequest],commitId:Option[String],renderScript:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(issue,comments,isManageable,repository,pullreq,commitId,renderScript)(context)

  def f:((Option[gitbucket.core.model.Issue],List[gitbucket.core.model.Comment],Boolean,gitbucket.core.service.RepositoryService.RepositoryInfo,Option[gitbucket.core.model.PullRequest],Option[String],Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (issue,comments,isManageable,repository,pullreq,commitId,renderScript) => (context) => apply(issue,comments,isManageable,repository,pullreq,commitId,renderScript)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/commentlist.scala.html
                  HASH: c2355b0740c8f9b79ff5ed7aa665c55466f3a75c
                  MATRIX: 813->1|1253->370|1295->406|1348->447|1375->465|1458->469|1520->504|1551->526|1583->537|1608->541|1637->561|1762->607|1790->608|1881->672|1897->679|1928->689|1992->727|2008->734|2071->776|2103->782|2119->789|2202->851|2234->856|2320->915|2359->916|2395->925|2435->948|2474->949|2510->958|2553->974|2594->994|2632->1002|2666->1009|2712->1028|2728->1035|2759->1045|2798->1057|2816->1066|2890->1119|2924->1126|3170->1344|3210->1345|3244->1352|3335->1416|3351->1423|3382->1433|3516->1540|3532->1547|3563->1557|3685->1636|3715->1639|3809->1706|3825->1713|3856->1723|3890->1731|3906->1738|4262->2074|4292->2077|4347->539|4375->2092|4423->2113|4462->2114|4492->2117|4609->2208|4625->2215|4687->2256|4721->2264|4737->2271|4819->2332|4853->2339|4911->2370|4929->2379|5006->2434|5184->2584|5224->2585|5263->2596|5318->2624|5332->2629|5365->2641|5481->2713|5515->2720|5628->2807|5644->2814|6057->3207|6089->3212|6149->3229|6177->3231|6194->3239|6207->3243|6217->3248|6276->3298|6316->3300|6348->3306|6364->3313|6380->3320|6395->3326|6405->3335|6430->3351|6470->3353|6507->3363|6918->3765|6988->3797|7027->3808|7268->4022|7284->4029|7347->4071|7390->4087|7406->4094|7489->4156|7532->4171|7596->4208|7637->4228|7680->4244|7698->4253|7772->4306|7813->4319|7912->4391|7929->4399|7942->4403|7987->4410|8032->4427|8094->4462|8110->4469|8136->4474|8165->4476|8184->4486|8211->4492|8240->4494|8259->4504|8285->4509|8322->4518|8346->4520|8395->4541|8407->4543|8445->4559|8503->4586|8546->4601|8681->4709|8697->4716|8741->4739|8784->4755|8797->4759|8810->4763|8860->4775|8906->4792|9146->5004|9163->5011|9212->5037|9266->5059|9308->5072|9373->5105|9400->5120|9425->5135|9466->5137|9503->5146|9738->5353|9755->5360|9819->5402|9861->5416|9878->5423|9962->5485|10004->5498|10048->5514|10090->5534|10132->5548|10151->5557|10226->5610|10266->5621|10362->5689|10408->5725|10419->5741|10462->5774|10494->5777|10511->5784|10617->5879|10657->5890|10705->5926|10737->5948|10778->5950|10815->5959|11050->6166|11067->6173|11131->6215|11173->6229|11190->6236|11274->6298|11316->6311|11360->6327|11402->6347|11444->6361|11463->6370|11538->6423|11578->6434|11672->6500|11718->6536|11729->6550|11799->6610|11840->6612|11884->6628|11901->6635|12002->6713|12047->6726|12087->6737|12135->6773|12160->6788|12201->6790|12239->6800|12290->6829|12327->6838|12563->7046|12580->7053|12644->7095|12686->7109|12703->7116|12787->7178|12829->7191|12890->7224|12907->7231|12963->7265|13068->7342|13108->7343|13152->7358|13187->7365|13204->7372|13240->7386|13288->7406|13305->7413|13348->7434|13393->7461|13433->7462|13477->7477|13512->7484|13529->7491|13567->7507|13597->7509|13614->7516|13650->7530|13698->7550|13715->7557|13761->7580|13792->7582|13810->7589|13854->7610|13907->7631|13949->7645|13968->7654|14043->7707|14083->7718|14131->7754|14174->7787|14215->7789|14290->7836|14330->7837|14370->7849|14421->7878|14476->7888|14513->7897|14752->8108|14769->8115|14833->8157|14875->8171|14892->8178|14976->8240|15018->8253|15059->8266|15101->8286|15143->8300|15162->8309|15237->8362|15277->8373|15325->8409|15370->8444|15411->8446|15487->8494|15527->8495|15567->8507|15618->8536|15673->8546|15710->8555|15951->8768|15968->8775|16032->8817|16074->8831|16091->8838|16175->8900|16217->8913|16259->8927|16301->8947|16343->8961|16362->8970|16437->9023|16477->9034|16525->9070|16558->9093|16599->9095|16636->9104|16881->9321|16898->9328|16962->9370|17004->9384|17021->9391|17105->9453|17147->9466|17194->9485|17211->9492|17254->9513|17310->9541|17329->9550|17404->9603|17444->9614|17492->9650|17521->9669|17562->9671|17599->9680|17833->9886|17850->9893|17914->9935|17956->9949|17973->9956|18057->10018|18099->10031|18144->10048|18161->10055|18191->10063|18246->10090|18265->10099|18340->10152|18380->10163|18428->10199|18460->10221|18501->10223|18538->10232|18775->10441|18792->10448|18856->10490|18898->10504|18915->10511|18999->10573|19041->10586|19088->10605|19105->10612|19135->10620|19190->10647|19209->10656|19284->10709|19324->10720|19372->10756|19407->10781|19448->10783|19485->10792|19727->11006|19744->11013|19808->11055|19850->11069|19867->11076|19951->11138|19993->11151|20050->11180|20067->11187|20096->11206|20121->11209|20167->11227|20184->11234|20214->11253|20240->11256|20289->11277|20308->11286|20383->11339|20423->11350|20471->11386|20507->11412|20548->11414|20585->11423|20832->11642|20849->11649|20913->11691|20955->11705|20972->11712|21056->11774|21098->11787|21156->11817|21173->11824|21202->11843|21227->11846|21273->11864|21290->11871|21320->11890|21346->11893|21395->11914|21414->11923|21489->11976|21529->11987|21577->12023|21603->12039|21644->12041|21674->12074|21711->12083|21945->12289|21962->12296|22026->12338|22068->12352|22085->12359|22169->12421|22211->12434|22268->12463|22285->12470|22314->12489|22339->12492|22385->12510|22402->12517|22432->12536|22458->12539|22507->12560|22526->12569|22601->12622|22641->12633|22689->12669|22721->12691|22762->12693|22799->12702|23033->12908|23050->12915|23114->12957|23156->12971|23173->12978|23257->13040|23299->13053|23343->13069|23360->13076|23390->13084|23439->13105|23458->13114|23533->13167|23573->13178|23621->13214|23656->13239|23697->13241|23734->13250|23968->13456|23985->13463|24049->13505|24091->13519|24108->13526|24192->13588|24234->13601|24280->13619|24297->13626|24327->13634|24383->13662|24402->13671|24477->13724|24517->13735|24565->13771|24597->13793|24638->13795|24675->13804|24909->14010|24926->14017|24986->14055|25028->14069|25045->14076|25129->14138|25171->14151|25225->14177|25278->14220|25300->14232|25325->14235|25372->14253|25426->14296|25449->14308|25475->14311|25524->14332|25543->14341|25618->14394|25658->14405|25706->14441|25744->14469|25785->14471|25822->14480|26056->14686|26073->14693|26133->14731|26175->14745|26192->14752|26276->14814|26318->14827|26378->14859|26431->14902|26454->14914|26480->14917|26527->14935|26581->14978|26604->14990|26630->14993|26679->15014|26698->15023|26773->15076|26813->15087|26861->15123|26895->15147|26936->15149|26973->15158|27217->15374|27234->15381|27294->15419|27336->15433|27353->15440|27437->15502|27479->15515|27540->15548|27559->15557|27634->15610|27674->15621|27722->15657|27741->15666|27782->15668|27820->15678|27871->15707|27911->15721|27934->15728|27997->15781|28038->15783|28071->15789|28090->15798|28225->15910|28248->15917|28309->15968|28350->15970|28383->15975|28478->16042|28495->16049|28527->16059|28601->16105|28618->16112|28682->16154|28720->16164|28737->16171|28821->16233|28858->16242|28956->16312|28973->16319|29005->16329|29036->16332|29055->16341|29131->16394|29197->16432|29214->16439|29252->16455|29289->16464|29306->16471|29337->16480|29386->16501|29403->16508|29451->16533|29614->16667|29655->16668|29695->16679|29791->16747|29808->16754|29840->16764|29979->16875|29996->16882|30028->16892|30160->16979|30195->16986|30296->17059|30313->17066|30345->17076|30385->17088|30402->17095|30796->17467|30831->17474|30884->17497|30930->17515|30970->17516|30999->17517|31049->17538|31079->17539|31128->17560|31168->17561|31199->17564|31285->17621|31315->17622|31348->17627|31443->17694|31460->17701|31498->17717|31616->17806|31646->17807|31681->17814|31768->17873|31785->17880|31823->17896|31914->17959|31943->17960|31977->17966|32017->17977|32047->17978|32077->17979|32124->17997|32154->17998|32199->18014|32229->18015|32264->18022|32325->18055|32354->18056|32405->18079|32434->18080|32520->18137|32550->18138|32583->18143|32665->18196|32695->18197|32730->18204|32825->18271|32842->18278|32880->18294|32954->18339|32984->18340|33021->18349|33063->18362|33093->18363|33133->18374|33199->18412|33229->18413|33264->18420|33293->18421|33328->18428|33357->18429|33390->18434|33434->18450|33463->18451|33511->18455|33542->18458|33645->18532|33675->18533|33708->18538|33807->18609|33824->18616|33862->18632|34034->18775|34064->18776|34094->18777|34141->18795|34171->18796|34216->18812|34246->18813|34281->18820|34342->18853|34371->18854|34423->18878|34452->18879|34556->18954|34586->18955|34619->18960|34701->19013|34731->19014|34766->19021|34861->19088|34878->19095|34916->19111|34997->19163|35027->19164|35064->19173|35106->19186|35136->19187|35176->19198|35351->19344|35381->19345|35423->19358|35488->19394|35518->19395|35562->19410|35654->19473|35684->19474|35726->19487|35778->19510|35808->19511|35849->19523|36008->19653|36038->19654|36080->19667|36217->19775|36247->19776|36291->19791|36348->19819|36378->19820|36418->19831|36448->19832|36478->19833|36512->19838|36542->19839|36584->19852|36641->19880|36671->19881|36708->19890|36738->19891|36773->19898|36802->19899|36837->19906|36866->19907|36899->19912|36943->19928|36972->19929|37084->20012|37114->20013|37147->20018|37453->20296|37470->20303|37508->20319|37575->20357|37605->20358|37635->20359|37682->20377|37712->20378|37774->20411|37804->20412|37841->20421|37877->20428|37907->20429|37947->20440|37982->20447|37999->20454|38037->20470|38143->20547|38173->20548|38215->20561|38345->20662|38375->20663|38440->20699|38470->20700|38512->20713|38612->20784|38642->20785|38679->20794|38709->20795|38746->20804|38775->20805|38808->20810|38841->20815|38870->20816|38922->20840|38962->20841|38993->20844|39078->20900|39108->20901|39141->20906|39230->20967|39247->20974|39285->20990|39328->21005|39343->21010|39377->21022|39409->21025|39439->21026|39469->21027|39516->21045|39546->21046|39608->21079|39638->21080|39675->21089|39711->21096|39741->21097|39781->21108|39816->21115|39833->21122|39871->21138|39913->21152|39928->21157|39962->21169|40034->21212|40064->21213|40106->21226|40258->21349|40288->21350|40325->21359|40355->21360|40392->21369|40421->21370|40454->21375|40487->21380|40516->21381|40618->21454|40648->21455|40681->21460|40930->21681|40947->21688|40985->21704|41051->21741|41081->21742|41111->21743|41158->21761|41188->21762|41250->21795|41280->21796|41317->21805|41353->21812|41383->21813|41423->21824|41458->21831|41475->21838|41513->21854|41618->21930|41648->21931|41690->21944|41820->22045|41850->22046|41887->22055|41917->22056|41954->22065|41983->22066|42016->22071|42049->22076|42078->22077|42126->22081|42155->22082|42184->22083|42242->22097
                  LINES: 14->1|23->8|24->9|26->10|26->10|28->10|28->10|28->10|28->10|28->11|28->11|30->11|31->12|31->12|31->12|31->12|33->14|33->14|33->14|34->15|34->15|34->15|35->16|36->17|36->17|37->18|38->19|38->19|39->20|39->20|39->20|40->21|41->22|41->22|41->22|41->22|42->23|42->23|42->23|43->24|46->27|46->27|47->28|48->29|48->29|48->29|49->30|49->30|49->30|51->32|52->33|53->34|53->34|53->34|54->35|54->35|63->44|64->45|67->10|68->47|69->48|69->48|70->49|72->51|72->51|72->51|73->52|73->52|73->52|74->53|74->53|74->53|74->53|76->55|76->55|77->56|77->56|77->56|77->56|78->57|79->58|82->61|82->61|91->70|92->71|94->73|95->74|95->74|95->74|95->75|95->75|95->75|96->76|96->76|96->76|96->76|96->77|96->77|96->77|97->78|103->84|103->84|104->85|107->88|107->88|107->88|108->89|108->89|108->89|109->90|109->90|109->90|110->91|110->91|110->91|111->92|113->94|113->94|113->94|113->94|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|114->95|115->96|116->97|117->98|117->98|117->98|118->99|118->99|118->99|118->99|119->100|120->101|120->101|120->101|121->102|122->103|124->105|125->107|125->107|125->107|126->108|129->111|129->111|129->111|130->112|130->112|130->112|131->113|131->113|131->113|132->114|132->114|132->114|133->115|135->117|135->117|135->118|135->118|135->118|135->118|135->119|136->120|138->123|138->123|138->123|139->124|142->127|142->127|142->127|143->128|143->128|143->128|144->129|144->129|144->129|145->130|145->130|145->130|146->131|148->133|148->133|148->134|148->134|148->134|149->135|149->135|149->135|150->136|151->137|153->140|153->140|153->140|154->141|154->141|155->142|158->145|158->145|158->145|159->146|159->146|159->146|160->147|161->148|161->148|161->148|162->149|162->149|163->150|163->150|163->150|163->150|163->150|163->150|163->150|164->151|164->151|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|165->152|166->153|167->154|167->154|167->154|168->155|170->158|170->158|170->158|171->159|171->159|172->160|172->160|173->161|174->162|177->165|177->165|177->165|178->166|178->166|178->166|179->167|179->167|179->167|180->168|180->168|180->168|181->169|183->172|183->172|183->172|184->173|184->173|185->174|185->174|186->175|187->176|190->179|190->179|190->179|191->180|191->180|191->180|192->181|192->181|192->181|193->182|193->182|193->182|194->183|196->186|196->186|196->186|197->187|200->190|200->190|200->190|201->191|201->191|201->191|202->192|202->192|202->192|202->192|203->193|203->193|203->193|204->194|206->197|206->197|206->197|207->198|210->201|210->201|210->201|211->202|211->202|211->202|212->203|212->203|212->203|212->203|213->204|213->204|213->204|214->205|216->208|216->208|216->208|217->209|220->212|220->212|220->212|221->213|221->213|221->213|222->214|222->214|222->214|222->214|223->215|223->215|223->215|224->216|226->219|226->219|226->219|227->220|230->223|230->223|230->223|231->224|231->224|231->224|232->225|232->225|232->225|232->225|232->225|232->225|232->225|232->225|232->225|233->226|233->226|233->226|234->227|236->230|236->230|236->230|237->231|240->234|240->234|240->234|241->235|241->235|241->235|242->236|242->236|242->236|242->236|242->236|242->236|242->236|242->236|242->236|243->237|243->237|243->237|244->238|246->241|246->241|246->241|246->241|247->242|250->245|250->245|250->245|251->246|251->246|251->246|252->247|252->247|252->247|252->247|252->247|252->247|252->247|252->247|252->247|253->248|253->248|253->248|254->249|256->252|256->252|256->252|257->253|260->256|260->256|260->256|261->257|261->257|261->257|262->258|262->258|262->258|262->258|263->259|263->259|263->259|264->260|266->263|266->263|266->263|267->264|270->267|270->267|270->267|271->268|271->268|271->268|272->269|272->269|272->269|272->269|273->270|273->270|273->270|274->271|276->274|276->274|276->274|277->275|280->278|280->278|280->278|281->279|281->279|281->279|282->280|282->280|282->280|282->280|282->280|282->280|282->280|282->280|282->280|283->281|283->281|283->281|284->282|286->285|286->285|286->285|287->286|290->289|290->289|290->289|291->290|291->290|291->290|292->291|292->291|292->291|292->291|292->291|292->291|292->291|292->291|292->291|293->292|293->292|293->292|294->293|296->296|296->296|296->296|297->297|300->300|300->300|300->300|301->301|301->301|301->301|302->302|303->303|303->303|303->303|304->304|306->307|306->307|306->307|307->308|307->308|308->310|309->312|309->312|309->312|310->313|310->313|310->313|311->315|311->315|311->315|312->316|312->316|312->316|312->316|314->318|314->318|314->318|315->319|315->319|315->319|316->320|318->322|318->322|318->322|318->322|318->322|318->322|320->324|320->324|320->324|320->324|320->324|320->324|320->324|320->324|320->324|322->326|322->326|323->327|324->328|324->328|324->328|325->329|325->329|325->329|327->331|328->332|329->333|329->333|329->333|330->334|330->334|339->343|340->344|342->347|343->348|343->348|344->349|345->350|345->350|346->351|346->351|347->352|347->352|347->352|348->353|349->354|349->354|349->354|352->357|352->357|353->358|354->359|354->359|354->359|356->361|356->361|358->363|358->363|358->363|358->363|358->363|358->363|358->363|358->363|359->364|360->365|360->365|362->367|362->367|363->368|363->368|364->369|364->369|364->369|365->370|366->371|366->371|366->371|366->371|366->371|367->372|367->372|367->372|368->373|369->374|369->374|370->375|370->375|371->376|371->376|372->377|373->378|373->378|374->379|375->380|375->380|375->380|376->381|377->382|377->382|377->382|380->385|380->385|380->385|380->385|380->385|380->385|380->385|381->386|382->387|382->387|385->390|385->390|387->392|387->392|388->393|388->393|388->393|389->394|390->395|390->395|390->395|391->396|391->396|392->397|392->397|392->397|393->398|397->402|397->402|398->403|398->403|398->403|399->404|400->405|400->405|401->406|402->407|402->407|404->409|406->411|406->411|407->412|408->413|408->413|409->414|410->415|410->415|411->416|411->416|411->416|411->416|411->416|412->417|413->418|413->418|414->419|414->419|415->420|415->420|416->421|416->421|417->422|418->423|418->423|420->425|420->425|421->426|424->429|424->429|424->429|424->429|424->429|424->429|424->429|424->429|425->430|425->430|426->431|426->431|426->431|427->432|427->432|427->432|427->432|429->434|429->434|430->435|432->437|432->437|433->438|433->438|434->439|435->440|435->440|436->441|436->441|437->442|437->442|438->443|439->444|439->444|441->446|441->446|442->447|442->447|442->447|443->448|444->449|444->449|444->449|444->449|444->449|444->449|444->449|444->449|444->449|444->449|444->449|445->450|445->450|446->451|446->451|446->451|447->452|447->452|447->452|447->452|447->452|447->452|447->452|449->454|449->454|450->455|452->457|452->457|453->458|453->458|454->459|454->459|455->460|456->461|456->461|458->463|458->463|459->464|462->467|462->467|462->467|462->467|462->467|462->467|462->467|462->467|463->468|463->468|464->469|464->469|464->469|465->470|465->470|465->470|465->470|467->472|467->472|468->473|470->475|470->475|471->476|471->476|472->477|472->477|473->478|474->479|474->479|475->480|476->481|476->481|478->483
                  -- GENERATED --
              */
          