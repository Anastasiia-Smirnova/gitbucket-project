
package gitbucket.core.pulls.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object compare extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template21[String,Seq[Seq[gitbucket.core.util.JGitUtil.CommitInfo]],Seq[gitbucket.core.util.JGitUtil.DiffInfo],List[(String, String, String)],List[gitbucket.core.model.Comment],String,String,String,String,String,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[gitbucket.core.model.CustomField],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String,
  commits: Seq[Seq[gitbucket.core.util.JGitUtil.CommitInfo]],
  diffs: Seq[gitbucket.core.util.JGitUtil.DiffInfo],
  members: List[(String, String, String)],
  comments: List[gitbucket.core.model.Comment],
  originId: String,
  forkedId: String,
  sourceId: String,
  commitId: String,
  content: String,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  originRepository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  forkedRepository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  hasOriginWritePermission: Boolean,
  collaborators: List[String],
  milestones: List[gitbucket.core.model.Milestone],
  priorities: List[gitbucket.core.model.Priority],
  defaultPriority: Option[gitbucket.core.model.Priority],
  labels: List[gitbucket.core.model.Label],
  customFields: List[gitbucket.core.model.CustomField])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*21.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(/*22.2*/gitbucket/*22.11*/.core.html.main(s"Pull requests - ${repository.owner}/${repository.name}", Some(repository))/*22.103*/{_display_(Seq[Any](format.raw/*22.104*/("""
  """),_display_(/*23.4*/gitbucket/*23.13*/.core.html.menu("pulls", repository)/*23.49*/{_display_(Seq[Any](format.raw/*23.50*/("""
    """),format.raw/*24.5*/("""<div class="pullreq-info">
      <div id="compare-edit">
        """),_display_(/*26.10*/gitbucket/*26.19*/.core.helper.html.dropdown(originRepository.owner + "/" + originRepository.name, "base fork", filter=("origin_repo", "Find Repository..."))/*26.158*/ {_display_(Seq[Any](format.raw/*26.160*/("""
          """),_display_(/*27.12*/members/*27.19*/.map/*27.23*/ { case (owner, name, defaultBranch) =>_display_(Seq[Any](format.raw/*27.62*/("""
            """),format.raw/*28.13*/("""<li><a href="#" class="origin-owner" data-owner=""""),_display_(/*28.63*/owner),format.raw/*28.68*/("""" data-name=""""),_display_(/*28.82*/name),format.raw/*28.86*/("""" data-default-branch=""""),_display_(/*28.110*/defaultBranch),format.raw/*28.123*/("""">"""),_display_(/*28.126*/gitbucket/*28.135*/.core.helper.html.checkicon(owner == originRepository.owner)),format.raw/*28.195*/(""" """),_display_(/*28.197*/owner),format.raw/*28.202*/("""/"""),_display_(/*28.204*/name),format.raw/*28.208*/("""</a></li>
          """)))}),format.raw/*29.12*/("""
        """)))}),format.raw/*30.10*/("""
        """),_display_(/*31.10*/gitbucket/*31.19*/.core.helper.html.dropdown(originId, "base", filter=("origin_branch", "Find Branch..."))/*31.107*/ {_display_(Seq[Any](format.raw/*31.109*/("""
          """),_display_(if(!originRepository.branchList.contains(originId))/*32.63*/{_display_(Seq[Any](format.raw/*32.64*/("""
            """),format.raw/*33.13*/("""<li><a href="#" class="origin-branch" data-branch=""""),_display_(/*33.65*/helpers/*33.72*/.encodeRefName(originId)),format.raw/*33.96*/("""">"""),_display_(/*33.99*/gitbucket/*33.108*/.core.helper.html.checkicon(true)),format.raw/*33.141*/(""" """),_display_(/*33.143*/originId),format.raw/*33.151*/("""</a></li>
          """)))} else {null} ),format.raw/*34.12*/("""
          """),_display_(/*35.12*/originRepository/*35.28*/.branchList.map/*35.43*/ { branch =>_display_(Seq[Any](format.raw/*35.55*/("""
            """),format.raw/*36.13*/("""<li><a href="#" class="origin-branch" data-branch=""""),_display_(/*36.65*/helpers/*36.72*/.encodeRefName(branch)),format.raw/*36.94*/("""">"""),_display_(/*36.97*/gitbucket/*36.106*/.core.helper.html.checkicon(branch == originId)),format.raw/*36.153*/(""" """),_display_(/*36.155*/branch),format.raw/*36.161*/("""</a></li>
          """)))}),format.raw/*37.12*/("""
        """)))}),format.raw/*38.10*/("""
        """),format.raw/*39.9*/("""...
        """),_display_(/*40.10*/gitbucket/*40.19*/.core.helper.html.dropdown(forkedRepository.owner + "/" + forkedRepository.name, "head fork", filter=("forked_repo", "Find Repository..."))/*40.158*/ {_display_(Seq[Any](format.raw/*40.160*/("""
          """),_display_(/*41.12*/members/*41.19*/.map/*41.23*/ { case (owner, name, defaultBranch) =>_display_(Seq[Any](format.raw/*41.62*/("""
            """),format.raw/*42.13*/("""<li><a href="#" class="forked-owner" data-owner=""""),_display_(/*42.63*/owner),format.raw/*42.68*/("""" data-name=""""),_display_(/*42.82*/name),format.raw/*42.86*/("""" data-default-branch=""""),_display_(/*42.110*/defaultBranch),format.raw/*42.123*/("""">"""),_display_(/*42.126*/gitbucket/*42.135*/.core.helper.html.checkicon(owner == forkedRepository.owner)),format.raw/*42.195*/(""" """),_display_(/*42.197*/owner),format.raw/*42.202*/("""/"""),_display_(/*42.204*/name),format.raw/*42.208*/("""</a></li>
          """)))}),format.raw/*43.12*/("""
        """)))}),format.raw/*44.10*/("""
        """),_display_(/*45.10*/gitbucket/*45.19*/.core.helper.html.dropdown(forkedId, "compare", filter=("forked_branch", "Find Branch..."))/*45.110*/ {_display_(Seq[Any](format.raw/*45.112*/("""
          """),_display_(if(!forkedRepository.branchList.contains(forkedId))/*46.63*/{_display_(Seq[Any](format.raw/*46.64*/("""
            """),format.raw/*47.13*/("""<li><a href="#" class="origin-branch" data-branch=""""),_display_(/*47.65*/helpers/*47.72*/.encodeRefName(forkedId)),format.raw/*47.96*/("""">"""),_display_(/*47.99*/gitbucket/*47.108*/.core.helper.html.checkicon(true)),format.raw/*47.141*/(""" """),_display_(/*47.143*/forkedId),format.raw/*47.151*/("""</a></li>
          """)))} else {null} ),format.raw/*48.12*/("""
          """),_display_(/*49.12*/forkedRepository/*49.28*/.branchList.map/*49.43*/ { branch =>_display_(Seq[Any](format.raw/*49.55*/("""
            """),format.raw/*50.13*/("""<li><a href="#" class="forked-branch" data-branch=""""),_display_(/*50.65*/helpers/*50.72*/.encodeRefName(branch)),format.raw/*50.94*/("""">"""),_display_(/*50.97*/gitbucket/*50.106*/.core.helper.html.checkicon(branch == forkedId)),format.raw/*50.153*/(""" """),_display_(/*50.155*/branch),format.raw/*50.161*/("""</a></li>
          """)))}),format.raw/*51.12*/("""
        """)))}),format.raw/*52.10*/("""
      """),format.raw/*53.7*/("""</div>
      """),_display_(if(originRepository.branchList.contains(originId) && forkedRepository.branchList.contains(forkedId))/*54.108*/{_display_(Seq[Any](format.raw/*54.109*/("""
        """),format.raw/*55.9*/("""<div class="check-conflict" style="display: none;">
          <img src=""""),_display_(/*56.22*/helpers/*56.29*/.assets("/common/images/indicator.gif")),format.raw/*56.68*/(""""/> Checking...
        </div>
      """)))} else {null} ),format.raw/*58.8*/("""
    """),format.raw/*59.5*/("""</div>
    """),_display_(if(commits.nonEmpty && context.loginAccount.isDefined && originRepository.branchList.contains(originId) && forkedRepository.branchList.contains(forkedId))/*60.160*/{_display_(Seq[Any](format.raw/*60.161*/("""
      """),format.raw/*61.7*/("""<div id="pull-request-form" style="margin-bottom: 20px;">
        <form method="POST" action=""""),_display_(/*62.38*/context/*62.45*/.path),format.raw/*62.50*/("""/"""),_display_(/*62.52*/originRepository/*62.68*/.owner),format.raw/*62.74*/("""/"""),_display_(/*62.76*/originRepository/*62.92*/.name),format.raw/*62.97*/("""/pulls/new" validate="true">
          <div class="row">
            <div class="col-md-9">
              <span class="error" id="error-title"></span>
              <input type="text" name="title" value=""""),_display_(/*66.55*/title),format.raw/*66.60*/("""" class="form-control" style="margin-bottom: 6px;" placeholder="Title"/>
              """),_display_(/*67.16*/gitbucket/*67.25*/.core.helper.html.preview(
                repository         = repository,
                content            = content,
                enableWikiLink     = false,
                enableRefsLink     = true,
                enableLineBreaks   = true,
                enableTaskList     = true,
                hasWritePermission = true,
                completionContext  = "issues",
                style              = "height: 200px;"
              )),format.raw/*77.16*/("""
              """),format.raw/*78.15*/("""<div class="text-right">
                <input type="hidden" name="targetUserName" value=""""),_display_(/*79.68*/originRepository/*79.84*/.owner),format.raw/*79.90*/(""""/>
                <input type="hidden" name="targetBranch" value=""""),_display_(/*80.66*/originId),format.raw/*80.74*/(""""/>
                <input type="hidden" name="requestUserName" value=""""),_display_(/*81.69*/forkedRepository/*81.85*/.owner),format.raw/*81.91*/(""""/>
                <input type="hidden" name="requestRepositoryName" value=""""),_display_(/*82.75*/forkedRepository/*82.91*/.name),format.raw/*82.96*/(""""/>
                <input type="hidden" name="requestBranch" value=""""),_display_(/*83.67*/forkedId),format.raw/*83.75*/(""""/>
                <input type="hidden" name="commitIdFrom" value=""""),_display_(/*84.66*/sourceId),format.raw/*84.74*/(""""/>
                <input type="hidden" name="commitIdTo" value=""""),_display_(/*85.64*/commitId),format.raw/*85.72*/(""""/>
                <input type="hidden" id="is-draft" name="isDraft" value=false />
                <div class="btn-group dropdown">
                  <input type="submit" class="btn btn-success" tabindex="2" value="Create pull request" id="submit-button" validate="true" formaction=""""),_display_(/*88.153*/context/*88.160*/.path),format.raw/*88.165*/("""/"""),_display_(/*88.167*/originRepository/*88.183*/.owner),format.raw/*88.189*/("""/"""),_display_(/*88.191*/originRepository/*88.207*/.name),format.raw/*88.212*/("""/pulls/new"/>
                  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="caret"></span>
                  </button>
                  <ul class="dropdown-menu dropdown-menu-right">
                    <li><a id="pull-request">Create pull request</a></li>
                    <li><a id="draft-request">Create draft request</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              """),_display_(/*100.16*/gitbucket/*100.25*/.core.issues.html.issueinfo(
                issue = None,
                comments = Nil,
                issueLabels = Nil,
                issueAssignees = Nil,
                collaborators = collaborators,
                milestones = milestones.map((_, 0, 0)),
                priorities = priorities,
                defaultPriority = defaultPriority,
                labels = labels,
                customFields = customFields.map((_, None)),
                isManageable = hasOriginWritePermission,
                repository = repository
              )),format.raw/*113.16*/("""
            """),format.raw/*114.13*/("""</div>
          </div>
        </form>
      </div>
    """)))} else {null} ),format.raw/*118.6*/("""
    """),_display_(if(commits.isEmpty)/*119.25*/{_display_(Seq[Any](format.raw/*119.26*/("""
      """),format.raw/*120.7*/("""<div class="panel panel-default" style="padding: 20px; background-color: #eee; text-align: center;">
        <h4>There isn't anything to compare.</h4>
        <span class="strong">"""),_display_(/*122.31*/originRepository/*122.47*/.owner),format.raw/*122.53*/(""":"""),_display_(/*122.55*/originId),format.raw/*122.63*/("""</span> and <span class="strong">"""),_display_(/*122.97*/forkedRepository/*122.113*/.owner),format.raw/*122.119*/(""":"""),_display_(/*122.121*/forkedId),format.raw/*122.129*/("""</span> are identical.
      </div>
    """)))}else/*124.12*/{_display_(Seq[Any](format.raw/*124.13*/("""
      """),format.raw/*125.7*/("""<div style="margin-bottom: 10px; padding: 4px;" class="panel panel-default">
        <table class="fill-width">
          <tr>
            <td style="width: 25%; text-align: center;">
              <i class="octicon octicon-commit"></i>
              """),_display_(/*130.16*/defining(commits.flatten)/*130.41*/{ commits =>_display_(Seq[Any](format.raw/*130.53*/("""
                """),format.raw/*131.17*/("""<strong>"""),_display_(/*131.26*/commits/*131.33*/.size),format.raw/*131.38*/("""</strong> """),_display_(/*131.49*/helpers/*131.56*/.plural(commits.size, "commit")),format.raw/*131.87*/("""
              """)))}),format.raw/*132.16*/("""
            """),format.raw/*133.13*/("""</td>
            <td style="width: 25%; text-align: center;">
              <i class="octicon octicon-diff"></i>
              <strong>"""),_display_(/*136.24*/diffs/*136.29*/.size),format.raw/*136.34*/("""</strong> """),_display_(/*136.45*/helpers/*136.52*/.plural(diffs.size, "file")),format.raw/*136.79*/(""" """),format.raw/*136.80*/("""changed
            </td>
            <td style="width: 25%; text-align: center;">
              <i class="octicon octicon-comment"></i>
              """),_display_(/*140.16*/defining(comments.collect { case c: gitbucket.core.model.CommitComment => c })/*140.94*/{ comments =>_display_(Seq[Any](format.raw/*140.107*/("""
                """),format.raw/*141.17*/("""<strong>"""),_display_(/*141.26*/comments/*141.34*/.size),format.raw/*141.39*/("""</strong> commit """),_display_(/*141.57*/helpers/*141.64*/.plural(comments.size, "comment")),format.raw/*141.97*/("""
              """)))}),format.raw/*142.16*/("""
            """),format.raw/*143.13*/("""</td>
            <td style="width: 25%; text-align: center;">
              <i class="octicon octicon-organization"></i>
              """),_display_(/*146.16*/defining(commits.flatMap(_.map(_.authorEmailAddress)).distinct)/*146.79*/{ contributors =>_display_(Seq[Any](format.raw/*146.96*/("""
                """),format.raw/*147.17*/("""<strong>"""),_display_(/*147.26*/contributors/*147.38*/.size),format.raw/*147.43*/("""</strong> """),_display_(/*147.54*/helpers/*147.61*/.plural(contributors.size, "contributor")),format.raw/*147.102*/("""
              """)))}),format.raw/*148.16*/("""
            """),format.raw/*149.13*/("""</td>
          </tr>
        </table>
      </div>
      <div style="margin-bottom: 20px;">
        """),_display_(/*154.10*/commits/*154.17*/.map/*154.21*/ { day =>_display_(Seq[Any](format.raw/*154.30*/("""
          """),format.raw/*155.11*/("""<div style="margin-top: 8px; margin-bottom: 8px;" class="muted">
            Commits on """),_display_(/*156.25*/helpers/*156.32*/.date(day.head.commitTime)),format.raw/*156.58*/("""
          """),format.raw/*157.11*/("""</div>
          <table style="width: 100%;">
          """),_display_(/*159.12*/day/*159.15*/.map/*159.19*/ { commit =>_display_(Seq[Any](format.raw/*159.31*/("""
            """),format.raw/*160.13*/("""<tr>
              <td style="width: 20%;">
                <i class="octicon octicon-git-commit"></i>
                """),_display_(/*163.18*/helpers/*163.25*/.avatarLink(commit, 20)),format.raw/*163.48*/("""
                """),_display_(/*164.18*/helpers/*164.25*/.user(commit.authorName, commit.authorEmailAddress, "username strong")),format.raw/*164.95*/("""
              """),format.raw/*165.15*/("""</td>
              <td><span class="monospace">"""),_display_(/*166.44*/commit/*166.50*/.shortMessage),format.raw/*166.63*/("""</span></td>
              <td style="width: 10%; text-align: right;">
                <a href=""""),_display_(/*168.27*/helpers/*168.34*/.url(repository)),format.raw/*168.50*/("""/commit/"""),_display_(/*168.59*/commit/*168.65*/.id),format.raw/*168.68*/("""" class="monospace">"""),_display_(/*168.89*/commit/*168.95*/.id.substring(0, 7)),format.raw/*168.114*/("""</a>
              </td>
            </tr>
          """)))}),format.raw/*171.12*/("""
          """),format.raw/*172.11*/("""</table>
        """)))}),format.raw/*173.10*/("""
      """),format.raw/*174.7*/("""</div>
      """),_display_(/*175.8*/gitbucket/*175.17*/.core.helper.html.diff(diffs, repository, Some(commitId), Some(sourceId), true, None, false, false)),format.raw/*175.116*/("""
      """),_display_(/*176.8*/gitbucket/*176.17*/.core.issues.html.commentlist(None, comments, false, repository, None)),format.raw/*176.87*/("""
    """)))}),format.raw/*177.6*/("""
  """)))}),format.raw/*178.4*/("""
""")))}),format.raw/*179.2*/("""
"""),format.raw/*180.1*/("""<script>

$(function()"""),format.raw/*182.13*/("""{"""),format.raw/*182.14*/("""
  """),format.raw/*183.3*/("""$('#draft-request').click(function()"""),format.raw/*183.39*/("""{"""),format.raw/*183.40*/("""
    """),format.raw/*184.5*/("""$("#is-draft").val(true);
    $('#submit-button').attr('value', 'Create draft request')
  """),format.raw/*186.3*/("""}"""),format.raw/*186.4*/(""");
  $('#pull-request').click(function()"""),format.raw/*187.38*/("""{"""),format.raw/*187.39*/("""
  """),format.raw/*188.3*/("""$("#is-draft").val(false);
    $('#submit-button').attr('value', 'Create pull request')
  """),format.raw/*190.3*/("""}"""),format.raw/*190.4*/(""");
"""),format.raw/*191.1*/("""}"""),format.raw/*191.2*/(""");


$(function()"""),format.raw/*194.13*/("""{"""),format.raw/*194.14*/("""
  """),format.raw/*195.3*/("""function updateSelector(e)"""),format.raw/*195.29*/("""{"""),format.raw/*195.30*/("""
    """),format.raw/*196.5*/("""e.parents('ul').find('i').attr('class', 'octicon');
    e.find('i').addClass('octicon-check');
    e.parents('div.btn-group').find('button span.strong').text(e.text());
  """),format.raw/*199.3*/("""}"""),format.raw/*199.4*/("""

  """),format.raw/*201.3*/("""$('a.origin-owner').click(function()"""),format.raw/*201.39*/("""{"""),format.raw/*201.40*/("""
    """),format.raw/*202.5*/("""updateSelector($(this));

    location.href = '"""),_display_(/*204.23*/context/*204.30*/.path),format.raw/*204.35*/("""/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + '/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('name')) +'/compare/' +
      $.trim($('i.octicon-check').parents('a.origin-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.origin-owner' ).data('default-branch')) + '...' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.forked-branch').data('branch'));
  """),format.raw/*211.3*/("""}"""),format.raw/*211.4*/(""");

  $('a.forked-owner').click(function()"""),format.raw/*213.39*/("""{"""),format.raw/*213.40*/("""
    """),format.raw/*214.5*/("""updateSelector($(this));

    location.href = '"""),_display_(/*216.23*/context/*216.30*/.path),format.raw/*216.35*/("""/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + '/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('name')) +'/compare/' +
      $.trim($('i.octicon-check').parents('a.origin-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.origin-branch').data('branch')) + '...' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('default-branch'));
  """),format.raw/*223.3*/("""}"""),format.raw/*223.4*/(""");

  $('a.origin-branch, a.forked-branch').click(function()"""),format.raw/*225.57*/("""{"""),format.raw/*225.58*/("""
    """),format.raw/*226.5*/("""updateSelector($(this));

    location.href = '"""),_display_(/*228.23*/context/*228.30*/.path),format.raw/*228.35*/("""/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + '/' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('name')) +'/compare/' +
      $.trim($('i.octicon-check').parents('a.origin-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.origin-branch').data('branch')) + '...' +
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + ':' +
      $.trim($('i.octicon-check').parents('a.forked-branch').data('branch'));
  """),format.raw/*235.3*/("""}"""),format.raw/*235.4*/(""");

  """),_display_(if(context.loginAccount.isDefined && originRepository.branchList.contains(originId) && forkedRepository.branchList.contains(forkedId))/*237.138*/{_display_(Seq[Any](format.raw/*237.139*/("""
    """),format.raw/*238.5*/("""function checkConflict(from, to)"""),format.raw/*238.37*/("""{"""),format.raw/*238.38*/("""
      """),format.raw/*239.7*/("""$('.check-conflict').show();
      $.get('"""),_display_(/*240.15*/helpers/*240.22*/.url(forkedRepository)),format.raw/*240.44*/("""/compare/' + from + '...' + to + '/mergecheck',
        function(data)"""),format.raw/*241.23*/("""{"""),format.raw/*241.24*/(""" """),format.raw/*241.25*/("""$('.check-conflict').html(data); """),format.raw/*241.58*/("""}"""),format.raw/*241.59*/(""");
    """),format.raw/*242.5*/("""}"""),format.raw/*242.6*/("""

    """),format.raw/*244.5*/("""checkConflict(
      $.trim($('i.octicon-check').parents('a.origin-owner' ).data('owner')) + ":" +
      $.trim($('i.octicon-check').parents('a.origin-branch').data('branch')),
      $.trim($('i.octicon-check').parents('a.forked-owner' ).data('owner')) + ":" +
      $.trim($('i.octicon-check').parents('a.forked-branch').data('branch'))
    );
  """)))} else {null} ),format.raw/*250.4*/("""
"""),format.raw/*251.1*/("""}"""),format.raw/*251.2*/(""");
</script>
"""))
      }
    }
  }

  def render(title:String,commits:Seq[Seq[gitbucket.core.util.JGitUtil.CommitInfo]],diffs:Seq[gitbucket.core.util.JGitUtil.DiffInfo],members:List[(String, String, String)],comments:List[gitbucket.core.model.Comment],originId:String,forkedId:String,sourceId:String,commitId:String,content:String,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,originRepository:gitbucket.core.service.RepositoryService.RepositoryInfo,forkedRepository:gitbucket.core.service.RepositoryService.RepositoryInfo,hasOriginWritePermission:Boolean,collaborators:List[String],milestones:List[gitbucket.core.model.Milestone],priorities:List[gitbucket.core.model.Priority],defaultPriority:Option[gitbucket.core.model.Priority],labels:List[gitbucket.core.model.Label],customFields:List[gitbucket.core.model.CustomField],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(title,commits,diffs,members,comments,originId,forkedId,sourceId,commitId,content,repository,originRepository,forkedRepository,hasOriginWritePermission,collaborators,milestones,priorities,defaultPriority,labels,customFields)(context)

  def f:((String,Seq[Seq[gitbucket.core.util.JGitUtil.CommitInfo]],Seq[gitbucket.core.util.JGitUtil.DiffInfo],List[(String, String, String)],List[gitbucket.core.model.Comment],String,String,String,String,String,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.service.RepositoryService.RepositoryInfo,Boolean,List[String],List[gitbucket.core.model.Milestone],List[gitbucket.core.model.Priority],Option[gitbucket.core.model.Priority],List[gitbucket.core.model.Label],List[gitbucket.core.model.CustomField]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (title,commits,diffs,members,comments,originId,forkedId,sourceId,commitId,content,repository,originRepository,forkedRepository,hasOriginWritePermission,collaborators,milestones,priorities,defaultPriority,labels,customFields) => (context) => apply(title,commits,diffs,members,comments,originId,forkedId,sourceId,commitId,content,repository,originRepository,forkedRepository,hasOriginWritePermission,collaborators,milestones,priorities,defaultPriority,labels,customFields)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/pulls/compare.scala.html
                  HASH: 0a067e45e468e711cf6f971d89699ba15f3ae95f
                  MATRIX: 1184->1|2185->930|2249->966|2267->975|2369->1067|2409->1068|2439->1072|2457->1081|2502->1117|2541->1118|2573->1123|2666->1189|2684->1198|2833->1337|2874->1339|2913->1351|2929->1358|2942->1362|3019->1401|3060->1414|3137->1464|3163->1469|3204->1483|3229->1487|3281->1511|3316->1524|3347->1527|3366->1536|3448->1596|3478->1598|3505->1603|3535->1605|3561->1609|3613->1630|3654->1640|3691->1650|3709->1659|3807->1747|3848->1749|3938->1812|3977->1813|4018->1826|4097->1878|4113->1885|4158->1909|4188->1912|4207->1921|4262->1954|4292->1956|4322->1964|4387->1985|4426->1997|4451->2013|4475->2028|4525->2040|4566->2053|4645->2105|4661->2112|4704->2134|4734->2137|4753->2146|4822->2193|4852->2195|4880->2201|4932->2222|4973->2232|5009->2241|5049->2254|5067->2263|5216->2402|5257->2404|5296->2416|5312->2423|5325->2427|5402->2466|5443->2479|5520->2529|5546->2534|5587->2548|5612->2552|5664->2576|5699->2589|5730->2592|5749->2601|5831->2661|5861->2663|5888->2668|5918->2670|5944->2674|5996->2695|6037->2705|6074->2715|6092->2724|6193->2815|6234->2817|6324->2880|6363->2881|6404->2894|6483->2946|6499->2953|6544->2977|6574->2980|6593->2989|6648->3022|6678->3024|6708->3032|6773->3053|6812->3065|6837->3081|6861->3096|6911->3108|6952->3121|7031->3173|7047->3180|7090->3202|7120->3205|7139->3214|7208->3261|7238->3263|7266->3269|7318->3290|7359->3300|7393->3307|7535->3421|7575->3422|7611->3431|7711->3504|7727->3511|7787->3550|7868->3588|7900->3593|8094->3759|8134->3760|8168->3767|8290->3862|8306->3869|8332->3874|8361->3876|8386->3892|8413->3898|8442->3900|8467->3916|8493->3921|8725->4126|8751->4131|8866->4219|8884->4228|9359->4682|9402->4697|9521->4789|9546->4805|9573->4811|9669->4880|9698->4888|9797->4960|9822->4976|9849->4982|9954->5060|9979->5076|10005->5081|10102->5151|10131->5159|10227->5228|10256->5236|10350->5303|10379->5311|10693->5597|10710->5604|10737->5609|10767->5611|10793->5627|10821->5633|10851->5635|10877->5651|10904->5656|11521->6245|11540->6254|12126->6818|12168->6831|12270->6889|12323->6914|12363->6915|12398->6922|12607->7103|12633->7119|12661->7125|12691->7127|12721->7135|12783->7169|12810->7185|12839->7191|12870->7193|12901->7201|12966->7248|13006->7249|13041->7256|13321->7508|13356->7533|13407->7545|13453->7562|13490->7571|13507->7578|13534->7583|13573->7594|13590->7601|13643->7632|13691->7648|13733->7661|13898->7798|13913->7803|13940->7808|13979->7819|13996->7826|14045->7853|14075->7854|14255->8006|14343->8084|14396->8097|14442->8114|14479->8123|14497->8131|14524->8136|14570->8154|14587->8161|14642->8194|14690->8210|14732->8223|14897->8360|14970->8423|15026->8440|15072->8457|15109->8466|15131->8478|15158->8483|15197->8494|15214->8501|15278->8542|15326->8558|15368->8571|15498->8673|15515->8680|15529->8684|15577->8693|15617->8704|15734->8793|15751->8800|15799->8826|15839->8837|15924->8894|15937->8897|15951->8901|16002->8913|16044->8926|16192->9046|16209->9053|16254->9076|16300->9094|16317->9101|16409->9171|16453->9186|16530->9235|16546->9241|16581->9254|16706->9351|16723->9358|16761->9374|16798->9383|16814->9389|16839->9392|16888->9413|16904->9419|16946->9438|17032->9492|17072->9503|17122->9521|17157->9528|17198->9542|17217->9551|17339->9650|17374->9658|17393->9667|17485->9737|17522->9743|17557->9747|17590->9749|17619->9750|17670->9772|17700->9773|17731->9776|17796->9812|17826->9813|17859->9818|17977->9908|18006->9909|18075->9949|18105->9950|18136->9953|18254->10043|18283->10044|18314->10047|18343->10048|18389->10065|18419->10066|18450->10069|18505->10095|18535->10096|18568->10101|18767->10272|18796->10273|18828->10277|18893->10313|18923->10314|18956->10319|19032->10367|19049->10374|19076->10379|19626->10901|19655->10902|19726->10944|19756->10945|19789->10950|19865->10998|19882->11005|19909->11010|20459->11532|20488->11533|20577->11593|20607->11594|20640->11599|20716->11647|20733->11654|20760->11659|21302->12173|21331->12174|21501->12315|21542->12316|21575->12321|21636->12353|21666->12354|21701->12361|21772->12404|21789->12411|21833->12433|21932->12503|21962->12504|21992->12505|22054->12538|22084->12539|22119->12546|22148->12547|22182->12553|22574->12901|22603->12902|22632->12903
                  LINES: 14->1|36->21|39->22|39->22|39->22|39->22|40->23|40->23|40->23|40->23|41->24|43->26|43->26|43->26|43->26|44->27|44->27|44->27|44->27|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|45->28|46->29|47->30|48->31|48->31|48->31|48->31|49->32|49->32|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|51->34|52->35|52->35|52->35|52->35|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|54->37|55->38|56->39|57->40|57->40|57->40|57->40|58->41|58->41|58->41|58->41|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|59->42|60->43|61->44|62->45|62->45|62->45|62->45|63->46|63->46|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|64->47|65->48|66->49|66->49|66->49|66->49|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|67->50|68->51|69->52|70->53|71->54|71->54|72->55|73->56|73->56|73->56|75->58|76->59|77->60|77->60|78->61|79->62|79->62|79->62|79->62|79->62|79->62|79->62|79->62|79->62|83->66|83->66|84->67|84->67|94->77|95->78|96->79|96->79|96->79|97->80|97->80|98->81|98->81|98->81|99->82|99->82|99->82|100->83|100->83|101->84|101->84|102->85|102->85|105->88|105->88|105->88|105->88|105->88|105->88|105->88|105->88|105->88|117->100|117->100|130->113|131->114|135->118|136->119|136->119|137->120|139->122|139->122|139->122|139->122|139->122|139->122|139->122|139->122|139->122|139->122|141->124|141->124|142->125|147->130|147->130|147->130|148->131|148->131|148->131|148->131|148->131|148->131|148->131|149->132|150->133|153->136|153->136|153->136|153->136|153->136|153->136|153->136|157->140|157->140|157->140|158->141|158->141|158->141|158->141|158->141|158->141|158->141|159->142|160->143|163->146|163->146|163->146|164->147|164->147|164->147|164->147|164->147|164->147|164->147|165->148|166->149|171->154|171->154|171->154|171->154|172->155|173->156|173->156|173->156|174->157|176->159|176->159|176->159|176->159|177->160|180->163|180->163|180->163|181->164|181->164|181->164|182->165|183->166|183->166|183->166|185->168|185->168|185->168|185->168|185->168|185->168|185->168|185->168|185->168|188->171|189->172|190->173|191->174|192->175|192->175|192->175|193->176|193->176|193->176|194->177|195->178|196->179|197->180|199->182|199->182|200->183|200->183|200->183|201->184|203->186|203->186|204->187|204->187|205->188|207->190|207->190|208->191|208->191|211->194|211->194|212->195|212->195|212->195|213->196|216->199|216->199|218->201|218->201|218->201|219->202|221->204|221->204|221->204|228->211|228->211|230->213|230->213|231->214|233->216|233->216|233->216|240->223|240->223|242->225|242->225|243->226|245->228|245->228|245->228|252->235|252->235|254->237|254->237|255->238|255->238|255->238|256->239|257->240|257->240|257->240|258->241|258->241|258->241|258->241|258->241|259->242|259->242|261->244|267->250|268->251|268->251
                  -- GENERATED --
              */
          