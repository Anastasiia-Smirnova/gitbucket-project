
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object files extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template13[String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],gitbucket.core.util.JGitUtil.CommitInfo,Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],Int,List[gitbucket.core.util.JGitUtil.FileInfo],Option[(List[String], String)],Boolean,Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],Option[Any],Option[Any],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(branch: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  pathList: List[String],
  latestCommit: gitbucket.core.util.JGitUtil.CommitInfo,
  commitStatus: Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],
  commitCount: Int,
  files: List[gitbucket.core.util.JGitUtil.FileInfo],
  readme: Option[(List[String], String)],
  hasWritePermission: Boolean,
  branchPullRequest: Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],
  info: Option[Any] = None,
  error: Option[Any] = None)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*13.2*/import gitbucket.core.view.helpers
/*14.2*/import gitbucket.core.service.RepositoryService


Seq[Any](_display_(/*15.2*/gitbucket/*15.11*/.core.html.main(
  if(pathList.isEmpty){
    if(branch == repository.repository.defaultBranch){
      s"${repository.owner}/${repository.name}"
    } else {
      s"${repository.owner}/${repository.name} at ${branch}"
    }
  } else {
    s"${(repository.name :: pathList).mkString("/")} at ${branch} - ${repository.owner}/${repository.name}"
  }, Some(repository))/*24.23*/ {_display_(Seq[Any](format.raw/*24.25*/("""
  """),_display_(/*25.4*/gitbucket/*25.13*/.core.html.menu("files", repository, Some(branch), info, error)/*25.76*/{_display_(Seq[Any](format.raw/*25.77*/("""
    """),_display_(if(pathList.isEmpty)/*26.26*/ {_display_(Seq[Any](format.raw/*26.28*/("""
      """),_display_(/*27.8*/repository/*27.18*/.repository.description.map/*27.45*/ { description =>_display_(Seq[Any](format.raw/*27.62*/("""
        """),format.raw/*28.9*/("""<p class="pc" style="margin-bottom: 10px;">
          <span class="normal muted">"""),_display_(/*29.39*/Html(helpers.decorateHtml(helpers.urlLink(description), repository))),format.raw/*29.107*/("""</span>
        </p>
      """)))}),format.raw/*31.8*/("""
    """)))} else {null} ),format.raw/*32.6*/("""
    """),format.raw/*33.5*/("""<div id="pull-request-area"></div>
    <div class="head" style="height: 24px;">
      <div class="pull-right">
        <div class="btn-group">
          <a href=""""),_display_(/*37.21*/{helpers.url(repository)}),format.raw/*37.46*/("""/archive"""),_display_(if(pathList.length > 0)/*37.78*/{_display_(Seq[Any](format.raw/*37.79*/("""/"""),_display_(/*37.81*/pathList/*37.89*/.map(helpers.urlEncode).mkString("/"))))} else {null} ),format.raw/*37.127*/("""/"""),_display_(/*37.129*/{helpers.urlEncode(branch)}),format.raw/*37.156*/(""".zip" class="btn btn-sm btn-default pc"><i class="octicon octicon-cloud-download"></i> Download ZIP</a>
          <a href=""""),_display_(/*38.21*/helpers/*38.28*/.url(repository)),format.raw/*38.44*/("""/find/"""),_display_(/*38.51*/helpers/*38.58*/.encodeRefName(branch)),format.raw/*38.80*/("""" class="btn btn-sm btn-default" data-hotkey="t" title="Search files"><i class="octicon octicon-search" aria-label="Search files"></i></a>
          <a href=""""),_display_(/*39.21*/helpers/*39.28*/.url(repository)),format.raw/*39.44*/("""/commits/"""),_display_(/*39.54*/helpers/*39.61*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*39.111*/("""" class="btn btn-sm btn-default"><i class="octicon octicon-history"></i> """),_display_(if(commitCount > 10000)/*39.208*/{_display_(Seq[Any](format.raw/*39.209*/("""10000+""")))}else/*39.222*/{_display_(_display_(/*39.224*/commitCount))}),format.raw/*39.236*/(""" """),_display_(/*39.238*/helpers/*39.245*/.plural(commitCount, "commit")),format.raw/*39.275*/("""</a>
        </div>
        <a href=""""),_display_(/*41.19*/helpers/*41.26*/.url(repository)),format.raw/*41.42*/("""/tree/"""),_display_(/*41.49*/helpers/*41.56*/.encodeRefName((latestCommit.id :: pathList).mkString("/"))),format.raw/*41.115*/("""" data-hotkey="y" style="display: none;">Transfer to URL with SHA</a>
      </div>
      """),_display_(if(pathList.isEmpty)/*43.28*/{_display_(Seq[Any](format.raw/*43.29*/("""
        """),format.raw/*44.9*/("""<div class="pull-right pc" style="margin-right: 5px;">
          <div class="btn-group">
            """),_display_(if(context.platform != "linux" && context.platform != null)/*46.73*/{_display_(Seq[Any](format.raw/*46.74*/("""
              """),format.raw/*47.15*/("""<a href=""""),_display_(/*47.25*/RepositoryService/*47.42*/.openRepoUrl(repository.httpUrl)),format.raw/*47.74*/("""" id="repository-clone-url" class="btn btn-sm btn-default" title="Open with GitHub Desktop"><i class="octicon octicon-desktop-download" aria-label="Open with GitHub Desktop"></i></a>
            """)))} else {null} ),format.raw/*48.14*/("""
          """),format.raw/*49.11*/("""</div>
        </div>
        <div class="pull-right pc">
          <div style="width: 240px; margin-right: 5px; margin-left: 5px;">
            """),_display_(/*53.14*/gitbucket/*53.23*/.core.helper.html.copy("repository-url", "repository-url-copy", repository.httpUrl)/*53.106*/{_display_(Seq[Any](format.raw/*53.107*/("""
              """),_display_(if(repository.sshUrl.isDefined)/*54.47*/{_display_(Seq[Any](format.raw/*54.48*/("""
                """),format.raw/*55.17*/("""<div class="btn-group input-group-btn">
                  <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span id="repository-url-proto">HTTP</span> <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu">
                    <li>
                      <a href="javascript:void(0);" id="repository-url-http">
                        <strong>HTTP (recommended)</strong><br>
                        Clone with Git using the repository's web address.
                      </a>
                    </li>
                    <li>
                      <a href="javascript:void(0);" id="repository-url-ssh">
                        <strong>SSH</strong><br>
                        Clone with an SSH key and passphrase from your GitBucket settings.
                      </a>
                    </li>
                  </ul>
                </div>
              """)))} else {null} ),format.raw/*74.16*/("""
              """),format.raw/*75.15*/("""<input type="text" value=""""),_display_(/*75.42*/repository/*75.52*/.httpUrl),format.raw/*75.60*/("""" id="repository-url" class="form-control input-sm" readonly aria-label="repository-url">
            """)))}),format.raw/*76.14*/("""
          """),format.raw/*77.11*/("""</div>
        </div>
      """)))} else {null} ),format.raw/*79.8*/("""
      """),format.raw/*80.7*/("""<div class="pull-left">
        """),_display_(/*81.10*/gitbucket/*81.19*/.core.helper.html.branchcontrol(branch, repository, hasWritePermission)/*81.90*/{_display_(Seq[Any](format.raw/*81.91*/("""
          """),_display_(/*82.12*/repository/*82.22*/.branchList.map/*82.37*/ { x =>_display_(Seq[Any](format.raw/*82.44*/("""
            """),format.raw/*83.13*/("""<li class="branch-control-item-branch"><a href=""""),_display_(/*83.62*/helpers/*83.69*/.url(repository)),format.raw/*83.85*/("""/tree/"""),_display_(/*83.92*/helpers/*83.99*/.encodeRefName(x)),format.raw/*83.116*/("""">"""),_display_(/*83.119*/gitbucket/*83.128*/.core.helper.html.checkicon(x == branch)),format.raw/*83.168*/(""" """),_display_(/*83.170*/x),format.raw/*83.171*/("""</a></li>
          """)))}),format.raw/*84.12*/("""
          """),_display_(/*85.12*/repository/*85.22*/.tags.map/*85.31*/ { x =>_display_(Seq[Any](format.raw/*85.38*/("""
            """),format.raw/*86.13*/("""<li class="branch-control-item-tag"><a href=""""),_display_(/*86.59*/helpers/*86.66*/.url(repository)),format.raw/*86.82*/("""/tree/"""),_display_(/*86.89*/helpers/*86.96*/.encodeRefName(x.name)),format.raw/*86.118*/("""">"""),_display_(/*86.121*/gitbucket/*86.130*/.core.helper.html.checkicon(x.name == branch)),format.raw/*86.175*/(""" """),_display_(/*86.177*/x/*86.178*/.name),format.raw/*86.183*/("""</a></li>
          """)))}),format.raw/*87.12*/("""
        """)))}),format.raw/*88.10*/("""
        """),_display_(if(pathList.nonEmpty)/*89.31*/{_display_(Seq[Any](format.raw/*89.32*/("""
          """),format.raw/*90.11*/("""<a href=""""),_display_(/*90.21*/helpers/*90.28*/.url(repository)),format.raw/*90.44*/("""/tree/"""),_display_(/*90.51*/helpers/*90.58*/.encodeRefName(branch)),format.raw/*90.80*/("""">"""),_display_(/*90.83*/repository/*90.93*/.name),format.raw/*90.98*/("""</a> /
          """),_display_(/*91.12*/pathList/*91.20*/.zipWithIndex.map/*91.37*/ { case (section, i) =>_display_(Seq[Any](format.raw/*91.60*/("""
            """),format.raw/*92.13*/("""<a href=""""),_display_(/*92.23*/helpers/*92.30*/.url(repository)),format.raw/*92.46*/("""/tree/"""),_display_(/*92.53*/helpers/*92.60*/.encodeRefName((branch :: pathList.take(i + 1)).mkString("/"))),format.raw/*92.122*/("""">"""),_display_(/*92.125*/section),format.raw/*92.132*/("""</a> /
          """)))}),format.raw/*93.12*/("""
        """)))} else {null} ),format.raw/*94.10*/("""
      """),format.raw/*95.7*/("""</div>
      """),_display_(if(hasWritePermission)/*96.30*/{_display_(Seq[Any](format.raw/*96.31*/("""
        """),format.raw/*97.9*/("""<div class="btn-group pull-left" style="margin-left: 4px;">
          <a href=""""),_display_(/*98.21*/helpers/*98.28*/.url(repository)),format.raw/*98.44*/("""/new/"""),_display_(/*98.50*/helpers/*98.57*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*98.107*/("""" class="btn btn-sm btn-default pc" title="Create a new file"><i class="octicon octicon-plus"></i></a>
          <a href=""""),_display_(/*99.21*/helpers/*99.28*/.url(repository)),format.raw/*99.44*/("""/upload/"""),_display_(/*99.53*/helpers/*99.60*/.encodeRefName((branch :: pathList).mkString("/"))),format.raw/*99.110*/("""" class="btn btn-sm btn-default pc" title="Upload files"><i class="octicon octicon-cloud-upload"></i></a>
        </div>
      """)))} else {null} ),format.raw/*101.8*/("""
    """),format.raw/*102.5*/("""</div>
    <table class="table table-hover">
      """),format.raw/*114.9*/("""
      """),format.raw/*115.7*/("""<tr>
        <th colspan="4" class="latest-commit" style="font-weight: normal;">
          <div>
            <div class="pull-right align-right" style="line-height: 18px;">
              <a href=""""),_display_(/*119.25*/helpers/*119.32*/.url(repository)),format.raw/*119.48*/("""/commit/"""),_display_(/*119.57*/latestCommit/*119.69*/.id),format.raw/*119.72*/("""" class="commit-id">
                <span class="muted">latest commit</span>
                <span class="monospace commit-message strong">"""),_display_(/*121.64*/latestCommit/*121.76*/.id.substring(0, 10)),format.raw/*121.96*/("""</span>
              </a>
            </div>
            <div class="author-info">
              <div class="author">
                """),_display_(/*126.18*/helpers/*126.25*/.avatarLink(latestCommit, 20)),format.raw/*126.54*/("""
                """),format.raw/*127.17*/("""<span>"""),_display_(/*127.24*/helpers/*127.31*/.user(latestCommit.authorName, latestCommit.authorEmailAddress, "username strong")),format.raw/*127.113*/("""</span>
                <span class="muted"> authored """),_display_(/*128.48*/gitbucket/*128.57*/.core.helper.html.datetimeago(latestCommit.authorTime)),format.raw/*128.111*/("""</span>
                <span>
                """),_display_(/*130.18*/commitStatus/*130.30*/.map/*130.34*/ { case (summary, statuses) =>_display_(Seq[Any](format.raw/*130.64*/("""
                  """),_display_(/*131.20*/gitbucket/*131.29*/.core.helper.html.commitstatus(latestCommit.id, summary, statuses)),format.raw/*131.95*/("""
                """)))}),format.raw/*132.18*/("""
                """),format.raw/*133.17*/("""</span>
              </div>
              """),_display_(if(latestCommit.isDifferentFromAuthor)/*135.54*/ {_display_(Seq[Any](format.raw/*135.56*/("""
                """),format.raw/*136.17*/("""<div class="committer">
                  <span class="octicon octicon-arrow-right"></span>
                  <span>"""),_display_(/*138.26*/helpers/*138.33*/.user(latestCommit.committerName, latestCommit.committerEmailAddress, "username strong")),format.raw/*138.121*/("""</span>
                  <span class="muted"> committed """),_display_(/*139.51*/gitbucket/*139.60*/.core.helper.html.datetimeago(latestCommit.commitTime)),format.raw/*139.114*/("""</span>
                </div>
              """)))} else {null} ),format.raw/*141.16*/("""
            """),format.raw/*142.13*/("""</div>
          </div>
        </th>
      </tr>
      """),_display_(if(pathList.size > 0)/*146.29*/{_display_(Seq[Any](format.raw/*146.30*/("""
        """),format.raw/*147.9*/("""<tr>
          <td width="16" class="file-icon"></td>
          <td><a href=""""),_display_(/*149.25*/helpers/*149.32*/.url(repository)),_display_(if(pathList.size > 1)/*149.70*/{_display_(Seq[Any](format.raw/*149.71*/("""/tree/"""),_display_(/*149.78*/helpers/*149.85*/.encodeRefName(branch)),format.raw/*149.107*/("""/"""),_display_(/*149.109*/helpers/*149.116*/.encodeRefName(pathList.init.mkString("/")))))} else {null} ),format.raw/*149.160*/("""">..</a></td>
          <td></td>
          <td></td>
        </tr>
      """)))} else {null} ),format.raw/*153.8*/("""
      """),_display_(/*154.8*/files/*154.13*/.map/*154.17*/ { file =>_display_(Seq[Any](format.raw/*154.27*/("""
        """),format.raw/*155.9*/("""<tr>
          <td width="16" class="file-icon">
            """),_display_(if(file.isDirectory)/*157.34*/{_display_(Seq[Any](format.raw/*157.35*/("""
              """),_display_(if(file.linkUrl.isDefined)/*158.42*/{_display_(Seq[Any](format.raw/*158.43*/("""
                """),format.raw/*159.17*/("""<i class="octicon octicon-file-symlink-directory"></i>
              """)))}else/*160.22*/{_display_(Seq[Any](format.raw/*160.23*/("""
                """),format.raw/*161.17*/("""<i class="octicon octicon-file-directory"></i>
              """)))}),format.raw/*162.16*/("""
            """)))}else/*163.20*/{_display_(Seq[Any](format.raw/*163.21*/("""
              """),format.raw/*164.15*/("""<i class="octicon octicon-file-text" data-filename=""""),_display_(/*164.68*/helpers/*164.75*/.urlEncode(file.name)),format.raw/*164.96*/(""""></i>
            """)))}),format.raw/*165.14*/("""
          """),format.raw/*166.11*/("""</td>
          <td class="ellipsis-cell" style="width: 20%; min-width: 160px;">
            """),_display_(if(file.isDirectory)/*168.34*/{_display_(Seq[Any](format.raw/*168.35*/("""
              """),_display_(/*169.16*/{file.linkUrl match {
                case Some(linkUrl) if linkUrl.startsWith("http://") || linkUrl.startsWith("https://") => {
                  <a href={linkUrl}>
                    <span class="simplified-path">{file.name.split("/").toList.init match {
                      case Nil  => ""
                      case list => list.mkString("", "/", "/")
                    }}</span>
                    {file.name.split("/").toList.last}
                  </a>
                }
                case Some(_) => {
                  <span>
                    <span class="simplified-path">{file.name.split("/").toList.init match {
                      case Nil  => ""
                      case list => list.mkString("", "/", "/")
                    }}</span>
                    {file.name.split("/").toList.last}
                  </span>
                }
                case None => {
                  <a href={helpers.url(repository) + "/tree" + helpers.encodeRefName((branch :: pathList).mkString("/", "/", "/") + file.name)}>
                    <span class="simplified-path">{file.name.split("/").toList.init match {
                      case Nil  => ""
                      case list => list.mkString("", "/", "/")
                    }}</span>
                    {file.name.split("/").toList.last}
                  </a>
                }
              }}),format.raw/*197.17*/("""
            """)))}else/*198.20*/{_display_(Seq[Any](format.raw/*198.21*/("""
              """),format.raw/*199.15*/("""<a href=""""),_display_(/*199.25*/helpers/*199.32*/.url(repository)),format.raw/*199.48*/("""/blob"""),_display_(/*199.54*/{helpers.encodeRefName((branch :: pathList).mkString("/", "/", "/") + file.name)}),format.raw/*199.135*/("""">"""),_display_(/*199.138*/file/*199.142*/.name),format.raw/*199.147*/("""</a>
            """)))}),format.raw/*200.14*/("""
          """),format.raw/*201.11*/("""</td>
          <td class="ellipsis-cell" style="width: 70%;">
            <span>
              <a href=""""),_display_(/*204.25*/helpers/*204.32*/.url(repository)),format.raw/*204.48*/("""/commit/"""),_display_(/*204.57*/file/*204.61*/.commitId),format.raw/*204.70*/("""" class="commit-message" title=""""),_display_(/*204.103*/file/*204.107*/.message),format.raw/*204.115*/("""">"""),_display_(/*204.118*/helpers/*204.125*/.link(file.message, repository)),format.raw/*204.156*/("""</a>
            </span>
          </td>
          <td style="width: 10%; min-width: 125px; text-align: right;">"""),_display_(/*207.73*/gitbucket/*207.82*/.core.helper.html.datetimeago(file.time, false)),format.raw/*207.129*/("""</td>
        </tr>
      """)))}),format.raw/*209.8*/("""
    """),format.raw/*210.5*/("""</table>
    """),_display_(/*211.6*/readme/*211.12*/.map/*211.16*/ { case (filePath, content) =>_display_(Seq[Any](format.raw/*211.46*/("""
      """),format.raw/*212.7*/("""<div id="readme" class="box-header">
        <div class="strong" style="line-height: 28px;">
          <i class="octicon octicon-file"></i>
          """),_display_(/*215.12*/filePath/*215.20*/.last),format.raw/*215.25*/("""
          """),_display_(if(hasWritePermission)/*216.34*/{_display_(Seq[Any](format.raw/*216.35*/("""
            """),format.raw/*217.13*/("""<div class="btn-group pull-right">
              <a class="btn btn-sm" style="padding-right: 4px;" href=""""),_display_(/*218.72*/helpers/*218.79*/.url(repository)),format.raw/*218.95*/("""/edit/"""),_display_(/*218.102*/helpers/*218.109*/.encodeRefName((branch :: filePath).mkString("/"))),format.raw/*218.159*/(""""><i class="octicon octicon-pencil" aria-label="Edit"></i></a>
            </div>
          """)))} else {null} ),format.raw/*220.12*/("""
        """),format.raw/*221.9*/("""</div>
      </div>
      <div class="box-content-bottom markdown-body" style="padding-left: 20px; padding-right: 20px;">"""),_display_(/*223.103*/helpers/*223.110*/.renderMarkup(filePath, content, branch, repository, false, false, true)),format.raw/*223.182*/("""</div>
    """)))}),format.raw/*224.6*/("""
  """)))}),format.raw/*225.4*/("""
""")))}),format.raw/*226.2*/("""
"""),format.raw/*227.1*/("""<script>
$(function() """),format.raw/*228.14*/("""{"""),format.raw/*228.15*/("""
  """),_display_(/*229.4*/repository/*229.14*/.sshUrl.map/*229.25*/ { sshUrl =>_display_(Seq[Any](format.raw/*229.37*/("""
    """),format.raw/*230.5*/("""$('#repository-url-http').click(function()"""),format.raw/*230.47*/("""{"""),format.raw/*230.48*/("""
      """),format.raw/*231.7*/("""$('#repository-url-proto').text('HTTP');
      $('#repository-url').val('"""),_display_(/*232.34*/repository/*232.44*/.httpUrl),format.raw/*232.52*/("""');
      $('#repository-clone-url').attr('href', '"""),_display_(/*233.49*/RepositoryService/*233.66*/.openRepoUrl(repository.httpUrl)),format.raw/*233.98*/("""')
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*235.5*/("""}"""),format.raw/*235.6*/(""");

    $('#repository-url-ssh').click(function()"""),format.raw/*237.46*/("""{"""),format.raw/*237.47*/("""
      """),format.raw/*238.7*/("""$('#repository-url-proto').text('SSH');
      $('#repository-url').val('"""),_display_(/*239.34*/sshUrl),format.raw/*239.40*/("""');
      $('#repository-clone-url').attr('href', '"""),_display_(/*240.49*/RepositoryService/*240.66*/.openRepoUrl(sshUrl)),format.raw/*240.86*/("""');
      $('#repository-url-copy').attr('data-clipboard-text', $('#repository-url').val());
    """),format.raw/*242.5*/("""}"""),format.raw/*242.6*/(""");
  """)))}),format.raw/*243.4*/("""

  """),_display_(if(pathList.isEmpty && hasWritePermission)/*245.46*/{_display_(Seq[Any](format.raw/*245.47*/("""
    """),format.raw/*246.5*/("""$.get('"""),_display_(/*246.13*/{helpers.url(repository)}),format.raw/*246.38*/("""/pulls/proposals', function(res)"""),format.raw/*246.70*/("""{"""),format.raw/*246.71*/("""
      """),format.raw/*247.7*/("""if(res) """),format.raw/*247.15*/("""{"""),format.raw/*247.16*/("""
        """),format.raw/*248.9*/("""$('#pull-request-area').html(res);
      """),format.raw/*249.7*/("""}"""),format.raw/*249.8*/("""
    """),format.raw/*250.5*/("""}"""),format.raw/*250.6*/(""");
  """)))} else {null} ),format.raw/*251.4*/("""
"""),format.raw/*252.1*/("""}"""),format.raw/*252.2*/(""");
</script>
"""))
      }
    }
  }

  def render(branch:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,pathList:List[String],latestCommit:gitbucket.core.util.JGitUtil.CommitInfo,commitStatus:Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],commitCount:Int,files:List[gitbucket.core.util.JGitUtil.FileInfo],readme:Option[(List[String], String)],hasWritePermission:Boolean,branchPullRequest:Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],info:Option[Any],error:Option[Any],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(branch,repository,pathList,latestCommit,commitStatus,commitCount,files,readme,hasWritePermission,branchPullRequest,info,error)(context)

  def f:((String,gitbucket.core.service.RepositoryService.RepositoryInfo,List[String],gitbucket.core.util.JGitUtil.CommitInfo,Option[(gitbucket.core.model.CommitState, List[gitbucket.core.model.CommitStatus])],Int,List[gitbucket.core.util.JGitUtil.FileInfo],Option[(List[String], String)],Boolean,Option[(gitbucket.core.model.PullRequest, gitbucket.core.model.Issue)],Option[Any],Option[Any]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (branch,repository,pathList,latestCommit,commitStatus,commitCount,files,readme,hasWritePermission,branchPullRequest,info,error) => (context) => apply(branch,repository,pathList,latestCommit,commitStatus,commitCount,files,readme,hasWritePermission,branchPullRequest,info,error)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/files.scala.html
                  HASH: 2583d1d9d0c330a626ee57abdef5b763810fcb9c
                  MATRIX: 990->1|1685->624|1728->660|1805->709|1823->718|2197->1083|2237->1085|2267->1089|2285->1098|2357->1161|2396->1162|2449->1188|2489->1190|2523->1198|2542->1208|2578->1235|2633->1252|2669->1261|2778->1343|2868->1411|2926->1439|2975->1445|3007->1450|3197->1613|3243->1638|3302->1670|3341->1671|3370->1673|3387->1681|3463->1719|3493->1721|3542->1748|3693->1872|3709->1879|3746->1895|3780->1902|3796->1909|3839->1931|4025->2090|4041->2097|4078->2113|4115->2123|4131->2130|4203->2180|4328->2277|4368->2278|4399->2291|4430->2293|4466->2305|4496->2307|4513->2314|4565->2344|4630->2382|4646->2389|4683->2405|4717->2412|4733->2419|4814->2478|4951->2588|4990->2589|5026->2598|5214->2759|5253->2760|5296->2775|5333->2785|5359->2802|5412->2834|5652->3030|5691->3041|5864->3187|5882->3196|5975->3279|6015->3280|6089->3327|6128->3328|6173->3345|7228->4356|7271->4371|7325->4398|7344->4408|7373->4416|7507->4519|7546->4530|7618->4559|7652->4566|7712->4599|7730->4608|7810->4679|7849->4680|7888->4692|7907->4702|7931->4717|7976->4724|8017->4737|8093->4786|8109->4793|8146->4809|8180->4816|8196->4823|8235->4840|8266->4843|8285->4852|8347->4892|8377->4894|8400->4895|8452->4916|8491->4928|8510->4938|8528->4947|8573->4954|8614->4967|8687->5013|8703->5020|8740->5036|8774->5043|8790->5050|8834->5072|8865->5075|8884->5084|8951->5129|8981->5131|8992->5132|9019->5137|9071->5158|9112->5168|9170->5199|9209->5200|9248->5211|9285->5221|9301->5228|9338->5244|9372->5251|9388->5258|9431->5280|9461->5283|9480->5293|9506->5298|9551->5316|9568->5324|9594->5341|9655->5364|9696->5377|9733->5387|9749->5394|9786->5410|9820->5417|9836->5424|9920->5486|9951->5489|9980->5496|10029->5514|10083->5524|10117->5531|10180->5567|10219->5568|10255->5577|10362->5657|10378->5664|10415->5680|10448->5686|10464->5693|10536->5743|10686->5866|10702->5873|10739->5889|10775->5898|10791->5905|10863->5955|11035->6083|11068->6088|11147->6718|11182->6725|11407->6922|11424->6929|11462->6945|11499->6954|11521->6966|11546->6969|11715->7110|11737->7122|11779->7142|11943->7278|11960->7285|12011->7314|12057->7331|12092->7338|12109->7345|12214->7427|12297->7482|12316->7491|12393->7545|12469->7593|12491->7605|12505->7609|12574->7639|12622->7659|12641->7668|12729->7734|12779->7752|12825->7769|12935->7851|12976->7853|13022->7870|13167->7987|13184->7994|13295->8082|13381->8140|13400->8149|13477->8203|13568->8249|13610->8262|13716->8340|13756->8341|13793->8350|13899->8428|13916->8435|13975->8473|14015->8474|14050->8481|14067->8488|14112->8510|14143->8512|14161->8519|14244->8563|14363->8638|14398->8646|14413->8651|14427->8655|14476->8665|14513->8674|14623->8756|14663->8757|14733->8799|14773->8800|14819->8817|14913->8893|14953->8894|14999->8911|15093->8973|15131->8993|15171->8994|15215->9009|15296->9062|15313->9069|15356->9090|15408->9110|15448->9121|15590->9235|15630->9236|15674->9252|17073->10629|17111->10649|17151->10650|17195->10665|17233->10675|17250->10682|17288->10698|17322->10704|17426->10785|17458->10788|17473->10792|17501->10797|17551->10815|17591->10826|17725->10932|17742->10939|17780->10955|17817->10964|17831->10968|17862->10977|17924->11010|17939->11014|17970->11022|18002->11025|18020->11032|18074->11063|18215->11176|18234->11185|18304->11232|18362->11259|18395->11264|18436->11278|18452->11284|18466->11288|18535->11318|18570->11325|18749->11476|18767->11484|18794->11489|18856->11523|18896->11524|18938->11537|19072->11643|19089->11650|19127->11666|19163->11673|19181->11680|19254->11730|19392->11823|19429->11832|19580->11954|19598->11961|19693->12033|19736->12045|19771->12049|19804->12051|19833->12052|19884->12074|19914->12075|19945->12079|19965->12089|19986->12100|20037->12112|20070->12117|20141->12159|20171->12160|20206->12167|20308->12241|20328->12251|20358->12259|20438->12311|20465->12328|20519->12360|20643->12456|20672->12457|20750->12506|20780->12507|20815->12514|20916->12587|20944->12593|21024->12645|21051->12662|21093->12682|21218->12779|21247->12780|21284->12786|21359->12833|21399->12834|21432->12839|21468->12847|21515->12872|21576->12904|21606->12905|21641->12912|21678->12920|21708->12921|21745->12930|21814->12971|21843->12972|21876->12977|21905->12978|21955->12984|21984->12985|22013->12986
                  LINES: 14->1|28->13|29->14|32->15|32->15|41->24|41->24|42->25|42->25|42->25|42->25|43->26|43->26|44->27|44->27|44->27|44->27|45->28|46->29|46->29|48->31|49->32|50->33|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|54->37|55->38|55->38|55->38|55->38|55->38|55->38|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|56->39|58->41|58->41|58->41|58->41|58->41|58->41|60->43|60->43|61->44|63->46|63->46|64->47|64->47|64->47|64->47|65->48|66->49|70->53|70->53|70->53|70->53|71->54|71->54|72->55|91->74|92->75|92->75|92->75|92->75|93->76|94->77|96->79|97->80|98->81|98->81|98->81|98->81|99->82|99->82|99->82|99->82|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|100->83|101->84|102->85|102->85|102->85|102->85|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|103->86|104->87|105->88|106->89|106->89|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|108->91|108->91|108->91|108->91|109->92|109->92|109->92|109->92|109->92|109->92|109->92|109->92|109->92|110->93|111->94|112->95|113->96|113->96|114->97|115->98|115->98|115->98|115->98|115->98|115->98|116->99|116->99|116->99|116->99|116->99|116->99|118->101|119->102|121->114|122->115|126->119|126->119|126->119|126->119|126->119|126->119|128->121|128->121|128->121|133->126|133->126|133->126|134->127|134->127|134->127|134->127|135->128|135->128|135->128|137->130|137->130|137->130|137->130|138->131|138->131|138->131|139->132|140->133|142->135|142->135|143->136|145->138|145->138|145->138|146->139|146->139|146->139|148->141|149->142|153->146|153->146|154->147|156->149|156->149|156->149|156->149|156->149|156->149|156->149|156->149|156->149|156->149|160->153|161->154|161->154|161->154|161->154|162->155|164->157|164->157|165->158|165->158|166->159|167->160|167->160|168->161|169->162|170->163|170->163|171->164|171->164|171->164|171->164|172->165|173->166|175->168|175->168|176->169|204->197|205->198|205->198|206->199|206->199|206->199|206->199|206->199|206->199|206->199|206->199|206->199|207->200|208->201|211->204|211->204|211->204|211->204|211->204|211->204|211->204|211->204|211->204|211->204|211->204|211->204|214->207|214->207|214->207|216->209|217->210|218->211|218->211|218->211|218->211|219->212|222->215|222->215|222->215|223->216|223->216|224->217|225->218|225->218|225->218|225->218|225->218|225->218|227->220|228->221|230->223|230->223|230->223|231->224|232->225|233->226|234->227|235->228|235->228|236->229|236->229|236->229|236->229|237->230|237->230|237->230|238->231|239->232|239->232|239->232|240->233|240->233|240->233|242->235|242->235|244->237|244->237|245->238|246->239|246->239|247->240|247->240|247->240|249->242|249->242|250->243|252->245|252->245|253->246|253->246|253->246|253->246|253->246|254->247|254->247|254->247|255->248|256->249|256->249|257->250|257->250|258->251|259->252|259->252
                  -- GENERATED --
              */
          